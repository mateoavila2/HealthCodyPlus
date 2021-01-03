/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class Administrator extends Person {
    private String administratorUSer;
    private String administratorPassword;
    private String administratorCode;
    public Administrator(String namePerson, String idPerson, String genderPerson, int agePerson,String administratorUSer, String administratorPassword,String administratorCode) {
        super(namePerson, idPerson, genderPerson, agePerson);
        this.administratorUSer = administratorUSer;
        this.administratorPassword = administratorPassword;
        this.administratorCode = administratorCode;
    }

    public String getAdministratorUSer() {
        return administratorUSer;
    }

    public void setAdministratorUSer(String administratorUSer) {
        this.administratorUSer = administratorUSer;
    }

    public String getAdministratorPassword() {
        return administratorPassword;
    }

    public void setAdministratorPassword(String administratorPassword) {
        this.administratorPassword = administratorPassword;
    }

    public String getAdministratorCode() {
        return administratorCode;
    }

    public void setAdministratorCode(String administratorCode) {
        this.administratorCode = administratorCode;
    }
    
    @Override
    public String toString() {
        return namePerson + "," + idPerson + "," + genderPerson + "," + agePerson + "," + administratorUSer + "," + administratorPassword + "," + administratorCode +"\n";
    }
    
    
}
