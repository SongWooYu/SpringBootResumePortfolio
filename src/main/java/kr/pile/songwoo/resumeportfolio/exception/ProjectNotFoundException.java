package kr.pile.songwoo.resumeportfolio.exception;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(String projectId) {
        super("요청한 프로젝트를 찾을 수 없습니다. projectId=" + projectId);
    }
}