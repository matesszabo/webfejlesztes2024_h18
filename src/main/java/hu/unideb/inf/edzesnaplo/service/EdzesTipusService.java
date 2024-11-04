package hu.unideb.inf.edzesnaplo.service;

import hu.unideb.inf.edzesnaplo.service.dto.EdzesTipusDto;

import java.util.List;

public interface EdzesTipusService {

    EdzesTipusDto getById(Long id);
    List<EdzesTipusDto> getAll();
    EdzesTipusDto save(EdzesTipusDto edzesTipusDto);
}
