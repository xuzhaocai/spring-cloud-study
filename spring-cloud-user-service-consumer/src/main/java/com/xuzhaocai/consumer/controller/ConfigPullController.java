package com.xuzhaocai.consumer.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigPullController {
    @Value("${mysql.jdbc-url}")
    private String jdbcUrl;
    @Value("${mysql.username}")
    private String username;
    @Value("${mysql.password}")
    private String password;
    @RequestMapping("/pullMysqlInof")
    public String pullMysqlInfo(){
        return "mysql-connect-info:[\"jdbc-url\":"+jdbcUrl+",\"username\":"+username+",\"password\":+"+password+"]";
    }
}
