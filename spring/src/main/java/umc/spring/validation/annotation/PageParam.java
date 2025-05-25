// ① 어노테이션 정의
package umc.spring.validation.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageParam { }   // page=1  →  int 0 으로 변환
