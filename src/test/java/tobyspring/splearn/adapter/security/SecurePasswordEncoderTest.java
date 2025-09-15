package tobyspring.splearn.adapter.security;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SecurePasswordEncoderTest {

    @Test
    void securePasswordEncoder() {
        SecurePasswordEncoder passwordEncoder = new SecurePasswordEncoder();

        String passwordHash = passwordEncoder.encode("security");
        
        assertThat(passwordEncoder.matches("security", passwordHash)).isTrue();
        assertThat(passwordEncoder.matches("wrong", passwordHash)).isFalse();
    }

}