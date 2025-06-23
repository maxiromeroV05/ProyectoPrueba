# ProyectoPrueba

# 🧾 Instrucciones de Ejecución del Proyecto

Este proyecto está desarrollado en Java utilizando el framework **Spring Boot**. Está diseñado para gestionar **inscripciones a cursos**, permitiendo operaciones como crear, ver, actualizar y eliminar datos relacionados a **usuarios, cursos e inscripciones**.

A continuación, se explican paso a paso las instrucciones para ejecutar este sistema, pensando en personas que **nunca han trabajado con este tipo de aplicaciones**.

---

## 1. Requisitos previos

Antes de ejecutar el proyecto, es necesario contar con lo siguiente instalado en tu computador:

- Un programa para desarrollar, como **IntelliJ IDEA**, que permita trabajar con proyectos Java.
- Tener **Java 17 o superior** instalado.
- Conexión a internet para que el entorno pueda preparar el proyecto automáticamente.
- Una **base de datos en Oracle Cloud**, ya que el sistema necesita conectarse a ella para funcionar correctamente.

---

## 2. ¿Cómo funciona el proyecto?

Este proyecto está organizado en distintas partes, cada una con un rol específico:

- **Modelo (model):** Aquí están las clases que representan los datos (como Usuario, Curso e Inscripción).
- **Repositorio (repository):** Se encarga de acceder a la base de datos para guardar y obtener datos automáticamente.
- **Servicio (service):** Aquí vive la lógica del negocio. Es donde se define qué hacer con los datos antes de enviarlos o guardarlos.
- **Controlador (controller):** Recibe las solicitudes del usuario (como ingresar a una dirección web) y responde con la información correspondiente.
- **Aplicación principal:** Es la parte del proyecto que se ejecuta primero y que pone en marcha todo el sistema.

---

## 3. Pasos para ejecutar el proyecto

### Paso 1: Abrir el proyecto
- Abre IntelliJ IDEA (u otro programa similar) y selecciona la opción para **importar un proyecto existente**.
- Elige la carpeta del proyecto.
- El sistema detectará automáticamente que es un proyecto Maven y comenzará a prepararlo.

### Paso 2: Esperar que se cargue el proyecto
- Una vez abierto, el entorno descargará automáticamente todas las herramientas necesarias para que el sistema funcione.
- Esto puede tomar algunos minutos si es la primera vez.

### Paso 3: Ejecutar la aplicación
- Busca la clase principal del proyecto, que usualmente termina en la palabra `Application`.
- Ejecuta esa clase. Esto hará que el sistema inicie un **servidor local** en tu computador.

### Paso 4: Probar el sistema
- Una vez iniciado, el servidor estará listo para recibir solicitudes.
- Puedes probar las funcionalidades del sistema con un navegador o herramientas como **Postman**.
- El sistema te permitirá registrar usuarios, crear cursos, hacer inscripciones y consultar datos guardados.

---

## 4. Consideraciones importantes

Este proyecto **no usa una base de datos temporal**. En su lugar, está conectado a una base de datos real alojada en **Oracle Cloud**. Esto significa que:

- **Los datos se guardan permanentemente**, incluso si el sistema se apaga.
- Para que todo funcione, es importante que:
  - Tu base de datos en Oracle Cloud esté activa.
  - Las credenciales (usuario, contraseña, dirección del servidor, etc.) estén bien configuradas en el archivo del proyecto llamado `application.properties`.
  - Tu red permita conectarte a Oracle Cloud (que los puertos estén habilitados).
  - En algunos casos, puede ser necesario ajustar la ruta o ubicación del controlador de la base de datos en tu computador local.

Además, este proyecto está preparado para seguir creciendo. Puedes agregar fácilmente nuevas funciones como:
- Autenticación de usuarios.
- Reportes de información.
- Integración con otros servicios.
- Una interfaz gráfica que facilite su uso.

---

## 5. Pruebas unitarias

El proyecto incluye **pruebas unitarias**, que son pequeños programas que revisan si cada parte del sistema está funcionando correctamente.

Estas pruebas están enfocadas especialmente en la **lógica de los servicios** del sistema. Por ejemplo:
- Verificar que una inscripción se guarde bien.
- Comprobar que los datos se recuperen correctamente al buscarlos.
- Revisar que el sistema reaccione adecuadamente si los datos no existen o hay errores.

Estas pruebas fueron desarrolladas usando **JUnit** y **Mockito**, que son herramientas estándar en el desarrollo en Java. Aunque no muestran una interfaz visual, son muy importantes para mantener la calidad del sistema y evitar errores cuando se hacen cambios en el código.

---

## ✅ Conclusión

Este proyecto es una aplicación funcional creada con Java y Spring Boot, centrada en la gestión de cursos e inscripciones. Está bien estructurado, separando la lógica del sistema, los datos y la conexión con la base de datos.

Se conecta a una base de datos real en la nube (Oracle Cloud), lo que garantiza que los datos se guarden de forma segura y accesible desde distintos lugares.

Para ejecutarlo, basta con tener Java, un entorno de desarrollo como IntelliJ, importar el proyecto, conectarse correctamente a la base de datos, y ejecutar la aplicación desde la clase principal.

Además, gracias a las pruebas unitarias, se puede asegurar que la lógica principal del sistema funciona bien, incluso cuando se actualiza el código o se agregan nuevas funciones.

En resumen, es una base sólida para proyectos más grandes, ideal tanto para aprendizaje como para usar en entornos reales o académicos.
