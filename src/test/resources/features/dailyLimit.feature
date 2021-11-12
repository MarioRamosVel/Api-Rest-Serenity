Feature: Limite Diario
  Con el fin de comprobar el funcionamiento del servicio
  Yo como usuario quiero comprobar el limite diario
  para poder saber la hora y el lugar donde me encuentro


  Scenario: Limite Diario
    Given el Tester1 intenta conocer diferentes ubicaciones
    When el envia usuario con limite de consultas ssuperadas
    Then el debo obetener un mensaje de error por limite diario