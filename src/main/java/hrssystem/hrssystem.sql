DROP DATABASE IF EXISTS hrs_system;
CREATE DATABASE hrs_system;
USE hrs_system;

-- 환자 (Patient) 테이블
CREATE TABLE patient (
    patientid INT AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    birthdate DATE NOT NULL,
    phone VARCHAR(20) NOT NULL UNIQUE,
    address VARCHAR(100) NOT NULL,
    createdat DATETIME DEFAULT NOW(),
    CONSTRAINT pk_patient PRIMARY KEY (patientid)
);

-- 의사 (Doctor) 테이블
CREATE TABLE doctor (
    doctorid INT AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    specialty VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    createdat DATETIME DEFAULT NOW(),
    CONSTRAINT pk_doctor PRIMARY KEY (doctorid)
);

-- 진료 예약 (Appointment) 테이블
CREATE TABLE appointment (
    appointmentid INT AUTO_INCREMENT,
    patientid INT NOT NULL,
    doctorid INT NOT NULL,
    appointmentdate DATE NOT NULL,
    appointmenttime TIME NOT NULL,
    status TINYINT DEFAULT 1,
    createdat DATETIME DEFAULT NOW(),
    CONSTRAINT pk_appointment PRIMARY KEY (appointmentid),
    CONSTRAINT fk_appointment_patient FOREIGN KEY (patientid) REFERENCES patient(patientid) ON DELETE CASCADE,
    CONSTRAINT fk_appointment_doctor FOREIGN KEY (doctorid) REFERENCES doctor(doctorid) ON DELETE CASCADE
);

-- 환자 데이터 (20명)
INSERT INTO patient (name, birthdate, phone, address) VALUES
('김민수', '1990-03-15', '010-1234-5678', '서울시 강남구 역삼동'),
('이영희', '1985-07-22', '010-2345-6789', '서울시 서초구 반포동'),
('박지훈', '1992-11-10', '010-3456-7890', '부산시 해운대구 중동'),
('최수정', '1998-05-03', '010-4567-8901', '대구시 달서구 두류동'),
('정우성', '1975-09-25', '010-5678-9012', '인천시 남동구 구월동'),
('한지민', '1989-02-18', '010-6789-0123', '광주시 서구 치평동'),
('강다현', '1996-12-30', '010-7890-1234', '대전시 유성구 노은동'),
('조윤희', '1993-06-07', '010-8901-2345', '서울시 송파구 잠실동'),
('배성우', '1980-08-14', '010-9012-3456', '부산시 동래구 명륜동'),
('임채원', '2000-04-21', '010-0123-4567', '경기도 성남시 분당구'),
('윤아름', '1991-10-30', '010-5670-7891', '경기도 고양시 일산서구'),
('장예진', '1987-07-05', '010-2340-9876', '전주시 완산구 중화산동'),
('김도현', '1995-02-12', '010-8765-4321', '울산시 남구 신정동'),
('이정훈', '1983-11-09', '010-7654-3210', '춘천시 퇴계동'),
('박민아', '1997-09-08', '010-6543-2109', '제주시 노형동'),
('서지훈', '1984-01-26', '010-5432-1098', '천안시 서북구 두정동'),
('정가연', '1999-06-23', '010-4321-0987', '포항시 북구 양덕동'),
('홍승우', '1994-08-17', '010-3210-9876', '청주시 흥덕구 봉명동'),
('최유진', '1986-12-04', '010-2109-8765', '수원시 장안구 정자동'),
('문정후', '2001-05-11', '010-1098-7654', '창원시 의창구 반림동');

-- 의사 데이터 (5명)
INSERT INTO doctor (name, specialty, phone) VALUES
('김철수', '내과', '010-9876-5432'),
('이소라', '정형외과', '010-8765-4321'),
('박영호', '피부과', '010-7654-3210'),
('최한결', '소아과', '010-6543-2109'),
('정다연', '이비인후과', '010-5432-1098');

-- 진료 예약 데이터
INSERT INTO appointment (patientid, doctorid, appointmentdate, appointmenttime, status) VALUES
(1, 1, '2025-03-01', '09:30:00', 1),
(2, 2, '2025-03-01', '10:00:00', 1),
(3, 3, '2025-03-01', '11:30:00', 1),
(4, 4, '2025-03-01', '14:00:00', 0),  -- 취소됨
(5, 5, '2025-03-01', '15:30:00', 1),
(6, 1, '2025-03-01', '16:45:00', 1),
(7, 2, '2025-03-02', '09:00:00', 1),
(8, 3, '2025-03-02', '10:30:00', 1),
(9, 4, '2025-03-02', '13:45:00', 1),
(10, 5, '2025-03-02', '15:00:00', 0), -- 취소됨
(11, 1, '2025-03-02', '16:30:00', 1),
(12, 2, '2025-03-03', '09:15:00', 1),
(13, 3, '2025-03-03', '11:00:00', 1),
(14, 4, '2025-03-03', '13:00:00', 1),
(15, 5, '2025-03-03', '14:30:00', 1),
(16, 1, '2025-03-03', '16:00:00', 1),
(17, 2, '2025-03-04', '09:45:00', 1),
(18, 3, '2025-03-04', '11:30:00', 0), -- 취소됨
(19, 4, '2025-03-04', '14:00:00', 1),
(20, 5, '2025-03-04', '15:45:00', 1),
(1, 1, '2025-03-04', '17:00:00', 1),
(2, 2, '2025-03-05', '09:00:00', 1),
(3, 3, '2025-03-05', '10:30:00', 1),
(4, 4, '2025-03-05', '12:00:00', 1),
(5, 5, '2025-03-05', '13:30:00', 1),
(6, 1, '2025-03-05', '15:00:00', 1),
(7, 2, '2025-03-06', '09:45:00', 1),
(8, 3, '2025-03-06', '11:00:00', 1),
(9, 4, '2025-03-06', '13:15:00', 1),
(10, 5, '2025-03-06', '14:45:00', 1),
(11, 1, '2025-03-06', '16:30:00', 1),
(12, 2, '2025-03-07', '09:15:00', 1),
(13, 3, '2025-03-07', '10:45:00', 1),
(14, 4, '2025-03-07', '12:30:00', 0), -- 취소됨
(15, 5, '2025-03-07', '14:00:00', 1),
(16, 1, '2025-03-07', '15:45:00', 1),
(17, 2, '2025-03-07', '17:00:00', 1),
(18, 3, '2025-03-07', '09:30:00', 1),
(19, 4, '2025-03-07', '11:15:00', 1),
(20, 5, '2025-03-07', '13:45:00', 1);

SELECT
    a.appointmentid,
    p.name AS patient_name,
    d.name AS doctor_name,
    d.specialty,
    a.appointmentdate,
    a.appointmenttime,
    a.status
FROM appointment a
JOIN patient p ON a.patientid = p.patientid
JOIN doctor d ON a.doctorid = d.doctorid;