package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.validation.annotation.NotAlreadyChallenge;
import umc.spring.web.dto.MemberMissionRequest;

@Component
@RequiredArgsConstructor
public class NotAlreadyChallengeValidator
        implements ConstraintValidator<NotAlreadyChallenge, MemberMissionRequest> {

    private final MemberMissionRepository mmRepo;

    @Override
    public boolean isValid(MemberMissionRequest req, ConstraintValidatorContext ctx) {
        Long memberId  = 1L;                // 예시
        Long missionId = req.getMissionId();

        boolean exists = mmRepo.existsByMember_IdAndMission_IdAndStatus(
                memberId, missionId, MissionStatus.CHALLENGING);

        return !exists;
    }
}
