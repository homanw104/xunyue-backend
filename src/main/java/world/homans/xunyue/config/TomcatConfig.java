package world.homans.xunyue.config;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * To enable support for both HTTP and HTTPS in Spring Boot 2, we need to
 * register an additional connector. To configure this, we need to return an
 * implementation of ConfigurableServletWebServerFactory as a bean.
 *
 * @author Homan Wong
 * @since 06/12/2021
 */
@Configuration
public class TomcatConfig {

    @Value("${server.http-port}")
    private int httpPort;

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
        return tomcat;
    }

    private Connector createStandardConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(httpPort);
        return connector;
    }

}
