package com.anla.sseemitter.normal;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.PostConstruct;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ProcessSensor {
   private final ApplicationEventPublisher publisher;
   private final Random rnd = new Random();
   private final ScheduledExecutorService executor =
           Executors.newSingleThreadScheduledExecutor();

   public ProcessSensor(ApplicationEventPublisher publisher) {
      this.publisher = publisher;
   }

   @PostConstruct
   public void startProcessing() {
      this.executor.schedule(this::probe, 1, SECONDS);
   }

   private void probe() {
      double temperature = 16 + rnd.nextGaussian() * 10;
      publisher.publishEvent(new Process(temperature));

      // schedule the next read after some random delay (0-5 seconds)
      executor.schedule(this::probe, rnd.nextInt(5000), MILLISECONDS);
   }
}
