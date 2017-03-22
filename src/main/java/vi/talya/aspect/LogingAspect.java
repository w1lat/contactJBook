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

        LOGGER.debug("******");
        LOGGER.debug("******");
        LOGGER.debug("Service " + joinPoint.getSignature().getName() + " begins");
    }

    @AfterReturning("execution(* vi.talya.service.ContactService.*(..))")
    public void logAfter(JoinPoint joinPoint) {


        LOGGER.debug("Service " + joinPoint.getSignature().getName() + " ends");
        LOGGER.debug("******");
        LOGGER.debug("******");
    }

}
