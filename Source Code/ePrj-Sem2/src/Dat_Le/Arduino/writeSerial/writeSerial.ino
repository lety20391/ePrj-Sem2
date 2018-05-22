int inData = 0;   // for incoming serial data

void setup() {
        Serial.begin(9600);     // opens serial port, sets data rate to 9600 bps
}

void loop() {

        // send data only when you receive data:        
        if (Serial.available() > 0) {
                // read the incoming byte:
                inData = Serial.read();            
                
        }
        if (inData != 0)
        {
        // say what you got:
          Serial.println((char)inData);
          delay(1000);
        }
}
