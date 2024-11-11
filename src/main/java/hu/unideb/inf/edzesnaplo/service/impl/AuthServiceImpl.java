package hu.unideb.inf.edzesnaplo.service.impl;

import hu.unideb.inf.edzesnaplo.data.entity.FelhasznaloEntity;
import hu.unideb.inf.edzesnaplo.data.entity.JogosultsagEntity;
import hu.unideb.inf.edzesnaplo.data.repository.FelhasznaloRepository;
import hu.unideb.inf.edzesnaplo.data.repository.JogosultsagRepository;
import hu.unideb.inf.edzesnaplo.service.AuthService;
import hu.unideb.inf.edzesnaplo.service.dto.BejelentkezesDto;
import hu.unideb.inf.edzesnaplo.service.dto.RegisztracioDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    FelhasznaloRepository felhasznaloRepository;
    @Autowired
    JogosultsagRepository jogRepo;

    @Override
    public void regisztracio(RegisztracioDto dto) {
        FelhasznaloEntity entity = modelMapper.map(dto, FelhasznaloEntity.class);
        entity.setJelszo(passwordEncoder.encode(entity.getJelszo()));

        JogosultsagEntity jog = jogRepo.findByNev("FELHASZNALO");
        if(jog == null){
            jog = new JogosultsagEntity();
            jog.setNev("FELHASZNALO");
            jog = jogRepo.save(jog);

            entity.setJogosultsagok(List.of(jog));
        } else {
            entity.setJogosultsagok(List.of(jog));
        }

        felhasznaloRepository.save(entity);



    }

    @Override
    public void bejelentkezes(BejelentkezesDto dto) {

    }
}
