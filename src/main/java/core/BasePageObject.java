package core;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePageObject extends PageObject {

    private static final Logger logger = LoggerFactory.getLogger(BasePageObject.class);

    public  void openUrl(String url)
    {
        try {
            getDriver().get(url);
        }catch(Exception e)
        {
           logger.debug("Not able to launch driver ");
        }

    }

    public void switchToFrame(WebElementFacade webElementFacade)
    {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(0);
       // getDriver().switchTo().frame(webElementFacade);
    }
}
