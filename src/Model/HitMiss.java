package Model;

import java.util.Calendar;


public class HitMiss {
    private String word;
    private boolean hit;
    private Calendar hitDate;

    public HitMiss(String word, boolean hit, Calendar hitDate) {
        this.word = word;
        this.hit = hit;
        this.hitDate = hitDate;
    }

    public String getWord() {
        return word;
    }

    public boolean isHit() {
        return hit;
    }

    public Calendar getHitDate() {
        return hitDate;
    }
}
