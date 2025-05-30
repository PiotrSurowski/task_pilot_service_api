package pl.wsei.token;

import pl.wsei.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "activation_token")
public class Token {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activation_token_seq")
  @SequenceGenerator(name = "activation_token_seq", sequenceName = "activation_token_seq", allocationSize = 1)
  public Integer id;

  @Column(unique = true)
  public String token;

  @Enumerated(EnumType.STRING)
  public TokenType tokenType = TokenType.BEARER;

  public boolean revoked;

  public boolean expired;

  @Column(name = "expiry_date")
  public Date expiryDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  public User user;
}
