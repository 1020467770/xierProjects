package cn.sqh.demos;

import java.util.ArrayList;
import java.util.LinkedList;

public class West2FriedChickenRestauran implements FriedChickenRestaurant{
    private double yue;
    private LinkedList<Beer> listBeer;
    private LinkedList<Juice> listJuice;
    private ArrayList<SetMeal> listTaocan;

    public West2FriedChickenRestauran() {
        listTaocan.add(new SetMeal("套餐1",20,"脆皮炸鸡",new Beer()));
        listTaocan.add(new SetMeal("套餐2",18,"香香炸鸡",new Beer()));
        listTaocan.add(new SetMeal("套餐3",21,"脆皮炸鸡",new Juice()));
        listTaocan.add(new SetMeal("套餐4",22,"香香炸鸡",new Juice()));
    }

    private void use(Beer beer){
        if(listBeer.isEmpty()){
            throw new IngredientSortOutException();
        }else{
            listBeer.pop();
        }
    }

    private void use(Juice juice){
        if(listJuice.isEmpty()){
            throw new IngredientSortOutException();
        }else{
            listJuice.pop();
        }
    }

    @Override
    public void saleTaocan(int index) {
        SetMeal taocan = listTaocan.get(index - 1);
        Drinks drinks = taocan.getDrinks();
        if(drinks instanceof Beer){
            use((Beer) drinks);
        }else if(drinks instanceof Juice){
            use((Juice) drinks);
        }
    }

    @Override
    public void jinhuo() {

    }
}
