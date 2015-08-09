package ua.com.smartsoft.viy.abetka;

import android.graphics.Color;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Random;

public class Lesson_02 extends Activity {
    private String s1,s2;
    private int indexL;
    private int resID;
    final Random random = new Random();

    // private String eatImages[][];
    private ArrayList<String> eatlist = new ArrayList<String>();
    private ArrayList<String> imagelist = new ArrayList<String>();
    private int colorChar[] = new int[7];

    private RelativeLayout layout;                   // основной Layout и единственный
    private TextViewPlus bigChar;                    // буквица в верху
    private TextViewPlus labelName;                  // подпись внизу
    private TextViewPlus lblTitle;                   //
    private ImageView mainimage;
    private ImageView imageView;                     //
    private ImageButton imageButton01;               // кнопка внизу - следующий
    private ImageButton imageButton02;               // кнопка внизу - предыдущий
    private ImageButton imageButton03;               // кнопка вверху - следующая
    private ImageButton imageButton04;               // кнопка вверху - предыдущая
    private ImageButton btnNext;
    private ImageButton btnPrev;
    private Button btnGoNext;

    private float widthDp;                           // определяем ширину активности
    private float heightDp;                          // для определения высоты активности
    private int sizeButtonArrow;                     // размер кнопки со стрелками


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.lesson_02);

        // Определяем ширину и высоту экрана для задания размера шрифта
        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        widthDp = metrics.widthPixels / metrics.density;
        heightDp = metrics.heightPixels / metrics.density;
        sizeButtonArrow = (int) metrics.heightPixels / 5;
        // minSizeActivity = widthDp < heightDp ? widthDp : heightDp;
        //Log.d("Lesson2", "*******************************************************" + metrics.heightPixels + "****" + metrics.density);

        this.onCreateLayout();

        colorChar[0] = Color.BLUE;
        colorChar[1] = Color.CYAN;
        colorChar[2] = Color.GRAY;
        colorChar[3] = Color.GREEN;
        colorChar[4] = Color.MAGENTA;
        colorChar[5] = Color.YELLOW;
        colorChar[6] = Color.RED;

        // eatImages = new String[2][10];
        imagelist.add("l0000"); eatlist.add("Абрикос");     // А 00
        imagelist.add("l0001"); eatlist.add("Аґрус");
        imagelist.add("l0002"); eatlist.add("Айва");
        imagelist.add("l0003"); eatlist.add("Ананас");
        imagelist.add("l0004"); eatlist.add("Апелсин");
        imagelist.add("l0005"); eatlist.add("Алича");
        imagelist.add("l0006"); eatlist.add("Артишок");
        imagelist.add("l0100"); eatlist.add("Баклажан");    // Б 01
        imagelist.add("l0101"); eatlist.add("Банан");
        imagelist.add("l0102"); eatlist.add("Борщ");
        imagelist.add("l0200"); eatlist.add("Вишня");       // В 02
        imagelist.add("l0201"); eatlist.add("Виноград");
        imagelist.add("l0300"); eatlist.add("Горох");       // Г 03
        imagelist.add("l0301"); eatlist.add("Груша");
        imagelist.add("l0302"); eatlist.add("Гарбуз");
        imagelist.add("l0303"); eatlist.add("Гранат");
        imagelist.add("l0304"); eatlist.add("Гриби");
        imagelist.add("l0305"); eatlist.add("Горіхи");
        imagelist.add("l0400"); eatlist.add("Ґоґель-моґель"); // Ґ 05
        imagelist.add("l0500"); eatlist.add("Диня");        // Д 04
        imagelist.add("l0501"); eatlist.add("Джекфрут");
        imagelist.add("l0502"); eatlist.add("Дуріан");
        imagelist.add("l0503"); eatlist.add("Дайкон");
        imagelist.add("l0600"); eatlist.add("Евкаліпт");    // Е 06
        imagelist.add("l0601"); eatlist.add("Естрагон");
        imagelist.add("l0602"); eatlist.add("Еклер");
        imagelist.add("l0603"); eatlist.add("Ескімо");
                                                            // Є 07
        imagelist.add("l0800"); eatlist.add("Желе");        // Ж 08
        imagelist.add("l0801"); eatlist.add("Жульен");
        imagelist.add("l0802"); eatlist.add("Жито");
        imagelist.add("l0803"); eatlist.add("Жолудь");
        imagelist.add("l0804"); eatlist.add("Жуйка");
        imagelist.add("l0900"); eatlist.add("Зефир");       // З 09
        imagelist.add("l0901"); eatlist.add("Зрази");
        imagelist.add("l0902"); eatlist.add("Зерно");
        imagelist.add("l1100"); eatlist.add("Інжир");       // І 11

        imagelist.add("l1300"); eatlist.add("Йогурт");      // Й 11
        imagelist.add("l1400"); eatlist.add("Ківі");        // К 14
        imagelist.add("l1401"); eatlist.add("Кавун");
        imagelist.add("l1402"); eatlist.add("Капуста");
        imagelist.add("l1403"); eatlist.add("Картопля");
        imagelist.add("l1404"); eatlist.add("Кукурудза");
        imagelist.add("l1405"); eatlist.add("Кабачек");
        imagelist.add("l1500"); eatlist.add("Лимон");       // Л 15
        imagelist.add("l1501"); eatlist.add("Лайм");
        imagelist.add("l1600"); eatlist.add("Мандарин");    // М 16
        imagelist.add("l1601"); eatlist.add("Малина");
        imagelist.add("l1602"); eatlist.add("М’ята");
        imagelist.add("l1603"); eatlist.add("Морква");
        imagelist.add("l1604"); eatlist.add("Манго");
        imagelist.add("l1605"); eatlist.add("Мед");
        imagelist.add("l1606"); eatlist.add("Мак");
        imagelist.add("l1700"); eatlist.add("Насіння");    // Н 17
        imagelist.add("l1701"); eatlist.add("Нектарин");
        imagelist.add("l1702"); eatlist.add("Напій");
        imagelist.add("l1800"); eatlist.add("Оливки");      // О 18
        imagelist.add("l1801"); eatlist.add("Ожина");
        imagelist.add("l1802"); eatlist.add("Огірок");
        imagelist.add("l1803"); eatlist.add("Обліпиха");
        imagelist.add("l1900"); eatlist.add("Перець");      // П 19
        imagelist.add("l1901"); eatlist.add("Перець");
        imagelist.add("l1902"); eatlist.add("Персик");
        imagelist.add("l1903"); eatlist.add("Полуниця");
        imagelist.add("l1904"); eatlist.add("Помідор");
        imagelist.add("l1904"); eatlist.add("Помідор");
        imagelist.add("l1905"); eatlist.add("Порічка");
        imagelist.add("l1906"); eatlist.add("Пастернак");
        imagelist.add("l1907"); eatlist.add("Патісон");
        imagelist.add("l2000"); eatlist.add("Редис");       // Р 20
        imagelist.add("l2001"); eatlist.add("Рис");
        imagelist.add("l2002"); eatlist.add("Ревінь");
        imagelist.add("l2100"); eatlist.add("Смородина");   // С 21
        imagelist.add("l2101"); eatlist.add("Слива");
        imagelist.add("l2102"); eatlist.add("Суниця");
        imagelist.add("l2103"); eatlist.add("Сало");
        imagelist.add("l2104"); eatlist.add("Селера");
        imagelist.add("l2200"); eatlist.add("Топінамбур");  // Т 22
        imagelist.add("l2201"); eatlist.add("Терн");
        imagelist.add("l2202"); eatlist.add("Трюфель");
        imagelist.add("l2300"); eatlist.add("Устриці");     // У 23
        imagelist.add("l2301"); eatlist.add("Узвар");
        imagelist.add("l2302"); eatlist.add("Урда");
        imagelist.add("l2400"); eatlist.add("Фініки");      // Ф 24
        imagelist.add("l2401"); eatlist.add("Фейхоа");
        imagelist.add("l2402"); eatlist.add("Фісташки");
        imagelist.add("l2500"); eatlist.add("Хурма");       // Х 25
        imagelist.add("l2501"); eatlist.add("Хрін");
        imagelist.add("l2600"); eatlist.add("Цибуля");      // Ц 26
        imagelist.add("l2601"); eatlist.add("Цикорій");
        imagelist.add("l2602"); eatlist.add("Цукор");
        imagelist.add("l2700"); eatlist.add("Часник");      // Ч 27
        imagelist.add("l2701"); eatlist.add("Чорниця");
        imagelist.add("l2702"); eatlist.add("Черешня");
        imagelist.add("l2703"); eatlist.add("Черемша");
        imagelist.add("l2800"); eatlist.add("Шпинат");      // Ш 28
        imagelist.add("l2801"); eatlist.add("Шипшина");
        imagelist.add("l2802"); eatlist.add("Шовковиця");
        imagelist.add("l2900"); eatlist.add("Щавель");      // Щ 29
        imagelist.add("l3000"); eatlist.add("Ь");           // Ь 30
        imagelist.add("l3100"); eatlist.add("Ющка");        // Ю 31
        imagelist.add("l3200"); eatlist.add("Яблуко");      // Я 32
        imagelist.add("l3201"); eatlist.add("Яйця");

        indexL = random.nextInt(imagelist.size());
        onLoadChar();

        imageButton01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = imagelist.get(indexL).substring(0, 3);
                if (indexL + 1 < imagelist.size()) {
                    s2 = imagelist.get(indexL + 1).substring(0, 3);
                } else {
                    s2 = "";
                }
                if (s1.equals(s2)) {
                    indexL++;
                } else {
                    s1 = imagelist.get(indexL).substring(3, 5);
                    indexL = indexL - Integer.valueOf(s1);
                }
                onLoadChar();
            }
        });

        imageButton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = imagelist.get(indexL).substring(0,3);
                if (indexL > 0) {s2 = imagelist.get(indexL-1).substring(0,3);}
                else { s2 = ""; }
                if (s1.equals(s2)) { indexL--; }
                else {  // ???
                    // s1 = imagelist.get(indexL).substring(3,5);
                    // indexL = indexL - Integer.valueOf(s1);
                }
                onLoadChar();
            }
        });

        imageButton03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = imagelist.get(indexL).substring(1,3);
                if (Integer.valueOf(s1) == 32) { indexL = 0; }
                else {
                    s2 = imagelist.get(indexL+1).substring(1,3);
                    while (Integer.valueOf(s1) == Integer.valueOf(s2)) {
                        ++indexL;
                        s1 = imagelist.get(indexL).substring(1,3);
                        s2 = imagelist.get(indexL+1).substring(1,3);
                    }
                    indexL++;
                }
                onLoadChar();
            }
        });

        imageButton04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = imagelist.get(indexL).substring(1,3);
                if (Integer.valueOf(s1) == 0) { indexL = imagelist.size() - 1; }
                else {
                    s2 = imagelist.get(indexL-1).substring(1,3);
                    while (Integer.valueOf(s1) == Integer.valueOf(s2)) {
                        --indexL;
                        s1 = imagelist.get(indexL).substring(1,3);
                        s2 = imagelist.get(indexL-1).substring(1,3);
                    }
                    indexL--;
                }
                onLoadChar();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lesson_03, menu);
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

    protected void onCreateLayout() {

        //**********  Создаем основной и единственный слой *****************************************
        layout = new RelativeLayout(Lesson_02.this);
        //layout.setId(654001);                               // Дает ошибку но работает ???
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(layoutParams);

        //**********  Создаем заглавную букву вверху ***********************************************
        bigChar = new TextViewPlus(Lesson_02.this);
        bigChar.setText("Я");
        RelativeLayout.LayoutParams textViewLayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        textViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        textViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        bigChar.setCustomFont(this, "fonts/Narbut_Abetka.ttf");
        bigChar.setTextSize(heightDp / 5);
        bigChar.setTextColor(Color.RED);
        bigChar.setId(654003);
        bigChar.setLayoutParams(textViewLayoutParams);
        layout.addView(bigChar);

        //**********  Создаем нижнюю кнопку далее **************************************************
        Bitmap sourceImageNext = BitmapFactory.decodeResource(getResources(), R.drawable.arrow_next);
        Bitmap imageArrowNext = Bitmap.createScaledBitmap(sourceImageNext, sizeButtonArrow, sizeButtonArrow, true);
        BitmapDrawable imageDrawableNext = new BitmapDrawable(imageArrowNext);
        imageButton01 = new ImageButton(Lesson_02.this);
        imageButton01.setImageDrawable(imageDrawableNext);
        RelativeLayout.LayoutParams imageButton01Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        imageButton01Params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        imageButton01Params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        imageButton01.setScaleType(ImageView.ScaleType.CENTER);
        imageButton01.setId(654004);
        imageButton01.setBackground(null);
        imageButton01.setLayoutParams(imageButton01Params);
        layout.addView(imageButton01);

        //**********  Создаем нижнюю кнопку назад **************************************************
        Bitmap sourceImagePrev = BitmapFactory.decodeResource(getResources(), R.drawable.arrow_prev);
        Bitmap imageArrowPrev = Bitmap.createScaledBitmap(sourceImagePrev, sizeButtonArrow, sizeButtonArrow, true);
        BitmapDrawable imageDrawablePrev = new BitmapDrawable(imageArrowPrev);
        imageButton02 = new ImageButton(Lesson_02.this);
        imageButton02.setImageDrawable(imageDrawablePrev);
        RelativeLayout.LayoutParams imageButton02Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        imageButton02Params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        imageButton02Params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        imageButton02.setScaleType(ImageView.ScaleType.CENTER);
        imageButton02.setId(654005);
        imageButton02.setBackground(null);
        imageButton02.setLayoutParams(imageButton02Params);
        layout.addView(imageButton02);

        //**********  Создаем подпись под картинкой ************************************************
        labelName = new TextViewPlus(Lesson_02.this);
        labelName.setText("Смачного");
        RelativeLayout.LayoutParams labelNameParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        labelNameParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        labelNameParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        labelName.setCustomFont(this, "fonts/Narbut_Abetka.ttf");
        labelName.setTextSize(heightDp / 16);
        labelName.setPadding(0,0,0,(int)heightDp/16);
        labelName.setId(654006);
        labelName.setLayoutParams(labelNameParams);
        layout.addView(labelName);

        //**********  Создаем верхнюю кнопку далее *************************************************
        Bitmap sourceImageNextTop = BitmapFactory.decodeResource(getResources(), R.drawable.arrow_next_top);
        Bitmap imageArrowNextTop = Bitmap.createScaledBitmap(sourceImageNextTop, sizeButtonArrow, sizeButtonArrow, true);
        BitmapDrawable imageDrawableNextTop = new BitmapDrawable(imageArrowNextTop);
        imageButton03 = new ImageButton(Lesson_02.this);
        imageButton03.setImageDrawable(imageDrawableNextTop);
        RelativeLayout.LayoutParams imageButton03Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        imageButton03Params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        imageButton03Params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        imageButton03.setScaleType(ImageView.ScaleType.CENTER);
        imageButton03.setPadding(0, (int)heightDp/16, (int)heightDp/16, 0);
        imageButton03.setId(654007);
        imageButton03.setBackground(null);
        imageButton03.setLayoutParams(imageButton03Params);
        layout.addView(imageButton03);

        //**********  Создаем верхнюю кнопку назад *************************************************
        Bitmap sourceImagePrevTop = BitmapFactory.decodeResource(getResources(), R.drawable.arrow_prev_top);
        Bitmap imageArrowPrevTop = Bitmap.createScaledBitmap(sourceImagePrevTop, sizeButtonArrow, sizeButtonArrow, true);
        BitmapDrawable imageDrawablePrevTop = new BitmapDrawable(imageArrowPrevTop);
        imageButton04 = new ImageButton(Lesson_02.this);
        imageButton04.setImageDrawable(imageDrawablePrevTop);
        RelativeLayout.LayoutParams imageButton04Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        imageButton04Params.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        imageButton04Params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        imageButton04.setScaleType(ImageView.ScaleType.CENTER);
        imageButton04.setPadding((int)heightDp/16, (int)heightDp/16, 0, 0);
        imageButton04.setId(654008);
        imageButton04.setBackground(null);
        imageButton04.setLayoutParams(imageButton04Params);
        layout.addView(imageButton04);


        //********** Создаем картинку по среди экрана **********************************************
        imageView = new ImageView(Lesson_02.this);
        //imageView.setId(R.id.image_id);
        imageView.setImageResource(R.drawable.l3200);
        RelativeLayout.LayoutParams imageViewLayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        imageView.setId(654009);
        imageViewLayoutParams.addRule(RelativeLayout.BELOW, bigChar.getId());
        imageViewLayoutParams.addRule(RelativeLayout.ABOVE, imageButton01.getId());
        imageViewLayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        // CENTER_IN_PARENT);

        imageView.setLayoutParams(imageViewLayoutParams);
        layout.addView(imageView);


        setContentView(layout);

    }

    protected void onLoadChar() {
        resID = getResources().getIdentifier(imagelist.get(indexL), "drawable", getApplicationContext().getPackageName());
        imageView.setImageResource(resID);
        labelName.setText(eatlist.get(indexL));
        bigChar.setText(eatlist.get(indexL).substring(0, 1));
        bigChar.setTextColor(colorChar[random.nextInt(7)]);
    }


}


//            android:text="@string/btnPrev"
//            android:text="@string/btnNext"
//            android:layout_height="wrap_content"
//            android:layout_height="60dp"
//Log.d("Lesson2", "--------------------------------------------------------")
//Log.d("Lesson2", "*******************************************************");
//Log.d("Lesson2", "****************" + s1 + "*******************" + s2 +"********************");
//Log.d("Lesson2", "****************" + s1 + "*******************" + s2 +"********************" + indexL);