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

/**
 * A simple {@link Fragment} subclass.
 */
public class HiriganaFragment extends Fragment {


    public HiriganaFragment() {
        // Required empty public constructor
    }
    /**
     * Handles playback of all the sound files
     */
    private MediaPlayer mMediaPlayer;

    /**
     * Handles audio focus when playing a sound file
     */
    private AudioManager mAudioManager;
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


    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
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
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
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


        // Create a list of words
        final ArrayList<KanaClass> kanaList = new ArrayList<KanaClass>();
        kanaList.add(new KanaClass(R.drawable.i_hirigana_a,"a",R.raw.hirigana_a));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_ka,"ka",R.raw.hirigana_ka));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_sa,"sa",R.raw.hirigana_sa));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_ta,"ta",R.raw.hirigana_ta));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_na,"na",R.raw.hirigana_na));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_ha,"ha",R.raw.hirigana_ha));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_ma,"ma",R.raw.hirigana_ma));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_ya,"ya",R.raw.hirigana_ya));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_ra,"ra",R.raw.hirigana_ra));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_wa,"wa",R.raw.hirigana_wa));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_i,"i",R.raw.hirigana_i));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_ki,"ki",R.raw.hirigana_ki));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_shi,"shi",R.raw.hirigana_shi));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_chi,"chi",R.raw.hirigana_chi));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_ni,"ni",R.raw.hirigana_ni));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_hi,"hi",R.raw.hirigana_hi));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_mi,"mi",R.raw.hirigana_mi));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_ri,"ri",R.raw.hirigana_ri));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_u,"u",R.raw.hirigana_u));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_ku,"ku",R.raw.hirigana_ku));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_su,"su",R.raw.hirigana_su));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_tsu,"tsu",R.raw.hirigana_tsu));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_fu,"fu",R.raw.hirigana_fu));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_mu,"mu",R.raw.hirigana_mu));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_yu,"yu",R.raw.hirigana_yu));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_ru,"ru",R.raw.hirigana_ru));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_n,"n",R.raw.hirigana_n));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_e,"e",R.raw.hirigana_e));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_ke,"ke",R.raw.hirigana_ke));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_se,"se",R.raw.hirigana_se));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_te,"te",R.raw.hirigana_te));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_ne,"ne",R.raw.hirigana_ne));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_he,"he",R.raw.hirigana_he));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_me,"me",R.raw.hirigana_me));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_re,"re",R.raw.hirigana_re));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_o,"o",R.raw.hirigana_o));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_ko,"ko",R.raw.hirigana_ko));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_so,"so",R.raw.hirigana_so));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_to,"to",R.raw.hirigana_to));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_no,"no",R.raw.hirigana_no));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_ho,"ho",R.raw.hirigana_ho));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_mo,"mo",R.raw.hirigana_mo));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_yo,"yo",R.raw.hirigana_yo));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_ro,"ro",R.raw.hirigana_ro));
        kanaList.add(new KanaClass(R.drawable.i_hirigana_wo,"wo",R.raw.hirigana_wo));




        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        KanaAdapter adapter = new KanaAdapter(getActivity(), kanaList,R.color.hirigana_view_color);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                KanaClass kana = kanaList.get(position);
                releaseMediaPlayer();
                int audioID = kana.getmAudioRes();
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback


                    mMediaPlayer = MediaPlayer.create(getActivity(), audioID);
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        return rootView;
    }


    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }
}