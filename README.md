 🎮 GTA VI API (`GTA_VI_api`)

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)


## 📖 Sobre o Projeto

A **GTA VI API** é uma aplicação back-end RESTful desenvolvida em **Java** com **Spring Boot**, projetada para gerenciar dados inspirados no universo de **Grand Theft Auto VI**. 

O sistema fornece endpoints completos para operações de **CRUD** (*Create, Read, Update, Delete*) de **Armas**, **Missões**, **Veículos** e **Personagens**, persistindo as informações em um banco de dados relacional **MySQL** e retornando respostas padronizadas em **JSON** para integração com aplicações Front-end.

---

## 🏗️ Arquitetura do Projeto

O projeto está organizado no pacote `com.dt2.GTAVI` seguindo o padrão de camadas do Spring:

```text
src/main/java/com/dt2/GTAVI
├── controller/     # Camada REST: recebe requisições HTTP e devolve respostas em JSON
│   ├── ArmaController.java
│   ├── MissaoController.java
│   ├── PersonagemController.java
│   └── VeicolosController.java
├── entities/       # Camada de Modelo: classes mapeadas como tabelas no MySQL via JPA
│   ├── Arma.java
│   ├── Missao.java
│   ├── Personagem.java
│   └── Veicolos.java
└── repository/     # Camada de Dados: interfaces JpaRepository para operações SQL automáticas
    ├── ArmaRepository.java
    ├── MissaoRepository.java
    ├── PersonagemRepository.java
    └── VeicolosRepository.java
🔍 Como o código funciona por dentro:Entities (@Entity): Mapeiam as tabelas do banco de dados (Arma, Missao, Veicolos, Personagem). Utilizam @Id e @GeneratedValue(strategy = GenerationType.IDENTITY) para auto-incremento de chaves primárias no MySQL.Repositories (JpaRepository): Interfaces que herdam de JpaRepository, eliminando a necessidade de escrever queries SQL manuais para buscar (findAll, findById), salvar (save) e deletar (deleteById) registros.Controllers (@RestController): Controlam as rotas HTTP da aplicação:@GetMapping → Consulta todos os registros ou busca um item específico via @PathVariable int id.@PostMapping → Recebe um JSON no corpo da requisição (@RequestBody) e salva um novo registro no banco.@PutMapping("/{id}") → Localiza um registro pelo ID, atualiza seus atributos e salva as alterações.@DeleteMapping("/{id}") → Remove o registro correspondente ao ID informado.ResponseEntity → Garante o retorno correto dos status HTTP (200 OK, 400 Bad Request, 404 Not Found) junto ao corpo em JSON válido.📡 Documentação dos Endpoints🔫 Armas (/api/armas)MétodoRotaDescriçãoGET/api/armasLista todas as armas cadastradasGET/api/armas/{id}Busca uma arma específica pelo IDPOST/api/armasCadastra uma nova armaPUT/api/armas/{id}Atualiza os dados de uma arma existenteDELETE/api/armas/{id}Remove uma arma pelo IDExemplo de JSON (POST / PUT):JSON{
  "nome": "Glock 19mm",
  "categoria": "Pistola",
  "fabricante": "Glock",
  "descricao": "Pistola semiautomática compacta e confiável.",
  "imagem": "[https://exemplo.com/glock19.png](https://exemplo.com/glock19.png)"
}
🎯 Missões (/api/missoes)MétodoRotaDescriçãoGET/api/missoesLista todas as missões cadastradasGET/api/missoes/{id}Busca uma missão específica pelo IDPOST/api/missoesCadastra uma nova missãoPUT/api/missoes/{id}Atualiza os dados de uma missão existenteDELETE/api/missoes/{id}Remove uma missão pelo IDExemplo de JSON (POST / PUT):JSON{
  "nome": "Assalto em Vice City",
  "local": "Vice City",
  "dificudade": "Alta",
  "descricao": "Infiltração no banco central durante a noite.",
  "imagem": "[https://exemplo.com/missao.png](https://exemplo.com/missao.png)"
}
🚗 Veículos (/api/veiculos)MétodoRotaDescriçãoGET/api/veiculosLista todos os veículos cadastradosGET/api/veiculos/{id}Busca um veículo específico pelo IDPOST/api/veiculosCadastra um novo veículoPUT/api/veiculos/{id}Atualiza os dados de um veículo existenteDELETE/api/veiculos/{id}Remove um veículo pelo IDExemplo de JSON (POST / PUT):JSON{
  "nome": "Bugatti Chiron",
  "categoria": "Superesportivo",
  "marca": "Bugatti",
  "descricao": "Hipercarro de alta velocidade para fugas.",
  "imagem": "[https://exemplo.com/bugatti.png](https://exemplo.com/bugatti.png)"
}
⚙️ Como Executar o Projeto Localmente1. Pré-requisitosJava JDK 17 ou superiorMySQL Server ativo na porta 3306Maven (ou wrapper ./mvnw incluso no projeto)2. Instalação e ConfiguraçãoClone o repositório:Bashgit clone [https://github.com/IgorBarretodeLima/GTA_VI_api.git](https://github.com/IgorBarretodeLima/GTA_VI_api.git)
cd GTA_VI_api
Configure o arquivo src/main/resources/application.properties:Propertiesspring.application.name=GTAVI

spring.datasource.url=jdbc:mysql://localhost:3306/gtavi?createDatabaseIfNotExist=true&useTimezone=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Inicie a aplicação:Pela IDE (IntelliJ IDEA / Eclipse): Execute a classe principal da aplicação.Pelo terminal:Bash./mvnw spring-boot:run
Acesse a API:
O servidor iniciará por padrão em http://localhost:8080.👨‍💻 AutorDesenvolvido por Igor Barreto de Lima — GitHub
