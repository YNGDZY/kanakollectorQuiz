package com.example.deezy.quizredux;

/**
 * Created by DEEZY on 09/04/2017.
 */

public class KanaClass {

private String mRomanji;
    private int mImgRes;
    private int mAudioRes;


    public KanaClass(int imgRes,String romanji,int audioRes) {

        mImgRes = imgRes;
        mRomanji = romanji;
        mAudioRes = audioRes;

    }


public int getmImgRes(){
        return mImgRes;
    }
public String getmRomanji(){
    return  mRomanji;
}
public int getmAudioRes(){
    return mAudioRes;
}



}
