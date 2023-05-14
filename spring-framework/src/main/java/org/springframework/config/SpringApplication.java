package org.springframework.config;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author leellun
 * date: 2020-1-15 21:05
 * desc:
 **/
public class SpringApplication {

    public static void run(Class<?> applicationClass, String[] args) throws Exception {
//        long start = System.currentTimeMillis();
//        Tomcat tomcat = new Tomcat();
//
//        PropertiesConfig propertiesConfig = new PropertiesConfig();
//        tomcat.setPort(propertiesConfig.getPort());
//
//        // 设置contextPath和路径
//        Context context = tomcat.addContext(propertiesConfig.getContextPath(), null);
//        //配置servlet，此处相当于初始化了整个spring上下文
//        tomcat.addServlet(propertiesConfig.getContextPath(), "dispatatchServlet", new DispatcherServlet(applicationClass));
//        context.addServletMappingDecoded("/*", "dispatatchServlet");
//
//        // 启动tomcat
//        tomcat.start();
//        long end = System.currentTimeMillis();
//        System.out.println("启动完成,共使用了:" + (end - start) + "ms");
//        // 进入监听状态,如果不进入监听状态,启动tomat后就会关闭tomcat
//        tomcat.getServer().await();
        startTomcat(applicationClass, args);
    }
    public static void startTomcat(Class<?> applicationClass, String[] args) throws Exception {
        PropertiesConfig propertiesConfig = new PropertiesConfig();

        Tomcat tomcat = new Tomcat();

        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        Connector connector = new Connector();
        connector.setPort(propertiesConfig.getPort());

        Engine engine = new StandardEngine();
        engine.setDefaultHost("localhost");

        Host host = new StandardHost();
        host.setName("localhost");

        String contextPath = propertiesConfig.getContextPath();
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);

        tomcat.addServlet(context.getPath(), "dispatcher", new DispatcherServlet(applicationClass));
        context.addServletMappingDecoded("/*", "dispatcher");

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }
}
