package tobyspring.splearn.application.provided;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static tobyspring.splearn.domain.MemberFixture.createMemberRegisterRequest;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import tobyspring.splearn.SplearnTestConfiguration;
import tobyspring.splearn.domain.Member;


@SpringBootTest
@Transactional
@Import(SplearnTestConfiguration.class)
record MemberFinderTest(MemberRegister register, MemberFinder memberFinder, EntityManager em) {

    @Test
    void find() {
        Member member = register.register(createMemberRegisterRequest());
        em.flush();
        em.clear();

        Member found = memberFinder.find(member.getId());
        assertThat(member.getId()).isEqualTo(found.getId());
    }

    @Test
    void findFail() {
        assertThatThrownBy(() -> memberFinder.find(999L))
                .isInstanceOf(IllegalArgumentException.class);
    }


}