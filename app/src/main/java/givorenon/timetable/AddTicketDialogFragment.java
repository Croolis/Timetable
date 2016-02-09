package givorenon.timetable;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import io.realm.Realm;

public class AddTicketDialogFragment extends DialogFragment {
    public interface DialogListener {
        void onDialogPositiveClick(DialogFragment dialog);
    }

    DialogListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (DialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }

    TextView text;
    TextView startDate;
    TextView startTime;
    TextView finishDate;
    TextView finishTime;
    CheckBox starred;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_ticket_fragment, null);
        text = (TextView) view.findViewById(R.id.text);
        startDate = (TextView) view.findViewById(R.id.startDate);
        startTime = (TextView) view.findViewById(R.id.startTime);
        finishDate = (TextView) view.findViewById(R.id.finishDate);
        finishTime = (TextView) view.findViewById(R.id.finishTime);
        starred = (CheckBox) view.findViewById(R.id.star);

        builder.setView(view)
                .setPositiveButton("Создать", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Ticket ticket = new Ticket(startDate.getText().toString(),
                                finishDate.getText().toString(),
                                startTime.getText().toString(),
                                finishTime.getText().toString(),
                                text.getText().toString(),
                                starred.isChecked());

                        Realm realm = Realm.getInstance(getActivity().getApplicationContext());
                        try {
                            realm.beginTransaction();
                            Ticket realmTicket = realm.copyToRealm(ticket);
                            realm.commitTransaction();
                        } catch (Exception e) {
                            Log.d("Creating Ticket", "This ticket already exists so could not be created");
                        }
                        mListener.onDialogPositiveClick(AddTicketDialogFragment.this);
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}