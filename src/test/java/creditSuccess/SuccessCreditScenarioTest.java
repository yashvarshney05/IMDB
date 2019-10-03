package creditSuccess;

import common.BaseTestCase;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import steps.SuccessCreditScenarioSteps;
import utils.CommonUtils;

public class SuccessCreditScenarioTest extends BaseTestCase {

    @Steps
    SuccessCreditScenarioSteps successCreditScenarioStepsObj;

    @Test
    public void verify_homepage() {
        String home_page_url = CommonUtils.getBaseUrl();
        successCreditScenarioStepsObj.open_home_page(home_page_url);
        successCreditScenarioStepsObj.user_on_click_buy_now();
    }
}
