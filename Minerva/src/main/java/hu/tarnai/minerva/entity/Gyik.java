// Generated with WSg.

package hu.tarnai.minerva.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="gyik")
public class Gyik implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    public int id;
    @Column(nullable=false, length=100)
    public String eler;
    @Column(nullable=false, length=1000)
    public String kerdes;
    @Column(nullable=false, length=1)
    public String stat;

    /** Default constructor. */
    public Gyik() {
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
     * Access method for eler.
     *
     * @return the current value of eler
     */
    public String getEler() {
        return eler;
    }

    /**
     * Setter method for eler.
     *
     * @param aEler the new value for eler
     */
    public void setEler(String aEler) {
        eler = aEler;
    }

    /**
     * Access method for kerdes.
     *
     * @return the current value of kerdes
     */
    public String getKerdes() {
        return kerdes;
    }

    /**
     * Setter method for kerdes.
     *
     * @param aKerdes the new value for kerdes
     */
    public void setKerdes(String aKerdes) {
        kerdes = aKerdes;
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
