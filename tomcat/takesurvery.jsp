<!--div for title of survey -->
<div class="container">
    <h2>Survey Title</h2>
</div>

<h4 class="container">Attributes:</h4>

<!--div: enumerate each question with a random answer -->
<div class="container">
    <ul>
        <li>Question 1: Random Answer</li>
    </ul>
</div>

<!--div for Yes No responses -->
<div class="Container">
    <form>
        <input type="radio" name="response" value="Yes" checked> Yes<br>
        <input type="radio" name="response" value="No"> No<br>

    </form>
</div>

<!--div for submit and continue button -->
<div class="container">
    <form>
        <input type="submit" value="Continue">

    </form>
</div>

<style>
    .container {
        text-align: center;
        margin-top: 2rem;

        font-family: sans-serif;
    }
</style>