package com.example.proyectosmga.services;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarteService {
    private final JobLauncher jobLauncher;
    private final Job marsMissionJob;

    @Autowired
    public MarteService(JobLauncher jobLauncher, Job marsMissionJob) {
        this.jobLauncher = jobLauncher;
        this.marsMissionJob = marsMissionJob;
    }

    public void processData() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("startAt", System.currentTimeMillis()) // Parámetro único para cada ejecución
                    .toJobParameters();

            jobLauncher.run(marsMissionJob, jobParameters);
            System.out.println("Procesamiento por lotes iniciado con éxito.");
        } catch (Exception e) {
            System.err.println("Error al iniciar el procesamiento por lotes: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
