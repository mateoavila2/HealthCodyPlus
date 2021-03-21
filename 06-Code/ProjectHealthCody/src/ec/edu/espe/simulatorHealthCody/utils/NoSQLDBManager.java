/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.utils;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public interface NoSQLDBManager extends DataPersistence {

    public boolean openConnection(String dataBaseName);
    
}
