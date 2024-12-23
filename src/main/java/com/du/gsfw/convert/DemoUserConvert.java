package com.du.gsfw.convert;

import com.du.gsfw.model.dto.request.DemoUserAddRequestDTO;
import com.du.gsfw.model.dto.response.DemoUserResponseDTO;
import com.du.gsfw.model.entity.DemoUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring" ,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DemoUserConvert {
    DemoUserConvert INSTANCE = Mappers.getMapper( DemoUserConvert.class );

    @Mapping(target = "userName", source = "username")
    DemoUserResponseDTO toDto(DemoUser source);

    DemoUser toEntity(DemoUserAddRequestDTO source);
}
