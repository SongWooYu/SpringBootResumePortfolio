package kr.pile.songwoo.resumeportfolio.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStoreService {

    private final Path rootPath;

    public FileStoreService(@Value("${file.upload-dir}") String uploadDir) {
        this.rootPath = Paths.get(uploadDir).toAbsolutePath().normalize();
    }

    public String storeCertificateImage(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return "";
        }

        String originalFilename = file.getOriginalFilename();
        String extension = extractExtension(originalFilename);
        String storedFileName = UUID.randomUUID() + extension;

        try {
            Path certificateDir = rootPath.resolve("certificates");
            Files.createDirectories(certificateDir);

            Path targetPath = certificateDir.resolve(storedFileName).normalize();
            file.transferTo(targetPath);

            return "/files/certificates/" + storedFileName;
        } catch (IOException e) {
            throw new IllegalStateException("자격증 이미지 저장 중 오류가 발생했습니다.", e);
        }
    }

    private String extractExtension(String originalFilename) {
        if (originalFilename == null || originalFilename.isBlank()) {
            return "";
        }

        int position = originalFilename.lastIndexOf(".");
        if (position == -1) {
            return "";
        }

        return originalFilename.substring(position);
    }
}