package world.homans.xunyue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("world.homans.xunyue.dao")
public class XunYueApplication {

    public static void main(String[] args) {
        SpringApplication.run(XunYueApplication.class, args);
    }

}
