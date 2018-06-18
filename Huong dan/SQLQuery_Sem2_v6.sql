use master
go
drop database Sem2_Project_Group2
go

create database Sem2_Project_Group2
go

use Sem2_Project_Group2
go

/* Tao bang tai khoan */
create table Account
(
	ID varchar(20),
	[Password] varchar(20) not null,
	[Type] varchar(3) not null,
	Question varchar(100) not null,
	Answer varchar(100) not null,
	Active bit not null,
	constraint pk_Taikhoan primary key (ID)
)
go



/* Tao bang cong tac vien */
create table Collaborator
(
	IDCo varchar(20),
	NameCo nvarchar(30) not null,
	[AddressCo] nvarchar(50) not null,
	DOBCo date not null,
	IdentificationNumberCo varchar(12) not null,
	DepositCo money not null,
	PhoneCo varchar(11) not null,
	EmailCo varchar(50) not null,
	[ImageCo] varchar(100) not null,
	GradeCo varchar(20) not null,
	NumberOfGuest int not null
	constraint pk_Collabrator primary key (IDCo),
	constraint fk_Collabrator_Account foreign key (IDCo) references Account(ID)
)
go


create table Guest
(
	IDGu varchar(20),
	NameGu nvarchar(50) not null,
	DOBGu date not null,
	IdentificationNumberGu varchar(12) not null,
	PhoneGu varchar(11) not null,
	EmailGu varchar(50) not null,
	ImageGu varchar(100) not null,
	StatusGu varchar(20) not null,
	constraint pk_Guest primary key (IDGu),
	IDCo varchar(20) null,
	constraint fk_Guest_Collaborator foreign key (IDCo) references Collaborator(IDCo),
	constraint fk_Guest_Account foreign key (IDGu) references Account(ID)
)
go


create table Apartment
(
	IDApa varchar(20),
	NameApa varchar(10) not null,
	AddressApa varchar(50) not null,
	ImageApa varchar(100) not null,
	InfoApa nvarchar(150) not null,
	StatusApa varchar(50) not null,
	PriceApa money not null,
	BookCo varchar(20),
	constraint pk_Apartment primary key (IDApa)
	/*constraint fk_Apartment_Account foreign key (BookCo) references Account(ID)	*/
)
go

create table FeedbackNote
(
	IDFb varchar(20) not null,
	DateFb date not null,
	IDGu varchar(20) not null,
	IDApa varchar(20) not null,
	ContentFb nvarchar(1000) not null,
	StatusFb varchar(30) not null,
	constraint pk_FeedbackNote primary key (IDFb),
	constraint fk_FeedbackNote_Guest foreign key (IDGu) references Guest(IDGu),
	constraint fk_FeedbackNote_Apartment foreign key (IDApa) references Apartment(IDApa)
)
go


create table Holding
(
	IDHo varchar(20) not null,
	IDGu varchar(20) not null,
	IDApa varchar(20) not null,
	IDCo varchar(20) null,
	DateHo date not null,	
	FromDateHo date not null,
	ToDateHo date not null,
	PayStatusHo varchar(20) not null,
	TotalHo money not null,
	CommissionHo money null,	
	constraint pk_Holding primary key (IDHo),
	constraint fk_Holding_Guest foreign key (IDGu) references Guest(IDGu),
	constraint fk_Holding_Apartment foreign key (IDApa) references Apartment(IDApa),
	constraint fk_Holding_Collaborator foreign key (IDCo) references Collaborator(IDCo)
)
go

create table Contract
(
	IDCon varchar(20) not null,
	DateCon date not null,
	IDHo varchar(20) not null,
	PriceCon money not null,
	StatusCon varchar(20) not null,
	constraint pk_Contract primary key (IDCon),
	constraint fk_Contract_Holding foreign key (IDHo) references Holding(IDHo)

)
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

go
create table [Notification]
(
	IDNot varchar(20) not null,
	IDAcc varchar(20) not null,
	DetailNot nvarchar(50) not null,
	StatusNot varchar(20) not null,
	Redirect varchar(20) not null,
	constraint pk_Notification primary key (IDNot),
	constraint fk_Notification_Account foreign key (IDAcc) references Account(ID)
)
go

select * from Account
go

