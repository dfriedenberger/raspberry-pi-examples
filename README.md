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

# Connect arduino with raspberry

## Install Hypriot Docker on Image 
https://blog.hypriot.com/getting-started-with-docker-and-windows-on-the-raspberry-pi/

## Install Test-Software on Arduino


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


