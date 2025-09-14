package tobyspring.splearn.application.required;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import tobyspring.splearn.domain.Member;
import tobyspring.splearn.domain.MemberFixture;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    void createMember() {
        Member member = Member.register(MemberFixture.createMemberRegisterRequest(), MemberFixture.createPasswordEncoder());

        assertThat(member.getId()).isNull();

        memberRepository.save(member);

        assertThat(member.getId()).isNotNull();
    }

    @Test
    void duplicateEmailFail() {
        Member member = Member.register(MemberFixture.createMemberRegisterRequest(), MemberFixture.createPasswordEncoder());
        memberRepository.save(member);

        Member member2 = Member.register(MemberFixture.createMemberRegisterRequest(), MemberFixture.createPasswordEncoder());
        assertThatThrownBy(() -> memberRepository.save(member2))
                .isInstanceOf(DataIntegrityViolationException.class);
    }
}