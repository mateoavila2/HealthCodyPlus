/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.DBmanager.utils;

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
public class DBmanagerDates {

    String cluster;
    MongoClientURI uri;
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection collection;

    public DBmanagerDates(String dataBaseName, String collectionName) {
        cluster = "mongodb+srv://rebuse:08152000@cluster0.dtqjv.mongodb.net/DataBase?retryWrites=true&w=majority";
        uri = new MongoClientURI(cluster);
        mongoClient = new MongoClient(uri);
        database = mongoClient.getDatabase(dataBaseName);
        collection = database.getCollection(collectionName);
    }

    public void createDate(String date, String code) {
        Document dc = new Document("date", date).append("code", code);
        collection.insertOne(dc);
    }

    public String readDate() {
        String dates = "";
        MongoCursor<Document> documents;
        documents = collection.find().iterator();

        while (documents.hasNext()) {
            Document document = new Document();
            document = documents.next();
            document.remove("_id");
            dates = dates + document.get("date").toString() + "\r\n";
        }
        return dates;
    }

    public String readASpecificDate(String dataToFind) {
        String dateFound = "";
        MongoCursor<Document> documents;
        documents = collection.find().iterator();

        while (documents.hasNext()) {
            Gson gson = new Gson();
            Document document = new Document();
            document = documents.next();
            document.remove("_id");
            String recovered;
            recovered = document.get("code").toString();
            //Properties properties = (Properties) gson.fromJson(recovered, Properties.class);
            //Set<String> keys = properties.stringPropertyNames();
            //for (String key : keys) {
                if (dataToFind.equals(recovered)) {

                    dateFound = document.get("date").toString() + "\r\n";
                }
            //}

        }
        return dateFound;

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