// Generated with WSg.

package hu.tarnai.minerva.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="napimenu")
public class Napimenu implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    public int id;
    @Column(nullable=false, length=500)
    public String leves;
    @Column(nullable=false, length=500)
    public String foetel;
    @Column(nullable=false, length=500)
    public String koret;
    @Column(nullable=false, length=50)
    public String nap;

    /** Default constructor. */
    public Napimenu() {
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
     * Access method for leves.
     *
     * @return the current value of leves
     */
    public String getLeves() {
        return leves;
    }

    /**
     * Setter method for leves.
     *
     * @param aLeves the new value for leves
     */
    public void setLeves(String aLeves) {
        leves = aLeves;
    }

    /**
     * Access method for foetel.
     *
     * @return the current value of foetel
     */
    public String getFoetel() {
        return foetel;
    }

    /**
     * Setter method for foetel.
     *
     * @param aFoetel the new value for foetel
     */
    public void setFoetel(String aFoetel) {
        foetel = aFoetel;
    }

    /**
     * Access method for koret.
     *
     * @return the current value of koret
     */
    public String getKoret() {
        return koret;
    }

    /**
     * Setter method for koret.
     *
     * @param aKoret the new value for koret
     */
    public void setKoret(String aKoret) {
        koret = aKoret;
    }

    /**
     * Access method for nap.
     *
     * @return the current value of nap
     */
    public String getNap() {
        return nap;
    }

    /**
     * Setter method for nap.
     *
     * @param aNap the new value for nap
     */
    public void setNap(String aNap) {
        nap = aNap;
    }
}
