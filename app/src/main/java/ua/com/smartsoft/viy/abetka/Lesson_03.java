package ua.com.smartsoft.viy.abetka;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import java.util.Random;

/**
 * Created by viy on 23.05.15.
 */
public class Lesson_03 extends Activity {

    final Random random = new Random();
    public String[] abetka;
    public int index;
    public Button btn01;
    public Button btn02;
    public Button btn03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_03);

        btn01 = (Button) findViewById(R.id.btn_01);
        btn02 = (Button) findViewById(R.id.btn_02);
        btn03 = (Button) findViewById(R.id.btn_03);

        abetka = getResources().getStringArray(R.array.abetka_array);
        index = random.nextInt(31);
        btn01.setText(abetka[index]);
        index = random.nextInt(31);
        btn02.setText(abetka[index]);
        index = random.nextInt(31);
        btn03.setText(abetka[index]);

    }


}
