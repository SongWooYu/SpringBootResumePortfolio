package kr.pile.songwoo.resumeportfolio.controller.admin;

import jakarta.validation.Valid;
import kr.pile.songwoo.resumeportfolio.domain.Project;
import kr.pile.songwoo.resumeportfolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
            @Valid @ModelAttribute("project") Project project,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        log.info("Project add requested. projectId={}, title={}", project.getProjectId(), project.getTitle());

        if (bindingResult.hasErrors()) {
            log.warn("Project add validation failed. errors={}", bindingResult.getErrorCount());
            return "admin/projects/addForm";
        }

        Project savedProject = projectService.create(project);

        redirectAttributes.addFlashAttribute("message", "프로젝트가 등록되었습니다.");

        return "redirect:/projects/" + savedProject.getProjectId();
    }

    @GetMapping("/{projectId}/edit")
    public String editForm(
            @PathVariable String projectId,
            Model model
    ) {
        log.info("Project edit form requested. projectId={}", projectId);

        Project project = projectService.findById(projectId);
        model.addAttribute("project", project);

        return "admin/projects/editForm";
    }

    @PostMapping("/{projectId}/edit")
    public String editProject(
            @PathVariable String projectId,
            @Valid @ModelAttribute("project") Project project,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        log.info("Project edit requested. projectId={}, title={}", projectId, project.getTitle());

        if (bindingResult.hasErrors()) {
            log.warn("Project edit validation failed. projectId={}, errors={}", projectId, bindingResult.getErrorCount());
            project.setProjectId(projectId);
            return "admin/projects/editForm";
        }

        projectService.update(projectId, project);

        redirectAttributes.addFlashAttribute("message", "프로젝트가 수정되었습니다.");

        return "redirect:/projects/" + projectId;
    }

    @PostMapping("/{projectId}/delete")
    public String deleteProject(
            @PathVariable String projectId,
            RedirectAttributes redirectAttributes
    ) {
        log.info("Project delete requested. projectId={}", projectId);

        projectService.delete(projectId);

        redirectAttributes.addFlashAttribute("message", "프로젝트가 삭제되었습니다.");

        return "redirect:/projects";
    }
}