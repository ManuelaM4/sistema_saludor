# Reflexión del laboratorio: Sistema Saludador

## Cómo trabajé
Trabajé con Java y JavaFX. Ya tenía el JDK instalado por trabajos anteriores hechos en Visual Studio. El IDE que utilicé es Cursor, que trae un agente de IA integrado. También usé GitHub para crear el repositorio y organizar las carpetas necesarias para la entrega. El primer prompt lo ejecutó el agente de Cursor y generó la base del prototipo; el segundo prompt lo redacté, pero el agente no pudo ejecutarlo.

## Retos
- Instalar Git para poder clonar el repositorio y trabajar con él.
- Aprender a hacer commit desde Cursor y lograr que todo apareciera en el repositorio de GitHub.
- El límite de uso del agente de Cursor: dejó de responder y, según el panel de mi cuenta gratuita, el uso se renueva el 8 de noviembre.

## Descubrimientos
- No fue necesario instalar todo manualmente: el proyecto usa Maven Wrapper, que descarga Maven por sí solo.
- El `.gitignore` sirve para que Git no suba archivos pesados o generados automáticamente, como `target/`.
- Cada prompt modifica los mismos archivos del proyecto, y Git guarda el historial de cambios en los commits.

## Sorpresas
- Que el primer prompt generara tantos archivos que yo no conocía. Nunca había usado JavaFX y tuve que investigar para qué servía cada uno.

## Comandos, librerías o conceptos que no comprendí
- No entendí bien el funcionamiento interno de JavaFX, ni cómo `javafx:run` encuentra la clase principal, ni cómo Maven descarga JavaFX por dentro. Solo sé que lo hace a partir del `pom.xml`.
- No comprendí del todo la carpeta `target/`. Entiendo que Maven la genera al compilar y que no debe subirse a GitHub.

## Estructura del software
- `SistemaSaludadorApp.java`: contiene todo el programa. Tiene tres pantallas, cada una en su método: `crearInicio()` (botón "Solicitar saludo"), `crearFormulario()` (nombre, edad y AM/PM, con validaciones) y `crearSaludo()` (muestra "Buenos días" o "Buenas tardes" con el nombre y la edad). El programa cambia de pantalla reemplazando el contenido de la misma ventana.
- `pom.xml`: archivo de Maven que indica la versión de Java y las librerías necesarias (JavaFX).
- `ejecutar.bat`: atajo para Windows que compila y abre la aplicación con un solo clic.
- `mvnw`, `mvnw.cmd` y `.mvn/`: Maven Wrapper, que descarga Maven automáticamente para no tener que instalarlo.
- `target/`: carpeta donde Maven guarda el código compilado. No es código escrito por mí y está en el `.gitignore`.

## Uso de IA
- Primer prompt (`prompts/primero.txt`): lo ejecutó el agente de Cursor y generó la estructura inicial del proyecto, con la ventana y el botón "Solicitar saludo".
- Segundo prompt (`prompts/segundo.txt`): describe el flujo completo (formulario, validaciones y saludo). El agente de Cursor alcanzó su límite de uso y no pudo ejecutarlo, así que el código de esta etapa lo obtuve con otra herramienta de IA (Gemini), a partir de esa misma descripción, y lo integré en el proyecto de Cursor. Lo probé ejecutando `ejecutar.bat`.ss