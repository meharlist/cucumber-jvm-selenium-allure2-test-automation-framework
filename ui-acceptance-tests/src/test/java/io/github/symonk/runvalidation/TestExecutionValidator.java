package io.github.symonk.runvalidation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@Slf4j
@ContextConfiguration(classes = TestExecutionSpringConfig.class)
public class TestExecutionValidator extends AbstractTestNGSpringContextTests {

    @Autowired
    private TestExecutionListener testExecutionListener;

    @Test
    public void validateRunConditionsHere() {
        log.info("Test run instantiated...validating conditions");
        testExecutionListener.checkEnvironmentIsOnline();
        testExecutionListener.pushReportEnvironmentDataToDirectory();
    }

}
