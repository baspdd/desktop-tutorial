create database TMDT
go
use TMDT
go
create table Information(
    info_id int primary key,
	[FullName] nvarchar(MAX) not null,
	[Address] nvarchar(MAX) not null,
	[Dob] date not null
)
create table [Role](
   role_id int primary key,
   role_name nvarchar(MAX) not null
)
create table account(
    account_id int identity(1,1) primary key,
	username nvarchar(MAX) not null,
	[password] nvarchar(MAX) not null,
	email nvarchar(MAX) not null,
	role_id int references [Role](role_id),
	infor_id int references Information(info_id)
)
create table [Type](
    [type_id] int primary key,
	[type_name] nvarchar(MAX) not null
)

create table [Product](
    product_id int primary key identity(1,1),
	product_name nvarchar(MAX) not null,
	[image] nvarchar(MAX) not null,
	price money not null,
	quantity int not null,
	original nvarchar(MAX) not null,
	[description] nvarchar(MAX) not null,
	[type_id] int references [Type]([type_id])
)

create table [Order](
    order_id int primary key,
	account_id int references account(account_id),
	product_id int references [Product](product_id),
	quantity int not null
)

create table comment(
   comment_id int primary key,
   account_id int references account(account_id),
   product_id int references [Product](product_id),
   content nvarchar(MAX) not null,
   [date] date not null
)