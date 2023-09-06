package bitcamp.myapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppWepApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public AppWepApplicationInitializer() {
        System.out.println("AppWepApplicationInitializer() 생성됨!");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // ContextLoaderListener의 IoC 컨테이너가 사용할 java config 클래스를 지정한다.
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // DispatcherServlet의 IoC 컨테이너가 사용할 java config 클래스를 지정한다.
        return new Class[] {AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // DispatcherServlet의 URL을 지정한다.
        return new String[] {"/app/*"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement("temp", 10000000, 15000000, 1000000));
    }
}
