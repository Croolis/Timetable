package givorenon.timetable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Ticket extends RealmObject {
    @PrimaryKey
    private String id;
    private String startDate;
    private String finishDate;
    private String startTime;
    private String finishTime;
    private String text;
    private Boolean starred;

    public Ticket() {

    }

    public Ticket(String _startDate, String _finishDate, String _startTime, String _finishTime, String _text, Boolean _starred) {
        startDate = _startDate;
        finishDate = _finishDate;
        startTime = _startTime;
        finishTime = _finishTime;
        text = _text;
        starred = _starred;
        id = startDate + startTime + finishDate + finishTime + text;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getStarred() {
        return starred;
    }

    public void setStarred(Boolean starred) {
        this.starred = starred;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}