package com.Socketio.demo.map;


import com.Socketio.demo.dto.request.ChatMessageRequest;
import com.Socketio.demo.dto.response.ChatMessageResponse;
import com.Socketio.demo.model.ChatMessage;
import com.Socketio.demo.repository.ChatMessageRepo;
import org.apache.logging.log4j.message.Message;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MessageMapper {

    ChatMessage messageResponseToMessage(ChatMessageResponse messageResponse);

    ChatMessageResponse messageToMessageResponse(ChatMessage message);

    ChatMessage messageRequestToMessage(ChatMessageRequest messageRequest);

}
