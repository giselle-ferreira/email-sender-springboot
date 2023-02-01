package com.emailsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.emailsender.service.EmailService;

@SpringBootApplication
public class EmailSenderApplication {

	@Autowired
	private EmailService emailService;
	
	public static void main(String[] args) {
		SpringApplication.run(EmailSenderApplication.class, args);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail() {
		emailService.sendEmail(
				"usuarioteste.service@gmail.com", 
				"Teste de Envio de Email", 
				"Olá! Esta é uma mensagem teste enviada pelo Serviço de Envio de email desenvolvido com o SpringBoot.");
	}

}
