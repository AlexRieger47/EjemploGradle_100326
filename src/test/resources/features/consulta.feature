Feature: Consulta de informacion
  Como usuario del sistema
  Quiero poder consultar informacion
  Para obtener los datos que necesito

  Scenario Outline: Consulta exitosa de informacion
    Given que el usuario se encuentra en la pagina principal de Yahoo!
    When el usuario ingresa los "<datos>" de busqueda validos
    Then el sistema muestra el titulo de la pagina con la informacion "<datos>"

    Examples:
      | datos          |
      | clima          |