package pages;

import com.google.j2objc.annotations.Weak;
import core.BasePageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ImdbHomePage extends BasePageObject {

    @FindBy(xpath = "//span[@id='home_img_holder']/a[@title='Home']")
    private WebElementFacade homePageLbl;

    @FindBy(xpath = "//select[@name='s']")
    private WebElementFacade dropDownOnHomePage;


    public boolean verifyImdbIconIsDisplayed()
    {
        homePageLbl.waitUntilVisible().expect("Imdb icon is not present").isVisible();
        return homePageLbl.isDisplayed();
    }

    public void userClickOnAdvancedSearch()
    {
        selectFromDrownDown(dropDownOnHomePage);
    }


}


