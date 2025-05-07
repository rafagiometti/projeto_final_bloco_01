# 🐾 Projeto Final - PetShop Java (Console)

## 📌 Descrição

Este é um sistema de e-commerce em Java para gerenciamento de produtos de um Pet Shop.  
A aplicação funciona no console e permite cadastrar, listar, buscar, atualizar e deletar produtos.

O projeto foi desenvolvido como atividade final do Bloco 1 da Generation Brasil, com o objetivo de aplicar os principais conceitos de **Java básico** e **Programação Orientada a Objetos (POO)**.

---

## 🎯 Funcionalidades

- Cadastrar produtos (ração ou brinquedo)
- Listar todos os produtos
- Buscar produto por ID
- Atualizar dados de um produto
- Remover produto por ID
- Buscar produtos por nome

---

## 🧠 Conceitos Utilizados

- Classes, Atributos e Métodos
- Herança e Polimorfismo
- Classe Abstrata
- Interface
- Coleções (ArrayList)
- Estrutura de controle (if, switch, loops)
- Entrada e saída de dados (Scanner)
- Tratamento de erros com Optional

---

## 🗂 Estrutura do Projeto

- `ProdutoPet` → Classe abstrata com os atributos e métodos principais  
- `Racao` e `Brinquedo` → Classes filhas com atributos específicos  
- `ProdutoRepository` → Interface com os métodos do CRUD  
- `ProdutoController` → Implementação da lógica do sistema  
- `Menu` → Classe principal com o menu e interação com o usuário

---

## ▶️ Como Executar

1. Instale o **Java JDK 17+** e o **Eclipse ou STS**
2. Clone o repositório:

```bash
git clone https://github.com/rafagiometti/projeto_final_bloco_01.git
