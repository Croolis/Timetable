package givorenon.timetable;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class DataBase {

    private static DataBase instance = null;

    private DataBase() { }

    public static DataBase getInstance() {
        if (instance == null)
            instance = new DataBase();
        return instance;
    }

    public ArrayList<Ticket> getDailyTickets(Context context, String currentDate) {
        Realm realm = Realm.getInstance(context);
        RealmResults<Ticket> ticketQueryResult = realm.where(Ticket.class)
                                                      .equalTo("startDate", currentDate)
                                                      .findAll();
        ArrayList<Ticket> ticketList = new ArrayList<>();
        for (Ticket food : ticketQueryResult) {
            ticketList.add(food);
        }

        return ticketList;
    }
}
