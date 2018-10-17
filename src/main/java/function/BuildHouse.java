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
public class BuildHouse {

    private static List<BuildHouse> house2x4 = new ArrayList();
    private static List<BuildHouse> house2x2 = new ArrayList();
    private static List<BuildHouse> house2x1 = new ArrayList();
    
    private String type = "";
    private int Side1 = 0;
    private int Side2 = 0;
    private int Side3 = 0;
    private int Side4 = 0;
    private int ialt = 0;
    private int ialtxhøjde = 0;
    

    public BuildHouse(String type, int Side1, int Side2, int Side3, int Side4, int ialt, int ialtxhøjde) {
        this.type = type;
        this.Side1 = Side1;
        this.Side2 = Side2;
        this.Side3 = Side3;
        this.Side4 = Side4;
        this.ialt = ialt;
        this.ialtxhøjde = ialtxhøjde;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotal() {
        return ialt;
    }

    public void setTotal(int ialt) {
        this.ialt = ialt;
    }

    public int getTotalxHeigth() {
        return ialtxhøjde;
    }

    public void setTotalxHeigth(int ialtxhøjde) {
        this.ialtxhøjde = ialtxhøjde;
    }

    public int getSide1() {
        return Side1;
    }

    public void setSide1(int Side1) {
        this.Side1 = Side1;
    }

    public int getSide2() {
        return Side2;
    }

    public void setSide2(int Side2) {
        this.Side2 = Side2;
    }

    public int getSide3() {
        return Side3;
    }

    public void setSide3(int Side3) {
        this.Side3 = Side3;
    }

    public int getSide4() {
        return Side4;
    }

    public void setSide4(int Side4) {
        this.Side4 = Side4;
    }

    public List<BuildHouse> getHouse2x4() {
        return house2x4;
    }

    public void setHouse2x4(List<BuildHouse> house2x4) {
        this.house2x4 = house2x4;
    }

    public List<BuildHouse> getHouse2x2() {
        return house2x2;
    }

    public void setHouse2x2(List<BuildHouse> house2x2) {
        this.house2x2 = house2x2;
    }

    public List<BuildHouse> getHouse2x1() {
        return house2x1;
    }

    public void setHouse2x1(List<BuildHouse> house2x1) {
        this.house2x1 = house2x1;
    }

    public int getIalt() {
        return ialt;
    }

    public void setIalt(int ialt) {
        this.ialt = ialt;
    }

    public int getIaltxhøjde() {
        return ialtxhøjde;
    }

    public void setIaltxhøjde(int ialtxhøjde) {
        this.ialtxhøjde = ialtxhøjde;
    }
    
    
    
}
