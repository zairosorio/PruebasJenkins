#autor: zair osorio
#language: es


Característica: Crear usuario Rest


  @crearUsuario
  Escenario: Crear Usuario
    Cuando zair envia la siguiente operacion al servicio "https://petstore.swagger.io/v2/user"
    Entonces valida que el codigo de esta de estado sea




