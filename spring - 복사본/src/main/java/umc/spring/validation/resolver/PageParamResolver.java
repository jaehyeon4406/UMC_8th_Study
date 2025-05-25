package umc.spring.validation.resolver;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.spring.apiPayload.exception.InvalidPageException;
import umc.spring.validation.annotation.PageParam;

@Slf4j
public class PageParamResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(PageParam.class)
                && parameter.getParameterType().equals(Integer.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {

        HttpServletRequest req = (HttpServletRequest) webRequest.getNativeRequest();
        String raw = req.getParameter("page");
        try {
            int frontPage = Integer.parseInt(raw);    // null 이면 NPE
            if (frontPage <= 0) throw new InvalidPageException();
            return frontPage - 1;                     // 0-based
        } catch (Exception e) {                       // NumberFormatException, NPE
            log.debug("page 파라미터 오류: {}", raw);
            throw new InvalidPageException();
        }
    }
}
