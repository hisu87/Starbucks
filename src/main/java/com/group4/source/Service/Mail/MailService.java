package com.group4.source.Service.Mail;

import com.group4.source.Model.MailInformation;
import jakarta.mail.MessagingException;
import org.springframework.scheduling.annotation.Scheduled;

public interface MailService {
    void send(MailInformation mail) throws MessagingException;

    void send(String to, String subject, String body) throws MessagingException;

    void queue(MailInformation mail);

    void queue(String to, String subject, String body);

    @Scheduled(fixedDelay = 5000)
    void run();
}
