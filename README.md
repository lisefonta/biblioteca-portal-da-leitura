Portal da Leitura - Projeto pronto para rodar (Spring Boot + H2)

Como usar localmente:
1. Tenha Java 17+ e Maven instalados.
2. No terminal, rode:
   mvn clean package -DskipTests
   java -jar target/portal-da-leitura-0.0.1-SNAPSHOT.jar
3. Abra no navegador: http://localhost:8080/index.html
4. H2 Console: http://localhost:8080/h2-console
   - JDBC URL: jdbc:h2:mem:portal
   - User: sa
   - Password: (vazio)

Deploy no Railway:
1. Suba este repo para o GitHub (ou conecte diretamente).
2. No Railway, crie novo projeto e escolha deploy via GitHub.
3. Railway vai executar o build com Maven. O Procfile já está presente.
