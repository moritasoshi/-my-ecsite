package com.example.myecsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class MailService {
    @Autowired
    private MailSender sender;

    public void sendMail() {
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setFrom("xxx@xxx.com");
        msg.setTo("xxx@xxx.com");
        msg.setSubject("注文完了メール");  //タイトルの設定
        msg.setText("注文が完了しました。\nご利用ありがとうございました。");  //本文の設定

        this.sender.send(msg);
    }
}
