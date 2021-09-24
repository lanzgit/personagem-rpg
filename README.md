# Assessment Desenvolvimento Web com JavaEE
## Roteiro

### LOADER
- [x] 1.	Apague o seu banco de dados.
- [x] 2.	Rode a aplicação e veja se as tabelas foram criadas (uma para cada classe e a de relacionamento).
- [x] 3.	Observe se em cada tabela tem pelo menos um registro.
### ACESSO DO USUARIO
- [x] 4.	Tente acessar o sistema com uma credencial (email/senha) inexistente.
- [x] 5.	A mensagem de usuário inválido deve ser apresentada.
- [x] 6.	Verifique se os menus de cadastros não aparecem sem um usuário logado.
- [x] 7.	Acesse o sistema e cadastre um novo usuário pelo link de signup.
- [x] 8.	Tente acessar o sistema com as credenciais do usuário admin.
- [x] 9.	Clique no menu de usuários para listar todos os registros existentes no banco.
- [x] 10.	A tela home deve ser apresentada com o nome do usuário utilizado nas credenciais de login.
- [ ] 11.	A listagem de usuários deve estar organizada alfabeticamente de forma crescente.
### EQUIPE: PERSONAGENS E EQUIPAMENTOS
- [x] 12.	Clique no menu de pedidos para listar todos os registros existentes no banco.
- [x] 13.	Verifique se além dos dados cadastrais também está sendo exibida a informação do solicitante deste pedido e da quantidade de produtos.
- [x] 14.	Clique no menu de solicitantes para listar todos os registros existentes no banco.
- [x] 15.	Faça a inclusão de um solicitante e verifique se existe algum critério de ordenação.
- [x] 16.	Clique no menu de bebidas para listar todos os registros existentes no banco.
- [x] 17.	Faça a inclusão de uma bebida e verifique se existe algum critério de ordenação.
- [x] 18.	Clique no menu de comidas para listar todos os registros existentes no banco.
- [x] 19.	Faça a inclusão de uma bebida e verifique se existe algum critério de ordenação.
- [x] 20.	Clique no menu de sobremesas para listar todos os registros existentes no banco.
- [x] 21.	Faça a inclusão de uma sobremesa e verifique se existe algum critério de ordenação.
- [x] 22.	Clique no menu de produtos para listar todos os registros existentes no banco de forma ordenada.
### EQUIPES
- [x] 23.	Crie um novo pedido com o solicitante e os três produtos cadastrados.
- [x] 24.	Verifique no campo "select" se todos os solicitantes cadastrados aparecem ordenados.
- [x] 25.	Verifique no campo "checkbox" se todos os produtos cadastrados aparecem ordenados.
- [ ] 26.	Após a inclusão verifique se os pedidos aparecem de forma ordenada.
### USUARIOS
- [x] 27.	Faça o logout no sistema e entre com o novo usuário.
- [x] 28.	Clique no menu de usuários para listar todos e verificar se a opção de exclusão não aparece.
- [x] 29.	Verifique se os dois usuários cadastrados têm algum critério de ordenação.
### EQUIPE DE NOVO USUARIO
- [x] 30.	Clique no menu de pedidos para cadastrar um novo registro.
- [x] 31.	Verifique se existe uma indicação de ausência de solicitantes e de produtos.
- [x] 32.	Faça a inclusão de um solicitante e verifique se aparece apenas um registro na lista.
- [x] 33.	Faça a inclusão de uma bebida, de uma comida e de uma sobremesa e verifique se aparece apenas um registro em cada listagem.
- [x] 34.	Verifique se aparecem apenas três registros na lista de produto de forma ordenada.
- [x] 35.	Clique no menu de pedidos e realize o cadastro de um novo registro.
- [x] 36.	Vá ao menu de usuário para confirmar a quantidade de solicitantes, produtos e pedidos por usuário.
### EXCLUSAO
- [x] 37.	Faça o login com o usuário administrador.
- [x] 38.	Faça a inclusão de uma bebida, uma comida, uma sobremesa e um solicitante.
- [x] 39.	Faça a exclusão desta bebida e veja se a listagem foi atualizada, além da listagem de produtos e de usuários.
- [x] 40.	Faça a exclusão desta comida e veja se a listagem foi atualizada, além da listagem de produtos e de usuários.
- [x] 41.	Faça a exclusão desta sobremesa e veja se a listagem foi atualizada, além da listagem de produtos e de usuários.
- [x] 42.	Faça a exclusão deste solicitante e veja se a listagem foi atualizada, além da listagem de usuários.
- [x] 43.	Faça a exclusão de algum pedido e veja se a listagem foi atualizada, além da listagem de usuários.
### INTEGRIDADE
- [ ] 44.	Tente fazer a exclusão de um solicitante que esteja associado a um pedido. Não deve permitir e emitir uma mensagem.
- [ ] 45.	Tente fazer a exclusão de uma bebida que esteja associada a um pedido. Não deve permitir e emitir uma mensagem.
- [ ] 46.	Tente fazer a exclusão de uma comida que esteja associada a um pedido. Não deve permitir e emitir uma mensagem.
- [ ] 47.	Tente fazer a exclusão de uma sobremesa que esteja associada a um pedido. Não deve permitir e emitir uma mensagem.
- [ ] 48.	Agora tente excluir algum registro - através do menu de produtos - que esteja associado a um pedido. Mesma regra.
### FIM
- [x] 49.	Vá ao menu de usuário e exclua um registro e verifique no banco se todos os registros associados foram excluídos.
- [x] 50.	Faça o logout no sistema, confirme se os menus sumiram e tente entrar com o usuário excluído.