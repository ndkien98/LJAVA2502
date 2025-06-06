
create database insurance_claim;
use insurance_claim;
INSERT INTO users (
    created_by, created_date, deleted,
    last_modified_by, last_modified_date,
    address, email, first_name, last_name,
    mime_type, password, path_avatar,
    phone, username
)
VALUES
-- 1
('admin', '2024-01-10 08:15:00', 0, 'admin', '2024-01-12 09:30:00',
 '123 Lê Lợi, Quận 1, TP.HCM', 'nguyen.an@example.com', 'Nguyễn', 'An',
 'image/png', 'hashed_password_1', '/avatars/user1.png', '0901234567', 'nguyen.an'),

-- 2
('admin', '2024-02-14 14:00:00', 0, 'admin', '2024-02-15 16:20:00',
 '45 Hoàng Văn Thụ, Đà Nẵng', 'tran.binh@example.com', 'Trần', 'Bình',
 'image/jpeg', 'hashed_password_2', '/avatars/user2.jpg', '0912345678', 'tran.binh'),

-- 3
('admin', '2024-03-01 09:45:00', 0, 'admin', '2024-03-05 10:10:00',
 '12 Nguyễn Huệ, Hà Nội', 'le.chi@example.com', 'Lê', 'Chi',
 'image/png', 'hashed_password_3', '/avatars/user3.png', '0923456789', 'le.chi'),

-- 4
('admin', '2024-03-20 11:30:00', 0, 'admin', '2024-03-21 13:00:00',
 '78 Trần Phú, Hải Phòng', 'pham.dung@example.com', 'Phạm', 'Dũng',
 'image/jpeg', 'hashed_password_4', '/avatars/user4.jpg', '0934567890', 'pham.dung'),

-- 5
('admin', '2024-04-01 08:00:00', 0, 'admin', '2024-04-03 09:10:00',
 '56 Nguyễn Trãi, Cần Thơ', 'doan.ha@example.com', 'Doãn', 'Hà',
 'image/png', 'hashed_password_5', '/avatars/user5.png', '0945678901', 'doan.ha'),

-- 6
('admin', '2024-04-05 10:00:00', 0, 'admin', '2024-04-06 11:00:00',
 '90 Lê Duẩn, Đà Nẵng', 'vu.hoa@example.com', 'Vũ', 'Hoa',
 'image/png', 'hashed_password_6', '/avatars/user6.png', '0956789012', 'vu.hoa'),

-- 7
('admin', '2024-04-08 12:00:00', 0, 'admin', '2024-04-09 13:00:00',
 '33 Phan Đình Phùng, Huế', 'dang.khoa@example.com', 'Đặng', 'Khoa',
 'image/jpeg', 'hashed_password_7', '/avatars/user7.jpg', '0967890123', 'dang.khoa'),

-- 8
('admin', '2024-04-10 14:00:00', 0, 'admin', '2024-04-11 15:00:00',
 '77 Nguyễn Văn Linh, Hà Nội', 'phan.linh@example.com', 'Phan', 'Linh',
 'image/png', 'hashed_password_8', '/avatars/user8.png', '0978901234', 'phan.linh'),

-- 9
('admin', '2024-04-12 16:00:00', 0, 'admin', '2024-04-13 17:00:00',
 '88 Tôn Đức Thắng, TP.HCM', 'ngo.minh@example.com', 'Ngô', 'Minh',
 'image/jpeg', 'hashed_password_9', '/avatars/user9.jpg', '0989012345', 'ngo.minh'),

-- 10
('admin', '2024-04-14 18:00:00', 0, 'admin', '2024-04-15 19:00:00',
 '22 Hai Bà Trưng, Đà Lạt', 'trinh.nam@example.com', 'Trịnh', 'Nam',
 'image/png', 'hashed_password_10', '/avatars/user10.png', '0990123456', 'trinh.nam'),

