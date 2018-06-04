// Generated with WSg.

package hu.tarnai.minerva.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="galeria")
public class Galeria implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    public int id;
    @Column(nullable=false, length=500)
    public String nev;
    @Column(nullable=false, length=500)
    public String leiras;
    @Column(nullable=false)
    public byte[] kep;

    /** Default constructor. */
    public Galeria() {
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
}
