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

    public boolean save(String data);

    public String read();

    public boolean update(String dataTofind, String dataToupdate);

    public boolean delete(String dataToDelete);

    public String find(String dataToFind);
}
