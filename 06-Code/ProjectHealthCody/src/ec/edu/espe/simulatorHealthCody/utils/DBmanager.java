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
public class DBmanager {

    String cluster;
    MongoClientURI uri;
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection collection;

    public DBmanager(String dataBaseName, String collectionName) {
        cluster = "mongodb+srv://rebuse:08152000@cluster0.dtqjv.mongodb.net/DataBase?retryWrites=true&w=majority";
        uri = new MongoClientURI(cluster);
        mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase(dataBaseName);
        collection = database.getCollection(collectionName);
    }

    public void create(String json) {
        Document dc = Document.parse(json);
        collection.insertOne(dc);
    }

    public String read() {
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

    public String readByFilter(String dataToFind) {
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

    public boolean verifyExistingData(String dataToFind) {
        boolean isRegistered;
        isRegistered = false;
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
                    isRegistered = true;
                }
            }

        }
        return isRegistered;

    }

    public void update(String dataToFind, String dataToUpdate, String keyName) {
        Document findDocument = new Document(keyName, dataToFind);

        Document updateDocument = new Document("$set", new Document(keyName, dataToUpdate));

        collection.findOneAndUpdate(findDocument, updateDocument);
    }

    public void delete(String keyName, String dataToDelete) {
        Document findDocument = new Document(keyName, dataToDelete);

        collection.findOneAndDelete(findDocument);

    }

}