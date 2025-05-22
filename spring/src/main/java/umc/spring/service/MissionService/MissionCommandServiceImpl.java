package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.exception.notfound.MemberNotFoundException;
import umc.spring.apiPayload.exception.notfound.StoreNotFoundException;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.web.dto.MissionRequest;
import umc.spring.web.dto.MissionResponse;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository   storeRepository;
    private final MemberRepository  memberRepository;

    /** 가게에 미션 등록 */
    @Override
    @Transactional
    public MissionResponse createMission(Long storeId, MissionRequest request) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(StoreNotFoundException::new);

        // 작성자(member)는 인증 정보를 통해 받아오는 게 일반적이지만,
        // 여기선 예시로 1L 고정 → 실제 구현에서는 SecurityContext 등에서 꺼내세요
        Member member = memberRepository.findById(1L)
                .orElseThrow(MemberNotFoundException::new);

        Mission mission = MissionConverter.toEntity(member, store, request);
        Mission saved   = missionRepository.save(mission);

        return MissionConverter.toResponse(saved);
    }
}
