package net.atos.springaop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
public class BeforeRunRepository {

    @Before(value = "execution(* net.atos.springaop.repository.*.*(..))")
    public void before(JoinPoint joinPoint) {

        log.info("-- Check something");
        log.info("-- Before {}", joinPoint);

    }

}
