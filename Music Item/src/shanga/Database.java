package shanga;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.eq;


public class Database {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public Database() {
        mongoClient = MongoClients.create("mongodb+srv://shangeeran:shanga@shanga-c6536.mongodb.net/test?retryWrites=true&w=majority");
        database = mongoClient.getDatabase("MusicStore");
        collection = database.getCollection("MusicItem");
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
    }
    public List<Document> getData(){
        List<Document> documents = new ArrayList<Document>();
        for (Document cur : collection.find()) {
            documents.add(cur);
        }
        return documents;
    }

    public List<Document> getData(String title, String find){
        List<Document> documents = new ArrayList<Document>();
        for (Document cur : collection.find(eq(title,find))) {
            documents.add(cur);
        }
        return documents;
    }
    public List<Document> getData(String title, int find){
        List<Document> documents = new ArrayList<Document>();
        for (Document cur : collection.find(eq(title,find))) {
            documents.add(cur);
        }
        return documents;
    }
    public List<Document> getData(String title){
        List<Document> documents = new ArrayList<Document>();
        for (Document cur : collection.find(eq("Title",title))) {
            documents.add(cur);
        }
        return documents;
    }
    public void insert (Cd cd){
        System.out.println("Music Items are updating on CD");
        System.out.println("Please wait..........");
        Document document = new Document("Item Id", cd.getItemID())
                .append("Title", cd.getTitle())
                .append("Genre", cd.getGenre())
                .append("Date", cd.getDate())
                .append("Artist", cd.getArtist())
                .append("Price", cd.getPrice())
                .append("Duration",cd.getDuration())
                .append("Type","CD");
        collection.insertOne(document);
        System.out.println("Successfully Items Updated.");
        System.out.println("");
    }

    public void insert (Vinyl vinyl){
        System.out.println("Music Items are updating on Vinyl");
        System.out.println("Please wait..........");
        Document document = new Document("Item Id", vinyl.getItemID())
                .append("Title", vinyl.getTitle())
                .append("Genre", vinyl.getGenre())
                .append("Date", vinyl.getDate())
                .append("Artist", vinyl.getArtist())
                .append("Speed", vinyl.getSpeed())
                .append("Diameter", vinyl.getDiameter())
                .append("Price", vinyl.getPrice())
                .append("Type","Vinyl");
        collection.insertOne(document);
        System.out.println("Successfully Items Updated.");
        System.out.println("");
    }

    public void delete(Document document) {
        System.out.println("Yes, Id Founded");
        System.out.println("Deleting.....");
        collection.deleteOne(eq("Item Id",document.get("Item Id")));
        System.out.println("Successfully Items Deleted.");
        System.out.println("");
    }
}
