/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author kienb
 */
public class Invoice {
    private int invoiceId;
    private int accountId;
    private double total;
    private Date date_invoice;

    public Invoice() {
    }

    public Invoice(int invoiceId, int accountId, double total, Date date_invoice) {
        this.invoiceId = invoiceId;
        this.accountId = accountId;
        this.total = total;
        this.date_invoice = date_invoice;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate_invoice() {
        return date_invoice;
    }

    public void setDate_invoice(Date date_invoice) {
        this.date_invoice = date_invoice;
    }
    
    
}
