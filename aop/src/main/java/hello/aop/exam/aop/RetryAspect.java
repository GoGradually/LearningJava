package hello.aop.exam.aop;

import hello.aop.exam.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
public class RetryAspect {

    @Around("@annotation(retry)")
    public Object retry(ProceedingJoinPoint joinPoint, Retry retry) throws Throwable {
        Exception exceptionHolder = null;
        for (int i = 0; i < retry.value(); i++) {
            try {
                log.info("[retry] try count={}/{}", i, retry.value());
                return joinPoint.proceed();
            }catch (IllegalStateException e){
                log.info("재시도");
                exceptionHolder = e;
            }
        }
        throw exceptionHolder;
    }
}
