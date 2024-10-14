package hu.unideb.inf.edzesnaplo.data.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "edzestipus")
public class EdzesTipusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "nev")
    private String nev;
    @Column(name = "kcal")
    private Integer kaloria;

    public EdzesTipusEntity() {
    }

    public EdzesTipusEntity(long id, String nev, Integer kaloria) {
        this.id = id;
        this.nev = nev;
        this.kaloria = kaloria;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EdzesTipusEntity that = (EdzesTipusEntity) o;
        return id == that.id && Objects.equals(nev, that.nev) && Objects.equals(kaloria, that.kaloria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, kaloria);
    }
}
