package kr.pile.songwoo.resumeportfolio.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class SkillController {

    @GetMapping("/skills")
    public String skills() {
        log.info("Skills page requested");
        return "skills";
    }
}