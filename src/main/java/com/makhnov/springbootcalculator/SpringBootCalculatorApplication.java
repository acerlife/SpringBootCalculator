package com.makhnov.springbootcalculator;

import com.makhnov.springbootcalculator.quartz.AutoWiringSpringBeanJobFactory;
import com.makhnov.springbootcalculator.quartz.JobExpression;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;

@SpringBootApplication
@EnableSwagger2
public class SpringBootCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCalculatorApplication.class, args);
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/postfix_results");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public JobDetailFactoryBean jobDetail() {
        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
        jobDetailFactory.setJobClass(JobExpression.class);
        jobDetailFactory.setDescription("Invoke Sample Job service...");
        jobDetailFactory.setDurability(true);
        return jobDetailFactory;
    }

    @Bean
    public CronTriggerFactoryBean trigger(JobDetail jobDetail) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setGroup("myGroup");
        cronTriggerFactoryBean.setName("myTrigger");
        cronTriggerFactoryBean.setJobDetail(jobDetail);
        cronTriggerFactoryBean.setCronExpression("0 0/1 * 1/1 * ? *");
        return cronTriggerFactoryBean;
    }

    @Bean
    public SchedulerFactoryBean scheduler(Trigger trigger, JobDetail job) {
        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
        schedulerFactory.setConfigLocation(new ClassPathResource("quartz.properties"));
        schedulerFactory.setJobFactory(springBeanJobFactory());
        schedulerFactory.setJobDetails(job);
        schedulerFactory.setTriggers(trigger);
        return schedulerFactory;
    }

    @Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }
}
