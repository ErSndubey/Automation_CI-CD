package Infobays.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryFailedTest implements IRetryAnalyzer {
    int count = 0;
    int maxTry = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if (count < maxTry) {
            count++;
            //as long as it returns true test will continue re-running
            return true;

        }
        return false;
    }
}
