import java.util.*;

public class WestminsterMusicStoreManager implements StoreManager {

    private List<MusicItem> storeItem = new ArrayList<MusicItem>();      //Arraylist for store item
    private List<MusicItem> boughtItem = new ArrayList<MusicItem>();              //Arraylist for items bought
    private static final int MAX_COUNT = 1000;

    public List<MusicItem> getStoreItem() {
        return storeItem;
    }

    public List<MusicItem> getBoughtItem() {
        return boughtItem;
    }


    @Override
    public void addNewItem(MusicItem item) throws StoreFullException {
        if (storeItem.size() < MAX_COUNT) {                          //Check whether the count of items is less than 1000
            storeItem.add(item);
        }else {
            throw new StoreFullException("Cannot Add. Store is Full!!");    //Exception occurs
        }
    }

    @Override
    public boolean deleteItem(MusicItem item) {
        return storeItem.remove(item);       //removes the item from the list
    }

    @Override
    public void printList() {
        new Thread(){
            @Override
            public void run() {
                javafx.application.Application.launch(InterfaceMenu.class);  //This directs to the JavaFx Application
            }
        }.start();

    }


    @Override
    public void sortItem() {

        Collections.sort(storeItem, new TitleComparator());


    }

    @Override
    public void buyItem(MusicItem item) throws StoreItemNotFoundException {
        if (storeItem.contains(item)){                                     //It checks for the item and then sorts it
            deleteItem(item);
            boughtItem.add(item);
        }else {
            throw new StoreItemNotFoundException("Item not found!!!");
        }
    }

    @Override
    public void generateReport() {

    }

    @Override
    public void searchItem() {
        new Thread(){
            @Override
            public void run() {                                            //This directs to the JavaFx Application
                javafx.application.Application.launch(InterfaceMenu.class);
            }
        }.start();

    }


}


class TitleComparator implements Comparator<MusicItem>{       //Title comparing

    @Override
    public int compare(MusicItem o1, MusicItem o2) {
        return o1.getTheTitle().compareTo(o2.getTheTitle());
    }
}
