/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dat_Le;
import com.fazecast.jSerialComm.*;
/**
 *
 * @author Dat ThinkPad
 */
public class Dat_Le {
    
    public Dat_Le(){
        
    }
    
    public void TestArduino(){
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
    
}
