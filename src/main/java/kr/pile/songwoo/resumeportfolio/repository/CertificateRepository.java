package kr.pile.songwoo.resumeportfolio.repository;

import kr.pile.songwoo.resumeportfolio.domain.Certificate;

import java.util.List;
import java.util.Optional;

public interface CertificateRepository {

    List<Certificate> findAll();

    Optional<Certificate> findById(String certificateId);

    Certificate save(Certificate certificate);

    void delete(String certificateId);
}