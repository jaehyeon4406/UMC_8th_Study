package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MissionChallengeRepository;
import umc.spring.validation.annotation.NotAlreadyChallenge;
import umc.spring.web.dto.MissionChallengeRequest;

@Component
@RequiredArgsConstructor
public class NotAlreadyChallengeValidator
        implements ConstraintValidator<NotAlreadyChallenge, MissionChallengeRequest> {

    private final MissionChallengeRepository missionChallengeRepository;

    @Override
    public boolean isValid(MissionChallengeRequest request,
                           ConstraintValidatorContext context) {

        Long memberId  = 1L;                     // ★ 실제 구현 땐 로그인 유저 ID로 교체
        Long missionId = request.getMissionId(); // 요청에서 미션 ID 추출

        boolean alreadyExists =
                missionChallengeRepository.existsByMember_IdAndMission_IdAndStatus(
                        memberId, missionId, MissionStatus.CHALLENGING);

        return !alreadyExists;                   // true → 유효, 도전 안 했음
    }
}
