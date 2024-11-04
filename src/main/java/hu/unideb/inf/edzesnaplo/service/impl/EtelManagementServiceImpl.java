package hu.unideb.inf.edzesnaplo.service.impl;

import hu.unideb.inf.edzesnaplo.data.entity.EtelEntity;
import hu.unideb.inf.edzesnaplo.data.repository.EtelRepository;
import hu.unideb.inf.edzesnaplo.service.EtelManagementService;
import hu.unideb.inf.edzesnaplo.service.dto.EtelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtelManagementServiceImpl implements EtelManagementService {
    @Autowired
    EtelRepository repo;

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
        return List.of();
    }

    @Override
    public EtelDto save(EtelDto etel) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
