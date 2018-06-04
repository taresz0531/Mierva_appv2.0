// Generated with WSg.

package hu.tarnai.minerva.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ajanlat")
public class Ajanlat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, precision=10)
    public int id;
    @Column(length=1)
    public String stat;
    @Column(nullable=false, length=100)
    public String nev;
    @Column(nullable=false)
    public Date tol;
    @Column(nullable=false)
    public Date ig;
    @Column(nullable=false, precision=10)
    public int szszam;
    @Column(nullable=false, length=100)
    public String email;
    @Column(length=30)
    public String mobil;
    @Column(nullable=false, length=100)
    public String szoba;
    @Column(length=1)
    public String reggeli;
    @Column(length=3000)
    public String megjegyzes;
    @Column(length=16777215)
    public String valasz;
    @Column(precision=10)
    public int autodelet;

    /** Default constructor. */
    public Ajanlat() {
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
     * Access method for tol.
     *
     * @return the current value of tol
     */
    public Date getTol() {
        return tol;
    }

    /**
     * Setter method for tol.
     *
     * @param aTol the new value for tol
     */
    public void setTol(Date aTol) {
        tol = aTol;
    }

    /**
     * Access method for ig.
     *
     * @return the current value of ig
     */
    public Date getIg() {
        return ig;
    }

    /**
     * Setter method for ig.
     *
     * @param aIg the new value for ig
     */
    public void setIg(Date aIg) {
        ig = aIg;
    }

    /**
     * Access method for szszam.
     *
     * @return the current value of szszam
     */
    public int getSzszam() {
        return szszam;
    }

    /**
     * Setter method for szszam.
     *
     * @param aSzszam the new value for szszam
     */
    public void setSzszam(int aSzszam) {
        szszam = aSzszam;
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
     * Access method for mobil.
     *
     * @return the current value of mobil
     */
    public String getMobil() {
        return mobil;
    }

    /**
     * Setter method for mobil.
     *
     * @param aMobil the new value for mobil
     */
    public void setMobil(String aMobil) {
        mobil = aMobil;
    }

    /**
     * Access method for szoba.
     *
     * @return the current value of szoba
     */
    public String getSzoba() {
        return szoba;
    }

    /**
     * Setter method for szoba.
     *
     * @param aSzoba the new value for szoba
     */
    public void setSzoba(String aSzoba) {
        szoba = aSzoba;
    }

    /**
     * Access method for reggeli.
     *
     * @return the current value of reggeli
     */
    public String getReggeli() {
        return reggeli;
    }

    /**
     * Setter method for reggeli.
     *
     * @param aReggeli the new value for reggeli
     */
    public void setReggeli(String aReggeli) {
        reggeli = aReggeli;
    }

    /**
     * Access method for megjegyzes.
     *
     * @return the current value of megjegyzes
     */
    public String getMegjegyzes() {
        return megjegyzes;
    }

    /**
     * Setter method for megjegyzes.
     *
     * @param aMegjegyzes the new value for megjegyzes
     */
    public void setMegjegyzes(String aMegjegyzes) {
        megjegyzes = aMegjegyzes;
    }

    /**
     * Access method for valasz.
     *
     * @return the current value of valasz
     */
    public String getValasz() {
        return valasz;
    }

    /**
     * Setter method for valasz.
     *
     * @param aValasz the new value for valasz
     */
    public void setValasz(String aValasz) {
        valasz = aValasz;
    }

    /**
     * Access method for autodelet.
     *
     * @return the current value of autodelet
     */
    public int getAutodelet() {
        return autodelet;
    }

    /**
     * Setter method for autodelet.
     *
     * @param aAutodelet the new value for autodelet
     */
    public void setAutodelet(int aAutodelet) {
        autodelet = aAutodelet;
    }

}
