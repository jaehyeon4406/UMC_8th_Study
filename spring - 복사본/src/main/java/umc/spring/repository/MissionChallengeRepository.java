package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.MissionChallenge;
import umc.spring.domain.enums.MissionStatus;

public interface MissionChallengeRepository extends JpaRepository<MissionChallenge, Long> {

    /* 진행중/완료 목록 조회 */
    Page<MissionChallenge> findByMemberIdAndStatus(Long memberId,
                                                   MissionStatus status,
                                                   Pageable pageable);

    /* ✅ 이미 도전한 미션인지 검사 */
    boolean existsByMember_IdAndMission_IdAndStatus(Long memberId,
                                                    Long missionId,
                                                    MissionStatus status);
}
