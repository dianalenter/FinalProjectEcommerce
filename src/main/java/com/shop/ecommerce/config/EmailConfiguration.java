package com.shop.ecommerce.config;

import com.shop.ecommerce.services.email.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shop.ecommerce.services.email.SmtpEmailService;

@Configuration
public class EmailConfiguration {

	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
