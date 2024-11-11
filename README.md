# Projeto Final de Arquitetura Java [24E4_2] - Cadastro de Comerciantes e Mercadorias

Este projeto faz parte da disciplina de **Arquitetura Java** e representa a **entrega final** do curso. Ele implementa a funcionalidade de **Cadastro de Comerciantes e Mercadorias**, permitindo registrar comerciantes com suas mercadorias (souvenirs e brinquedos) usando o framework Spring Boot.

## Funcionalidades Implementadas

### Cadastro de Comerciantes e Mercadorias
O sistema inclui as seguintes funcionalidades principais:

- **Cadastro de Comerciantes**: Cada comerciante possui nome, CPF, e-mail e endereço.
- **Cadastro de Mercadorias**: É possível cadastrar dois tipos de mercadorias:
  - **Souvenir**: Itens com características específicas, como se são orgânicos ou não, e descrição detalhada.
  - **Brinquedos**: Mercadorias com informações sobre marca e tempo de garantia.
- **Leitura Automática de Arquivo**: O sistema permite o cadastro automático de comerciantes e mercadorias a partir de um arquivo de texto.
- **Listagem de Comerciantes e Mercadorias**: Exibe os comerciantes cadastrados, bem como suas mercadorias associadas.

## Estrutura do Projeto

- **`br.edu.infnet.salomao.SalomaoApplication`**: Classe principal para inicialização da aplicação Spring Boot.
- **`br.edu.infnet.salomao.Loader`**: Classe responsável por carregar dados iniciais a partir de um arquivo de texto especificado.
- **Domínio**:
  - `Comerciante`: Representa o comerciante e contém uma lista de mercadorias.
  - `Mercadoria`: Classe abstrata que serve de base para diferentes tipos de mercadorias.
  - `Souvenir`: Subclasse de `Mercadoria`, representando mercadorias de souvenir.
  - `Brinquedos`: Subclasse de `Mercadoria`, representando mercadorias de brinquedos.
  - `Endereco`: Representa o endereço completo do comerciante.
- **Serviço**:
  - `ComercianteService`: Classe que gerencia a inclusão e recuperação de comerciantes cadastrados.

## Arquivo de Entrada

O cadastro de comerciantes e mercadorias pode ser feito automaticamente a partir do arquivo `files/comerciantes.txt`. O arquivo deve seguir o formato abaixo:

V;cpf;email;nome;cep A;codigo;descricao;estoque;preco;caracteristica;organico 
E;codigo;descricao;estoque;preco;marca;garantiaMeses


**Exemplo:**
V;123123123123;salomao@salomao.com;Salomao Nasser;01001000 
A;1;coca-cola;false;10;normal;false E;4;celular;true;40;xpto;15



## Tecnologias Utilizadas

- **Java 11**
- **Spring Boot 2.7.5**
- **Maven**

## Autor

- **Salomão Rachid Nasser Neto** - br.edu.infnet
