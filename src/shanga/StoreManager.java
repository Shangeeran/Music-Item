package shanga;

import org.bson.Document;

import java.util.List;

public interface StoreManager {
    void addItems(MusicItem item);
    boolean deleteItems(MusicItem item);
    void printItems();
    void buyItems(Document document,int count);
    int availableStorage();


    void sort(List<MusicItem> list, SortCategory c);
    List<MusicItem> generateReport();

    List<MusicItem> list();
}
