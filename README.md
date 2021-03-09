# HOTELO

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

- Observar tipos de habitaciones que contengan los hoteles y sus servicios.

- Consultar el número de reservas disponibles de los hoteles.

# Parte privada de la aplicación web:

- Consultar información privada del huésped y sus reservas.

- Hacer una reserva en un hotel.

# Servicio interno:

- Cuando un usuario haga una reserva en uno de los hoteles se le mandará un correo con la información de la reserva que ha hecho.


## Equipo:

- Marcos Vázquez Martín (m.vazquezm.2017@alumnos.urjc.es / https://github.com/marcosvm13)

- David Payán Cabral (d.payan.2017@alumnos.urjc.es / https://github.com/dpc99)

- David Calderón Casarrubios (d.calderonc.2016@alumnos.urjc.es / https://github.com/calderon95)



## Capturas de pantalla de la aplicación web


- ### Principal.html

![Principal](https://user-images.githubusercontent.com/47868021/110248880-87b9cf00-7f73-11eb-904f-d5f156e3a190.jpeg)

Página principal de la aplicación web. Muestra los hoteles en los que puedes reservar.

- ### Principal2.html

![Principal2](https://user-images.githubusercontent.com/47868021/110248896-9ef8bc80-7f73-11eb-839c-b98283f3d802.jpeg)

Segunda página principal de la aplicación web. Muestra las actividades disponibles en los hoteles.

- ### Hotel.html
 
![InfoHotel](https://user-images.githubusercontent.com/47868021/110248908-aae47e80-7f73-11eb-941b-468b96bb8930.jpeg)

Página que muestra la información del hotel junto con las actividades y habitaciones disponibles.

- ### Actividad.html

![InfoActividad](https://user-images.githubusercontent.com/47868021/110249017-29d9b700-7f74-11eb-8c16-3d8205b285b8.jpeg)

Página que muestra la información de la actividad y muestra que hoteles la tienen.

- ### Reserva.html

![Elegir fechaI y fechaF](https://user-images.githubusercontent.com/47868021/110249052-58f02880-7f74-11eb-8f65-2e1277e2e338.jpeg)
![ElegirHabitacion](https://user-images.githubusercontent.com/47868021/110249067-77562400-7f74-11eb-80b7-d7057905bcf5.jpeg)

Pagina que se usa para crear la reserva en un hotel, primero eliges la fecha de inicio y final para posteriormente elegir en que habitación deseas hospedarte.

- ### ConfirmarReserva.html

![ConfirmarReserva](https://user-images.githubusercontent.com/47868021/110249080-8e951180-7f74-11eb-8fbd-8cb890cc9391.jpeg)

Página usada para la confirmación de la reserva del huesped.

- ### MisReservas.html

![MisReservas](https://user-images.githubusercontent.com/47868021/110249093-a5d3ff00-7f74-11eb-84d2-666190b7b306.jpeg)

Página que muestra las reservas e información del huesped.

- ### InsertarHotel.html

![AñadirHotel](https://user-images.githubusercontent.com/47868021/110249149-03684b80-7f75-11eb-9aef-b990f8e43dcd.jpeg)

Página que sirve para añadir un hotel dentro de la base de datos de la aplicación.

- ### AyadirActividad.html

![InsertarActividad](https://user-images.githubusercontent.com/47868021/110249218-740f6800-7f75-11eb-8d66-a6f8d58f648b.jpeg)

Página que sirve para añadir una actividad al hotel creado anteriormente.

- ### AyadirHabitación.html

![AñadirHabitacion](https://user-images.githubusercontent.com/47868021/110249157-0b27f000-7f75-11eb-9d84-b447c36d8bfb.jpeg)

Pagina que añade habitaciones al hotel creado anteriormente.

- ### InsertarActividad.html

![AñadirActividad](https://user-images.githubusercontent.com/47868021/110249246-943f2700-7f75-11eb-8823-4546e84520ec.jpeg)

Página que crea una nueva actividad dentro de la base de datos de la aplicación.

- ### InicioSesion.html

![Login](https://user-images.githubusercontent.com/47868021/110249319-e84a0b80-7f75-11eb-8f88-a5eca2245c21.jpeg)

Página que se utiliza para iniciar sesión de un huesped. (En progreso)




## Diagrama de Navegación
- Visualización de hoteles y actividades. Añadido de habitaciones y actividades a hoteles.
![Graph6](https://user-images.githubusercontent.com/47868021/110363025-53611400-8042-11eb-842b-a527ac9c9237.jpeg)

- Creación de hoteles junto con inserción de habitaciones y actividades.
![Graph_3](https://user-images.githubusercontent.com/47868021/110362928-34628200-8042-11eb-8298-afb058bd24af.png)

- Creación de reserva
![Graph4](https://user-images.githubusercontent.com/47868021/110362986-480de880-8042-11eb-85c7-1d722c5cf0c0.jpeg)

- Enlace de botones de cabecera.
![Graph5](https://user-images.githubusercontent.com/47868021/110363002-4cd29c80-8042-11eb-9c88-f08b8eaf2c32.jpeg)


## Diagrama UML

![UML](https://user-images.githubusercontent.com/47868021/110364038-966fb700-8043-11eb-81b6-1bef3092f9ad.jpeg)


## Diagrama E/R
![E-R](https://user-images.githubusercontent.com/47868021/110364188-c0c17480-8043-11eb-9c71-bf02b3278c59.jpeg)

![Diagrama ER](https://user-images.githubusercontent.com/61868600/110465310-89e76f00-80d4-11eb-989b-aeeef7b4c663.png)
