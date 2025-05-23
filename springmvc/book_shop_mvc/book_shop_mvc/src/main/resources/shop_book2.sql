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
