from sklearn import tree
import graphviz
import numpy as np
import scipy
import csv
import ast
import math

# TODO: Make questions read in from java program

# list of questions that will be asked in decision making process

# parse the data from the csv into a list of lists, each list containing the results of one example

responses = {
    "yes" : 1,
    "no" : 0
}


def parse_questions(filename):
    questions = []
    with open(filename, 'r') as f:
        for line in f.readlines():
            questions.append(line.strip())
    return questions


def parse(filename):
    with open(filename, 'r') as f:
        mylist = ast.literal_eval(f.read())
    return mylist


def convert(data):
    response_data = []
    question_data = []
    #  loop that reads from list of data (length n) and puts first n-1 entries into question data and last entrie
    #  into question data
    for feature in data:
        raw_data = []
        count = 0
        while count < len(feature)-1:
            raw_data.append(feature[count])
            count += 1
        response_data.append(feature[len(feature)-1])
        question_data.append(raw_data)

    return {"x": question_data, "y": response_data}  # x for question data y for response data (answers)


if __name__ == "__main__":
    newparse = parse("survey_data.txt")
    new_qs = parse_questions("question_data.txt")
    num_items = math.floor(len(newparse)*.75)  # take 75% of entries for training and 25% for testing
    converted_new = convert(newparse)

    perm = np.random.permutation(len(newparse))  # permutation for shuffling data
    converted_new['x'] = list(np.array(converted_new['x'])[perm])
    converted_new['y'] = list(np.array(converted_new['y'])[perm])

    trainx = converted_new['x'][:num_items]  # grab 20 example sets that have been converted
    trainy = converted_new['y'][:num_items]  # grab the response data that's been converted and corresponds to the examples

    testx = converted_new['x'][num_items:]  # grab the remaining for testing
    testy = converted_new['x'][num_items:]

    clf = tree.DecisionTreeClassifier()  # use the library function to create the decision tree
    clf = clf.fit(trainx, trainy)  # run our training data

    predictions = clf.predict(testx)  # test our decision tree trained by the training examples on the test set
    print(predictions)


# use graphviz to create a graph representing the decision tree
 #   dot_data = tree.export_graphviz(clf, out_file=None,
  #                                  feature_names=questions,
   #                                class_names=list(responses.keys()),
    #                                filled=True, rounded=True,
    #                                special_characters=True)
    #graph = graphviz.Source(dot_data)
    #graph.render("asdff")


