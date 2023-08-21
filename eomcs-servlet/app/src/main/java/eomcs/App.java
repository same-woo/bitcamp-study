package eomcs;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.io.File;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class App {
    public App() {
    }

    public static void main(String[] args) throws Exception {
        System.out.println("서버 시작!");
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8888);
        tomcat.setBaseDir("temp");
        Connector connector = tomcat.getConnector();
        connector.setURIEncoding("UTF-8");
        StandardContext ctx = (StandardContext)tomcat.addWebapp("/", (new File("src/main/webapp")).getAbsolutePath());
        ctx.setReloadable(true);
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", (new File("build/classes/java/main")).getAbsolutePath(), "/"));
        ctx.setResources(resources);
        tomcat.start();

        // tomcat.getServer().await();

        System.out.println("엔터를 치면 서버종료!");
        if (System.in.read() != -1) {
            System.out.println("서버 종료 중..");
            tomcat.stop();
        }

        System.out.println("서버 종료!");

    }
}

