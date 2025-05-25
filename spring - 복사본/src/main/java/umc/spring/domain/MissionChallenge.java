package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.enums.MissionStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MissionChallenge {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) private Member member;
    @ManyToOne(fetch = FetchType.LAZY) private Mission mission;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /*============== 엔티티 이벤트 ==============*/
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = MissionStatus.CHALLENGING;
    }
    @PreUpdate protected void onUpdate() { this.updatedAt = LocalDateTime.now(); }

    /*============== 비즈니스 메서드 ==============*/
    /** 진행중 → 완료 */
    public void complete() { this.status = MissionStatus.COMPLETE; }

    /** @return 완료 여부 */
    public boolean isComplete() { return this.status == MissionStatus.COMPLETE; }
}
