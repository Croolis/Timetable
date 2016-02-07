package givorenon.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DayActivity extends AppCompatActivity {

    Calendar calendar;
    DataBase dataBase;
    ArrayList<Ticket> dailyTickets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        Intent startIntent = getIntent();
        int year = startIntent.getIntExtra("year", 0);
        int month = startIntent.getIntExtra("month", 0);
        int day = startIntent.getIntExtra("day", 0);

        calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");

        String dateString = dateFormat.format(calendar.getTime());
        String dayString = dayFormat.format(calendar.getTime());

        ((TextView) findViewById(R.id.date)).setText(dateString);
        ((TextView) findViewById(R.id.dayOfWeek)).setText(dayString);

        dataBase = DataBase.getInstance();
        dailyTickets = dataBase.getDailyTickets(getApplicationContext());
        ((ListView) findViewById(R.id.dailyTickets)).setAdapter(new MyAdapter(this, dailyTickets));
    }

    public void nextDay(View view) {
        calendar.add(Calendar.DATE, 1);
        Intent intent = new Intent(DayActivity.this, DayActivity.class);
        intent.putExtra("year", calendar.get(Calendar.YEAR));
        intent.putExtra("month", calendar.get(Calendar.MONTH));
        intent.putExtra("day", calendar.get(Calendar.DAY_OF_MONTH));
        startActivity(intent);
    }

    public void prevDay(View view) {
        calendar.add(Calendar.DATE, -1);
        Intent intent = new Intent(DayActivity.this, DayActivity.class);
        intent.putExtra("year", calendar.get(Calendar.YEAR));
        intent.putExtra("month", calendar.get(Calendar.MONTH));
        intent.putExtra("day", calendar.get(Calendar.DAY_OF_MONTH));
        startActivity(intent);
    }
}
