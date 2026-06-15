package kr.pile.songwoo.resumeportfolio.repository;

import kr.pile.songwoo.resumeportfolio.domain.Project;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryProjectRepository implements ProjectRepository {

    private final Map<String, Project> store = new LinkedHashMap<>();

    public MemoryProjectRepository() {
        save(Project.builder()
                .projectId("PJT001")
                .title("개인 이력서 및 포트폴리오 웹사이트")
                .category("Spring Boot")
                .summary("Spring Boot MVC 구조를 활용한 개인 이력서 관리 웹 애플리케이션")
                .description("프로필, 이력서, 기술스택, 프로젝트, 자격증 정보를 관리하고 보여주는 웹 애플리케이션입니다.")
                .techStack("Java, Spring Boot, Thymeleaf, HTML, CSS")
                .role("기획, 설계, 백엔드, 화면 구현")
                .githubUrl("https://github.com/SongWooYu/SpringBootResumePortfolio")
                .demoUrl("")
                .imageFileName("")
                .build());

        save(Project.builder()
                .projectId("PJT002")
                .title("도서 쇼핑몰 실습 변형")
                .category("Web Practice")
                .summary("수업의 도서 쇼핑몰 구조를 포트폴리오 관리 구조로 변환")
                .description("도서 목록, 상세, 등록, 파일 업로드 예제를 개인 프로젝트 관리 기능으로 확장하는 실습입니다.")
                .techStack("Java, Spring MVC, Thymeleaf")
                .role("수업 예제 분석 및 구조 변환")
                .githubUrl("")
                .demoUrl("")
                .imageFileName("")
                .build());

        save(Project.builder()
                .projectId("PJT003")
                .title("IoT 센서 모니터링 시스템")
                .category("IoT")
                .summary("센서 데이터를 수집하고 웹 화면에서 상태를 확인하는 시스템")
                .description("센서 데이터 수집, 서버 전송, 웹 대시보드 표시를 목표로 하는 IoT 시스템 아이디어입니다.")
                .techStack("Microcontroller, Sensor, Java, Web")
                .role("시스템 기획 및 구조 설계")
                .githubUrl("")
                .demoUrl("")
                .imageFileName("")
                .build());
    }

    @Override
    public List<Project> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Project> findById(String projectId) {
        return Optional.ofNullable(store.get(projectId));
    }

    @Override
    public List<Project> findByKeyword(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return findAll();
        }

        String lowerKeyword = keyword.toLowerCase(Locale.ROOT);

        return store.values().stream()
                .filter(project ->
                        contains(project.getTitle(), lowerKeyword)
                                || contains(project.getCategory(), lowerKeyword)
                                || contains(project.getSummary(), lowerKeyword)
                                || contains(project.getDescription(), lowerKeyword)
                                || contains(project.getTechStack(), lowerKeyword)
                )
                .toList();
    }

    @Override
    public Project save(Project project) {
        store.put(project.getProjectId(), project);
        return project;
    }

    @Override
    public void update(String projectId, Project project) {
        project.setProjectId(projectId);
        store.put(projectId, project);
    }

    @Override
    public void delete(String projectId) {
        store.remove(projectId);
    }

    private boolean contains(String value, String keyword) {
        return value != null && value.toLowerCase(Locale.ROOT).contains(keyword);
    }
}