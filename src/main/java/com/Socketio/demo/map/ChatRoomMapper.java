package com.Socketio.demo.map;


import com.Socketio.demo.dto.response.ChatRoomResponse;
import com.Socketio.demo.model.ChatRoom;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ChatRoomMapper {

        ChatRoomResponse chatRoomToChatRoomResponse(ChatRoom chatRoom);

        ChatRoom chatRoomResponseToChatRoom(ChatRoomResponse chatRoomResponse);
}
