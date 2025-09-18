package tobyspring.splearn.domain.shared;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EmailTest {

    @Test
    void equality() {
        Email email1 = new Email("hyeongil100@gmail.com");
        Email email2 = new Email("hyeongil100@gmail.com");

        assertThat(email1).isEqualTo(email2);
    }
}