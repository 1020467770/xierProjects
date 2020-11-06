package cn.sqh.demos;

import java.time.LocalDate;

public class Juice extends Drinks{
    /*public Juice() {
        super("果汁", 10, LocalDate.of(2020,2,1),2);
    }*/

    public Juice(String name, double cost, LocalDate dateProduced) {
        super(name, cost, dateProduced, 2);
    }

    @Override
    public String toString() {
        return "果汁的种类是："+super.name+'\n'+
                "果汁的成本是："+super.cost+"元\n"+
                "果汁的生产日期是："+super.dateProduced.toString()+'\n'+
                "果汁的保质期是"+super.baozhiqi+"天";
    }
}
