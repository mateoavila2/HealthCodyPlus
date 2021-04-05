/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.simulatorHealthCody.utils;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.Properties;
import java.util.Set;
import org.bson.Document;

/**
 *
 * @author Rafa
 */
public class NosqlDBManager implements DataPersistence {

    Connection cn;
    private String keyName = "";

    public NosqlDBManager(String dbName, String collection) {
        cn = new Connection(dbName, collection);
    }

    @Override
    public boolean save(String data) {
        
        Document dc = Document.parse(data);
        cn.getCollection().insertOne(dc);
        return true;
    }

    @Override
    public String read() {
        String json = "";
        MongoCursor<Document> documents;
        documents = cn.getCollection().find().iterator();

        while (documents.hasNext()) {
            Document document = new Document();
            document = documents.next();
            document.remove("_id");
            json = json + document.toJson() + "\r\n";
        }
        return json;
    }

    @Override
    public boolean update(String dataTofind, String dataToupdate) {
        boolean status;

        status = verifyExistingData(dataTofind);

        if (status == true) {
            Document findDocument = new Document(keyName, dataTofind);

            Document updateDocument = new Document("$set", new Document(keyName, dataToupdate));

            cn.getCollection().findOneAndUpdate(findDocument, updateDocument);

            status = true;
        } else {
            status = false;
        }

        return status;
    }

    @Override
    public boolean delete(String dataToDelete) {
        boolean status;

        status = verifyExistingData(dataToDelete);
        if (status == true) {
            Document findDocument = new Document(keyName, dataToDelete);

            cn.getCollection().findOneAndDelete(findDocument);

            status = true;
        } else {
            status = false;
        }

        return status;
    }

    @Override
    public String find(String dataToFind) {
        String jsonFind = "";
        MongoCursor<Document> documents;
        documents = cn.getCollection().find().iterator();

        while (documents.hasNext()) {
            Gson gson = new Gson();
            Document document = new Document();
            document = documents.next();
            document.remove("_id");
            String json;
            json = document.toJson();
            Properties properties = (Properties) gson.fromJson(json, Properties.class);
            Set<String> keys = properties.stringPropertyNames();
            for (String key : keys) {
                if (dataToFind.equals(properties.getProperty(key))) {

                    jsonFind = jsonFind + json + "\r\n";
                }
            }

        }
        return jsonFind;
    }

    public boolean verifyExistingData(String dataToFind) {

        boolean isRegistered;
        isRegistered = false;
        MongoCursor<Document> documents;
        documents = cn.getCollection().find().iterator();

        while (documents.hasNext()) {
            Gson gson = new Gson();
            Document document = new Document();
            document = documents.next();
            document.remove("_id");
            String json;
            json = document.toJson();
            Properties properties = (Properties) gson.fromJson(json, Properties.class);
            Set<String> keys = properties.stringPropertyNames();
            for (String key : keys) {
                if (dataToFind.equals(properties.getProperty(key))) {
                    isRegistered = true;
                }
            }

        }
        return isRegistered;

    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

}
