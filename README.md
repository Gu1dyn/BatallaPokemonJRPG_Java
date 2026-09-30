# 🐉 MonsterHatch

## 📖 Descripción

**MonsterHatch** es un proyecto desarrollado en **Java** que simula una pelea entre diferentes Pokémon mediante el uso de conceptos de **Programación Orientada a Objetos (POO)** y el patrón de diseño **Strategy**.

El proyecto permite crear Pokémon con diferentes características y asignarles distintos comportamientos de combate. De esta manera, cada Pokémon puede realizar acciones diferentes dependiendo de la estrategia que tenga asignada.

Actualmente, el proyecto incluye comportamientos **agresivos, defensivos y mágicos**, permitiendo representar diferentes estilos de combate.

---

## 🎯 Objetivo del proyecto

El objetivo principal es desarrollar una simulación sencilla de una batalla entre Pokémon, aplicando conceptos de programación orientada a objetos como:

* Encapsulamiento.
* Herencia.
* Polimorfismo.
* Interfaces.
* Composición.
* Patrón de diseño **Strategy**.
* Manejo de atributos y métodos.
* Interacción entre diferentes objetos.

---

## ⚔️ Funcionamiento

Cada Pokémon cuenta con características básicas que determinan su estado durante la batalla:

* **Nombre**
* **Vida**
* **Ataque**
* **Defensa**
* **Esquiva**
* **Estrategia de combate**

La estrategia determina la forma en que el Pokémon ejecutará su acción durante el combate.

Por ejemplo, un Pokémon puede utilizar un comportamiento agresivo para atacar, uno defensivo para aumentar su defensa o uno mágico para realizar ataques utilizando maná.

---

## 🧩 Estructura del proyecto

El proyecto está organizado de la siguiente manera:

```text
MonsterHatch/
│
├── src/
│   ├── App.java
│   ├── Pokemon.java
│   ├── CategoriaMagica.java
│   ├── EstrategiaBatalla.java
│   ├── ComportamientoAgresivo.java
│   ├── ComportamientoDefensivo.java
│   └── ComportamientoMagico.java
│
├── bin/
│   └── Archivos compilados .class
│
├── lib/
│
├── .vscode/
│   └── settings.json
│
└── README.md
```

---

## 🏗️ Clases principales

### 🐲 `Pokemon`

Es la clase principal que representa a un Pokémon.

Contiene atributos como:

```java
private final String nombre;
private int vida;
private final int ataque;
private int defensa;
private boolean esquivaActiva;
private EstrategiaBatalla estrategia;
```

Entre sus principales métodos se encuentran:

* `ejecutarAccion(Pokemon enemigo)`: ejecuta la estrategia de combate asignada.
* `setEstrategia(...)`: permite cambiar la estrategia de combate.
* `reducirVida(int daño)`: disminuye la vida del Pokémon teniendo en cuenta su defensa y esquiva.
* `aumentarDefensa(int cantidad)`: incrementa la defensa.
* `activarEsquiva()`: activa la posibilidad de esquivar el siguiente daño.
* `getNombre()`: obtiene el nombre del Pokémon.
* `getAtaque()`: obtiene el valor de ataque.
* `getVida()`: obtiene la vida actual.

---

### ⚡ `EstrategiaBatalla`

Es una interfaz que define el comportamiento que deben implementar las diferentes estrategias de combate.

La idea principal es que `Pokemon` no necesita conocer directamente cómo se realiza cada acción. Simplemente utiliza la estrategia que tenga asignada.

Conceptualmente:

```text
EstrategiaBatalla
       │
       ├── ComportamientoAgresivo
       │
       ├── ComportamientoDefensivo
       │
       └── ComportamientoMagico
```

Esto permite agregar nuevas estrategias de combate sin tener que modificar directamente la clase `Pokemon`.

---

### 🔥 `ComportamientoAgresivo`

Representa un estilo de combate ofensivo.

Su función principal es realizar ataques contra el Pokémon enemigo utilizando el atributo de ataque.

---

### 🛡️ `ComportamientoDefensivo`

Representa un estilo de combate enfocado en la defensa.

Puede utilizar las funcionalidades disponibles en `Pokemon`, como aumentar la defensa o activar la esquiva.

---

### ✨ `ComportamientoMagico`

Representa un comportamiento basado en ataques mágicos.

Utiliza características relacionadas con el **maná**, como:

* Costo de maná.
* Poder mágico.
* Regeneración de maná.

De esta manera, un Pokémon con este comportamiento puede realizar acciones especiales que dependen de la cantidad de maná disponible.

---

### 🔮 `CategoriaMagica`

Es una clase que extiende de `Pokemon` y agrega características propias de los Pokémon de categoría mágica.

