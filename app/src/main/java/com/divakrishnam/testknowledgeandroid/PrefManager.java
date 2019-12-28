package com.divakrishnam.testknowledgeandroid;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "testknowledgeandroid";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public static final String NICKNAME = "nickname";

    public PrefManager(Context context){
        this._context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime){
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch(){
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setNickname(String nickname){
        editor.putString(NICKNAME, nickname);
        editor.commit();
    }

    public String getNickname(){
        return pref.getString(NICKNAME, "");
    }
}
