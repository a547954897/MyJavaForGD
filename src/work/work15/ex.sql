create database ex
use ex

CREATE TABLE [admin] (
	[aid] int  identity PRIMARY KEY,
	[aname] varchar(20) NOT NULL,
	[apass] varchar(20) NOT NULL
)


CREATE TABLE [stu] (
	[sid] int  identity PRIMARY KEY,
	[sname] varchar(20) NULL,
	[ssex] varchar(2) NULL,
	[sage] int  NULL,
	
)

INSERT INTO [admin] VALUES ('pry', '123')
INSERT INTO [admin] VALUES ('peter','456')

INSERT INTO [stu] VALUES ('王大锤', '男', '20')
INSERT INTO [stu] VALUES ('王小丫', '女', '19')

