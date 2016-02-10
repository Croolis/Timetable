package givorenon.timetable;

import java.util.Comparator;

public class TicketComparator implements Comparator<Ticket> {
    public int compare(Ticket a, Ticket b) {
        if (a.getStartDate().compareTo(b.getStartDate()) < 0) {
            return -1;
        }
        if (a.getStartDate().compareTo(b.getStartDate()) > 0) {
            return 1;
        }
        if (a.getStartTime().compareTo(b.getStartTime()) < 0) {
            return -1;
        }
        if (a.getStartTime().compareTo(b.getStartTime()) > 0) {
            return 1;
        }
        if (a.getFinishDate().compareTo(b.getFinishDate()) < 0) {
            return -1;
        }
        if (a.getFinishDate().compareTo(b.getFinishDate()) > 0) {
            return 1;
        }
        if (a.getFinishTime().compareTo(b.getFinishTime()) < 0) {
            return -1;
        }
        if (a.getFinishTime().compareTo(b.getFinishTime()) > 0) {
            return 1;
        }
        return 0;

    }
}
