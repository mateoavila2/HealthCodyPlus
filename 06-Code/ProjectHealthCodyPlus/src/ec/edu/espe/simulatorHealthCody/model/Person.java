/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class Person {
    private String namePerson;
    private String idPerson; 
    private String genderPerson;
    private int agePerson;

    public Person(String namePerson, String idPerson, String genderPerson, int agePerson) {
        this.namePerson = namePerson;
        this.idPerson = idPerson;
        this.genderPerson = genderPerson;
        this.agePerson = agePerson;
    }
    /**
     * @return the namePerson
     */
    public String getNamePerson() {
        return namePerson;
    }

    /**
     * @param namePerson the namePerson to set
     */
    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    /**
     * @return the idPerson
     */
    public String getIdPerson() {
        return idPerson;
    }

    /**
     * @param idPerson the idPerson to set
     */
    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    /**
     * @return the genderPerson
     */
    public String getGenderPerson() {
        return genderPerson;
    }

    /**
     * @param genderPerson the genderPerson to set
     */
    public void setGenderPerson(String genderPerson) {
        this.genderPerson = genderPerson;
    }

    /**
     * @return the agePerson
     */
    public int getAgePerson() {
        return agePerson;
    }

    /**
     * @param agePerson the agePerson to set
     */
    public void setAgePerson(int agePerson) {
        this.agePerson = agePerson;
    }
    
    
}
