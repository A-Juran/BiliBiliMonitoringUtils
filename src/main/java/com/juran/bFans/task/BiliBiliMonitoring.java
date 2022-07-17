package com.juran.bFans.task;

import com.juran.bFans.api.ApiManager;
import com.juran.bFans.confing.Mail;
import com.juran.bFans.entity.FansVo;
import com.juran.bFans.mailTemplate.MailTemplate;
import com.juran.bFans.utils.http.HttpUtil;
import com.juran.bFans.utils.json.GetMapFromJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

/**
 * 作者： Juran on 2022-07-17 10:55
 * 作者博客：iit.la
 */
@Component
public class BiliBiliMonitoring {
    Mail mail;

    @Autowired
    public void setMail(Mail mail) {
        this.mail = mail;
    }

    /**
     * 监控关注与粉丝
     * 周期:30s
     */
    public void FansAnd() throws IOException, MessagingException {
        //get BiliBili following And follower
        String send = HttpUtil.send(ApiManager.BILIBILI_GET_FANS.getApi());
        FansVo fansVo = GetMapFromJson.getInfo(send);
        //send message use mail template;
        String tempOne = MailTemplate.temp_one(fansVo.getFollowing(), fansVo.getFollower());
        //send email
        //SimpleMailMessage message=new SimpleMailMessage();
        //MimeMessage message = Mail.javaMailSender.createMimeMessage();
        MimeMessage message = Mail.getJavaMailSender().createMimeMessage();
        //需要借助Helper类
        MimeMessageHelper helper=new MimeMessageHelper(message,true);
        //发送信息
        helper.setFrom(mail.sender);
        //主题
        helper.setSubject("BiliBili follower and following");
        //收件人
        helper.setTo(mail.recipient);
        //抄送人
        helper.setCc(mail.cc);
        //密送人
        helper.setBcc(mail.sender);
        //发送邮件
        helper.setText(tempOne,true);

        mail.send(message);
    }
}
