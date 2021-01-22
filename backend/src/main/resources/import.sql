INSERT INTO tb_specialty (name, is_active) VALUES ('ALERGOLOGIA', true);
INSERT INTO tb_specialty (name, is_active) VALUES ('ANGIOLOGIA', true);
INSERT INTO tb_specialty (name, is_active) VALUES ('BUCO MAXILO', true);
INSERT INTO tb_specialty (name, is_active) VALUES ('CARDIOLOGIA CLÍNICA', true);
INSERT INTO tb_specialty (name, is_active) VALUES ('CARDIOLOGIA INFANTIL', true);
INSERT INTO tb_specialty (name, is_active) VALUES ('CIRURGIA CABEÇA E PESCOÇO', true);
INSERT INTO tb_specialty (name, is_active) VALUES ('CIRURGIA CARDÍACA', true);
INSERT INTO tb_specialty (name, is_active) VALUES ('CIRURGIA DE TÓRAX', true);
	
INSERT INTO tb_doctor (name, crm_number, phone_number, address, complement, home_number, neighborhood, cellphone_number, zip_code, is_active) VALUES ('João Tiago da Silva', 1234, '1111111111', 'Rua A', 'Próximo a Rua B', '1548', 'Jardim A', '960674060', '04842-120', true);
INSERT INTO tb_doctor (name,crm_number,phone_number, address,complement,home_number,neighborhood,cellphone_Number,zip_code,is_active) values ('Lucas', 1234, '(11)96754-3020', 'Rua J', 'Próximo a Rua Z', '1234', 'Jardim E', '(11)94322-2210', '04842-100', true);
INSERT INTO tb_doctor (name,crm_number,phone_number, address,complement,home_number,neighborhood,cellphone_Number,zip_code,is_active) values ('José', 1234, '(11)96654-3020', 'Rua X', 'Próximo a Rua D', '12438', 'Jardim S', '(11)94322-2210', '04842-150', false);


INSERT INTO tb_doctor_specialty(doctor_id, specialty_id)values(1,1);
INSERT INTO tb_doctor_specialty(doctor_id, specialty_id)values(1,2);
INSERT INTO tb_doctor_specialty(doctor_id, specialty_id)values(1,3);