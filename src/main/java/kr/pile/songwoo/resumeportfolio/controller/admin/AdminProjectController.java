package kr.pile.songwoo.resumeportfolio.controller.admin;

import kr.pile.songwoo.resumeportfolio.domain.Project;
import kr.pile.songwoo.resumeportfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/projects")
public class AdminProjectController {

    private final ProjectService projectService;

    @GetMapping("/add")
    public String addForm(Model model) {
        log.info("Project add form requested");

        Project project = Project.builder()
                .projectId(projectService.generateNextProjectId())
                .category("Spring Boot")
                .build();

        model.addAttribute("project", project);

        return "admin/projects/addForm";
    }

    @PostMapping("/add")
    public String addProject(
            @ModelAttribute("project") Project project,
            RedirectAttributes redirectAttributes
    ) {
        log.info("Project add requested. projectId={}, title={}", project.getProjectId(), project.getTitle());

        Project savedProject = projectService.create(project);

        redirectAttributes.addFlashAttribute("message", "프로젝트가 등록되었습니다.");

        return "redirect:/projects/" + savedProject.getProjectId();
    }
}