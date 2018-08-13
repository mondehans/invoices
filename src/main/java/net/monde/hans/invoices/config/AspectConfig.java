package net.monde.hans.invoices.config;


import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import java.util.UUID;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

@Aspect
@Component
@Configuration
public class AspectConfig {

    private static final Logger logger = LoggerFactory.getLogger(AspectConfig.class);
    private static final String REF_ID = "refId";

    @Before("execution(* net.monde.hans.invoices.rest..*.*(..))")
    public void mdcPut(JoinPoint joinPoint) {
        //to get method name
        logger.info("before calling {} {}",joinPoint.getSignature().getName(),"()");

        //to get method args
        Object[] methodArgs = joinPoint.getArgs();
        for (Object oneArg: methodArgs) {
            logger.info("arg={}",oneArg);
        }

        MDC.put(REF_ID, UUID.randomUUID().toString().replace("-", "").substring(0, 12));
    }

    @After("execution(* net.monde.hans.invoices.rest..*.*(..))")
    public void mdcRemove(JoinPoint joinPoint) {
        logger.info("after calling {} {}",joinPoint.getSignature().getName(),"()");
        MDC.remove(REF_ID);
    }

}
