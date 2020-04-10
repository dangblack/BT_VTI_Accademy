/*
----VTI ACCADEMY HOMEWORK
----CREATE BY DANGBLACK
*/
DROP DATABASE IF EXISTS TestingSystem1;
CREATE DATABASE TestingSystem1;
USE TestingSystem1;
COMMIT;

/*============================== TẠO BẢNG DỮ LIỆU (10 BẢNG) =============================*/
/*======================================================================================*/

-- Tao bang 1: Department
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			NVARCHAR(20) NOT NULL UNIQUE
);

-- Tao bang 2: `Position`
DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position`(
	PositionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName			ENUM('Dev','Test','Scrum Master','PM') NOT NULL
);

-- Tao bang 3: `Account`
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY,
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName				VARCHAR(50) NOT NULL,
    DepartmentID 			TINYINT UNSIGNED NOT NULL,
    PositionID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID)
);

-- Tao bang 4: `Group`
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName				NVARCHAR(50) NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreateDate				DATETIME DEFAULT NOW()
);

-- Tao bang 5: Group`Account`
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
	GroupAccountID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,			
	GroupID					TINYINT UNSIGNED NOT NULL,
    AccountID				TINYINT UNSIGNED NOT NULL,
    JoinDate				DATETIME DEFAULT NOW(),
	FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID),
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID)
);
                            
-- Tao bang 6: TypeQuestion
DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion (
    TypeID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName ENUM('Essay','Multiple-Choice') NOT NULL
);

-- Tao bang 7: CategoryQuestion
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion(
    CategoryID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName			NVARCHAR(50) NOT NULL UNIQUE
);

-- Tao bang 8: Question
DROP TABLE IF EXISTS Question;
CREATE TABLE Question(
    QuestionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(50) NOT NULL,
    CategoryID				TINYINT UNSIGNED NOT NULL,
    TypeID					TINYINT UNSIGNED NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreateDate				DATETIME NOT NULL DEFAULT NOW(),
    FOREIGN KEY(CategoryID) 	REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY(TypeID) 	REFERENCES TypeQuestion(TypeID)
);

-- Tao bang 9: Answer
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer(
    AnswerID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(50) NOT NULL,
    QuestionID				TINYINT UNSIGNED NOT NULL,
    isCorrect				BIT NOT NULL, -- 0: Sai, 1: Đúng
    FOREIGN KEY(QuestionID) 	REFERENCES Question(QuestionID)
);

-- Tao bang 10: Exam
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
    ExamID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Code					CHAR(7) UNIQUE KEY NOT NULL,
    Title					NVARCHAR(50) NOT NULL,
    CategoryID				TINYINT UNSIGNED NOT NULL,
    Duration				TINYINT UNSIGNED NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATETIME NOT NULL DEFAULT NOW(),
    FOREIGN KEY(CategoryID) 	REFERENCES CategoryQuestion(CategoryID)
);

-- Tao bang 11: ExamQuestion
DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion(
    ExamID				TINYINT UNSIGNED AUTO_INCREMENT,
	QuestionID			TINYINT UNSIGNED NOT NULL,
    PRIMARY KEY(ExamID,QuestionID)
);

/*============================== THÊM DỮ LIỆU VÀO BẢNG =================================*/
/*======================================================================================*/
-- Thêm dữ liệu cho bảng Department
INSERT INTO Department	(DepartmentName) VALUE 
						(N'Marketing'	),
						(N'Sale'		),
						(N'Bảo vệ'		),
						(N'Nhân sự'		),
						(N'Kỹ thuật'	),
						(N'Tài chính'	),
						(N'Phó giám đốc'),
						(N'Giám đốc'	),
						(N'Thư kí'		),
						(N'Bán hàng'	);
    
-- Thêm dữ liệu cho bảng `Position`
INSERT INTO `Position`	( PositionName	) 
VALUE 					('Dev'			),
						('Test'			),
						('Scrum Master'	),
						('PM'			); 


-- Thêm dữ liệu cho bảng `Account`
INSERT INTO `Account`(Email								, Username			, FullName				, DepartmentID	, PositionID, CreateDate)
VALUE 				('haidang29productions@gmail.com'	, 'dangblack'		,'Nguyen Hai Dang'		,   '5'			,   '1'		,'2020-03-05'),
					('account1@gmail.com'				, 'quanganh'		,'Tong Quang Anh'		,   '1'			,   '2'		,'2020-03-05'),
                    ('`Account`@gmail.com'				, 'vanchien'		,'Nguyen Van Chien'		,   '2'			,   '3'		,'2020-03-07'),
                    ('account3@gmail.com'				, 'cocoduongqua'	,'Duong Do'				,   '3'			,   '4'		,'2020-03-08'),
                    ('account4@gmail.com'				, 'doccocaubai'		,'Nguyen Chien Thang'	,   '5'			,   '4'		,'2020-03-10'),
                    ('dapphatchetngay@gmail.com'		, 'khabanh'			,'Ngo Ba Kha'			,   '5'			,   '3'		,'2020-04-05'),
                    ('songcodaoly@gmail.com'			, 'huanhoahong'		,'Bui Xuan Huan'		,   '7'			,   '2'		,'2020-04-05'),
                    ('sontungmtp@gmail.com'				, 'tungnui'			,'Nguyen Thanh Tung'	,   '5'			,   '1'		,'2020-04-07'),
                    ('duongghuu@gmail.com'				, 'duongghuu'		,'Duong Van Huu'		,   '9'			,   '2'		,'2020-04-07'),
                    ('vtiaccademy@gmail.com'			, 'vtiaccademy'		,'Vi Ti Ai'				,   '10'		,   '1'		,'2020-04-09');

-- Thêm dữ liệu cho bảng `Group`
INSERT INTO `Group`	(  GroupName			, CreatorID		, CreateDate)
VALUE 				(N'Testing System'		,   5			,'2019-03-05'),
					(N'Developement'		,   1			,'2020-03-07'),
                    (N'VTI Sale 01'			,   2			,'2020-03-09'),
                    (N'VTI Sale 02'			,   3			,'2020-03-10'),
                    (N'VTI Sale 02'			,   4			,'2020-03-28'),
                    (N'VTI Creator'			,   6			,'2020-04-06'),
                    (N'VTI Marketing 01'	,   7			,'2020-04-07'),
                    (N'Management'			,   8			,'2020-04-08'),
                    (N'Chat with love'		,   9			,'2020-04-09'),
                    (N'Vi Ti Ai'			,   10			,'2020-04-10');

-- Thêm dữ liệu cho bảng Group`Account`
INSERT INTO `GroupAccount`	(  GroupID	, AccountID	, JoinDate	 )
VALUE 						(	1		,    1		,'2019-03-05'),
							(	1		,    2		,'2020-03-07'),
							(	3		,    3		,'2020-03-09'),
							(	3		,    4		,'2020-03-10'),
							(	5		,    5		,'2020-03-28'),
							(	1		,    3		,'2020-04-06'),
							(	1		,    7		,'2020-04-07'),
							(	8		,    3		,'2020-04-08'),
							(	1		,    9		,'2020-04-09'),
							(	10		,    10		,'2020-04-10');


-- Thêm dữ liệu cho bảng TypeQuestion
INSERT INTO TypeQuestion	(TypeName			) 
VALUE 						('Essay'			), 
							('Multiple-Choice'	); 


-- Thêm dữ liệu cho CategoryQuestion
INSERT INTO CategoryQuestion		(CategoryName	)
VALUE 								('Java'			),
									('ASP.NET'		),
									('ADO.NET'		),
									('SQL'			),
									('Postman'		),
									('Ruby'			),
									('Python'		),
									('C++'			),
									('C Sharp'		),
									('PHP'			);
													
-- Thêm bảng Question
INSERT INTO Question	(Content			, CategoryID, TypeID	, CreatorID	, CreateDate )
VALUE 					(N'Câu hỏi về Java'	,	10		,   '1'		,   '1'		,'2020-04-05'),
						(N'Câu Hỏi về PHP'	,	10		,   '2'		,   '2'		,'2020-04-05'),
						(N'Hỏi về C#'		,	10		,   '2'		,   '3'		,'2020-04-06'),
						(N'Hỏi về Ruby'		,	6		,   '1'		,   '4'		,'2020-04-06'),
						(N'Hỏi về Postman'	,	1		,   '1'		,   '5'		,'2020-04-06'),
						(N'Hỏi về ADO.NET'	,	3		,   '2'		,   '6'		,'2020-04-06'),
						(N'Hỏi về ASP.NET'	,	2		,   '1'		,   '7'		,'2020-04-06'),
						(N'Hỏi về C++'		,	8		,   '1'		,   '8'		,'2020-04-07'),
						(N'Hỏi về SQL'		,	4		,   '2'		,   '9'		,'2020-04-07'),
						(N'Hỏi về Python'	,	7		,   '1'		,   '10'	,'2020-04-07');

-- Thêm bảng Answers2
INSERT INTO Answer	(  Content		, QuestionID	, isCorrect	)
VALUE 				(N'Trả lời 01'	,   2			,	0		),
					(N'Trả lời 02'	,   2			,	1		),
                    (N'Trả lời 03'	,   2			,	0		),
                    (N'Trả lời 04'	,   1			,	1		),
                    (N'Trả lời 05'	,   2			,	1		),
                    (N'Trả lời 06'	,   3			,	1		),
                    (N'Trả lời 07'	,   4			,	0		),
                    (N'Trả lời 08'	,   8			,	0		),
                    (N'Trả lời 09'	,   9			,	1		),
                    (N'Trả lời 10'	,   10			,	1		);
	
-- Thêm bảng Exam
INSERT INTO Exam	(Code			, Title					, CategoryID	, Duration	, CreatorID		, CreateDate )
VALUE 				('VTIQ001'		, N'Đề thi C#'			,	1			,	60		,   '5'			,'2019-04-05'),
					('VTIQ002'		, N'Đề thi PHP'			,	10			,	60		,   '1'			,'2019-04-05'),
                    ('VTIQ003'		, N'Đề thi C++'			,	9			,	120		,   '2'			,'2019-04-07'),
                    ('VTIQ004'		, N'Đề thi Java'		,	6			,	60		,   '3'			,'2020-04-08'),
                    ('VTIQ005'		, N'Đề thi Ruby'		,	5			,	120		,   '4'			,'2020-04-10'),
                    ('VTIQ006'		, N'Đề thi Postman'		,	3			,	60		,   '6'			,'2020-04-05'),
                    ('VTIQ007'		, N'Đề thi SQL'			,	2			,	60		,   '7'			,'2020-04-05'),
                    ('VTIQ008'		, N'Đề thi Python'		,	8			,	60		,   '8'			,'2020-04-07'),
                    ('VTIQ009'		, N'Đề thi ADO.NET'		,	4			,	90		,   '9'			,'2020-04-07'),
                    ('VTIQ010'		, N'Đề thi ASP.NET'		,	7			,	90		,   '10'		,'2020-04-08');
                    
-- Thêm bảng ExamQuestion
INSERT INTO ExamQuestion(QuestionID) 
VALUE 						(1),
							(10), 
							(1), 
							(1), 
							(5), 
							(10), 
							(7), 
							(8), 
							(9), 
							(10); 


/*============================== TRUY VẤN DỮ LIỆU (DB_3_2) =============================*/
/*======================================================================================*/


-- Question 2: Lấy tất cả các phòng ban
SELECT * FROM Department;

-- Question 3: Lấy ra id của phòng ban "Sale"
SELECT 	DepartmentID 
FROM 	Department 
WHERE 	DepartmentName = N'Sale';

-- Question 4: lấy ra thông tin account có full name dài nhất và sắp xếp chúng theo thứ tự giảm dần
SELECT 	* 
FROM 	`Account` 
WHERE 	LENGTH(Fullname) = (SELECT MAX(LENGTH(Fullname)) FROM `Account`)
ORDER BY Fullname DESC;

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
SELECT * FROM `Account` 
WHERE LENGTH(Fullname) = (SELECT MAX(LENGTH(Fullname)) FROM `Account`) AND DepartmentID = 3
ORDER BY Fullname DESC;

-- Question 6: lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT GroupName FROM `Group` 
WHERE CreateDate < '2019-12-20';

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT QuestionID
FROM Answer
GROUP BY QuestionID
HAVING COUNT(QuestionID)>=4;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT Code FROM Exam
WHERE Duration >= 60 AND CreateDate < '2019-12-20';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT * FROM `Group`
ORDER BY CreateDate DESC 
LIMIT 5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT COUNT(AccountID) AS 'SO NHAN VIEN' FROM `Account`
WHERE DepartmentID = 2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT Fullname FROM `Account`
WHERE (SUBSTRING_INDEX(FullName, ' ', -1)) LIKE 'D%o' ;

-- Question 12: xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE FROM Exam WHERE CreateDate < '2019-12-20';
ROLLBACK;
-- Question 13: xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
-- SET FOREIGN_KEY_CHECKS=0;
DELETE FROM Question 
WHERE (SUBSTRING_INDEX(Content,' ',2)) = 'Câu hỏi';
-- SET FOREIGN_KEY_CHECKS=1;

-- Question 14: update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
UPDATE `Account` SET Fullname = N'Nguyễn Bá Lộc', Email = 'loc.nguyenba@vti.com.vn'
WHERE AccountID = 5;

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
SET FOREIGN_KEY_CHECKS=0;
UPDATE `GroupAccount` SET AccountID = 5 WHERE GroupID = 4;
SET FOREIGN_KEY_CHECKS=1;



/*============================== TRUY VẤN DỮ LIỆU (DB_4_2) =============================*/
/*======================================================================================*/

-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 	Email, Username	, FullName, PositionID, CreateDate, A.DepartmentID, D.DepartmentName
FROM 	`Account` A INNER JOIN Department D
ON 		A.DepartmentID = D.DepartmentID;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/03/2020
SELECT	*
FROM	`Account`
WHERE	CreateDate < '2020-03-20';

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT	*
FROM	`Account` A INNER JOIN Position P
ON		A.PositionID = P.PositionID
WHERE	P.PositionName = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên
SELECT 		D.DepartmentID, DepartmentName, COUNT(A.DepartmentID) AS 'SO LUONG'
FROM 		`Account` A INNER JOIN Department  D
ON			D.DepartmentID = A.DepartmentID
GROUP BY 	A.DepartmentID
HAVING 		COUNT(A.DepartmentID)>3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT 		Q.QuestionID, Q.Content, Q.CategoryID, Q.TypeID, Q.CreatorID, Q.CreateDate, Count(Q.Content) AS 'SO LUONG'
FROM		Question Q INNER JOIN ExamQuestion EQ
ON			Q.QuestionID = EQ.QuestionID
GROUP BY	Q.Content
HAVING		COUNT(Q.Content) = (SELECT		MAX(CountQ)
								FROM		
										(SELECT 		COUNT(Q.QuestionID) AS CountQ
										FROM			ExamQuestion EQ INNER JOIN Question Q
										ON				EQ.QuestionID = Q.QuestionID
										GROUP BY		Q.QuestionID) AS MaxContent);

-- Question 6: Thống kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT		CQ.CategoryID, CQ.CategoryName, COUNT(Q.CategoryID)
FROM		CategoryQuestion CQ LEFT JOIN Question Q
ON			CQ.CategoryID = Q.CategoryID
GROUP BY	Q.CategoryID
ORDER BY	CQ.CategoryID ASC;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT		Q.Content, COUNT(EQ.QuestionID)
FROM		Question Q LEFT JOIN ExamQuestion EQ
ON			EQ.QuestionID = Q.QuestionID
GROUP BY	Q.Content
ORDER BY 	EQ.ExamID ASC;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT 		Q.QuestionID, Q.Content, COUNT(A.QuestionID) AS 'SO LUONG'
FROM		Question Q INNER JOIN Answer A 
ON			Q.QuestionID = A.QuestionID
GROUP BY	A.QuestionID
HAVING		COUNT(A.QuestionID) =	(SELECT 	MAX(CountQ)
									FROM		(SELECT 		COUNT(A.QuestionID) AS CountQ
												FROM			Answer A RIGHT JOIN  Question Q 
												ON				A.QuestionID = Q.QuestionID 
												GROUP BY		A.QuestionID) AS MaxCountQ);
			
-- Question 9: Thống kê số lượng account trong mỗi group
SELECT		GA.GroupID, COUNT(GA.AccountID) AS 'SO LUONG'
FROM		GroupAccount GA 
GROUP BY	GA.GroupID;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT 		P.PositionID, P.PositionName, COUNT(A.PositionID) AS 'SO LUONG'
FROM		Position P INNER JOIN `Account` A 
ON			P.PositionID = A.PositionID
GROUP BY 	P.PositionID
HAVING		COUNT(A.PositionID)	=	(SELECT 	MIN(CountP)
									FROM		(SELECT 	COUNT(P.PositionID) AS CountP
												FROM		Position P INNER JOIN `Account` A 
												ON			P.PositionID = A.PositionID		
												GROUP BY	P.PositionID) AS MinCountP);

-- Question 11: thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT 		D.DepartmentID, D.DepartmentName, COUNT(P.PositionID) AS 'SO LUONG'
FROM		Position P INNER JOIN `Account` A 
ON			P.PositionID = A.PositionID
INNER JOIN	Department D
ON			A.DepartmentID = D.DepartmentID
GROUP BY	D.DepartmentID, PositionName
ORDER BY	D.DepartmentID ASC;
-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, …
SELECT 		T.TypeName AS 'LOAI CAU HOI', Q.CreatorID AS 'ID NGUOI TAO', Q.Content AS 'CAU HOI', A.Content AS 'CAU TRA LOI', Q.CreateDate AS 'NGAY TAO'
FROM		Question Q INNER JOIN Answer A
ON			Q.QuestionID = A.QuestionID
INNER JOIN	TypeQuestion T
ON			Q.TypeID = T.TypeID;
-- Question 13: lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT		T.TypeName AS 'LOAI CAU HOI', COUNT(Q.TypeID) AS 'SO LUONG'
FROM		Question Q INNER JOIN TypeQuestion T
ON			Q.TypeID = T.TypeID
GROUP BY	Q.TypeID;
-- Question 14: lấy ra group không có account nào
SELECT		*
FROM		`Group` 
WHERE		GroupID  NOT IN
					(SELECT		GroupID
					FROM		GroupAccount);

-- Question 15: lấy ra group không có account nào
SELECT		*
FROM		`Group` 
WHERE		GroupID  NOT IN
					(SELECT		GroupID
					FROM		GroupAccount);
-- Question 16: lấy ra question không có answer nào 
SELECT		*
FROM		Question
WHERE		QuestionID NOT IN
						(SELECT		QuestionID
                        From		Answer);
                        

