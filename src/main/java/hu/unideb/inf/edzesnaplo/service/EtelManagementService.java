package hu.unideb.inf.edzesnaplo.service;

import hu.unideb.inf.edzesnaplo.service.dto.EtelDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EtelManagementService {

    EtelDto findById(Long id);
    List<EtelDto> findAll();
    EtelDto save(EtelDto etel);
    void delete(Long id);

    List<EtelDto> findByNev(String nev);
    List<EtelDto> findByNevDb(String nev);
    List<EtelDto> findByAny(String nev,
                            Integer kaloria,
                            Float mennyiseg,
                            String mennyisegiEgyseg);

}
