package prafull.com.mymiwok;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        ArrayList<Color> words= new ArrayList<Color>();
        words.add(new Color("red","weṭeṭṭi",R.drawable.color_red,R.drawable.ic_play_arrow_black_24dp));
        words.add(new Color("green","chokokki",R.drawable.color_green,R.drawable.ic_play_arrow_black_24dp));
        words.add(new Color("brown","ṭakaakki",R.drawable.color_brown,R.drawable.ic_play_arrow_black_24dp));
        words.add(new Color("gray","ṭopoppi",R.drawable.color_gray,R.drawable.ic_play_arrow_black_24dp));
        words.add(new Color("black","kululli",R.drawable.color_black,R.drawable.ic_play_arrow_black_24dp));
        words.add(new Color("white","kelelli",R.drawable.color_white,R.drawable.ic_play_arrow_black_24dp));
        words.add(new Color("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow,R.drawable.ic_play_arrow_black_24dp));
        words.add(new Color("mustard yellow"
                ,"chiwiiṭә",R.drawable.color_mustard_yellow,R.drawable.ic_play_arrow_black_24dp));


        ListView lv1=findViewById(R.id.colsv);

        lv1.setBackgroundResource(R.color.category_colors);
        ColorAdapter arrayAdapter=new ColorAdapter(this,words);
        lv1.setAdapter(arrayAdapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {

                    mediaPlayer = MediaPlayer.create(ColorActivity.this, R.raw.color_red);
                    mediaPlayer.start();

                }else if(position==1)
                {

                    mediaPlayer = MediaPlayer.create(ColorActivity.this, R.raw.color_green);
                    mediaPlayer.start();

                }
                else if(position==2)
                {

                    mediaPlayer = MediaPlayer.create(ColorActivity.this, R.raw.color_brown);
                    mediaPlayer.start();

                    }else if(position==3)
                {

                    mediaPlayer = MediaPlayer.create(ColorActivity.this, R.raw.color_gray);
                    mediaPlayer.start();

                }else if(position==4)
                {

                    mediaPlayer = MediaPlayer.create(ColorActivity.this, R.raw.color_black);
                    mediaPlayer.start();


                }else if(position==5)
                {

                    mediaPlayer = MediaPlayer.create(ColorActivity.this, R.raw.color_white);
                    mediaPlayer.start();

                }else if(position==6)
                {

                    mediaPlayer = MediaPlayer.create(ColorActivity.this, R.raw.color_dusty_yellow);
                    mediaPlayer.start();
                }
                else if(position==7)
                {

                    mediaPlayer = MediaPlayer.create(ColorActivity.this, R.raw.color_mustard_yellow);
                    mediaPlayer.start();
                    }

            }
        });
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            // because we no longer need it.

            mediaPlayer.reset();
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
