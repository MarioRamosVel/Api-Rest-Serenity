Feature: Latitud
  Con el fin de comprobar el funcionamiento del servicio
  Yo como usuario quiero comprobar los valores de la latitud
  para poder saber la hora y el lugar donde me encuentro

  Background:
    Given el Tester1 intenta conocer diferentes ubicaciones

  Scenario: latitud real
    When el envia una langitud de valores permitidos
    Then el debe obtener su  información de manera correcta

  Scenario: latitud fuera de rango menor
    When el envia una latitud de valores debajo del permitido
    Then el debo obetener un mensaje de latitud erronea

  Scenario: latitud fuera de rango mayor
    When el envia una latitud de valores mayores al permitido
    Then el debo obetener un mensaje de latitud erronea

  Scenario: latitud rango decimal
    When el envia una latitud con valores decimales
    Then el debe obtener su  información de manera correcta
