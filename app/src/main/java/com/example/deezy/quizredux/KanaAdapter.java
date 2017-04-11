package com.example.deezy.quizredux;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by DEEZY on 09/04/2017.
 */

public class KanaAdapter extends ArrayAdapter<KanaClass> { private int mColorResourceId;

    public KanaAdapter(Activity context, ArrayList<KanaClass> kana, int colorResourceId) {

        super(context, 0, kana);
        mColorResourceId = colorResourceId;


    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.kana_item, parent, false);
        }


        KanaClass currentKana = getItem(position);

        ImageView kanaView = (ImageView) listItemView.findViewById(R.id.kanaImageView);
        kanaView.setImageResource(currentKana.getmImgRes());


        TextView romanjiTextView = (TextView) listItemView.findViewById(R.id.romanji_text);

        romanjiTextView.setText(currentKana.getmRomanji());








        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);



        return listItemView;
    }
}


