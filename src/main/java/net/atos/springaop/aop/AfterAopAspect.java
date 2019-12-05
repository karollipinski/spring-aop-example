package net.atos.springaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

// Aspekty w Springu mogą działać z pięcioma rodzajami porad:
// @Before — Funkcjonalność porady jest wykonywana przed wywołaniem metody z poradą.
// @After — Funkcjonalność porady jest wykonywana po zakończeniu działaniametody z poradą, niezależnie od wyniku jej działania.
// @After-returning — Funkcjonalność porady jest wykonywana po prawidłowym zakończeniu metody z poradą.
// @After-throwing — Funkcjonalność porady jest wykonywana po zgłoszeniu wyjątku przez metodę z poradą.
// @Around — Porada realizuje tę samą funkcjonalność zarówno przed wywołaniem,jak i po zakończeniu metody z poradą.

@Slf4j
@Aspect
@Configuration
public class AfterAopAspect {

    @AfterReturning(value = "execution(* net.atos.springaop.service.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.info(">>> AfterReturning {} returned with value {} ", joinPoint, result);
    }

    @Pointcut(value = "execution(* net.atos.springaop.service.*.*(..))")
    private void afterPointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    @After("afterPointcut()")
    public void after(JoinPoint joinPoint) {
        log.info(">>> After {} ", joinPoint);
    }

}
