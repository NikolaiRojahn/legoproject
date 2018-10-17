/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nr
 */
public class Order {
   
    private int id, u_id, length, width, heigth;
    private String date;
    private String shipped;

    public Order(int id, int u_id, String shipped, int length, int width, int heigth) {
        this.id = id;
        this.u_id = u_id;
        this.shipped = shipped;
        this.length = length;
        this.width = width;
        this.heigth = heigth;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    
    
    public String getShipped() {
        return shipped;
    }

    public void setShipped(String shipped) {
        this.shipped = shipped;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int order_id) {
        this.id = order_id;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String orderdate) {
        this.date = orderdate;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
    
}
