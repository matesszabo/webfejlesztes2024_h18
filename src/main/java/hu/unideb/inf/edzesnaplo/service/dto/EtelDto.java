package hu.unideb.inf.edzesnaplo.service.dto;

import java.util.Objects;

//DTO - Data Transfer Object
//POJO - Plain old java object
public class EtelDto {

    private Long id;
    private String nev;
    private Integer kaloria;
    private Float mennyiseg;
    private String mennyisegiEgyseg;

    public EtelDto() {
    }

    public EtelDto(Long id, String nev, Integer kaloria, Float mennyiseg, String mennyisegiEgyseg) {
        this.id = id;
        this.nev = nev;
        this.kaloria = kaloria;
        this.mennyiseg = mennyiseg;
        this.mennyisegiEgyseg = mennyisegiEgyseg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        EtelDto etelDto = (EtelDto) o;
        return Objects.equals(id, etelDto.id) && Objects.equals(nev, etelDto.nev) && Objects.equals(kaloria, etelDto.kaloria) && Objects.equals(mennyiseg, etelDto.mennyiseg) && Objects.equals(mennyisegiEgyseg, etelDto.mennyisegiEgyseg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, kaloria, mennyiseg, mennyisegiEgyseg);
    }
}
