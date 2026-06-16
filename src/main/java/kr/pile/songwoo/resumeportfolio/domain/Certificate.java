package kr.pile.songwoo.resumeportfolio.domain;

import jakarta.validation.constraints.NotBlank;
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
public class Certificate {

    private String certificateId;

    @NotBlank
    @Size(min = 2, max = 60)
    private String name;

    @NotBlank
    @Size(min = 2, max = 60)
    private String issuer;

    @NotBlank
    @Size(min = 8, max = 20)
    private String acquiredDate;

    @NotBlank
    @Size(min = 10, max = 500)
    private String description;

    private String imagePath;
}