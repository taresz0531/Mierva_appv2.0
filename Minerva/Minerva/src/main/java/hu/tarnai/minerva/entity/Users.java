// Generated with WSg.

package hu.tarnai.minerva.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="users")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

    @Column(nullable=false, length=100)
    public String nev;
    @Column(nullable=false, length=1)
    public String stat;
    @Column(nullable=false, length=5)
    public String hkor;
    @Column(nullable=false, length=50)
    public String menu;
    @Column(nullable=false, length=30)
    public String fnev;
    @Column(nullable=false, length=30)
    public String jelszo;
    @Column(nullable=false, length=100)
    public String email;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    public int id;
    @Column(name = "permission", length=300)
    public String permission;

    /** Default constructor. */
    public Users() {
        super();
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
     * Access method for hkor.
     *
     * @return the current value of hkor
     */
    public String getHkor() {
        return hkor;
    }

    /**
     * Setter method for hkor.
     *
     * @param aHkor the new value for hkor
     */
    public void setHkor(String aHkor) {
        hkor = aHkor;
    }

    /**
     * Access method for menu.
     *
     * @return the current value of menu
     */
    public String getMenu() {
        return menu;
    }

    /**
     * Setter method for menu.
     *
     * @param aMenu the new value for menu
     */
    public void setMenu(String aMenu) {
        menu = aMenu;
    }

    /**
     * Access method for fnev.
     *
     * @return the current value of fnev
     */
    public String getFnev() {
        return fnev;
    }

    /**
     * Setter method for fnev.
     *
     * @param aFnev the new value for fnev
     */
    public void setFnev(String aFnev) {
        fnev = aFnev;
    }

    /**
     * Access method for jelszo.
     *
     * @return the current value of jelszo
     */
    public String getJelszo() {
        return jelszo;
    }

    /**
     * Setter method for jelszo.
     *
     * @param aJelszo the new value for jelszo
     */
    public void setJelszo(String aJelszo) {
        jelszo = aJelszo;
    }

    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
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

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
}
