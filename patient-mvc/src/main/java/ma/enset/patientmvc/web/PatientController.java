package ma.enset.patientmvc.web;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.patientmvc.entities.Patient;
import ma.enset.patientmvc.repositories.PatientRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping(path = "/index")
    public String patients(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) {
        Page<Patient> pagePatients = patientRepository.findByNameContains(keyword, PageRequest.of(page, size));
        model.addAttribute("patients", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("size", size);
        return "patients";
    }

    @GetMapping(path = "/delete")
    public String deletePatient(@RequestParam Long id, @RequestParam String keyword, @RequestParam int page, @RequestParam int size) {
        System.out.println("id = " + id);
        patientRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&keyword=" + keyword + "&size" + size;
    }

    @GetMapping(path = "/formPatients")
    public String formPatients(Model model) {
        model.addAttribute("patient", new Patient());

        return "formPatients";
    }

    @PostMapping(path = "/save")
    public String save(@Valid Patient patient, BindingResult bindingResult, @RequestParam Long id, @RequestParam int page, @RequestParam int size, @RequestParam String keyword, Model model) {
        if (bindingResult.hasErrors()) return "formPatients";
        patientRepository.save(patient);
        return "redirect:/index?page=" + page + "&keyword=" + keyword + "&size" + size;
    }

    @GetMapping(path = "/home")
    public String index() {
        return "home";
    }

    @GetMapping(path = "/edit")
    public String edit(Model model, @RequestParam Long id, @RequestParam int page, @RequestParam int size, @RequestParam String keyword) {
        Patient patient = patientRepository.findById(id).get();
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("patient", patient);
        return "editPatients";
    }



}
