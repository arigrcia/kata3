# Kata 3 – Transformación de datos a JSON

## Objetivo
Leer usuarios en formato JSON desde la API randomuser.me, convertirlos en objetos de Java, descartar los registros no válidos y generar un JSON propio con la lista de usuarios y un bloque de metadatos.

## Cómo compilar y ejecutar
Abrir el proyecto en IntelliJ IDEA como proyecto Maven y ejecutar la clase `Main`.
El JSON generado se muestra por consola. Necesita conexión a internet.

## Dependencias y versión de JDK
- JDK 26
- Gson 2.14.0

## Estructura y clases principales
- `domain.model.User`: entidad de dominio con nombre, género y email.
- `domain.model.Report`: salida JSON con el total, la fecha de generación y la lista de usuarios.
- `adapters.dtos.UserDto`: DTO con la estructura del JSON de randomuser.
- `ports.UserReader`: interfaz que lee usuarios desde un `InputStream`.
- `adapters.RandomUserReader`: lee el JSON con Gson, valida cada registro (`isValid`) y lo transforma en `User` (`toUser`).
- `adapters.JsonReportWriter`: serializa el `Report` a JSON en un `OutputStream`.
- `Main`: abre la URL, lee los usuarios, crea el `Report` y lo escribe por consola.

## Ejemplo de entrada y salida
Entrada:
```json
{
  "results": [
    { "gender": "female", "name": { "first": "Ana", "last": "López" }, "email": "ana.lopez@example.com" },
    { "gender": "robot", "name": { "first": "Juan", "last": "Suárez" }, "email": "juan.suarez@example.com" },
    { "gender": "male", "email": "pedro.ramirez@example.com" }
  ]
}
```
Salida:
```json
{
  "total": 1,
  "generatedAt": "2026-11-08",
  "users": [
    { "name": "Ana López", "gender": "female", "email": "ana.lopez@example.com" }
  ]
}
```
Juan se descarta por tener un género no válido y Pedro por no tener nombre.

## Repeticiones
La kata se ha repetido tres veces, escribiendo el código desde cero en cada una:
- `develop`: la salida se escribe en el fichero `output.json` e incluye un `users.json` de ejemplo con registros válidos e inválidos.
- `develop-2`: variación: la salida se muestra por consola con `System.out`.
- `develop-3`: misma versión que `develop-2`.

La versión final está en `master`.

## Verificación
- Entrada correcta: al ejecutar `Main` se muestra el JSON con los 10 usuarios, el total y la fecha.
- Registros inválidos: con el `users.json` de `develop` (6 usuarios, 3 mal formados) solo aparecen los 3 válidos.
- Dataset vacío: con la entrada `{"results":[]}` la salida tiene `total: 0` y la lista vacía.
- El JSON generado se puede volver a leer, ya que tiene el mismo formato que produce Gson.
- Cambiar el origen (URL, fichero o texto) no obliga a cambiar `RandomUserReader`, porque recibe un `InputStream`.

## Vídeo
[Enlace al vídeo]