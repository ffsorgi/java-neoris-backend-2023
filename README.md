# 📦 **Proyecto Turnos Rotativos**

Este proyecto es una aplicación desarrollada en **Java 11** con **Spring Boot** que gestiona los turnos rotativos de empleados, así como la información relacionada con conceptos y empleados. Utiliza una **arquitectura en capas** para organizar las responsabilidades del sistema.

## 🌟 **Descripción del Proyecto**

El sistema está diseñado para gestionar la asignación de turnos a los empleados y las interacciones con los conceptos, permitiendo una administración eficiente. A través de las siguientes funcionalidades, el sistema permite:

1. **Añadir empleados**: Permite registrar nuevos empleados en el sistema.
2. **Obtener empleados**: Muestra una lista de empleados registrados.
3. **Obtener conceptos**: Permite visualizar los conceptos disponibles en el sistema.
4. **Eliminar empleados**: Permite eliminar empleados por su ID.

## 🛠️ **Patrones de Diseño Utilizados**

### 🔥 **Arquitectura en Capas (Layered Architecture)**

Este proyecto sigue el patrón de **Arquitectura en Capas**, donde cada capa tiene una responsabilidad clara y se encarga de una parte específica de la aplicación. La arquitectura se divide principalmente en:

1. **Controladores (Controllers)**: Gestionan las peticiones HTTP y delegan la lógica de negocio a los servicios correspondientes. Están encargados de recibir las solicitudes de los usuarios y retornar las respuestas adecuadas.
2. **Servicios (Services)**: Contienen la lógica de negocio principal. Los servicios interactúan con los repositorios y realizan las operaciones necesarias sobre las entidades y DTOs.
3. **Repositorios (Repositories)**: Gestionan la persistencia de datos y proporcionan acceso a las entidades a través de la base de datos.
4. **DTOs (Data Transfer Objects)**: Representan los datos que se transfieren entre las capas, normalmente entre el controlador y el servicio. Ayudan a desacoplar las entidades del dominio de las interfaces externas.
5. **Entidades (Entities)**: Representan los objetos del dominio que se mapean a las tablas de la base de datos.
6. **Wrappers (Wrappers)**: Proveen una capa de abstracción adicional entre los controladores y servicios, simplificando la interacción entre capas y permitiendo un acceso más limpio a las entidades o datos. Los wrappers ayudan a manejar complejidades o integraciones externas de forma transparente.

Esta estructura permite una clara separación de responsabilidades y facilita el mantenimiento y la escalabilidad del sistema.

## 📁 **Estructura del Proyecto**

La estructura del proyecto es la siguiente:

**src**
└── **main**
├── **java**
│ └── **com**
│ └── **neoris**
│ └── **turnosrotativos**
│ ├── **annotations**
│ │ ├── **employee**
│ │ │ ├── Adult.java
│ │ │ ├── AdultValidator.java
│ │ │ ├── DocumentNumberAlreadyExists.java
│ │ │ ├── DocumentNumberAlreadyExistsValidator.java
│ │ │ ├── EmailAlreadyExists.java
│ │ │ ├── EmailAlreadyExistsValidator.java
│ │ │ ├── NotFutureDate.java
│ │ │ ├── NotFutureDateValidator.java
│ │ │ ├── ValidEmail.java
│ │ │ ├── ValidEmailValidator.java
│ │ │ ├── ValidFullName.java
│ │ │ └── ValidFullNameValidator.java
│ ├── **controllers**
│ │ ├── ConceptController.java
│ │ └── EmployeeController.java
│ ├── **dto**
│ │ └── EmployeeDTO.java
│ ├── **entities**
│ │ ├── Concepto.java
│ │ └── Employee.java
│ ├── **exceptions**
│ │ ├── BadRequestException.java
│ │ ├── ConflictException.java
│ │ ├── CustomExceptionHandler.java
│ │ ├── ErrorServerException.java
│ │ └── NotFoundException.java
│ ├── **mapper**
│ │ ├── EmployeeDTOToEmployee.java
│ │ └── IMapper.java
│ ├── **repository**
│ │ ├── ConceptRepository.java
│ │ └── EmployeeRepository.java
│ ├── **services**
│ │ ├── ConceptService.java
│ │ ├── ConceptServiceImplement.java
│ │ ├── EmployeeService.java
│ │ └── EmployeeServiceImplement.java
│ └── **utils**
│ └── GenerateOptionals.java
├── **resources**
│ │ ├── static
│ │ ├── templates
│ │ ├── aplication.properties
│ │ └── data.sql
├── .gitignore
├── HELP.md
├── jshell.history
├── mvnw
├── mvnw.cmd
├── nb-configuration.xml
├── pom.xml
└── README.md


