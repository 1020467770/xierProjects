package cn.sqh.demos;

public class IngredientSortOutException extends RuntimeException{

    public IngredientSortOutException() {
        super("果汁或啤酒售完");
    }
}
