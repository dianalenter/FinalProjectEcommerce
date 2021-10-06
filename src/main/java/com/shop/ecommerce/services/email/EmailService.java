package com.shop.ecommerce.services.email;

import javax.mail.internet.MimeMessage;

import com.shop.ecommerce.domain.Product;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

	void sendConfirmationEmail(Product obj);
	void sendEmail(SimpleMailMessage msg);
	
	void sendConfirmationEmailHtml(Product obj);
	void sendEmailHtml(MimeMessage msg);
	
	void sendNewPassword(String email, String newPassword);
}
