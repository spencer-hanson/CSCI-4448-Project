from sklearn import tree
import graphviz
import numpy as np
import scipy
import csv

# list of possible answers to the main question
responses = {
    "yes" : 5,
    "no" : 6
}

reverse_responses = {}
for k, v in responses.items():
    reverse_responses[v] = k

# list of questions that will be asked in decision making process
questions = [
    "Do you need you car at the time of loan?",
    "Duration of the friendship?",
    "Times friend has been ticketed?",  # answers: 0 times, 1-2 times(some), or 3+ times
    "Have you driven with said friend before?",
    "Does your friend text and drive?",
    "Will your friend pay for gas?"
]

# parse the data from the csv into a list of lists, each list containing the results of one example

def parse_date(filename):
    with open(filename) as f:
        rows = csv.reader(f)
        results = list(rows)
    return results


# convert the data into numbers so that we can use the sklearn library to train the data

#TODO Change conversions from AI problem set to conversions from Taylor's stuff

def convert_data(data):
    response_data = []
    question_data = []
    for feature in data:
        raw_features = []
        for item in feature:
            item = item.strip()
            if item == "yes" or item == "no":
                if item == "yes":
                    raw_features.append(0)  # 0 for yes
                else:
                    raw_features.append(1)  # 1 for no
            elif item == "short" or item == "medium" or item == "long":
                if item == "short":
                    raw_features.append(0)  # 0 for short
                elif item == "medium":
                    raw_features.append(1)  # 1 for medium
                elif item == "long":
                    raw_features.append(2)  # 2 for long
            elif item == "0" or item == "some" or item == "3":
                if item == "0":
                    raw_features.append(0)  # 0 for 0 tickets
                elif item == "some":
                    raw_features.append(1)  # 1 for 1 or 2 tickets
                elif item == "3":
                    raw_features.append(2)  # 2 for 3+ tickets
            elif item == "ans:yes" or item == "ans:no":  # answer
                response_data.append(responses[item.split(':')[1]])
        question_data.append(raw_features)
    return {"x": question_data, "y": response_data}  # x for questiondate y for response data (answers)


if __name__ == "__main__":

    data = "fixed_examples.csv"
    all_data = parse_date(data)  # not converted data, just data parsed from file

    converted_data = convert_data(all_data) # convert the data parsed into just numbers

    perm = np.random.permutation(25)  # permutation for shuffling data
    converted_data['x'] = list(np.array(converted_data['x'])[perm])
    converted_data['y'] = list(np.array(converted_data['y'])[perm])

    trainx = converted_data['x'][:20]  # grab 20 example sets that have been converted
    trainy = converted_data['y'][:20]  # grab the response data that's been converted and corresponds to the examples

    testx = converted_data['x'][20:]  # grab the remaining for testing
    testy = converted_data['x'][20:]

    clf = tree.DecisionTreeClassifier()  # use the library function to create the decision tree
    clf = clf.fit(trainx, trainy)  # run our training data

    predictions = clf.predict(testx)  # test our decision tree trained by the training examples on the test set
    print(predictions)


# use graphiz to create a graph representing the decision tree
 #   dot_data = tree.export_graphviz(clf, out_file=None,
  #                                  feature_names=questions,
   #                                class_names=list(responses.keys()),
    #                                filled=True, rounded=True,
    #                                special_characters=True)
    #graph = graphviz.Source(dot_data)
    #graph.render("asdff")


