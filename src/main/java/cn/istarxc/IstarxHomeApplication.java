package cn.istarxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author istarxc.cn
 * @date 2021/12/29
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class IstarxHomeApplication {
    public static void main(String[] args) {
        SpringApplication.run(IstarxHomeApplication.class, args);
    }
}
