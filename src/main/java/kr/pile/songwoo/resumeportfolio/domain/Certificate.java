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
public class Certificate {

    private String certificateId;
    private String name;
    private String issuer;
    private String acquiredDate;
    private String description;
    private String imagePath;
}