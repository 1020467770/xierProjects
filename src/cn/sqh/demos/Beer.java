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

    @Override
    public String toString() {
        return "啤酒的种类是："+super.name+'\n'+
                "啤酒的成本是："+super.cost+"元\n"+
                "啤酒的生产日期是："+super.dateProduced.toString()+'\n'+
                "啤酒的保质期是"+super.baozhiqi+"天"+'\n'+
                "这种啤酒的度数是"+dushu;
    }
}
