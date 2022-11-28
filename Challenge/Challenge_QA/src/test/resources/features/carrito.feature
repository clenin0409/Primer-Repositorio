@Pruebas_Automatizadas
Feature: Flujo de compra
  Como usuario deseo poder agregar un producto al carrito

  @Ltest02
  Scenario: Agregar una laptop al carrito
    Given Validar que la web este operativa
    When selecciono un la categoria Laptops
    And  agrego una laptop al carrito
    Then mostrar producto en carrito
