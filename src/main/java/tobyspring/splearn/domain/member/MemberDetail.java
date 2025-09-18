package tobyspring.splearn.domain.member;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tobyspring.splearn.domain.shared.AbstractEntity;

@Entity
@Getter
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDetail extends AbstractEntity {
	private String profile;

	private String introduction;

	private LocalDateTime registerAt;

	private LocalDateTime activateAt;

	private LocalDateTime deactivateAt;

	static MemberDetail create() {
		MemberDetail memberDetail = new MemberDetail();
		memberDetail.registerAt = LocalDateTime.now();
		return memberDetail;
	}

	public void activate() {
		this.activateAt = LocalDateTime.now();
	}
}
