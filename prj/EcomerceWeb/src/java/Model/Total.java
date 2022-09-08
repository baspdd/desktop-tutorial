/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author kienb
 */
public class Total {
    private int accountId;
    private double total_sell;
    private double total_buy;

    public Total() {
    }

    public Total(int accountId, double total_sell, double total_buy) {
        this.accountId = accountId;
        this.total_sell = total_sell;
        this.total_buy = total_buy;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getTotal_sell() {
        return total_sell;
    }

    public void setTotal_sell(double total_sell) {
        this.total_sell = total_sell;
    }

    public double getTotal_buy() {
        return total_buy;
    }

    public void setTotal_buy(double total_buy) {
        this.total_buy = total_buy;
    }
    
    
}
