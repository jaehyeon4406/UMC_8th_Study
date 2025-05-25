package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.enums.MissionStatus;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    Page<MemberMission> findByMemberIdAndStatus(Long memberId,
                                                MissionStatus status,
                                                Pageable pageable);

    boolean existsByMember_IdAndMission_IdAndStatus(Long memberId,
                                                    Long missionId,
                                                    MissionStatus status);
}
