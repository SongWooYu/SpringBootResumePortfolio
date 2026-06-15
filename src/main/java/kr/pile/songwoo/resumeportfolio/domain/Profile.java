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
public class Profile {

    private String name;
    private String department;
    private String grade;
    private String email;
    private String domain;
    private String githubUrl;
    private String introduction;
}