### 📂 **Descripción de las Carpetas**

- **src**: Código fuente del proyecto.
    - **controllers**: Contiene los controladores que manejan las peticiones HTTP.
    - **dto**: Contiene los Data Transfer Objects utilizados para la comunicación entre las capas.
    - **entities**: Contiene las entidades que representan las tablas de la base de datos.
    - **exceptions**: Contiene las excepciones personalizadas para manejar errores en el sistema.
    - **mapper**: Contiene los mappers que convierten entre DTOs y entidades.
    - **repository**: Contiene los repositorios para acceder a la base de datos.
    - **services**: Contiene los servicios con la lógica de negocio.
    - **wrappers**: Contiene las clases de **wrapper**, que abstraen la interacción entre los controladores y servicios.
    - **utils**: Contiene clases de utilidad.
- **resources**: Archivos de configuración y recursos estáticos.
    - **application.properties**: Archivo de configuración de la aplicación.
    - **data.sql**: Script de inicialización de la base de datos.

## ⚙️ **Casos de Uso Implementados**

### 🧑‍💼 **Caso de uso #1: Añadir empleado**

- **Endpoint**: `[POST] /employees`
- **Descripción**: Añade un nuevo empleado al sistema.

### 👥 **Caso de uso #2: Obtener empleados**

- **Endpoint**: `[GET] /employees`
- **Descripción**: Obtiene una lista de todos los empleados registrados.

### 🔍 **Caso de uso #3: Obtener empleado por ID**

- **Endpoint**: `[GET] /employees/{id}`
- **Descripción**: Obtiene un empleado específico por su ID.

### 💼 **Caso de uso #4: Obtener conceptos**

- **Endpoint**: `[GET] /concepts`
- **Descripción**: Obtiene una lista de todos los conceptos registrados en el sistema.

### 🗑️ **Caso de uso #5: Eliminar empleado por ID**

- **Endpoint**: `[DELETE] /employees/{id}`
- **Descripción**: Elimina un empleado específico por su ID.

## 📍 **Requisitos**

- **Java 11** o superior.
- **Spring Boot**.
- **Maven** (para gestionar dependencias).
- **Base de datos** (configurada en `application.properties`).

## 🌐 **Documentación de la API**

Para más detalles sobre los endpoints y su funcionamiento, puedes consultar la [Documentación de la API](https://neorislab.stoplight.io/docs/api-turnos-rotativos/branches/main/nrowuxrl9uwnd-turnos-rotativos).

## ⚠️ **Excepciones Personalizadas**

El proyecto incluye validaciones personalizadas que se encuentran en la capa de **annotations**, las cuales son usadas en la capa de **DTO**. Estas excepciones son:

- **Adult**: Valida la edad de un empleado basándose en su fecha de nacimiento.
- **DocumentNumberAlreadyExists**: Verifica si el número de documento del empleado ya existe en la base de datos.
- **EmailAlreadyExists**: Verifica si el email del empleado ya existe en la base de datos.
- **NotFutureDate**: Valida que una fecha no sea en el futuro.
- **ValidEmail**: Verifica si un email es válido usando una expresión regular.
- **ValidFullName**: Verifica si el nombre completo solo contiene letras.

Estas validaciones son utilizadas para garantizar que los datos ingresados sean correctos y consistentes.

---

