# LABORATORIO 8
Crear un API con Quarkus para posts de 140 caracteres, desplegar una app JavaScript en Amazon S3 para interacción, probar y asegurar con JWT y Cognito de AWS. Luego, separar el monolito en microservicios con AWS Lambda para escalabilidad en la infraestructura de AWS.

### PRERREQUISITOS

* [Maven](https://maven.apache.org/)

* [Git](https://github.com/)

* [Java](https://www.oracle.com/co/java/technologies/downloads/)

* [AWS](https://aws.amazon.com/es/training/awsacademy/)

* [Quarkus](https://es.quarkus.io/about/)

### Ejecución de Manera Local

1. Clonar el repositorio del proyecto:

```
git clone https://github.com/FDanielMC/AREP_LAB-8.git
```

2. Ingresar a la carpeta del repositorio que se clonó anteriormente:

```
cd AREP_Lab-8.git
```

3. Construir el proyecto:

```
mvn clean install
```

4. Se ejecuta el siguiente comando para correr el programa de manera local:  

```
mvn quarkus:run
```

5. Ingresa a la siguiente URL para accerder a la aplicación:

```
http://localhost:8080
```

### Programa 

La aplicación incluye dos formularios: 
- Uno para el inicio de sesión y otro para la funcionalidad principal, donde los usuarios pueden crear hilos, similar a Twitter, de hasta 140 caracteres, los cuales se registrarán en un hilo único de posts. 

Para ingresar al aplicativo debe usar los siguiente usuarios:

```
Usuario: DanielMoreno
Contraseña: Daniel2003

Usuario: JuanVivas
Contraseña: Juan2001

Usuario: SergioLopez
Contraseña: Sergio2002
```

## Funcionalidad

1. Ve a la siguiente URL http://localhost:8080 e ingresa con alguno de los usuarios anteriormente dados:

![image](https://github.com/FDanielMC/AREP_LAB-8/assets/123689924/98fe7425-57d1-415c-89c7-559c359a3363)

2. Ingresa con dos usuarios o más para que los hilos se muestren, a su vez con su respectivo creador.

![image](https://github.com/FDanielMC/AREP_LAB-8/assets/123689924/587e16db-c727-470a-a32b-644d8a5767fa)

Como se muestra, encontramos dos publicaciones, las cuales se han añadido al hilo de posts de nuestra aplicación. Es esencial considerar que si se recarga la página o se hace otro post, se podrán ver las demás publicaciones.

## Arquitectura

1. En el nivel Front-End, la implementación se basa en HTML, CSS y JavaScript, alojados en un Bucket S3 de AWS, un servicio de almacenamiento estático comúnmente utilizado para este propósito.

2. Para el Back-End, se han desarrollado tres microservicios utilizando Quarkus:

   - Usuario: Encargado de la gestión de usuarios, como la creación, consulta por ID y autenticación.
   - Hilo: Responsable de la gestión de los hilos, incluyendo la creación, consulta de todos los hilos, búsqueda por ID y la adición de posts a un hilo.
   - Post: Se ocupa de la gestión de los posts, permitiendo su consulta.

3. El uso de JSON Web Tokens (JWT) se implementa para la autenticación de usuarios:

   - Al iniciar sesión, el microservicio Usuario genera un JWT.
   - Este JWT se envía de vuelta al Front-End en la respuesta HTTP.
   - En las siguientes solicitudes del Front-End a los microservicios Back-End, el JWT se incluye en el encabezado.
   - Los microservicios Back-End validan el JWT antes de procesar la solicitud, asegurando la autenticidad del usuario.
  
## Autores

* **[Daniel Fernando Moreno Cerón](https://github.com/FDanielMC)**

* **[Juan Felipe Vivas Manrique](https://github.com/JuanFe2001)**

* **[Sergio Daniel López Vargas](https://github.com/sergiolopezzl)**
