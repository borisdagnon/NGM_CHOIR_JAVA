//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.graceetfoi.gf;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GfApplication extends SpringBootServletInitializer {
    private int maxUploadSizeInMb = 10485760;

    public GfApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(GfApplication.class, args);
    }

    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.addConnectorCustomizers(new TomcatConnectorCustomizer[]{(connector) -> {
            if (connector.getProtocolHandler() instanceof AbstractHttp11Protocol) {
                ((AbstractHttp11Protocol)connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }

        }});
        return tomcat;
    }
}
