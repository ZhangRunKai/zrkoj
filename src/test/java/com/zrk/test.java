package com.zrk;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/18 17:45
 */
public class test {
    public static void main(String[] args) {
        while (true){
            new Thread(()->{
                System.out.println("12121");
            }).start();
        }
    }
}
