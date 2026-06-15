package kr.pile.songwoo.resumeportfolio.controller;

import kr.pile.songwoo.resumeportfolio.domain.Project;
import kr.pile.songwoo.resumeportfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/projects")
    public String projects(
            @RequestParam(value = "keyword", required = false) String keyword,
            Model model
    ) {
        log.info("Projects page requested. keyword={}", keyword);

        List<Project> projects = projectService.findProjects(keyword);

        model.addAttribute("projects", projects);
        model.addAttribute("keyword", keyword);
        model.addAttribute("projectCount", projects.size());

        return "projects/list";
    }

    @GetMapping("/projects/{projectId}")
    public String projectDetail(
            @PathVariable String projectId,
            Model model
    ) {
        log.info("Project detail page requested. projectId={}", projectId);

        Project project = projectService.findById(projectId);
        model.addAttribute("project", project);

        return "projects/detail";
    }
}