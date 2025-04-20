create database furama;

use furama;

CREATE TABLE user (
	username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255)
);

CREATE TABLE position (
    position_id INT PRIMARY KEY AUTO_INCREMENT,
    position_name VARCHAR(45) NOT NULL
);

CREATE TABLE education_degree (
    education_degree_id INT PRIMARY KEY AUTO_INCREMENT,
    education_degree_name VARCHAR(45) NOT NULL
);

CREATE TABLE division (
    division_id INT PRIMARY KEY AUTO_INCREMENT,
    division_name VARCHAR(45) NOT NULL
);

CREATE TABLE employee (
	employee_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(45) NOT NULL,
    employee_birthday DATE NOT NULL,
    employee_id_card VARCHAR(45) NOT NULL,
    employee_salary DOUBLE NOT NULL,
    employee_phone VARCHAR(45) NOT NULL,
    employee_email VARCHAR(45),
    employee_address VARCHAR(45),
    position_id INT NOT NULL,
    education_degree_id INT NOT NULL,
    division_id INT NOT NULL,
    username VARCHAR(255),
	FOREIGN KEY (position_id)
		REFERENCES position (position_id),
    FOREIGN KEY (education_degree_id)
        REFERENCES education_degree (education_degree_id),
    FOREIGN KEY (division_id)
        REFERENCES division (division_id),
	FOREIGN KEY (username)
		REFERENCES user (username)
);

CREATE TABLE customer_type (
    customer_type_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_type_name VARCHAR(45)
);

CREATE TABLE customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_type_id INT NOT NULL,
    customer_name VARCHAR(45) NOT NULL,
    customer_birthday DATE NOT NULL,
    customer_gender BIT(1) NOT NULL,
    customer_id_card VARCHAR(45) NOT NULL,
    customer_phone VARCHAR(45) NOT NULL,
    customer_email VARCHAR(45),
    customer_address VARCHAR(45),
    FOREIGN KEY (customer_type_id) REFERENCES customer_type(customer_type_id)
);

-- CREATE TABLE loai_dich_vu (
--     ma_loai_dich_vu INT PRIMARY KEY,
--     ten_loai_dich_vu VARCHAR(45),
--     is_delete BOOLEAN DEFAULT(0) NOT NULL
-- );

-- CREATE TABLE kieu_thue (
--     ma_kieu_thue INT PRIMARY KEY,
--     ten_kieu_thue VARCHAR(45),
--     is_delete BOOLEAN DEFAULT(0) NOT NULL
-- );

-- CREATE TABLE dich_vu (
--     ma_dich_vu INT PRIMARY KEY,
--     ten_dich_vu VARCHAR(45) NOT NULL,
--     dien_tich INT,
--     chi_phi_thue DOUBLE NOT NULL,
--     so_nguoi_toi_da INT,
--     ma_kieu_thue INT NOT NULL,
--     ma_loai_dich_vu INT NOT NULL,
--     tieu_chuan_phong VARCHAR(45),
--     mo_ta_tien_nghi_khac VARCHAR(45),
--     dien_tich_ho_boi DOUBLE,
--     so_tang INT,
--     is_delete BOOLEAN DEFAULT(0) NOT NULL,
--     FOREIGN KEY (ma_kieu_thue)
--         REFERENCES kieu_thue (ma_kieu_thue),
--     FOREIGN KEY (ma_loai_dich_vu)
--         REFERENCES loai_dich_vu (ma_loai_dich_vu)
-- );

-- CREATE TABLE dich_vu_di_kem (
--     ma_dich_vu_di_kem INT PRIMARY KEY,
--     ten_dich_vu_di_kem varchar(45),
--     gia DOUBLE NOT NULL,
--     don_vi VARCHAR(10) NOT NULL,
--     trang_thai VARCHAR(45),
--     is_delete BOOLEAN DEFAULT(0) NOT NULL
-- );

-- CREATE TABLE hop_dong (
--     ma_hop_dong INT PRIMARY KEY,
--     ngay_lam_hop_dong DATETIME NOT NULL,
--     ngay_ket_thuc DATETIME NOT NULL,
--     tien_dat_coc DOUBLE NOT NULL,
--     ma_nhan_vien INT NOT NULL,
--     ma_khach_hang INT NOT NULL,
--     ma_dich_vu INT NOT NULL,
--     is_delete BOOLEAN DEFAULT(0) NOT NULL,
--     FOREIGN KEY (ma_nhan_vien)
--         REFERENCES nhan_vien (ma_nhan_vien),
--     FOREIGN KEY (ma_khach_hang)
--         REFERENCES khach_hang (ma_khach_hang),
--     FOREIGN KEY (ma_dich_vu)
--         REFERENCES dich_vu (ma_dich_vu)
-- );

-- CREATE TABLE hop_dong_chi_tiet (
--     ma_hop_dong_chi_tiet INT PRIMARY KEY,
--     ma_hop_dong INT NOT NULL,
--     ma_dich_vu_di_kem INT NOT NULL,
--     so_luong INT NOT NULL,
--     is_delete BOOLEAN DEFAULT(0) NOT NULL,
--     FOREIGN KEY (ma_hop_dong)
--         REFERENCES hop_dong (ma_hop_dong),
--     FOREIGN KEY (ma_dich_vu_di_kem)
--         REFERENCES dich_vu_di_kem (ma_dich_vu_di_kem)
-- );