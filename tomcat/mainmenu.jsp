<div class="container">
    <form>
        <fieldset>
        <legend>
            SurveyTree
        </legend>
        <h1>Main Menu</h1>
        </fieldset>
    </form>
</div>


<div class="row">
  <div class="column"></div>
  <div class="column"></div>
</div>

 <div class="container">
 
    <form>
            <div>
                 <img src="img/plus.png" style="width:100px;height:100px; " class="center">
                <form action="takesurvery.jsp">
                    <input type="submit" value="New Survey">
                </form>
            </div>
            <div>
                 <img src="img/survey.png" style="width:100px;height:100px; " class="center">
                 <!-- Need to make this redirect to view old surveys -->
                <form action="takesurvery.jsp">
                    <input type="submit" value="View Your Surveys">
                </form>
            </div>
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