# Api credada en spring boot
Los servicios estan creados con spring boot 

# Crear base de datos
en la carpeta resource estan los scripts para el localhost
asi mismo en el application.properties estan las cofiguraciones

# URL's

Login
http://localhost:8080/api/seguridad/login devuelve el token el cual debe ir en los header de cada petición.

Guardar o actualizar persona
para actualizar se debe enviar el ID
http://localhost:8080/api/personas/savePersona devuelve la persona actualizada o guardada

Lista de personas
http://localhost:8080/api/personas/findAllPersona devuelve la lista de personas

Guardar o actualizar tarjeta de credito
para actualizar se debe enviar el ID
http://localhost:8080/api/tarjetaCredito/saveTarjetaCredito devuelve la persona actualizada o guardada

Lista de personas
http://localhost:8080/api/tarjetaCredito/findAllTarjetaCredito devuelve la lista de tarjetas de credito



