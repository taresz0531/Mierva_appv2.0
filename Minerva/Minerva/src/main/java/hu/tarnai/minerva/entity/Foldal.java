// Generated with WSg.

package hu.tarnai.minerva.entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="foldal")
public class Foldal implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    public int id;
    @Column(nullable=false, length=200)
    public String cim;
    @Column(nullable=false, length=5000)
    public String leiras;
    @Column(nullable=false, length=3)
    public String nyelv;
    @Column(nullable=false, length=1)
    public String stat;
    @Column(nullable=false, length=100)
    public String date;
    @Column(nullable=false, length=20)
    public String dateTo;
    @Column(nullable=false, precision=10)
    public int autoOpen;

    /** Default constructor. */
    public Foldal() {
        super();
    }
    
    public static Foldal covertResultToFoldal(ResultSet rs){
    	Foldal fl = new Foldal();
		try {
			fl.setId(rs.getInt("id"));
			fl.setCim(rs.getString("cim"));
			fl.setLeiras(rs.getString("leiras"));
			fl.setNyelv(rs.getString("nyelv"));
			fl.setStat(rs.getString("stat"));
			fl.setDate(rs.getString("date"));
			fl.setDateTo(rs.getString("dateto"));
			fl.setAutoOpen(rs.getInt("autoopen"));
			return fl;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
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
     * Access method for cim.
     *
     * @return the current value of cim
     */
    public String getCim() {
        return cim;
    }

    /**
     * Setter method for cim.
     *
     * @param aCim the new value for cim
     */
    public void setCim(String aCim) {
        cim = aCim;
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
     * Access method for nyelv.
     *
     * @return the current value of nyelv
     */
    public String getNyelv() {
        return nyelv;
    }

    /**
     * Setter method for nyelv.
     *
     * @param aNyelv the new value for nyelv
     */
    public void setNyelv(String aNyelv) {
        nyelv = aNyelv;
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

    /**
     * Access method for date.
     *
     * @return the current value of date
     */
    public String getDate() {
        return date;
    }

    /**
     * Setter method for date.
     *
     * @param aDate the new value for date
     */
    public void setDate(String aDate) {
        date = aDate;
    }

    /**
     * Access method for dateTo.
     *
     * @return the current value of dateTo
     */
    public String getDateTo() {
        return dateTo;
    }

    /**
     * Setter method for dateTo.
     *
     * @param aDateTo the new value for dateTo
     */
    public void setDateTo(String aDateTo) {
        dateTo = aDateTo;
    }

    /**
     * Access method for autoOpen.
     *
     * @return the current value of autoOpen
     */
    public int getAutoOpen() {
        return autoOpen;
    }

    /**
     * Setter method for autoOpen.
     *
     * @param aAutoOpen the new value for autoOpen
     */
    public void setAutoOpen(int aAutoOpen) {
        autoOpen = aAutoOpen;
    }
}
