kế hoạch demo dockerfile

- Từ dockerfile build image, image run thành các container chứa môi trường và công cụ để chạy được app java và mysql.

- Các bước thực hiện:

 + Từ dockerfile_mysql build image db_mysql, run image lên để được container chứa mysql. Sau đó tạo bảng customers và insert một vài dữ liệu.
	// Tạo Table: CREATE TABLE customers (id INT NOT NULL PRIMARY KEY , name VARCHAR(255), email VARCHAR(255), phone VARCHAR(255), avatar VARCHAR(255), password VARCHAR(255));

	// Insert dữ liệu: INSERT INTO customers(id, name,email,phone,avatar,password )VALUES (1, "Ngo Van Duc", "Ngovanduc@Gmail.com", "0904955121", "image1.png", "123456789"), (2, "Vu Dinh Cuong", "Vudinhcuong@Gmail.com", "0804955122", "image2.png", "1212212121"), (3, "Tran Tien Thanh", "Trantienthanh@Gmail.com", "0704955123", "image3.png", "3232323232"), (4, "Bui Nhat Anh", "Buinhatanh@Gmail.com", "0604955124", "image4.png", "434343432"), (5, "Minh Tam", "Minhtam@Gmail.com", "0504955125", "image5.png", "2112121212"), (6, "Le Thuc Trinh", "Lethuctrinh@Gmail.com", "0404955126", "image6.png", "3232434354"), (7, "Trinh Van Tuan", "Trinhvantuan@Gmail.com", "0304955127", "image7.png", "654534343"), (8, "Chu Manh Tuan", "Chumanhtuan@Gmail.com", "0204955128", "image8.png", "123445667");
 
 + Từ dockerfile_environment_java build thành image image_web_java, và run image để được container chạy app java.
 
 + Từ dockerfile_onbuild chúng ta run thành image demo_onbuild để thấy chức năng của directive ONBUILD.