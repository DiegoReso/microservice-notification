![Java](https://img.shields.io/badge/Java-007396?style=flat-square&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33?style=flat-square&logo=spring-boot&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-2C3E50?style=flat-square&logo=lombok&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=gradle&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/GitHub%20Actions-2088FF?style=flat-square&logo=github-actions&logoColor=white)
![Kanban](https://img.shields.io/badge/Kanban-007ACC?style=flat-square&logo=trello&logoColor=white)


# Microsserviço de Notificação 🔔

## Visão Geral do Projeto

Este projeto é um **microsserviço de notificação** focado no envio de e-mails para alertar os usuários sobre suas tarefas pendentes. Ele é um componente vital da arquitetura de microsserviços do sistema de gerenciamento de tarefas, trabalhando em conjunto com o microsserviço de tarefas para garantir que nenhuma atividade seja esquecida.

-----

## Microsserviço de Notificação

Este serviço é responsável por orquestrar o envio de notificações por e-mail, utilizando um **agendador (Cron Job)** para buscar tarefas pendentes e um **template dinâmico** para formatar a mensagem. Sua principal função é manter o usuário informado sobre seus compromissos, melhorando a produtividade.

### Tecnologias e Ferramentas

* **Java ☕ e Spring Boot:** A base do desenvolvimento, garantindo um ambiente robusto e escalável para o serviço.
* **Thymeleaf:** Utilizado para a criação de templates de e-mail **dinâmicos e elegantes**, permitindo personalizar o conteúdo com os dados da tarefa.
* **SMTP (Simple Mail Transfer Protocol):** O protocolo padrão para o envio de e-mails, configurado para integrar-se com o serviço de e-mail.
* **Lombok:** Ferramenta que reduz o código boilerplate, tornando a estrutura dos DTOs e classes mais limpa e legível.
* **Gradle:** Gerenciador de dependências e automação de build para um processo de desenvolvimento eficiente.
* **GitHub Actions:** Automatiza o pipeline de CI/CD (Integração e Entrega Contínuas), garantindo deploys rápidos e confiáveis.
* **Kanban (Trello):** Metodologia de gestão de projetos que ajuda a visualizar o fluxo de trabalho e organizar as tarefas do desenvolvimento.

-----

### Funcionalidades (Endpoints)

O microsserviço de notificação expõe um único endpoint, que permite o envio de e-mails de notificação, recebendo as informações da tarefa.

* **`POST /email`**: Envia um e-mail de notificação para um usuário com base nos dados de uma tarefa.

-----

## Próximos Passos

A arquitetura de microsserviços de gerenciamento de tarefas está em um estágio avançado de desenvolvimento. Os microsserviços de usuários e de tarefas já foram concluídos, e este microsserviço de notificação é o componente final para a automação de alertas. Com a comunicação entre serviços já estabelecida, a próxima etapa é consolidar a integração e focar na otimização, melhoria contínua da performance de toda a plataforma e criação do BFF (Back-End For Front-End) para facilitar a interação com as interfaces de usuário.

-----

## Como Executar o Projeto Localmente

**Pré-requisitos:**

* JDK 17 ou superior
* Configuração do seu serviço de e-mail (Gmail, SendGrid, etc.)

**Passos:**

1.  Clone este repositório:
    ```bash
    git clone https://github.com/DiegoReso/microservice-notification.git
    cd microservice-notification
    ```
2.  Configure suas variáveis de ambiente, como as credenciais do seu serviço de e-mail, em um arquivo `.env` ou nas configurações do seu ambiente de desenvolvimento.
3.  Execute a aplicação usando Gradle:
    ```bash
    ./gradlew bootRun
    ```
4.  A API estará disponível em `http://localhost:8082`.

-----