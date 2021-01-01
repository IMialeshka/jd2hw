create database if not exists ListExpenses DEFAULT CHARACTER SET utf8;

create table if not exists ListExpenses.recivers(
num int not null primary key,
name varchar(255)
); 

create table if not exists ListExpenses.expenses (
num int AUTO_INCREMENT primary key,
paydate date not null,
receiver int,
value dec, 
constraint receiver foreign key (receiver) 
references ListExpenses.recivers(num)   
);

INSERT INTO `listexpenses`.`recivers`
(`num`,
`name`)
VALUES
(1,
'ОАО Рога и Копыта');


INSERT INTO `listexpenses`.`recivers`
(`num`,
`name`)
VALUES
(2,
'ЗАО Корона');

INSERT INTO `listexpenses`.`recivers`
(`num`,
`name`)
VALUES
(3,
'Латария');

INSERT INTO `listexpenses`.`recivers`
(`num`,
`name`)
VALUES
(4,
'ОАО МММ');

INSERT INTO `listexpenses`.`expenses`
(`num`,
`paydate`,
`receiver`,
`value`)
VALUES
(null,
'2011-05-10',
1,
20000);


INSERT INTO `listexpenses`.`expenses`
(`num`,
`paydate`,
`receiver`,
`value`)
VALUES
(null,
'2011-05-10',
2,
94000);

INSERT INTO `listexpenses`.`expenses`
(`num`,
`paydate`,
`receiver`,
`value`)
VALUES
(null,
'2011-05-11',
3,
10000);

INSERT INTO `listexpenses`.`expenses`
(`num`,
`paydate`,
`receiver`,
`value`)
VALUES
(null,
'2011-05-11',
2,
13000);

INSERT INTO `listexpenses`.`expenses`
(`num`,
`paydate`,
`receiver`,
`value`)
VALUES
(null,
'2011-05-12',
4,
2500);

