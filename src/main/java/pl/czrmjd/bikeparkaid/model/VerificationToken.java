package pl.czrmjd.bikeparkaid.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class VerificationToken {

    private Integer id;
    private String token;
    private Date createdAt;
    private Date expiresAt;
    private Date confirmedAt;
    private String userEmail;

    public VerificationToken(String token,
                             Date createdAt,
                             Date expiresAt,
                             Date confirmedAt,
                             String userEmail) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.confirmedAt = confirmedAt;
        this.userEmail = userEmail;
    }
}
