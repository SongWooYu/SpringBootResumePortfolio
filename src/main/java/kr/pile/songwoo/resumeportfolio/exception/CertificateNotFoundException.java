package kr.pile.songwoo.resumeportfolio.exception;

public class CertificateNotFoundException extends RuntimeException {

    public CertificateNotFoundException(String certificateId) {
        super("요청한 자격증 정보를 찾을 수 없습니다. certificateId=" + certificateId);
    }
}