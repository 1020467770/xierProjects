package cn.sqh.demos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;


public class West2FriedChickenRestauran implements FriedChickenRestaurant {
    private double yue;
    static private LinkedList<Beer> listBeer;//啤酒和果汁在售卖和进货时要经常添加和删除，同时又由于品种有限，线性查找速度已经够了，所以选择LinkedList
    static private LinkedList<Juice> listJuice;
    static private ArrayList<SetMeal> listTaocan;//套餐只有在创建对象时初始化，之后没有添加和删除操作，而且要经常查询套餐，所以使用ArrayList

    static {
         listBeer=new LinkedList<>();
         listJuice=new LinkedList<>();
         listTaocan=new ArrayList<>();
    }

    @Override
    public String toString() {
        String yue = "目前的余额是" + this.yue + "元";
        String beers= "目前一共有"+listBeer.size()+"种啤酒，分别是：";
        for (Beer beer : listBeer) {
            beers+=beer.name+' ';
        }
        String jucies= "目前一共有"+listJuice.size()+"种果汁，分别是：";
        for (Juice juice : listJuice) {
            jucies+=juice.name+' ';
        }
        return yue+'\n'+beers+'\n'+jucies;

    }

    public West2FriedChickenRestauran() {
        yue=10000;
        listTaocan.add(new SetMeal("套餐1", 20, "脆皮炸鸡", new Beer("小啤酒", 10, LocalDate.of(2020, 11, 1), 3)));
        listTaocan.add(new SetMeal("套餐2", 18, "香香炸鸡", new Beer("大啤酒", 15, LocalDate.of(2020, 11, 2), 4)));
        listTaocan.add(new SetMeal("套餐3", 21, "脆皮炸鸡", new Juice("苹果汁", 8, LocalDate.of(2020, 11, 1))));
        listTaocan.add(new SetMeal("套餐4", 22, "香香炸鸡", new Juice("橙汁", 9, LocalDate.of(2020, 11, 3))));
    }

    private void use(Beer beer) {
        if (listBeer.isEmpty()) {
            throw new IngredientSortOutException("您所需要的"+beer.name+"已经售空了");
        } else {
            for (Beer listbr : listBeer) {
                if(listbr.name==beer.name){
                    listBeer.remove(listbr);
                    return;
                }
            }
            throw new IngredientSortOutException("您所需要的"+beer.name+"已经售空了");
        }
    }

    private void use(Juice juice) {
        if (listJuice.isEmpty()) {
            throw new IngredientSortOutException("您所需要的"+juice.name+"已经售空了");
        } else {
            for (Juice listjc : listJuice) {
                if(listjc.name==juice.name){
                    listJuice.remove(listjc);
                    return;
                }
            }
            throw new IngredientSortOutException("您所需要的"+juice.name+"已经售空了");
        }
    }

    @Override
    public void saleTaocan(int index) {//客户选择的套餐是1-4，但在查询时要-1
        SetMeal taocan = listTaocan.get(index - 1);
        Drinks drinks = taocan.getDrinks();
        if (drinks instanceof Beer) {
            use((Beer) drinks);
        } else if (drinks instanceof Juice) {
            use((Juice) drinks);
        }
    }

    @Override
    public void jinhuo(int num, Drinks drinks) {
        if (drinks instanceof Beer) {
            Beer beer = (Beer) drinks;
            double chae = beer.cost * num - yue;
            if(chae>0){
                throw new OverdraftBalanceException("店铺余额不足，还差"+chae+"");
            }else {
                for (int i = 0; i < num; i++) {
                    listBeer.add(beer);
                }
                yue -= chae+yue;
            }
        } else if (drinks instanceof Juice) {
            Juice juice = (Juice) drinks;
            double chae = juice.cost * num - yue;
            if(chae>0){
                throw new OverdraftBalanceException("店铺余额不足，还差"+chae+"");
            }else {
                for (int i = 0; i < num; i++) {
                    listJuice.add(juice);
                }
                yue -= chae + yue;
            }
        }
    }

    public void showTaocan(){
        System.out.println("一共有如下几种套餐：");
        for (SetMeal listtc : listTaocan) {
            System.out.println(listtc);
        }
    }
}
