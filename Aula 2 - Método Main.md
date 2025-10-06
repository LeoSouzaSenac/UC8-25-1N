# O que é Obrigatório no Método `main` em Java?

O método `main` é essencial para o funcionamento de um programa Java, pois é o ponto de entrada da aplicação. Há algumas características que **sempre** devem estar presentes para que o método funcione corretamente. Vamos explorar o que é **obrigatório** em todo método `main`.

Quando você diz ao computador para executar uma aplicação Java (por exemplo com `java MinhaClasse`), a JVM (Java Virtual Machine) **procura essa porta** — o método `main` — para saber por onde começar. Sem essa porta, a JVM não saberia qual código executar primeiro.

### O que o `main` faz, em palavras simples

* **Ponto inicial:** é o primeiro método que a JVM invoca para começar a execução do programa.
* **Recebe argumentos:** ele pode receber informações vindas da linha de comando (por exemplo, nomes de arquivos, flags, etc.) através do parâmetro `args`.
* **Controla o fluxo inicial:** neste método você normalmente configura o programa, chama outras classes/métodos e decide o que acontece em seguida.
* **Fim do programa:** quando o `main` termina (e não há outras *threads* não-daemon ativas), o programa normalmente encerra.

### Analogia rápida

Imagine um teatro: o `main` é o **diretor** que abre a cortina. Ele organiza quem entra em cena, dá as primeiras instruções e só depois a peça continua com os atores (outras classes e métodos).

### Exemplo prático (compilar e executar)

Arquivo `Exemplo.java`:

```java
public class Exemplo {
    public static void main(String[] args) {
        System.out.println("Programa iniciado!");
        System.out.println("Recebi " + args.length + " argumento(s).");
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }
    }
}
```

Como compilar e executar:

```bash
javac Exemplo.java        # compila
java Exemplo olá mundo    # executa e passa dois argumentos: "olá" e "mundo"
```

Saída esperada:

```
Programa iniciado!
Recebi 2 argumento(s).
args[0] = olá
args[1] = mundo
```

## Estrutura Obrigatória do Método `main`

A assinatura padrão do método `main` que a JVM (Java Virtual Machine) espera é:

```java
public static void main(String[] args)
```

### O que é Obrigatório?

1. **public**
   - O método `main` deve ser **público**. Isso é necessário porque a JVM precisa ter acesso ao método para iniciar o programa. Se ele não for público, o programa não rodará, pois a JVM não conseguiria "enxergar" o método.

2. **static**
   - O método `main` deve ser **estático**. Isso é obrigatório porque a JVM chama o método sem criar um objeto da classe que contém o `main`. Sendo estático, ele pode ser chamado diretamente através do nome da classe, sem necessidade de instanciar a classe.

3. **void**
   - O método `main` **não pode retornar nenhum valor**. O tipo de retorno deve ser `void`. Isso significa que, após executar o método `main`, o programa não devolve nenhuma informação diretamente à JVM.

4. **main**
   - O nome do método **deve ser exatamente** `main`. Esse é o nome específico que a JVM procura ao iniciar o programa. Qualquer outro nome resultaria em erro ou o programa não rodaria.

5. **String[] args**
   - O método `main` precisa aceitar um parâmetro do tipo `array de Strings`, ou seja, `String[]`. Esse parâmetro é usado para passar argumentos para o programa quando ele é executado. Embora você possa não usar os argumentos, o parâmetro precisa estar lá para que o programa seja considerado válido.

### Exemplo Correto:

Aqui está o formato correto e obrigatório de um método `main`:

```java
public class Exemplo {
    public static void main(String[] args) {
        System.out.println("Programa rodando corretamente!");
    }
}
```

- **`public`**: A JVM pode acessar o método.
- **`static`**: Pode ser executado sem criar uma instância da classe.
- **`void`**: Não retorna nada.
- **`main`**: Nome fixo que a JVM reconhece.
- **`String[] args`**: Parâmetro obrigatório, mesmo que não seja utilizado no código.

---

## Resumo

Os elementos obrigatórios do método `main` em Java são:
- **`public`**: Acessível pela JVM.
- **`static`**: Executado sem instância de classe.
- **`void`**: Não retorna valor.
- **`main`**: Nome específico do método.
- **`String[] args`**: Parâmetro de array de Strings.
