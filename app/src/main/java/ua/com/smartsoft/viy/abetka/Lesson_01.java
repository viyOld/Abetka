package ua.com.smartsoft.viy.abetka;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.Arrays;
import java.util.Random;
//import ua.com.smartsoft.viy.Abetka;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import android.util.Log;
import android.view.Display;

/**
 * Created by viy on 19.05.15.
 */

public class Lesson_01 extends Activity {

    private String[] abetka;                // массив где хранятся все литеры
    private ArrayAdapter<String> adapter;   // адаптер для ListView
    private Context context;                // содержит текущий контекст для некоторых вызовов
    private float widthDp;                  // определяем ширину активности
    private float heightDp;                 // для определения высоты активности
    private float minSizeActivity;          // для определения минимальной сторны активити
    private int   mySizeFont;               // для установки размера шрифта в активити
    private String s;                       // переменная для временного хранения при сортировке
    final Random random = new Random();     //
    private ListView listView;              //
    SharedPreferences sPref;                // для сохранения данных
    public static final String APP_PREFERENCES = "mysettings";     // это будет именем файла настроек
    final String SAVED_ORDER = "saved_order";
    final String SAVED_FONT = "saved_font";
    private int orderList = 0;
    private int orderFont = 0;              // индекс выбранного шрифта
    private String[] namefont;              // массив хранения имен шрифтов
    private int[] soundLetter = new int[33];

    //private int[] soundLetterSource = new int[33];
    //private SoundPool sp;
    //private boolean loaded = false;
    public static final String TAG = "Abetka";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_01);
        // заполняем массив названиями шрифтов
        namefont = getResources().getStringArray(R.array.name_fonts);
        // Запоминаем текущий контекст
        context = getApplicationContext();
        // Определяем ширину и высоту экрана для задания размера шрифта
        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        widthDp = metrics.widthPixels / metrics.density;
        heightDp = metrics.heightPixels / metrics.density;
        minSizeActivity = widthDp < heightDp ? widthDp : heightDp;
        mySizeFont = Math.round(minSizeActivity / 3 + 40);

        //Toast.makeText(Lesson_01.this, "****"  , Toast.LENGTH_SHORT).show();
        Log.d(TAG, "*******************************************************");

        // готуемо звук
        //Abetka.getInstance().onLoadDate();


        //sp = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        //sp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
        //    @Override
        //    public void onLoadComplete(SoundPool soundPool, int sampleId,
        //                               int status) {
        //        loaded = true;
        //    }
        //});

        //int i = 0;
        //while ( i < 33 ) {
        //    s = i < 10 ? "0" + String.valueOf(i) : String.valueOf(i);
        //    try {
        //        soundLetter[i] = sp.load(getAssets().openFd("sounds/l" + s + ".ogg"), 1);
        //    } catch (IOException e) {
        //        e.printStackTrace();
        //    }
        //    i++;
        //}

        // soundLetterSource = soundLetter.clone();
        //soundLetterSource = Arrays.copyOf(soundLetter,33);

        // відновляємо метод сортування списку
        sPref = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        orderList = sPref.getInt(SAVED_ORDER, 0);
        orderFont = sPref.getInt(SAVED_FONT, 0);

        // Log.d(TAG, "*******************************************************");

        // загружаєм данні з xml файлу згідно сортуванню
        soundLetter = Abetka.getInstance().soundLetterSource.clone();
        abetka = getResources().getStringArray(R.array.abetka_array);

        this.onLoadData(orderList);



        listView = (ListView) findViewById(R.id.lesson_01);

        // устанавливаем режим выбора пунктов списка
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // створюємо адаптер переопрацьовуючи метод відображення єлементу з шрифтом
        adapter =  new ArrayAdapter(this, R.layout.list_view_01, abetka) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                if (view instanceof TextViewPlus) {
                    ((TextViewPlus) view).setTextSize(mySizeFont);
                    ((TextViewPlus) view).setCustomFont(context, namefont[orderFont]);
                }
                return view;
            }
        };

        // встановлюемо адаптер на наш список
        listView.setAdapter(adapter);

        // обработка нажатия на элемент списка
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Log.d(LOG_TAG, "itemClick: position = " + position + ", id = " + id);
                //sp.play(soundLetter[(int)id], 1, 1, 0, 0, 1);
                //int i = Abetka.getInstance().soundLetterSource[(int)id];
                //Abetka.getInstance().sSoundPool.play(i, 1, 1, 0, 0, 1);
                Abetka.getInstance().sSoundPool.play(soundLetter[(int) id], 1, 1, 0, 0, 1);
            }
        });

    }

    // метод для завантаження даних
    protected void onLoadData(int sortmethod) {
        Log.d(TAG, "##############################################################"+sortmethod);

        // получаем литеры из файла ресурса и пемещаем их в массив
        if (sortmethod == 0) {

            soundLetter = Abetka.getInstance().soundLetterSource.clone();
            //soundLetter = Arrays.copyOf(soundLetterSource,33);
            //soundLetter = Arrays.copyOf(Abetka.getInstance().soundLetterSource,33);

            Log.d(TAG, "___________________________________________________________________");

            abetka = getResources().getStringArray(R.array.abetka_array);
        }

        if (sortmethod == 1) {
            int i;
            int j = 0;
            while ((abetka.length / 2) > j) {
                s = abetka[j];
                abetka[j] = abetka[abetka.length - j - 1];
                abetka[abetka.length - j - 1] = s;
                i = soundLetter[j];
                soundLetter[j] = soundLetter[abetka.length - j - 1];
                soundLetter[abetka.length - j - 1] = i;
                j++;
            }

        }
        if (sortmethod == 2) {
            int r,i;
            int j = 0;
            Log.d(TAG, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            Log.d(TAG, "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+abetka.length);
            while ( abetka.length > j ) {
                r = random.nextInt(abetka.length-1);
                s = abetka[j];
                i = soundLetter[j];
                abetka[j] = abetka[r];
                soundLetter[j] = soundLetter[r];
                abetka[r] = s;
                soundLetter[r] = i;
                j++;
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,0,R.string.btnMenuOrderly);
        menu.add(0,1,1,R.string.btnMenuReverse);
        menu.add(0,2,2,R.string.btnMenuRandom);
        menu.add(1,3,3,R.string.btnMenuFont);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == 3) { orderFont = orderFont < 4 ? ++orderFont : 0; }      // змінюємо шрифт
        if (id == 0) { orderList = 0; }
        if (id == 1) { orderList = 1; }
        if (id == 2) { orderList = 2; }
        this.onLoadData(orderList);
        adapter =  new ArrayAdapter(this, R.layout.list_view_01, abetka) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                if (view instanceof TextViewPlus) {
                    ((TextViewPlus) view).setTextSize(mySizeFont);
                    ((TextViewPlus) view).setCustomFont(context, namefont[orderFont]);
                }
                return view;
            }
        };
        listView.setAdapter(adapter);
        // сохраняем порядок списка
        sPref = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt(SAVED_ORDER, orderList);
        ed.putInt(SAVED_FONT, orderFont);
        ed.commit();
        // Toast.makeText(this, "orderList:" + orderList, Toast.LENGTH_SHORT).show();
        // Toast.makeText(context, "Прямий Clicked:" + adapter.getCount(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
