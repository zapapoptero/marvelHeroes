DROP TABLE IF EXISTS SuperHero;

CREATE TABLE SuperHero (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nombreHeroe VARCHAR(250) NOT NULL,
  nombreReal VARCHAR(250) NOT NULL,
  fuerza DOUBLE DEFAULT NULL
);

insert into SuperHero (id,nombreHeroe,nombreReal,fuerza)values(1, 'Spiderman','Peter Parker',129.35);
insert into SuperHero (id,nombreHeroe,nombreReal,fuerza)values(2, 'Capitan America','Steve Rogers',50.20);
insert into SuperHero (id,nombreHeroe,nombreReal,fuerza)values(3, 'Vision','Sigue Llamandose Vision',223.40);
insert into SuperHero (id,nombreHeroe,nombreReal,fuerza)values(4, 'Dr Strange','Steven Strange',200.35);
insert into SuperHero (id,nombreHeroe,nombreReal,fuerza)values(5, 'Wanda Maximof','Bruja Escarlata',229.35);
insert into SuperHero (id,nombreHeroe,nombreReal,fuerza)values(6, 'Thor','Sigue siendo Thor',500);
insert into SuperHero (id,nombreHeroe,nombreReal,fuerza)values(7, 'Hulk','Bruce Banner',300.46);
insert into SuperHero (id,nombreHeroe,nombreReal,fuerza)values(8, 'Magneto','Erik Lesher',15.35);
insert into SuperHero (id,nombreHeroe,nombreReal,fuerza)values(9, 'Profesor Xavier','Chales Xavier',1220.85);
insert into SuperHero (id,nombreHeroe,nombreReal,fuerza)values(10, 'Wolverine','Logan',300.95);
