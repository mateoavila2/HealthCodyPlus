/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.utils;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kenneth Andrade ESPE-DCCO
 */
public class JsonManager implements FileManager {

    @Override
    public boolean save(String data, String table) {
        boolean status = false;
        try {
            File f = new File(table + ".json");
            FileWriter file = new FileWriter(table + ".json", true);
            if (f.exists()) {
                BufferedWriter write = new BufferedWriter(file);
                write.write(data);
                write.write("\n");
                write.close();
                status = true;
            } else {
                file = new FileWriter(table + ".json", true);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, (String) null, ex);
            status = false;
        }
        return status;
    }

    @Override
    public String read(String table) {
        String readLine = "";
        String allData = "";
        try {
            File f = new File(table + ".json");
            FileReader file = new FileReader(table + ".json");
            if (f.exists()) {
                BufferedReader read = new BufferedReader(file);
                String line;
                while ((line = read.readLine()) != null) {
                    allData = allData + line + "\r\n";
                }
                read.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
        return allData;
    }

    @Override
    public boolean update(String dataTofind, String dataToupdate, String table) {
        boolean update = false;
        String newLine = "";
        Gson gson = new Gson();
        try {
            FileReader readFile = new FileReader(table + ".json");
            BufferedReader read = new BufferedReader(readFile);
            String line;
            while ((line = read.readLine()) != null) {
                Properties properties = (Properties) gson.fromJson(line, Properties.class);
                Set<String> keys = properties.stringPropertyNames();
                for (String key : keys) {
                    if (dataTofind.equals(properties.getProperty(key))) {
                        properties.setProperty(key, dataToupdate);
                        line = gson.toJson(properties);
                        update = true;
                    }
                }
                newLine = newLine + line + "\r\n";
            }
            read.close();
            try (FileWriter writer = new FileWriter(table + ".json")) {
                writer.write(newLine);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, (String) null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
        return update;
    }

    @Override
    public boolean delete(String dataToDelete, String table) {
        boolean deleted = false;
        boolean ignore = false;
        String newLine = "";
        Gson gson = new Gson();
        try {
            FileReader readFile = new FileReader(table + ".json");
            BufferedReader read = new BufferedReader(readFile);
            String line;
            while ((line = read.readLine()) != null) {
                Properties properties = (Properties) gson.fromJson(line, Properties.class);
                Set<String> keys = properties.stringPropertyNames();
                for (String key : keys) {
                    if (dataToDelete.equals(properties.getProperty(key))) {
                        ignore = true;
                        deleted = true;
                    }
                }
                if (!ignore) {
                    newLine = newLine + line + "\r\n";
                    continue;
                }
                ignore = false;
            }
            read.close();
            try (FileWriter writer = new FileWriter(table + ".json")) {
                writer.write(newLine);
                writer.close();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, (String) null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
        return deleted;
    }

    @Override
    public String find(String dataToFind, String table) {

        String findLine = "";
        Gson gson = new Gson();
        try {
            FileReader readFile = new FileReader(table + ".json");
            BufferedReader read = new BufferedReader(readFile);
            String line;
            while ((line = read.readLine()) != null) {
                Properties properties = (Properties) gson.fromJson(line, Properties.class);
                Set<String> keys = properties.stringPropertyNames();
                for (String key : keys) {
                    if (dataToFind.equals(properties.getProperty(key))) {

                        findLine = findLine + line + "\r\n";
                    }
                }
            }
            read.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, (String) null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
        return findLine;
    }

    @Override
    public boolean verifyData(String dataToFind, String table) {
        boolean verify = false;
        String readLine = "";
        Gson gson = new Gson();
        try {
            FileReader readFile = new FileReader(table+".json");
            BufferedReader read = new BufferedReader(readFile);
            String line;
            while ((line = read.readLine()) != null) {
                Properties properties = (Properties) gson.fromJson(line, Properties.class);
                Set<String> keys = properties.stringPropertyNames();
                for (String key : keys) {
                    if (dataToFind.equals(properties.getProperty(key))) {
                        verify = true;
                    }
                }
            }
            read.close();
            if (!verify) {
                System.out.println("Dato no encontrado");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, (String) null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, (String) null, ex);
        }
        return verify;
    }
}
