package com.orangehrm.utilities;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangehrm.testData.Data;

public class Reporter {


	private static ExtentReports reports;
	private static ExtentTest reportNode;

	public static void initilizeReporter(String testName) {
		UtilityMethods.createFolder(Data.REPORT_FOLDER_PATH);

		String resultFilePath=Data.REPORT_FOLDER_PATH+"\\"+testName+"_"+UtilityMethods.getTimeStamp()+".html";

		//	ExtentSparkReporter esp=new ExtentSparkReporter(System.getProperty("user.dir")+"Reports");
		ExtentSparkReporter esp=new ExtentSparkReporter(resultFilePath);
		esp.config().setTheme(Theme.DARK);
		esp.config().setReportName("Exicution result for test"+testName);
		esp.config().setDocumentTitle("Testing");
		esp.config().setTimelineEnabled(true);
		esp.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");


		reports=new ExtentReports();
		reports.attachReporter(esp);

	}

	public static void createNodeForTestcase(String testcase) {
		reportNode=reports.createTest(testcase);
	}

	public static void writeReport(Status status,String message) {
		switch (status) {
		case PASS:
			reportNode.log(Status.PASS, message);
			break;

		case FAIL:
			reportNode.log(Status.FAIL, message);
			break;

		case WARNING:
			reportNode.log(Status.WARNING, message);
			break;

		case INFO:
			reportNode.log(Status.INFO, message);
			break;

		default:
			reportNode.log(Status.SKIP, message);
			break;
		}
	}

	public static void writeReport(Status status,String message,WebDriver driver,String imagename) {
		switch (status) {
		case PASS:
			reportNode.log(Status.PASS, message,MediaEntityBuilder
					.createScreenCaptureFromBase64String(UtilityMethods.captureImage(imagename, driver)).build());
			break;

		case FAIL:
			reportNode.log(Status.FAIL, message,MediaEntityBuilder
					.createScreenCaptureFromBase64String(UtilityMethods.captureImage(imagename, driver)).build());
			break;

		case WARNING:
			reportNode.log(Status.WARNING, message,MediaEntityBuilder
					.createScreenCaptureFromBase64String(UtilityMethods.captureImage(imagename, driver)).build());
			break;

		case INFO:
			reportNode.log(Status.INFO, message,MediaEntityBuilder
					.createScreenCaptureFromBase64String(UtilityMethods.captureImage(imagename, driver)).build());
			break;

		default:
			reportNode.log(Status.SKIP, message,MediaEntityBuilder
					.createScreenCaptureFromBase64String(UtilityMethods.captureImage(imagename, driver)).build());
			break;
		}
	}
	public static void finalizeReport() {
		reports.flush();
	}

}
