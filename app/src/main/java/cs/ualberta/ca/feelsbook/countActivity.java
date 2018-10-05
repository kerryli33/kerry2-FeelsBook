package cs.ualberta.ca.feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class countActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_count);

        //finds view for texts
        TextView fear_text = (TextView) findViewById(R.id.count_fear);
        TextView sad_text = (TextView)  findViewById(R.id.count_sad);
        TextView joy_text = (TextView)  findViewById(R.id.count_joy);
        TextView anger_text = (TextView)  findViewById(R.id.count_angry);
        TextView surprised_text = (TextView)  findViewById(R.id.count_surprised);
        TextView love_text = (TextView)  findViewById(R.id.count_love);

        //finds counts
        int fear_count = EntryList.fear_count;
        int sad_count = EntryList.sad_count;
        int joy_count = EntryList.joy_count;
        int anger_count = EntryList.angry_count;
        int surprised_count = EntryList.surprised_count;
        int love_count = EntryList.love_count;

        //concatenates string and count
        String fear = "Fear: \t" + Integer.toString(fear_count);
        String sad = "Sad: \t" + Integer.toString(sad_count);
        String joy = "Joy: \t" + Integer.toString(joy_count);
        String anger = "Anger: \t" + Integer.toString(anger_count);
        String surprised = "Surprised:  \t" + Integer.toString(surprised_count);
        String love = "Love: \t" + Integer.toString(love_count);

        //sets text to View
        fear_text.setText(fear);
        sad_text.setText(sad);
        joy_text.setText(joy);
        anger_text.setText(anger);
        surprised_text.setText(surprised);
        love_text.setText(love);




    }
}
