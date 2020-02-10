import java.util.List;

public interface StoreManager {
    void addNewItem(MusicItem item) throws StoreFullException;

    boolean deleteItem(MusicItem item);
    void printList();

    void sortItem();

    void buyItem(MusicItem item) throws StoreItemNotFoundException;
    void generateReport();
    void searchItem();


}
