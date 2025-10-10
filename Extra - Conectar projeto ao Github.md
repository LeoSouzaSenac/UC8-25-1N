## 🧩 **1. Pré-requisitos**

Antes de tudo, verifique se você tem:

* ✅ **Conta no GitHub** — [https://github.com](https://github.com)
* ✅ **Git instalado** no computador
  👉 [Baixar Git](https://git-scm.com/downloads)
* ✅ **NetBeans** instalado (versão 8 ou superior)

---

## ⚙️ **2. Verifique se o Git está configurado**

Abra o **terminal (Prompt de Comando)** e digite:

```bash
git --version
```

Se aparecer algo como `git version 2.42.0`, está tudo certo.

Se for a primeira vez usando Git, configure seu nome e e-mail (usados nos commits):

```bash
git config --global user.name "Seu Nome"
git config --global user.email "seuemail@exemplo.com"
```

---

## 💻 **3. Abra seu projeto no NetBeans**

Abra o projeto Java normalmente no **NetBeans**.

---

## 🌿 **4. Inicializar o repositório Git dentro do NetBeans**

1. Clique com o botão direito sobre a **pasta do projeto**.
2. Vá em **Git → Initialize Repository**.
3. O NetBeans vai criar uma pasta oculta chamada `.git` dentro do seu projeto.

> 🧠 Isso significa que agora seu projeto é controlado pelo Git localmente.

---

## 💾 **5. Fazer o primeiro commit**

1. Clique com o botão direito no projeto → **Git → Commit**.
2. Selecione os arquivos que quer enviar.
3. Escreva uma mensagem, por exemplo:
   `"Primeiro commit do projeto"`
4. Clique em **Commit**.

---

## ☁️ **6. Criar o repositório no GitHub**

1. Acesse o GitHub e clique em **New Repository** (novo repositório).
2. Dê um nome (ex: `meu-projeto-java`).
3. NÃO marque a opção *Initialize this repository with a README*, pois o projeto já existe.
4. Clique em **Create Repository**.

Você verá instruções do tipo:

```bash
git remote add origin https://github.com/seuusuario/meu-projeto-java.git
git branch -M main
git push -u origin main
```

Guarde esse link — ele será usado no próximo passo.

---

## 🔗 **7. Conectar o repositório local ao GitHub (pelo NetBeans)**

1. Clique com o botão direito no projeto → **Git → Remote → Push...**

2. Na janela que abre, clique em **Specify Git Repository Location**.

3. No campo *Repository URL*, cole o link do GitHub, por exemplo:

   ```
   https://github.com/seuusuario/meu-projeto-java.git
   ```

4. Insira seu **usuário e senha/token do GitHub**.

   ⚠️ **Importante:** o GitHub **não aceita mais senha normal** — use um **Personal Access Token (PAT)**.
   Crie um token aqui:
   👉 [https://github.com/settings/tokens](https://github.com/settings/tokens)
   → Clique em **Generate new token (classic)**
   → Marque `repo` e `workflow`
   → Copie o token e use no lugar da senha.

5. Clique em **Next → Finish**.

---

## 🚀 **8. Enviar (push) o projeto ao GitHub**

1. Clique com o botão direito no projeto → **Git → Remote → Push...**
2. Selecione `origin` como destino.
3. Clique em **Next** → marque `master` (ou `main`) → **Finish**.

O NetBeans enviará seu código ao GitHub.

---

## ✅ **9. Verifique no GitHub**

Acesse seu repositório no navegador (por exemplo,
`https://github.com/seuusuario/meu-projeto-java`)
Você verá todos os arquivos do projeto lá.

---

## 💡 Dica extra — Fazer commits e pushes futuros

Toda vez que alterar o projeto:

1. **Git → Commit...** (salva localmente)
2. **Git → Remote → Push...** (envia ao GitHub)

---
