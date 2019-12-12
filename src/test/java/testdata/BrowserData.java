package testdata;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class BrowserData {
    @DataProvider(name="BrowserData")

    public static Object[][] getBrowsersList(ITestContext context) {
        String parameter = context.getCurrentXmlTest().getLocalParameters().get("browser");
        String[] names = parameter.split(",");
        Object[][] browserValues = new Object[names.length][1];
        int index = 0;
        for (Object[] each : browserValues) {
            each[0] = names[index++].trim();
        }
        return browserValues;
    }
}
