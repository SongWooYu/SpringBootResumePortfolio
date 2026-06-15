package kr.pile.songwoo.resumeportfolio.repository;


import kr.pile.songwoo.resumeportfolio.domain.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {

    List<Project> findAll();

    Optional<Project> findById(String projectId);

    List<Project> findByKeyword(String keyword);

    Project save(Project project);

    void update(String projectId, Project project);

    void delete(String projectId);
}