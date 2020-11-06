package cn.sqh.demos;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        West2FriedChickenRestauran wfcr = new West2FriedChickenRestauran();
        Beer brkind1=new Beer ("小啤酒", 10, LocalDate.of(2020, 11, 1), 3);
        Beer brkind2=new Beer("大啤酒", 15, LocalDate.of(2020, 11, 2), 4);
        Juice jckind1=new Juice("苹果汁", 8, LocalDate.of(2020, 11, 3));
        Juice jckind2=new Juice("橙汁", 9, LocalDate.of(2020, 11, 5));
        //生产日期可以用Random类配合判断过期函数来决定要不要进那一批货，但题目要求的保质期太短就手中控制生产日期吧

        System.out.println(brkind1);

        System.out.println(jckind1);

        System.out.println("==================");


        try {
            wfcr.jinhuo(20, brkind1);
            wfcr.jinhuo(20, brkind2);
            wfcr.jinhuo(30, jckind1);
            wfcr.jinhuo(30, jckind2);
            //wfcr.jinhuo(5000,brkind1);这行会提示余额不足
        }catch (OverdraftBalanceException e){
            System.out.println(e);
        }

        System.out.println(wfcr);//重载了toString函数，可以用来debug

        System.out.println("==================");

        wfcr.showTaocan();//debug用

        System.out.println("==================");


        try {
            wfcr.saleTaocan(1);//顾客选择的应该是1-4而不是0-3

            System.out.println(wfcr);

            System.out.println("==================");

            wfcr.saleTaocan(3);

            System.out.println(wfcr);

            for(int i=0;i<40;i++){//小啤酒不够了
                wfcr.saleTaocan(1);
            }
        }catch (IngredientSortOutException e){
            System.out.println(e);
        }

        System.out.println("==================");


        System.out.println(brkind1.isOverdue()==false? "啤酒未过期":"啤酒已过期");

        System.out.println(jckind1.isOverdue()==false?"果汁未过期":"果汁已过期");


    }
}
