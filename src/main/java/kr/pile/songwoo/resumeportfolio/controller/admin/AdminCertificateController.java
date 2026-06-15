package kr.pile.songwoo.resumeportfolio.controller.admin;

import kr.pile.songwoo.resumeportfolio.domain.Certificate;
import kr.pile.songwoo.resumeportfolio.service.CertificateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/certificates")
public class AdminCertificateController {

    private final CertificateService certificateService;

    @GetMapping("/add")
    public String addForm(Model model) {
        log.info("Certificate add form requested");

        Certificate certificate = Certificate.builder()
                .certificateId(certificateService.generateNextCertificateId())
                .build();

        model.addAttribute("certificate", certificate);

        return "admin/certificates/addForm";
    }

    @PostMapping("/add")
    public String addCertificate(
            @ModelAttribute("certificate") Certificate certificate,
            @RequestParam("imageFile") MultipartFile imageFile,
            RedirectAttributes redirectAttributes
    ) {
        log.info("Certificate add requested. certificateId={}, name={}", certificate.getCertificateId(), certificate.getName());

        certificateService.create(certificate, imageFile);

        redirectAttributes.addFlashAttribute("message", "자격증 정보가 등록되었습니다.");

        return "redirect:/certificates";
    }
}