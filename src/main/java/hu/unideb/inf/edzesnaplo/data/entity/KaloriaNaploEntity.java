package hu.unideb.inf.edzesnaplo.data.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "kalorianaplo")
public class KaloriaNaploEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "fogyasztas_idopontja")
    private Date datum;
    @Column(name = "mennyiseg")
    private Float mennyiseg;

    @ManyToOne
    @JoinColumn(name = "etel_id", referencedColumnName = "id")
    private EtelEntity etel;

    @ManyToOne
    @JoinColumn(name = "felhasznalo_id", referencedColumnName = "id")
    private FelhasznaloEntity felhasznalo;

    public KaloriaNaploEntity() {
    }

    public KaloriaNaploEntity(long id, Date datum, Float mennyiseg) {
        this.id = id;
        this.datum = datum;
        this.mennyiseg = mennyiseg;
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

    public Float getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(Float mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public EtelEntity getEtel() {
        return etel;
    }

    public void setEtel(EtelEntity etel) {
        this.etel = etel;
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
        KaloriaNaploEntity that = (KaloriaNaploEntity) o;
        return id == that.id && Objects.equals(datum, that.datum) && Objects.equals(mennyiseg, that.mennyiseg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datum, mennyiseg);
    }
}






