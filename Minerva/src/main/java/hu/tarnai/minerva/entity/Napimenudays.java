// Generated with WSg.

package hu.tarnai.minerva.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="napimenudays")
public class Napimenudays implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    public int id;
    @Column(nullable=false, length=300)
    public String days;
    @Column(nullable=false, length=300)
    public String days2;
    @Column(nullable=false, length=1)
    public String aktual;

    /** Default constructor. */
    public Napimenudays() {
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
     * Access method for days.
     *
     * @return the current value of days
     */
    public String getDays() {
        return days;
    }

    /**
     * Setter method for days.
     *
     * @param aDays the new value for days
     */
    public void setDays(String aDays) {
        days = aDays;
    }

    /**
     * Access method for days2.
     *
     * @return the current value of days2
     */
    public String getDays2() {
        return days2;
    }

    /**
     * Setter method for days2.
     *
     * @param aDays2 the new value for days2
     */
    public void setDays2(String aDays2) {
        days2 = aDays2;
    }

    /**
     * Access method for aktual.
     *
     * @return the current value of aktual
     */
    public String getAktual() {
        return aktual;
    }

    /**
     * Setter method for aktual.
     *
     * @param aAktual the new value for aktual
     */
    public void setAktual(String aAktual) {
        aktual = aAktual;
    }
}
