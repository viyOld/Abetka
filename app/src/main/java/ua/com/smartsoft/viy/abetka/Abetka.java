package ua.com.smartsoft.viy.abetka;

//import android.support.v7.app.ActionBarActivity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.util.DisplayMetrics;
//import android.util.Log;
//import android.content.res.Configuration;
//import android.media.AudioAttributes;
//import android.media.AudioAttributes.Builder;

import android.app.Application;
import android.media.AudioManager;
import android.media.SoundPool;

public class Abetka extends Application {
    private static Abetka singleton;
    public String[] abetkaCharArray;                // массив где хранятся все литеры
    public SoundPool sSoundPool;                    // плайер для литер
    public int[] soundLetterSource = new int[33];   // звуки литер
    public int screenHeight;                        // высота экрана присваиваеться в MainActivity
    public int screenWidth;                         // ширина экрана


    // Возвращает экземпляр данного класса
    public static Abetka getInstance() {
        return singleton;
    }

    @Override
    public final void onCreate() {
        super.onCreate();
        singleton = this;
        sSoundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        // вызываем метод начальной загрузки данных
        //this.onLoadDate();
    }

    public void onLoadDate() {
        int i = 0;
        int resourceID;
        String s;

        abetkaCharArray = getResources().getStringArray(R.array.abetka_array);
        while ( i < 33 ) {
            s = i < 10 ? "0" + String.valueOf(i) : String.valueOf(i);
            resourceID = this.getResources().getIdentifier("l"+s,"raw", this.getPackageName());
            soundLetterSource[i] = sSoundPool.load(this, resourceID, 1);
            i++;
        }
    }
}

// Новый конструктор для SoundPool. Не совместим с старыми API
//AudioAttributes attributes = new AudioAttributes.Builder()
//        .setUsage(AudioAttributes.CONTENT_TYPE_SPEECH)          // USAGE_GAME
//        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
//        .build();
//sSoundPool = new SoundPool.Builder()
//        .setAudioAttributes(attributes)
//        .build();

//было созданно автоматически в манифесте
//<activity
//android:name=".Abetka"
//android:label="@string/title_activity_abetka" >
//</activity>
// android:installLocation="preferExternal"

// Log.d("QQQQQQQQQQQQQQQ", "*******************************************************"+i);