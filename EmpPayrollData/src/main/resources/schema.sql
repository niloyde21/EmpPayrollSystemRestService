create table empCredentials
(
   id integer not null, userName varchar(255) not null,
   password varchar(255) not null,
   primary key(id)
);

create table Staff_information (
id Integer not null,
first_name varchar(255) not null,
surname varchar(255) not null,
Dob varchar(255) not null,
Email varchar(255) not null,
Telephone varchar(255) not null,
Address varchar(255) not null,
Department varchar(255) not null,
Image varchar(255) null,
Salary varchar(255) not null,
Gender varchar(255) not null,
Address2 varchar(255) null,
Post_code varchar(255) not null,
Designation varchar(255) not null,
Status varchar(255) null,
job_title varchar(255) not null,
Apartment varchar(255) not null,
Date_hired varchar(255) null,
primary key(id)
);