use ql_sinhvien;
select * from ql_sinhvien.sinh_vien;
-- lay ra danh sach lap top cua sinh vien co ten = Nguyễn Văn A
-- inner join
select * from lap_top inner join sinh_vien
                                 on lap_top.id_sinh_vien = sinh_vien.id
where sinh_vien.ho_ten = 'Nguyễn Văn A';

-- sub query
/*
 câu query nhỏ được lồng trong query to, giá trị của sub query
 sẽ được root query sử dụng làm bảng tạm hoặc một gia trị để so sánh
 */

select * from lap_top where lap_top.id_sinh_vien = (select sinh_vien.id from sinh_vien where ho_ten = 'Nguyễn Văn A');

/*
 Cách thiết kế database
- đề bài thiết kế database phục vụ chức năng trang home, detail sản phẩm của hệ thống https://atino.vn/

 b1. Tìm hiểu hệ thống, trong thực tế cần đọc tài liệu mô tả yêu cầu, hoặc giao diện Ui của chức năng nếu có, tham khảo
 các hệ thống tương tự có sẵn

 b2. Xác định các loại dữ liệu cần lưu vào hệ thống, đây là các dữ liệu thông tin từ cộ sống thực tế
    - dữ liệu về menu loại sản phẩm
    - sản phẩm, giá cả, chi tiết sản phẩm, ảnh sản phẩm, tên sản phẩm
    - Hệ thống cửa hàng
    - Thông tin công ty
    - thông tin mạng xã hội

 b3 xác định ra các thuc thể từ các dữ liệu đã được xác định của bước 2
    * entity ( chính là các đối tượng ngoài đời sống, dữ liệu được ánh xạ vào trong lập trình
        - Loại sản phẩm (category) : chuyên lưu trữ thông tin của loại sản phẩm
                                    + tên
                                    + ngày tạo
        - Sản phẩm (Production) : Chuyên lưu trữ các thông tin về sản phẩm
                                    + tên, giá, ảnh, kích thước, màu sắc, số lượng, mô tả
            => tách ra 1 thực thể nưa chi tiết sản phẩn (production detail )
                                + lưu thông tin của chi tiết các sản phẩm ứng với màu sắn, size, hình ảnh, so lượng
                                vd:
                                    cùng 1 sản phẩm áo polo link https://atino.vn/ao-polo-regular-l.3.3439-p37926475.html
                                        + 3 loại màu sắc, 5 loại size => ít nhất sẽ có bao nhiêu sản phẩm ? = 3 * 5 = 15 sp
        - Hệ thống cửa hàng (Branch): lưu trữ thông tin về các chi nhánh hệ thống cửa hàng
                                + tên, địa chỉ, mail, số điện thoại
        - Hệ thống cửa hàng (Company Info): Lưu trữ thông tin công ty
                                + Tên, địa chỉ, hotline, logo, mã số doanh nghiệp, mail, các hình ảnh giới thiệu công ty
        - thông tin mạng xã hội (social): Lưu trữ thông tin về các trang mạng xã hội, phục vụ maketing
                                + tên, logo, link, admin
        - Hình ảnh (Image) : Lưu trữ thông tin hình ảnh, logo, của hệ thống
                                + tên, định dạng, đường dẫn lưu
        - Màu sắc (Color) : Thông tin về màu sắc
                            + tên, hình ảnh
        - Kích thước(Kích thước) : Thông tin về kích thước
                            + tên, size, loại
 b4 Xác định mối quan hệ của các thực thể và xây dựng sơ đồ thực thể liên kết (Entity Relationship diagram) từ thông tin các thực thể ở bước 3
    - các mối quan hệ
        1 -n : 1 nhiều
        n - 1: nhiều 1
        n - n: nhiều nhiều
        1 - 1:
 Xác định quan hệ giua các thực thể ?
        - category - production : 1 - n
        - branch - category : n - n
        - company info - social : 1 - n
        - branch - social : 1 - n
        - production - image : n - n
        - production - color: n - n
        - prodcution - size : n - n
            entity trung gian chinh la production detail

 b5 tư sơ đồ thực thể liên kế (Entity Relationship diagram ) -> chuyển sang các table trong database với quy tắc
    - các thực thể tương tứng với các table
    - thuộc tính của thực thể => các colum table
    - mối quan hệ của các thực thể -> khóa ngoại của table

 b6 viết sql tạo table
 */