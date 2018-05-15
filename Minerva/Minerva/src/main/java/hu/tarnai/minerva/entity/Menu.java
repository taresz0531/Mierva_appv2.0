// Generated with WSg.

package hu.tarnai.minerva.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="menu")
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    public int id;
    @Column(nullable=false, length=100)
    public String nev;
    @Column(nullable=false, length=10)
    public String code;
    @Column(nullable=false, length=300)
    public String url;
    @Column(nullable=false, length=100)
    public String main;
    @Column(nullable=false, precision=10)
    public int sorrend;

    /** Default constructor. */
    public Menu() {
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
     * Access method for code.
     *
     * @return the current value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for code.
     *
     * @param aCode the new value for code
     */
    public void setCode(String aCode) {
        code = aCode;
    }

    /**
     * Access method for url.
     *
     * @return the current value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter method for url.
     *
     * @param aUrl the new value for url
     */
    public void setUrl(String aUrl) {
        url = aUrl;
    }

    /**
     * Access method for main.
     *
     * @return the current value of main
     */
    public String getMain() {
        return main;
    }

    /**
     * Setter method for main.
     *
     * @param aMain the new value for main
     */
    public void setMain(String aMain) {
        main = aMain;
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
}
