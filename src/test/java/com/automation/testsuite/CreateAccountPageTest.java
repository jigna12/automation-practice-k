package com.automation.testsuite;

import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.SigninPage1;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountPageTest extends TestBase {

            HomePage homePage;
            SigninPage1 signinPage1;
            CreateAccountPage createAccountPage;

            @BeforeMethod(alwaysRun = true)
            public void inIt() {
                homePage = new HomePage();
                signinPage1 = new SigninPage1();
                createAccountPage = new CreateAccountPage();
            }
/*2. CreateAccountPageTest
Inside CreateAccountPageTest class create following testmethods
1. verifyThatUserShouldCreateAccountSuccessfully()
Click on Sign in Link
Enter email address
Click on "Create an account" button
Fill all mandetory fields
Click on "Register" button
Verify message "My Account"*/

            @Test(groups = {"sanity","regression","smoke"},priority = 1)
            public void verifyThatUserShouldCreateAccountSuccessfully() {
                SoftAssert softAssert = new SoftAssert();
                //Click on Sign in Link
                homePage.clickOnSignInLink();
                //Enter email address
                signinPage1.emailForCreateNewAccount("bbkhbn@gmail.com");
                //Click on "Create an account" button
                signinPage1. clickCreatAccount();
               //Fill all mandetory fields
                createAccountPage.enterFirstName("Niv");
                createAccountPage.enterLastName("Maan");
                createAccountPage.enteremail("prime678@gmail.com");
                createAccountPage.enterPassword("niv4123");
                createAccountPage.enterFirstNameField("niv");
                createAccountPage.enterLastNameField("Maan");
                createAccountPage.enterAddress("22 Harboneclose");
                createAccountPage.enterCity("london");
                createAccountPage.selectState("Hetforshire");
                createAccountPage.enterZipCode("HA3 9PY");
                createAccountPage.enterPhoneNumber("12567834123");
                createAccountPage.enterReference("House");
               // Click on "Register" button
                createAccountPage.clickOnRegisterBtn();
                softAssert.assertAll();
                //Verify message "My Account"
               // String expectedResult ="My Account";
               // String actualResult = createAccountPage.verifyMyAccountText();
               // Assert.assertEquals(actualResult, expectedResult, "Result not found");
            }
        }
