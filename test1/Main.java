package com.company.test1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Goods g1 = new Goods();
        g1.name = "Apple";
        g1.price = 100;
        g1.qty = 50;
        Goods[] shopCar = new Goods[100];//100樣物品
        //int[] aaa = new int[]{1,2,3,4,5};

        /*Goods g2 = g1;
        g2.price = 111;
        System.out.println(g2.toString());*/

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("input command[1:add, 2:query, 3:update price, 4:pay]");
            int command = sc.nextInt();
            switch (command){
                case 1://add
                    addGoods(sc, shopCar);
                    break;
                case 2://query
                    queryGoods(shopCar);
                    break;
                case 3://update
                    updateGoods(sc, shopCar);
                    break;
                case 4://pay
                    pay(shopCar);
                    break;
            }
        }
    }

    private static void pay(Goods[] shopCar) {
        double money = 0;
        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if(g != null){
                money = g.price *g.qty;
            }else{
                break;
            }
        }
        System.out.println("total price is :" + money);
    }

    private static void updateGoods(Scanner sc, Goods[] shopCar) {
        System.out.println("input the item you want to update");
        String updateName = sc.next();
        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if(updateName.equals(g.name)){//別用updateName == g.name去比較[因為等號會變成比較地址而非內容]
                System.out.println("input the new price");
                int newPrice = sc.nextInt();
                g.price = newPrice;
                System.out.println("update complete");
                queryGoods(shopCar);
                break;
            }else{
                System.out.println("no this item");
            }
        }
    }

    private static void queryGoods(Goods[] shopCar) {
        for (int i = 0; i < shopCar.length; i++) {
            Goods g = shopCar[i];
            if(g == null){
                break;
            }else{
                System.out.println(g);
            }
        }
    }

    private static void addGoods(Scanner sc, Goods[] shopCar) {
        System.out.println("type the name you want to sell: ");
        String name = sc.next();
        System.out.println("type the price you want to sell: ");
        int price = sc.nextInt();
        System.out.println("type the Qty you want to sell: ");
        int qty = sc.nextInt();

        Goods g1 = new Goods();
        g1.name = name;
        g1.price = price;
        g1.qty = qty;

        for (int i = 0; i < shopCar.length; i++) {
            if(shopCar[i]==null){
                shopCar[i] = g1;
                System.out.println(g1);
                break;
            }
        }
    }
}