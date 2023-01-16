package webBoard.JianBoard.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class member {
    private String id;
    private String pw;
    private String name;
    private String birth;
    private String email;
}