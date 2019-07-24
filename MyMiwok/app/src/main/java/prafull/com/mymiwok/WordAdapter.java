package prafull.com.mymiwok;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();


    public WordAdapter(@NonNull Activity context, ArrayList<Word> objects) {
        super(context, 0,objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
// Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_lv, parent, false);
        }
        Word wrd=getItem(position);

        TextView defaulTrans=listItemView.findViewById(R.id.defaultTransl);
        defaulTrans.setText(wrd.getDefaultTranslation());

        TextView miwokTrans=listItemView.findViewById(R.id.miwokTransl);
        miwokTrans.setText(wrd.getMiwokTranslation());


        ImageView img=listItemView.findViewById(R.id.list_item_icon);
        img.setBackgroundResource(R.color.icon_color);
        img.setImageResource(wrd.getmImageResourceId());


        ImageView img1=listItemView.findViewById(R.id.img);
        img1.setImageResource(wrd.getmImageResourceId2());


        return  listItemView;
    }


}

