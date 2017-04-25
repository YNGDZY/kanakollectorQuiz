package com.example.deezy.quizredux;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;


public class KatakanaFragment extends Fragment {


    public KatakanaFragment() {

    }

    private MediaPlayer mMediaPlayer;


    private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {

            releaseMediaPlayer();
        }

    };



    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {

                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {

                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {

                releaseMediaPlayer();
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.kana_list, container, false);

        super.onCreate(savedInstanceState);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);



        final ArrayList<KanaClass> kanaList = new ArrayList<KanaClass>();
        kanaList.add(new KanaClass(R.drawable.i_katakana_a,"a",R.raw.hirigana_a));
        kanaList.add(new KanaClass(R.drawable.i_katakana_ka,"ka",R.raw.hirigana_ka));
        kanaList.add(new KanaClass(R.drawable.i_katakana_sa,"sa",R.raw.hirigana_sa));
        kanaList.add(new KanaClass(R.drawable.i_katakana_ta,"ta",R.raw.hirigana_ta));
        kanaList.add(new KanaClass(R.drawable.i_katakana_na,"na",R.raw.hirigana_na));
        kanaList.add(new KanaClass(R.drawable.i_katakana_ha,"ha",R.raw.hirigana_ha));
        kanaList.add(new KanaClass(R.drawable.i_katakana_ma,"ma",R.raw.hirigana_ma));
        kanaList.add(new KanaClass(R.drawable.i_katakana_ya,"ya",R.raw.hirigana_ya));
        kanaList.add(new KanaClass(R.drawable.i_katakana_ra,"ra",R.raw.hirigana_ra));
        kanaList.add(new KanaClass(R.drawable.i_katakana_wa,"wa",R.raw.hirigana_wa));
        kanaList.add(new KanaClass(R.drawable.i_katakana_i,"i",R.raw.hirigana_i));
        kanaList.add(new KanaClass(R.drawable.i_katakana_ki,"ki",R.raw.hirigana_ki));
        kanaList.add(new KanaClass(R.drawable.i_katakana_shi,"shi",R.raw.hirigana_shi));
        kanaList.add(new KanaClass(R.drawable.i_katakana_chi,"chi",R.raw.hirigana_chi));
        kanaList.add(new KanaClass(R.drawable.i_katakana_ni,"ni",R.raw.hirigana_ni));
        kanaList.add(new KanaClass(R.drawable.i_katakana_hi,"hi",R.raw.hirigana_hi));
        kanaList.add(new KanaClass(R.drawable.i_katakana_mi,"mi",R.raw.hirigana_mi));
        kanaList.add(new KanaClass(R.drawable.i_katakana_ri,"ri",R.raw.hirigana_ri));
        kanaList.add(new KanaClass(R.drawable.i_katakana_u,"u",R.raw.hirigana_u));
        kanaList.add(new KanaClass(R.drawable.i_katakana_ku,"ku",R.raw.hirigana_ku));
        kanaList.add(new KanaClass(R.drawable.i_katakana_su,"su",R.raw.hirigana_su));
        kanaList.add(new KanaClass(R.drawable.i_katakana_tsu,"tsu",R.raw.hirigana_tsu));
        kanaList.add(new KanaClass(R.drawable.i_katakana_fu,"fu",R.raw.hirigana_fu));
        kanaList.add(new KanaClass(R.drawable.i_katakana_mu,"mu",R.raw.hirigana_mu));
        kanaList.add(new KanaClass(R.drawable.i_katakana_yu,"yu",R.raw.hirigana_yu));
        kanaList.add(new KanaClass(R.drawable.i_katakana_ru,"ru",R.raw.hirigana_ru));
        kanaList.add(new KanaClass(R.drawable.i_katakana_n,"n",R.raw.hirigana_n));
        kanaList.add(new KanaClass(R.drawable.i_katakana_e,"e",R.raw.hirigana_e));
        kanaList.add(new KanaClass(R.drawable.i_katakana_ke,"ke",R.raw.hirigana_ke));
        kanaList.add(new KanaClass(R.drawable.i_katakana_se,"se",R.raw.hirigana_se));
        kanaList.add(new KanaClass(R.drawable.i_katakana_te,"te",R.raw.hirigana_te));
        kanaList.add(new KanaClass(R.drawable.i_katakana_ne,"ne",R.raw.hirigana_ne));
        kanaList.add(new KanaClass(R.drawable.i_katakana_he,"he",R.raw.hirigana_he));
        kanaList.add(new KanaClass(R.drawable.i_katakana_me,"me",R.raw.hirigana_me));
        kanaList.add(new KanaClass(R.drawable.i_katakana_re,"re",R.raw.hirigana_re));
        kanaList.add(new KanaClass(R.drawable.i_katakana_o,"o",R.raw.hirigana_o));
        kanaList.add(new KanaClass(R.drawable.i_katakana_ko,"ko",R.raw.hirigana_ko));
        kanaList.add(new KanaClass(R.drawable.i_katakana_so,"so",R.raw.hirigana_so));
        kanaList.add(new KanaClass(R.drawable.i_katakana_to,"to",R.raw.hirigana_to));
        kanaList.add(new KanaClass(R.drawable.i_katakana_no,"no",R.raw.hirigana_no));
        kanaList.add(new KanaClass(R.drawable.i_katakana_ho,"ho",R.raw.hirigana_ho));
        kanaList.add(new KanaClass(R.drawable.i_katakana_mo,"mo",R.raw.hirigana_mo));
        kanaList.add(new KanaClass(R.drawable.i_katakana_yo,"yo",R.raw.hirigana_yo));
        kanaList.add(new KanaClass(R.drawable.i_katakana_ro,"ro",R.raw.hirigana_ro));
        kanaList.add(new KanaClass(R.drawable.i_katakana_wo,"wo",R.raw.hirigana_wo));




        KanaAdapter adapter = new KanaAdapter(getActivity(), kanaList,R.color.katakana_view_color);


        ListView listView = (ListView) rootView.findViewById(R.id.list);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                KanaClass kana = kanaList.get(position);
                releaseMediaPlayer();
                int audioID = kana.getmAudioRes();
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,

                        AudioManager.STREAM_MUSIC,

                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {



                    mMediaPlayer = MediaPlayer.create(getActivity(), audioID);
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        return rootView;
    }



    private void releaseMediaPlayer() {

        if (mMediaPlayer != null) {

            mMediaPlayer.release();


            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    @Override
    public void onStop() {
        super.onStop();


        releaseMediaPlayer();
    }
}