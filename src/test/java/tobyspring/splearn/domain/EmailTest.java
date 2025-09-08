package tobyspring.splearn.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmailTest {

    @Test
    void equality() {
        Email email1 = new Email("hyeongil100@gmail.com");
        Email email2 = new Email("hyeongil100@gmail.com");

        assertThat(email1).isEqualTo(email2);
    }
}