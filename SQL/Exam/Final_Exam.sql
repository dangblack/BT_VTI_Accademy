DROP DATABASE IF EXISTS Final_Exam_SQL;
CREATE DATABASE Final_Exam_SQL;
USE	Final_Exam_SQL;

-- Tạo table với các ràng buộc và kiểu dữ liệu
-- Thêm ít nhất 3 bản ghi vào table

-- create table Student
DROP TABLE IF EXISTS Student;
CREATE TABLE IF NOT EXISTS Student
(	RN						INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Name					NVARCHAR(50) NOT NULL,
    Age						TINYINT NOT NULL,
    Gender					ENUM('0','1','null')
);
INSERT INTO	Student	(		`Name`		,	Age	,	Gender		)
VALUES				(N'Nguyễn Hải Đăng'	,	18	,	'0'			),
					(N'Tống Quang Anh'	,	18	,	'null'	),
					(N'Nguyễn Kim Anh'	,	18	,	'1'			);
            
-- create table Subject
DROP TABLE IF EXISTS Subject;
CREATE TABLE IF NOT EXISTS Subject
(	sID						NVARCHAR(5) PRIMARY KEY, 
	sName					NVARCHAR(50) NOT NULL
);
INSERT INTO `Subject`	(sID	,			sName					)
VALUES					('SU001',		'Hướng đối tượng Java'		),
						('SU002',		'Hướng sự kiện c#'			),
						('SU003',		'Lập trình web html'		);
            
-- create table StudentSubject
DROP TABLE IF EXISTS StudentSubject;
CREATE TABLE IF NOT EXISTS StudentSubject
(	RN						INT UNSIGNED,
	sID						NVARCHAR(5),
    Mark					DECIMAL(3,1) NOT NULL,
    Date					DATETIME DEFAULT NOW(),
    PRIMARY KEY (RN, sID)
);
INSERT INTO StudentSubject	(RN	,	sID		,	Mark	,	`Date`	 )
VALUES						(1	,	'SU001'	,	9		,'2019/10/10'),
							(1	,	'SU002'	,	8		,'2019/11/10'),

							(2	,	'SU001'	,	9		,'2019/10/10'),
							(2	,	'SU002'	,	10		,'2019/11/10'),

							(3	,	'SU001'	,	8		,'2019/10/10'),
							(3	,	'SU002'	,	9		,'2019/11/10');

                                    
                                
-- b
-- Viết lệnh để
-- a. Lấy tất cả các môn học không có bất kì điểm nào
WITH CTE_sID_StudentSubject AS(
	SELECT 	sID
	FROM	StudentSubject
)
SELECT 	*
FROM 	`Subject`
WHERE	sID NOT IN (SELECT * 
					FROM CTE_sID_StudentSubject);
-- b. Lấy danh sách các môn học có ít nhất 2 điểm
SELECT 		S.sName, S.sID
FROM		`Subject` S INNER JOIN `StudentSubject` SS 
ON 			S.sID = SS.sID
GROUP BY 	S.sID
HAVING 		COUNT(Mark) >= 2; 

-- c
-- Tạo "StudentInfo" view có các thông tin về học sinh bao gồm:
-- RN,sID,Name, Age, Gender, sName, Mark, Date. Với cột Gender show
-- Male để thay thế cho 0, Female thay thế cho 1 và Unknow thay thế cho
-- null.
DROP VIEW IF EXISTS StudentInfo;
CREATE VIEW 		StudentInfo 
AS
SELECT		ST.RN, ST.Age, ST.`Name`,
			CASE ST.Gender 	WHEN '0' THEN 'Male'
							WHEN '1' THEN 'Female'
							ELSE 'Unknown'
							END AS GioiTinh,
					S.sID, SS.Mark, SS.`Date`
FROM		Student ST, `Subject` S, StudentSubject SS
WHERE		(ST.RN=SS.RN) AND (SS.sID=S.sID) ;

-- Test
SELECT * FROM`StudentInfo`;

-- d
-- Tạo trigger cho table Subject:
-- a. Trigger CasUpdate: khi thay đổi data của cột sID, thì giá trị của
-- cột sID của table StudentSubject cũng thay đổi theo

DROP TRIGGER IF EXISTS CasUpdate;
DELIMITER $$
CREATE TRIGGER CasUpdate
AFTER UPDATE ON subject
FOR EACH ROW
BEGIN
		UPDATE StudentSubject
        SET sID = NEW.sID
        WHERE sID = OLD.sID;
        
END$$
DELIMITER ;

UPDATE Subject
   SET sID='SU004'
 WHERE sID='SU002';
         
SELECT * FROM StudentSubject;


-- b. Trigger casDel: Khi xóa 1 student, các dữ liệu của table
-- StudentSubject cũng sẽ bị xóa theo
DROP TRIGGER IF EXISTS casDel;
DELIMITER $$
CREATE TRIGGER casDel
AFTER DELETE ON `Student`
FOR EACH ROW
BEGIN
		DELETE FROM `StudentSubject`
        WHERE RN = OLD.RN;
END$$
DELIMITER ;

DELETE FROM `Student`
WHERE RN = 3;

SELECT * FROM `StudentSubject`;

-- d
-- Viết 1 thủ tục (có 2 parameters: student name, mark). Thủ tục sẽ xóa tất cả
-- các thông tin liên quan tới học sinh có cùng tên như parameter và tất cả
-- các điểm nhỏ hơn của các học sinh đó.
-- Trong trường hợp nhập vào "*" thì thủ tục sẽ xóa tất cả các học sinh
DROP PROCEDURE IF EXISTS sp_DeleteStudent;
DELIMITER $$
CREATE PROCEDURE sp_DeleteStudent
(IN StudentName_IN NVARCHAR(50), IN Mark_IN DECIMAL(3,1))
BEGIN
		IF (StudentName_IN = '*') THEN
				DELETE 
                FROM `Student`;
		END IF;
		IF (StudentName_IN = '*') THEN
				DELETE
				FROM `StudentSubject`
                WHERE Mark < Mark_IN;
		END IF;
        
        IF (StudentName_IN != '*' AND Mark_IN != '*') THEN
			DELETE 
			FROM `Student`
			WHERE Name = StudentName_IN;
		END IF;
        IF (StudentName_IN != '*' AND Mark_IN != '*') THEN
			DELETE
			FROM `StudentSubject`
			WHERE Mark < Mark_IN AND RN IN (SELECT 		RN 
											FROM 		Student 
											WHERE Name = StudentName_IN );
		END IF;
                                        
END$$
DELIMITER ;



CALL sp_DeleteStudent('*',8);

SELECT * FROM `Student`;

CALL sp_DeleteStudent('Nguyễn Hải Đăng',8);