use Sem2_Project_Group2
go

alter table Apartment
add IDSup varchar(20) not null
go

create table Supplier
(
	IDSup varchar(20),
	NameSup nvarchar(30) not null,
	[AddressSup] nvarchar(50) not null,
	PhoneSup varchar(11) not null,
	EmailSup varchar(50) not null,
	StatusSup varchar(20) not null,
	constraint pk_Supplier primary key (IDSup)
)

go
alter table Apartment
add constraint fk_Apartment_Supplier foreign key (IDSup) references Supplier(IDSup)

go
create table Services
(
	IDSer varchar(20) not null,
	NameSer nvarchar(30) not null,
	Price money not null,
	constraint pk_Services primary key (IDSer)
)

go
alter table Holding
add IDSer varchar(20)

go
alter table Holding
add constraint fk_Holding_Services foreign key (IDSer) references Services(IDSer)