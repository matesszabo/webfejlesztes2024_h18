package hu.unideb.inf.edzesnaplo.service.mapper;

import hu.unideb.inf.edzesnaplo.data.entity.EdzesTipusEntity;
import hu.unideb.inf.edzesnaplo.service.dto.EdzesTipusDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface EdzesTipusMapper {

    @Mapping(source = "id", target = "id")
    EdzesTipusDto edzesTipusEntityToDto(EdzesTipusEntity entity);
    List<EdzesTipusDto> edzesTipusEntityListToDtoList(List<EdzesTipusEntity> entities);

    EdzesTipusEntity edzesTipusDtoToEntity(EdzesTipusDto dto);
    List<EdzesTipusEntity> edzesTipusDtoListToEntityList(List<EdzesTipusDto> dtos);
}
