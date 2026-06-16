package kr.pile.songwoo.resumeportfolio.exception;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProjectNotFoundException.class)
    public String handleProjectNotFound(
            ProjectNotFoundException exception,
            Model model,
            HttpServletResponse response
    ) {
        log.warn("Project not found exception occurred. message={}", exception.getMessage());

        response.setStatus(HttpStatus.NOT_FOUND.value());

        model.addAttribute("errorTitle", "프로젝트를 찾을 수 없습니다.");
        model.addAttribute("errorMessage", exception.getMessage());
        model.addAttribute("backUrl", "/projects");
        model.addAttribute("backLabel", "프로젝트 목록으로");

        return "error/404";
    }

    @ExceptionHandler(CertificateNotFoundException.class)
    public String handleCertificateNotFound(
            CertificateNotFoundException exception,
            Model model,
            HttpServletResponse response
    ) {
        log.warn("Certificate not found exception occurred. message={}", exception.getMessage());

        response.setStatus(HttpStatus.NOT_FOUND.value());

        model.addAttribute("errorTitle", "자격증 정보를 찾을 수 없습니다.");
        model.addAttribute("errorMessage", exception.getMessage());
        model.addAttribute("backUrl", "/certificates");
        model.addAttribute("backLabel", "자격증 목록으로");

        return "error/404";
    }
}