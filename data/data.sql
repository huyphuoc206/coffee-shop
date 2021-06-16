-- Payment data

INSERT INTO payment (name, status) VALUES ('Tiền mặt', '1');
INSERT INTO payment (name, status) VALUES ('Momo', '1');
INSERT INTO payment (name, status) VALUES ('ZaloPay', '1');

-- Size data

INSERT INTO size (name) VALUES ('Nhỏ');
INSERT INTO size (name) VALUES ('Vừa');
INSERT INTO size (name) VALUES ('Lớn');

-- User data

INSERT INTO users (fullname, email, phone, address, gender, birthday, status, username, password, role, createddate)
VALUES ('Huy Phước', 'huyphuoc@gmail.com', '0919553993', 'Tp.HCM', 'MALE', '23-6-2000', '1', 'php','123456', 'USER', NOW());
INSERT INTO users (fullname, email, phone, address, gender, birthday, status, username, password, role, createddate)
VALUES ('Quang Anh', 'quanganh@gmail.com', '0919333195', 'Tp.HCM', 'MALE', '2-2-2000', '1', 'quanganh','123456', 'USER', NOW());
INSERT INTO users (fullname, email, phone, address, gender, birthday, status, username, password, role, createddate)
VALUES ('Nhật Tân', 'nhattan@gmail.com', '0938256934', 'Tp.HCM', 'MALE', '3-3-2000', '1', 'nhattan','123456', 'USER', NOW());
INSERT INTO users (fullname, email, phone, address, gender, birthday, status, username, password, role, createddate)
VALUES ('Nguyễn Văn A', 'vana@gmail.com', '0919223443', 'Tp.HCM', 'MALE', '2-6-1990', '1', 'nguyenvana','123456', 'ADMIN', NOW());

-- Category data

INSERT INTO category (name, status) VALUES ('Cà phê', '1');
INSERT INTO category (name, status) VALUES ('Sữa chua', '1');
INSERT INTO category (name, status) VALUES ('Sinh tố', '1');
INSERT INTO category (name, status) VALUES ('Nước ép', '1');
INSERT INTO category (name, status) VALUES ('Trà', '1');
INSERT INTO category (name, status) VALUES ('Soda', '1');

-- Drinks data
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Bạc xỉu', '/images/bacxiu.jpeg', '1', 1, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Barista', '/images/barista.jpeg', '1', 1, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Cà phê đen', '/images/capheden.jpeg', '1', 1, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Cà phê phin', '/images/caphephin.jpeg', '1', 1, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Cà phê sữa', '/images/caphesua.jpeg', '1', 1, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Capuchino', '/images/capuchino.jpeg', '1', 1, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Espresso', '/images/espresso.jpeg', '1', 1, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Latte', '/images/latte.jpeg', '1', 1, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Macchiato', '/images/macchiato.jpeg', '1', 1, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Sữa chua dâu', '/images/suachuadau.jpeg', '1', 2, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Sữa chua mít', '/images/suachuamit.jpeg', '1', 2, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Trân châu', '/images/suachuatranchau.jpeg', '1', 2, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Nếp cẩm', '/images/scnepcam.jpeg', '1', 2, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Việt quất', '/images/scvietquat.jpeg', '1', 2, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Nha đam', '/images/suachuanhadam.jpeg', '1', 2, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Sữa chua cam', '/images/sccam.jpg', '1', 2, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Sữa chua nho', '/images/scnho.jpg', '1', 2, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Sữa chua xoài', '/images/scxoai.jpg', '1', 2, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Sinh tố bơ', '/images/sinhtobo.jpeg', '1', 3, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Sinh tố chuối', '/images/sinhtochuoi.jpeg', '1', 3, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Sinh tố dâu', '/images/sinhtodau.jpeg', '1', 3, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Sinh tố dừa', '/images/sinhtodua.jpeg', '1', 3, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Sinh tố táo', '/images/sinhtotao.jpeg', '1', 3, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Sinh tố thơm', '/images/sinhtothom.jpeg', '1', 3, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Sinh tố xoài', '/images/sinhtoxoai.jpeg', '1', 3, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Sinh tố cam', '/images/sinhtocam.jpg', '1', 3, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Sinh tố Kiwi', '/images/sinhtokiwi.jpg', '1', 3, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Nước ép bưởi', '/images/NEbuoi.jpeg', '1', 4, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Nước ép xoài', '/images/NExoai.png', '1', 4, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Nước ép cà rốt', '/images/NEcarot.jpeg', '1', 4, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Nước ép cóc', '/images/NEcoc.jpeg', '1', 4, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Nước ép dứa', '/images/NEdua.jpeg', '1', 4, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Nước ép nho', '/images/NEnho.jpeg', '1', 4, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Nước ép ổi', '/images/NEoi.jpeg', '1', 4, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Nước ép táo', '/images/NEtao.jpeg', '1', 4, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Nước ép cam', '/images/NEcam.jpg', '1', 4, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Hồng trà ', '/images/hongtra.jpeg', '1', 5, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Trà bưởi', '/images/trabuoi.jpeg', '1', 5, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Trà chanh', '/images/trachanh.png', '1', 5, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Trà đào', '/images/tradao.jpeg', '1', 5, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Trà đào cam sả', '/images/tradaocamsa.jpeg', '1', 5, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Trà gừng', '/images/tragung.jpeg', '1', 5, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Trà Kiwi', '/images/trakiwi.jpeg', '1', 5, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Trà táo', '/images/tratao.jpeg', '1', 5, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Trà vài', '/images/travai.jpeg', '1', 5, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Soda vải', '/images/sodavai.jpeg', '1', 6, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Soda nho', '/images/sodanho.jpeg', '1', 6, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Soda Kiwi', '/images/sodakiwi.jpeg', '1', 6, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Soda dâu', '/images/sodadau.jpeg', '1', 6, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Soda chanh', '/images/sodachanh.jpeg', '1', 6, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Soda chanh dây', '/images/sodachanhday.jpeg', '1', 6, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Soda đào', '/images/sodadao.jpg', '1', 6, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Soda cam', '/images/sodacam.jpg', '1', 6, NOW());
INSERT INTO drinks (name, image, status, categoryid, createddate) VALUES ('Soda táo', '/images/sodatao.jpg', '1', 6, NOW());

