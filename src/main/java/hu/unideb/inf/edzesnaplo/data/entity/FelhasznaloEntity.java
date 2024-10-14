package hu.unideb.inf.edzesnaplo.data.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "felhasznalo")
public class FelhasznaloEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nev")
    private String nev;
    @Column(name = "szuletesiDatum")
    private Date szuletesiDatum;
    @Column(name = "suly")
    private Float suly;
    @Column(name = "magassag")
    private Integer magassag;
    @Column(name = "jelszo")
    private String jelszo;
    @Column(name = "email")
    private String email;
    @Column(name = "cel")
    private String cel;

    @OneToMany(mappedBy = "felhasznalo")
    private List<KaloriaNaploEntity> kaloriaNaplo;

    @ManyToMany
    @JoinTable(name = "felhasznalo_jogosultsagok",
            joinColumns = {@JoinColumn(name = "felhasznalo_id")},
            inverseJoinColumns = {@JoinColumn(name = "jogosultsag_id")}
    )
    private List<JogosultsagEntity> jogosultsagok;

    public FelhasznaloEntity() {
    }

    public FelhasznaloEntity(long id, String nev, Date szuletesiDatum, Float suly, Integer magassag, String jelszo, String email, String cel) {
        this.id = id;
        this.nev = nev;
        this.szuletesiDatum = szuletesiDatum;
        this.suly = suly;
        this.magassag = magassag;
        this.jelszo = jelszo;
        this.email = email;
        this.cel = cel;
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

    public List<KaloriaNaploEntity> getKaloriaNaplo() {
        return kaloriaNaplo;
    }

    public void setKaloriaNaplo(List<KaloriaNaploEntity> kaloriaNaplo) {
        this.kaloriaNaplo = kaloriaNaplo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FelhasznaloEntity that = (FelhasznaloEntity) o;
        return id == that.id && Objects.equals(nev, that.nev) && Objects.equals(szuletesiDatum, that.szuletesiDatum) && Objects.equals(suly, that.suly) && Objects.equals(magassag, that.magassag) && Objects.equals(jelszo, that.jelszo) && Objects.equals(email, that.email) && Objects.equals(cel, that.cel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, szuletesiDatum, suly, magassag, jelszo, email, cel);
    }
}
