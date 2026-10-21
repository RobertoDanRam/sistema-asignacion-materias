# Sistema de Asignación de Materias JAVA (Actividad 5)

Este es un programa de consola desarrollado en Java para gestionar la asignación de clases académicas. El sistema administra profesores, salones y materias, implementando validaciones para evitar conflictos de asignación y asegurar la integridad de los datos de entrada.

## Características Principales

El sistema opera a través de un menú interactivo en consola con las siguientes funciones:

1. **Agregar un Profesor:** Registra nombre (validado mediante regex para contener exclusivamente caracteres alfabéticos), clave y edad.
2. **Agregar un Salón:** Registra el identificador del salón y el edificio correspondiente.
3. **Agregar una Materia:** Crea una nueva clase vinculando un profesor y un salón previamente registrados. Incluye las siguientes reglas de negocio:
   - El nombre de la materia debe tener más de 4 caracteres y no puede componerse únicamente de números.
   - Prevención de registro de materias duplicadas.
   - Verificación de disponibilidad del profesor (no permite asignar a un docente ocupado).
   - Verificación de disponibilidad del salón (evita empalme de clases en un mismo espacio).
4. **Mostrar materias registradas:** Despliega un listado de las clases activas con su respectivo profesor y salón asignados.

## Tecnologías Utilizadas

- **Lenguaje:** Java
- **Paradigmas:** Programación Orientada a Objetos (POO)
- **Estructuras de datos:** Colecciones `ArrayList` y `List`
- **Manejo de entrada:** `Scanner` y expresiones regulares para validación de formato de cadenas.

## Estructura del Código

El proyecto se compone de 4 clases que implementan principios básicos de encapsulamiento:

- `App.java`: Clase principal que contiene el método `main`, el ciclo del menú de usuario y la lógica de negocio para las validaciones.
- `Profesor.java`: Modelo de datos de los docentes.
- `Salon.java`: Modelo de datos de la infraestructura.
- `Materia.java`: Entidad que relaciona un objeto `Profesor` y un objeto `Salon` bajo un identificador único.

## Autor: Roberto Daniel Ramos Flores


