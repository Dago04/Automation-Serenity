package stepdefinitions.serenitysteps;

import net.serenitybdd.annotations.Step;
import pageobjects.HomePage;

public class HomeSteps {
    HomePage homePage;

    @Step("Sign off from user account")
    public void signOff(){
        homePage.signOff();
    }
}
