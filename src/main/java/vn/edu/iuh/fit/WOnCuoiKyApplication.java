package vn.edu.iuh.fit;

import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.models.Experience;
import vn.edu.iuh.fit.models.Roles;
import vn.edu.iuh.fit.repositories.CandidateRepository;
import vn.edu.iuh.fit.repositories.ExperienceRepository;

import java.util.Date;

@SpringBootApplication
public class WOnCuoiKyApplication {

    public static void main(String[] args) {
        SpringApplication.run(WOnCuoiKyApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(CandidateRepository candidateRepository, ExperienceRepository experienceRepository){
        return args -> {
            Faker faker  = new Faker();
            for(int i= 0; i<3; i++) {
                Candidate candidate = new Candidate();
                candidate.setFullName(faker.name().fullName());
                candidate.setEmail(faker.internet().emailAddress());
                candidate.setPhone(faker.phoneNumber().phoneNumber());
                candidateRepository.save(candidate);
                for (int j=0; j<3; j++) {
                    Experience experience = new Experience();
                    experience.setCompany(faker.company().name());
                    experience.setFromDate(new Date());
                    experience.setToDate(new Date());
                    experience.setRole(Roles.EXECUTIVE);
                    experience.setWorkDesc(faker.job().title());
                    experience.setCandidate(candidate);
                    experienceRepository.save(experience);

                }
            }
        };
    }

}
