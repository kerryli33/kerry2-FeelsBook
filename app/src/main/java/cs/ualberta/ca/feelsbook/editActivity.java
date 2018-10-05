package cs.ualberta.ca.feelsbook;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import static java.security.AccessController.getContext;

public class editActivity extends AppCompatActivity implements View.OnClickListener,TimePickerDialog.OnTimeSetListener{
    private String selected;
    private Entry entry;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_entry);

        //Set Spinner Values
        final Spinner spinner = (Spinner) findViewById(R.id.edit_emo_list);                                                            //Change ID
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.emotions_dropdown, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        //Get the Entry from Intent
        Bundle extras = getIntent().getExtras();
        Entry entry = (Entry) extras.getSerializable("Entry");
        this.entry = entry;
        int position = extras.getInt("Position");
        this.position = position;
        System.out.println("juan2  \t"+ this.entry);




        if (entry != null) {


            TextView textinput = (TextView) findViewById(R.id.edit_new_comment_input);                                          //Change ID
            textinput.setText(entry.getComment());

            //Finds the original chosen emoji so Spinner starts at that emoji
            String compareValue = "";
            switch (entry.getImage()) {
                case R.drawable.angry:
                    compareValue = "Anger";
                    break;

                case R.drawable.sad:
                    compareValue = "Sadness";
                    break;

                case R.drawable.joy:
                    compareValue = "Joy";
                    break;

                case R.drawable.love:
                    compareValue = "Love";
                    break;

                case R.drawable.fear:
                    compareValue = "Fear";
                    break;

                case R.drawable.surprised:
                    compareValue = "Surprised";
                    break;

            }
            //Find the position of emoticon in spinner
            int spinnerPosition = adapter.getPosition(compareValue);
            spinner.setSelection(spinnerPosition);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int pos, long resId) {
                    editActivity.this.setChosen(String.valueOf(spinner.getItemAtPosition(pos)));
                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub

                }
            });

            //Initializing onclick save and delete buttons
            Button saveButton = (Button) findViewById(R.id.edit_save);
            saveButton.setOnClickListener(this);

            Button deleteButton = (Button) findViewById(R.id.edit_delete);
            deleteButton.setOnClickListener(this);


        }
        //Initializing onclick clock picker
        Button chooser = (Button) findViewById(R.id.date_chooser);
        chooser.setOnClickListener(this);
    }
    public void setChosen(String text){
        this.selected = text;
    }
    public void onClick(View v) {
        switch (v.getId()) {

            //if click was on date button
            case R.id.date_chooser:
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "Time Picker ");
                break;
            //if click was on save
            case R.id.edit_save:
                TextView view = (TextView) findViewById(R.id.edit_new_comment_input);
                String text = view.getText().toString();
                try {
                    this.entry.setMessage(text);
                }catch (TooLongEx e){
                    System.err.println("Comment is too long \n");

                }





                //this.entry.setImage();
                break;

                // if click was on delete button
            case R.id.edit_delete:

                //initiates Dialogue options
                AlertDialog.Builder adb = new AlertDialog.Builder(this);
                adb.setMessage("Are you sure you want to delete this entry?");
                adb.setCancelable(true);
                adb.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int pos = CustomAdapter.entries.indexOf(editActivity.this.entry);

                        EntryListController.removeEntry(entry);
                        CustomAdapter.removeEntry(pos);
                        Intent intent = new Intent(editActivity.this,list_history.class);
                        startActivity(intent);
                    }
                });
                adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                adb.show();
                break;
        }
    }
    //sets Time on textview
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView text = (TextView) findViewById(R.id.display_date);
        String time = Integer.toString(hourOfDay) + ":" + Integer.toString(minute);
        text.setText(time);
    }
}
