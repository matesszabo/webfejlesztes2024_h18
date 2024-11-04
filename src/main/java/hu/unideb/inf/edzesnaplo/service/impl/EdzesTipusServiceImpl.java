package hu.unideb.inf.edzesnaplo.service.impl;

import hu.unideb.inf.edzesnaplo.data.entity.EdzesTipusEntity;
import hu.unideb.inf.edzesnaplo.data.repository.EdzesTipusRepository;
import hu.unideb.inf.edzesnaplo.service.EdzesTipusService;
import hu.unideb.inf.edzesnaplo.service.dto.EdzesTipusDto;
import hu.unideb.inf.edzesnaplo.service.mapper.EdzesTipusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdzesTipusServiceImpl implements EdzesTipusService {
    @Autowired
    EdzesTipusRepository repository;

    @Autowired
    EdzesTipusMapper mapper;

    @Override
    public EdzesTipusDto getById(Long id) {
        EdzesTipusEntity entity = repository.getReferenceById(id);
        EdzesTipusDto dto = new EdzesTipusDto();

        dto = mapper.edzesTipusEntityToDto(entity);
        return dto;
    }

    @Override
    public List<EdzesTipusDto> getAll() {
        return mapper.edzesTipusEntityListToDtoList(repository.findAll());
    }

    @Override
    public EdzesTipusDto save(EdzesTipusDto edzesTipusDto) {
        EdzesTipusEntity entity = mapper.edzesTipusDtoToEntity(edzesTipusDto);
        entity = repository.save(entity);

        EdzesTipusDto dto = mapper.edzesTipusEntityToDto(entity);
        return dto;
    }
}
