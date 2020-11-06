package cn.sqh.demos;

import java.time.LocalDate;
import java.util.Calendar;


public abstract class Drinks {
    protected String name;
    protected double cost;
    protected LocalDate dateProduced;
    protected int baozhiqi;

    public Drinks(String name, double cost, LocalDate dateProduced, int baozhiqi) {
        this.name = name;
        this.cost = cost;
        this.dateProduced = dateProduced;
        this.baozhiqi = baozhiqi;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public LocalDate getDateProduced() {
        return dateProduced;
    }

    public int getBaozhiqi() {
        return baozhiqi;
    }

    public boolean isOverdue(){//返回false则没过期，返回true则过期
        LocalDate now=LocalDate.now();
        int year_now=now.getYear();
        int month_now=now.getMonthValue();
        int day_now=now.getDayOfMonth();
        int year_pro=dateProduced.getYear();
        int month_pro=dateProduced.getMonthValue();
        int day_pro=dateProduced.getDayOfMonth();
        Calendar nowC=Calendar.getInstance();
        Calendar proC=Calendar.getInstance();
        nowC.set(year_now,month_now,day_now);
        proC.set(year_pro,month_pro,day_pro);
        long deltas=nowC.getTimeInMillis()-proC.getTimeInMillis();
        long cunzaitianshu=deltas/1000/60/60/24;//存在天数   用Calendar计算的天数可以不用管闰年，因为Calendar计算的毫秒数已经考虑到闰秒了
        if(cunzaitianshu<=baozhiqi) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public abstract String toString();
}
