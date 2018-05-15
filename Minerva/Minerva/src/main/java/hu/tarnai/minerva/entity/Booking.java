// Generated with g9.

package hu.tarnai.minerva.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="booking")
public class Booking implements Serializable {

	private static final long serialVersionUID = -6059061681332614743L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    public int id;
    @Column(name="date", nullable=false)
    public Date date;
    @Column(name="bed_1", nullable=false, precision=10)
    public int bed1;
    @Column(name="bed_2", nullable=false, precision=10)
    public int bed2;
    @Column(name="bed_3", nullable=false, precision=10)
    public int bed3;
    @Column(name="bed_4", nullable=false, precision=10)
    public int bed4;
    @Column(name="bed_attic_2", nullable=false, precision=10)
    public int bedAttic2;

    /** Default constructor. */
    public Booking() {
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
     * Access method for date.
     *
     * @return the current value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter method for date.
     *
     * @param aDate the new value for date
     */
    public void setDate(Date aDate) {
        date = aDate;
    }

    /**
     * Access method for bed1.
     *
     * @return the current value of bed1
     */
    public int getBed1() {
        return bed1;
    }

    /**
     * Setter method for bed1.
     *
     * @param aBed1 the new value for bed1
     */
    public void setBed1(int aBed1) {
        bed1 = aBed1;
    }

    /**
     * Access method for bed2.
     *
     * @return the current value of bed2
     */
    public int getBed2() {
        return bed2;
    }

    /**
     * Setter method for bed2.
     *
     * @param aBed2 the new value for bed2
     */
    public void setBed2(int aBed2) {
        bed2 = aBed2;
    }

    /**
     * Access method for bed3.
     *
     * @return the current value of bed3
     */
    public int getBed3() {
        return bed3;
    }

    /**
     * Setter method for bed3.
     *
     * @param aBed3 the new value for bed3
     */
    public void setBed3(int aBed3) {
        bed3 = aBed3;
    }

    /**
     * Access method for bed4.
     *
     * @return the current value of bed4
     */
    public int getBed4() {
        return bed4;
    }

    /**
     * Setter method for bed4.
     *
     * @param aBed4 the new value for bed4
     */
    public void setBed4(int aBed4) {
        bed4 = aBed4;
    }

    /**
     * Access method for bedAttic2.
     *
     * @return the current value of bedAttic2
     */
    public int getBedAttic2() {
        return bedAttic2;
    }

    /**
     * Setter method for bedAttic2.
     *
     * @param aBedAttic2 the new value for bedAttic2
     */
    public void setBedAttic2(int aBedAttic2) {
        bedAttic2 = aBedAttic2;
    }

    /**
     * Compares the key for this instance with another Booking.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Booking and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Booking)) {
            return false;
        }
        Booking that = (Booking) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Booking.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Booking)) return false;
        return this.equalKeys(other) && ((Booking)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Booking |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", new Integer(getId()));
        return ret;
    }

}
