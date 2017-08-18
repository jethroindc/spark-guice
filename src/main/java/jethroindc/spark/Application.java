package jethroindc.spark;

import spark.servlet.SparkApplication;

import javax.inject.Inject;

import static spark.Spark.get;

public class Application implements SparkApplication {

    private final ReportService reportService;

    @Inject
    public Application(ReportService reportService1) {
        this.reportService = reportService1;
    }

    @Override
    public void init() {
        get("/", ( req, res ) -> {
            return reportService.getHello();
        });
    }

    @Override
    public void destroy() {

    }
}
