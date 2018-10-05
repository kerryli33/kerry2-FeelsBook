package cs.ualberta.ca.feelsbook;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class EntryList{

    //makes counts of emotions
    static public int joy_count =0;
    static public int surprised_count =0;
    static public int angry_count =0;
    static public int love_count =0;
    static public int sad_count =0;
    static public int fear_count =0;

    //creates listeners and entry arrays
    protected ArrayList<Entry> entryList;
    protected ArrayList<Listener> listeners;

    public EntryList() {

        entryList = new ArrayList<Entry>();
        listeners = new ArrayList<Listener>();
    }

    //returns entry list
    public ArrayList<Entry> getEntries(){
        return entryList;
    }

    //adds entry
    public void addEntry(Entry entry){
        entryList.add(entry);
    }

    //ads entry
    public void removeEntry(Entry entry){
        entryList.remove(entry);
    }

    //sorts entrylist for ordering
    public void sort(){
        Collections.sort(entryList);

    }
    //notifys for activity and updates
    public void notifyListeners(){
        for (Listener listener: listeners) {
            listener.update();
        }
    }
    //adds listener
    public void addListener(Listener l){
        listeners.add(l);
    }

    //removes listener
    public void removeListener(Listener l){
        listeners.remove(l);
    }

}
