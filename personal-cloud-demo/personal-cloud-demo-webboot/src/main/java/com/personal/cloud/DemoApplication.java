package com.personal.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;

/**
 * Created by Administrator on 2019-07-30.
 */
@ServletComponentScan(basePackages = "com.personal")
@SpringBootApplication(scanBasePackages = "com.personal", exclude = {HibernateJpaAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class})
public class DemoApplication {

    private static Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
        for (String profile : activeProfiles) {
            logger.info("Spring Boot 使用profile为:{}", profile);
        }
    }
}
