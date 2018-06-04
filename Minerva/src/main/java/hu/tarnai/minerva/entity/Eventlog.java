// Generated with WSg.

package hu.tarnai.minerva.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="eventlog")
public class Eventlog implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    public int id;
    @Column(nullable=false, precision=10)
    public int userId;
    @Column(nullable=false, length=100)
    public String nev;
    @Column(nullable=false)
    public Timestamp date;
    @Column(nullable=false, length=1000)
    public String event;
    @Column(nullable=false, length=1)
    public String type;

    /** Default constructor. */
    public Eventlog() {
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
     * Access method for userId.
     *
     * @return the current value of userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Setter method for userId.
     *
     * @param aUserId the new value for userId
     */
    public void setUserId(int aUserId) {
        userId = aUserId;
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
     * Access method for date.
     *
     * @return the current value of date
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * Setter method for date.
     *
     * @param aDate the new value for date
     */
    public void setDate(Timestamp aDate) {
        date = aDate;
    }

    /**
     * Access method for event.
     *
     * @return the current value of event
     */
    public String getEvent() {
        return event;
    }

    /**
     * Setter method for event.
     *
     * @param aEvent the new value for event
     */
    public void setEvent(String aEvent) {
        event = aEvent;
    }

    /**
     * Access method for type.
     *
     * @return the current value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter method for type.
     *
     * @param aType the new value for type
     */
    public void setType(String aType) {
        type = aType;
    }
}
