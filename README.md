# viwit-interface
## Maven clean install
``` mvn clean install ```
## Build the image
``` docker build -t viwit-interface . ```
## Run image
``` docker run -it --rm --name viwit-interface -p 8080:8080 viwit-interface ```
##
```http://{URL}:8080/ws/viwit_ws.wsdl```
