@Pruebas_Automatizadas
Feature: Pruebas del servicio GET obtener una mascota existente

  @test
  # POST /v2/pet/{id}
  Scenario: Validar servicio GET obtener una mascota existente
    Then Validar servicio GET obtener una mascota existente
      | exp | escenario            |
      | 200 | successful operation |
