// Generated with WSg.

package hu.tarnai.minerva.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="etlapkategoria")
public class Etlapkategoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    public int id;
    @Column(nullable=false, length=200)
    public String nev;
    @Column(nullable=false, precision=10)
    public int sorrend;
    @Column(length=255)
    public String stat;

    /** Default constructor. */
    public Etlapkategoria() {
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
     * Access method for sorrend.
     *
     * @return the current value of sorrend
     */
    public int getSorrend() {
        return sorrend;
    }

    /**
     * Setter method for sorrend.
     *
     * @param aSorrend the new value for sorrend
     */
    public void setSorrend(int aSorrend) {
        sorrend = aSorrend;
    }

    /**
     * Access method for stat.
     *
     * @return the current value of stat
     */
    public String getStat() {
        return stat;
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
