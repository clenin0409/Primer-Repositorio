@Pruebas_Automatizadas
Feature: Pruebas del servicio PUT Modificar una mascota existente

  @test
  # PUT /v2/pet
  Scenario: Validar servicio PUT Modificar una mascota existente
    Then Validar servicio PUT Modificar una mascota existente
      | body                                                                                                                                                                                           | exp | escenario     |
      | { "id": 0, "category": { "id": 0,   "name": "string" }, "name": "doggie",  "photoUrls": [    "string"  ],  "tags": [    {      "id": 0,      "name": "string"    }  ],  "status": "available"} | 200 | Satisfactorio |
