package tobyspring.splearn.adapter.security;

import org.springframework.context.annotation.Fallback;
import org.springframework.stereotype.Component;
import tobyspring.splearn.domain.member.PasswordEncoder;

@Component
@Fallback
public class DummyPasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(String password) {
		return "";
	}

	@Override
	public boolean matches(String password, String passwordHash) {
		return true;
	}
}
