package pl.wsei.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Integer id;
    private int roleId;
    private String login;
    private String email;
}
