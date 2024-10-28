package hu.unideb.inf.edzesnaplo.data.repository;

import hu.unideb.inf.edzesnaplo.data.entity.EtelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtelRepository extends JpaRepository<EtelEntity, Long> {
}