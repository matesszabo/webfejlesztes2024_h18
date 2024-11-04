package hu.unideb.inf.edzesnaplo.service.mapper;

import hu.unideb.inf.edzesnaplo.data.entity.EdzesTipusEntity;
import hu.unideb.inf.edzesnaplo.service.dto.EdzesTipusDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EdzesTipusEntityMapper {
    EdzesTipusEntity toEntity(EdzesTipusDto edzesTipusDto);

    EdzesTipusDto toDto(EdzesTipusEntity edzesTipusEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EdzesTipusEntity partialUpdate(EdzesTipusDto edzesTipusDto, @MappingTarget EdzesTipusEntity edzesTipusEntity);
}