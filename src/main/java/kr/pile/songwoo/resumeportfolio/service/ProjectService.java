package kr.pile.songwoo.resumeportfolio.service;


import kr.pile.songwoo.resumeportfolio.domain.Project;
import kr.pile.songwoo.resumeportfolio.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public void update(String projectId, Project project) {
        projectRepository.update(projectId, project);
    }

    public void delete(String projectId) {
        projectRepository.delete(projectId);
    }
}