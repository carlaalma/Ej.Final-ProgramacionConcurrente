package com.example.proyectosmga.config;
import com.example.proyectosmga.models.DatosSensor;
import com.example.proyectosmga.models.Sensor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.batch.test.JobLauncherTestUtils;



@Configuration
@EnableBatchProcessing
public class MarteConfig {

    private JobRepository jobRepository;
    private PlatformTransactionManager transactionManager;

    public MarteConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }

    @Bean
    public Job marsMissionJob(Step step1) {
        return  new JobBuilder("marsMissionJob", jobRepository)
                .start(step1)
                .build();
    }

    @Bean
    public Step step1(ItemReader<Sensor> reader,
                      ItemProcessor<Sensor, DatosSensor> processor,
                      ItemWriter<DatosSensor> writer) {
        return new StepBuilder("step1", jobRepository)
                .<Sensor,DatosSensor>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public ItemReader<Sensor> reader() {
        return () -> new Sensor(1L, "Sensor de Temperatura", "Temperatura"); // Simulación de entrada
    }

    @Bean
    public ItemProcessor<Sensor, DatosSensor> processor() {
        return sensorData -> new DatosSensor(sensorData.getId(),
                Math.random() * 100, // Procesamiento simulado
                java.time.LocalDateTime.now());
    }

    @Bean
    public ItemWriter<DatosSensor> writer() {
        return items -> items.forEach(item -> System.out.println("Procesado: " + item));
    }

    @Bean
    public JobLauncherTestUtils jobLauncherTestUtils() {
        return new JobLauncherTestUtils();
    }
    @Bean
    public JobRepositoryTestUtils jobRepositoryTestUtils(JobRepository jobRepository) {
        return new JobRepositoryTestUtils(jobRepository);
    }

}



