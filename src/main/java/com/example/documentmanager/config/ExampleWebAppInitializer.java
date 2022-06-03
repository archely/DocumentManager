package com.example.documentmanager.config;

import com.vaadin.flow.spring.SpringServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
// https://vaadin.com/docs/v14/flow/integrations/spring/tutorial-spring-basic-mvc
public class ExampleWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        registerConfiguration(context);
        servletContext.addListener(
                new ContextLoaderListener(context));
        ServletRegistration.Dynamic registration =
                servletContext.addServlet("dispatcher",
                        new SpringServlet(context, true));
        registration.setLoadOnStartup(1);
        registration.addMapping("/*");
    }

    private void registerConfiguration(
            AnnotationConfigWebApplicationContext context) {
        // register your configuration classes here
    }
}
