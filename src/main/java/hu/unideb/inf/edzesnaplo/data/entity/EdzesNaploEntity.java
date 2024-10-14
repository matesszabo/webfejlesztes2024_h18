package hu.unideb.inf.edzesnaplo.data.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "edzesnaplo")
public class EdzesNaploEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "datum")
    private Date datum;
    @Column(name = "idotartam")
    private Float idotartam;

    @ManyToOne
    @JoinColumn(name = "felhasznalo_id", referencedColumnName = "id")
    private FelhasznaloEntity felhasznalo;

    public EdzesNaploEntity() {
    }

    public EdzesNaploEntity(long id, Date datum, Float idotartam, FelhasznaloEntity felhasznalo) {
        this.id = id;
        this.datum = datum;
        this.idotartam = idotartam;
        this.felhasznalo = felhasznalo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Float getIdotartam() {
        return idotartam;
    }

    public void setIdotartam(Float idotartam) {
        this.idotartam = idotartam;
    }

    public FelhasznaloEntity getFelhasznalo() {
        return felhasznalo;
    }

    public void setFelhasznalo(FelhasznaloEntity felhasznalo) {
        this.felhasznalo = felhasznalo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EdzesNaploEntity that = (EdzesNaploEntity) o;
        return id == that.id && Objects.equals(datum, that.datum) && Objects.equals(idotartam, that.idotartam) && Objects.equals(felhasznalo, that.felhasznalo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datum, idotartam, felhasznalo);
    }
}
