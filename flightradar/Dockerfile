FROM balenalib/raspberry-pi-debian-openjdk:8-stretch


RUN install_packages git make librtlsdr-dev gcc pkg-config libc6-dev

RUN git clone git://github.com/MalcolmRobb/dump1090.git
RUN cd dump1090;make

EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "cd dump1090;./dump1090 --net"]
