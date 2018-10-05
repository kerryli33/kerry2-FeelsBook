package cs.ualberta.ca.feelsbook;

public class EntryListController {
    private static EntryList entryList = null;

    //creates entrylist if none and/or returns it
    public static EntryList getEntryList(){
        if (entryList == null){
            entryList = new EntryList();

        }
        return entryList;
    }

    //adds entry to entryList
    public void addEntry(Entry entry) {
        getEntryList().addEntry(entry);
    }

    //removes entry from entryList
    static public void removeEntry(Entry entry){   getEntryList().removeEntry(entry); }




}
