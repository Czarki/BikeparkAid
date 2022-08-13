package pl.czrmjd.bikeparkaid.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "verification_tokens")
@NoArgsConstructor
public class VerificationTokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "token")
    private String token;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "expires_at")
    private Date expiresAt;
    @Column(name = "confirmed_at")
    private Date confirmedAt;
    @Column(name = "user_email")
    private String userEmail;
}