package kr.pile.songwoo.resumeportfolio.service;

import kr.pile.songwoo.resumeportfolio.domain.Certificate;
import kr.pile.songwoo.resumeportfolio.exception.CertificateNotFoundException;
import kr.pile.songwoo.resumeportfolio.repository.CertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CertificateService {

    private final CertificateRepository certificateRepository;
    private final FileStoreService fileStoreService;

    public List<Certificate> findAll() {
        return certificateRepository.findAll();
    }

    public Certificate findById(String certificateId) {
        return certificateRepository.findById(certificateId)
                .orElseThrow(() -> new CertificateNotFoundException(certificateId));
    }

    public Certificate create(Certificate certificate, MultipartFile imageFile) {
        if (certificate.getCertificateId() == null || certificate.getCertificateId().isBlank()) {
            certificate.setCertificateId(generateNextCertificateId());
        }

        String uploadedImagePath = fileStoreService.storeCertificateImage(imageFile);

        if (!uploadedImagePath.isBlank()) {
            certificate.setImagePath(uploadedImagePath);
        }

        return certificateRepository.save(certificate);
    }

    public void delete(String certificateId) {
        certificateRepository.delete(certificateId);
    }

    public String generateNextCertificateId() {
        int nextNumber = certificateRepository.findAll().stream()
                .map(Certificate::getCertificateId)
                .filter(Objects::nonNull)
                .filter(certificateId -> certificateId.matches("CERT\\d{3}"))
                .mapToInt(certificateId -> Integer.parseInt(certificateId.substring(4)))
                .max()
                .orElse(0) + 1;

        return String.format("CERT%03d", nextNumber);
    }
}