package prafull.com.mymiwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhraseActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase);
        ArrayList<Phrase> words= new ArrayList<Phrase>();
        words.add(new Phrase("Where are you going?" +
                "","minto wuksus" +
                "",R.drawable.ic_play_arrow_black_24dp));
        words.add(new Phrase("What is your name?" +
                "","tinnә oyaase'nә" +
                "",R.drawable.ic_play_arrow_black_24dp));
        words.add(new Phrase("My name is..." ,"oyaaset..." +
                "",R.drawable.ic_play_arrow_black_24dp));
        words.add(new Phrase("How are you feeling?" +
                "","michәksәs?" +
                "",R.drawable.ic_play_arrow_black_24dp));
        words.add(new Phrase("I’m feeling good." +
                "","kuchi achit" +
                "",R.drawable.ic_play_arrow_black_24dp));
        words.add(new Phrase("Are you coming?" +
                "","әәnәs'aa?",R.drawable.ic_play_arrow_black_24dp));
        words.add(new Phrase("Yes, I’m coming." ,"hәә’ әәnәm" +
                "",R.drawable.ic_play_arrow_black_24dp));
        words.add(new Phrase("I’m coming.","әәnәm" +
                "",R.drawable.ic_play_arrow_black_24dp));

        ListView lv1=findViewById(R.id.phlsv);

        lv1.setBackgroundResource(R.color.category_phrases);
        PhraseAdapter arrayAdapter=new PhraseAdapter(this,words);
        lv1.setAdapter(arrayAdapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0) {
                    mediaPlayer = MediaPlayer.create(PhraseActivity.this, R.raw.phrase_where_are_you_going);
                    mediaPlayer.start();
                }else if(position==1)
                {
                    mediaPlayer = MediaPlayer.create(PhraseActivity.this, R.raw.phrase_what_is_your_name);
                    mediaPlayer.start();
                }
                else if(position==2)
                {
                    mediaPlayer = MediaPlayer.create(PhraseActivity.this, R.raw.phrase_my_name_is);
                    mediaPlayer.start();
                }else if(position==3)
                {
                    mediaPlayer = MediaPlayer.create(PhraseActivity.this, R.raw.phrase_how_are_you_feeling);
                    mediaPlayer.start();
                }else if(position==4)
                {
                    mediaPlayer = MediaPlayer.create(PhraseActivity.this, R.raw.phrase_im_feeling_good);
                    mediaPlayer.start();
                }else if(position==5)
                {
                    mediaPlayer = MediaPlayer.create(PhraseActivity.this, R.raw.phrase_are_you_coming);
                    mediaPlayer.start();
                }else if(position==6)
                {
                    mediaPlayer = MediaPlayer.create(PhraseActivity.this, R.raw.phrase_yes_im_coming);
                    mediaPlayer.start();
                }else if(position==7)
                {
                    mediaPlayer = MediaPlayer.create(PhraseActivity.this, R.raw.phrase_im_coming);
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
            if(mediaPlayer.isPlaying())
                mediaPlayer.stop();
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
