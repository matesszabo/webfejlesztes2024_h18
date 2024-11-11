package hu.unideb.inf.edzesnaplo.service;

import hu.unideb.inf.edzesnaplo.service.dto.BejelentkezesDto;
import hu.unideb.inf.edzesnaplo.service.dto.RegisztracioDto;

public interface AuthService {
    void regisztracio(RegisztracioDto dto);
    void bejelentkezes(BejelentkezesDto dto);
}
