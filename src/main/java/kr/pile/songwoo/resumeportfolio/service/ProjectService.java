package kr.pile.songwoo.resumeportfolio.service;

import kr.pile.songwoo.resumeportfolio.domain.Project;
import kr.pile.songwoo.resumeportfolio.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<Project> findProjects(String keyword) {
        return projectRepository.findByKeyword(keyword);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(String projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 프로젝트입니다. projectId=" + projectId));
    }

    public Project create(Project project) {
        if (project.getProjectId() == null || project.getProjectId().isBlank()) {
            project.setProjectId(generateNextProjectId());
        }

        return projectRepository.save(project);
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public void update(String projectId, Project project) {
        projectRepository.update(projectId, project);
    }

    public void delete(String projectId) {
        projectRepository.delete(projectId);
    }

    public String generateNextProjectId() {
        int nextNumber = projectRepository.findAll().stream()
                .map(Project::getProjectId)
                .filter(Objects::nonNull)
                .filter(projectId -> projectId.matches("PJT\\d{3}"))
                .mapToInt(projectId -> Integer.parseInt(projectId.substring(3)))
                .max()
                .orElse(0) + 1;

        return String.format("PJT%03d", nextNumber);
    }
}