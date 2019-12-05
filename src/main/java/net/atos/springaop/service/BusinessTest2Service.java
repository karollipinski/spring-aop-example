package net.atos.springaop.service;

import net.atos.springaop.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BusinessTest2Service {

    @Autowired
    private UserRepository test2Repository;

    public String doSomething() {

        String value = test2Repository.getValue();
        log.info("BusinessTest2Service -{}", value);
        return value;

    }
}
