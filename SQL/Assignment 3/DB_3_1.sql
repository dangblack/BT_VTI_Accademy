DROP DATABASE IF EXISTS Fresher_management;
CREATE DATABASE Fresher_management;
USE Fresher_management;
/*================TẠO BẢNG=======================*/
/*===============================================*/
-- =Question1=
-- Tao bang Trainee
DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee(
	TraineeID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Full_Name			NVARCHAR(50) NOT NULL,
    Birth_Date			DATE NOT NULL,
    Gender				ENUM('male','female','unknown') NOT NULL,
    ET_IQ				TINYINT UNSIGNED CHECK(ET_IQ<=20) NOT NULL,
    ET_Gmath			TINYINT UNSIGNED CHECK(ET_Gmath<=20) NOT NULL,
    ET_English			TINYINT UNSIGNED CHECK(ET_English<=20) NOT NULL,
    Trainning_Class		CHAR(6) NOT NULL,
    Evaluation_Notes	NVARCHAR(50) DEFAULT NULL
);
-- Them cot VTI_Account
ALTER TABLE Trainee ADD COLUMN VTI_Account VARCHAR(30) NOT NULL UNIQUE KEY;


-- =Question2=
DROP TABLE IF EXISTS Ques2;
CREATE TABLE Ques2(
	ID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Name			VARCHAR(50) NOT NULL,
    Code			CHAR(5) NOT NULL UNIQUE KEY,
    ModifiedDate	DATETIME DEFAULT NOW()
);

-- =Question3=
DROP TABLE IF EXISTS Ques3;
CREATE TABLE Ques3(
	ID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Name			VARCHAR(50) NOT NULL,
    BirthDate		DATETIME NOT NULL DEFAULT NOW(),
    Gender			ENUM('0','1','2'), -- 0: Male, 1: Female, 2:Unknown
    IsDeletedFlag	ENUM('0','1') -- 0: Active,	1: Deleted
);

/*================THÊM DỮ LIỆU VÀO BẢNG=======================*/
/*===========================================================*/

-- Thêm dữ liệu cho bagnr Trainee
INSERT INTO Trainee (   Full_Name		,   Birth_Date	, Gender	, ET_IQ	, ET_Gmath	, ET_English	, Trainning_Class	, Evaluation_Notes	, VTI_Account		)
VALUE 				('Nguyễn Hải Đăng'	,  '2000-04-29'	, 'male'	,	20	,	20		,	20			,		'VTI001'	,		'Very good'	,	'dangblack'		),
					('Nguyễn Văn Bảo'	,  '2000-05-09'	, 'male'	,	18	,	16		,	16			,		'VTI002'	,		'Normal'	,	'bao123'		),
                    ('Hoàng Thị Thường'	,  '2000-06-22'	, 'female'	,	11	,	17		,	10			,		'VTI003'	,		'Good'		,	'thuong69'		),
                    ('Huấn Râu Sì'		,  '2000-07-24'	, 'male'	,	20	,	12		,	20			,		'VTI004'	,		'Good'		,	'huanrose'		),
                    ('Ngô Bá Khá'		,  '2000-08-05'	, 'male'	,	16	,	20		,	16			,		'VTI005'	,		'Normal'	,	'khabanh'		),
                    ('Nguyễn Văn Dũng'	,  '2000-09-08'	, 'female'	,	19	,	10		,	19			,		'VTI006'	,		'Good'		,	'dungtroc'		),
                    ('Nguyễn Hải Hậu'	,  '2000-10-11'	, 'male'	,	20	,	19		,	18			,		'VTI007'	,		'Normal'	,	'haumon'		),
                    ('Tống Quang Anh'	,  '2000-11-12'	, 'female'	,	15	,	20		,	17			,		'VTI008'	,		'Good'		,	'antondev'		),
                    ('Nguyễn Thị Chiến'	,  '2000-11-13'	, 'unknown'	,	20	,	19		,	20			,		'VTI009'	,		'Normal'	,	'chienpanda'	),
					('Nguyễn Thị Hảo'	,  '2000-11-13'	, 'female'	,	20	,	19		,	15			,		'VTI010'	,		'Good'		,	'haohaochucay'	);
      
-- Thêm dữ liệu cho bảng Ques2   
INSERT INTO Ques2	 (   `Name`,  	   `Code`, 		`ModifiedDate`	)
VALUE 				('NOW OR NEVER'	, 'VT001'	,	'2020-03-05'	),
					('DEAD OR LIVE'	, 'VT002'	,	'2020-03-05'	),
                    ('BE CAREFULL'	, 'VT003'	,	'2020-03-07'	),
                    ('PAY LAK'		, 'VT004'	,	'2020-03-08'	),
                    ('LET DO IT'	, 'VT005'	,	'2020-03-10'	),
                    ('DOING STH'	, 'VT006'	,	'2020-04-05'	),
                    ('GET OUT'		, 'VT007'	,	'2020-04-05'	),
                    ('OUTLAST'		, 'VT008'	,	'2020-04-07'	),
                    ('GET IT'		, 'VT009'	,	'2020-04-07'	),
					('TAKE OUT'		, 'VT010'	,	'2020-04-09'	);
				
-- Thêm dữ liệu cho bảng Ques3
INSERT INTO Ques3 	(   `Name`			,   `BirthDate`		, `Gender`	, `IsDeletedFlag`	)
VALUE 				('Nguyễn Hải Đăng'	,  '2000-04-29'		, 	'0'		,		'0'			),                    
					('Nguyễn Văn Bảo'	,  '2000-05-09'		, 	'0'		,		'1'			),
                    ('Hoàng Thị Thường'	,  '2000-06-22'		, 	'1'		,		'0'			),
                    ('Huấn Râu Sì'		,  '2000-07-24'		, 	'1'		,		'1'			),
                    ('Ngô Bá Khá'		,  '2000-08-05'		, 	'2'		,		'0'			),
                    ('Nguyễn Văn Dũng'	,  '2000-09-08'		, 	'1'		,		'1'			),
                    ('Nguyễn Hải Hậu'	,  '2000-10-11'		, 	'0'		,		'1'			),
                    ('Tống Quang Anh'	,  '2000-11-12'		, 	'0'		,		'0'			),
                    ('Nguyễn Thị Chiến'	,  '2000-11-13'		, 	'0'		,		'0'			),
					('Nguyễn Thị Hảo'	,  '2000-11-13'		, 	'1'		,		'1'			);
                    
                    
				
/*================TRUY VẤN DỮ LIỆU===========================*/
/*===========================================================*/
-- Question 2: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, nhóm chúng thành các tháng sinh khác nhau
SELECT * FROM Trainee;
-- Question 3: Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau: tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)
SELECT * 
FROM Trainee
WHERE LENGTH(Full_Name) = (SELECT MAX(LENGTH(Full_Name)) FROM Trainee);

-- Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau:
-- ET_IQ + ET_Gmath>=20
-- ET_IQ>=8
-- ET_Gmath>=8
-- ET_English>=18
SELECT * 
FROM Trainee
WHERE ET_IQ + ET_Gmath>=20 AND ET_Gmath>=8 AND  ET_English>=18;

-- Question 5: xóa thực tập sinh có TraineeID = 3
DELETE FROM Trainee WHERE TraineeID = 3; 

-- Question 6: Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2". Hãy cập nhật thông tin vào database
UPDATE Trainee 
SET Trainning_Class = 'VTI002' 
WHERE TraineeID = 5;








