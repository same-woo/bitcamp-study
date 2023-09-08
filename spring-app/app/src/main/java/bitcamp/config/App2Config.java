package bitcamp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceView;

@ComponentScan("bitcamp.app2")
public class App2Config {

    public ViewResolver viewResolver() {
        InternalResourceView vr = new InternalResourceView();
        vr.setPrefix("/WEB_INF")
    }
}
