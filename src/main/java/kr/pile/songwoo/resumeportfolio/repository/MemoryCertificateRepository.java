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
                .name("정보처리산업기사")
                .issuer("한국산업인력공단")
                .acquiredDate("2026-06-12")
                .description("소프트웨어 개발, 데이터베이스, 시스템 운영 등 정보처리 분야의 실무 역량을 증명하는 국가기술자격입니다.")
                .imagePath("/images/certificates/information-processing-industrial-engineer.png")
                .build());

        save(Certificate.builder()
                .certificateId("CERT002")
                .name("네트워크관리사 2급")
                .issuer("한국정보통신자격협회")
                .acquiredDate("2026-06-09")
                .description("네트워크 구축, 운용, 관리에 필요한 기본 지식과 실무 능력을 증명하는 자격입니다.")
                .imagePath("/images/certificates/network-manager-2.png")
                .build());

        save(Certificate.builder()
                .certificateId("CERT003")
                .name("리눅스마스터 2급")
                .issuer("한국정보통신진흥협회")
                .acquiredDate("2026-04-03")
                .description("리눅스 운영체제의 기본 명령어, 시스템 관리, 네트워크 설정 능력을 증명하는 국가공인 자격입니다.")
                .imagePath("/images/certificates/linux-master-2.png")
                .build());

        save(Certificate.builder()
                .certificateId("CERT004")
                .name("지게차운전기능사")
                .issuer("한국산업인력공단")
                .acquiredDate("2023-11-24")
                .description("지게차 운전 및 안전관리 능력을 증명하는 국가기술자격입니다.")
                .imagePath("/images/certificates/forklift-operator.png")
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