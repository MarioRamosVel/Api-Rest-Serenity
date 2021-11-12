Feature: Olvido de Parametros
  Con el fin de comprobar el funcionamiento del servicio
  Yo como usuario quiero comprobar si no envio parametros
  para poder saber la hora y el lugar donde me encuentro

  Background:
    Given el Tester1 intenta conocer diferentes ubicaciones

  Scenario: Sin Latitud
    When el envia una ubicacion sin latitud
    Then el debe obtener mensaje de error

  Scenario: Sin Longitud
    When el envia una ubicacion sin longitud
    Then el debo obetener mensaje de error
