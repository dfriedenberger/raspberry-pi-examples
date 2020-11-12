#include <Wire.h>

#define I2C_ADDRESS 0x05

String inData;
int ledPin = 13;

byte nr = 0;

void setup()
{
    Serial.begin(9600);
    Wire.begin(I2C_ADDRESS);

    pinMode(ledPin, OUTPUT);
    digitalWrite(ledPin, LOW);

    Wire.onReceive(receiveI2CData);
    Wire.onRequest(sendI2cData);
}

void loop() {}

void receiveI2CData(int byteCount)
{
    while (Wire.available()) {
        nr = Wire.read();
        Serial.print(String(nr) + ": ");

        switch (nr) {
            case 1:
                digitalWrite(ledPin, HIGH);
                Serial.println("LED on");
                break;
            case 2:
                digitalWrite(ledPin, LOW);
                Serial.println("LED off");
                break;
            default:
                Serial.println("-");
                break;
        }
    }
}

void sendI2cData()
{
    Wire.write(nr);
}