-- Drink Details Data

INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (1, 2, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (1, 3, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (2, 2, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (2, 3, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (3, 2, 18000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (3, 3, 22000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (4, 2, 18000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (4, 3, 22000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (5, 2, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (5, 3, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (6, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (6, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (7, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (7, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (8, 2, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (8, 3, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (9, 2, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (9, 3, 40000);

INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (10, 1, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (10, 2, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (10, 3, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (11, 1, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (11, 2, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (11, 3, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (12, 1, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (12, 2, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (12, 3, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (13, 1, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (13, 2, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (13, 3, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (14, 1, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (14, 2, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (14, 3, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (15, 1, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (15, 2, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (15, 3, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (16, 1, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (16, 2, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (16, 3, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (17, 1, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (17, 2, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (17, 3, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (18, 1, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (18, 2, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (18, 3, 30000);

INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (19, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (19, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (19, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (20, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (20, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (20, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (21, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (21, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (21, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (22, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (22, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (22, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (23, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (23, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (23, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (24, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (24, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (24, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (25, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (25, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (25, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (26, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (26, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (26, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (27, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (27, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (27, 3, 35000);

INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (28, 1, 15000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (28, 2, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (28, 3, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (29, 1, 15000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (29, 2, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (29, 3, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (30, 1, 15000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (30, 2, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (30, 3, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (31, 1, 15000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (31, 2, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (31, 3, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (32, 1, 15000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (32, 2, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (32, 3, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (33, 1, 15000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (33, 2, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (33, 3, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (34, 1, 15000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (34, 2, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (34, 3, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (35, 1, 15000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (35, 2, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (35, 3, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (36, 1, 15000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (36, 2, 20000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (36, 3, 25000);

INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (37, 1, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (37, 2, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (37, 3, 40000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (38, 1, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (38, 2, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (38, 3, 40000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (39, 1, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (39, 2, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (39, 3, 40000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (40, 1, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (40, 2, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (40, 3, 40000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (41, 1, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (41, 2, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (41, 3, 40000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (42, 1, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (42, 2, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (42, 3, 40000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (43, 1, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (43, 2, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (43, 3, 40000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (44, 1, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (44, 2, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (44, 3, 40000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (45, 1, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (45, 2, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (45, 3, 40000);

INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (46, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (46, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (46, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (47, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (47, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (47, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (48, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (48, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (48, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (49, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (49, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (49, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (50, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (50, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (50, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (51, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (51, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (51, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (52, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (52, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (52, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (53, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (53, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (53, 3, 35000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (54, 1, 25000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (54, 2, 30000);
INSERT INTO drinkdetails (drinkid, sizeid, price) VALUES (54, 3, 35000);

