
create database Sem2_Project_Group2
on primary
(
	name = 'Sem2_Project_Group2',
	filename = 'C:\Aptech\sql prj\Sem2_Project_Group2.mdf',
	size = 5MB,
	maxsize = 5MB,
	filegrowth = 10%
)

log on
(
	name = 'Sem2_Project_Group2_lg',
	filename = 'C:\Aptech\sql prj\Sem2_Project_Group2_lg.ldf',
	size = 2MB,
	maxsize = 2MB,
	filegrowth = 10%
)
go

use Sem2_Project_Group2
go

--create table TaiKhoan
--(
--	ID varchar(20) primary key,
--	[Password] varchar(20) not null,
--	[Type] varchar(3) not null
--)

create table TaiKhoan
(
	ID varchar(20),
	[Password] varchar(20) not null,
	[Type] varchar(3) not null,
	constraint pk_Taikhoan primary key (ID)
)
go

create table CongTacVien
(
	IDctv varchar(20),
	HoTenctv varchar(50) not null,
	DOBctv date not null,
	CMNDctv varchar(12) not null,
	KyQuyctv money not null,
	SoDienThoaictv varchar(11) not null,
	Emailctv varchar(50) not null,
	Gradectv varchar(20) not null,
	constraint pk_CTV primary key (IDctv),
	constraint fk_CongTacVien_TaiKhoan foreign key (IDctv) references TaiKhoan(ID)
)
go


create table KhachHang
(
	IDkh varchar(20),
	HoTenkh varchar(50) not null,
	DOBkh date not null,
	CMNDkh varchar(12) not null,
	SoDienThoaikh varchar(11) not null,
	Emailkh varchar(50) not null,
	Gradekh varchar(20) not null,
	constraint pk_KhachHang primary key (IDkh),
	IDctv varchar(20) null,
	constraint fk_KhachHang_CongTacVien foreign key (IDctv) references CongTacVien(IDctv),
	constraint fk_KhachHang_TaiKhoan foreign key (IDkh) references TaiKhoan(ID)
)
go


create table CanHo
(
	IDch varchar(20),
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
	IDkh varchar(20) null,
	constraint pk_CanHo primary key (IDch),
	constraint fk_CanHo_KhachHang foreign key (IDkh) references KhachHang(IDkh)
)
go

create table Feedback
(
	IDfb varchar(20) not null,
	IDkh varchar(20) not null,
	IDch varchar(20) not null,
	NoiDungfb varchar(1000) not null,
	TinhTrangXuLyfb varchar(30) not null,
	constraint pk_Feedback primary key (IDfb),
	constraint fk_Feedback_KhachHang foreign key (IDkh) references KhachHang(IDkh),
	constraint fk_Feedback_CanHo foreign key (IDch) references CanHo(IDch),
)
go


create table ThongTinHopDong
(
	Code varchar(10),
	IDkh varchar(20) not null,
	IDch varchar(20) not null,
	IDctv varchar(20) null,
	TinhTrangThanhToan varchar(20) not null,
	NgayBatDau date not null,
	NgayKetThuc date not null,
	TongTien money not null,
	HoaHong varchar(20) null,
	IDfb varchar(20) foreign key references Feedback(IDfb) null,
	constraint pk_ThongTinHopDong primary key (Code),
	constraint fk_ThongTinHopDong_KhachHang foreign key (IDkh) references KhachHang(IDkh),
	constraint fk_ThongTinHopDong_CanHo foreign key (IDch) references CanHo(IDch),
	constraint fk_ThongTinHopDong_CongTacVien foreign key (IDctv) references CongTacVien(IDctv)
)
go

