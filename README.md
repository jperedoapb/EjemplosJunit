# Junit 5 proyecto inicial casos sencillos

JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage

Plataforma JUnit: es la base para lanzar el marco de prueba en la JVM.

JUnit Jupiter: es un nuevo modelo de programación y modelo de extensión extendido por JUnit5, utilizado para escribir casos de prueba. El subproyecto Júpiter proporciona un TestEngine para ejecutar pruebas en Júpiter en la plataforma.

JUnit Vintage: proporciona un TestEngine que ejecuta JUnit 3 y JUnit 4 en la plataforma.

&nbsp;

# Dependecia Maven de Junit
Se debe recalcar que Junit5 corre en Java 1.8 para arriba. 
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.8.2</version>
        </dependency>




## Anotaciones 📄
| Anotación          | Explicación| 
|--------------------|--------------------------------------------| 
| @Test              | El método de presentación es un método de prueba. A diferencia de la anotación @Test de JUnit 4, esta anotación no declara ningún atributo, porque las extensiones de prueba en JUnit Jupiter funcionan en función de sus propias anotaciones dedicadas. |
| @ParameterizedTest | El método de representación es una prueba parametrizada. |
| @RepeatedTest      | El método de presentación es una plantilla de prueba para pruebas repetidas.                                                                        |
| @TestFactory       | El método de representación es una fábrica de pruebas para pruebas dinámicas.                                                                       |
| @TestInstance      | Se usa para configurar el ciclo de vida de la instancia de prueba para las clases de prueba anotadas.                                               | 
| @TestTemplate      | El método de presentación es una plantilla diseñada para casos de prueba, y se realizan múltiples llamadas en función del número de contextos de llamada devueltos por el proveedor de registro. |
| @DisplayName       | Declare un nombre para mostrar personalizado para la clase de prueba o el método de prueba. | 
| @BeforeEach        | Representa un método que ejecuta una anotación antes de cada método @Test, @RepeatedTest, @ParameterizedTest o @TestFactory en la clase actual; similar a @Before en JUnit 4. |
| @AfterEach         | Indica que después de cada método @Test, @RepeatedTest, @ParameterizedTest o @TestFactory en la clase actual, se debe ejecutar un método anotado; similar a @After en JUnit 4. |
| @BeforeAll         | Indica que el método anotado debe ejecutarse antes de todos los métodos @Test, @RepeatedTest, @ParameterizedTest y @TestFactory en la clase actual; similar a @BeforeClass de JUnit 4. |
| @AfterAll          | Indica que en la clase actual, todos los métodos @Test, @RepeatedTest, @ParameterizedTest y @TestFactory deben ejecutar métodos anotados; similar a @AfterClass de JUnit 4. |
| @Nested            | Indica que la clase anotada es una clase de prueba anidada, no estática. Los métodos @BeforeAll y @AfterAll no se pueden usar directamente en la clase de prueba @Nested a menos que se use el ciclo de vida de la instancia de prueba "todas las clases". |
| @Tag               | Una etiqueta utilizada para declarar pruebas de filtro a nivel de clase o método; similar a los grupos de prueba en TestNG o categorías en JUnit 4. |
| @Disabled          | Se usa para deshabilitar las clases de prueba o los métodos de prueba; similar a @Ignore de JUnit 4. |
| @ExtendWith        | Se usa para registrar extensiones personalizadas. |

&nbsp;

## Changelog

##### Aqui podes encontrar el changelog.md con los distintos releases de la API.
### [CHANGELOG](CHANGELOG.md)

## Stack Tecnológico 🛠️

