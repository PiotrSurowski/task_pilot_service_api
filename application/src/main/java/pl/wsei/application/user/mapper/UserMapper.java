package pl.wsei.application.user.mapper;

import pl.wsei.application.user.User;
import pl.wsei.application.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "role.id", target = "roleId")
    UserDto toDto(User user);

    User toModel(UserDto dto);
}
