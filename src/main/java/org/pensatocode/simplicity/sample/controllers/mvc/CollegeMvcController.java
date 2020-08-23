package org.pensatocode.simplicity.sample.controllers.mvc;

import org.pensatocode.simplicity.sample.domain.College;
import org.pensatocode.simplicity.sample.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping("/colleges/")
public class CollegeMvcController {

    private final CollegeRepository collegeRepository;

    public CollegeMvcController(@Autowired CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    @GetMapping("list")
    public String loadColleges(Locale locale, Model model) {
        addRequiredModelAttributes(model);
        model.addAttribute("colleges", collegeRepository.findAll());
        model.addAttribute("content", "list-college");
        return "index";
    }

    @GetMapping("create")
    public String showCreateForm(Locale locale, Model model, College college) {
        addRequiredModelAttributes(model);
        model.addAttribute("content", "add-college");
        return "index";
    }

    @PostMapping("add")
    public String createCollege(@Valid College college, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/colleges/create";
        }
        collegeRepository.save(college);
        return "redirect:/colleges/list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        College college = collegeRepository.findOne(id);
        if (college == null) {
            throw new IllegalArgumentException("Invalid college Id:" + id);
        }
        addRequiredModelAttributes(model);
        model.addAttribute("college", college);
        model.addAttribute("content", "update-college");
        return "index";
    }

    @PostMapping("update/{id}")
    public String updateCollege(@PathVariable("id") Long id, @Valid College college,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            college.setId(id);
            return String.format("redirect:/colleges/edit/%d", id);
        }
        collegeRepository.save(college);
        return "redirect:/colleges/list";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        College college = collegeRepository.findOne(id);
        if (college == null) {
            throw new IllegalArgumentException("Invalid college Id:" + id);
        }
        collegeRepository.delete(college.getId());
        return "redirect:/colleges/list";
    }

    private void addRequiredModelAttributes(Model model) {
        model.addAttribute("path", "college");
        model.addAttribute("title", "Colleges");
    }

}
