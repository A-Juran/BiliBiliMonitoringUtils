package com.juran.bFans.confing;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

/**
 * 作者： Juran on 2022-07-17 12:14
 * 作者博客：iit.la
 */
@Component
@ConfigurationProperties(prefix = "mail")
public class Mail {
    @Value("${mail.sender}")
    public String sender;
    @Value("${mail.recipient}")
    public  String recipient;
    @Value("${mail.cc}")
    public String cc;

    //发送信息类
    private static JavaMailSender javaMailSender;

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public static JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void send(SimpleMailMessage message){
        javaMailSender.send(message);
    }

    public void send(MimeMessage message){
        javaMailSender.send(message);
    }
}