* Java 11 JDK
* Apache Maven 3.5.x en adelante
* [Junit](http://spockframework.org/) - Tests y Test de integración.

Metodología
* [Git Flow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow) - Colaboración y versionado

&nbsp;

## Entorno de Desarrollo 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._


### Pre-Requisitos 📋

_Que software necesitas tener instalado y como instalarlo_

```
Da un ejemplo
```

### Instalación 🔧

---
#### Base de datos en contenedor de Docker
Registrarse y loguearse en https://hub.docker.com/

Ejecutar por consola

    docker login
    
Ingresar los datos de login y ejecutar

    docker pull mcr.microsoft.com/mssql/server
    docker run --name sqlserver -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=Pa$$w0rd1" -p 1433:1433 -d mcr.microsoft.com/mssql/server:2017-latest
    // En linux se deben usar comillas simples

Conectarse a la DB del container recién creado

    docker exec -it sqlserver /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P'Pa$$w0rd1'
    // En linux se deben usar comillas simples
    
_Una vez conectado ejecutar las sentencias para crear las base de datos_

    CREATE DATABASE microservice_archetype
    GO
    CREATE DATABASE microservice_archetype_test
    GO

Para conectarse a la DB por medio de algún cliente, Los datos de conexión son:
* server: localhost
* user: sa
* password:  Pa$$w0rd1
* tipo de autenticación: SQL Server Authentication


##### Instalar Lombok en el IDE

_Esto depende del IDE(1) que utilices, seguir indicaciones de la web de [Project Lombok](https://projectlombok.org/)_

@Data .- Contiene las anotaciones de:
---> "@ToString", "@EqualsAndHashCode", "@Getter", "@Setter" y "@RequiredArgsConstructor"
(incluyendo el atributo "staticConstructor" para generar un método estático de fábrica).
Esta anotación es excelente para escribir POJOs.

##### Iniciar aplicación

    mvn bootRun


## Ejecutando las Pruebas ⚙️

_Explica como ejecutar las pruebas automatizadas para este sistema_

     
### Ejecutar tests para ver que esté todo en orden

    mvn verify
    
### Detalle de las Pruebas End-to-End 🔩

_Explica que verifican estas pruebas y por qué_

```
Da un ejemplo
```

&nbsp;

## Despliegue 📦

Este comando arma el yaml dentro de la carpeta resource del proyecto.

&nbsp;

## URLs del Proyecto  💻

[Desarrollo](http://localhost:8080/swagger-ui/index.html#/)

[Testing](http://localhost:8080/swagger-ui/index.html#/)

&nbsp;

## Diagrama de Arquitectura 🖇️

_Sección dedicada al Diagrama de Arquitectura de la Solución, dicho diagrama debe estar en este repositorio_

&nbsp;

## Wiki 📖

Puedes encontrar mucho más de cómo utilizar este proyecto en nuestra [Wiki]

* Test driven development TDD con junit

&nbsp;




## Problemas comunes 😣

---

* Maven no puede bajar las dependencias

  Verificar configuración de proxy: Ir a C:\Users\\{tuUsuario}\\.m2

* No puede iniciar la app en entorno local por problemas de permisos al escribir el archivo de log

  Definir una nueva variable de entorno con la ruta adecuada, ejemplo: export LOG_PATH=/tmp

* Error de certificado al intentar acceder a la url de personas

  Agregar el certificado provisto por la url definida en application.properties.

  Descargar el certificado de la página indicada en application.properties y luego agregar el certificado.
  Ejemplo:
    * En Linux, puede correr el siguiente comando por consola:
        sudo keytool -importcert -cacerts -file /mypath/apidesa.gscorp.ad.pem -alias ApiDesaCert

    * En Windows, puede correr el siguiente comando en la consola de windows (como administrador):
        your_java_home\jdk_x.xx\jre\bin\keytool -importcert -file "C:\mypath\apidesa.gscorp.ad.pem" -alias CertArtifactory -trustcacerts -keystore "C:\Program Files\Java\jdk-11.0.5\lib\security\cacerts"

## Tips Intellij  ![](https://github.githubassets.com/images/icons/emoji/electron.png?v8) <code><img height="20" src="https://github.githubassets.com/images/icons/emoji/electron.png?v8"></code>
* Insertar una nueva clase, paquete, test -> ALT + insert
* Crear un nuevo objeto CTRL + ALT + v
  
## Autores ✒
_Menciona a todos aquellos que ayudaron a levantar el proyecto desde sus inicios_

* **Jaime Alvaro Peredo Botello** - *Desarrollo* - [Jaime](https://github.ad/{UsuarioAD})

 

&nbsp;
