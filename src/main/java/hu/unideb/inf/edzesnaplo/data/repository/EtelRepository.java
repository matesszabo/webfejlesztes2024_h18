package hu.unideb.inf.edzesnaplo.data.repository;

import hu.unideb.inf.edzesnaplo.data.entity.EtelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtelRepository extends JpaRepository<EtelEntity, Long> {

    //select * from Etel where nev like '%nev%'
    List<EtelEntity> findAllByNevContains(String nev);
}