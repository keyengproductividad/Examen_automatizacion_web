#language: es
@testfeature
Característica: Login

  @test

  Esquema del escenario: Iniciar sesión
    Dado estoy en la página de la tienda
    Y me logueo con mi usuario <usuario> y contraseña <password>
    Cuando navego a la categoria <categoria> y subcategoria <subcategoria>
    Y agrego 2 unidades del primer producto al carrito
    Entonces valido en el popup la confirmación del producto agregado
    Y valido en el popup que el monto total sea calculado correctamente
    Cuando finalizo la compra
    Entonces valido el titulo de la pagina del carrito
    Y vuelvo a validar el calculo de precios en el carrito


  @valido
    Ejemplos:
    | usuario                           |   password                 |  categoria   |  subcategoria |
    | "keyeng.compartir@gmail.com"      |   "mailmanPRODUCTIVIDAD9"  | "CLOTHES"    |  "Men"          |


    @Login_invalido
    Ejemplos:
      | usuario                           |   password                      |  categoria   |  subcategoria |
      | "keyeng.compartir@gmail.comsss"      |   "mailmanPRODUCTIVIDssAD9"  | "CTHES"    |  "Men"          |

    @categoria_inexistente
    Ejemplos:
      | usuario                           |   password                 |  categoria   |  subcategoria |
      | "keyeng.compartir@gmail.com"      |   "mailmanPRODUCTIVIDAD9"  | "CAT"        |  "DOG"          |
