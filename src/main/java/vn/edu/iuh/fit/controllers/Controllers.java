package vn.edu.iuh.fit.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.models.Experience;
import vn.edu.iuh.fit.services.CandidateServices;
import vn.edu.iuh.fit.services.ExperienceServices;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class Controllers {
    @Autowired
    private CandidateServices candidateServices;

    @Autowired
    private ExperienceServices experienceServices;

    @RequestMapping()
    public String getHome() {
        return "index";
    }

    @RequestMapping("/candidates")
    public String getCandidates(Model model) {
        model.addAttribute("listCandidate", candidateServices.getAll());
        return "candidates";
    }

    @RequestMapping("/getDetails")
    public String getDetails(Model model, HttpServletRequest request) {
        long id = Long.parseLong(request.getParameter("candidateIdDetails"));
        model.addAttribute("candidateDetail", candidateServices.findById(id));
        return "candidateDetails";
    }
    @RequestMapping("/report1")
    public String getReport1() {

        return "report1";
    }

    @RequestMapping("/filterByCompany")
    public String filter(@RequestParam(name = "companyName", required = false)String companyName, Model model) {
        if(companyName!=null) {
            List<Experience> list = experienceServices.findByCompany(companyName);
            List<Candidate> listCan = new ArrayList<>();
            for (Experience experience:list) {
                listCan.add(experience.getCandidate());
            }
            model.addAttribute("listCandidate", listCan);
        } else {
            List<Candidate> listCan = new ArrayList<>();
            model.addAttribute("listCandidate", listCan);
        }
        return "candidateByCompany";
    }

    @RequestMapping("/report2")
    public String getReport2(Model model) {
        List<Experience> experiences = new ArrayList<>();
        experiences = experienceServices.getAll();
        List<Candidate> candidates = new ArrayList<>();
        for (Experience experience:experiences) {
            if(getYearBetween(experience.getToDate(),experience.getFromDate())>=5) {
                candidates.add(experience.getCandidate());
            }
        }
        model.addAttribute("candidateYear5", candidates);
        return "report2";
    }

    public int getYearBetween(Date from ,Date to) {
        int x = from.getYear()- to.getYear();
        return x;
    }
}
