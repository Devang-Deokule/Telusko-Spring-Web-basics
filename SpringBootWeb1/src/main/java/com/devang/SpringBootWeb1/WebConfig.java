package com.devang.SpringBootWeb1;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.server.servlet.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.net.URI;

@Configuration
public class WebConfig {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> docRootCustomizer() {
        return factory -> {
            try {
                // Derive the project root from the compiled classes directory
                // e.g. .../target/classes -> go up 2 levels to reach the Maven project root
                URI classesLocation = getClass().getProtectionDomain().getCodeSource().getLocation().toURI();
                File classesDir = new File(classesLocation);
                File projectRoot = classesDir.getParentFile().getParentFile();
                File webappDir = new File(projectRoot, "src/main/webapp");
                if (webappDir.isDirectory()) {
                    factory.setDocumentRoot(webappDir);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
