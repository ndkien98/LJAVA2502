
/*
 1.	Tạo cơ sở dữ liệu:
o	Tạo cơ sở dữ liệu có tên QL_SINHVIEN (nếu chưa tồn tại).
2.	Tạo các bảng trong cơ sở dữ liệu:
o	Tạo bảng SinhVien với các trường:
	id (khóa chính, kiểu INT, tự động tăng),
	ho_ten (kiểu VARCHAR, không được để trống),
	ngay_sinh (kiểu DATE),
	gioi_tinh (kiểu VARCHAR),
	dia_chi (kiểu VARCHAR),
	email (kiểu VARCHAR, phải là duy nhất),
	diem_trung_binh (kiểu DECIMAL, làm tròn đến 2 chữ số thập phân).
o	Tạo bảng MonHoc với các trường:
	id_mon (khóa chính, kiểu INT, tự động tăng),
	ten_mon (kiểu VARCHAR),
	so_tin_chi (kiểu INT).
o	Tạo bảng DiemThi với các trường:
	id_diem (khóa chính, kiểu INT, tự động tăng),
	id_sinhvien (khóa ngoại tham chiếu đến id trong bảng SinhVien),
	id_mon (khóa ngoại tham chiếu đến id_mon trong bảng MonHoc),
	diem (kiểu DECIMAL).
 */

create database QL_SINHVIEN;
use QL_SINHVIEN;
create table sinh_vien(
                          id int primary key auto_increment,
                          ho_ten nvarchar(50) not null ,
                          ngay_sinh date,
                          gioi_tinh varchar(10),
                          dia_chi nvarchar(255),
                          email varchar(50) unique ,
                          diem_trung_binh decimal
);

create table mon_hoc(
                        id int primary key auto_increment,
                        ten_mon nvarchar(255),
                        so_tin_chi integer
);

create table diem_thi(
                         id int auto_increment primary key ,
                         id_sinh_vien int,
                         id_mon int,
                         diem decimal
);

create table lap_top(
                        id int primary key auto_increment,-- auto_increment: giá trị id tự động tăng khi thêm mới 1 bản ghi vào table
                        ten varchar(100),
                        ngay_cap date,
                        id_sinh_vien int
);

alter table diem_thi
    add foreign key (id_sinh_vien) references sinh_vien(id);
alter table diem_thi
    add foreign key (id_mon) references mon_hoc(id);
alter table lap_top
    add foreign key (id_sinh_vien) references sinh_vien(id);
-- 3.	Thêm dữ liệu vào các bảng:
insert into sinh_vien (ho_ten, ngay_sinh, gioi_tinh, dia_chi, email, diem_trung_binh)
values
    ('Nguyễn Văn A','1998-01-02','Male','Hà Nội','a@gmail.com',7),
    ('Lê Anh B','1999-01-02','Female','Thanh Hóa','b@gmail.com',8),
    ('Hồ Văn C','1994-01-02','Male','Nghệ An','c@gmail.com',9),
    ('Vương Thị D','1995-01-02','Female','Bình Định','d@gmail.com',5),
    ('Nguyễn Thị R','1998-03-02','Female','Yên Bài','e@gmail.com',6);

INSERT INTO ql_sinhvien.mon_hoc (id, ten_mon, so_tin_chi) VALUES (1, 'Cấu trúc dữ liệu', 3);
INSERT INTO ql_sinhvien.mon_hoc (id, ten_mon, so_tin_chi) VALUES (2, 'Lập trình Java', 2);
INSERT INTO ql_sinhvien.mon_hoc (id, ten_mon, so_tin_chi) VALUES (3, 'Thể dục', 1);

INSERT INTO ql_sinhvien.diem_thi (id, id_sinh_vien, id_mon, diem) VALUES (1, 1, 1, 5);
INSERT INTO ql_sinhvien.diem_thi (id, id_sinh_vien, id_mon, diem) VALUES (2, 2, 2, 6);
INSERT INTO ql_sinhvien.diem_thi (id, id_sinh_vien, id_mon, diem) VALUES (3, 3, 3, 7);
INSERT INTO ql_sinhvien.diem_thi (id, id_sinh_vien, id_mon, diem) VALUES (4, 3, 1, 8);
INSERT INTO ql_sinhvien.diem_thi (id, id_sinh_vien, id_mon, diem) VALUES (5, 2, 2, 9);
INSERT INTO ql_sinhvien.diem_thi (id, id_sinh_vien, id_mon, diem) VALUES (6, 1, 3, 10);

INSERT INTO ql_sinhvien.lap_top (id, ten, ngay_cap, id_sinh_vien) VALUES (1, 'DELL001', '2025-04-08', 1);
INSERT INTO ql_sinhvien.lap_top (id, ten, ngay_cap, id_sinh_vien) VALUES (2, 'DELL002', '2025-04-08', 1);
INSERT INTO ql_sinhvien.lap_top (id, ten, ngay_cap, id_sinh_vien) VALUES (3, 'Mac001', '2025-04-08', 2);
INSERT INTO ql_sinhvien.lap_top (id, ten, ngay_cap, id_sinh_vien) VALUES (4, 'Mac002', '2025-04-08', 3);
INSERT INTO ql_sinhvien.lap_top (id, ten, ngay_cap, id_sinh_vien) VALUES (5, 'ThinkPad001', '2025-04-08', 3);


