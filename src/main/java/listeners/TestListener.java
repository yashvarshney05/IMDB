package listeners;

import org.apache.commons.exec.util.StringUtils;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.CommonUtils;


public class TestListener extends RunListener
{
    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void testRunFinished(Result result) throws Exception
    {
        super.testRunFinished(result);
        logger.info("Cleaning after all test runs!");
        String retryFailedTests = CommonUtils.getEnvProperty("junit.retry.tests");

    }

    @Override
    public void testFailure(Failure failure) throws Exception
    {
        super.testFailure(failure);
        String[] splitArr = StringUtils.split(failure.getTestHeader(), "(");

    }
}
