create database shop_book2;

use shop_book2;

INSERT INTO categories (categoryName, description)
VALUES
    ('Fiction', 'Các tác phẩm văn học hư cấu như tiểu thuyết, truyện ngắn'),
    ('Non-Fiction', 'Sách phi hư cấu bao gồm lịch sử, khoa học, v.v.'),
    ('Self-Help & Biography', 'Sách phát triển bản thân và tiểu sử nhân vật');


INSERT INTO products (author, description, discountPercent, genre, pageCount, price, publicationYear, publisher, stockQuantity, title, category_id)
VALUES
    ('George Orwell', 'Dystopian novel', 10.0, 'Fiction', 328, 15.99, 1949, 'Secker & Warburg', 50, '1984', 1),
    ('J.K. Rowling', 'Fantasy novel', 5.0, 'Fantasy', 309, 20.00, 1997, 'Bloomsbury', 100, 'Harry Potter and the Philosopher''s Stone', 1),
    ('Yuval Noah Harari', 'History of humankind', 15.0, 'History', 443, 25.50, 2011, 'Harvill Secker', 30, 'Sapiens', 2),
    ('F. Scott Fitzgerald', 'Classic American novel', 0.0, 'Fiction', 180, 10.00, 1925, 'Charles Scribner''s Sons', 40, 'The Great Gatsby', 1),
    ('Stephen Hawking', 'Science book', 20.0, 'Science', 256, 18.75, 1988, 'Bantam Books', 25, 'A Brief History of Time', 2),
    ('Jane Austen', 'Romantic novel', 0.0, 'Romance', 279, 12.50, 1813, 'T. Egerton', 60, 'Pride and Prejudice', 1),
    ('Michelle Obama', 'Autobiography', 10.0, 'Biography', 448, 22.00, 2018, 'Crown Publishing Group', 45, 'Becoming', 3),
    ('Mark Manson', 'Self-help book', 5.0, 'Self-help', 224, 14.99, 2016, 'HarperOne', 70, 'The Subtle Art of Not Giving a F*ck', 3),
    ('J.R.R. Tolkien', 'Epic fantasy novel', 0.0, 'Fantasy', 423, 21.00, 1954, 'Allen & Unwin', 80, 'The Fellowship of the Ring', 1),
    ('Dale Carnegie', 'Self-improvement classic', 8.0, 'Self-help', 291, 16.50, 1936, 'Simon and Schuster', 55, 'How to Win Friends and Influence People', 3);


-- Thêm dữ liệu vào bảng roles
INSERT INTO roles (deleted, role_name)
VALUES (0, 'ADMIN'),
       (0, 'USER'),
       (0, 'MODERATOR'),
       (0, 'GUEST');

-- Thêm dữ liệu vào bảng users
INSERT INTO users (active, password, username, age, created, fullName)
VALUES (1, 'pass123', 'john_doe', '30', '2023-01-01', 'John Doe'),
       (1, 'pass123', 'jane_smith', '28', '2023-01-02', 'Jane Smith'),
       (1, 'pass123', 'alice_wonder', '24', '2023-01-03', 'Alice Wonderland'),
       (1, 'pass123', 'bob_builder', '35', '2023-01-04', 'Bob Builder'),
       (1, 'pass123', 'charlie_day', '40', '2023-01-05', 'Charlie Day'),
       (1, 'pass123', 'diana_prince', '32', '2023-01-06', 'Diana Prince'),
       (1, 'pass123', 'edward_snow', '29', '2023-01-07', 'Edward Snow'),
       (1, 'pass123', 'fiona_apple', '27', '2023-01-08', 'Fiona Apple'),
       (1, 'pass123', 'george_bluth', '45', '2023-01-09', 'George Bluth'),
       (1, 'pass123', 'hannah_mont', '21', '2023-01-10', 'Hannah Montana'),
       (1, 'pass123', 'ian_wright', '34', '2023-01-11', 'Ian Wright'),
       (1, 'pass123', 'julia_roberts', '38', '2023-01-12', 'Julia Roberts'),
       (1, 'pass123', 'karl_marx', '50', '2023-01-13', 'Karl Marx'),
       (1, 'pass123', 'lisa_simpson', '22', '2023-01-14', 'Lisa Simpson'),
       (1, 'pass123', 'mike_tyson', '41', '2023-01-15', 'Mike Tyson');

-- Gán role cho từng user
INSERT INTO user_role (user_id, role_id)
VALUES (1, 1),
       (1, 2),  -- john_doe: ADMIN, USER
       (2, 2),  -- jane_smith: USER
       (3, 3),
       (3, 2),  -- alice_wonder: MODERATOR, USER
       (4, 4),  -- bob_builder: GUEST
       (5, 2),  -- charlie_day: USER
       (6, 1),
       (6, 2),  -- diana_prince: ADMIN, USER
       (7, 2),  -- edward_snow: USER
       (8, 3),
       (8, 2),  -- fiona_apple: MODERATOR, USER
       (9, 4),
       (9, 2),  -- george_bluth: GUEST, USER
       (10, 2), -- hannah_mont: USER
       (11, 1), -- ian_wright: ADMIN
       (12, 2), -- julia_roberts: USER
       (13, 3),
       (13, 1), -- karl_marx: MODERATOR, ADMIN
       (14, 4), -- lisa_simpson: GUEST
       (15, 1),
       (15, 2),
       (15, 3); -- mike_tyson: ADMIN, USER, MODERATOR