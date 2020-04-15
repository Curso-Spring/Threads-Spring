package com.ibm.example;

import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class ThreadsSpringApplicationTests {

  @Autowired
  ThreadPoolTaskExecutor taskExecutor;

  @Test
  void contextLoads() throws InterruptedException {

    Contador cont = new Contador();
    
    int numThreads = 6;
    
    CountDownLatch countDownLatch = new CountDownLatch(numThreads);
    
    for(int i = 0; i < numThreads; i++) {
      taskExecutor.execute(new ContadorThread(cont, 4000000, countDownLatch));
    }
    
    countDownLatch.await();
    System.out.println("cuenta: " + cont.getCuenta());


  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  @Test
  public void test_pi() {
    long trialCount = 0;
    long inCircleCount = 0;
    long batch_size = 1000000;

    for (int i = 0; i < batch_size; i++) {
      double x = Math.random();
      double y = Math.random();
      trialCount++;
      if (x * x + y * y < 1)
        inCircleCount++;
    }

    double estimateForPi = 4 * ((double) inCircleCount / trialCount);
    
    log.info("Number of trials: {}", trialCount);
    log.info("Current Estimate: {} ", estimateForPi);
  }
  
  
  
  
  
  
  

}
