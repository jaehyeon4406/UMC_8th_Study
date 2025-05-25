package umc.spring.domain.mapping;           // ✅ mapping 패키지

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "member_mission")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) private Member member;
    @ManyToOne(fetch = FetchType.LAZY) private Mission mission;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void complete() { this.status = MissionStatus.COMPLETE; }
}
