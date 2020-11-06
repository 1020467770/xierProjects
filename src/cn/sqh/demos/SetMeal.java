package cn.sqh.demos;

public class SetMeal {
    private String nameOfTaocan;
    private double price;
    private String nameOfZhaji;
    private Drinks drinks;

    public SetMeal(String nameOfTaocan, double price, String nameOfZhaji, Drinks drinks) {
        this.nameOfTaocan = nameOfTaocan;
        this.price = price;
        this.nameOfZhaji = nameOfZhaji;
        this.drinks = drinks;
    }

    public String getNameOfTaocan() {
        return nameOfTaocan;
    }

    public double getPrice() {
        return price;
    }

    public String getNameOfZhaji() {
        return nameOfZhaji;
    }

    public Drinks getDrinks() {
        return drinks;
    }

    @Override
    public String toString() {
        return nameOfTaocan + '：' + "  套餐价格：" + price +", "+nameOfZhaji + ", 饮料：" + drinks.getName();
    }
}
