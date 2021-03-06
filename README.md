# Junit 5 proyecto inicial casos sencillos

JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage

Plataforma JUnit: es la base para lanzar el marco de prueba en la JVM.

JUnit Jupiter: es un nuevo modelo de programaci贸n y modelo de extensi贸n extendido por JUnit5, utilizado para escribir casos de prueba. El subproyecto J煤piter proporciona un TestEngine para ejecutar pruebas en J煤piter en la plataforma.

JUnit Vintage: proporciona un TestEngine que ejecuta JUnit 3 y JUnit 4 en la plataforma.

&nbsp;

# Dependecia Maven de Junit
Se debe recalcar que Junit5 corre en Java 1.8 para arriba. 
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.8.2</version>
        </dependency>




## Anotaciones 馃搫
| Anotaci贸n          | Explicaci贸n| 
|--------------------|--------------------------------------------| 
| @Test              | El m茅todo de presentaci贸n es un m茅todo de prueba. A diferencia de la anotaci贸n @Test de JUnit 4, esta anotaci贸n no declara ning煤n atributo, porque las extensiones de prueba en JUnit Jupiter funcionan en funci贸n de sus propias anotaciones dedicadas. |
| @ParameterizedTest | El m茅todo de representaci贸n es una prueba parametrizada. |
| @RepeatedTest      | El m茅todo de presentaci贸n es una plantilla de prueba para pruebas repetidas.                                                                        |
| @TestFactory       | El m茅todo de representaci贸n es una f谩brica de pruebas para pruebas din谩micas.                                                                       |
| @TestInstance      | Se usa para configurar el ciclo de vida de la instancia de prueba para las clases de prueba anotadas.                                               | 
| @TestTemplate      | El m茅todo de presentaci贸n es una plantilla dise帽ada para casos de prueba, y se realizan m煤ltiples llamadas en funci贸n del n煤mero de contextos de llamada devueltos por el proveedor de registro. |
| @DisplayName       | Declare un nombre para mostrar personalizado para la clase de prueba o el m茅todo de prueba. | 
| @BeforeEach        | Representa un m茅todo que ejecuta una anotaci贸n antes de cada m茅todo @Test, @RepeatedTest, @ParameterizedTest o @TestFactory en la clase actual; similar a @Before en JUnit 4. |
| @AfterEach         | Indica que despu茅s de cada m茅todo @Test, @RepeatedTest, @ParameterizedTest o @TestFactory en la clase actual, se debe ejecutar un m茅todo anotado; similar a @After en JUnit 4. |
| @BeforeAll         | Indica que el m茅todo anotado debe ejecutarse antes de todos los m茅todos @Test, @RepeatedTest, @ParameterizedTest y @TestFactory en la clase actual; similar a @BeforeClass de JUnit 4. |
| @AfterAll          | Indica que en la clase actual, todos los m茅todos @Test, @RepeatedTest, @ParameterizedTest y @TestFactory deben ejecutar m茅todos anotados; similar a @AfterClass de JUnit 4. |
| @Nested            | Indica que la clase anotada es una clase de prueba anidada, no est谩tica. Los m茅todos @BeforeAll y @AfterAll no se pueden usar directamente en la clase de prueba @Nested a menos que se use el ciclo de vida de la instancia de prueba "todas las clases". |
| @Tag               | Una etiqueta utilizada para declarar pruebas de filtro a nivel de clase o m茅todo; similar a los grupos de prueba en TestNG o categor铆as en JUnit 4. |
| @Disabled          | Se usa para deshabilitar las clases de prueba o los m茅todos de prueba; similar a @Ignore de JUnit 4. |
| @ExtendWith        | Se usa para registrar extensiones personalizadas. |

&nbsp;

## Changelog

##### Aqui podes encontrar el changelog.md con los distintos releases de la API.
### [CHANGELOG](CHANGELOG.md)

## Stack Tecnol贸gico 馃洜锔?

