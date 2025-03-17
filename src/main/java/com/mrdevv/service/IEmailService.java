package com.mrdevv.service;

import java.io.File;

public interface IEmailService {

    void sendCodeEmail(String toUser, String subject, String message);
}
