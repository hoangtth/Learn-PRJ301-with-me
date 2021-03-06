USE [master]
GO
/****** Object:  Database [Account]    Script Date: 9/18/2020 9:11:21 PM ******/
CREATE DATABASE [PRJ321_DB]
GO

USE [PRJ321_DB]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 9/18/2020 9:11:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[userid] [int] NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[email] [nvarchar](max) NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[userid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Class]    Script Date: 9/18/2020 9:11:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Class](
	[classid] [int] IDENTITY(1,1) NOT NULL,
	[classname] [nvarchar](50) NULL,
 CONSTRAINT [PK_Class] PRIMARY KEY CLUSTERED 
(
	[classid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Student]    Script Date: 9/18/2020 9:11:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NULL,
	[age] [int] NULL,
	[mark] [float] NULL,
	[classid] [int] NOT NULL,
 CONSTRAINT [PK_Student_1] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
INSERT [dbo].[Account] ([userid], [username], [password], [email]) VALUES (1, N'Longtt', N'123456', N'longtt11@gmail.com')
INSERT [dbo].[Account] ([userid], [username], [password], [email]) VALUES (2, N'MenttC', N'123456', N'longtt123@gmail.com')
INSERT [dbo].[Account] ([userid], [username], [password], [email]) VALUES (3, N'Cent', N'123456', N'longtt123@gmail.com')
INSERT [dbo].[Account] ([userid], [username], [password], [email]) VALUES (4, N'Genk', N'123456', N'longtt1234@gmail.com')
INSERT [dbo].[Account] ([userid], [username], [password], [email]) VALUES (5, N'Blachen', N'1234566879', N'longtt567@gmail.com')
INSERT [dbo].[Account] ([userid], [username], [password], [email]) VALUES (6, N'Genkgenk', N'546123', N'change@gmail.com')
INSERT [dbo].[Account] ([userid], [username], [password], [email]) VALUES (7, N'Blangk', N'546123', N'change@gmail.com')
INSERT [dbo].[Account] ([userid], [username], [password], [email]) VALUES (8, N'Blue', N'123456123', N'genk@gmail.com')
INSERT [dbo].[Account] ([userid], [username], [password], [email]) VALUES (9, N'Henhen', N'123456', N'change@gmail.com')
SET IDENTITY_INSERT [dbo].[Class] ON 

INSERT [dbo].[Class] ([classid], [classname]) VALUES (1, N'SE1310')
INSERT [dbo].[Class] ([classid], [classname]) VALUES (2, N'SE1311')
INSERT [dbo].[Class] ([classid], [classname]) VALUES (3, N'SE1312')
INSERT [dbo].[Class] ([classid], [classname]) VALUES (4, N'SE1313')
INSERT [dbo].[Class] ([classid], [classname]) VALUES (5, N'SE1314')
INSERT [dbo].[Class] ([classid], [classname]) VALUES (6, N'SE1315')
SET IDENTITY_INSERT [dbo].[Class] OFF
SET IDENTITY_INSERT [dbo].[Student] ON 

INSERT [dbo].[Student] ([id], [name], [age], [mark], [classid]) VALUES (1, N'Nguyen Van A', 20, 10, 1)
INSERT [dbo].[Student] ([id], [name], [age], [mark], [classid]) VALUES (2, N'Anton', 20, 9, 2)
INSERT [dbo].[Student] ([id], [name], [age], [mark], [classid]) VALUES (3, N'Long Sensei', 20, 8, 2)
INSERT [dbo].[Student] ([id], [name], [age], [mark], [classid]) VALUES (4, N'Donal Trump', 20, 7, 1)
INSERT [dbo].[Student] ([id], [name], [age], [mark], [classid]) VALUES (5, N'Back', 20, 10, 2)
INSERT [dbo].[Student] ([id], [name], [age], [mark], [classid]) VALUES (6, N'AAAA', 10, 2.1, 6)
INSERT [dbo].[Student] ([id], [name], [age], [mark], [classid]) VALUES (7, N'Bla Bla', 20, 8, 3)
INSERT [dbo].[Student] ([id], [name], [age], [mark], [classid]) VALUES (8, N'Vina cafe', 20, 5, 2)
INSERT [dbo].[Student] ([id], [name], [age], [mark], [classid]) VALUES (9, N'Blush', 20, 4, 2)
INSERT [dbo].[Student] ([id], [name], [age], [mark], [classid]) VALUES (10, N'Genk genk', 20, 7, 4)
INSERT [dbo].[Student] ([id], [name], [age], [mark], [classid]) VALUES (11, N'Back ground', 20, 5, 5)
SET IDENTITY_INSERT [dbo].[Student] OFF
ALTER TABLE [dbo].[Student]  WITH CHECK ADD  CONSTRAINT [FK__Student__classid__49C3F6B7] FOREIGN KEY([classid])
REFERENCES [dbo].[Class] ([classid])
GO
ALTER TABLE [dbo].[Student] CHECK CONSTRAINT [FK__Student__classid__49C3F6B7]
GO
USE [master]
GO
ALTER DATABASE [Account] SET  READ_WRITE 
GO
