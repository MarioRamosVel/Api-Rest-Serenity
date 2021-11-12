Feature: Usuarios
  Con el fin de comprobar el funcionamiento del servicio
  Yo como usuario quiero comprobar mi usuario
  para poder saber la hora y el lugar donde me encuentro

  Background:
    Given el Tester1 intenta conocer su ubicacion


  Scenario: Usuario Correcto
    When el envia su usuario valido
    Then el debe obtener su  información de manera correcta

  Scenario: Usuario Invalido
    When el envia su usuario invalido
    Then el debe obtener respuesta de Usuario no existe

  Scenario: Usuario Nulo
    When no envia el usuario
    Then el debe obtener respuesta de Usuario invalido