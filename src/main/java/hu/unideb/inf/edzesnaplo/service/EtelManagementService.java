package hu.unideb.inf.edzesnaplo.service;

import hu.unideb.inf.edzesnaplo.service.dto.EtelDto;

import java.util.List;

public interface EtelManagementService {

    EtelDto findById(Long id);
    List<EtelDto> findAll();
    EtelDto save(EtelDto etel);
    void delete(Long id);

}
