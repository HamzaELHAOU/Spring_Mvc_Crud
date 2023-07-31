package com.springmvc.springmvc;

import com.springmvc.springmvc.dao.PatientRepository;
import com.springmvc.springmvc.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringMvcApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
     /*  patientRepository.save(new Patient(null,"Hamza","ELHAOU"," Casablanca",
                "0628754239",new Date(),false));

        patientRepository.save(new Patient(null,"Lhcen","Bouzzite","Beni mellal",
                "0628754799",new Date(),false));

        patientRepository.save(new Patient(null,"Rachid","bourigue","azilal ",
                "0628753654",new Date(),false));

        patientRepository.save(new Patient(null,"amin","youssfi","demnat",
                "06287536539",new Date(),false)); */

    }
}
