package net.atos.springaop.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AopServiceTest {
    @Autowired
    BusinessTestService businessTestService;

    @Autowired
    BusinessTest2Service businessTest2Service;

    @Test
    public void test() {
        log.info("Test -{} ", businessTestService.doSomething());
        log.info("Test -{} ", businessTest2Service.doSomething());

    }

}
