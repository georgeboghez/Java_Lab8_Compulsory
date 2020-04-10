# Java_Lab8_Compulsory

## JDBC
Write an application that allows to connect to a relational database by using JDBC, submit SQL statements and display the results.

The main specifications of the application are:

## Compulsory

- Create a database having the name MusicAlbums using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.)
- Create a user with the name dba and the password sql
- Create the following tables (this example uses Java DB SQL Dialect):
```
create table artists(
    id integer not null generated always as identity (start with 1, increment by 1),
    name varchar(100) not null,
    country varchar(100),
    primary key (id)
);
create table albums(
    id integer not null generated always as identity (start with 1, increment by 1),
    name varchar(100) not null,
    artist_id integer not null references artists on delete restrict,
    release_year integer,
    primary key (id)
);
```
- Add the database driver to the project libraries.
- Create the singleton class Database that manages a connection to the database.
- Create the DAO class ArtistController, having the methods create(String name, String country) and findByName(String name).
- Create the DAO class AlbumController, having the methods create(String name, int artistId, int releaseYear) and findByArtist(int artistId).
- Implement a simple test using your classes.

![Screenshot](./"Screenshot (2).png")
