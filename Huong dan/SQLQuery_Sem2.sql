create database Sem2_Project_Group2
on primary
(
	name = 'Sem2_Project_Group2',
	filename = 'E:\NAM_FPT\Sem2\ePrj-Sem2\Huong dan\Sem2_Project_Group2.mdf',
	size = 5,
	maxsize = 5,
	filegrowth = 10%
)
log on
(
	name = 'Sem2_Project_Group2_lg',
	filename = 'E:\NAM_FPT\Sem2\ePrj-Sem2\Huong dan\Sem2_Project_Group2_lg.ldf',
	size = 2,
	maxsize = 2,
	filegrowth = 10%
)
go

use Sem2_Project_Group2
go

create table TaiKhoan
(
	ID varchar(20) primary key,
	Password varchar(20) not null,
	Type varchar(3) not null
)
go

create table CongTacVien
(
	IDctv varchar(20) primary key,
	HoTenctv varchar(50) not null,
	DOBctv date not null,
	CMNDctv varchar(12) not null,
	KyQuyctv money not null,
	SoDienThoaictv varchar(11) not null,
	Emailctv varchar(50) not null,
	Gradectv varchar(20) not null
)
go

create table KhachHang
(
	IDkh varchar(20) primary key,
	HoTenkh varchar(50) not null,
	DOBkh date not null,
	CMNDkh varchar(12) not null,
	SoDienThoaikh varchar(11) not null,
	Emailkh varchar(50) not null,
	Gradekh varchar(20) not null,
	IDctv varchar(20) foreign key references CongTacVien(IDctv) null
)
go

create table CanHo
(
	IDch varchar(20) primary key,
	Tinh_ThanhPhoch varchar(20) not null,
	Quan_Huyench varchar(20) not null,
	Diachi varchar(50) not null,
	PhongNguch int not null,
	WCch int not null,
	Tangch varchar(20) not null,
	LoaiPhongch varchar(20) not null,
	GiaThueNgaych money not null,
	Tinhtrangch varchar(10) not null,
	SucChuach int not null,
	IDkh varchar(20) foreign key references KhachHang(IDkh) null
)
go

create table Feedback
(
	IDfb varchar(20) primary key not null,
	IDkh varchar(20) foreign key references KhachHang(IDkh) not null,
	IDch varchar(20) foreign key references CanHo(IDch) not null,
	NoiDungfb varchar(1000) not null,
	TinhTrangXuLyfb varchar(30) not null
)
go


create table ThongTinHopDong
(
	Code varchar(10) primary key,
	IDkh varchar(20) foreign key references KhachHang(IDkh) not null,
	IDch varchar(20) foreign key references CanHo(IDch) not null,
	IDctv varchar(20) foreign key references CongTacVien(IDctv) null,
	TinhTrangThanhToan varchar(20) not null,
	NgayBatDau date not null,
	NgayKetThuc date not null,
	TongTien money not null,
	HoaHong varchar(20) null,
	IDfb varchar(20) foreign key references Feedback(IDfb) null
)
go
