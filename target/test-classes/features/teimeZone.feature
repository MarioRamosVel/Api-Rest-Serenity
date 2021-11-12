Feature: TimeZone
  Con el fin de comprobar el funcionamiento del servicio
  Yo como usuario quiero comprobar zonas sin información
  para poder saber la hora y el lugar donde me encuentro

  Background:
    Given el Tester1 intenta conocer diferentes ubicaciones

  Scenario: TimeZone encontrada
    When el envia una ubicacion conocida
    Then el debe obtener su  información de manera correcta

  Scenario: TimeZone sin informacion
    When el envia una ubicacion desconocida
    Then el debo obetener un mensaje de sin informacion

  Scenario: TimeZone con informacion faltante
    When el envia una ubicacion poco conocida
    Then el debo obetener un mensaje con poca informacion