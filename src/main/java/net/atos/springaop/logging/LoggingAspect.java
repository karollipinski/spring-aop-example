package net.atos.springaop.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

// Aspekty w Springu mogą działać z pięcioma rodzajami porad:
// @Before — Funkcjonalność porady jest wykonywana przed wywołaniem metody z poradą.
// @After — Funkcjonalność porady jest wykonywana po zakończeniu działaniametody z poradą, niezależnie od wyniku jej działania.
// @After-returning — Funkcjonalność porady jest wykonywana po prawidłowym zakończeniu metody z poradą.
// @After-throwing — Funkcjonalność porady jest wykonywana po zgłoszeniu wyjątku przez metodę z poradą.
// @Around — Porada realizuje tę samą funkcjonalność zarówno przed wywołaniem,jak i po zakończeniu metody z poradą.

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Around(value = "execution(* net.atos.springaop..*(..)))")
    public void profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        //Get intercepted method details
        String className = methodSignature.getDeclaringType()
                                          .getSimpleName();
        String methodName = methodSignature.getName();

        final StopWatch stopWatch = new StopWatch();

        //Measure method execution time
        stopWatch.start();
        proceedingJoinPoint.proceed();
        stopWatch.stop();

        //Log method execution time
        log.info("Execution time of " + className + "." + methodName + " "
                 + ":: " + stopWatch.getTotalTimeMillis() + " ms");
    }

    @Around(value = "@annotation(net.atos.springaop.logging.annotation.TrackTime)")
    public void profileAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        log.info("****** Time Taken from annotation is {}", timeTaken);
    }

    @AfterThrowing(
            pointcut = "execution(* net.atos.springaop.logging.DomainService.addDomainObjectThrowException(..))",
            throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {

        log.info("+++++ AfterThrowing is running!");
        //Get intercepted method details
        String className = joinPoint.getSignature()
                                    .getDeclaringType()
                                    .getSimpleName();
        String methodName = joinPoint.getSignature()
                                     .getName();
        log.info("+++++ Execution Throwing in  {}.{}", className, methodName);
        log.info("+++++ Exception : " + error);

    }

}
