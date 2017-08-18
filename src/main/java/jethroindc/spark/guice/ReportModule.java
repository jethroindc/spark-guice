package jethroindc.spark.guice;

import com.google.inject.AbstractModule;
import jethroindc.spark.ReportService;
import jethroindc.spark.ReportServiceImpl;

public class ReportModule extends AbstractModule{
    @Override
    protected void configure() {
        bind( ReportService.class).to(ReportServiceImpl.class);
    }
}
