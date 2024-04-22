package com.student_information_system.serviceimplementation;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class Email_serviceimpl {
	@Autowired
	JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
		private String send;
	 
		public String Sendemail(String to, String subject, String body)
		{
			try {
				MimeMessage mimeMessage = javaMailSender.createMimeMessage();
				
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
				
				mimeMessageHelper.setFrom(send);
				mimeMessageHelper.setTo(to);
				mimeMessageHelper.setSubject(subject);
				mimeMessageHelper.setText(body);
				
				javaMailSender.send(mimeMessage);
				
				return "Email Send Successfully";
				
	 
			} catch (MessagingException e) {
				return e.getMessage();
			}
			
		}
}
