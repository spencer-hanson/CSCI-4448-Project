<head>
    <script type="text/javascript">
        function addTextArea(){
            var div = document.getElementById('div_quotes[]');
            div.innerHTML += "<input name='new_quote[]' value='Enter Answer' />";
           //div.innerHTML += "\n<br />";
        }
        function addTextArea1(){
            var div = document.getElementById('div_quotes1');
            div.innerHTML += "<div class=\"container\"><form><fieldset><legend><form><input size='40' type='text' value='Enter Question Title Here'></form></div><div>Answers:<br><input size='15' type='text' name='Answer' value='Enter Answer'><input size='15' type='text' name='Answer' value='Enter Answer'><div id='div_quotes[]'></div><input type='button' value='Add Answer'  onClick='addTextArea();'></div></legend></fieldset></form></div>";
           //div.innerHTML += "\n<br />";
        }
    </script>
</head>
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

<div >
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
                <input size="15" type="text" name="Answer1" value="Enter Answer">
                <div id="div_quotes[]"></div>
                <input type="button" value="Add Answer"  onClick="addTextArea();">
            </div>

        </fieldset>
    </form>
</div>

<!--div for adding more questions -->
<div id="div_quotes1"></div>

<div class="container">
    <form>
        <fieldset>
            <input type="button" value="Add Question" onClick="addTextArea1();">
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


