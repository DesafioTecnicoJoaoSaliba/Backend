## Intruções de uso
- Na raiz do projeto acesse a pasta de infra/sqlServer e rode o arquivo docker-compose
   ```
   dokcer-compose up -d 
   ```
- Acesse pasta src e rode
  ```
  mvn clean package
  ```

- em seguida 
  ```
  mvn spring-boot:run
  ```
    
## Ferramentas e Tecnologias
- Backend: Java 17+ com Spring Boot 3.2+
- Banco de Dados: SqlServer 2019.
- Documentar a API : Swagger.
    - <http://localhost:8080/swagger-ui.html#>