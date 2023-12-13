package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.models.Experience;
import vn.edu.iuh.fit.repositories.ExperienceRepository;

import java.util.List;

@Service
public class ExperienceServices {
    @Autowired
    private ExperienceRepository experienceRepository;

    public List<Experience> getAll() {
        return experienceRepository.findAll();
    }

    public List<Experience> findByCompany(String companyName) {
        return experienceRepository.findByCompany(companyName);
    }
}
