# Blog
### Segundo Projeto em Java
A finalidade do projeto é para testar meus conhecimentos como Back-end. 

Quero compartilhar com vocês um projeto em que tenho trabalhado ultimamente. Tive a oportunidade de criar uma API para o nosso blog, com o objetivo de aprimorar nossos recursos de gerenciamento de conteúdo e proporcionar uma melhor experiência para nossos leitores.

Optei por utilizar o Java como a linguagem principal para o back-end. Para agilizar o processo de desenvolvimento e facilitar a interação com nosso banco de dados(PostgreSQL), escolhi o Spring Boot e o Spring Data JPA.

Nossa API oferece uma série de funcionalidades cruciais:
- Adicionar Conteúdo: Com apenas algumas chamadas de API, podemos facilmente criar novas postagens e artigos para o blog. Os dados são persistentes e armazenados com segurança em nosso banco de dados.
- Editar e Atualizar: A capacidade de editar postagens existentes é essencial. Com nossa API, podemos atualizar facilmente informações como título, corpo do texto e categorias.
- Remover Conteúdo: Para manter nosso blog organizado, implementamos endpoints para exclusão de postagens quando necessário.
- Consultas Eficientes: A capacidade de recuperar postagens com base em critérios específicos, como categoria, data de publicação ou palavras-chave, é uma das vantagens mais valiosas da nossa API.
#
### Página inicial
![BlogHomeC](https://github.com/Wrasprodigio/blog/assets/132852135/d610ffc7-6029-47cb-8bb3-6335af8166fb)

#
### Alertas
Todos os posts que forem adicionados vão ser direcionados para a página inicial. Quando adicionar, editar ou excluir, vai aparecer o alerta abaixo de acordo com a funcionalidade aplicada.

![BlogAlertas](https://github.com/Wrasprodigio/blog/assets/132852135/9731edbf-6e57-4938-9be9-df64a1a1bfe9)
#

### Adicionando Post
Quando adicionar os campos no formulário (titulo, autor e texto) vai registrar a data que foi publicado o post e mesmo após editar o post essa data não será modificada.
Caso tentem adicionar algum post sem preencher os campos obrigatórios, aparecerá o alerta impedindo a publicação do post.

![BlogNewPost1](https://github.com/Wrasprodigio/blog/assets/132852135/618b0466-5935-42dd-bea0-4e8e31814e15)
#

### Editando Post

![BlogEditPost](https://github.com/Wrasprodigio/blog/assets/132852135/a0ac42b3-9fda-43f4-8d82-0263f6515ae5)
#

### Pesquisando Post
A pesquisa está sendo buscada pelo titulo ou autor do post, como podem ver na imagem foi buscado pela palavra "va" e como resposta foi encontrado dois posts.

![BlogSearch](https://github.com/Wrasprodigio/blog/assets/132852135/f4d70c8f-8041-41d9-ad93-2561ac856062)
