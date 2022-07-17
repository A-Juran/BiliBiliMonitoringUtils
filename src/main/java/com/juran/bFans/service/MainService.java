package com.juran.bFans.service;

import com.juran.bFans.task.BiliBiliMonitoring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * 作者： Juran on 2022-07-17 23:00
 * 作者博客：iit.la
 */
@Component
public class MainService {
    @Autowired
    BiliBiliMonitoring biliBiliMonitoring;

    @Scheduled(cron = "0 0 8 * * ?")
    public void monitoringFollowerAndFollowing() throws MessagingException, IOException {
        biliBiliMonitoring.FansAnd();
    }
}
