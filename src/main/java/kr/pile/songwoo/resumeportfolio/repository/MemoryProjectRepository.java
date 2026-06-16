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
                .title("Spring Boot 이력서 포트폴리오")
                .category("Spring Boot")
                .summary("기존 개인 홈페이지를 Spring Boot MVC 구조로 재구성한 기말 프로젝트")
                .description("Controller, Service, Repository, Thymeleaf, Form, Validation, Security, File Upload, Logging 기능을 적용한 개인 이력서 및 포트폴리오 프로젝트입니다.")
                .techStack("Java, Spring Boot, Thymeleaf, Spring Security, Validation, CSS")
                .role("기획, 화면 설계, 백엔드 구조 설계, 폼 처리, 보안 및 예외 처리 구현")
                .githubUrl("https://github.com/SongWooYu/SpringBootResumePortfolio")
                .demoUrl("")
                .imageFileName("")
                .build());

        save(Project.builder()
                .projectId("PJT002")
                .title("BookMarket 수업 예제 확장")
                .category("Spring MVC")
                .summary("수업에서 사용한 도서 쇼핑몰 구조를 분석하고 개인 포트폴리오 구조에 응용")
                .description("도서 목록, 상세 조회, 등록 폼, 파일 업로드, 유효성 검사 흐름을 포트폴리오 관리 기능으로 변환하기 위한 학습 프로젝트입니다.")
                .techStack("Java, Spring Boot, Thymeleaf, Validation, MultipartFile")
                .role("수업 예제 분석, URL 매핑 구조 설계, 폼 처리 흐름 응용")
                .githubUrl("https://github.com/SongWooYu/2026_BookMarket")
                .demoUrl("")
                .imageFileName("")
                .build());

        save(Project.builder()
                .projectId("PJT003")
                .title("홈 안전 모니터링 시스템")
                .category("IoT")
                .summary("센서와 서버를 연동하여 실내 상태를 모니터링하는 홈 안전 시스템")
                .description("센서 데이터 수집, 상태 판단, 알림 흐름을 중심으로 구성한 IoT 기반 안전 모니터링 프로젝트입니다.")
                .techStack("Raspberry Pi, Sensor, Java, Web Dashboard")
                .role("시스템 기획, 센서 데이터 흐름 설계, 대시보드 아이디어 구성")
                .githubUrl("https://github.com/SongWooYu/Home-Safety-System")
                .demoUrl("")
                .imageFileName("")
                .build());

        save(Project.builder()
                .projectId("PJT004")
                .title("WireGuard WebRTC 테스트")
                .category("Network")
                .summary("VPN 환경과 WebRTC 연결 방식을 테스트하기 위한 네트워크 실험 프로젝트")
                .description("WireGuard 기반 사설 네트워크 환경에서 브라우저 기반 통신과 연결 흐름을 실험하기 위한 테스트 프로젝트입니다.")
                .techStack("WireGuard, WebRTC, Linux, Network")
                .role("VPN 구성 실험, 네트워크 연결 테스트, 구조 검토")
                .githubUrl("https://github.com/SongWooYu/WireGuard_WebRTC_Test")
                .demoUrl("")
                .imageFileName("")
                .build());

        save(Project.builder()
                .projectId("PJT005")
                .title("머신러닝 기본 학습 프로젝트")
                .category("AI")
                .summary("scikit-learn 기반 머신러닝 모델 학습과 데이터 처리 흐름을 정리한 프로젝트")
                .description("분류, 회귀, 데이터 전처리, 모델 평가 등 머신러닝 기본 개념을 코드와 실습 중심으로 정리한 학습 프로젝트입니다.")
                .techStack("Python, scikit-learn, Pandas, Matplotlib")
                .role("데이터 전처리, 모델 학습, 결과 분석")
                .githubUrl("https://github.com/SongWooYu/ML_basic")
                .demoUrl("")
                .imageFileName("")
                .build());

        save(Project.builder()
                .projectId("PJT006")
                .title("딥러닝 기본 학습 프로젝트")
                .category("Deep Learning")
                .summary("TensorFlow 기반 딥러닝 모델 실습과 학습 과정을 정리한 프로젝트")
                .description("신경망 모델 구성, 학습, 평가, 결과 해석 과정을 실습하며 딥러닝 모델의 기본 구조를 학습한 프로젝트입니다.")
                .techStack("Python, TensorFlow, Deep Learning")
                .role("모델 구성, 학습 실험, 결과 정리")
                .githubUrl("https://github.com/SongWooYu/DL_Basic")
                .demoUrl("")
                .imageFileName("")
                .build());

        save(Project.builder()
                .projectId("PJT007")
                .title("가스 감지 딥러닝 프로젝트")
                .category("AI / Sensor")
                .summary("센서 데이터와 딥러닝을 결합한 이상 상태 감지 실험 프로젝트")
                .description("가스 또는 환경 센서 데이터를 기반으로 이상 상태를 분류하거나 판단하는 흐름을 실험하기 위한 AI 응용 프로젝트입니다.")
                .techStack("Python, TensorFlow, Sensor Data, Classification")
                .role("데이터 구조 검토, 모델 학습 아이디어 구성, 결과 분석")
                .githubUrl("https://github.com/SongWooYu/DL_Gass")
                .demoUrl("")
                .imageFileName("")
                .build());

        save(Project.builder()
                .projectId("PJT008")
                .title("AI 플랫폼 학습 정리")
                .category("AI Platform")
                .summary("AI 플랫폼과 모델 활용 흐름을 정리한 학습형 프로젝트")
                .description("다양한 AI 플랫폼, 모델 실행 환경, 데이터 처리 방식을 비교하고 학습 내용을 정리하기 위한 프로젝트입니다.")
                .techStack("Python, AI Platform, Model Test")
                .role("플랫폼 비교, 실습 코드 정리, 학습 내용 문서화")
                .githubUrl("https://github.com/SongWooYu/ai_platforms")
                .demoUrl("")
                .imageFileName("")
                .build());

        save(Project.builder()
                .projectId("PJT009")
                .title("Python 크롤링 실습")
                .category("Data")
                .summary("Python을 활용하여 웹 데이터 수집과 전처리 과정을 실습한 프로젝트")
                .description("웹 페이지에서 필요한 데이터를 수집하고, 분석 가능한 형태로 정리하는 크롤링 및 데이터 전처리 실습 프로젝트입니다.")
                .techStack("Python, Crawling, BeautifulSoup, Data Processing")
                .role("데이터 수집 코드 작성, 구조 분석, 결과 정리")
                .githubUrl("https://github.com/SongWooYu/python_crawling")
                .demoUrl("")
                .imageFileName("")
                .build());

        save(Project.builder()
                .projectId("PJT010")
                .title("Push App 테스트")
                .category("Application")
                .summary("알림 기능과 애플리케이션 동작 흐름을 실험하기 위한 프로젝트")
                .description("사용자 알림, 앱 동작 흐름, 서버와 클라이언트 간의 이벤트 전달 방식을 실험하기 위한 응용 프로젝트입니다.")
                .techStack("Web App, Push Notification, JavaScript")
                .role("기능 테스트, 화면 구성, 동작 흐름 검토")
                .githubUrl("https://github.com/SongWooYu/push-app")
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