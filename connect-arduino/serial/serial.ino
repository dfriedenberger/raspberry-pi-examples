String inData;
int ledPin = 13;
 
void setup() {
    pinMode(ledPin, OUTPUT);
    Serial.begin(9600);
    Serial.println("Serial connection started, waiting for instructions...");
}
 
void loop() {
    
    while (Serial.available() > 0)
    {
        // String command = Serial.readString();  // read command from serial port

        char recieved = Serial.read();
        inData += recieved; 
 
        // Process message when new line character is recieved
        if (recieved == '\n')
        {
            Serial.print("Arduino Received: ");
            Serial.print(inData);
            digitalWrite(ledPin, HIGH);
 
            // You can put some if and else here to process the message juste like that:
 
            if(inData == "OFF\n"){ // DON'T forget to add "\n" at the end of the string.
              Serial.println("LED OFF");
              digitalWrite(ledPin, LOW);
            }
 
 
            inData = ""; // Clear recieved buffer
        }
    }
}
