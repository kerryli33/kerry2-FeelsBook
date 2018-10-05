package cs.ualberta.ca.feelsbook;

import android.app.ListActivity;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class FeelsBookMainActivity extends AppCompatActivity
        implements View.OnClickListener{

    private EditText commentText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feels_book_main);
        //initialize buttons and texts
        commentText = (EditText) findViewById(R.id.main_comment);
        ImageButton joy_button = (ImageButton) findViewById(R.id.joy_image5);
        ImageButton love_button = (ImageButton) findViewById(R.id.love_image3);
        ImageButton surprised_button = (ImageButton) findViewById(R.id.surprised_image3);
        ImageButton fear_button = (ImageButton) findViewById(R.id.fear_image3);
        ImageButton angry_button = (ImageButton) findViewById(R.id.angry_image3);
        ImageButton sad_button = (ImageButton) findViewById(R.id.sad_image3);

        //set on click for the buttons/text
        joy_button.setOnClickListener(this);
        love_button.setOnClickListener(this);
        surprised_button.setOnClickListener(this);
        fear_button.setOnClickListener(this);
        angry_button.setOnClickListener(this);
        sad_button.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        String text;
        switch(v.getId()){
            case R.id.joy_image5:

                int img = R.drawable.joy;
                text = commentText.getText().toString();
                EntryList.joy_count++;
                addEntryAction(v,text,img,new Date());
                break;

            case R.id.love_image3:
                text = commentText.getText().toString();
                int img2 = R.drawable.love;
                EntryList.love_count++;
                addEntryAction(v,text,img2,new Date());
                break;

            case R.id.surprised_image3:
                text = commentText.getText().toString();
                int img3 = R.drawable.surprised;
                EntryList.surprised_count++;
                addEntryAction(v,text,img3,new Date());
                break;

            case R.id.fear_image3:
                text = commentText.getText().toString();
                int img4 = R.drawable.fear;
                EntryList.fear_count++;
                addEntryAction(v,text,img4,new Date());
                break;

            case R.id.angry_image3:
                text = commentText.getText().toString();
                int img5 = R.drawable.angry;
                EntryList.angry_count++;
                addEntryAction(v,text,img5,new Date());
                break;

            case R.id.sad_image3:
                String text6 = commentText.getText().toString();
                int img6 = R.drawable.sad;
                EntryList.sad_count++;
                addEntryAction(v,text6,img6,new Date());
                break;
        }
    }

    private void addEntryAction(View v, String text, int img, Date date) {
        try{
            Entry entry = new Entry();
            entry.setMessage(text);
            entry.setImage(img);
            entry.setDate(date);
            Toast.makeText(this,"Adding emotion entry to log", Toast.LENGTH_SHORT).show();
            EntryListController ec = new EntryListController();
            ec.addEntry(entry);

        }catch(TooLongEx e){
            System.err.println("Comment is too long \n");
        }
    }

    protected void onStart(){
        super.onStart();

    }

    //initiates intent to move to history from navigation bar
    public void displayHist(MenuItem menu){
        Toast.makeText(this,"Log History",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(FeelsBookMainActivity.this, list_history.class);
        startActivity(intent);

    }
    //initiates intent to move to entry from navigation bar
    public void displayEntry(MenuItem menu){
        Toast.makeText(this,"New Entry",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(FeelsBookMainActivity.this, FeelsBookMainActivity.class);
        startActivity(intent);
    }

    //initiates intent to move to count screen from navigation bar
    public void displayCount(MenuItem menu){
        Toast.makeText(this,"Count list",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(FeelsBookMainActivity.this, countActivity.class);
        startActivity(intent);
    }
}
