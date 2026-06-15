package kr.pile.songwoo.resumeportfolio.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    private String projectId;
    private String title;
    private String category;
    private String summary;
    private String description;
    private String techStack;
    private String role;
    private String githubUrl;
    private String demoUrl;
    private String imageFileName;
}