package cs.ualberta.ca.feelsbook;

import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.Date;

public class Entry implements Serializable,Comparable {

    protected String comment;
    protected int img;
    protected Date date;
    private static final Integer MAX_CHARS = 100;

    //sets msg if under 100 chars
    public void setMessage(String message) throws TooLongEx{

        if (message.length() <= MAX_CHARS){
            this.comment = message;

        }else {
            throw new TooLongEx();
        }
    }
    //changes date to string
    public String dateToString(){
        return getDate().toString();
    }

    //sets image
    public void setImage(int img){
        this.img = img;
    }

    //gets image
    public int getImage(){ return this.img;}

    //sets Date
    public void setDate(Date date) { this.date = date;}

    //gets comment
    public String getComment(){return this.comment;}

    //gets date
    public Date getDate(){ return this.date;}

    //compares two date objects
    @Override
    public int compareTo(Object o) {
        return this.getDate().compareTo(((Entry)o).getDate());
    }
}
