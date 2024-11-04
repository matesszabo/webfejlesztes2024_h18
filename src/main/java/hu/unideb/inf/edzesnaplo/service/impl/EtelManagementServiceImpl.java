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

    @Override
    public List<EtelDto> findByNev(String nev) {
        List<EtelEntity> szurt = new ArrayList<>();

        szurt = repo.findAll()
                .stream()
                .filter(x -> x.getNev().contains(nev))
                .toList();

        return mapper.map(szurt, new TypeToken<List<EtelDto>>(){}.getType());
    }

    @Override
    public List<EtelDto> findByNevDb(String nev) {
        return mapper.map(repo.findAllByNevContains(nev), new TypeToken<List<EtelDto>>(){}.getType());
    }

    @Override
    public List<EtelDto> findByAny(String nev, Integer kaloria, Float mennyiseg, String mennyisegiEgyseg) {
        List<EtelEntity> szurt = new ArrayList<>();
        szurt = repo.findAll()
                .stream()
                .filter(x -> nev == null || x.getNev().contains(nev))
                .filter(x -> kaloria == null || x.getKaloria() < kaloria)
                .filter(x -> mennyiseg == null || x.getMennyiseg().equals(mennyiseg))
                .filter(x -> mennyisegiEgyseg == null || x.getMennyisegiEgyseg().equals(mennyisegiEgyseg))
                .toList();

        return mapper.map(szurt, new TypeToken<List<EtelDto>>(){}.getType());
    }
}
