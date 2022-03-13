package com.te.springbootbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.te.springbootbatch.task.MyTaskOne;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

    @Autowired
	private JobBuilderFactory jobBuilderFactory;
    
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

   @Bean
    public Step stepOne() {
	   return  stepBuilderFactory.get("stepone")
			   .tasklet(new MyTaskOne())
			   .build();
	   
   }
  
   @Bean
   public Step stepTwo() {
	   return stepBuilderFactory.get("steptwo")
			   .tasklet(new MyTaskTwo())
			   .build();
   }
   
   @Bean
   public Job demoJob() {
	   return jobBuilderFactory.get("demojob")
			   .start(stepOne())
			   .next(stepTwo())
			   .build();
   }

}
