-- tạo database
create database quanlysinhvien;

-- chỉ định cho mysql biết đang sử dụng database nào
use quanlysinhvien; -- chỉ định cho mysql biết đang thao tác trên database user_manager

-- câu lệnh tạo table, đại diện lưu danh sachs các thực thể ví dụ thực thể sinh viên -> table sinh viên lưu danh sách sinh viên
create table sinhvien (
    -- tạo ra các colums
                          id integer primary key, -- id: tên cột, integer: kiểu dữ liệu column, primary key: chỉ định cột này là khóa chính
                          mssv varchar(50),-- tạo cột mã số sinh viên, kiểu dữ liệu varchar: kiểu dữ liệu không dấu( not utf-8), chiều dài không quá 50 ký tự
                          ho_ten nvarchar(50), -- tạo cột họ và tên, kiểu dữ liệu nvarchar: kiểu dữ liệu cho phép có dấu(utf-8), chiều dài không quá 50 ký tự
                          ngay_sinh date
);

-- sử dụng câu lệnh insert thêm dữ liệu vào table
insert into -- cú pháp khai bấo câu lệnh thêm mới dữ liệu
    sinhvien -- tên table muốn thêm
(id, mssv, ho_ten, ngay_sinh) -- các cột muốn thêm dữ liệu của table
    value -- từ khóa chỉ định phía sau là các giá trị thêm vào table
    (1,'SV001','Nguyễn Văn A','2025-04-15'); -- yyyy-mm-dd


insert into -- cú pháp khai bấo câu lệnh thêm mới dữ liệu
    sinhvien -- tên table muốn thêm
(id, mssv, ho_ten, ngay_sinh) -- các cột muốn thêm dữ liệu của table
values -- từ khóa chỉ định phía sau là danh sách các giá trị thêm vào table
(2,'SV002','Nguyễn Văn A','2025-04-15'), -- yyyy-mm-dd
(3,'SV003','Nguyễn Văn B','2028-04-15') -- yyyy-mm-dd
     ,(4,'SV004','Nguyễn Văn C','2027-04-15') -- yyyy-mm-dd
     ,(5,'SV005','Nguyễn Văn D','2025-04-15'); -- yyyy-mm-dd

-- câu lệnh update bản ghi trong database
-- update tên của bản ghi có id = 3
update -- cú pháp câu lệnh update
    sinhvien -- tên table muốn update bản ghi
set -- cú pháp set lại giá trị mới cho các colum
    ho_ten = 'Lê Thiên Tuấn'  -- set lại giá trị mới cho cột ho_ten của table sinh_vien
where  -- thêm điều kiện để tìm kiếm bản ghi muốn update
       id = 3; -- chỉ định giá trị của điều kiện: id =3 => chỉ tìm các bản ghi có id=3 để update

-- sử dụng câu lệnh select để truy vấn dữ liệu trong table
-- lấy tất cả dữ liệu của bảng sinh viên
select * from sinhvien; -- select: cú pháp câu lệnh query, *: lấy ra tất cả các cột của table, from: chỉ định tên table query, sinhvien: tên table
-- chỉ muốn lấy ra các cột nhất định như id, ho_ten
select id,ho_ten from sinhvien;
-- sử dụng where và các toán tử điều kiện để lọc dữ liệu
/**
  Các loại toán từ:
    = : bằng 1 giá trị nào đó
    > : só ánh lớn hơn
    >= : so sánh lớn hơn hoặc bằng
    <= : nhỏ hơn hoặc bằng
    like: tìm kiếm gần đúng
  Các loại mệnh đề:
    AND: chỉ trả về true khi tất cả các mệnh đề đều true, ngược lại trả về false
    OR : trả về true khi 1 trong các mệnh đề trả về true, ngược lại chỉ false khi tất cả các mệnh đề đều false
  kết luận:
    table sẽ trả ra dữ liệu khi tất cả các mệnh đề, toán tử phía sau where đều trả về true
 */
