package a1221.org.il.hatsalaquestionaire.entities;

import java.io.Serializable;

/**
 * Created by Daniel on 12/28/2016.
 */

public class Tag implements Serializable {

    private static final long serialVersionUID = 5L;

    private int _ID;

    private int q_ID;

    private String text;

    public Tag(int _ID, String text, int q_ID) {
        this._ID = _ID;
        this.text = text;
        this.q_ID = q_ID;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getQ_ID() {
        return q_ID;
    }

    public void setQ_ID(int q_ID) {
        this.q_ID = q_ID;
    }
}
