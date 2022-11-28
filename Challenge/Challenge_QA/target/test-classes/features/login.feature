@Pruebas_Automatizadas
Feature: Flujo de ingreso
  Como usuario deseo poder loguearme con mi usuario registrado en la web

  @Ltest02
  Scenario: Ingreso y logueo en la web
    Given Validar que la web este operativa
    When Ingresa las credenciales "example1@mail.com" y "peru2022"
    Then mostrar logueo exitoso "example1@mail.com"

  @test02
  Scenario: Inicio y cierre de sesion en la web
    Given Validar que la web este operativa
    When Ingresa las credenciales "example1@mail.com" y "peru2022"
    And  salir de sesion
    Then mostrar pantalla de inicio con boton login

