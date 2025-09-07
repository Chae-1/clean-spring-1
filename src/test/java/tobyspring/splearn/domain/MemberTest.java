package tobyspring.splearn.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MemberTest {
    @Test
    void createMember() {
        var member = new Member("hyeongil@splearn.app", "hyeongil", "secret");

        assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
    }

    @Test
    void constructorNullCheck() {
        assertThatThrownBy(() -> new Member(null, "hyeongil", "secret"))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void activate() {
        Member member = new Member("hyeongil@splearn.app", "hyeongil", "secret");

        member.activate();

        assertThat(member.getStatus())
                .isEqualTo(MemberStatus.ACTIVE);
    }

    @Test
    void activateFail() {
        Member member = new Member("hyeongil@splearn.app", "hyeongil", "secret");

        member.activate();

        assertThatThrownBy(() -> member.activate())
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void deactivate() {
        Member member = new Member("hyeongil@splearn.app", "hyeongil", "secret");
        member.activate();

        member.deactivate();

        assertThat(member.getStatus()).isEqualTo(MemberStatus.DEACTIVATED);
    }

    @Test
    void deactivateFail() {
        Member member = new Member("hyeongil@splearn.app", "hyeongil", "secret");


        assertThatThrownBy(() -> member.deactivate())
                .isInstanceOf(IllegalStateException.class);

        member.activate();
        member.deactivate();

        assertThatThrownBy(() -> member.deactivate())
                .isInstanceOf(IllegalStateException.class);
    }
}