Entre sus atributos se encuentra el maná, incluyendo:

```java
mana
manaMaximo
```

Esto permite que los Pokémon mágicos tengan un recurso adicional que pueden utilizar durante el combate.

---

## 🎮 Simulación

La simulación principal se encuentra en:

```text
App.java
```

En esta clase se crean los Pokémon que participarán en la batalla.

Por ejemplo, actualmente se crean dos Pokémon:

```java
Pokemon Frieren = new CategoriaMagica(
    "Frieren",
    50,
    30,
    8,
    new ComportamientoMagico(30, 20),
    300
);

Pokemon Aura = new CategoriaMagica(
    "Aura",
    50,
    10,
    4,
    new ComportamientoMagico(20, 10),
    100
);
```

Después comienza la simulación:

```java
Frieren.ejecutarAccion(Aura);
Aura.ejecutarAccion(Frieren);
```

Cada Pokémon ejecuta la estrategia que tiene asignada, permitiendo observar cómo interactúan sus diferentes comportamientos.

---

## 🔄 Patrón Strategy

Uno de los conceptos principales utilizados en el proyecto es el patrón de diseño **Strategy**.

La estructura puede representarse de la siguiente forma:

```text
                    ┌─────────────────────┐
                    │  EstrategiaBatalla  │
                    └──────────┬──────────┘
                               │
             ┌─────────────────┼─────────────────┐
             │                 │                 │
             ▼                 ▼                 ▼
     ┌───────────────┐ ┌───────────────┐ ┌───────────────┐
     │ Comportamiento│ │ Comportamiento│ │ Comportamiento│
     │   Agresivo    │ │   Defensivo   │ │    Mágico     │
     └───────────────┘ └───────────────┘ └───────────────┘
                              
                               ▲
                               │
                       ┌───────┴───────┐
                       │    Pokemon    │
                       └───────────────┘
```

La ventaja de este patrón es que el comportamiento de un Pokémon puede cambiar sin necesidad de modificar la clase principal.

Por ejemplo:

```java
pokemon.setEstrategia(nuevaEstrategia);
```

Esto permite que el mismo Pokémon pueda utilizar diferentes estrategias durante la ejecución del programa.

---

## ❤️ Sistema de daño

Cuando un Pokémon recibe un ataque, el método `reducirVida()` calcula el daño real teniendo en cuenta la defensa:

```java
int dañoReal = Math.max(daño - defensa, 0);
```

Esto significa que la defensa reduce el daño recibido, pero el daño nunca será menor que `0`.

Además, si el Pokémon tiene activa la esquiva, puede evitar completamente el daño recibido.

---

## 🛠️ Tecnologías utilizadas

* **Java**
* **Programación Orientada a Objetos**
* **Patrón de diseño Strategy**
* **Visual Studio Code**
* **Git / GitHub** *(si el proyecto está alojado en un repositorio)*

---

## ▶️ Cómo ejecutar el proyecto

### 1. Clonar el repositorio

```bash
git clone URL_DEL_REPOSITORIO
```

### 2. Abrir el proyecto

Abrir la carpeta `MonsterHatch` utilizando Visual Studio Code o cualquier IDE compatible con Java.

### 3. Verificar Java

Se recomienda tener instalado el **JDK** para poder compilar y ejecutar el proyecto.

Puedes comprobar la instalación mediante:

```bash
java --version
```

### 4. Ejecutar el programa

Ejecutar la clase:

```text
App.java
```

El programa iniciará la simulación de la batalla y mostrará en consola las acciones realizadas por los Pokémon.

---

## 📌 Ejemplo de ejecución

Al iniciar el programa se muestra un mensaje indicando el comienzo de la simulación:

```text
===== INICIO DE LA SIMULACIÓN =====

Inicio de la batalla entre Frieren y Aura
```

Posteriormente se ejecutan las acciones de combate de ambos Pokémon y finalmente se muestra:

```text
===== FIN DE LA SIMULACIÓN =====
```

---

## 📚 Conceptos de POO aplicados

| Concepto        | Aplicación                                                  |
| --------------- | ----------------------------------------------------------- |
| Encapsulamiento | Los atributos de las clases son privados.                   |
| Herencia        | `CategoriaMagica` extiende de `Pokemon`.                    |
| Polimorfismo    | Las diferentes estrategias implementan `EstrategiaBatalla`. |
| Abstracción     | `EstrategiaBatalla` define el comportamiento de combate.    |
| Composición     | `Pokemon` contiene una estrategia de combate.               |
| Strategy        | Permite cambiar el comportamiento de combate de un Pokémon. |

---

## 👨‍💻 Autor

Johan David Guillen Becerra
