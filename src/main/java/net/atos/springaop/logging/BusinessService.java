package net.atos.springaop.logging;

import lombok.extern.slf4j.Slf4j;
import net.atos.springaop.logging.annotation.TrackTime;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class BusinessService {

    @TrackTime
    public Long calculateSomething(long x, long y) {
        try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            //do some logging
        }
        long sum = x + y;
        log.info("Suma {}", sum);
        return sum;
    }
}
