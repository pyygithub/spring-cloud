package com.wolf.cloud.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component//加入到Spring容器
public class JdbcConfigBean {

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    @Override
    public String toString() {
        return "JdbcConfigBean [url=" + url + ", username=" + username
                + ", password=" + password + ", driverClassName="
                + driverClassName + "]";
    }

}