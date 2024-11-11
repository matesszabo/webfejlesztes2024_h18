package hu.unideb.inf.edzesnaplo.data.repository;

import hu.unideb.inf.edzesnaplo.data.entity.JogosultsagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogosultsagRepository extends JpaRepository<JogosultsagEntity, Long> {

    //select * from Jogosultsag where nev = ?nev
    JogosultsagEntity findByNev(String nev);
}