Feature: Usuarios
  Con el fin de comprobar el funcionamiento del servicio
  Yo como usuario quiero comprobar mi usuario
  para poder saber la hora y el lugar donde me encuentro

  Scenario: Usuario Correcto

    Given el Tester1 intenta conocer su ubicacion
    When el envia su usuario valido
    Then el debe obtener una respuesta correcta del servicio