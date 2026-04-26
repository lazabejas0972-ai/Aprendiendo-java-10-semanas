#  Agenda de Contactos - Semana 05

## Descripción

Aplicación en Java que permite gestionar una agenda de contactos desde consola.
Incluye manejo de excepciones personalizadas y persistencia de datos en formato JSON.

---

## Funcionalidades

*  Agregar contacto
*  Listar contactos
*  Buscar contacto por ID
*  Editar contacto
*  Eliminar contacto
*  Mostrar estadísticas

---

##  Estructura del Proyecto

```
src/main/java/com/example/
│
├── modelo/
│   └── Contacto.java
│
├── servicio/
│   └── AgendaContactos.java
│
├── exception/
│   ├── ContactoExistenteException.java
│   ├── ContactoNoEncontradoException.java
│   └── DatoInvalidoException.java
│
├── util/
│   └── ManejadorJSON.java
│
└── Main.java
```

---

##  Persistencia

Los contactos se almacenan en:

```
data/contactos.json
```

Se genera automáticamente si no existe.

---

##  Cómo ejecutar

1. Abrir terminal en la carpeta del proyecto:

```
cd semana-05-agenda-contactos
```

2. Compilar:

```
mvn clean compile
```

3. Ejecutar:

```
mvn exec:java -Dexec.mainClass="com.example.Main"
```

---

## ⚠️ Validaciones

* ID y nombre no pueden estar vacíos
* Teléfono debe tener 7 u 8 dígitos
* Email debe contener `@`

---

##  Ejemplo de uso

```
--- Agenda de Contactos ---
1. Agregar contacto
2. Listar todos
3. Buscar contacto por ID
4. Editar contacto
5. Eliminar
6. Estadísticas
7. Salir
```

---

##  Programas utilizadas

* Java 17
* Maven
* Gson (para JSON)

---

##  Autor

Juan Carlos
