insert into invoice
values(1,'Monde', '2018-08-13',15);

insert into invoice
values(2,'Hans','2018-08-13',15);

insert into line_item(ID, QUANTITY, DESCRIPTION,UNIT_PRICE, INVOICE_ID)
values(1, 10, 'water coller', 12 , 1)