package givorenon.timetable;

import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class DayActivity extends AppCompatActivity
        implements AddTicketDialogFragment.DialogListener{

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        refreshActivity();
    }

    Calendar calendar;
    DataBase dataBase;
    ArrayList<Ticket> dailyTickets;

    private void refreshActivity() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE");

        String dateString = dateFormat.format(calendar.getTime());
        String dayString = dayFormat.format(calendar.getTime());

        ((TextView) findViewById(R.id.date)).setText(dateString);
        ((TextView) findViewById(R.id.dayOfWeek)).setText(dayString);

        dataBase = DataBase.getInstance();
        dailyTickets = dataBase.getDailyTickets(getApplicationContext(), dateString);
        Collections.sort(dailyTickets, new TicketComparator());
        ((ListView) findViewById(R.id.dailyTickets)).setAdapter(new MyAdapter(this, dailyTickets));
    }

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
    }

    @Override
    protected void onStart() {
        super.onStart();

        refreshActivity();
    }

    public void addTicket(View view) {
        AddTicketDialogFragment fragment = new AddTicketDialogFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        fragment.show(ft, "dialog");
    }

    public void nextDay(View view) {
        calendar.add(Calendar.DATE, 1);

        refreshActivity();
    }

    public void prevDay(View view) {
        calendar.add(Calendar.DATE, -1);

        refreshActivity(                                                                                                        );
    }
}
