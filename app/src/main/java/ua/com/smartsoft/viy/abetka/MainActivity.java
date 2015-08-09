package ua.com.smartsoft.viy.abetka;
// Нарбут Георгій Іванович
// Platform.AppTheme
// Theme.AppCompat
// Theme.AppCompat.Light

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {
     //   ActionBarActivity {

    Button btnLess01;
    Button btnLess02;
    Button btnLess03;
    Button btnLess04;
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Определяем ширину и высоту экрана для задания размера шрифта
        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Abetka.getInstance().screenHeight = metrics.heightPixels;
        Abetka.getInstance().screenWidth = metrics.widthPixels;


        btnLess01 = (Button) findViewById(R.id.button_01);
        btnLess02 = (Button) findViewById(R.id.button_02);
        btnLess03 = (Button) findViewById(R.id.button_03);
        btnLess04 = (Button) findViewById(R.id.button_04);
        btnExit = (Button) findViewById(R.id.btnExit);

        // устанавливаем один обработчик для всех кнопок
        btnLess01.setOnClickListener(this);
        btnLess02.setOnClickListener(this);
        btnLess03.setOnClickListener(this);
        btnLess04.setOnClickListener(this);
        btnExit.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);

        menu.add(0,0,0,R.string.btnOption);
        menu.add(0,1,1,R.string.btnAbout);

        return super.onCreateOptionsMenu(menu);
        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}
        if (id == 1) {
            Toast.makeText(MainActivity.this, "About Clicked", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, About.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


    // анализируем, какая кнопка была нажата. Всего один метод для всех кнопок
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.button_01: {
                //Toast.makeText(MainActivity.this, "Button 01 Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Lesson_01.class);
                startActivity(intent);
            } break;
            case R.id.button_02: {
                Toast.makeText(MainActivity.this, "Button 02 Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Lesson_02.class);
                startActivity(intent);
            } break;
            case R.id.button_03: {
                Toast.makeText(MainActivity.this, "Button 03 Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Lesson_03.class);
                startActivity(intent);
            } break;
            case R.id.button_04: {
                Toast.makeText(MainActivity.this, "Button 04 Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Lesson_04.class);
                startActivity(intent);
            } break;
            case R.id.btnExit: {
                Toast.makeText(MainActivity.this, "Button Exit Clicked", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

}
