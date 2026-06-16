package kr.pile.songwoo.resumeportfolio.controller;

import kr.pile.songwoo.resumeportfolio.service.CertificateService;
import kr.pile.songwoo.resumeportfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProjectService projectService;
    private final CertificateService certificateService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        log.info("Home page requested");

        model.addAttribute("projectCount", projectService.findAll().size());
        model.addAttribute("certificateCount", certificateService.findAll().size());
        model.addAttribute("skillCategoryCount", 6);

        return "home";
    }
}