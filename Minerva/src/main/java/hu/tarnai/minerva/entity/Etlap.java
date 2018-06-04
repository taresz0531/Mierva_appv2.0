// Generated with WSg.

package hu.tarnai.minerva.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="etlap")
public class Etlap implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    public int id;
    @Column(nullable=false, length=300)
    public String nev;
    @Column(nullable=false, precision=10)
    public int kategoria;
    @Column(nullable=false, length=1000)
    public String leiras;
    @Column(nullable=false, length=100)
    public String ar;
    public byte[] kep;
    @Column(nullable=false, precision=10)
    public int is_kep;
    @Column(nullable=false, length=1)
    public String stat;

    /** Default constructor. */
    public Etlap() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for nev.
     *
     * @return the current value of nev
     */
    public String getNev() {
        return nev;
    }

    /**
     * Setter method for nev.
     *
     * @param aNev the new value for nev
     */
    public void setNev(String aNev) {
        nev = aNev;
    }

    /**
     * Access method for kategoria.
     *
     * @return the current value of kategoria
     */
    public int getKategoria() {
        return kategoria;
    }

    /**
     * Setter method for kategoria.
     *
     * @param aKategoria the new value for kategoria
     */
    public void setKategoria(int aKategoria) {
        kategoria = aKategoria;
    }

    /**
     * Access method for leiras.
     *
     * @return the current value of leiras
     */
    public String getLeiras() {
        return leiras;
    }

    /**
     * Setter method for leiras.
     *
     * @param aLeiras the new value for leiras
     */
    public void setLeiras(String aLeiras) {
        leiras = aLeiras;
    }

    /**
     * Access method for ar.
     *
     * @return the current value of ar
     */
    public String getAr() {
        return ar;
    }

    /**
     * Setter method for ar.
     *
     * @param aAr the new value for ar
     */
    public void setAr(String aAr) {
        ar = aAr;
    }

    /**
     * Access method for kep.
     *
     * @return the current value of kep
     */
    public byte[] getKep() {
        return kep;
    }

    /**
     * Setter method for kep.
     *
     * @param aKep the new value for kep
     */
    public void setKep(byte[] aKep) {
        kep = aKep;
    }

    /**
     * Access method for stat.
     *
     * @return the current value of stat
     */
    public String getStat() {
        return stat;
    }

    public int getIs_kep() {
		return is_kep;
	}

	public void setIs_kep(int is_kep) {
		this.is_kep = is_kep;
	}

	/**
     * Setter method for stat.
     *
     * @param aStat the new value for stat
     */
    public void setStat(String aStat) {
        stat = aStat;
    }
}
