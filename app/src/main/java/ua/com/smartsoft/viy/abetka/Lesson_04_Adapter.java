package ua.com.smartsoft.viy.abetka;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by viy on 02.07.15.
 */
public class Lesson_04_Adapter extends BaseAdapter {

    // define variable class
    private Bitmap sourceImage;                 // исходное изображение из ресурсов
    private Bitmap scaleImage;                  // послемасштабирования (иначе программа выбрасывает исключение)
    private int maxWidthImage;                  // массимальная ширина изображения
    private int maxHeightImage;                 // максимальная высота изображения
    private int myPaddingH;                     // определяем отступы по высоте (еси автоматом то неверно делает)

    public	Integer[] mThumbIds = {             // создаем массив изображений из ресурсов
            R.drawable.l0000, R.drawable.l0100, R.drawable.l0200, R.drawable.l0300, R.drawable.l0400,
            R.drawable.l0500, R.drawable.l0600, R.drawable.l0600, R.drawable.l0800, R.drawable.l0900,
            R.drawable.l1100, R.drawable.l1100, R.drawable.l1100, R.drawable.l1300, R.drawable.l1400,
            R.drawable.l1500, R.drawable.l1600, R.drawable.l1700, R.drawable.l1800, R.drawable.l1900,
            R.drawable.l2000, R.drawable.l2100, R.drawable.l2200, R.drawable.l2300, R.drawable.l2400,
            R.drawable.l2500, R.drawable.l2600, R.drawable.l2700, R.drawable.l2800, R.drawable.l2900,
            R.drawable.arrow_prev, R.drawable.l3000, R.drawable.l3100, R.drawable.l3200, R.drawable.arrow_next
    };

    private static final String[] mChar = {     // создаем массив литер для нанесения поверх изображения
            "А", "Б", "В", "Г", "Ґ",
            "Д", "Е", "Є", "Ж", "З",
            "И", "І", "Ї", "Й", "К",
            "Л", "М", "Н", "О", "П",
            "Р", "С", "Т", "У", "Ф",
            "Х", "Ц", "Ч", "Ш", "Щ",
            "",  "ь", "Ю", "Я", ""
    };

    private Context mContext;

    // define method class -------------------------------------------------------------------------
    public Lesson_04_Adapter(Context c) {
        mContext = c;
        maxWidthImage = ( Abetka.getInstance().screenWidth - ( 6 * 5 )) / 5;
        maxHeightImage = ( Abetka.getInstance().screenHeight - ( 8 * 5 )) / 7;
        if ( maxWidthImage > maxHeightImage ) { maxWidthImage = maxHeightImage; }
        else { maxHeightImage = maxWidthImage; }
        myPaddingH = (Abetka.getInstance().screenHeight - (maxHeightImage*7))/8;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // create a new View for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int widthImage;
        int heightImage;
        float divImage;

        View oneView=inflater.inflate(R.layout.lesson_04grid,parent,false);
        TextView oneText = (TextView) oneView.findViewById(R.id.gridText);
        ImageView imageView = (ImageView) oneView.findViewById(R.id.gridImage);

        sourceImage = BitmapFactory.decodeResource(mContext.getResources(), mThumbIds[position]);
        if ( sourceImage.getHeight() > sourceImage.getWidth() ) {
            divImage = (float) sourceImage.getHeight() / sourceImage.getWidth();
            heightImage = maxHeightImage;
            widthImage = (int) ((float) heightImage / divImage );
        } else {
            divImage = (float) sourceImage.getWidth() / sourceImage.getHeight();
            widthImage = maxWidthImage;
            heightImage = (int) ((float) widthImage / divImage);
        }
        Log.d("getView", "divImage" + divImage + "******************************************************************");

        //scaleImage.setScaleType(ImageView.ScaleType.FIT_END);
        // scaleImage = Bitmap.createScaledBitmap(sourceImage, maxWidthImage, maxHeightImage, true);
        if ( position == 30 ) { scaleImage = Bitmap.createScaledBitmap(sourceImage, maxWidthImage/2, maxHeightImage/2, false);
        } else { scaleImage = Bitmap.createScaledBitmap(sourceImage, widthImage, heightImage, true); }
        Log.d("getView", "***" + maxHeightImage + "***" + heightImage + "***" + maxWidthImage + "***" + widthImage + "******************************************************");

        imageView.setImageBitmap(scaleImage);
        imageView.setScaleType(ImageView.ScaleType.FIT_END);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        imageView.setLayoutParams(params);
        imageView.setPadding(5, myPaddingH, 5, myPaddingH);

        oneText.setText(mChar[position]);

        oneView.setLayoutParams(params);
        return oneView;
    }
}

//         Log.d("getView", "0000111******************************************************************");
//         Log.d("getView", "0000555******************************************************************");
//         Log.d("getView", "0000222******************************************************************");
// float divImage;
// widthSpacing 6 * 5 = 30
// heightSpacing 8 * 5 = 40
// return imageView;
// return oneText;
//Log.d("getView", "00006666******************************************************************");
//Log.d("log", String.format("Total memory = %s", (int) (Runtime.getRuntime().totalMemory() / 1024)));
////heightImage = (int) ((float) sourceImage.getHeight() / sourceImage.getWidth() * widthImage);
////heightImageLayout = ((Abetka.getInstance().screenHeight-40)/7) > heightImage ? ((Abetka.getInstance().screenHeight-40)/7) : heightImage;
////if (convertView == null) {
// if it's not recycled, initialize some attributes
// imageView = new ImageView(mContext);  /////////////////////////////////////////////////////
////    imageView.setLayoutParams(new GridView.LayoutParams(widthImage, heightImageLayout));
////    imageView.setScaleType(ImageView.ScaleType.FIT_END);
////    imageView.setPadding(5, 5, 5, 5);
////} else {
////    imageView = (ImageView) convertView;
////}
/////scaleImage = Bitmap.createScaledBitmap(sourceImage, widthImage/2, heightImage/2, true);
//drawableImage = new BitmapDrawable(mContext.getResources(),scaleImage);
//imageView.setImageResource(mThumbIds[position]);
//imageView.setImageResource(drawableImage);
// Log.d("getView", "0000444******************************************************************");
// widthImage = ( Abetka.getInstance().screenWidth - 30 ) / 5;

// ImageView imageView;
// TextView oneText;

// private BitmapDrawable drawableImage;
// private static LayoutInflater inflater = null;
// inflater = ( LayoutInflater ) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
// int heightImageLayout;