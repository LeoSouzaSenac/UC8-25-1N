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

Perfeito, Leonardo. 👏
Abaixo está o **guia completo e detalhado** sobre os **métodos mais importantes da classe `Arrays` e das Streams em Java**, com **explicações simples, parâmetros, retornos, exemplos comentados e observações conceituais**.
O texto está em formato Markdown (`.md`), pronto para usar em sala, postar no GitHub ou converter em PDF.

---

# 📘 Métodos mais importantes de Arrays e Streams em Java

Em Java, **arrays** são estruturas que armazenam múltiplos valores do mesmo tipo (como `int`, `String`, `double` etc.).
A classe **`java.util.Arrays`** oferece diversos métodos prontos para manipular arrays de forma eficiente.

Além disso, com **`Arrays.stream()`**, podemos transformar um array em um **Stream**, o que permite usar métodos modernos para filtrar, transformar e processar dados de forma funcional.

---

## 🟦 PARTE 1 — Métodos da Classe `Arrays`

---

### 🔹 1. `Arrays.sort(array)`

**Para que serve:**
Ordena os elementos de um array em **ordem crescente**.

**Como funciona:**
O método usa o **algoritmo Quicksort** (ou Timsort, dependendo do tipo de array) para reorganizar os elementos do menor para o maior.

**Parâmetros:**

* `array`: o array que será ordenado (deve conter elementos comparáveis).

**Retorno:**

* Não retorna nada (`void`).
* O array original é modificado diretamente.

**Exemplo:**

```java
import java.util.Arrays;

int[] numeros = {5, 2, 8, 1};
Arrays.sort(numeros);
System.out.println(Arrays.toString(numeros)); // [1, 2, 5, 8]
```

---

### 🔹 2. `Arrays.toString(array)`

**Para que serve:**
Converte um array em **uma string legível**, ideal para imprimir no console.

**Como funciona:**
Percorre todos os elementos do array e os concatena em uma string formatada entre colchetes.

**Parâmetros:**

* `array`: o array a ser convertido.

**Retorno:**

* Uma `String` representando o array.

**Exemplo:**

```java
int[] numeros = {1, 2, 3};
System.out.println(Arrays.toString(numeros)); // [1, 2, 3]
```

---

### 🔹 3. `Arrays.binarySearch(array, valor)`

**Para que serve:**
Procura um elemento dentro de um array **ordenado** e retorna o índice onde ele está.

**Como funciona:**
Usa o **algoritmo de busca binária**, que divide o array ao meio repetidamente até encontrar o valor.

**Parâmetros:**

* `array`: deve estar previamente **ordenado**.
* `valor`: o elemento que você quer encontrar.

**Retorno:**

* O índice do elemento, se encontrado.
* Um número **negativo** se o elemento não existir no array.

**Exemplo:**

```java
int[] numeros = {1, 3, 5, 7, 9};
int pos = Arrays.binarySearch(numeros, 5);
System.out.println(pos); // 2
```

🟠 **Dica:** Sempre chame `Arrays.sort()` antes de usar `binarySearch`.

---

### 🔹 4. `Arrays.equals(array1, array2)`

**Para que serve:**
Compara se **dois arrays têm os mesmos elementos na mesma ordem**.

**Parâmetros:**

* `array1`, `array2`: arrays que serão comparados.

**Retorno:**

* `true` → se os arrays forem iguais.
* `false` → se tiverem tamanhos ou elementos diferentes.

**Exemplo:**

```java
int[] a = {1, 2, 3};
int[] b = {1, 2, 3};
System.out.println(Arrays.equals(a, b)); // true
```

---

### 🔹 5. `Arrays.fill(array, valor)`

**Para que serve:**
Preenche todo o array com um **mesmo valor**.

**Como funciona:**
Substitui o valor de cada posição do array por um valor fixo.

**Parâmetros:**

* `array`: o array que será preenchido.
* `valor`: o valor que será colocado em todas as posições.

**Retorno:**

* Não retorna nada (`void`).

**Exemplo:**

```java
int[] numeros = new int[5];
Arrays.fill(numeros, 9);
System.out.println(Arrays.toString(numeros)); // [9, 9, 9, 9, 9]
```

---

### 🔹 6. `Arrays.copyOf(array, tamanho)`

**Para que serve:**
Cria uma **cópia do array original** com um novo tamanho.

**Parâmetros:**

* `array`: o array original.
* `tamanho`: o novo tamanho do array (pode ser maior ou menor).

**Retorno:**

* Um novo array com os elementos copiados.

**Exemplo:**

```java
int[] original = {1, 2, 3};
int[] copia = Arrays.copyOf(original, 5);
System.out.println(Arrays.toString(copia)); // [1, 2, 3, 0, 0]
```

---

### 🔹 7. `Arrays.copyOfRange(array, inicio, fim)`

**Para que serve:**
Cria uma cópia **parcial** de um array, de uma posição inicial até uma final (exclusiva).

**Parâmetros:**

* `array`: o array original.
* `inicio`: índice inicial (inclusivo).
* `fim`: índice final (exclusivo).

**Retorno:**

* Um novo array com o trecho selecionado.

**Exemplo:**

