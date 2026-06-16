package kr.pile.songwoo.resumeportfolio.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @Size(min = 2, max = 60)
    private String title;

    @NotBlank
    @Size(max = 30)
    private String category;

    @NotBlank
    @Size(min = 10, max = 150)
    private String summary;

    @NotBlank
    @Size(min = 20, max = 1000)
    private String description;

    @NotBlank
    @Size(max = 200)
    private String techStack;

    @NotBlank
    @Size(max = 200)
    private String role;

    @Pattern(regexp = "^(|https?://.+)$")
    private String githubUrl;

    @Pattern(regexp = "^(|https?://.+)$")
    private String demoUrl;

    private String imageFileName;
}