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
public class MongoDBManager implements NoSQLDBManager {

    String cluster;
    MongoClientURI uri;
    MongoClient mongoClient;
    MongoDatabase db;
    MongoCollection collection;
    String keyName = "";

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public void selectCollection(String table) {
        collection = db.getCollection(table);
    }

    @Override
    public boolean openConnection(String dataBaseName) {
        try {
            cluster = "mongodb+srv://rebuse:08152000@cluster0.dtqjv.mongodb.net/DataBase?retryWrites=true&w=majority";
            uri = new MongoClientURI(cluster);
            mongoClient = new MongoClient(uri);
            db = mongoClient.getDatabase(dataBaseName);
            return true;
        } catch (IndexOutOfBoundsException ex) {
            return false;
        }
    }

    @Override
    public boolean save(String data, String table) {
        selectCollection(table);
        Document dc = Document.parse(data);
        collection.insertOne(dc);
        return true;
    }

    @Override
    public String read(String table) {
        selectCollection(table);
        String json = "";
        MongoCursor<Document> documents;
        documents = collection.find().iterator();
        while (documents.hasNext()) {
            Document document = new Document();
            document = documents.next();
            document.remove("_id");
            json = json + document.toJson() + "\r\n";
        }
        return json;
    }

    @Override
    public boolean update(String dataTofind, String dataToupdate, String table) {
        selectCollection(table);
        boolean status;
        status = verifyExistingData(dataTofind,table);
        if (status == true) {
            Document findDocument = new Document(keyName, dataTofind);
            Document updateDocument = new Document("$set", new Document(keyName, dataToupdate));
            collection.findOneAndUpdate(findDocument, updateDocument);
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    @Override
    public boolean delete(String dataToDelete, String table) {
        selectCollection(table);
        boolean status;
        status = verifyExistingData(dataToDelete,table);
        if (status == true) {
            Document findDocument = new Document(keyName, dataToDelete);
            collection.findOneAndDelete(findDocument);
            status = true;
        } else {
            status = false;
        }
        return status;
    }

    @Override
    public String find(String dataToFind, String table) {
        selectCollection(table);
        String jsonFind = "";
        MongoCursor<Document> documents;
        documents = collection.find().iterator();
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
    public boolean verifyExistingData(String dataToFind,String table) {
        selectCollection(table);
        boolean isRegistered;
        isRegistered = false;
        MongoCursor<Document> documents;
        documents = this.collection.find().iterator();
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
}
