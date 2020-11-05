package cn.sqh.demos;

public class OverdraftBalanceException extends RuntimeException{
    public OverdraftBalanceException() {
        super("进货费用超出拥有余额");
    }
}
