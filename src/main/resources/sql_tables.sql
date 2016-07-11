/*CREATE TABLE User
(
username varchar(40) NOT NULL unique,
password varchar(20) NOT NULL,
PRIMARY KEY (username)
)

Create Table Follower
(
username varchar(40) not null,
followerName varchar(40) not null,
foreign key (username) references User(username),
foreign key (followerName) references User(username),
constraint follower_constrain unique(username,followerName)
)

Create Table Post
(
id int not null auto_increment,
owner varchar(40) not null,
data varchar(255) not null,
primary key (id),
foreign key (owner) references User(username)
)

create table UserRoles
(
id int(11) not null auto_increment,
username varchar(40) not null,
role varchar(45) not null,
primary key(id),
unique key user_role_unique(username,role),
foreign key(username) references User (username)
)*/
