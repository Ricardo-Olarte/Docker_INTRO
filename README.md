# Docker_INTRO

### Elaborado por:
Jose Ricardo Olarte Pardo
__________________________________________________________________

### Requisitos

- Docker
- Java
- Maven
- IDE (Visual, Netbeans, Intellij, entre otros)
- Git

__________________________________________________________________

## Instalación

Seguimos los siguientes pasos:

1. Para ello clonamos el repositorio de GIT
```
https://github.com/Ricardo-Olarte/Docker_INTRO.git
```
![](https://github.com/Ricardo-Olarte/TOOLS/blob/main/Images/GitHub.png)

2. Abrimos nuestro IDE y abrimos la terminal
3. Desde la terminal, nos vamos al directorio del repositorio descargado y con el siguiente comando:
```
mvn clean install
```
![](https://github.com/Ricardo-Olarte/TOOLS/blob/main/Images/mvn_clean.png)

4. Finalizando la compilación de Maven, corremos la siguiente línea
```
java -cp "target/classes;target/dependency/*" co.edu.escuelaing.sparkdockerdemolive.SparkWebServer
```
5. Nos dirigimos al browser de su preferencia, y por medio de este link, se debe visualizar como en la imagen
```
http://localhost:4567/hello
```
[]()
6. Para correr las demás opciones, como las funciones para ello, reemplazamos el "/hello" por los siguientes:
- /sin -> Es la función seno
- /cos -> Es la función coseno
- /pal -> Es si una palabra es palindroma
- /mag -> Es conocer la magnitud entre dos números
7. Seguido de la función, asignamos la variable ej: "?value=", y ponemos ya sea el número, la(s) palabra(s), o el par de números a mirar por visualizar.
En este ejemplo, usaremos la función de magnitud, para asignar lso dos números, se separan por ','
```
http://localhost:4567/mag?value=50,30
```
8. Se debe visualizar de esta manera:

![](https://github.com/Ricardo-Olarte/TOOLS/blob/main/Images/Test.png)

__________________________________________________________________

## Autor

- Jose Ricardo Olarte Pardo - [Ricardo-Olarte](https://github.com/Ricardo-Olarte)