-- tìm sinh viên có giá trị id = 3
select * from sinhvien where id =3;
-- sinh viên viên có họ Nguyễn, sử dụng toán tử like để tìm gần đúng
select * from sinhvien where ho_ten like '%Nguyễn%';
/*
 %%: sẽ được sử dụng để bỏ quả tất cả các ký tự ở phía trước hoặc sau %, chỉ sử dụng các ký tự ở giữa %% để so sánh
 */

-- tìm kiếm sinh viên vừa có họ Nguyễn và id = 2
select * from sinhvien where ho_ten like '%Nguyễn%' and id = 2;

-- tim kiếm sinh viên có id = 2 hoặc họ lê
select * from sinhvien where id =2 or ho_ten like '%Lê%';

-- count(): đếm số lượng bản ghi
select count(*) from sinhvien; -- đếm tổgn số lượng bản ghi

-- group by: gom nhóm tất cả các bản ghi theo một cột nào đó
                               use quanlysinhvien;
select count(*),ngay_sinh from sinhvien group by ngay_sinh;

-- having: lọc tiếp các bản ghi sau khi đã group by
-- đếm các bản ghi ngày sinh có số lượng > 1
select count(*),ngay_sinh from sinhvien group by ngay_sinh having count(*) > 1;

/*
 Khóa chính (primary key):
    - là 1 cột được sử dụng để xác định tính duy nhất của dữ liệu trong table
    - dữ liệu của khóa chính luôn luôn duy nhất trong table
    - có thể có 1 hoặc nhiều khóa chính trong database

 Khóa ngoại:
    - được sử dụng để tạo ra các mối quan hệ giữa các table trong database
    - đảm bảo tính ràng buộc dữ liệu, tính đúng đẵn của dữ liệu trong cơ sở dữ liệu quan hệ
    - khóa có thể trùng nhau trong 1 table
 */

-- bảng lớp học
/*
 Muốn quan hệ bảng lớp học và bảng sinh viên
    1 - n: 1 lớp học có thể chứa được nhiều sinh viên, đứng từ góc độ lớp học
    1 - n: 1 sinh viên có thể học được nhiều lớp học
 => là mối quan hệ n - n : 1 lớp học chứa được nhiều sinh viên, 1 sinh viên học được nhiều lớp học
 */
-- LapTop
/*
 1 sinh viên có thể có nhiều laptop: 1 - n
 1 laptop chỉ thuộc về đúng 1 sinh viên duy nhất
 => đây là mối quan hệ 1 - n
 */

create table lap_top(
    id integer primary key auto_increment,-- auto_increment: giá trị id tự động tăng khi thêm mới 1 bản ghi vào table
    ten varchar(100),
    ngay_cap date,
    sinh_vien_id integer
);
/*
 làm sao để biết được 1 bản ghi laptop này thuộc về sinh viên nào
 => tạo khóa ngoại từ bảng lap_top có tên: sinh_vien_id
   sinh_vien_id:
     - là khóa ngoại tại bảng lap_top tham chiếu đến cột id của bảng sinh viên
     - sử dụng khóa ngoại này để xác định được bản ghi laptop đó thuộc về sinh viên nào
     - đảm bảo tính toàn vẹn dữ liệu rằng giá trị của cột sinh_vien_id bắt buộc phải thuộc vào tập giá trị của cột id trong bảng sinh_vien
 */
-- cách thêm khóa ngoại vào table
alter table lap_top
    add foreign key (sinh_vien_id) references sinhvien (id);

insert into lap_top (ten, ngay_cap, sinh_vien_id)
values
    ('Del','2025-04-01',1),
    ('Macbook','2025-04-01',2),
    ('Asua','2025-04-01',1);

select * from lap_top;

/*
 - 1 - n: quan hệ 1 nhiều
        vd: 1 lớp học có nhiều sinh viên
 - n - 1: mối quan hệ nhiều 1
        vd: nhiều laptop thuộc về 1 sinh viên
 - 1 - 1 : một - một
        vd: 1 căn cước chỉ thuộc về 1 người
  - n - n : mối quan hệ nhiều nhiều
        vd: 1 giảng viên dạy nhiều sinh viên, 1 sinh viên học nhiều giảng viên
        để biểu diễn được cần phải tạo ra 1 bảng trung gian
 */