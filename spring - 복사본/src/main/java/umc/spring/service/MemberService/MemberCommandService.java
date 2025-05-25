package umc.spring.service.MemberService;

import jakarta.validation.Valid;
import umc.spring.domain.Member;
import umc.spring.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.@Valid JoinDto request);
}
