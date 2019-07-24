package prafull.com.mymiwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        ArrayList<Family> words= new ArrayList<Family>();
        words.add(new Family("father","әpә",R.drawable.family_father,R.drawable.ic_play_arrow_black_24dp));
        words.add(new Family("mother","әṭa",R.drawable.family_mother,R.drawable.ic_play_arrow_black_24dp));
        words.add(new Family("son","angsi",R.drawable.family_son,R.drawable.ic_play_arrow_black_24dp));
        words.add(new Family("daughter","tune",R.drawable.family_daughter,R.drawable.ic_play_arrow_black_24dp));
        words.add(new Family("older  brother" +
                "","taachi",R.drawable.family_older_brother,R.drawable.ic_play_arrow_black_24dp));
        words.add(new Family("younger  brother" +
                "","older sister",R.drawable.family_older_sister,R.drawable.ic_play_arrow_black_24dp));
        words.add(new Family("younger sister","teṭe",R.drawable.family_younger_sister,R.drawable.ic_play_arrow_black_24dp));
        words.add(new Family("grandmother","kolliti",R.drawable.family_grandmother,R.drawable.ic_play_arrow_black_24dp));
        words.add(new Family("grandfather","ama",R.drawable.family_grandfather,R.drawable.ic_play_arrow_black_24dp));


        ListView lv1=findViewById(R.id.famlsv);

        lv1.setBackgroundResource(R.color.category_family);
        FamilyAdapter arrayAdapter=new FamilyAdapter(this,words);
        lv1.setAdapter(arrayAdapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0) {

                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, R.raw.family_father);
                    mediaPlayer.start();

                }else if(position==1)
                {

                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, R.raw.family_mother);
                    mediaPlayer.start();

                }
                else if(position==2)
                {

                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, R.raw.family_son);
                    mediaPlayer.start();

                }else if(position==3)
                {

                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, R.raw.family_daughter);
                    mediaPlayer.start();

                }else if(position==4)
                {

                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, R.raw.family_older_brother);
                    mediaPlayer.start();

                }else if(position==5)
                {

                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, R.raw.family_younger_brother);
                    mediaPlayer.start();

                }else if(position==6)
                {

                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, R.raw.family_younger_sister);
                    mediaPlayer.start();

                }else if(position==7)
                {

                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, R.raw.family_grandmother);
                    mediaPlayer.start();

                }else if(position==8)
                {

                    mediaPlayer = MediaPlayer.create(FamilyActivity.this, R.raw.family_grandfather);
                    mediaPlayer.start();

                }

            }
        });
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // because we no longer need it.
            if(mediaPlayer.isPlaying())
                mediaPlayer.stop();
            mediaPlayer.reset();
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
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
