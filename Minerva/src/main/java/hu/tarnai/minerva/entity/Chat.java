// Generated with WSg.

package hu.tarnai.minerva.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="chat")
public class Chat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    public int id;
    @Column(nullable=false, precision=10)
    public int userId;
    @Column(nullable=false)
    public Timestamp date;
    @Column(nullable=false, length=1000)
    public String message;
    @Column(name="user_name", length=255)
    public String userName;

    /** Default constructor. */
    public Chat() {
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
     * Access method for message.
     *
     * @return the current value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method for message.
     *
     * @param aMessage the new value for message
     */
    public void setMessage(String aMessage) {
        message = aMessage;
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
     * Access method for userName.
     *
     * @return the current value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for userName.
     *
     * @param aUserName the new value for userName
     */
    public void setUserName(String aUserName) {
        userName = aUserName;
    }

}
