import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ListenerClass extends TestListenerAdapter {

    @Override
    public void onTestStart(ITestResult tr) {
        log(tr.getName() + " Started....");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        log("Test " + tr.getName() + " PASSED");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        log("Test " + tr.getName() + " FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        log("Test " + tr.getName() + " SKIPPED");
    }

    private void log(String methodName) {
        System.out.println("-----------");
        System.out.println(methodName);
        System.out.println("-----------");
    }

    private void log(IClass testClass) {
        System.out.println("-----------");
        System.out.println(testClass);
        System.out.println("-----------");
    }
}