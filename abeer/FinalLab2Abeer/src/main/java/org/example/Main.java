package org.example;


import java.util.Scanner;

class SharedResource {
    private int count = 0;


    public synchronized void incrment(int value) {
        this.count += value;
    }

    public synchronized int getCount() {
        return count ;
    }
}

class CheckdIDThread extends Thread {
    private SharedResource resource;
    private String id;

    public CheckdIDThread(SharedResource resource, String id) {
        this.resource = resource;
        this.id = id;
    }

    @Override
    public void run() {

        char[] idArray = id.toCharArray();

        for (char digit : idArray) {
            if (digit == '8') {
                resource.incrment(15);

            }
            if (digit == '6') {
                resource.incrment(10);

            }
            if (digit == '5') {
                resource.incrment(5);

            }
        }



    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your ID: ");
        String id = scanner.nextLine();

        CheckdIDThread t1 = new CheckdIDThread(resource,id);
        CheckdIDThread t2 = new CheckdIDThread(resource,id);
        CheckdIDThread t3 = new CheckdIDThread(resource,id);

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        System.out.println("Final Count: " + resource.getCount());
    }
}