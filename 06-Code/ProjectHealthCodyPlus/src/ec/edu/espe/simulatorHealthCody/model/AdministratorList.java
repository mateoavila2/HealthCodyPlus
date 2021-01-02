/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Buse ESPE-DCCO
 */
public class AdministratorList {
    private ArrayList<Administrator> administratorList;

    public AdministratorList() {
        administratorList = new ArrayList();
    }
    
    public void saveAdministrator(Administrator administrator){
        FileWriter file;
        BufferedWriter write;
        try
        {
            File f = new File("administratorList.txt");

            file = new FileWriter("administratorList.txt",true);
            if(f.exists())
            {
                write =new BufferedWriter(file);
                write.write(administrator.showDataAdministrator());
                //write.write(""+"\n");
                write.close();
                }   
            else
            {
                file = new FileWriter("administratorList.txt",true);
            }    
        }catch(IOException ex)
        {
           Logger.getLogger(Administrator.class.getName()).log(Level.SEVERE,null,ex);     
        }
    }
    
    public void readFile(){
        try {
            FileReader  readFile;
            BufferedReader read;
            readFile=new FileReader("administratorList.txt");
            read=new BufferedReader(readFile);
            String recovered="";
            while(read.ready()){
                Administrator administrator = new Administrator("","","",0,"","","");
                recovered=read.readLine();
                String[]data=recovered.split(",");
                administrator.setNamePerson(data[0]);
                administrator.setIdPerson(data[1]);
                administrator.setGenderPerson(data[2]);
                administrator.setAgePerson(Integer.parseInt(data[3]));
                administrator.setAdministratorUSer(data[4]);
                administrator.setAdministratorPassword(data[5]);
                administrator.setAdministratorCode(data[6]);
                administratorList.add(administrator);
            }
            read.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdministratorList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdministratorList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Administrator> getAdministratorList() {
        return administratorList;
    }

    public void setAdministratorList(ArrayList<Administrator> administratorList) {
        this.administratorList = administratorList;
    }
    
    
}

