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

CREATE TABLE service_type (
    service_type_id INT PRIMARY KEY AUTO_INCREMENT,
    service_type_name VARCHAR(45)
);

CREATE TABLE rent_type (
    rent_type_id INT PRIMARY KEY AUTO_INCREMENT,
    rent_type_name VARCHAR(45)
);

CREATE TABLE service (
    service_id INT PRIMARY KEY AUTO_INCREMENT,
    service_name VARCHAR(45) NOT NULL,
    service_area INT,
    service_cost DOUBLE NOT NULL,
    service_max_people INT,
    rent_type_id INT NOT NULL,
    service_type_id INT NOT NULL,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area DOUBLE,
    number_of_floors INT,
    FOREIGN KEY (rent_type_id)
        REFERENCES rent_type (rent_type_id),
    FOREIGN KEY (service_type_id)
        REFERENCES service_type (service_type_id)
);

-- CREATE TABLE dich_vu_di_kem (
--     ma_dich_vu_di_kem INT PRIMARY KEY,
--     ten_dich_vu_di_kem varchar(45),
--     gia DOUBLE NOT NULL,
--     don_vi VARCHAR(10) NOT NULL,
--     trang_thai VARCHAR(45),
--     is_delete BOOLEAN DEFAULT(0) NOT NULL
-- );

CREATE TABLE contract (
    contract_id INT PRIMARY KEY AUTO_INCREMENT,
    contract_start_date DATE NOT NULL,
    contract_end_date DATE NOT NULL,
    contract_deposit DOUBLE NOT NULL,
    contract_total_money DOUBLE NOT NULL,
    employee_id INT NOT NULL,
    customer_id INT NOT NULL,
    service_id INT NOT NULL,
    FOREIGN KEY (employee_id)
        REFERENCES employee (employee_id),
    FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id),
    FOREIGN KEY (service_id)
        REFERENCES service (service_id)
);

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