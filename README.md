# Sistema Saludador

aplicación de escritorio hecho con **Java y JavaFX**. Es una maqueta para mostrarle al cliente cómo se vería el sistema y confirmar que ambas partes tienen la misma idea antes de construir la versión final.

## ¿Que hace? 

El sistema implementa el caso de uso **Solicitar saludo**:
1. El estudiante hace clic en "Solicitar saludo".
2. El sistema le pide nombre, edad y hora (AM/PM).
3. El estudiante ingresa los datos y pulsa "Aceptar".
4. El sistema saluda al estudiante por su nombre y menciona su edad. Si la hora es AM dice "Buenos días", y si es PM, "Buenas tardes".
Además valida los datos (nombre no vacío, edad como número entero entre 1 y 120, y hora seleccionada) y muestra un mensaje de error en rojo cuando algo está mal.

## Requisitos
- Windows
- JDK 25 o superior (se verifica con `java -version`)
- Conexión a internet la primera vez, porque se descargan Maven y JavaFX
No hace falta instalar Maven: el proyecto incluye Maven Wrapper (`mvnw`).

## Cómo ejecutar (Windows)

1. Clonar el repositorio:
git clone [URL-DEL-REPOSITORIO]
2. Abrir una terminal en la carpeta del proyecto.
3. Ejecutar:
   .\ejecutar.bat
La primera vez puede tardar unos minutos mientras descarga las dependencias. Después abre la ventana "Sistema Saludador".

La primera vez Maven Wrapper descarga las dependencias; puede tardar unos minutos.

## Estructura del repositorio

| Carpeta o archivo | Contenido |
|---|---|
| src/ | Código fuente en Java (`SistemaSaludadorApp.java`) |
| pom.xml | Configuración de Maven: dependencias y versión de Java |
| ejecutar.bat | Atajo para ejecutar la aplicación en Windows |
| mvnw, mvnw.cmd, .mvn/ | Maven Wrapper |
| prompts/ | Prompts utilizados con la IA, en orden |
| docs/ | Documento de reflexión sobre lo realizado |

## Uso de IA

El proyecto se desarrolló con apoyo de IA. Los prompts quedan en la carpeta `prompts/` y la reflexión sobre el proceso está en `docs/reflexion.md`.


