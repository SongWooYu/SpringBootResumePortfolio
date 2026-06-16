# SongWoo Resume Portfolio

Spring Boot 기반 개인 이력서 및 포트폴리오 관리 웹 애플리케이션입니다.  
기존 정적 HTML 중심의 개인 홈페이지를 Spring Boot MVC 구조로 재구성하고, 수업에서 다룬 Controller, Thymeleaf, Form, Validation, File Upload, Security, Exception Handling, Logging 기능을 적용하는 것을 목표로 합니다.

> 본 프로젝트는 1학기 Spring Boot 기말 과제용 프로젝트입니다.  
> 데이터베이스 연동은 2학기 범위로 분리되어 있어, 현재 프로젝트에서는 메모리 기반 저장소를 사용합니다.

---

## 1. 프로젝트 개요

### 주제

**SongWoo의 이력서 및 포트폴리오**

개인 프로필, 이력서, 기술스택, 프로젝트, 자격증 정보를 웹 화면에서 조회하고, 관리자 화면에서 프로젝트와 자격증 데이터를 관리할 수 있는 포트폴리오 사이트입니다.

### 개발 목적

- 기존 HTML 기반 개인 홈페이지를 Spring Boot 프로젝트 구조로 변환
- MVC 패턴을 적용하여 Controller, Service, Repository 역할 분리
- Thymeleaf를 이용한 서버 사이드 렌더링 구현
- 관리자 기능을 통해 프로젝트 및 자격증 정보 관리
- 자격증 증빙 이미지를 업로드하고 화면에 표시
- Spring Security를 이용한 관리자 접근 제한
- 예외 처리 페이지와 요청 로그 기록 기능 적용

---

## 2. 주요 기능

### 사용자 페이지

| URL | 기능 |
|---|---|
| `/` | 메인 포트폴리오 대시보드 |
| `/profile` | 프로필 및 학습 방향 소개 |
| `/resume` | 문서형 이력서 페이지 |
| `/skills` | 기술스택 정리 |
| `/projects` | 프로젝트 목록 및 검색 |
| `/projects/{projectId}` | 프로젝트 상세 조회 |
| `/certificates` | 자격증 및 증빙 이미지 목록 |
| `/contact` | 연락처 페이지 |

### 관리자 페이지

| URL | 기능 |
|---|---|
| `/admin` | 관리자 메인 |
| `/admin/projects/add` | 프로젝트 등록 |
| `/admin/projects/{projectId}/edit` | 프로젝트 수정 |
| `/admin/projects/{projectId}/delete` | 프로젝트 삭제 |
| `/admin/certificates/add` | 자격증 등록 및 이미지 업로드 |
| `/admin/certificates/{certificateId}/delete` | 자격증 삭제 |

### 인증 정보

과제 시연용 관리자 계정입니다.

```text
ID: admin
PW: admin1234
```

> 실제 서비스에서는 화면에 관리자 계정 정보를 노출하지 않고, DB 기반 사용자 관리와 운영 환경 보안 설정을 별도로 적용해야 합니다.

---

## 3. 기술 스택

### Backend

- Java
- Spring Boot
- Spring MVC
- Spring Security
- Bean Validation
- Lombok

### View

- Thymeleaf
- Thymeleaf Layout Fragment
- Thymeleaf Security Extras
- HTML
- CSS

### Storage

- Memory Repository
- Local Upload Directory

### Development Tool

- IntelliJ IDEA
- Gradle
- Git / GitHub

---

## 4. 수업 내용 적용 현황

| 수업 내용 | 프로젝트 적용 위치 |
|---|---|
| Spring Boot 기본 구조 | 전체 프로젝트 구조, `application.properties` |
| Controller 구현 | `HomeController`, `ProjectController`, `CertificateController`, `AdminProjectController` 등 |
| 요청 처리 메서드 파라미터 | `@RequestParam`, `@PathVariable`, `@ModelAttribute` |
| Thymeleaf | `templates` 폴더의 HTML 화면 |
| Fragment | 공통 header/footer 분리 |
| Form 처리 | 프로젝트/자격증 등록 및 수정 화면 |
| File Upload | 자격증 증빙 이미지 업로드 |
| Validation | 프로젝트/자격증 입력값 검증 |
| Message Properties | 검증 실패 메시지 관리 |
| Spring Security | `/admin/**` 접근 제한, 로그인/로그아웃 |
| Exception Handling | 사용자용 404/403/500 오류 페이지 |
| Logging | 요청/응답 로그 인터셉터 |

---

## 5. 프로젝트 구조

