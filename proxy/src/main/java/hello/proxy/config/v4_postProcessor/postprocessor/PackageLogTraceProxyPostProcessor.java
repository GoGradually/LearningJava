package hello.proxy.config.v4_postProcessor.postprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@Slf4j
public class PackageLogTraceProxyPostProcessor implements BeanPostProcessor {
    private final String basePackage;
    private final Advisor advisor;

    public PackageLogTraceProxyPostProcessor(String basePackage, Advisor advisor) {
        this.basePackage = basePackage;
        this.advisor = advisor;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("param beanName={} bean={}", beanName, bean.getClass());
        if (!bean.getClass().getPackageName().startsWith(basePackage)) {
            return bean;
        }
        ProxyFactory factory = new ProxyFactory(bean);

        factory.addAdvisor(advisor);
        Object proxy = factory.getProxy();
        log.info("create proxy: target={} proxy={}", bean.getClass(),
                proxy.getClass());
        return proxy;
    }
}
