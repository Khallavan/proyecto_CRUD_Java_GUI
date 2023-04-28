/*
 * Script
 * Database App
 * @Author Javier Sebastian Morales Solano
*/
create database application;

use application;
create table inventory(
	item_name varchar(30),
    model varchar(80) not null,
    quantity bigint,
    iva float, -- IVA del 19% 
    neto_value float,
    brute_value float, 
    primary key (model)
);
 
insert into inventory (item_name, model, quantity, iva, neto_value, brute_value)
value ("a", "hj2727", 2, 950.0,5000.0, 5950.0);
