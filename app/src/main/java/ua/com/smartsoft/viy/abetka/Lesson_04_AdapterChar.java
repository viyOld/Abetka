package ua.com.smartsoft.viy.abetka;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class Lesson_04_AdapterChar extends ArrayAdapter<String> {

    private static final String[] mChar = {
            "А", "Б", "В", "Г", "Ґ",
            "Д", "Е", "Є", "Ж", "З",
            "И", "І", "Ї", "Й", "К",
            "Л", "М", "Н", "О", "П",
            "Р", "С", "Т", "У", "Ф",
            "Х", "Ц", "Ч", "Ш", "Щ",
            "ь", "Ю", "Я"
    };

    Context mContext;

    // Конструктор
    public Lesson_04_AdapterChar(Context context, int textViewResourceId) {
        super(context, textViewResourceId, mChar);
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView label = (TextView) convertView;

        if (convertView == null) {
            convertView = new TextView(mContext);
            label = (TextView) convertView;
        }
        label.setText(mChar[position]);
        return (convertView);
    }

    // возвращает содержимое выделенного элемента списка
    public String GetItem(int position) {
        return mChar[position];
    }

    public int getCount() {
        return mChar.length;
    }

    public long getItemId(int position) {
        return position;
    }

}