* Java 11 JDK
* Apache Maven 3.5.x en adelante
* [Junit](http://spockframework.org/) - Tests y Test de integraci贸n.

Metodolog铆a
* [Git Flow](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow) - Colaboraci贸n y versionado

&nbsp;

## Entorno de Desarrollo 馃殌

_Estas instrucciones te permitir谩n obtener una copia del proyecto en funcionamiento en tu m谩quina local para prop贸sitos de desarrollo y pruebas._


### Pre-Requisitos 馃搵

_Que software necesitas tener instalado y como instalarlo_

```
Da un ejemplo
```

### Instalaci贸n 馃敡

---
#### Base de datos en contenedor de Docker
Registrarse y loguearse en https://hub.docker.com/

Ejecutar por consola

    docker login
    
Ingresar los datos de login y ejecutar

    docker pull mcr.microsoft.com/mssql/server
    docker run --name sqlserver -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=Pa$$w0rd1" -p 1433:1433 -d mcr.microsoft.com/mssql/server:2017-latest
    // En linux se deben usar comillas simples

Conectarse a la DB del container reci茅n creado

    docker exec -it sqlserver /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P'Pa$$w0rd1'
    // En linux se deben usar comillas simples
    
_Una vez conectado ejecutar las sentencias para crear las base de datos_

    CREATE DATABASE microservice_archetype
    GO
    CREATE DATABASE microservice_archetype_test
    GO

Para conectarse a la DB por medio de alg煤n cliente, Los datos de conexi贸n son:
* server: localhost
* user: sa
* password:  Pa$$w0rd1
* tipo de autenticaci贸n: SQL Server Authentication


##### Instalar Lombok en el IDE

_Esto depende del IDE(1) que utilices, seguir indicaciones de la web de [Project Lombok](https://projectlombok.org/)_

@Data .- Contiene las anotaciones de:
---> "@ToString", "@EqualsAndHashCode", "@Getter", "@Setter" y "@RequiredArgsConstructor"
(incluyendo el atributo "staticConstructor" para generar un m茅todo est谩tico de f谩brica).
Esta anotaci贸n es excelente para escribir POJOs.

La anotaci贸n @Data de Lombok. Esta no solo agrega getters y setters, tambi茅n sobre escribe 
el m茅todo equals para comparar los objetos por sus atributos, no por referencia como s铆 se 
hace por defecto. Al agregar la anotaci贸n, se compara por atributo en lugar de por referencia.

##### Iniciar aplicaci贸n

    mvn bootRun


## Ejecutando las Pruebas 鈿欙笍

_Explica como ejecutar las pruebas automatizadas para este sistema_

     
### Ejecutar tests para ver que est茅 todo en orden

    mvn verify
    
### Detalle de las Pruebas End-to-End 馃敥

_Explica que verifican estas pruebas y por qu茅_

```
Da un ejemplo
```

&nbsp;

## Despliegue 馃摝

Este comando arma el yaml dentro de la carpeta resource del proyecto.

&nbsp;

## URLs del Proyecto  馃捇

[Desarrollo](http://localhost:8080/swagger-ui/index.html#/)

[Testing](http://localhost:8080/swagger-ui/index.html#/)

&nbsp;

## Diagrama de Arquitectura 馃枃锔?

_Secci贸n dedicada al Diagrama de Arquitectura de la Soluci贸n, dicho diagrama debe estar en este repositorio_

&nbsp;

## Wiki 馃摉

Puedes encontrar mucho m谩s de c贸mo utilizar este proyecto en nuestra [Wiki]

* Test driven development TDD con junit -> En resumen es primero realizar el c贸digo del Test y luego realizar la 
implementaci贸n del m茅todo o metodos que cumplan ese test
* 

&nbsp;




## Problemas comunes 馃槪

---

* Maven no puede bajar las dependencias

  Verificar configuraci贸n de proxy: Ir a C:\Users\\{tuUsuario}\\.m2

* No puede iniciar la app en entorno local por problemas de permisos al escribir el archivo de log

  Definir una nueva variable de entorno con la ruta adecuada, ejemplo: export LOG_PATH=/tmp

* Error de certificado al intentar acceder a la url de personas

  Agregar el certificado provisto por la url definida en application.properties.

  Descargar el certificado de la p谩gina indicada en application.properties y luego agregar el certificado.
  Ejemplo:
    * En Linux, puede correr el siguiente comando por consola:
        sudo keytool -importcert -cacerts -file /mypath/apidesa.gscorp.ad.pem -alias ApiDesaCert

    * En Windows, puede correr el siguiente comando en la consola de windows (como administrador):
        your_java_home\jdk_x.xx\jre\bin\keytool -importcert -file "C:\mypath\apidesa.gscorp.ad.pem" -alias CertArtifactory -trustcacerts -keystore "C:\Program Files\Java\jdk-11.0.5\lib\security\cacerts"

## Tips Intellij  ![](https://github.githubassets.com/images/icons/emoji/electron.png?v8) <code><img height="20" src="https://github.githubassets.com/images/icons/emoji/electron.png?v8"></code>
* Insertar una nueva clase, paquete, test -> ALT + insert
* Crear un nuevo objeto CTRL + ALT + v
*  Replicar una linea CTRL + d
  
## Autores 鉁?
_Menciona a todos aquellos que ayudaron a levantar el proyecto desde sus inicios_

* **Jaime Alvaro Peredo Botello** - *Desarrollo* - [Jaime](https://github.ad/{UsuarioAD})

 

&nbsp;
