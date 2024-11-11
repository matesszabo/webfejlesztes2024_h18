package hu.unideb.inf.edzesnaplo.service.dto;

import jakarta.persistence.Column;

import java.util.Date;
import java.util.Objects;

public class RegisztracioDto {
    private String nev;
    private Date szuletesiDatum;
    private Float suly;
    private Integer magassag;
    private String jelszo;
    private String email;
    private String cel;

    public RegisztracioDto() {
    }

    public RegisztracioDto(String nev, Date szuletesiDatum, Float suly, Integer magassag, String jelszo, String email, String cel) {
        this.nev = nev;
        this.szuletesiDatum = szuletesiDatum;
        this.suly = suly;
        this.magassag = magassag;
        this.jelszo = jelszo;
        this.email = email;
        this.cel = cel;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Date getSzuletesiDatum() {
        return szuletesiDatum;
    }

    public void setSzuletesiDatum(Date szuletesiDatum) {
        this.szuletesiDatum = szuletesiDatum;
    }

    public Float getSuly() {
        return suly;
    }

    public void setSuly(Float suly) {
        this.suly = suly;
    }

    public Integer getMagassag() {
        return magassag;
    }

    public void setMagassag(Integer magassag) {
        this.magassag = magassag;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCel() {
        return cel;
    }

    public void setCel(String cel) {
        this.cel = cel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisztracioDto that = (RegisztracioDto) o;
        return Objects.equals(nev, that.nev) && Objects.equals(szuletesiDatum, that.szuletesiDatum) && Objects.equals(suly, that.suly) && Objects.equals(magassag, that.magassag) && Objects.equals(jelszo, that.jelszo) && Objects.equals(email, that.email) && Objects.equals(cel, that.cel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nev, szuletesiDatum, suly, magassag, jelszo, email, cel);
    }
}
