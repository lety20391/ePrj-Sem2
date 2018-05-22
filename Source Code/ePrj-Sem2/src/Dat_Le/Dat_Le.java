/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dat_Le;
import com.fazecast.jSerialComm.*;
import java.util.Scanner;
/**
 *
 * @author Dat ThinkPad
 */
public class Dat_Le {
    
    public Dat_Le(){
        
    }
    
    public void TestReadArduino(){
        SerialPort comPort = SerialPort.getCommPorts()[0];
        comPort.openPort();
        try {
           while (true)
           {
              while (comPort.bytesAvailable() == 0)
                 Thread.sleep(20);

              byte[] readBuffer = new byte[comPort.bytesAvailable()];
              int numRead = comPort.readBytes(readBuffer, readBuffer.length);
              System.out.println("Read " + numRead + " bytes.");
               for (byte b : readBuffer) {
                   System.out.println((char)b);
               }
           }
        } catch (Exception e) 
        { System.out.println(e.getMessage()); }
        comPort.closePort();
    }
    
    public void TestWriteArduino(){
        Scanner sc = new Scanner(System.in);
        SerialPort comPort = SerialPort.getCommPorts()[0];
        comPort.openPort();
        try {
            System.out.println("Enter data:");
            String outData = sc.nextLine();
            byte[] outByte = outData.getBytes();
            comPort.writeBytes(outByte, outByte.length);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        comPort.closePort();
    }
    
}
