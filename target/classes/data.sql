INSERT INTO pessoa_tb (cpf, nome)
VALUES
  	('56637927082', 'Pessoa 1'),
  	('56637927082', 'Pessoa 2'),
  	('56637927089', 'Adm');



INSERT INTO produto_tb (descricao, valor_unitario)
VALUES
  	('Produto 1', 10.0),
  	('Produto 2', 20.0),
  	('Produto 3', 20.0);


INSERT INTO pedido_tb(ID_Pessoa, valor_total)
 VALUES
	('1', 120.00),
    ('2', 140.00),
    ('3', 50.00),
    ('1', 14.00);


INSERT INTO pedido_item_tb (quantidade, ID_Pedido, valor_total, ID_Produto) 
VALUES
	(12, 1, 120.00, 1),
    (7 ,2, 140.00, 2),
    (4, 2, 80.00, 3),
    (5, 3, 50.00, 1);