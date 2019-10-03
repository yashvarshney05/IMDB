package listeners;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.CommonUtils;

import java.io.IOException;
import java.util.List;

public class TestRunner extends SerenityRunner
{
    private static final Logger logger = LoggerFactory.getLogger(TestRunner.class);

    public TestRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

}
