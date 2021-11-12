Feature: Longitud
  Con el fin de comprobar el funcionamiento del servicio
  Yo como usuario quiero comprobar los valores de la longitud
  para poder saber la hora y el lugar donde me encuentro

  Background:
    Given el Tester1 intenta conocer diferentes ubicaciones

  Scenario: longitud real
    When el envia una longitud de valores permitidos
    Then el debe obtener su  información de manera correcta

  Scenario: longitud fuera de rango menor
    When el envia una longitud de valores debajo del permitido
    Then el debo obetener un mensaje de latitud erronea

  Scenario: longitud fuera de rango mayor
    When el envia una longitud de valores mayores al permitido
    Then el debo obetener un mensaje de latitud erronea

  Scenario: longitud rango decimal
    When el envia una longitud con valores decimales
    Then el debe obtener su  información de manera correcta
