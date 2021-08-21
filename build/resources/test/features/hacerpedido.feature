#autor: zair osorio
#language: es


Característica: realizar pedido para mascota

  @hacerpedido
  Escenario: hacer pedido para mascota
    Cuando se envia la siguiente operacion al servicio "https://petstore.swagger.io/v2/store/order"
    Entonces valida que el codigo de estado sea