package com.xiyou.email.service;

import com.xiyou.email.entities.AuthenticatorImpl;
import com.xiyou.email.entities.InfoRecord;
import com.xiyou.email.mapper.EmailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service("emailService")
public class EmailService {

    @Autowired(required = false)
    private EmailMapper mapper;

    @Value("#{prop.from}")
    private String from;
    @Value("#{prop.password}")
    private String password;
    @Value("#{prop['mail.smtp.host']}")
    private String host;
    @Value("#{prop['mail.smtp.auth']}")
    private String auth;


    public void sendEmail(String to){
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host",host);
        properties.setProperty("mail.smtp.auth",auth);
        System.out.println("send");
//        String to = "514156689@qq.com";
        Session session = Session.getDefaultInstance(properties,new AuthenticatorImpl(from,password));
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            // Set To: 头部头字段
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("激活邮件");
            message.setContent("<h1>Test<h1>","text/html;charset=UTF-8");
            message.setText("<h1>Test<h1>");
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();

        }
    }

    @Transactional
    public void addInfoRecord(InfoRecord infoRecord){
//        System.out.println("addInfoRecord");
         mapper.addInfoRecord(infoRecord);
    }

    public void updateStatus(String activationCode){
        mapper.updateStatus(activationCode);
    }

}
