package pl.wsei.application.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static pl.wsei.application.user.Permission.*;


@RequiredArgsConstructor
public enum Role {

  USER(3, Collections.emptySet()),
  ADMIN(1,
          Set.of(
                  ADMIN_READ,
                  ADMIN_UPDATE,
                  ADMIN_DELETE,
                  ADMIN_CREATE,
                  MANAGER_READ,
                  MANAGER_UPDATE,
                  MANAGER_DELETE,
                  MANAGER_CREATE
          )
  ),
  MANAGER(2,
          Set.of(
                  MANAGER_READ,
                  MANAGER_UPDATE,
                  MANAGER_DELETE,
                  MANAGER_CREATE
          )
  );

  Role(int id, Set<Permission> permissions) {
      this.permissions = permissions;
      this.id = id;
  }

  @Getter
  private final Set<Permission> permissions;

  @Getter
  private final Integer id;

  public List<SimpleGrantedAuthority> getAuthorities() {
    var authorities = getPermissions()
            .stream()
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toList());
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return authorities;
  }

  public Role getRoleById(int id){
    return Arrays.stream(Role.values()).filter(role -> id == role.getId())
            .findFirst()
            .orElse(null);
  }
}
