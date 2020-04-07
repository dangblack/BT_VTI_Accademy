DROP DATABASE IF EXISTS DB_2_3_AS_QS;
CREATE DATABASE DB_2_3_AS_QS;
USE DB_2_3_AS_QS;

-- Tao bang 1: Department2
DROP TABLE IF EXISTS Department2;
CREATE TABLE Department2(
	DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName 			NVARCHAR(20) NOT NULL
);

-- Tao bang 2: Position2
DROP TABLE IF EXISTS Position2;
CREATE TABLE Position2(
	PositionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName			ENUM('Dev','Test','Scrum Master','PM') NOT NULL
);

-- Tao bang 3: Account2
DROP TABLE IF EXISTS Account2;
CREATE TABLE Account2(
	AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(50) NOT NULL UNIQUE KEY,
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
    FullName				VARCHAR(50) NOT NULL,
    DepartmentID 			TINYINT UNSIGNED NOT NULL,
    PositionID				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATE NOT NULL,
    FOREIGN KEY(DepartmentID) REFERENCES Department2(DepartmentID),
    FOREIGN KEY(PositionID) REFERENCES Position2(PositionID)
);

-- Tao bang 4: Group2
DROP TABLE IF EXISTS Group2;
CREATE TABLE Group2(
	GroupID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName				NVARCHAR(50) NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreateDate				DATE NOT NULL
);

-- Tao bang 5: GroupAccount2
DROP TABLE IF EXISTS GroupAccount2;
CREATE TABLE GroupAccount2(
	GroupID					TINYINT UNSIGNED AUTO_INCREMENT,
    AccountID				NVARCHAR(50) NOT NULL,
    PRIMARY KEY (GroupID,AccountID),
    JoinDate				DATE NOT NULL
);

-- Tao bang 6: TypeQuestion2
DROP TABLE IF EXISTS TypeQuestion2;
CREATE TABLE TypeQuestion2 (
    TypeID TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName ENUM('Esay','Multiple-Choice') NOT NULL
);

-- Tao bang 7: CategoryQuestion2
DROP TABLE IF EXISTS CategoryQuestion2;
CREATE TABLE CategoryQuestion2(
    CategoryID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName			NVARCHAR(50) NOT NULL
);

-- Tao bang 8: Question2
DROP TABLE IF EXISTS Question2;
CREATE TABLE Question2(
    QuestionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(50) NOT NULL,
    CategoryID				TINYINT UNSIGNED NOT NULL,
    TypeID					TINYINT UNSIGNED NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreateDate				DATE NOT NULL,
    FOREIGN KEY(CategoryID) 	REFERENCES CategoryQuestion2(CategoryID),
    FOREIGN KEY(TypeID) 	REFERENCES TypeQuestion2(TypeID)
);

-- Tao bang 9: Answer2
DROP TABLE IF EXISTS Answer2;
CREATE TABLE Answer2(
    Answers					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content					NVARCHAR(50) NOT NULL,
    QuestionID				TINYINT UNSIGNED NOT NULL,
    isCorrect				BIT NOT NULL,
    FOREIGN KEY(QuestionID) 	REFERENCES Question2(QuestionID)
);

-- Tao bang 10: Exam2
DROP TABLE IF EXISTS Exam2;
CREATE TABLE Exam2(
    ExamID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Code					VARCHAR(10) NOT NULL,
    Title					NVARCHAR(50) NOT NULL,
    CategoryID				TINYINT UNSIGNED NOT NULL,
    Duration				TINYINT UNSIGNED NOT NULL,
    CreatorID				TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreateDate				DATE NOT NULL,
    FOREIGN KEY(CategoryID) 	REFERENCES CategoryQuestion2(CategoryID)
);

-- Tao bang 11: ExamQuestion2
DROP TABLE IF EXISTS ExamQuestion2;
CREATE TABLE ExamQuestion2(
    ExamID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	QuestionID			TINYINT UNSIGNED NOT NULL
);






