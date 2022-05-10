package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {

    public HomePage (){
        PageFactory.initElements(driver,this);
    }
/*1.HomePage -
WOMEN, DRESSES, T-SHIRTS and Sign in Links and logo locatores
and create appropriate methods for it.*/

    @FindBy(xpath="//a[@title='Women']")
    WebElement women;

    @FindBy(xpath = "//body/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]")
    WebElement dresses;

    @FindBy(xpath = "//li[@class='sfHover']//a[@title='T-shirts'][normalize-space()='T-shirts']")
    WebElement tshirts;

    @FindBy(xpath = "//a[normalize-space()='Sign in']")
    WebElement signInLink;

    @FindBy(xpath = "//img[@alt='My Store']")
    WebElement logo;

    public void clickOnWomen(){
        clickOnElement(women);
    }
    public void clickdresses(){
        clickOnElement(dresses);
    }
    public void clickonTshirt(){
        clickOnElement(tshirts);
    }
    public void clickOnSignInLink(){
        clickOnElement(signInLink);
    }
    public void verifyLogo(){
        Reporter.log("verify the logo "+ logo.toString());
        verifyThatElementIsDisplayed(logo);
    }
}

