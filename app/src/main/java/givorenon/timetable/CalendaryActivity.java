package givorenon.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

public class CalendaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendary);
        ((CalendarView) findViewById(R.id.calendarView)).setOnDateChangeListener(
                onDateChangeListener);
    }

    public CalendarView.OnDateChangeListener onDateChangeListener = new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(CalendarView view, int year, int month,
                                        int dayOfMonth) {
            Intent intent = new Intent(CalendaryActivity.this, DayActivity.class);
            intent.putExtra("year", year);
            intent.putExtra("month", month);
            intent.putExtra("day", dayOfMonth);
            startActivity(intent);
        }
    };
}
