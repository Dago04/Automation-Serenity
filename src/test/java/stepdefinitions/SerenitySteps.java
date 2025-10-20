package stepdefinitions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class SerenitySteps extends UIInteractions {

    HomePage homePage;
    LoginPage loginPage;

    @Step("Navigate to the home page")
    public void navigateToHomePage() {
        getDriver().navigate().to("https://www.walmart.com.gt/");
    }

    @Step("Select {0} and {1} for delivery location")
    public void selectDeliveryLocation(String option1, String option2) {
        homePage.selectDeliveryLocation(option1, option2);
    }

    @Step("User Login with email {0} and password {1}")
    public void userLogin(String email, String password){
        loginPage.userLogin(email, password);
    }

    @Step("Sign off from user account")
    public void signOff(){
        homePage.signOff();
    }

}
