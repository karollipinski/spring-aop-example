package net.atos.springaop.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class DomainService {
    public Object getDomainObjectById(Long id) {
        try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            //do some logging
        }
        return id;
    }

    public void addDomainObjectThrowException() throws RuntimeException {
        log.info("addDomainObjectThrowException() is running ");
        throw new RuntimeException("Generic Error");
    }

}
