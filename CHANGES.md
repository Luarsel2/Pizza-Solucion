# Cambios
### Cambios Pizza
- Agregué un constructor para crear la pizza con sus datos.
- Agregué cocinada para saber si ya está lista.
- Cambié los métodos de cocinar por sabor por un atributo que guarda el sabor. El horno cocinará la pizza.
- Agregué getters y toString() para consultar y mostrar sus datos.
- Agregué validaciones para evitar datos incorrectos.

### Cambios Ingredientes
- Agregué un constructor y validaciones para las cantidades.
- Agregué salami porque hay pizzas de ese sabor.
- Cambié decorar y dar sabor por revisar y descontar ingredientes.
- Agregué getters y toString() para consultar y mostrar las cantidades.

### Cambios Horno
- Agregué un constructor para indicar si tiene gas.
- Agregué tiempoCoccion para guardar los minutos.
- Agregué encender() y estaListo() para controlar el horno.
- Dejé hornearPizza() para cocinar y quité cocinar() porque repetía la misma función.
- Agregué validaciones, getters y toString().

### Cambios Clientes
- Agregué nombre y un constructor.
- Cambié tieneDinero por una cantidad de dinero para comprobar si alcanza.
- Agregué puedePagar() y pagar() para realizar el pago.
- Cambié comer() para que reciba una orden preparada y pagada.
- Agregué validaciones, getters y toString().

### Cambios Orden
- Agregué un constructor y las referencias al cliente y la pizza.
- Cambié cantidadPedidos por cantidadPizzas.
- Quité cantidadIngredientes porque eso lo controla Ingredientes.
- Agregué preparada y pagada para saber el estado q se encuentre la orden.
- Agregué calcularTotal() y validaciones para evitar cobrar dos veces.
- Dejé la preparación en Cocina y cambié factura() para devolver el comprobante.

### Cambios Cocina
- Agregué un constructor que recibe los ingredientes y el horno.
- Quité los datos repetidos que ya guardan otras clases.
- Junté los pasos de preparación en prepararPizza().
- Agregué validaciones para revisar la orden, el horno y el dinero.
- Agregué getters y toString().

### MAIN
- Lo agregue para iniciar el programa.
- Cree los ingredientes, el horno, la cocina y el cliente.
- Cree una orden de dos pizzas.
- Agregué la preparación, el pago y los resultados en consola.
- Agregué un manejo de errores para mostrar qué salió mal.

- Agregué VistaPizzeria usando JFrame.
- Configuré el título, tamaño y cierre de la ventana.
- Cambié Main para abrir la interfaz gráfica.

### Panel de ventana
- Agregué paneles para el formulario, el comprobante y los botones.
- Usé layouts para organizar los componentes.
- Agregué bordes con títulos y márgenes.
- Coloqué etiquetas temporales para ver la distribución.

### Campos formu
- Agregué campos para nombre, dinero y cantidad.
- Cambié el formulario a tres filas.
- Agregué métodos para consultar lo escrito.
- Dejé la cantidad inicial en 1.

### Seccion pizza
- Agregué una lista para elegir el sabor.
- Agregué opciones para masa tradicional o delgada.
- Agrupé las opciones para elegir solo una masa.
- Agregué métodos para consultar las selecciones.

### Botones / comprobante
## Botones y comprobante

- Agregué una casilla para confirmar el pedido.
- Agregué los botones Crear orden y Limpiar.
- Agregué un área de texto para mostrar el comprobante.
- Agregué métodos para conectar los botones con el controlador.
- Agregué métodos para mostrar errores y limpiar el formulario.