package vi.talya.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by vitalii on 12.03.17.
 */
@Aspect
@Component
public class LogingAspect {

    private static Logger LOGGER = Logger.getLogger(LogingAspect.class);

    @Before("execution(* vi.talya.service.ContactService.*(..))")
    public void logBefore(JoinPoint joinPoint) {

        LOGGER.info("******");
        LOGGER.info("******");
        LOGGER.info("Service " + joinPoint.getSignature().getName() + " begins");
    }

    @AfterReturning("execution(* vi.talya.service.ContactService.*(..))")
    public void logAfter(JoinPoint joinPoint) {


        LOGGER.info("Service " + joinPoint.getSignature().getName() + " ends");
        LOGGER.info("******");
        LOGGER.info("******");
    }

}
