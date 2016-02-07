package givorenon.timetable;

import android.content.Context;

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

    public ArrayList<Ticket> getDailyTickets(Context context) {
        /* Realm realm = Realm.getInstance(context);
        RealmResults<Ticket> ticketQueryResult = realm.where(Ticket.class).findAll();
        ArrayList<Ticket> ticketList = new ArrayList<>();
        for (Ticket food : ticketQueryResult) {
            ticketList.add(food);
        }*/
        ArrayList<Ticket> ticketList = new ArrayList<>();
        Ticket ticket = new Ticket("07-02-2016", "07-02-2016", "18:00", "19:00", "DELA", false);
        ticketList.add(ticket);
        return ticketList;
    }
}
