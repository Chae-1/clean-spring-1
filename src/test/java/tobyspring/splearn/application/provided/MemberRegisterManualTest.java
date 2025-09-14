package tobyspring.splearn.application.provided;

//@Disabled
//class MemberRegisterManualTest {
//
//	@Test
//	void registerTestStub() {
//		MemberRegister register = new MemberService(
//			new MemberRepositoryStub(), new EmailSenderStub(), createPasswordEncoder()
//		);
//
//		Member member = register.register(createMemberRegisterRequest());
//
//		assertThat(member.getId()).isNotNull();
//		assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
//	}
//
//	@Test
//	void registerTestMock() {
//		EmailSenderMock emailSenderMock = new EmailSenderMock();
//		MemberRegister register = new MemberService(
//			new MemberRepositoryStub(), emailSenderMock, createPasswordEncoder()
//		);
//
//		Member member = register.register(createMemberRegisterRequest());
//
//		assertThat(member.getId()).isNotNull();
//		assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
//
//		assertThat(emailSenderMock.tos).hasSize(1);
//		assertThat(emailSenderMock.tos.getFirst()).isEqualTo(member.getEmail());
//	}
//
//	@Test
//	void registerTestMockito() {
//		EmailSenderMock emailSenderMock = Mockito.mock(EmailSenderMock.class);
//		MemberRegister register = new MemberService(
//			new MemberRepositoryStub(), emailSenderMock, createPasswordEncoder()
//		);
//
//		Member member = register.register(createMemberRegisterRequest());
//
//		assertThat(member.getId()).isNotNull();
//		assertThat(member.getStatus()).isEqualTo(MemberStatus.PENDING);
//
//		Mockito.verify(emailSenderMock)
//			.send(eq(member.getEmail()), any(), any());
//	}
//
//
//	static class MemberRepositoryStub implements MemberRepository {
//
//		@Override
//		public Member save(Member member) {
//			ReflectionTestUtils.setField(member, "id", 1L);
//			return member;
//		}
//
//		@Override
//		public Optional<Member> findByEmail(Email email) {
//			return Optional.empty();
//		}
//
//		@Override
//		public Optional<Member> findById(Long memberId) {
//			return Optional.empty();
//		}
//	}
//
//	static class EmailSenderStub implements EmailSender {
//
//		@Override
//		public void send(Email email, String subject, String body) {
//
//		}
//	}
//
//	static class EmailSenderMock implements EmailSender {
//		List<Email> tos = new ArrayList<>();
//
//		@Override
//		public void send(Email email, String subject, String body) {
//			tos.add(email);
//		}
//	}
//}