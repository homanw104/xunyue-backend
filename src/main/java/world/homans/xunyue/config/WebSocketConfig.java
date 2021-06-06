package world.homans.xunyue.config;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Component
public class WebSocketConfig {

    /**
     * ServerEndpointExporter 作用
     * 这个 Bean 会自动注册使用 @ServerEndpoint 注解声明的 websocket endpoint。
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
