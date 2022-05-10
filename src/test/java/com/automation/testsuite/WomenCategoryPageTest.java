package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.*;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;



    public class WomenCategoryPageTest extends TestBase {

        WomenCategoryPage womenCategoryPage;
        ProductPage productPage;

        @BeforeMethod(alwaysRun = true)
        public void inIt() {
            womenCategoryPage = new WomenCategoryPage();
            productPage = new ProductPage();
        }
/*3. WomenCategoryPageTest
Inside WomenCategoryPageTest class create following testmethods
1. verifyUserShouldNavigateToWomenCategoryPageSuccessfully()
Click on WOMEN tab
Verify "WOMWN" text*/

        @Test(groups = {"sanity","regression"},priority = 0)
        public void  verifyUserShouldNavigateToWomenCategoryPageSuccessfully(){
            //Click on WOMEN tab
            womenCategoryPage.clickOnWomen();
            //Verify "WOMWN" text
            String expected = "Women";
            String actual = womenCategoryPage.verifyWomen();
            Assert.assertEquals(actual,expected,"not displayed");
        }
/*2. verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty, String
size, String colour)
Click on WOMEN tab
Click on the product "product"
Change quantity "qty"
Select size "size"
Select colour "colour"
Click on Add To Cart Button
Popup will desplay
Vetify the message "Product successfully added to your shopping cart"
Click on X button and close the popup*/

        @Test(priority = 0,dataProvider = "product",dataProviderClass = TestData.class)
        public void verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty, String
                size, String colour) throws InterruptedException {
            //Click on WOMEN tab
            womenCategoryPage.clickOnWomen();
            //Click on the product "product"
            productPage.selProduct(product);
            //Select colour "colour"
            Thread.sleep(2000);
            productPage.selColour(colour);
            //Click on Add To Cart Button
            productPage.enterQtyAdd(qty);
            //Select size "size"
            productPage.selectSize(size);
            //Click on Add To Cart Button
            productPage.clickAddCart();
            //Vetify the message "Product successfully added to your shopping cart"
            productPage.getAddMes("Product successfully added to your shopping cart");
            //Click on X button and close
            Thread.sleep(2000);
            productPage.setCloseBtn();
        }
    }


