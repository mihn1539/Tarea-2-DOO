# Tarea-2-DOO
Integrantes: Martín Henriquez, Jorge Pedreros, Rodolfo Rubio
![UML](https://github.com/user-attachments/assets/fb6ceebd-6d81-409a-aaa9-b09490f43e6b)
Primeramente, se creó una nueva clase abstracta llamada Invitado que generaliza a Empleados y Externos, nueva clase que permite invitar a personas que no estén asociadas a la empresa. Invitado posee la relación de dependencia con Asistencia y la implementación de Invitable, mientras que la relación de dependencia de Reunion con Empleado se mantiene. Cada Invitado cuenta con una Invitación que está relacionada directamente con la reunión a la que fue invitado. Para esta característica se cambió la relación entre Invitable y Reunion, la cual ahora está en una relación de dependencia de uso con esta última.

Dentro de Reunion, dado que cada Invitado cuenta con su propia Invitacion, estas clases ya no están en una relación de Composición. Además se agregó un nuevo método dentro de la clase llamado unirseReunion, que hace uso de la Invitacion que posee cada Invitado para verificar que cada persona que trata de unirse a la Reunion esté realmente invitada a esta. 


En todas las otras clases, se crearon getters y setters requeridos principalmente en la creación de los metodos toString de cada una.
