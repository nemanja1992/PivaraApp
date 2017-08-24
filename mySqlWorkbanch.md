# Prvi-projekat
create schema `pivara`;


DROP TABLE IF EXISTS pivo;
DROP TABLE IF EXISTS pivara;


CREATE TABLE pivara(
pivara_id integer auto_increment,
naziv varchar(20),
pib varchar(13),
drzava varchar(20),
primary key (pivara_id)
);



CREATE TABLE pivo (
pivo_id integer auto_increment,
naziv varchar(20),
procenat_alkohola double,
ibu double,
kolicina integer,
pivara_id integer not null,
primary key (pivo_id,pivara_id),
foreign key (pivara_id)
	references pivara(pivara_id)
    on delete restrict
);
