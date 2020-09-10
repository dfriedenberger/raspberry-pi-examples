# raspberry-pi-examples
raspberry-pi docker examples

## helpfull images

- Docker UI
```
 docker run -d -p 9000:9000 -v /var/run/docker.sock:/var/run/docker.sock hypriot/rpi-dockerui
```

- Debian with Java
```
docker run --rm -it raspberry-pi-debian-openjdk:8-stretch bach
```


## Install Hypriot Docker on Image 
https://blog.hypriot.com/getting-started-with-docker-and-windows-on-the-raspberry-pi/

# Connect arduino with raspberry

## Install Test-Software on Arduino
- Use File connect-arduino/serial/serial.ino

## Start
```
 stty 9600 -F /dev/ttyACM0 raw -echo
 docker run --rm -it --device /dev/ttyACM0:/dev/ttyACM0 balenalib/raspberry-pi-debian-openjdk:8-stretch bash
```

```
> install_packages git
> git clone https://github.com/dfriedenberger/raspberry-pi-examples.git
> cd raspberry-pi-examples/connect-arduino
> javac Connect.java
> java Connect
```

# Play Sound

## Start
```
 docker run --rm -it --device /dev/vchiq:/dev/vchiq balenalib/raspberry-pi-debian-openjdk:8-stretch bash
```

```
    install_packages omxplayer wget
    wget https://file-examples-com.github.io/uploads/2017/11/file_example_WAV_1MG.wav
    omxplayer -o local file_example_WAV_1MG.wav
    omxplayer -o hdmi file_example_WAV_1MG.wav
```

# Receive ADS-B Records from airplanes
https://mode-s.org/decode/adsb/introduction.html 
## DVB-T Stick anschließen
http://detlef-meis.de/2019/06/05/welche-dvb-t-sticks-funktionieren-fuer-sdr

## Start
```
 lsusb
 docker run --rm -it --device /dev/bus/usb/001/004:/dev/bus/usb/001/004 -p 8080:8080 balenalib/raspberry-pi-debian-openjdk:8-stretch bash
```

```
    install_packages rtl-sdr
    rtl_test
    rtl_adsb -V
    install_packages git make librtlsdr-dev gcc pkg-config libc6-dev
    git clone git://github.com/MalcolmRobb/dump1090.git
    cd dump1090
    make
    ./dump1090 --interactive --net
```

