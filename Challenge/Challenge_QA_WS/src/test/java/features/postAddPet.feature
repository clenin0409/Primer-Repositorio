@Pruebas_Automatizadas
Feature: Pruebas del servicio POST agregar mascota

  @test
  # POST /v2/pet
  Scenario: Validar servicio POST agregar mascota
    Then Validar servicio POST crear usuario
      | body                                                                                                                                                                                           | exp | escenario     |
      | { "id": 0, "category": { "id": 0,   "name": "string" }, "name": "doggie",  "photoUrls": [    "string"  ],  "tags": [    {      "id": 0,      "name": "string"    }  ],  "status": "available"} | 200 | Satisfactorio |
