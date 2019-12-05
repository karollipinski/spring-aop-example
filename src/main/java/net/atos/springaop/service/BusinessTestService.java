package net.atos.springaop.service;

import net.atos.springaop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BusinessTestService {

    @Autowired
    private ProductRepository testRepository;

    public String doSomething() {

        String value = testRepository.getValue();
        log.info("BusinessTestService -{}", value);
        return value;

    }
}