-- 4. Sử dụng câu lệnh update

-- 5.	Truy vấn dữ liệu:
-- 5.1
select * from sinh_vien;
-- 5.2
select * from mon_hoc;

-- 5.3 o	Hiển thị tên sinh viên, môn học và điểm thi của sinh viên đó từ bảng SinhVien  sử dụng join
-- inner join vd:
select * from sinh_vien
-- chỉ lấy những bản ghi có id vừa tồn tại ở bảng sinh viên và vừa tồn tại ở column id_sinh_vien bảng diem_thi
                  inner join diem_thi on sinh_vien.id = diem_thi.id_sinh_vien ;
-- chỉ lấy ra các sinh viên có laptop
select * from sinh_vien inner join lap_top on sinh_vien.id = lap_top.id_sinh_vien;
-- join không nhất thiết phải qua khóa ngoại, khóa ngoại chỉ để bảo tính toàn vẹn dữ liệu giữa các table quan hệ với nhau
select * from sinh_vien inner join lap_top on sinh_vien.ngay_sinh = lap_top.ngay_cap;

-- hiển thị tên sinh viên, tên mô học, điểm thi môn học đó của sinh viên
select ho_ten,mon_hoc.ten_mon,diem_thi.diem from sinh_vien
                                                     inner join diem_thi on diem_thi.id_sinh_vien = sinh_vien.id
                                                     inner join mon_hoc on mon_hoc.id = diem_thi.id_mon;

-- 5.2 o	Tìm tất cả các sinh viên có điểm trung bình lớn hơn 8.0
select * from sinh_vien where diem_trung_binh >  8;

-- 5.3 o	Liệt kê các môn học mà sinh viên có điểm thi dưới 5.0.
select * from mon_hoc
                  inner join diem_thi on mon_hoc.id = diem_thi.id_mon
where diem_thi.diem < 5;

-- 5.4 o	Đếm số lượng sinh viên có điểm thi môn học trên 6.0.
select count(id_sinh_vien) as so_luong_sinh_vien from diem_thi where diem > 6;

-- 6.1 o	Tìm tất cả sinh viên có điểm trung bình từ 7.0 đến 8.5 và giới tính là "Nam".
select * from sinh_vien where
    diem_trung_binh >= 7
                          and diem_trung_binh <= 8.5
                          and sinh_vien.gioi_tinh = 'Male';

select * from sinh_vien where sinh_vien.diem_trung_binh between 7 and 8
                          and sinh_vien.gioi_tinh = 'Male';

-- 6.1 o	Liệt kê tất cả sinh viên có email chứa "gmail.com" hoặc "yahoo.com".
select * from sinh_vien where sinh_vien.email like '%gmail.com%' or sinh_vien.email like 'yahoo.com';

-- 6.3 oSử dụng toán tử AND/OR để tìm sinh viên có điểm trung bình lớn hơn 6.5 và có ít nhất một môn thi điểm dưới 5.0.
-- 6.3.1) ít nhất một môn thi điểm dưới 5.0
select diem_thi.id_sinh_vien from diem_thi where diem_thi.diem < 5;

-- 6.3
select distinct sinh_vien.ho_ten from sinh_vien inner join diem_thi on sinh_vien.id = diem_thi.id_sinh_vien
where diem_thi.diem < 5 and sinh_vien.diem_trung_binh > 6.5;

-- 6.4 o	Đếm số lượng sinh viên có điểm thi môn học lớn hơn 6.0, nhóm theo môn học
select count(diem_thi.id_sinh_vien),mon_hoc.ten_mon from mon_hoc inner join diem_thi on diem_thi.id_mon = mon_hoc.id
where diem_thi.diem > 6 group by mon_hoc.ten_mon;
-- 6.5	Tính số sinh viên thi lại (điểm dưới 5.0) cho từng môn học
select count(diem_thi.id_sinh_vien),mon_hoc.ten_mon from mon_hoc inner join diem_thi on diem_thi.id_mon = mon_hoc.id
where diem_thi.diem < 5 group by mon_hoc.ten_mon ;


-- left join
/*
 - lấy tất cả dữ liệu của bảng phía bên trái, và những dữ liệu thỏa mãn
    điều kiện sau on của bảng phía bên phải
 - table left: là table phía trước left join
 - table right: laf table sau left join
 */
-- vd: lấy tất cả sinh viên và thông tin laptop của sinh viên đó,
-- lấy cả các sinh viên không có laptop
select sinh_vien.ho_ten,lap_top.ten from sinh_vien left join lap_top
                                                             on sinh_vien.id = lap_top.id;

-- right join
/*
 - lấy tất cả các dữ liệu ở bảng phía bên phải và các dữ liệu ở bảng phía
  bên trái khi thỏa mãn điều kiện on
  - table left: là table phía trước right join
 - table right: laf table sau right join
 */

-- vd: lấy tất cả các thông tin sinh viên và laptop,
-- chỉ lấy các sinh viên có laptop, và các laptop không thuộc về sinh viên nào
select sinh_vien.ho_ten,lap_top.ten from sinh_vien right join lap_top on sinh_vien.id = lap_top.id_sinh_vien;

-- cross join
/*
    - lấy dữ liệu của cả 2 table ghép vào nhau
    nếu có m dòng tại table left và n dòng tại table right
    => tổng số dòng cross join = m * n
 */

select * from sinh_vien cross join lap_top;