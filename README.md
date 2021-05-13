# HOTELO

#Video Presentación
https://youtu.be/Sx86pIxVYMo

Version Alternativa:
- https://youtu.be/abcoDznvw9Q
- https://youtu.be/LqoInzi1Y5k

# Descripción de la web:

La aplicación web consiste en una web de búsqueda y reserva de habitaciones de hoteles. En ella se mostrarán los hoteles pudiendo ver con cuantas habitaciones cuenta, si quedan reservas y las actividades que se pueden hacer en esos hoteles.

# Entidades:

- **Huésped**: Contiene la información de los huéspedes (Nombre y Apellidos del huésped, Contraseña, Telefono y Correo electrónico).

- **Hotel**: En él se encuentra la información del hotel (Nombre, Dirección, Número de habitaciones, Número de reservas y Actividades que se hagan en el hotel).

- **Reserva**: Contiene los datos de la reserva (Número de la reserva, Nombre del huésped, Nombre del hotel, Fecha de entrada, Fecha de salida).

- **Habitación**: Datos de la habitación (Nombre del hotel, Tipo de habitación, Tamaño de habitación, Servicios de la habitación).

- **Actividades**: Contiene la información de las actividades que se pueden hacer en un hotel (Nombre de la actividad, Descripción de la actividad, Número de plazas).

# Parte pública de la aplicación web:

- Búsqueda de hoteles.

- Mostrar actividades de los hoteles.

- Inicio Sesión y Crear Usuario

# Parte privada de la aplicación web:

- Consultar información privada del huésped y sus reservas.

- Hacer una reserva en un hotel.

- Crear Actividades, Hoteles y habitaciones

# Servicio interno:

- Cuando un usuario haga una reserva en uno de los hoteles se le mandará un correo con la información de la reserva que ha hecho.


## Equipo:

