package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

    public static ExtentReports report;

    public static ExtentReports createExtentReport(String filePath, String reportName, String docTitle){
        ExtentSparkReporter spark = new ExtentSparkReporter(filePath);
        spark.config().setReportName(reportName);
        spark.config().setDocumentTitle(docTitle);
        spark.config().setReportName("API Report");
        spark.config().setTheme(Theme.DARK);
        spark.config().setEncoding("UTF-8");

        report = new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("Project", "instantwebtools.net");
        report.setSystemInfo("Reporter", "jimmy");

        return report;
    }
}
