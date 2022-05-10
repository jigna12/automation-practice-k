package com.automation.testsuite;


import com.automation.pages.HomePage;
import com.automation.pages.SigninPage1;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;



    public class SignInPageTest extends TestBase {
        HomePage homePage;
        SigninPage1 signinPage1;

        @BeforeMethod(alwaysRun = true)
        public void inIt() {
            homePage = new HomePage();
            signinPage1 = new SigninPage1();
        }
 /*1.userShouldNavigateToSignInPageSuccessFully().
Click on Sign In link
verify that "AUTHENTICATION" message is displaye*/

        @Test(groups = {"sanity","regression"} ,priority = 0)
        public void userShouldNavigateToSignInPageSuccessFully(){
            //Click on Sign In link
            homePage.clickOnSignInLink();
            //verify that "AUTHENTICATION" message is displayed
            String expectedResult = "AUTHENTICATION";
            String actualResult = signinPage1.verifyAuthentication();
            Assert.assertEquals(actualResult, expectedResult, "Result not found");
        }
 /*2. verifyTheErrorMessageWithInValidCredentials(String username, String password,
String message).
Click on sign in link
Enter "username"
Enter "password"
Click on Sign in Button
Verify the Error message "message"*/

        @Test(groups = {"sanity","smoke","regression"},priority = 0,dataProvider = "ErrorMessageWithInValidCredentials",dataProviderClass = TestData.class)
        public void verifyTheErrorMessageWithInValidCredentials(String username,String password,String errorMsg){
           //Click on sign in link
            homePage.clickOnSignInLink();
            //Enter "username"
            signinPage1.enterEmail(username);
            //Enter "password
            signinPage1.enterpassword(password);
            //Click on Sign in Button
            signinPage1.clickonSignInBtn();
            //Verify the Error message "message"
            String expectedResult =errorMsg ;
            String actualResult = signinPage1.verifyErrorMessage(errorMsg);
            Assert.assertEquals(actualResult, expectedResult, "Result not found");
        }
/*3. verifyThatUserShouldLogInSuccessFullyWithValidCredentials().
Click on sign link
Enter EmailId
Enter Password
Click on Sign Button
Verify that Sign out link is displayed*/

        @Test(groups = {"smoke","regression"},priority = 1)
        public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
            //Click on sign link
            homePage.clickOnSignInLink();
            //Enter EmailId
            signinPage1.enterEmail("prime256@gmail.com");
            //Enter Password
            signinPage1.enterpassword("Prime456");
            //Click on Sign Button
            signinPage1.clickonSignInBtn();
            //Verify that Sign out link is displayed
            String expectedResult ="Sign out";
            String actualResult = signinPage1.verifySignOutLink();
            Assert.assertEquals(actualResult, expectedResult, "Result not found");
        }
/*4. verifyThatUserShouldLogOutSuccessFully()
Click on sign link
Enter EmailId
Enter Password
Click on Sign Button
Click on Sign out Link
Verify that Sign In Link displayed*/

        @Test(groups = {"smoke","regression"},priority = 2)
        public void VerifyThatUserShouldLogOutSuccessFully(){
            SoftAssert softAssert = new SoftAssert();
            //Click on sign lin
            homePage.clickOnSignInLink();
            //Enter EmailId
            signinPage1.enterEmail("prime256@gmail.com");
            //Enter Password
            signinPage1.enterpassword("Prime456");
            //Click on Sign Button
            signinPage1. clickonSignInBtn();
            //Click on Sign out Link
            signinPage1.clickOnSignOutLink();
            //Verify that Sign In Link displayed
            String expectedResult ="Sign in";
            String actualResult = signinPage1.verifySigninButton();
            Assert.assertEquals(actualResult, expectedResult, "Result not found");
            softAssert.assertAll();
        }
    }


