package vi.talya.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by vitalii on 12.03.17.
 */
@Aspect
@Component
public class LogingAspect {

    @Before("execution(* vi.talya.service.ContactService.*(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("******");
        System.out.println("******");
        System.out.println("Service " + joinPoint.getSignature().getName() + " begins");
    }

    @After("execution(* vi.talya.service.ContactService.*(..))")
    public void logAfter(JoinPoint joinPoint) {

        System.out.println("******");
        System.out.println("******");
        System.out.println("Service " + joinPoint.getSignature().getName() + " ends");
    }

}
