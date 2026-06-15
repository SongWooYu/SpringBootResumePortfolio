package kr.pile.songwoo.resumeportfolio.repository;

import kr.pile.songwoo.resumeportfolio.domain.Certificate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryCertificateRepository implements CertificateRepository {

    private final Map<String, Certificate> store = new LinkedHashMap<>();

    public MemoryCertificateRepository() {
        save(Certificate.builder()
                .certificateId("CERT001")
                .name("자격증명 입력 예정")
                .issuer("발급기관 입력 예정")
                .acquiredDate("취득일 입력 예정")
                .description("관리자 페이지에서 자격증 이미지와 정보를 등록할 수 있습니다.")
                .imageFileName("")
                .build());
    }

    @Override
    public List<Certificate> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Certificate> findById(String certificateId) {
        return Optional.ofNullable(store.get(certificateId));
    }

    @Override
    public Certificate save(Certificate certificate) {
        store.put(certificate.getCertificateId(), certificate);
        return certificate;
    }

    @Override
    public void delete(String certificateId) {
        store.remove(certificateId);
    }
}