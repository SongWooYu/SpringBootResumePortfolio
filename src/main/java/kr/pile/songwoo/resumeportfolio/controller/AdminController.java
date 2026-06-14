package kr.pile.songwoo.resumeportfolio.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class AdminController {

    @GetMapping("/admin")
    public String admin() {
        log.info("Admin page requested");
        return "admin/index";
    }
}