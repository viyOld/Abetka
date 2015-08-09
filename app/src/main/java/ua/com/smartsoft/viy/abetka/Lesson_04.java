package ua.com.smartsoft.viy.abetka;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import static android.graphics.Color.WHITE;

public class Lesson_04 extends Activity {

    private Lesson_04_Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_04);

        mAdapter = new Lesson_04_Adapter(this);
        GridView gridview = (GridView) findViewById(R.id.gridView);
        Log.d("onCreate", "*****************************************************");
        gridview.setAdapter( mAdapter );
        Log.d("onCreate", "******************************************************************");
    }

    private GridView.OnItemClickListener gridviewOnItemClickListener = new GridView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            // выводим номер позиции
            // mSelectText.setText(String.valueOf(position));
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lesson_04, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


//Log.d("Lesson4", "*****" + scaleImage.getHeight() + "*******" + scaleImage.getWidth() + "****************" + "scale" + "***************************");
//Log.d("Lesson4", "*****" + metrics.widthPixels + "*******" + metrics.heightPixels + "*********" + divImage + "******************");
//Log.d("Lesson4", "*****" + sourceImage.getHeight() + "*******" + sourceImage.getWidth() + "********" + heightImage + "********" + widthImage + "***************************");
//Log.d("Lesson4", "*****" + divImage);

//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:columnCount="5"

// Определяем ширину и высоту экрана для задания размера шрифта
// DisplayMetrics metrics = new DisplayMetrics();
// this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
// widthDp = metrics.widthPixels / metrics.density;
// heightDp = metrics.heightPixels / metrics.density;

//widthImage = Abetka.getInstance().screenWidth / 5;
//
//        sourceImage = BitmapFactory.decodeResource(getResources(), R.drawable.l0100);
//        divImage = (float) sourceImage.getHeight() / sourceImage.getWidth();
//        divImage = divImage * widthImage;
//        heightImage = (int)divImage;
//        scaleImage = Bitmap.createScaledBitmap(sourceImage, widthImage, heightImage, true);
//        drawableImage = new BitmapDrawable(getApplicationContext().getResources(),scaleImage);
//        drawableImage.setGravity(Gravity.CENTER);
//        textview01 = (TextViewPlus) findViewById(R.id.textview01);
//        textview01.setBackground(drawableImage);
//        textview01.setHeight(heightImage);
//        textview01.setWidth(widthImage);
//
//
//        sourceImage = BitmapFactory.decodeResource(getResources(), R.drawable.l0100);
//        heightImage = (int) ((float) sourceImage.getHeight() / sourceImage.getWidth() * widthImage);
//        scaleImage = Bitmap.createScaledBitmap(sourceImage, widthImage, heightImage, true);
//        textview02 = (TextViewPlus) findViewById(R.id.textview02);
//        textview02.setBackground(new BitmapDrawable(getApplicationContext().getResources(),scaleImage));
//
////divImage = sourceImage.getHeight() / sourceImage.getWidth() * (metrics.widthPixels/5);
////heightImage = (int)divImage;
////divImage = (float) sourceImage.getHeight() / sourceImage.getWidth() * widthImage;
////divImage = divImage * widthImage;
////heightImage = (int)divImage;
////drawableImage01 = new BitmapDrawable(getApplicationContext().getResources(),scaleImage);
////textview02.setBackground(drawableImage01);


//          sourceImage = BitmapFactory.decodeResource(getResources(), R.drawable.l0100);
//          divImage = (float) sourceImage.getHeight() / sourceImage.getWidth();
//        divImage = divImage * widthImage;
//          divImage = divImage * 85;
//          heightImage = (int)divImage;
//scaleImage = Bitmap.createScaledBitmap(sourceImage, widthImage, heightImage, true);
//          scaleImage = Bitmap.createScaledBitmap(sourceImage, 85, 85, true);
//          drawableImage = new BitmapDrawable(getApplicationContext().getResources(),scaleImage);
//        drawableImage.setGravity(Gravity.CENTER);
//mAdapterChar = new Lesson_04_AdapterChar(getApplicationContext(),android.R.layout.simple_list_item_1);

// mSelectText = (TextView) findViewById(R.id.info);
// GridView gridviewChar = (GridView) findViewById(R.id.gridViewChar);
//mAdapter = new Lesson_04_Adapter(this);
// gridviewChar.setAdapter( mAdapterChar );
//gridview.setBackground(WHITE);
//private TextViewPlus textview01;
//private TextViewPlus textview02;
//private Bitmap sourceImage;
//private Bitmap scaleImage;
//private BitmapDrawable drawableImage;
//private BitmapDrawable drawableImage01;
//private TextViewPlus mSelectText;
// private Lesson_04_AdapterChar mAdapterChar;
