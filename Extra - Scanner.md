# 🧠 Usando o `Scanner` em Java

## 📘 O que é o Scanner?

O **Scanner** é uma classe do Java usada para **ler dados digitados pelo usuário** no teclado.  
Ela faz parte do pacote `java.util`, por isso sempre precisamos **importá-la** no início do código:

```java
import java.util.Scanner;
````

---

## 💡 Exemplo Completo

Aqui está um programa simples que pede dois números ao usuário e mostra o resultado na tela:

```java
package gradleproject1;
// Importa a classe Scanner para permitir a entrada de dados do usuário
import java.util.Scanner;

public class Escrever {
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner sc = new Scanner(System.in);

        // Declara duas variáveis inteiras para armazenar os números digitados pelo usuário
        int numero1, numero2;

        // Solicita ao usuário que digite o primeiro número
        System.out.println("Digite um número: ");
        numero1 = sc.nextInt(); // Lê o próximo inteiro digitado pelo usuário e o armazena em numero1

        // Solicita ao usuário que digite o segundo número
        System.out.println("Digite outro número: ");
        numero2 = sc.nextInt(); // Lê o próximo inteiro digitado pelo usuário e o armazena em numero2

        // Exibe uma mensagem para indicar que o resultado será mostrado
        System.out.println("Resultado: " + (numero1 + numero2));

        // Fecha o objeto Scanner para liberar os recursos utilizados
        sc.close();
    }
}
```

---

## 🧩 Explicando o código

| Linha                                                    | Explicação                                                                           |
| -------------------------------------------------------- | ------------------------------------------------------------------------------------ |
| `import java.util.Scanner;`                              | Importa a classe `Scanner` para podermos usá-la.                                     |
| `Scanner sc = new Scanner(System.in);`                   | Cria um novo **objeto Scanner** chamado `sc`, que lê dados do teclado (`System.in`). |
| `int numero1, numero2;`                                  | Declara duas variáveis para armazenar os números digitados.                          |
| `numero1 = sc.nextInt();`                                | Lê o **próximo número inteiro** digitado e guarda em `numero1`.                      |
| `System.out.println("Resultado: " + numero1 + numero2);` | Mostra o resultado na tela (⚠️ mas aqui ele apenas **concatena** os números).        |
| `sc.close();`                                            | Fecha o Scanner (boa prática para liberar recursos).                                 |
---

## 🧪 Outras formas de entrada com Scanner

| Método         | Tipo de dado          | Exemplo                            |
| -------------- | --------------------- | ---------------------------------- |
| `nextInt()`    | Lê um número inteiro  | `int idade = sc.nextInt();`        |
| `nextDouble()` | Lê um número decimal  | `double altura = sc.nextDouble();` |
| `nextLine()`   | Lê uma linha de texto | `String nome = sc.nextLine();`     |
| `next()`       | Lê uma palavra        | `String cidade = sc.next();`       |

---

## ✅ Resumo

* `Scanner` é usado para **ler dados do teclado**.
* Precisa ser **importado**: `import java.util.Scanner;`
* Sempre **feche** o Scanner com `sc.close();`
* Para **somar números**, use parênteses: `(numero1 + numero2)`

---

## 🎯 Desafio para praticar

Crie um programa que:

1. Peça o nome do usuário.
2. Peça sua idade.
3. Mostre uma mensagem como:

   ```
   Olá, Maria! Você tem 25 anos.
   ```

Use o `Scanner` e os métodos `nextLine()` e `nextInt()`.
