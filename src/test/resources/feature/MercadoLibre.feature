Feature: Buscar productos en la pagina de Mercado Libre
  Yo como usuario de la pagina Mercado Libre
  Quiero buscar productos que tengan stock mayor igual a 3 unidades


  Scenario: Buscar productos con inventario minimo de 3 unidades
  Given la pagina de Mercado Libre esta estable
    When doy click en el pais bolivia
    And ingreso el producto "Parlantes bose" a buscar
    And verificamos y filtramos los productos usados mayor o igual a 3
    Then El listado de resultados nos desplegara solo de los productos "usado"
