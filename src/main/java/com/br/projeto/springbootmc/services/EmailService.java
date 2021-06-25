package com.br.projeto.springbootmc.services;

import org.springframework.mail.SimpleMailMessage;

import com.br.projeto.springbootmc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
