/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.utils;

/**
 *
 * @author Rafa
 */
public interface DataPersistence {

    public boolean save(String data,String table);

    public String read(String table);

    public boolean update(String dataTofind, String dataToupdate,String table);

    public boolean delete(String dataToDelete,String table);

    public String find(String dataToFind,String table);
    
}
