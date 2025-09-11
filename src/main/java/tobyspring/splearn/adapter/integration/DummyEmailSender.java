package tobyspring.splearn.adapter.integration;

import org.springframework.stereotype.Component;

import tobyspring.splearn.domain.Email;
import tobyspring.splearn.application.required.EmailSender;

@Component
public class DummyEmailSender implements EmailSender {
	@Override
	public void send(Email email, String subject, String body) {
		System.out.println("Email: " + email);
	}
}