```text
src/main/java/kr/pile/songwoo/resumeportfolio
├── config
│   ├── SecurityConfig.java
│   ├── WebConfig.java
│   └── WebResourceConfig.java
├── controller
│   ├── AuthController.java
│   ├── CertificateController.java
│   ├── ContactController.java
│   ├── HomeController.java
│   ├── ProfileController.java
│   ├── ProjectController.java
│   ├── ResumeController.java
│   ├── SkillController.java
│   └── admin
│       ├── AdminCertificateController.java
│       ├── AdminController.java
│       └── AdminProjectController.java
├── domain
│   ├── Certificate.java
│   └── Project.java
├── exception
│   ├── CertificateNotFoundException.java
│   ├── GlobalExceptionHandler.java
│   └── ProjectNotFoundException.java
├── interceptor
│   └── LogInterceptor.java
├── repository
│   ├── CertificateRepository.java
│   ├── MemoryCertificateRepository.java
│   ├── MemoryProjectRepository.java
│   └── ProjectRepository.java
├── service
│   ├── CertificateService.java
│   ├── FileStoreService.java
│   └── ProjectService.java
└── validator
    └── ...
```

```text
src/main/resources
├── application.properties
├── messages.properties
├── static
│   ├── css
│   │   └── style.css
│   └── images
└── templates
    ├── admin
    ├── certificates
    ├── error
    ├── module
    ├── projects
    ├── home.html
    ├── profile.html
    ├── resume.html
    └── skills.html
```

---

## 6. 실행 방법

### 6.1 프로젝트 클론

```bash
git clone https://github.com/SongWooYu/SpringBootResumePortfolio.git
cd SpringBootResumePortfolio
```

### 6.2 애플리케이션 실행

```bash
./gradlew bootRun
```

Windows 환경에서는 다음 명령을 사용할 수 있습니다.

```bash
gradlew.bat bootRun
```

### 6.3 접속 주소

```text
http://localhost:8080/ResumePortfolio/
```

주요 확인 주소는 다음과 같습니다.

```text
http://localhost:8080/ResumePortfolio/profile
http://localhost:8080/ResumePortfolio/resume
http://localhost:8080/ResumePortfolio/skills
http://localhost:8080/ResumePortfolio/projects
http://localhost:8080/ResumePortfolio/certificates
http://localhost:8080/ResumePortfolio/admin
```

---

## 7. 설정 정보

`src/main/resources/application.properties`

```properties
spring.application.name=ResumePortfolio

server.servlet.context-path=/ResumePortfolio

spring.servlet.multipart.enabled=true
spring.servlet.multipart.file-size-threshold=2KB
spring.servlet.multipart.max-file-size=5MB
spring.servlet.multipart.max-request-size=20MB

file.upload-dir=uploads/

spring.messages.basename=messages
spring.messages.encoding=UTF-8

logging.level.kr.pile.songwoo.resumeportfolio=INFO
logging.file.name=logs/resume-portfolio.log
```

### 업로드 파일 저장 위치

자격증 이미지 업로드 파일은 프로젝트 루트의 `uploads/` 아래에 저장됩니다.

```text
uploads/
└── certificates/
```

`uploads/`는 실행 중 생성되는 파일이므로 Git 관리 대상에서 제외합니다.

### 로그 파일 저장 위치

요청 로그는 콘솔과 아래 파일에 기록됩니다.

```text
logs/resume-portfolio.log
```

`logs/` 역시 Git 관리 대상에서 제외합니다.

---

## 8. 주요 구현 설명

### 8.1 MVC 계층 분리

프로젝트는 Controller, Service, Repository 계층으로 분리되어 있습니다.

- Controller: URL 요청 처리와 화면 이동 담당
- Service: 비즈니스 로직 처리
- Repository: 메모리 기반 데이터 저장 및 조회 담당
- Domain: 프로젝트와 자격증 데이터 구조 정의

DB 연동 없이도 계층 구조를 분리하여, 추후 DB 연동 시 Repository 구현체를 교체할 수 있도록 구성했습니다.

---

### 8.2 프로젝트 목록 및 검색

프로젝트 목록 페이지에서는 `keyword` 요청 파라미터를 사용하여 프로젝트명, 분류, 요약, 상세 설명, 기술스택을 기준으로 검색합니다.

```text
/projects?keyword=AI
/projects?keyword=Spring
/projects?keyword=WireGuard
```

적용 기술:

- `@RequestParam`
- Thymeleaf 반복 출력
- Memory Repository 검색

---

### 8.3 프로젝트 상세 조회

프로젝트 상세 페이지는 URL 경로에 포함된 프로젝트 ID를 기준으로 조회합니다.

```text
/projects/PJT001
```

적용 기술:

- `@PathVariable`
- Service 계층 조회
- 없는 프로젝트 ID 접근 시 사용자용 404 오류 페이지 처리

---

### 8.4 관리자 프로젝트 관리

관리자 페이지에서는 프로젝트를 등록, 수정, 삭제할 수 있습니다.

적용 기술:

- `@ModelAttribute`
- Form Binding
- `@Valid`
- `BindingResult`
- Validation Message
- Redirect 처리

---

### 8.5 자격증 이미지 업로드

자격증 등록 시 증빙 이미지를 함께 업로드할 수 있습니다.  
업로드된 파일은 로컬 `uploads/` 디렉터리에 저장되고, 화면에서는 `/files/**` 경로를 통해 표시됩니다.

적용 기술:

- `MultipartFile`
- File Upload
- 정적 리소스 매핑
- `.gitignore`를 통한 업로드 파일 제외

