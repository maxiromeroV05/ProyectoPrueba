# ProyectoPrueba

🧾 Instrucciones de Ejecución del Proyecto
Este proyecto está desarrollado en Java utilizando el framework Spring Boot. Está orientado a gestionar inscripciones en cursos, permitiendo operaciones básicas como crear, leer, actualizar y eliminar registros relacionados a usuarios, cursos e inscripciones.

A continuación, se detalla de forma clara y paso a paso de cómo ejecutar el proyecto correctamente, pensado para alguien que nunca ha trabajado con este tipo de aplicación:

1. Requisitos previos
Antes de poder ejecutar el proyecto, necesitas tener instalado en tu computador lo siguiente:

Un entorno de desarrollo como IntelliJ IDEA (preferentemente) o cualquier otro que soporte proyectos Maven y Spring Boot.

El JDK (Java Development Kit), versión 17 o superior.

Conexión a internet para que el entorno pueda descargar las dependencias necesarias.

Una base de datos de oracle cloud donde se necesita su conexion para el funcionamiento de ella.

2. Cómo funciona el proyecto
Este proyecto está estructurado en varias capas:

Modelo (model): Contiene las clases que representan los datos, como usuarios, cursos e inscripciones.

Repositorio (repository): Define las interfaces que permiten acceder a la base de datos de manera automática.

Servicio (service): Contiene la lógica del negocio. Por ejemplo, cómo se guarda una inscripción o cómo se obtiene una lista de cursos.

Controlador (controller): Es el encargado de recibir las solicitudes del usuario (por ejemplo, al ingresar a una URL) y responder con datos o acciones.

Aplicación principal: Es la clase que se encarga de iniciar el proyecto, lanzar el servidor y hacer que todo comience a funcionar.

3. Ejecución del proyecto paso a paso
Paso 1: Abrir el proyecto
Se debe abrir el entorno de desarrollo (por ejemplo, IntelliJ).

Luego, importar el proyecto como un proyecto Maven existente.

Esperar a que el entorno reconozca y cargue todas las configuraciones del proyecto.

Paso 2: Esperar la descarga de dependencias
El sistema automáticamente descargará las herramientas necesarias que el proyecto requiere para funcionar. Este proceso puede tardar unos minutos dependiendo de la conexión a internet.

Paso 3: Ejecutar la aplicación
Una vez que todo esté cargado, se debe buscar la clase principal del proyecto, que es la que contiene el método para iniciar (esta clase generalmente termina con la palabra “Application”).

Se debe ejecutar esa clase. El entorno levantará un servidor local que estará listo para recibir peticiones.

Paso 4: Probar el funcionamiento
Al ejecutarse correctamente, el proyecto inicia un servidor web en tu computador.

Desde allí, puedes acceder a las funciones del sistema usando un navegador o herramientas para hacer pruebas (como Postman).

El proyecto incluye funciones para registrar usuarios, cursos, hacer inscripciones y consultar información.

4. Consideraciones adicionales
Este proyecto está configurado para conectarse a una base de datos Oracle alojada en la nube mediante Oracle Cloud. Por lo tanto:

Para que la conexión funcione correctamente, debes asegurarte de que:

La base de datos en Oracle Cloud esté activa y accesible.

Las credenciales de conexión (usuario, contraseña, URL del host y puerto) estén correctamente configuradas en el archivo de propiedades del proyecto (application.properties o application.yml).

La red de Oracle Cloud permita conexiones entrantes desde tu máquina local (es decir, los puertos estén abiertos y accesibles).

Esta configuración permite que los datos persistan incluso si se apaga el servidor, ya que no se pierde la información como ocurriría con una base de datos temporal.

Además, el sistema está preparado para ser escalado o mejorado, permitiendo agregar nuevas funcionalidades como autenticación de usuarios, generación de reportes, integración con servicios externos, o una interfaz gráfica para facilitar el uso.

para poder conectarse a la base de datos correctamente si necesita la ruta donde se encuentra en su dispositivo y colocarla en "application.properties"
y se va a entrelasar sola debido a que tiene sus dependencias.

5. Pruebas unitarias
Este proyecto incluye pruebas unitarias que tienen como objetivo verificar que partes específicas del sistema funcionan correctamente de manera individual. Estas pruebas están orientadas especialmente a los servicios del proyecto, es decir, a la lógica que se encarga de procesar los datos antes de enviarlos o guardarlos.

Las pruebas fueron creadas utilizando las herramientas JUnit y Mockito, que son ampliamente utilizadas en proyectos Java para asegurar la calidad del código.

En este caso, las pruebas permiten verificar, por ejemplo:

Que una inscripción se guarde correctamente.

Que al buscar una inscripción por su identificador, el resultado sea correcto.

Que el sistema se comporte de forma esperada incluso cuando los datos no existen o hay errores.

Estas pruebas se ejecutan de forma automática dentro del entorno de desarrollo y permiten asegurar que los cambios en el código no rompan funcionalidades existentes. Son especialmente útiles para mantener el proyecto en crecimiento sin perder estabilidad.

El objetivo de estas pruebas no es ver una interfaz visual, sino confirmar que la lógica interna del sistema funciona tal como se espera.

✅ Conclusión
Este proyecto representa una aplicación funcional desarrollada con Java y Spring Boot, orientada a la gestión de inscripciones de usuarios a cursos. Está estructurado siguiendo buenas prácticas de programación: separando claramente las capas de modelo, lógica de negocio, acceso a datos y controladores.

Su conexión está configurada para trabajar con una base de datos real en Oracle Cloud, lo que permite persistencia de datos en la nube, acceso remoto y escalabilidad futura.

Cualquier persona que desee ejecutar el proyecto debe:

Tener instalado Java y un entorno compatible como IntelliJ.

Importar el proyecto, esperar que se configuren las dependencias y luego ejecutarlo desde la clase principal.

Asegurarse de tener acceso a la base de datos en Oracle Cloud con las credenciales correctas.

Probar el sistema a través de un navegador o herramienta de pruebas como Postman.

Además, el proyecto cuenta con pruebas unitarias que garantizan que la lógica principal funciona correctamente, ayudando a mantener la estabilidad y calidad del sistema a medida que se desarrollan nuevas funciones.

En resumen, se trata de una aplicación bien estructurada, lista para ejecutarse y ampliarse, ideal para ambientes de prueba, evaluación académica o como base para proyectos más avanzados.
