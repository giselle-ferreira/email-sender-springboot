package com.emailsender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;
	
	public void sendEmail(String sendTo, String subject, String text) {
		
		log.info("Enviando email.");
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("usuarioteste.service@gmail.com");
		message.setTo(sendTo);
		message.setText(text);
		message.setSubject(subject);
		
		emailSender.send(message);
		
		log.info("Email enviado.");
		
	}
}
