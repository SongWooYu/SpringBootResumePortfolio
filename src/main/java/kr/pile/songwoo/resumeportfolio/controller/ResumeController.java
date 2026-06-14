package kr.pile.songwoo.resumeportfolio.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ResumeController {

    @GetMapping("/resume")
    public String resume() {
        log.info("Resume page requested");
        return "resume";
    }
}
