package cs.ualberta.ca.feelsbook;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class CustomAdapter extends ArrayAdapter<Entry> implements View.OnClickListener {

    private int position;
    public static ArrayList<Entry> entries;

    //constructor
    CustomAdapter(Context context, ArrayList<Entry> entries){
        super(context, R.layout.custom_row,entries);
        this.entries = entries;


    }

    //finds custom view and creates ListView
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        //buffers view
        LayoutInflater viewInflater = LayoutInflater.from(getContext());
        View customView = viewInflater.inflate(R.layout.custom_row,parent, false);

        Entry entry = getItem(position);

        //inserts comments
        String text = entry.getComment();
        TextView comment = (TextView) customView.findViewById(R.id.custom_comment);
        comment.setText(text);

        //inserts image
        int id = entry.getImage();
        ImageView img = (ImageView) customView.findViewById(R.id.custom_img);
        img.setImageResource(id);

        String the_date = entry.dateToString();
        TextView date = (TextView) customView.findViewById(R.id.custom_date);
        date.setText(the_date);


        //edit button
        this.position = position;
        System.out.println("what??" +this.position);
        Button button = (Button) customView.findViewById(R.id.custom_edit);
        button.setOnClickListener(this);

        return customView;

    }

    @Override
    public void onClick(View v) {
        //packs entry and position with intent and initiates transition to editActivity
        Intent intent = new Intent(getContext(),editActivity.class);
        System.out.println("what???" + Integer.toString(this.position));
        intent.putExtra("Entry",getItem(this.position));
        intent.putExtra("Position",this.position);
        getContext().startActivity(intent);
    }
    static public void removeEntry(int position){
        entries.remove(position);
    }
    public void update(){
        this.notifyDataSetChanged();
    }

}
