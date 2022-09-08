
use Test
create table Student(
	[idStudent][int] identity(1,1) primary key,
	[Fullname][nvarchar](50),
	[Gender][nvarchar](10)
) 