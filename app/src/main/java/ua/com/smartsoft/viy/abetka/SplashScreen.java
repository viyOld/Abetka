package ua.com.smartsoft.viy.abetka;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import java.util.concurrent.TimeUnit;

/**
 * Created by viy on 21.05.15.
 */
public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        //Создаем новый поток:
        Thread splash_time = new Thread()
        {
            public void run()
            {
                    // Загружаем данные в другом классе
                    Abetka.getInstance().onLoadDate();
                    // Передаем управление в главное активити
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
            }
        };
        splash_time.start();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}


// ImageView imgView = (ImageView) findViewById(R.id.imageView);
// imgView.setImageResource(R.drawable.ukrainskij_kazak);

// пауза - 1 секунда
//       try {
//           TimeUnit.SECONDS.sleep(3);
//       } catch (InterruptedException e) {
//           e.printStackTrace();
//       }

// создаем новый Intent для перехода на MainActivity
//Intent intent = new Intent(SplashScreen.this, MainActivity.class);

// запускаем новое Activity c Intent-ом, который хранит наш объект currency
//startActivity(intent);

// завершаем работу потока
//finish();

//Целое значение время отображения картинки:
//int SplashTimer = 0;
//Запускаем цикл длиной в 3 секунды:
//while(SplashTimer < 3000) {
//    sleep(100);
//    SplashTimer = SplashTimer +100;
//};

//try
//{

//}
//catch (InterruptedException e) {
//    e.printStackTrace(); }
//finally {
//Закрываем activity:
//    finish();
//}
