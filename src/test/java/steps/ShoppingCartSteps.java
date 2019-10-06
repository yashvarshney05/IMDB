package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.ShoppingCartPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartSteps extends ScenarioSteps {

      ShoppingCartPage shoppingCartPageObj;

    @Step("Verify that Shopping cart is opened")
    public void verify_Shopping_Cart_IsOpened()
    {
        assertThat(shoppingCartPageObj.isCartContainerDisplayed()).overridingErrorMessage("shopping cart is not displayed").isTrue();
    }

    @Step("Verify that all the mendatory details for user checkout is filled")
    public void verify_user_details()
    {
        shoppingCartPageObj.checkValidationBeforeOrderPlace();
    }

    @Step("User click on checkout button to proceed")
    public void click_on_checkout_button()
    {
        shoppingCartPageObj.clickOnCheckoutButton();
    }
}
