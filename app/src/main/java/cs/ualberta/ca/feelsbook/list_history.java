package cs.ualberta.ca.feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class list_history extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_history);

        //creates listview
        ListView listView = findViewById(R.id.oldEntryList);

        EntryListController.getEntryList().sort();
        ArrayList<Entry> entries = EntryListController.getEntryList().getEntries();

        //calls adapter for custom view
        CustomAdapter entryAdapter = new CustomAdapter(this,entries);
        entryAdapter.notifyDataSetChanged();
        listView.setAdapter(entryAdapter);


        //EntryListController.getEntryList().addListener(new Listener() {
         ///   @Override
           // public void update() {
             //   entries.clear();
               // ArrayList<Entry> updated = EntryListController.getEntryList().getEntries();
                //entries.addAll(updated);
                //entryAdapter.notifyDataSetChanged();
                //System.out.println("wyd?");
            //}
        //});

    }


}
