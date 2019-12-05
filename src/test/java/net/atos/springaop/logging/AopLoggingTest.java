package net.atos.springaop.logging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopLoggingTest {
    @Autowired
    private DomainService domainService;

    @Autowired
    private BusinessService businessService;

    @Test
    public void testGetDomainObjectById() {
        domainService.getDomainObjectById(10L);
    }

    @Test(expected = RuntimeException.class)
    public void testAddDomainObjectThrowException() throws RuntimeException {
        domainService.addDomainObjectThrowException();
    }

    @Test
    public void testTrackTimeAnnotation() {
        businessService.calculateSomething(10L, 15L);
    }
}