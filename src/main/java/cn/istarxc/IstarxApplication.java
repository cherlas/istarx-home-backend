package cn.istarxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 * @author istarxc.cn
 * @date 2021/12/29
 */
@SpringBootApplication
@EnableR2dbcRepositories
public class IstarxApplication {
    public static void main(String[] args) {
        SpringApplication.run(IstarxApplication.class, args);
    }
}
