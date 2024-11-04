package hu.unideb.inf.edzesnaplo.service.dto;

import jakarta.persistence.Column;

import java.util.Objects;

public class EdzesTipusDto {
    private Long id;
    private String nev;
    private Integer kaloria;

    public EdzesTipusDto() {
    }

    public EdzesTipusDto(Long id, String nev, Integer kaloria) {
        this.id = id;
        this.nev = nev;
        this.kaloria = kaloria;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EdzesTipusDto that = (EdzesTipusDto) o;
        return Objects.equals(id, that.id) && Objects.equals(nev, that.nev) && Objects.equals(kaloria, that.kaloria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, kaloria);
    }
}
