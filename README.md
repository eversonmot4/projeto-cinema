# 🎬 Projeto Cinema

Um sistema simples de gerenciamento de cinema em **Java**, executado via **console** e organizado em camadas.  
O objetivo é simular reserva de assentos, compra de ingressos e gerenciamento de salas e filmes.

---

## 🚀 Funcionalidades

- ✔ Cadastro de salas  
- ✔ Cadastro de filmes  
- ✔ Exibição da lista de filmes e salas  
- ✔ Representação de assentos (disponíveis / reservados)  
- ✔ Compra de ingressos  
- ✔ Associação de ingresso → pessoa → sala → assento  
- ✔ Interface simples via console  
- ✔ Estrutura orientada a objetos organizada por camadas  

---

# 🛠 Tecnologias Utilizadas

Java 17+
Paradigma Orientado a Objetos (POO)
Scanner (entrada de dados)
Arquitetura MVC Simples

---

## 📁 Estrutura do Projeto
```text
projeto-cinema/
│
├── app/
│   └── Main.java
│
├── model/
│   ├── Assento.java
│   ├── Cinema.java
│   ├── Filme.java
│   ├── Ingresso.java
│   ├── Pessoa.java
│   └── Sala.java
│
├── view/
│   └── Ingresso.java
│
└── README.md
