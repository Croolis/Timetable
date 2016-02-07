package givorenon.timetable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    ArrayList<Ticket> tickets;
    LayoutInflater inflater;
    Context context;

    MyAdapter(Context aContext, ArrayList<Ticket> aFoodList) {
        tickets = aFoodList;
        context = aContext;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tickets.size();
    }

    @Override
    public View getView(int aPosition, View aConvertView, ViewGroup aParent) {
        View resultView = aConvertView;
        if (resultView == null) {
            resultView = (View) inflater.inflate(R.layout.ticket, null, false);
        }

        ((TextView) resultView.findViewById(R.id.startTime)).setText(tickets.get(aPosition).getStartTime());
        ((TextView) resultView.findViewById(R.id.finishTime)).setText(tickets.get(aPosition).getFinishTime());
        ((TextView) resultView.findViewById(R.id.ticketText)).setText(tickets.get(aPosition).getText());
        ((CheckBox) resultView.findViewById(R.id.star)).setChecked(tickets.get(aPosition).getStarred());

        resultView.setTag(aPosition);
        resultView.setId(aPosition);

        return resultView;
    }

    @Override
    public long getItemId(int anId) {
        return anId;
    }

    @Override
    public Ticket getItem(int anId) {
        return tickets.get(anId);
    }
}