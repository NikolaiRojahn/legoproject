/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

/**
 *
 * @author nr
 */
public class Side{
    
    private int brick2x1;
    private int brick2x2;
    private int brick2x4;

    public Side(int brick2x1, int brick2x2, int brick2x4) {
        this.brick2x1 = brick2x1;
        this.brick2x2 = brick2x2;
        this.brick2x4 = brick2x4;
    }

    @Override
    public String toString() {
        return "Side{" + "brick2x1=" + brick2x1 + ", brick2x2=" + brick2x2 + ", brick2x4=" + brick2x4 + '}';
    }

    public int getBrick2x1() {
        return brick2x1;
    }

    public void setBrick2x1(int brick2x1) {
        this.brick2x1 = brick2x1;
    }

    public int getBrick2x2() {
        return brick2x2;
    }

    public void setBrick2x2(int brick2x2) {
        this.brick2x2 = brick2x2;
    }

    public int getBrick2x4() {
        return brick2x4;
    }

    public void setBrick2x4(int brick2x4) {
        this.brick2x4 = brick2x4;
    }

    
    
    
    
}
