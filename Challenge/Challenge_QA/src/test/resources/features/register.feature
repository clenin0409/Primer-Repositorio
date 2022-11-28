@Pruebas_Automatizadas
Feature: Flujo de Registro
  Como usuario nuevo deseo poder registrarme en la web

  @Rtest01
  Scenario: Ingreso y registro en web
    Given Validar que la web este operativa
    When Ingresa las credenciales para registro "example0@mail.com" y "peru2022"
    Then mostrar alerta con mensaje de reistro sactisfactorio
