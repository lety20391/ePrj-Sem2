/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author Dat ThinkPad
 */
public class TestThread implements Runnable {

    /**
     * @param args the command line arguments
     */
    public void run(){
        System.out.println("Thread is running...");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        TestThread m1 = new TestThread();
        Thread t1 = new Thread(m1);
        t1.start();
    }
    
}
