/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package function;

import data.DataMapper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nr
 */
public class Controller {

    public static User login(String email, String password) throws LoginSampleException {
        return DataMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException, InstantiationException, IllegalAccessException {
        User user = new User(email, password, "customer");
        DataMapper.createUser(user);
        return user;
    }

    public static void placeOrder(User user, int length, int width, int heigth) throws LoginSampleException, CreateOrderException {
        DataMapper.createOrder(user, length, width, heigth);

    }

    public static List<BuildHouse> buildHouseType2x4(List<Layer> layers) {
        List<BuildHouse> completeHouse = new ArrayList();
        int side1Brick4x2 = 0;
        int side2Brick4x2 = 0;
        int side3Brick4x2 = 0;
        int side4Brick4x2 = 0;
        int total = 0;
        int totalxHeigth = 0;

        for (int i = 0; i < layers.size(); i++) {

            side1Brick4x2 += layers.get(i).getSides().get(0).getBrick2x4();
            // Front // Count 4x2 bricks for front at layer(i)
            side2Brick4x2 += layers.get(i).getSides().get(1).getBrick2x4();
            // Side // Count 4x2 bricks for side at layer(i)
            side3Brick4x2 += layers.get(i).getSides().get(2).getBrick2x4();
            // Back // Count 4x2 bricks for back at layer(i)
            side4Brick4x2 += layers.get(i).getSides().get(3).getBrick2x4();
            // Front // Count 4x2 bricks for side at layer(i)

        }
        total = side1Brick4x2 + side2Brick4x2 + side3Brick4x2 + side4Brick4x2;
        totalxHeigth = total * layers.size();
        completeHouse.add(new BuildHouse("4x2", side1Brick4x2, side2Brick4x2, side3Brick4x2, side4Brick4x2, total, totalxHeigth));
        return completeHouse;
    }

    public static List<BuildHouse> buildHouseType2x2(List<Layer> layers) {
        List<BuildHouse> completeHouse = new ArrayList();
        int side1Brick2x2 = 0;
        int side2Brick2x2 = 0;
        int side3Brick2x2 = 0;
        int side4Brick2x2 = 0;
        int total = 0;
        int totalxHeigth = 0;

        for (int i = 0; i < layers.size(); i++) {
            side1Brick2x2 += layers.get(i).getSides().get(0).getBrick2x2();
            // Front // Count 2x2 bricks for front at layer(i)
            side2Brick2x2 += layers.get(i).getSides().get(1).getBrick2x2();
            // Side // Count 2x2 bricks for side at layer(i)
            side3Brick2x2 += layers.get(i).getSides().get(2).getBrick2x2();
            // Back // Count 2x2 bricks for back at layer(i)
            side4Brick2x2 += layers.get(i).getSides().get(3).getBrick2x2();
            // Front // Count 2x2 bricks for side at layer(i)
        }

        total = side1Brick2x2 + side2Brick2x2 + side3Brick2x2 + side4Brick2x2;
        totalxHeigth = total * layers.size();
        completeHouse.add(new BuildHouse("2x2", side1Brick2x2, side2Brick2x2, side3Brick2x2, side4Brick2x2, total, totalxHeigth));
        return completeHouse;
    }

    public static List<BuildHouse> buildHouseType2x1(List<Layer> layers) {
        List<BuildHouse> completeHouse = new ArrayList();
        int side1Brick2x1 = 0;
        int side2Brick2x1 = 0;
        int side3Brick2x1 = 0;
        int side4Brick2x1 = 0;
        int total = 0;
        int totalxHeigth = 0;

        for (int i = 0; i < layers.size(); i++) {
            side1Brick2x1 += layers.get(i).getSides().get(0).getBrick2x1();
            // Front // Count 2x1 bricks for front at layer(i)
            side2Brick2x1 += layers.get(i).getSides().get(1).getBrick2x1();
            // Side // Count 2x1 bricks for side at layer(i)
            side3Brick2x1 += layers.get(i).getSides().get(2).getBrick2x1();
            // Back // Count 2x1 bricks for back at layer(i)
            side4Brick2x1 += layers.get(i).getSides().get(3).getBrick2x1();
            // Front // Count 2x1 bricks for side at layer(i)

        }
        total = side1Brick2x1 + side2Brick2x1 + side3Brick2x1 + side4Brick2x1;
        totalxHeigth = total * layers.size();

        completeHouse.add(new BuildHouse("1x2", side1Brick2x1, side2Brick2x1, side3Brick2x1, side4Brick2x1, total, totalxHeigth));
        return completeHouse;
    }

    private static List<Layer> calculateSides(int length, int width, int height) {
        List<Layer> layers = new ArrayList<>();
        Layer l;
        for (int i = 0; i < height; i++) {
            if (i % 2 == 0) {
                l = new Layer();
                //Even layer
                l.addSide(calcSide(length)); // Front
                l.addSide(calcSide(width - 4)); //Side 
                l.addSide(calcSide(length)); // Back
                l.addSide(calcSide(width - 4)); //Side 
                layers.add(l);
            } else {
                //Uneven layer
                l = new Layer();
                l.addSide(calcSide(length - 4)); // Front
                l.addSide(calcSide(width)); // Side
                l.addSide(calcSide(length - 4)); // Back
                l.addSide(calcSide(width)); // Side
                layers.add(l);
            }
        }
        return layers;

    }

    private static Side calcSide(int lengthOfSide) {
        Side s;
        int remainingLenghtAfterModulus = 0;
        int brick2x1 = 0;
        int brick2x2 = 0;
        int brick2x4 = 0;

        if (lengthOfSide % 4 == 0) {
            brick2x4 = lengthOfSide / 4;
            s = new Side(brick2x1, brick2x2, brick2x4);
        } else {
            brick2x4 = lengthOfSide / 4;
            remainingLenghtAfterModulus = lengthOfSide % 4;

            if (remainingLenghtAfterModulus % 2 == 0) {
                brick2x2 = remainingLenghtAfterModulus / 2;
                s = new Side(brick2x1, brick2x2, brick2x4);
            } else {
                brick2x2 = remainingLenghtAfterModulus / 2;
                remainingLenghtAfterModulus = remainingLenghtAfterModulus % 2;
                brick2x1 = remainingLenghtAfterModulus / 1;
                s = new Side(brick2x1, brick2x2, brick2x4);
            }
        }
        return s;
    }

    public static List<BuildHouse> getQuantityList2x4(int length, int width, int heigth) {
        List<Layer> layers = calculateSides(length, width, heigth);
        List<BuildHouse> houseType2x4 = buildHouseType2x4(layers);

        return houseType2x4;
    }

    public static List<BuildHouse> getQuantityList2x2(int length, int width, int heigth) {
        List<Layer> layers = calculateSides(length, width, heigth);
        List<BuildHouse> houseType2x2 = buildHouseType2x2(layers);

        return houseType2x2;
    }

    public static List<BuildHouse> getQuantityList2x1(int length, int width, int heigth) {
        List<Layer> layers = calculateSides(length, width, heigth);
        List<BuildHouse> houseType1x2 = buildHouseType2x1(layers);

        return houseType1x2;
    }

    public static List<Integer> getOrdersByCustomer(User user) {
        List<Integer> orderIds = DataMapper.getOrdersByUser(user);
        return orderIds;
    }

    public static Order getOrderDetails(int id) {
        Order order = DataMapper.getOrderDetails(id);
        return order;
    }

}
