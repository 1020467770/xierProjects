package cn.sqh.demos;

import java.time.LocalDate;

public class Beer extends Drinks {
    private float dushu;

    public Beer() {
        super("啤酒", 15, LocalDate.of(2020,1,1), 30);
        this.dushu=4;
    }

    public float getDushu() {
        return dushu;
    }
}
