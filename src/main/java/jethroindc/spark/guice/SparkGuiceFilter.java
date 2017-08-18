package jethroindc.spark.guice;

import com.google.inject.Injector;
import spark.servlet.SparkApplication;
import spark.servlet.SparkFilter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

public class SparkGuiceFilter extends SparkFilter {

    private static final String INJECTOR_NAME = Injector.class.getName();

    private Injector injector;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.injector = (Injector) filterConfig.getServletContext().getAttribute(INJECTOR_NAME);
        super.init(filterConfig);
    }

    @Override
    protected SparkApplication getApplication(String applicationClassName) throws ServletException {
        try {
            Class<?> applicationClass = Class.forName(applicationClassName);
            return (SparkApplication)injector.getInstance( applicationClass );
        } catch (Exception exc) {
            throw new ServletException(exc);
        }
    }
}