---

### 8.6 유효성 검사

프로젝트와 자격증 등록 폼에는 입력값 검증을 적용했습니다.  
검증 실패 시 `messages.properties`에 정의된 한글 메시지를 화면에 출력합니다.

적용 기술:

- Bean Validation
- `@NotBlank`
- `@Size`
- `@Pattern`
- `BindingResult`
- `messages.properties`

---

### 8.7 Spring Security

`/admin/**` 경로는 관리자 로그인 이후 접근할 수 있도록 제한했습니다.  
비로그인 사용자가 관리자 페이지에 접근하면 로그인 페이지로 이동합니다.

적용 기술:

- Spring Security
- `SecurityFilterChain`
- `InMemoryUserDetailsManager`
- `BCryptPasswordEncoder`
- Thymeleaf Security `sec:authorize`

---

### 8.8 예외 처리

존재하지 않는 프로젝트 또는 자격증에 접근할 경우 Whitelabel Error Page 대신 사용자용 오류 페이지를 표시합니다.

적용 기술:

- Custom Exception
- `@ControllerAdvice`
- `@ExceptionHandler`
- `templates/error/404.html`
- `templates/error/403.html`
- `templates/error/500.html`

---

### 8.9 요청 로그 인터셉터

모든 주요 요청에 대해 HTTP Method, URI, Controller Method, 응답 상태, 처리 시간을 로그로 기록합니다.

적용 기술:

- `HandlerInterceptor`
- `WebMvcConfigurer`
- `preHandle`
- `afterCompletion`
- SLF4J Logging

예시 로그:

```text
[REQUEST] GET /ResumePortfolio/projects -> ProjectController.projects() client=127.0.0.1
[RESPONSE] GET /ResumePortfolio/projects status=200 duration=8ms
```

---

## 9. 화면 구성

### 주요 화면

- 메인 대시보드
- 프로필 페이지
- 문서형 이력서 페이지
- 기술스택 페이지
- 프로젝트 목록 및 상세 페이지
- 자격증 갤러리 페이지
- 관리자 로그인 페이지
- 관리자 프로젝트/자격증 등록 페이지
- 사용자용 오류 페이지

### 디자인 방향

- 과제 제출용으로 기능 구조가 명확히 보이도록 구성
- 포트폴리오 사이트처럼 보이도록 현대적인 카드형 레이아웃 적용
- CSS 기반 막대 시각화로 프로젝트/자격증 분포 표현
- 별도 JavaScript 차트 라이브러리는 사용하지 않음
- 모바일 화면에서도 주요 콘텐츠가 1열로 정렬되도록 반응형 처리

---

## 10. Git 관리 기준

다음 파일과 디렉터리는 Git 관리 대상에서 제외합니다.

```text
uploads/
logs/
build/
.gradle/
.idea/
```

제외 이유:

- `uploads/`: 사용자가 실행 중 업로드하는 파일
- `logs/`: 실행 로그
- `build/`: Gradle 빌드 결과물
- `.gradle/`: Gradle 캐시
- `.idea/`: IntelliJ 개인 설정

---

## 11. 과제 범위 판단

이번 프로젝트에서는 다음 기능을 의도적으로 제외했습니다.

| 제외 항목 | 제외 이유 |
|---|---|
| Database | DB 연동은 2학기 학습 범위 |
| JPA | DB 미사용으로 인해 적용하지 않음 |
| REST API | 이번 과제는 MVC 화면 중심 구현 |
| OAuth2 / JWT | 현재 수업 범위 대비 과도함 |
| 외부 차트 라이브러리 | CSS 기반 시각화로 충분히 구현 가능 |
| 배포 자동화 | 제출 요구사항이 로컬 실행 및 GitHub 제출 중심 |

---

## 12. AI 활용 방식

본 프로젝트는 사람이 전체 구조와 기능 범위를 결정하고, 반복적인 코드 작성과 CSS 개선, 오류 원인 분석, 코드 리뷰에 AI를 보조적으로 활용했습니다.

활용 방식은 다음과 같습니다.

- 프로젝트 기능 범위 정리
- 수업 내용과 과제 요구사항 간 매핑
- Controller, Service, Repository 구조 검토
- Thymeleaf 화면 구성 보조
- CSS 디자인 개선과 반응형 레이아웃 정리
- Validation 및 Security 오류 분석
- GitHub 코드 리뷰 및 개선 방향 도출
- 보고서 작성에 사용할 기술 설명 정리

단, DB 연동이나 과제 범위를 넘어서는 기술은 의도적으로 제외하고, 수업에서 학습한 Spring Boot MVC 중심 구조를 유지했습니다.

---

## 13. 향후 개선 방향

- DB 연동을 통한 데이터 영속화
- 관리자 계정 DB 관리
- 프로젝트 이미지 업로드 기능 확장
- 자격증 검색 기능 추가
- REST API 제공
- 배포 환경 구성
- 사용자별 포트폴리오 관리 기능 확장

---

## 14. Repository

```text
https://github.com/SongWooYu/SpringBootResumePortfolio
```