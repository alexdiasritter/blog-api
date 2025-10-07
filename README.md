BlogSys — Documento de Requisitos e Histórias de Usuário

Visão Geral
Nome do Sistema: BlogSys
Tecnologias: Spring Boot (Java 25), PostgreSQL, AWS Cognito, AWS S3
Deploy: AWS

O BlogSys é um sistema de blog com autenticação, CRUD de postagens, comentários e curtidas.
Usuários autenticados podem interagir com postagens, e administradores podem gerenciar o conteúdo do blog.

Histórias de Usuário:

	1. Como administrador, quero criar, editar e excluir postagens, para manter o blog sempre atualizado.
	2. Como visitante, quero visualizar um feed com as postagens recentes, para acompanhar o conteúdo.
	3. Como usuário cadastrado, quero curtir e comentar postagens, para interagir com o conteúdo e outros usuários.
	4. Como novo usuário, quero me cadastrar e logar via AWS Cognito, para ter acesso às funções de interação.
	5. Como administrador, quero fazer upload de imagens no AWS S3, para adicionar mídias às postagens sem sobrecarregar o banco.

Requisitos Funcionais (RF):

	RF01 - Autenticação e Autorização: O sistema deve utilizar AWS Cognito para login, cadastro e gerenciamento de roles (COMMUN_USER, ADMIN_USER).
	RF02 - Gerenciamento de Postagens: Administradores podem criar, editar, excluir e listar postagens.
	RF03 - Feed de Postagens: O sistema exibirá as postagens em um feed ordenado por data (decrescente), paginado.
	RF04 - Upload de Imagens: O sistema deve enviar e recuperar imagens de postagens via AWS S3.
	RF05 - Curtidas: Usuários autenticados poderão curtir e descurtir postagens.
	RF06 - Comentários: Usuários autenticados poderão criar, editar e excluir seus próprios comentários.

Requisitos Não Funcionais (RNF):

	RNF01 - Linguagem: Java 25 com Spring Boot.
	RNF02 - Banco de Dados: PostgreSQL.
	RNF03 - Segurança: Integração com AWS Cognito para autenticação e autorização com JWT.
	RNF04 - Armazenamento de Imagens: Utilizar AWS S3 para armazenamento e recuperação de imagens.
	RNF05 - Deploy: O sistema será hospedado na AWS.
	RNF06 - Performance: O feed deverá carregar até 100 postagens em menos de 2 segundos.
	RNF07 - Escalabilidade: O sistema deve suportar horizontal scaling via AWS ECS ou Elastic Beanstalk.


Entidades:

	Usuário: OK

		id (UUID) - Identificador único
		nome (String) - Nome do usuário
		email (String) - E-mail único
		role (Enum: COMMUN_USER, ADMIN_USER) - Papel do usuário
		posts (List<Post>) - Postagens criadas (admin)
		curtidas (List<Post>) - Postagens curtidas
		comentarios (List<Comment>) - Comentários feitos

	Post:
		
		id (Long) - Identificador da postagem
		dataPublicacao (LocalDateTime) - Data e hora da publicação
		titulo (String) - Título da postagem
		texto (String) - Conteúdo principal
		imagemUrl (String) - URL da imagem no S3
		autor (User) - Usuário autor
		comentarios (List<Comment>) - Comentários da postagem
		curtidas (List<User>) - Usuários que curtiram

	Comment:

		id (Long) - Identificador do comentário
		texto (String) - Conteúdo do comentário
		dataHora (LocalDateTime) - Data e hora da criação
		autor (User) - Usuário autor
		post (Post) - Postagem associada

	Relacionamentos:

		User (1) --- (N) Post (admin cria postagens)
		User (1) --- (N) Comment
		Post (1) --- (N) Comment
		User (N) --- (N) Post (curtidas)

Arquitetura Spring Boot:

Camadas:
- Controller: expõe endpoints REST.
- Service: regras de negócio e integração com AWS Cognito/S3.
- Repository: persistência com Spring Data JPA.
- Entity: mapeamento ORM das tabelas.
- Config: configurações de segurança e aws.

Observação
A versão futura pode incluir paginação, busca por postagens e sistema de notificações via SNS (AWS Simple Notification Service).
