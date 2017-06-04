package com.yftech.uiautomator2demo.sample;

import android.support.test.uiautomator.UiDevice;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * Created by 薛东磊 on 2017/6/2.
 */

public class ReportTest extends TestWatcher {
    UiDevice device;

    public ReportTest(UiDevice device){
        this.device = device;
    }

    @Override
    protected void succeeded(Description description) {
        super.succeeded(description);
        ExtentReports extent = createReport();
        ExtentTest test = extent.startTest(description.getDisplayName(), "-");

        // step log
        test.log(LogStatus.PASS, "-");
        flushReports(extent, test);
    }

    public void success(){
        ExtentReports extent = createReport();
        ExtentTest test = extent.startTest("test1", "Test failed, click here for further details");

        // step log
        test.log(LogStatus.FAIL, "Failure trace Selenium: ");
        flushReports(extent, test);
    }


    private ExtentReports createReport() {
        ExtentReports extent = new ExtentReports("E:/test.html", false);
        extent.config().reportName("My first extentReport report");
        extent.config().reportHeadline("See my awesome passed tests!");
        return extent;
    }

    private void flushReports(ExtentReports extent, ExtentTest test){
        // ending test
        extent.endTest(test);
        // writing everything to document
        extent.flush();
    }
}
