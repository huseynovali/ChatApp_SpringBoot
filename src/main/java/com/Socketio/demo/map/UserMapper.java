package com.Socketio.demo.map;


import com.Socketio.demo.dto.response.UserResponse;
import com.Socketio.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    User userResponseToUser(UserResponse userResponse);

    UserResponse userToUserResponse(User user);
}
