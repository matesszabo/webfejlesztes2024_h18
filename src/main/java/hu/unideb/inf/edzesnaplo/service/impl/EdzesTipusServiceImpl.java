package hu.unideb.inf.edzesnaplo.service.impl;

import hu.unideb.inf.edzesnaplo.data.repository.EdzesTipusRepository;
import hu.unideb.inf.edzesnaplo.service.EdzesTipusService;
import hu.unideb.inf.edzesnaplo.service.dto.EdzesTipusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdzesTipusServiceImpl implements EdzesTipusService {
    @Autowired
    EdzesTipusRepository repository;

    @Override
    public EdzesTipusDto getById(Long id) {
        return null;
    }

    @Override
    public List<EdzesTipusDto> getAll() {
        return List.of();
    }

    @Override
    public EdzesTipusDto save(EdzesTipusDto edzesTipusDto) {
        return null;
    }
}