- Marcos Vázquez Martín (m.vazquezm.2017@alumnos.urjc.es / https://github.com/marcosvm13)

- David Payán Cabral (d.payan.2017@alumnos.urjc.es / https://github.com/dpc99)

- David Calderón Casarrubios (d.calderonc.2016@alumnos.urjc.es / https://github.com/calderon95)



## Capturas de pantalla de la aplicación web

### Páginas públicas

- #### Principal.html

![Principal](https://user-images.githubusercontent.com/61868600/114204165-28c3ed00-9959-11eb-9a86-60cf145fa027.png)

Página principal de la aplicación web. Muestra los hoteles en los que puedes reservar.

- #### Principal2.html

![Principal2](https://user-images.githubusercontent.com/61868600/114204330-5c067c00-9959-11eb-8469-b0f5d9957cc1.png)

Segunda página principal de la aplicación web. Muestra las actividades disponibles en los hoteles.

- #### InicioSesion.html

![InicioSesion](https://user-images.githubusercontent.com/61868600/114204964-16967e80-995a-11eb-9654-ee3693ba98e4.png)

Página que se utiliza para iniciar sesión de un huesped. Hay dos tipos de huéspedes, usuarios y administradores.

- #### CrearHuesped.html

![crearHuesped](https://user-images.githubusercontent.com/61868600/114205048-30d05c80-995a-11eb-99e8-6b73e41f0eed.png)

Página que se utiliza para crear una cuenta. La cuenta creada es de usuario normal, no de administrador.

- #### Hotel.html
 
![Hotel_user](https://user-images.githubusercontent.com/61868600/114204435-7a6c7780-9959-11eb-9175-8f5202d83d49.png)

Página que muestra la información del hotel junto con las actividades y habitaciones disponibles. Los huéspedes que han iniciado sesión pueden hacer reservar una habitación a partir de esta página.

![Hotel_admin](https://user-images.githubusercontent.com/61868600/114204445-7e989500-9959-11eb-89ba-7bfc6be1466b.png)

Los administradores también pueden añadir actividades al hotel, añadir o eliminar habitaciones y eliminar el hotel de la aplicación.

- #### Actividad.html

![Actividad](https://user-images.githubusercontent.com/61868600/114206360-8d804700-995b-11eb-9f8b-6f54dbd278db.png)

Página que muestra la información de la actividad y muestra que hoteles la tienen.

![Actividad_admin](https://user-images.githubusercontent.com/61868600/114206373-93762800-995b-11eb-99a9-796d20b4e616.png)

A los administradores les aparece la opción de eliminar la actividad de la aplicación.

### Páginas privadas

- #### Reserva.html

![Reserva](https://user-images.githubusercontent.com/61868600/114207086-48a8e000-995c-11eb-8a2a-d7dff37747d5.png)
![Reserva2](https://user-images.githubusercontent.com/61868600/114207103-4ba3d080-995c-11eb-975d-bae777a9895c.png)

Página que se usa para crear la reserva en un hotel, primero eliges la fecha de inicio y final para posteriormente elegir en que habitación deseas hospedarte. Al hacer una reserva se manda un correo a la cuenta de correo electrónico del usuario.

- #### ConfirmarReserva.html

![ConfirmarReserva](https://user-images.githubusercontent.com/61868600/114207182-637b5480-995c-11eb-8c59-80f08862aa02.png)

Página usada para la confirmación de la reserva del huésped.

- #### MisReservas.html

![MisReservas](https://user-images.githubusercontent.com/61868600/114207665-e7354100-995c-11eb-8b4c-4caf14a4be58.png)

Página que muestra las reservas e información del huesped. Al eliminar una reserva se manda un correo a la cuenta de del usuario.

- #### InsertarHotel.html

![InsertarHotel](https://user-images.githubusercontent.com/61868600/114207785-0e8c0e00-995d-11eb-969c-416163781b6e.png)

Página que sirve para añadir un hotel dentro de la base de datos de la aplicación. Solo tienen acceso a ella los administradores.

- #### AyadirActividad.html

![ayadirActividad](https://user-images.githubusercontent.com/61868600/114207996-472be780-995d-11eb-986f-277d94ac9a88.png)

Página que sirve para añadir una actividad al hotel creado anteriormente. Solo tienen acceso a ella los administradores.

- #### AyadirHabitación.html

![ayadirHabitacion](https://user-images.githubusercontent.com/61868600/114207901-28c5ec00-995d-11eb-93c4-0759b207c1b5.png)

Pagina que añade habitaciones al hotel creado anteriormente. Solo tienen acceso a ella los administradores.

- #### InsertarActividad.html

![InsertarActividad](https://user-images.githubusercontent.com/61868600/114207970-3e3b1600-995d-11eb-860d-4f0152160075.png)

Página que crea una nueva actividad dentro de la base de datos de la aplicación. Solo tienen acceso a ella los administradores.




## Diagrama de Navegación
- Visualización de hoteles y actividades. Añadido de habitaciones y actividades a hoteles.
![Graph6](https://user-images.githubusercontent.com/47868021/110363025-53611400-8042-11eb-842b-a527ac9c9237.jpeg)

- Creación de hoteles junto con inserción de habitaciones y actividades.
![Graph_3](https://user-images.githubusercontent.com/47868021/110362928-34628200-8042-11eb-8298-afb058bd24af.png)

- Creación de reserva
![Graph4](https://user-images.githubusercontent.com/47868021/110362986-480de880-8042-11eb-85c7-1d722c5cf0c0.jpeg)

- Enlace de botones de cabecera.
![Graph5](https://user-images.githubusercontent.com/47868021/110363002-4cd29c80-8042-11eb-9c88-f08b8eaf2c32.jpeg)

- Crear cuenta e inicio y fin de sesión.
![Transicion usuarios](https://user-images.githubusercontent.com/61868600/114265910-b7854800-99f3-11eb-8e3e-01b5c0c51474.png)

- Diagrama de navegación completo resumido.
![Transicion de estados](https://user-images.githubusercontent.com/61868600/114266452-c3bed480-99f6-11eb-8a19-6c5e3700db42.png)


## Diagrama UML

![UML](https://user-images.githubusercontent.com/47868021/110364038-966fb700-8043-11eb-81b6-1bef3092f9ad.jpeg)


## Diagrama E/R
![E-R](https://user-images.githubusercontent.com/47868021/110364188-c0c17480-8043-11eb-9c71-bf02b3278c59.jpeg)

![Diagrama ER](https://user-images.githubusercontent.com/61868600/110465310-89e76f00-80d4-11eb-989b-aeeef7b4c663.png)

## Diagrama de Clases y Templates
![Diagrama de clases y templates](https://user-images.githubusercontent.com/47868021/114309980-6788ad00-9ae9-11eb-8c58-aa20b9146f38.jpeg)

## Instrucciones para desplegar la aplicación

- En STS, click derecho en el proyecto y en Run As selecionas Maven Build.. , posteriormente aparecerá una ventana y en la opción Goals rellenar con **"clean package"** y selecionar Run. Luego en la carpeta Target de la aplicación aparecerá el .jar creado.
 
- Crear una VM de Linux en la que primero utlizar en el terminal el comando "sudo apt update" para actualizar el paquete apt para luego instalar java JDK mediante el comando **"sudo apt install openjdk-11-jdk"**. 

- Posteriormente instalar mysql-server o docker, en nuestro caso utilizaremos docker que contiene una imagen de mysql-server. Para ello primero usamos el comando **"sudo apt install apt-transport-https ca-certificates curl software-properties-common"** para instalar paquetes de requisitos previos que permitan a apt usar paquetes a través de HTTPS.
 
- Luego utilizar **"curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add - "** para añadir la clave de GPG para el repositorio oficial de Docker en el sistema y **"sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu focal stable" "** para agregar el repositorio de Docker a las fuentes de apt.

- Con el comando **"sudo apt update"** actualizamos el paquete de base de datos con los paquetes de Docker del repositorio agregado y finalmente instalamos docker mediante **"apt-cache policy docker-ce"**. 

- Para comprobar si el Docker está funcionando se usa el comando **"sudo systemctl status docker"**, en él se puede observar si el servicio está activo y en ejecucción.

- Iniciamos el docker de mysql-server mediante el comando **"docker run --rm -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=hotelo -p 3306:3306 -d mysql:8.0.22"**.

- Para subir el .jar a la VM dentro de la aplicación de VirtualBox, click derecho a la VM que se va a utilizar y click en Configuración. En 'General' dentro de la pestaña de 'Avanzado' ponemos 'Compartir portapapeles' y 'Arrastra y Soltar' como Bidireccional ambos y arrastramos el .jar a la carpeta que queramos dentro de la VM.

- Para iniciar la aplicación web del .jar utilizamos en el terminal de Linux el comando **"java -jar Hotelo-0.0.1-SNAPSHOT"** y para iniciar el servicio REST utilizamos el comando **"Hotelo_Rest-0.0.1-SNAPSHOT"** en otro terminal.


# Interfaz del servicio interno

El servicio interno de esta aplicación sirve para mandar un correo de confirmación al usuario que solicita o cancela una reserva. La URL de entrada al servicio interno es http://hoteloRest:8090/email/send.

Como parámetro se manda un objeto de la clase Correo, cuyo constructor es *Correo(String email, String content, String subject)*, donde *email* es la cuenta de correo electrónico a la que se manda el correo, *content* es el mensaje que se manda en el correo y *subject* es el asunto del correo. Un ejemplo de su uso en la aplicación:
```java
String url="http://hoteloRest:8090/email/send";

//usu es de la clase Huesped
HttpEntity<Correo> re = new HttpEntity<>(new Correo(usu.get().getCorreo(), "Buenos dias " + usu.get().getNombreHuesped() + ".\n Reserva realizada para los dias " + reserva.getFechaDeEntrada() + " a " + reserva.getFechaDeSalida()+ " en la habitacion " + reserva.getHabitacion().getNumero() + " de tamayo " + reserva.getHabitacion().getTamayo() + ", del hotel " + reserva.getHabitacion().getHotel().getNombreHotel() + ", en la direccion "+ reserva.getHabitacion().getHotel().getDireccion()+ " con numero de referencia "+ reserva.getId() +".\n Esperemos que disfrute, \n Un saludo.","Reserva Hotelo"));	

restTemplate.postForEntity(url, re, String.class);
```
El servicio devuelve un booleano que indica si se ha mandado el correo correctamente.


# Comunicación entre los componentes de la aplicación

![Infraestructura de la aplicación](https://user-images.githubusercontent.com/61868600/117839470-8b234c80-b27b-11eb-8d1f-e7955ec51b47.png)

# Actualización del diagrama de clases y templates
![Redis](https://user-images.githubusercontent.com/61940472/117953525-603a0680-b316-11eb-9b69-e15c693b846d.jpg)

# Desplegar la aplicación con Docker

1) Construir las aplicaciones y poner el .jar dentro de una carpeta llamada target con los nombres hotelo y hotelo_rest
2) Posicionarse sobre la raíz del proyecto DAD donde se encuentra el docker-compose.yml
3) Ejecutar el comando docker compose up
