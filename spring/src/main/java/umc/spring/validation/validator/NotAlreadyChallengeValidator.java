package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MissionChallengeRepository;
import umc.spring.web.dto.MissionChallengeRequest;

@Component
@RequiredArgsConstructor
public class NotAlreadyChallengeValidator implements ConstraintValidator<umc.spring.validation.annotation.NotAlreadyChallenge, MissionChallengeRequest> {

    private final MissionChallengeRepository missionChallengeRepository;

    @Override
    public boolean isValid(MissionChallengeRequest request, ConstraintValidatorContext context) {
        Long memberId = 1L; // 하드코딩된 멤버 ID
        return !missionChallengeRepository.existsByMemberIdAndMissionIdAndStatus(
                memberId, request.getMissionId(), MissionStatus.CHALLENGING
        );
    }
}