-- 11
('admin', '2024-04-16 08:30:00', 0, 'admin', '2024-04-17 09:30:00',
 '44 Pasteur, Nha Trang', 'hoang.phuc@example.com', 'Hoàng', 'Phúc',
 'image/jpeg', 'hashed_password_11', '/avatars/user11.jpg', '0901122334', 'hoang.phuc'),

-- 12
('admin', '2024-04-18 10:30:00', 0, 'admin', '2024-04-19 11:30:00',
 '19 Trần Hưng Đạo, Hải Dương', 'mai.quyen@example.com', 'Mai', 'Quyên',
 'image/png', 'hashed_password_12', '/avatars/user12.png', '0912233445', 'mai.quyen'),

-- 13
('admin', '2024-04-20 12:30:00', 0, 'admin', '2024-04-21 13:30:00',
 '20 Nguyễn Tất Thành, Quy Nhơn', 'bui.quang@example.com', 'Bùi', 'Quang',
 'image/jpeg', 'hashed_password_13', '/avatars/user13.jpg', '0923344556', 'bui.quang'),

-- 14
('admin', '2024-04-22 14:30:00', 0, 'admin', '2024-04-23 15:30:00',
 '99 Lê Hồng Phong, Vũng Tàu', 'vo.tam@example.com', 'Võ', 'Tâm',
 'image/png', 'hashed_password_14', '/avatars/user14.png', '0934455667', 'vo.tam'),

-- 15
('admin', '2024-04-24 16:30:00', 0, 'admin', '2024-04-25 17:30:00',
 '11 Bạch Đằng, Hội An', 'duong.hoai@example.com', 'Dương', 'Hoài',
 'image/jpeg', 'hashed_password_15', '/avatars/user15.jpg', '0945566778', 'duong.hoai'),

-- 16
('admin', '2024-04-26 08:15:00', 0, 'admin', '2024-04-27 09:15:00',
 '101 Nguyễn Du, Quảng Ngãi', 'nguyen.yen@example.com', 'Nguyễn', 'Yến',
 'image/png', 'hashed_password_16', '/avatars/user16.png', '0956677889', 'nguyen.yen'),

-- 17
('admin', '2024-04-28 10:15:00', 0, 'admin', '2024-04-29 11:15:00',
 '66 Trường Chinh, TP.HCM', 'cao.tien@example.com', 'Cao', 'Tiến',
 'image/jpeg', 'hashed_password_17', '/avatars/user17.jpg', '0967788990', 'cao.tien'),

-- 18
('admin', '2024-04-30 12:15:00', 0, 'admin', '2024-05-01 13:15:00',
 '100 Hùng Vương, Hà Nội', 'truong.lan@example.com', 'Trương', 'Lan',
 'image/png', 'hashed_password_18', '/avatars/user18.png', '0978899001', 'truong.lan'),

-- 19
('admin', '2024-05-02 14:15:00', 0, 'admin', '2024-05-03 15:15:00',
 '88 Võ Văn Kiệt, Cần Thơ', 'luu.nhat@example.com', 'Lưu', 'Nhật',
 'image/jpeg', 'hashed_password_19', '/avatars/user19.jpg', '0989900112', 'luu.nhat'),

-- 20
('admin', '2024-05-04 16:15:00', 0, 'admin', '2024-05-05 17:15:00',
 '55 Hòa Bình, Buôn Ma Thuột', 'ha.thanh@example.com', 'Hà', 'Thanh',
 'image/png', 'hashed_password_20', '/avatars/user20.png', '0990011223', 'ha.thanh');


INSERT INTO roles (code, name) VALUES
                                   ('ADMIN', 'Administrator'),
                                   ('USER', 'Standard User'),
                                   ('MOD', 'Moderator');

INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (4, 1);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (7, 1);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (10, 1);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (13, 1);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (16, 1);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (19, 1);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (5, 2);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (8, 2);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (11, 2);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (14, 2);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (17, 2);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (20, 2);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (3, 3);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (6, 3);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (9, 3);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (12, 3);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (15, 3);
INSERT INTO insurance_claim.user_roles (user_id, role_id) VALUES (18, 3);
