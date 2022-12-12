### Requisitos
```Java 18```

### Como rodar
```mvn spring-boot:run```

### Endpoints:
http://localhost:8080/pessoas/listar

http://localhost:8080/pessoas/listar/alfabetico

http://localhost:8080/pedidos/listar

http://localhost:8080/pedidos/listar/total

http://localhost:8080/pedidos/listar/{idCliente}

http://localhost:8080/produtos/listar

http://localhost:8080/produtos/listar/preco


### Script criacao tabelas:
```schema.sql```

### Scripts carga de dados:
```data.sql```

### Acesso a console banco de dados:
URL: ```http://localhost:8080/h2```  
JDBC URL:: ```jdbc:h2:mem:testdb```  
User Name: ```sa```  
Password: ``
