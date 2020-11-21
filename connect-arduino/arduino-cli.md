## arduino-cli


### Update 
update the local cache of available platforms and libraries
```
arduino-cli core update-index
```


### List board
```
arduino-cli board list
Port Type              Board Name  FQBN            Core
COM3 Serial Port (USB) Arduino Uno arduino:avr:uno arduino:avr
```
### Compile Project
Install platform for `your` arduino
```
arduino-cli core install arduino:avr
```
Compile
```
$ arduino-cli compile --fqbn arduino:avr:uno wire
Sketch uses 4838 bytes (14%) of program storage space. Maximum is 32256 bytes.
Global variables use 411 bytes (20%) of dynamic memory, leaving 1637 bytes for local variables. Maximum is 2048 bytes.
```
### Upload
```
arduino-cli upload -p COM3 --fqbn arduino:avr:uno wire
```

### communicate with putty 
```
Ctrl+M : Carriage Return(“\r”)
Ctrl+J : Line Feed(“\n”)
```

### References
https://github.com/B45i/arduino-cli-how-to
https://z49x2vmq.github.io/2017/11/12/putty-cr-lf-en/
