package com.zrk;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/4/2 15:45
 */
public class Main {
    public static void main(String[] args) {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.getName());
        ThreadGroup parent = threadGroup.getParent();
        System.out.println(parent);
        System.out.println(parent.getParent());
    }
}
