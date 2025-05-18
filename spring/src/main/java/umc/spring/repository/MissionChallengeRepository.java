package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.MissionChallenge;
import umc.spring.domain.enums.MissionStatus;

public interface MissionChallengeRepository extends JpaRepository<MissionChallenge, Long> {
    boolean existsByMemberIdAndMissionIdAndStatus(Long memberId, Long missionId, MissionStatus status);
}