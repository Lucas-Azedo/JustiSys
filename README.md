## Checklists

### 🔧 Estrutura Básica - Backend

- [x] Criar pacotes principais: controller, dto, exception, model, repository, service
- [x] Definir entidades principais: Client, City, Case, Document
- [ ] Implementar classes DTO para cada entidade
- [ ] Configurar repositórios com Spring Data JPA
- [ ] Criar serviços para lógica de negócios
- [ ] Implementar controladores REST para cada recurso

### 🔧 Estrutura Básica - Frontend

- [ ] Escolher framework
- [ ] Estruturar pastas (components, pages, services, assets)
- [ ] Criar componentes básicos para:
  - [ ] Lista de clientes
  - [ ] Formulário de cadastro/edição de clientes
  - [ ] Visualização de casos
  - [ ] Upload e visualização de documentos
- [ ] Criar serviço para comunicação com API REST (ex: axios, fetch)


### 🛠️ Funcionalidades Essenciais - Backend

- [x] Cadastro de clientes
- [x] Cadastro de cidades
- [ ] Cadastro de casos jurídicos
- [ ] Upload e gerenciamento de documentos
- [ ] Relacionamento entre clientes e casos
- [ ] Pesquisa e filtro de casos por cliente, status, data, etc.
- [ ] Implementação de autenticação e autorização via JWT
- [ ] Tratamento de exceções e erros
  - [ ] Criar classes customizadas de exceção
  - [ ] Implementar handler global para exceções

### 🛠️ Funcionalidades Essenciais - Frontend

- [ ] Tela de login e autenticação
- [ ] Formulário para cadastro e edição de clientes
- [ ] Formulário para cadastro e edição de casos jurídicos
- [ ] Upload e listagem de documentos no cliente/caso correspondente
- [ ] Tela para pesquisar e filtrar casos
- [ ] Tratamento de erros e mensagens de validação na UI


### 📦 Testes - Backend

- [ ] Testes unitários para serviços
- [ ] Testes de integração para endpoints REST
- [x] Testes de repositório com banco de dados em memória

### 📦 Testes - Frontend

- [ ] Testes unitários para componentes
- [ ] Testes de integração para fluxos principais
- [ ] Testes E2E


### 📄 Documentação

- [ ] Documentar endpoints da API com Swagger/OpenAPI
- [ ] Atualizar README.md com instruções de uso e desenvolvimento
- [ ] Incluir informações sobre como rodar a aplicação localmente
- [ ] Adicionar exemplos de requisições e respostas da API
- [ ] Documentar funcionalidades e fluxo da interface frontend


### 🚀 Preparação para Produção

- [ ] Configurar banco de dados de produção 
- [ ] Preparar scripts de migração de banco de dados
- [ ] Configurar variáveis de ambiente para produção (backend e frontend)
- [ ] Gerar build final da aplicação backend
- [ ] Gerar build final da aplicação frontend
- [ ] Testar deploy em ambiente de produção (backend e frontend)
