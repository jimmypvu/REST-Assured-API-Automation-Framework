package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.Header;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExtentReportManager {

    private static ExtentReports report;

    public static ExtentReports createExtentReport(String reportName, String docTitle){
//        String filename = getTimestampedReportFilename();
        String filename = "API Test Report";
        String reportPath = "./reports/" + filename;

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setDocumentTitle(docTitle);
        spark.config().setReportName(reportName);
        spark.config().setTheme(Theme.DARK);
        spark.config().setEncoding("UTF-8");

        report = new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("Project", "instantwebtools.net");
        report.setSystemInfo("Reporter", "jimmy");

        return report;
    }

    public static String getTimestampedReportFilename(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh_mm_ss_a");
        LocalDateTime time = LocalDateTime.now();
        String formattedTime = dtf.format(time);

        String reportFilename = "API Test Report " + formattedTime;

        return reportFilename;
    }

    public static void logPassDetails(String log){
        TestListener.extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }

    public static void logFailDetails(String log){
        TestListener.extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }

    public static void logExceptionDetails(String log){
        TestListener.extentTest.get().fail(log);
    }

    public static void logInfoDetails(String log){
        TestListener.extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }

    public static void logWarningDetails(String log){
        TestListener.extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }

    public static void logJson(String json){
        TestListener.extentTest.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    public static void logHeaders(List<Header> headersList){
        String[][] headersArray = headersList.stream().map(header -> new String[] {header.getName(), header.getValue()})
                .toArray(String[][] :: new);

        TestListener.extentTest.get().info(MarkupHelper.createTable(headersArray));
    }
}
