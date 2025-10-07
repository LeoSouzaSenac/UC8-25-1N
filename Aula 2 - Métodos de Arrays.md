# Métodos mais importantes de Arrays em Java

Em Java, **arrays** são estruturas que armazenam múltiplos valores do mesmo tipo. Para trabalhar com arrays de forma mais fácil, usamos a classe `Arrays` do pacote `java.util`, que oferece diversos métodos prontos.

A seguir, explicamos os métodos mais importantes de forma simples, com exemplos, parâmetros, retornos e utilidade.

---

## 1. `Arrays.sort(array)`

**Para que serve:**  
Ordena os elementos de um array em **ordem crescente**.

**Parâmetros:**  
- `array`: o array que você quer ordenar.

**Retorno:**  
- Não retorna nada (`void`), apenas altera o array original.

**Exemplo:**
```java
import java.util.Arrays;

int[] numeros = {5, 2, 8, 1};
Arrays.sort(numeros);
System.out.println(Arrays.toString(numeros)); // [1, 2, 5, 8]
````

---

## 2. `Arrays.toString(array)`

**Para que serve:**
Converte um array em **uma string legível**, útil para imprimir no console.

**Parâmetros:**

* `array`: o array que você quer converter.

**Retorno:**

* Uma `String` mostrando os elementos do array.

**Exemplo:**

```java
int[] numeros = {1, 2, 3};
String texto = Arrays.toString(numeros);
System.out.println(texto); // [1, 2, 3]
```

---

## 3. `Arrays.binarySearch(array, valor)`

**Para que serve:**
Procura um elemento em um array **ordenado** e retorna seu índice.

**Parâmetros:**

* `array`: array **ordenado**.
* `valor`: valor que você quer procurar.

**Retorno:**

* Índice do elemento se encontrado.
* Um número negativo se o elemento não estiver no array.

**Exemplo:**

```java
int[] numeros = {1, 3, 5, 7};
int pos = Arrays.binarySearch(numeros, 5);
System.out.println(pos); // 2 (posição do elemento 5)
```

**Obs:** Sempre ordene o array antes de usar `binarySearch`.

---

## 4. `Arrays.equals(array1, array2)`

**Para que serve:**
Verifica se dois arrays têm **os mesmos elementos na mesma ordem**.

**Parâmetros:**

* `array1` e `array2`: os arrays que serão comparados.

**Retorno:**

* `true` se forem iguais.
* `false` se forem diferentes.

**Exemplo:**

```java
int[] a = {1, 2, 3};
int[] b = {1, 2, 3};
boolean iguais = Arrays.equals(a, b);
System.out.println(iguais); // true
```

---

## 5. `Arrays.fill(array, valor)`

**Para que serve:**
Preenche todos os elementos do array com um **mesmo valor**.

**Parâmetros:**

* `array`: array a ser preenchido.
* `valor`: valor que será colocado em todas as posições.

**Retorno:**

* Não retorna nada (`void`), apenas modifica o array.

**Exemplo:**

```java
int[] numeros = new int[5];
Arrays.fill(numeros, 9);
System.out.println(Arrays.toString(numeros)); // [9, 9, 9, 9, 9]
```

---

## 6. `Arrays.copyOf(array, tamanho)`

**Para que serve:**
Cria uma **cópia de um array**.

**Parâmetros:**

* `array`: array original.
* `tamanho`: tamanho do novo array (pode ser menor ou maior que o original).

**Retorno:**

* Um novo array com os elementos copiados.

**Exemplo:**

```java
int[] original = {1, 2, 3};
int[] copia = Arrays.copyOf(original, original.length);
System.out.println(Arrays.toString(copia)); // [1, 2, 3]
```

---

## 7. `Arrays.copyOfRange(array, inicio, fim)`

**Para que serve:**
Cria uma cópia **parcial** de um array, de uma posição inicial até uma posição final (exclusiva).

**Parâmetros:**

* `array`: array original.
* `inicio`: índice inicial (inclusive).
* `fim`: índice final (exclusive).

**Retorno:**

* Um novo array com os elementos do intervalo definido.

**Exemplo:**

```java
int[] original = {10, 20, 30, 40, 50};
int[] parte = Arrays.copyOfRange(original, 1, 4);
System.out.println(Arrays.toString(parte)); // [20, 30, 40]
```

---

## 8. `Arrays.stream(array)`

**Para que serve:**
Permite criar um **stream** para aplicar operações como `sum`, `average`, `filter`, etc.

**Parâmetros:**

* `array`: array de números ou objetos.

**Retorno:**

* Um `IntStream`, `DoubleStream` ou `Stream` dependendo do tipo do array.

**Exemplo:**

```java
import java.util.Arrays;

int[] numeros = {1, 2, 3, 4};
int soma = Arrays.stream(numeros).sum();
System.out.println(soma); // 10
```

---

## **Resumo dos métodos**

| Método                                   | Para que serve              | Retorno            |
| ---------------------------------------- | --------------------------- | ------------------ |
| `Arrays.sort(array)`                     | Ordena o array              | `void`             |
| `Arrays.toString(array)`                 | Converte em string          | `String`           |
| `Arrays.binarySearch(array, valor)`      | Procura elemento            | índice ou negativo |
| `Arrays.equals(a, b)`                    | Compara arrays              | `boolean`          |
| `Arrays.fill(array, valor)`              | Preenche com um valor       | `void`             |
| `Arrays.copyOf(array, tamanho)`          | Copia array                 | novo array         |
| `Arrays.copyOfRange(array, inicio, fim)` | Copia parte do array        | novo array         |
| `Arrays.stream(array)`                   | Permite operações de stream | Stream             |

---

