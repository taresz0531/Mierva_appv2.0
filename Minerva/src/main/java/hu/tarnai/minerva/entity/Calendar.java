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

@Entity(name="calendar")
public class Calendar implements Serializable {

	private static final long serialVersionUID = -578359275419582155L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    public int id;
    @Column(name="date_from", nullable=false)
    public Date dateFrom;
    @Column(name="date_to", nullable=false)
    public Date dateTo;
    @Column(name="room_type", nullable=false, precision=10)
    public int roomType;
    @Column(nullable=false, length=200)
    public String name;
    @Column(nullable=false, length=50)
    public String phone;
    @Column(name="adults_num", nullable=false, precision=10)
    public int adultsNum;
    @Column(name="children_num", nullable=false, precision=10)
    public int childrenNum;
    @Column(name="pay_type", nullable=false, length=50)
    public String payType;
    @Column(nullable=false, precision=10)
    public int price;
    @Column(nullable=false, length=1500)
    public String comment;
    @Column(nullable=false, length=10)
    public String color;

    /** Default constructor. */
    public Calendar() {
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
     * Access method for dateFrom.
     *
     * @return the current value of dateFrom
     */
    public Date getDateFrom() {
        return dateFrom;
    }

    /**
     * Setter method for dateFrom.
     *
     * @param aDateFrom the new value for dateFrom
     */
    public void setDateFrom(Date aDateFrom) {
        dateFrom = aDateFrom;
    }

    /**
     * Access method for dateTo.
     *
     * @return the current value of dateTo
     */
    public Date getDateTo() {
        return dateTo;
    }

    /**
     * Setter method for dateTo.
     *
     * @param aDateTo the new value for dateTo
     */
    public void setDateTo(Date aDateTo) {
        dateTo = aDateTo;
    }

    /**
     * Access method for roomType.
     *
     * @return the current value of roomType
     */
    public int getRoomType() {
        return roomType;
    }

    /**
     * Setter method for roomType.
     *
     * @param aRoomType the new value for roomType
     */
    public void setRoomType(int aRoomType) {
        roomType = aRoomType;
    }

    /**
     * Access method for name.
     *
     * @return the current value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for name.
     *
     * @param aName the new value for name
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * Access method for phone.
     *
     * @return the current value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter method for phone.
     *
     * @param aPhone the new value for phone
     */
    public void setPhone(String aPhone) {
        phone = aPhone;
    }

    /**
     * Access method for adultsNum.
     *
     * @return the current value of adultsNum
     */
    public int getAdultsNum() {
        return adultsNum;
    }

    /**
     * Setter method for adultsNum.
     *
     * @param aAdultsNum the new value for adultsNum
     */
    public void setAdultsNum(int aAdultsNum) {
        adultsNum = aAdultsNum;
    }

    /**
     * Access method for childrenNum.
     *
     * @return the current value of childrenNum
     */
    public int getChildrenNum() {
        return childrenNum;
    }

    /**
     * Setter method for childrenNum.
     *
     * @param aChildrenNum the new value for childrenNum
     */
    public void setChildrenNum(int aChildrenNum) {
        childrenNum = aChildrenNum;
    }

    /**
     * Access method for payType.
     *
     * @return the current value of payType
     */
    public String getPayType() {
        return payType;
    }

    /**
     * Setter method for payType.
     *
     * @param aPayType the new value for payType
     */
    public void setPayType(String aPayType) {
        payType = aPayType;
    }

    /**
     * Access method for price.
     *
     * @return the current value of price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter method for price.
     *
     * @param aPrice the new value for price
     */
    public void setPrice(int aPrice) {
        price = aPrice;
    }

    /**
     * Access method for comment.
     *
     * @return the current value of comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter method for comment.
     *
     * @param aComment the new value for comment
     */
    public void setComment(String aComment) {
        comment = aComment;
    }
    

    public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	/**
     * Compares the key for this instance with another Calendar.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Calendar and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Calendar)) {
            return false;
        }
        Calendar that = (Calendar) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Calendar.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Calendar)) return false;
        return this.equalKeys(other) && ((Calendar)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Calendar |");
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
