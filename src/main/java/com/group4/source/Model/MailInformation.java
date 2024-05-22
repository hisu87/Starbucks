package com.group4.source.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailInformation {
    private String from = "Starbuck <hisu807@outlook.com>";
    private String to;
    private String[] cc;
    private String[] bcc;
    private String subject;
    private String body;
    private List<File> files = new ArrayList<>();

    public MailInformation(String to, String subject, String body) {
        super();
        this.to = to;
        this.subject = subject;
        this.body = body;
    }
}


