package shanga;

import org.bson.Document;

import java.util.*;

public class WestminsterMusicStoreManager implements StoreManager {
    private List<MusicItem> storeItem = new ArrayList<MusicItem>();   //create an arraylist object for storeItem
    private List<MusicItem> boughtItem = new ArrayList<MusicItem>();    //create an arraylist object for boughItem
    private static final int MAX_COUNT = 1000;
    private int availableStorage;
    Database database;

    public WestminsterMusicStoreManager(){
        database = new Database();
    }

    @Override
    public void addItems(MusicItem item) {
        if (storeItem.size() < MAX_COUNT){
            storeItem.add(item);
            if(item instanceof Cd){
                database.insert((Cd) item);
            }else if(item instanceof Vinyl){
                database.insert((Vinyl) item);
            }
        }else {
            throw new IllegalArgumentException("1000 completed");
        }
    }

    @Override
    public boolean deleteItems(MusicItem item) {
        return storeItem.remove(item);
//        return false;
    }

    @Override
    public void printItems() {
        System.out.println("list of cd");
        for(MusicItem item : storeItem){
            if (item instanceof Cd){
                System.out.println(item);
            }
        }
        System.out.println("list of vynal");
        for(MusicItem item : storeItem){
            if (item instanceof Vinyl){
                System.out.println(item);
            }
        }

    }



    @Override
    public void buyItems(Document document,int count) {
        Shop shop = new Shop(document.getString("Item Id"),document.getString("Title"),document.getString("Genre"),document.getString("Date"),document.getString("Artist"),document.getDouble("Price"),count);
        boughtItem.add(shop);
        System.out.println(boughtItem.size());
    }

    @Override
    public int availableStorage() {
        return 1000-storeItem.size();
    }

    @Override
    public void sort(List<MusicItem> list, SortCategory c) {
        if (c == SortCategory.PRICE){
            Collections.sort(list);
        }else if(c == SortCategory.TITLE) {
            Collections.sort(list, new TitleComparator());
        }else if (c == SortCategory.ITEM_ID){
            Collections.sort(list, new ItemIdComparator());
        }
    }

    @Override
    public List<MusicItem> generateReport() {
        return boughtItem;
    }

    @Override
    public List<MusicItem> list() {
        return null;
    }
}

class ItemIdComparator implements Comparator<MusicItem>{

    @Override
    public int compare(MusicItem o1, MusicItem o2) {
        return o1.getItemID().compareTo(o2.getItemID());
    }
}

class TitleComparator implements Comparator<MusicItem>{

    @Override
    public int compare(MusicItem o1, MusicItem o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}