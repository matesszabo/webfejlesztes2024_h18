package hu.unideb.inf.edzesnaplo.data.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Etel")
public class EtelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nev", nullable = false)
    private String nev;
    @Column(name = "kcal", nullable = false)
    private Integer kaloria;
    @Column(name = "menny",nullable = false)
    private Float mennyiseg;
    @Column(name = "me", nullable = false, length = 20)
    private String mennyisegiEgyseg;

    public EtelEntity() {
    }

    public EtelEntity(long id, String nev, Integer kaloria, Float mennyiseg, String mennyisegiEgyseg) {
        this.id = id;
        this.nev = nev;
        this.kaloria = kaloria;
        this.mennyiseg = mennyiseg;
        this.mennyisegiEgyseg = mennyisegiEgyseg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Integer getKaloria() {
        return kaloria;
    }

    public void setKaloria(Integer kaloria) {
        this.kaloria = kaloria;
    }

    public Float getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(Float mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public String getMennyisegiEgyseg() {
        return mennyisegiEgyseg;
    }

    public void setMennyisegiEgyseg(String mennyisegiEgyseg) {
        this.mennyisegiEgyseg = mennyisegiEgyseg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtelEntity that = (EtelEntity) o;
        return id == that.id && Objects.equals(nev, that.nev) && Objects.equals(kaloria, that.kaloria) && Objects.equals(mennyiseg, that.mennyiseg) && Objects.equals(mennyisegiEgyseg, that.mennyisegiEgyseg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, kaloria, mennyiseg, mennyisegiEgyseg);
    }
}
