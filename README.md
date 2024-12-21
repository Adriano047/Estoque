<a id="readme-top"></a>
# Gerenciador de Estoque 📦:
Este sistema utiliza uma implementação de banco de dados para gerenciar o estoque de um almoxarifado. A estrutura é composta por uma tabela, onde cada item representa um produto, contendo as colunas: Nome, Preço e Quantidade. O sistema pode ser acessado tanto via API (utilizando o Postman para testar as requisições) quanto através de uma interface web, proporcionando flexibilidade e praticidade na gestão do estoque.

## 🔧 Principais Funcionalidades: 
**Registrar:**
- **Através da requisição POST, novos registros de produtos podem ser adicionados ao estoque.**
- **Postman:** Envia a requisição com os dados do produto (nome, preço, quantidade) no corpo da requisição, utilizando o Content-Type: 'application/json'.
- **Interface Web:** Preenche um formulário com as informações do produto e envia via interface gráfica.
  
**Remover:**
- **Através da requisição DELETE, remove itens específicos do estoque.**
- **Postman:** Envia a requisição DELETE para a URL correspondente ao item, passando o identificador do produto no corpo ou na URL.
- **Interface Web:** Seleciona o item na lista de produtos e clica em "Excluir", removendo o produto do estoque.

**Atualizar:**
- **Através da requisição PUT, atualiza as informações de um item específico no estoque, como nome, preço ou quantidade.**
- **Postman:** Envia a requisição PUT com os dados modificados no corpo da requisição para o item selecionado, utilizando o Content-Type: 'application/json'.
- **Interface Web:** Edita as informações diretamente no formulário e envia via interface gráfica para atualização do produto.

**Listar:**
- **Através da requisição GET, exibe todos os itens disponíveis no estoque.**
- **Postman:** Envia a requisição GET para obter a lista de todos os itens, retornando as informações em formato JSON.
- **Interface Web:** Exibe a lista de produtos no painel da interface, com a opção de editar ou excluir cada item.

## Validações de dados ✅:
**Registrar e Atualizar Informações:**

**O nome não pode estar em branco.**
- **Postman:** Se o nome não for fornecido, a requisição falhará e retornará um erro de validação.
- **Interface Web:** O campo de nome será destacado, e o usuário será solicitado a preenchê-lo antes de enviar o formulário.

**A quantidade não pode ser null e deve ser igual ou maior que 1.**
- **Postman:** Se a quantidade for menor que 1 ou null, a requisição será rejeitada com um erro.
- **Interface Web:** O campo de quantidade será validado no formulário, garantindo que o valor inserido seja maior que 0 antes de permitir o envio.

**O preço não pode ser null e deve ser igual ou maior que 0,05.**
- **Postman:** Se o preço for menor que 0,05 ou null, a requisição será rejeitada com uma mensagem de erro.
- **Interface Web:** O campo de preço será validado no formulário, impedindo que valores abaixo de 0,05 sejam enviados.

## 🗄️ Estrutura do Banco de Dados:
###  Tabela: produto
| Colunas  |  Tipos De Dados  |  Descrição             |
|----------| ---------------- |------------------------|
| **Id**   |       INT        |  Chave Primária, possui auto incremento             |
| **Nome** |  VARCHAR(255)    |  Nome do Produto                   |
| **Preco** |  DOUBLE   |  Preço do Produto                   |
| **Qtd** |  INT    |  Quantidade do Produto          |

### Rodando Codigo:
https://github.com/user-attachments/assets/39deea4c-2771-4b10-9275-513d23f603a9

## Rotas do POSTMAN:
**POST e GET (Todos os produtos):**
- **Rota:** http://localhost:3306/almo-sys/produtos
- **Descrição:**
 - **POST:** Adiciona novos produtos ao estoque.
- **GET:** Lista todos os produtos cadastrados no estoque.

**PUT, DELETE e GET (Produto específico):**
- **Rota:** http://localhost:3306/almo-sys/produtos/{id}
- **Descrição:**
- **PUT:** Atualiza as informações de um produto específico pelo ID.
- **DELETE:** Remove um produto específico do estoque pelo ID.
- **GET:** Retorna as informações de um produto específico pelo ID.

## Rotas da Interface Web:
**GET (Todos os produtos):**
- **Rota:** http://localhost:8081

**Formulario de requisição POST**
- **Rota:** http://localhost:8081/novoProduto
  
**Formulario de requisição PUT**
- **Rota:** http://localhost:8081/AlterarProduto/{id}

**Formulario de requisição DELETE**
- **Rota:** http://localhost:8081/DeletarProduto/{id}

## Mudança de Conexão Importante ⚠️:
![Alterações](https://github.com/user-attachments/assets/cdd667ed-d7fc-4278-93e3-231512763122)

### Caso você não deseje criar uma conexão com o banco de dados na porta padrão 3306 e queira que o servidor Spring Boot seja executado na porta 8081, com o nome do banco sendo estoque, e o usuário e senha como root, aqui estão alguns avisos: 

**Linha 1:** Refere-se ao nome do banco de dados. Caso não queira utilizar um banco com o nome "estoque", basta substituí-lo pelo nome desejado.

**Linha 3:** A variável url se conecta ao banco de dados MySQL na porta padrão 3306. Se você precisar usar outra porta, deve incluir isso na URL. EX: jdbc:mysql://localhost:3307.

**Linha 4:** A variável usuario define o nome do usuário que está se conectando ao banco de dados. O padrão é root, mas você pode mudá-lo para outro usuário com permissões  
adequadas.

**Linha 5:** A variável senha especifica a senha do usuário definido na linha 5. Assim como o usuário, você deve alterar para a senha correta conforme configurada no seu banco de dados.

**Linha 6:** Atualmente, a aplicação está configurada para rodar na porta 8081. Caso queira usar a porta padrão (8080), exclua este trecho, ou se desejar configurar outra porta, basta alterá-la para o número desejado.

## :octocat: Faça o clone do projeto

```bash
# Clone este repositório
$ gh repo clone Adriano047/Estoque

# Acesse a pasta do projeto no terminal/cmd
$ cd me

```


## 👨‍🔧 Sobre mim
"Conecte-se comigo no LinkedIn para explorar minha trajetória profissional e colaborar em projetos incríveis."
<table>
  <tbody>
    <tr>
      <td align="center" valign="top" width="14.28%"><a href="https://www.linkedin.com/in/cardosodev047/"><img src="https://media.licdn.com/dms/image/v2/D4D03AQFRff9YjluTHQ/profile-displayphoto-shrink_400_400/profile-displayphoto-shrink_400_400/0/1713879990636?e=2147483647&v=beta&t=AIThEkfC267uJ_bVz5bpXdPbuvQlDzdWdeb4JgeSkxQ" width="100px;" alt="Kent C. Dodds"/><br /><sub><b>Adriano Cardoso Santos</b></sub></a><br />
    </tr>
  </tbody>
</table>

<p align="right">(<a href="#readme-top">Voltar ao topo</a>)</p>

