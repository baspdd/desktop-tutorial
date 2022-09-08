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
public class Review {
    private int review_id;
    private int account_id;
    private int product_id;
    private String content;
    private Date date_review;

    public Review() {
    }

    public Review(int review_id, int account_id, int product_id, String content, Date date_review) {
        this.review_id = review_id;
        this.account_id = account_id;
        this.product_id = product_id;
        this.content = content;
        this.date_review = date_review;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate_review() {
        return date_review;
    }

    public void setDate_review(Date date_review) {
        this.date_review = date_review;
    }
    
}
