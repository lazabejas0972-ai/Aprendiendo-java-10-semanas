DESCRIPCION DEL PROYECTO 
Este proyecto es un sistema en Java para gestionar estudiantes mediante su carnet, permitiendo registrarlos, buscarlos, actualizarlos y eliminarlos. Además, organiza automáticamente un ranking según el promedio académico y ofrece funciones como filtrado por carrera, estadísticas generales y un historial de operaciones. Utiliza estructuras como HashMap, TreeSet y ArrayList para optimizar el rendimiento y la organización de los datos.


TABLA COMPARATIVA DE LOS 3 MODELOS
| Colección                     | ¿Por qué se eligió?                                | Problema que resuelve                                  | Rol en el sistema                           |
| ----------------------------- | -------------------------------------------------- | ------------------------------------------------------ | ------------------------------------------- |
| `ArrayList<String>`           | Mantiene el orden de inserción y es simple de usar | Permite registrar eventos en el orden en que ocurren   | Historial de operaciones (orden de llegada) |
| `HashMap<String, Estudiante>` | Acceso rápido por clave en tiempo O(1)             | Evita recorrer toda la lista para buscar un estudiante | Búsqueda directa por carnet                 |
| `TreeSet<Estudiante>`         | Ordena automáticamente los elementos               | Evita tener que ordenar manualmente cada vez           | Ranking automático por promedio             |

COMO COMPUILAR Y EJECUTAR EL PROYECTO
-  javac -d . modelo/Estudiante.java servicio/GestorEstudiantes.java Main.java
-  java Main.java

EJEMPLO DE SALIDA PROYECTO
=== GESTOR DE ESTUDIANTES ===
1. Agregar estudiante
2. Buscar estudiante por carnet
3. Actualizar promedio
4. Eliminar estudiante
5. Mostrar ranking completo
6. Mostrar top 5 estudiantes
7. Filtrar por carrera
8. Estadisticas
9. Historial
0. Salir
Seleccione una opción: 5

=== RANKING DE ESTUDIANTES ===
  1. [20210002] Luis Pérez          Derecho         78.0
  2. [20210005] Sofía Martínez      Psicología      80.2
  3. [20210001] Ana Gómez           Ingeniería      85.5
  4. [20210004] Carlos Sánchez      Arquitectura    88.7
  5. [20210003] María Rodríguez     Medicina        92.3