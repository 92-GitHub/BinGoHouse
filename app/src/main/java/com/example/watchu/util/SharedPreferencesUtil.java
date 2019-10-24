package com.example.watchu.util;
import android.widget.*;
import android.text.*;
/*配置一个偏好设置*/
import android.content.Context;
import android.content.SharedPreferences;
public class SharedPreferencesUtil {
    private static final String TAG="TAG";
    private static final String KEY_LOGIN="KEY_LOGIN";

    private static SharedPreferences mPreferences;
    private static SharedPreferences.Editor mEditor;
    private static SharedPreferencesUtil mSharedPreferencesUtil;
    private final Context context;

    public SharedPreferencesUtil(Context context){
        this.context=context.getApplicationContext();
        mPreferences=this.context.getSharedPreferences(TAG,context.MODE_PRIVATE);
        mEditor=mPreferences.edit();
    }

    /*实现单例*/
    public static SharedPreferencesUtil getInstance(Context context){
        if (mSharedPreferencesUtil==null){
            mSharedPreferencesUtil=new SharedPreferencesUtil(context);
        }
        return mSharedPreferencesUtil;
    }

    /**判断是否登陆
     * @return
     */
    public boolean isLogin(){
        return getBoolean(KEY_LOGIN,false);
    }

    /**更改登陆状态
     * *
     */
    public void  setLogin(boolean value){
        putBoolean(KEY_LOGIN,value);
    }

    //----私有方法
    private void put(String key,String value){
        mEditor.putString(key,value);
        mEditor.commit();
    }
    private void putBoolean(String key,boolean value){
        mEditor.putBoolean(key,value);
        mEditor.commit();
    }
    private String get(String key){

        //-------------------------------------------------下面一句是自己瞎猜的 -----------------------------------------------------
        return mPreferences.getString(key,"");
    }
    private boolean getBoolean(String key,boolean defaultValue){
        return mPreferences.getBoolean(key,defaultValue);
    }
    private void putInt(String key,int value){
        mEditor.putInt(key,value);
        mEditor.apply();
    }
    private int getInt(String key,int defaultValue){
        return mPreferences.getInt(key,defaultValue);
    }
    //--------end 私有方法
}
