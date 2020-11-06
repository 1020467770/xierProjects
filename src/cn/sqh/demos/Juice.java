package cn.sqh.demos;

import java.time.LocalDate;

public class Juice extends Drinks{
    /*public Juice() {
        super("果汁", 10, LocalDate.of(2020,2,1),2);
    }*/

    public Juice(String name, double cost, LocalDate dateProduced) {
        super(name, cost, dateProduced, 2);
    }
}
