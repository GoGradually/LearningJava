package hello.proxy.config.v4_postProcessor;

import hello.proxy.config.AppV1Config;
import hello.proxy.config.AppV2Config;
import hello.proxy.config.v3_proxyfactory.advice.LogTraceAdvice;
import hello.proxy.config.v4_postProcessor.postprocessor.PackageLogTraceProxyPostProcessor;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@Import({AppV1Config.class, AppV2Config.class})
public class BeanPostProcessorConfig {
    @Bean
    public PackageLogTraceProxyPostProcessor logTraceProxyPostProcessor(LogTrace logTrace) {
        return new PackageLogTraceProxyPostProcessor("hello.proxy.app", getAdvisor(logTrace));
    }

    private Advisor getAdvisor(LogTrace logTrace) {
        LogTraceAdvice logTraceAdvice = new LogTraceAdvice(logTrace);
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedNames("request*", "order*", "save*");
        return new DefaultPointcutAdvisor(pointcut, logTraceAdvice);
    }
}
