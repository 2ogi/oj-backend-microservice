package com.yu.ojbackendjudgeservice;

import com.yu.ojbackendjudgeservice.rabbitmq.InitRabbitMq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

// todo 如需开启 Redis，须移除 exclude 中的内容  (exclude = {RedisAutoConfiguration.class})
@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ComponentScan("com.yu")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.yu.ojbackendserviceclient.service"})
public class OjBackendJudgeServiceApplication {

    public static void main(String[] args) {
        // 初始化消息队列
        InitRabbitMq.doInit();
        SpringApplication.run(OjBackendJudgeServiceApplication.class, args);
    }

}
