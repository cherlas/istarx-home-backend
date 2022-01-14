package cn.istarxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author istarxc.cn
 * @date 2021/12/29
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@PropertySource(value={"classpath:database.properties"})
public class IstarxApplication {
    public static void main(String[] args) {
        SpringApplication.run(IstarxApplication.class, args);
    }
}
