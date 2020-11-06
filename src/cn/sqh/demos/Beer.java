package cn.sqh.demos;

import java.time.LocalDate;

public class Beer extends Drinks {
    private float dushu;

    public Beer(String name, double cost, LocalDate dateProduced, float dushu) {
        super(name, cost, dateProduced, 30);
        this.dushu = dushu;
    }

    public float getDushu() {
        return dushu;
    }
}
