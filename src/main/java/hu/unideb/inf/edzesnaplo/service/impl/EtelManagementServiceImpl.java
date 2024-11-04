package hu.unideb.inf.edzesnaplo.service.impl;

import hu.unideb.inf.edzesnaplo.data.entity.EtelEntity;
import hu.unideb.inf.edzesnaplo.data.repository.EtelRepository;
import hu.unideb.inf.edzesnaplo.service.EtelManagementService;
import hu.unideb.inf.edzesnaplo.service.dto.EtelDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EtelManagementServiceImpl implements EtelManagementService {
    @Autowired
    EtelRepository repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public EtelDto findById(Long id) {
        EtelEntity entity = repo.getReferenceById(id);
        EtelDto dto = new EtelDto();

        dto.setId(entity.getId());
        dto.setKaloria(entity.getKaloria());
        dto.setMennyiseg(entity.getMennyiseg());
        dto.setNev(entity.getNev());
        dto.setMennyisegiEgyseg(entity.getMennyisegiEgyseg());

        return dto;
    }

    @Override
    public List<EtelDto> findAll() {
        List<EtelEntity> entities = repo.findAll();
        List<EtelDto> dtos = new ArrayList<>();

        dtos = mapper.map(entities, new TypeToken<List<EtelDto>>(){}.getType());
        return dtos;
    }

    @Override
    public EtelDto save(EtelDto etel) {
        /*return mapper.map(repo.save(mapper.map(etel, EtelEntity.class))
                , EtelDto.class);*/

        EtelEntity entity = mapper.map(etel, EtelEntity.class);
        entity = repo.save(entity);

        EtelDto dto = new EtelDto();
        dto = mapper.map(entity, EtelDto.class);

        return dto;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
