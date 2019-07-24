package prafull.com.mymiwok;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static prafull.com.mymiwok.R.*;
import static prafull.com.mymiwok.R.raw.*;

public class NumberActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(layout.activity_number);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti", drawable.number_one, drawable.ic_play_arrow_black_24dp));
        words.add(new Word("two", "ottiko", drawable.number_two, drawable.ic_play_arrow_black_24dp));
        words.add(new Word("three", "tolookosu", drawable.number_three, drawable.ic_play_arrow_black_24dp));
        words.add(new Word("four", "oyyisa", drawable.number_four, drawable.ic_play_arrow_black_24dp));
        words.add(new Word("five", "massoka", drawable.number_five, drawable.ic_play_arrow_black_24dp));
        words.add(new Word("six", "temmokka", drawable.number_six, drawable.ic_play_arrow_black_24dp));
        words.add(new Word("seven", "kenekaku", drawable.number_seven, drawable.ic_play_arrow_black_24dp));
        words.add(new Word("eight", "kawinta", drawable.number_eight, drawable.ic_play_arrow_black_24dp));
        words.add(new Word("nine", "wo'e", drawable.number_nine, drawable.ic_play_arrow_black_24dp));
        words.add(new Word("ten", "na'aache", drawable.number_ten, drawable.ic_play_arrow_black_24dp));


        ListView lv1 = findViewById(id.listv);
        lv1.setBackgroundResource(color.category_numbers);
        WordAdapter arrayAdapter = new WordAdapter(this, words);
        lv1.setAdapter(arrayAdapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    mediaPlayer = MediaPlayer.create(NumberActivity.this, R.raw.number_one);
                    mediaPlayer.start();
                } else if (position == 1) {
                    mediaPlayer = MediaPlayer.create(NumberActivity.this, raw.number_two);
                    mediaPlayer.start();
                } else if (position == 2) {
                    mediaPlayer = MediaPlayer.create(NumberActivity.this, raw.number_three);
                    mediaPlayer.start();
                } else if (position == 3) {
                    mediaPlayer = MediaPlayer.create(NumberActivity.this, raw.number_four);
                    mediaPlayer.start();
                } else if (position == 4) {
                    mediaPlayer = MediaPlayer.create(NumberActivity.this, raw.number_five);
                    mediaPlayer.start();
                } else if (position == 5) {
                    mediaPlayer = MediaPlayer.create(NumberActivity.this, raw.number_six);
                    mediaPlayer.start();
                } else if (position == 6) {
                    mediaPlayer = MediaPlayer.create(NumberActivity.this, raw.number_seven);
                    mediaPlayer.start();
                } else if (position == 7) {
                    mediaPlayer = MediaPlayer.create(NumberActivity.this, raw.number_eight);
                    mediaPlayer.start();
                } else if (position == 8) {
                    mediaPlayer = MediaPlayer.create(NumberActivity.this, raw.number_nine);
                    mediaPlayer.start();
                } else if (position == 9) {
                    mediaPlayer = MediaPlayer.create(NumberActivity.this, raw.number_ten);
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

    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mediaPlayer.pause();
                mediaPlayer.setVolume(100*0.1f,100*0.1f);
                mediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };
}
