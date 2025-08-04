# language: es
Característica: : Compra de productos en SwagLabs

  Como usuario registrado
  Quiero agregar productos al carrito y finalizar la compra
  Para recibir la confirmación exitosa del pedido

  Escenario: Flujo completo de compra en SwagLabs
    Dado que estoy logueado en la aplicación SwagLabs
    Cuando agrego al carrito los siguientes productos:
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |
    Y voy al carrito de compras
    Y elimino un producto del carrito
    Y procedo a checkout
    Y completo la información de envío con los datos del archivo "datos_checkout.csv"
    Y finalizo la compra
    Entonces los productos confirmados en el checkout deben ser:
      | Sauce Labs Backpack     |
      | Sauce Labs Bolt T-Shirt |
    Y la compra debería ser confirmada con el mensaje "THANK YOU FOR YOU ORDER"