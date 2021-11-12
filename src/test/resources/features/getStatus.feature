Feature: Validación de API
  Con el fin de comprobar el funcionamiento del servicio
  Yo como usuario quiero poder conocer mi ubicación
  para poder saber la hora y el lugar donde me encuentro

  @signup
  Scenario: Respuesta exitosa de API

    Given el Tester1 quiere conocer las caracteristicas la ubicicacion
    When el envia la latitud y longitud
    Then el debe obtener las caraacteristicas del lugar donde se encuentra

