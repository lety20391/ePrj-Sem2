use Sem2_Project_Group2
go
select * from Collaborator

insert into Account(ID, Password, Type, Question, Answer) values 
('Co01', 'abc123', 'Co', 'Dog Name' , 'Duy'),
('Co02', 'abc123', 'Co', 'Dog Name' , 'Min'), 
('Gu01', 'abc123', 'Gu', 'Dog Name' , 'Be'),
('Gu02', 'abc123', 'Gu', 'Dog Name' , 'Lu')
go

update Account set Question = 'What is name of your pet ?' where ID = 'Co01'
update Account set Question = 'What is name of your favorite film ?' where ID = 'Co02'
update Account set Question = 'What is name of your pet ?' where ID = 'Gu01'
update Account set Question = 'What is name of your best friend ?' where ID = 'Gu02'
go

insert into Account(ID, Password, Type, Question, Answer) values
('Ad01', 'abc123', 'Co', 'What is name of your favorite film ?' , 'ffvii')
go
update Account set Type = 'Ad' where ID = 'Ad01'
go
select * from Account
go
insert into Collaborator(IDCo, NameCo, AddressCo, DOBCo, IdentificationNumberCo, DepositCo, PhoneCo, EmailCo, StatusCo, ImageCo) values
('Co01', 'Duy', 'Q5', '2005-12-20',  '1234', 123, '12345', 'email', 'Normal', 'Link' ),
('Co02', 'Duyen', 'Q10', '2005-12-30', '1234', 123, '12345', 'email', 'Normal', 'Link' )
go

insert into Guest values
('Gu01', 'Dat le', '1995-5-5', '1234456', '012345', 'datle@hetle.com', 'Normal', 'Co01'),
('Gu02', 'Duyen tran truong', '2005-5-5', '566890', '0234435', 'duyenbede@bede.com', 'Normal', 'Co02')
go

insert into Supplier values
('Su01', 'Sup 1' , 'Q10', '12345', 'Sup@sup.vn', 'Normal'),
('Su02', 'Sup 2' , 'Q15', '12345', 'Sup@sup.com.vn', 'Normal')
go

insert into Services values
('Se01', 'Giat ui', 1000),
('Se02', 'Lau nha', 2000)

insert into Apartment values
('Ap01', 'A01', 'Q10', 'Link', '2 giuong', 'Trong', 1000, 'Su01'),
('Ap02', 'A02', 'Q5', 'Link', '1 giuong', 'Co nguoi', 2000, 'Su02')
go

insert into Holding values
('Ho01', 'Gu01', 'Ap01', 'Co01', '2018-5-5', '2018-6-6', '2018-6-12', 'Chua thanh toan', 10000, 100, 'Se01'),
('Ho02', 'Gu02', 'Ap02', 'Co02', '2018-3-5', '2018-7-6', '2018-7-12', 'Da thanh toan', 6000, 60, 'Se02')
go

insert into [Contract] values
('Con01', '2018-6-3', 'Ho01', 9500, 'Da xac nhan'),
('Con02', '2018-6-1', 'Ho02', 6000, 'waiting')
go

insert into FeedbackNote values
('Fb01', '2018-5-5', 'Gu01', 'Ap01', 'Thieu tien ich', 'unread'),
('Fb02', '2018-6-5', 'Gu02', 'Ap02', 'Nha hang xom qua on', 'read')
go

insert into [Notification] values
('Not01', 'Gu01', 'Dat phong thanh cong', 'unread', 'Link Frame'),
('Not02', 'Gu02', 'Sap het han thanh toan', 'read', 'Link Frame')

select * from Collaborator
go






