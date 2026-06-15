package kr.pile.songwoo.resumeportfolio.controller;

import kr.pile.songwoo.resumeportfolio.service.CertificateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CertificateController {

    private final CertificateService certificateService;

    @GetMapping("/certificates")
    public String certificates(Model model) {
        log.info("Certificates page requested");

        model.addAttribute("certificates", certificateService.findAll());

        return "certificates/list";
    }
}