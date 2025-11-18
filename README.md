# Currency Converter

Una aplicación de consola escrita en Java para convertir monedas usando una API externa.  
Permite al usuario elegir las monedas de origen/destino, ingresar un monto, ver el resultado, y además mantiene un histórico de conversiones con marca de tiempo.

## 📝 Características

- Selección de moneda origen y destino mediante menú interactivo.  
- Conversión de montos reales llamando a una API de cambio de divisas.  
- Estructura modular: separación entre modelo (`model/`), Manejo de errores (`exception/`) API cliente (`api/`), lógica de negocio (`service/`), interfaz de usuario/menu (`ui/`) y clase principal `Main.java`.

## 📦 Estructura del proyecto
### 📁 api/
Conexión con la API externa.  
Encargado de manejar peticiones HTTP y parsear la respuesta JSON.

### 📁 exception/
Manejo de errores personalizados mediante `ApiException`.

### 📁 main/
Punto de entrada de la aplicación.  
`App.java` inicia el menú y prepara los servicios necesarios.

### 📁 model/
Modelos de datos que representan solicitudes y respuestas de conversión.

### 📁 service/
Contiene la lógica de negocio.  
`CurrencyService.java` coordina conversiones y validaciones.

### 📁 ui/
Interacción con el usuario mediante línea de comandos.  
`Menu.java` imprime el menú, solicita datos y muestra resultados.

## 🛠 Requisitos

- Java 11 o superior.
- Una **API Key** válida para el servicio de cambio de divisas.
- Conexión a Internet para que la aplicación pueda llamar a la API externa.

## 🚀 Cómo ejecutar

1. Clona este repositorio  
   ```bash
   git clone https://github.com/juandavidpardo9/currency-converter.git

2. Abre el proyecto en tu IDE (IntelliJ IDEA, Eclipse, VS Code…)

3. Ajusta el valor de la API Key en el archivo App.java
    ```java
    String apiKey = "TU_API_KEY_AQUI";
    CurrencyService service = new CurrencyService(apiKey);

4. Ejecuta la clase Main.java

5. Usa el menú para seleccionar la conversión deseada, ingresa el monto, y observa el resultado.

