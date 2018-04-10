<div style=" text-align: right;">
    Hello, Admin!
    <form>
        <input type="button" value="Log Out">
    </form>
</div>
<img src="img/logo.png" style="width:100px;height:160px; " class="center">

<!--div for entering survey title -->
<div class="container">
    <form>
        <input size="64" type="text" name="SurveyTitle" value="Enter Survey Title Here">
    </form>
</div>

<div class="container">
    <form>
        <fieldset>
            <legend>
                <!--div for entering question title -->
                <div>
                    <form>
                        <input size="40" type="text" name="Question" value="Enter Question Title Here">
                    </form>
                </div>

            </legend>

            <!--div for adding answers -->
            <div>
                Answers:<br>
                <input size="15" type="text" name="Answer" value="Enter Answer">
                <input size="15" type="text" name="Answer" value="Enter Answer">
                <input type="button" value="Add Answer">
            </div>

        </fieldset>
    </form>
</div>

<!--div for adding more questions -->
<div class="container">
    <form>
        <fieldset>
            <input type="button" value="Add Question">
        </fieldset>
    </form>
</div>

<!--div for save and cancel button -->
<div class="container">
    <form>
        <input type="submit" value="Save">
        <input type="button" value="Cancel">
    </form>
</div>

<style>
    .container {
        text-align: center;
        margin-top: 3rem;

        font-family: sans-serif;
    }

    .center {
        display: block;
        margin-left: auto;
        margin-right: auto;
        width: 50%;
    }
</style>