```java
int[] numeros = {10, 20, 30, 40, 50};
int[] parte = Arrays.copyOfRange(numeros, 1, 4);
System.out.println(Arrays.toString(parte)); // [20, 30, 40]
```

---

### 🔹 8. `Arrays.stream(array)`

**Para que serve:**
Transforma o array em uma **Stream**, permitindo o uso de métodos modernos como `filter()`, `map()`, `sum()`, `average()`, etc.

**Parâmetros:**

* `array`: um array numérico ou de objetos.

**Retorno:**

* Um `IntStream`, `DoubleStream` ou `Stream`.

**Exemplo:**

```java
int[] numeros = {1, 2, 3, 4};
int soma = Arrays.stream(numeros).sum();
System.out.println(soma); // 10
```

---


### 🔹 1. `.filter()`

**Para que serve:**
Seleciona apenas os elementos que **satisfazem uma condição**.

**Parâmetros:**

* Uma expressão que retorna `true` ou `false`.

**Retorno:**

* Uma nova `Stream` apenas com os elementos filtrados.

**Exemplo:**

```java
int[] numeros = {1, 2, 3, 4, 5};
Arrays.stream(numeros)
      .filter(n -> n % 2 == 0)
      .forEach(System.out.println); // 2, 4
```

---

### 🔹 2. `.map()`

**Para que serve:**
Transforma cada elemento da Stream em outro valor.

**Exemplo:**

```java
Arrays.stream(new int[]{1, 2, 3})
      .map(n -> n * n)
      .forEach(System.out::println); // 1, 4, 9
```

---

### 🔹 3. `.forEach()`

**Para que serve:**
Executa uma ação para cada elemento (geralmente imprimir ou processar).

**Exemplo:**

```java
Arrays.stream(new int[]{10, 20, 30})
      .forEach(System.out::println);
```

---

### 🔹 4. `.reduce()`

**Para que serve:**
Combina todos os elementos em **um único resultado** (soma, multiplicação, etc.).

**Exemplo:**

```java
int soma = Arrays.stream(new int[]{1, 2, 3, 4})
                 .reduce(0, (a, b) -> a + b);
System.out.println(soma); // 10
```

---

### 🔹 5. `.collect()`

**Para que serve:**
Coleta os elementos da Stream em uma **coleção** (`List`, `Set`, etc.).

**Exemplo:**

```java
import java.util.*;
import java.util.stream.Collectors;

List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5);
List<Integer> pares = lista.stream()
                           .filter(n -> n % 2 == 0)
                           .collect(Collectors.toList());
System.out.println(pares); // [2, 4]
```

---

### 🔹 6. `.sorted()`

**Para que serve:**
Ordena os elementos da Stream.

**Exemplo:**

```java
List<Integer> lista = Arrays.asList(5, 3, 8, 1);
lista.stream()
     .sorted()
     .forEach(System.out::println); // 1, 3, 5, 8
```

---

### 🔹 7. `.distinct()`

**Para que serve:**
Remove elementos duplicados.

**Exemplo:**

```java
List<Integer> numeros = Arrays.asList(1, 2, 2, 3, 3, 3);
numeros.stream()
       .distinct()
       .forEach(System.out::println); // 1, 2, 3
```

---

### 🔹 8. `.count()`

**Para que serve:**
Conta quantos elementos existem na Stream.

**Exemplo:**

```java
long qtd = Arrays.stream(new int[]{1, 2, 3, 4, 5}).count();
System.out.println(qtd); // 5
```

---

### 🔹 9. `.anyMatch()`, `.allMatch()`, `.noneMatch()`

**Para que servem:**
Verificam se algum, todos ou nenhum elemento satisfaz uma condição.

**Exemplo:**

```java
int[] numeros = {1, 2, 3, 4, 5};

System.out.println(Arrays.stream(numeros).anyMatch(n -> n > 4)); // true
System.out.println(Arrays.stream(numeros).allMatch(n -> n > 0)); // true
System.out.println(Arrays.stream(numeros).noneMatch(n -> n < 0)); // true
```

---

### 🔹 10. `.findFirst()` e `.findAny()`

**Para que servem:**
Retornam o primeiro (ou qualquer) elemento da Stream.

**Exemplo:**

```java
OptionalInt primeiro = Arrays.stream(new int[]{10, 20, 30}).findFirst();
System.out.println(primeiro.getAsInt()); // 10
```

---

### 🔹 11. `.max()` e `.min()`

**Para que servem:**
Encontram o maior e o menor elemento da Stream.

**Exemplo:**

```java
int maximo = Arrays.stream(new int[]{5, 9, 3}).max().getAsInt();
int minimo = Arrays.stream(new int[]{5, 9, 3}).min().getAsInt();
System.out.println("Maior: " + maximo + ", Menor: " + minimo);
```

---

### 🔹 12. `.limit()` e `.skip()`

**Para que servem:**
Controlam quantos elementos serão processados.

* `limit(n)` → Pega os **n primeiros** elementos.
* `skip(n)` → **Pula** os n primeiros.

**Exemplo:**

```java
Arrays.stream(new int[]{1, 2, 3, 4, 5})
      .limit(3)
      .forEach(System.out::println); // 1, 2, 3

Arrays.stream(new int[]{1, 2, 3, 4, 5})
      .skip(2)
      .forEach(System.out::println); // 3, 4, 5
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

