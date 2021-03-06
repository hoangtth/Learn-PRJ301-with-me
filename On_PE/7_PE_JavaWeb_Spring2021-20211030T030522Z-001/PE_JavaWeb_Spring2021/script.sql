USE [master]
GO
/****** Object:  Database [PRJ321_SPRING2021]    Script Date: 11/3/2021 4:50:00 PM ******/
CREATE DATABASE [PRJ321_SPRING2021]

GO
USE [PRJ321_SPRING2021]
GO
/****** Object:  Table [dbo].[Event]    Script Date: 11/3/2021 4:50:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Event](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[content] [varchar](150) NOT NULL,
	[date] [date] NOT NULL,
	[isEnable] [bit] NOT NULL,
	[created_by] [varchar](150) NOT NULL,
 CONSTRAINT [PK_Event] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Record]    Script Date: 11/3/2021 4:50:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Record](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[content] [varchar](150) NOT NULL,
	[eid] [int] NOT NULL,
 CONSTRAINT [PK_Record] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Event] ON 

INSERT [dbo].[Event] ([id], [content], [date], [isEnable], [created_by]) VALUES (1, N'Event number 1', CAST(N'2021-11-03' AS Date), 1, N'quan')
INSERT [dbo].[Event] ([id], [content], [date], [isEnable], [created_by]) VALUES (2, N'Event number 2', CAST(N'2021-11-03' AS Date), 1, N'quan')
INSERT [dbo].[Event] ([id], [content], [date], [isEnable], [created_by]) VALUES (3, N'Event number 3', CAST(N'2021-11-03' AS Date), 1, N'quan')
INSERT [dbo].[Event] ([id], [content], [date], [isEnable], [created_by]) VALUES (4, N'Event number 4', CAST(N'2021-11-03' AS Date), 1, N'quan')
INSERT [dbo].[Event] ([id], [content], [date], [isEnable], [created_by]) VALUES (5, N'Event number 5', CAST(N'2021-11-03' AS Date), 1, N'quan')
SET IDENTITY_INSERT [dbo].[Event] OFF
GO
SET IDENTITY_INSERT [dbo].[Record] ON 

INSERT [dbo].[Record] ([id], [content], [eid]) VALUES (1, N'Record 1 on Event 1', 1)
INSERT [dbo].[Record] ([id], [content], [eid]) VALUES (2, N'Record 2 on Event 1', 1)
INSERT [dbo].[Record] ([id], [content], [eid]) VALUES (3, N'Record 3 on Event 1', 1)
INSERT [dbo].[Record] ([id], [content], [eid]) VALUES (4, N'Record 1 on Event 2', 2)
INSERT [dbo].[Record] ([id], [content], [eid]) VALUES (5, N'Record 2 on Event 2', 2)
SET IDENTITY_INSERT [dbo].[Record] OFF
GO
ALTER TABLE [dbo].[Event] ADD  CONSTRAINT [DF_Event_date]  DEFAULT (getdate()) FOR [date]
GO
ALTER TABLE [dbo].[Record]  WITH CHECK ADD  CONSTRAINT [FK__Record__eid__267ABA7A] FOREIGN KEY([eid])
REFERENCES [dbo].[Event] ([id])
GO
ALTER TABLE [dbo].[Record] CHECK CONSTRAINT [FK__Record__eid__267ABA7A]
GO
USE [master]
GO
ALTER DATABASE [PRJ321_SPRING2021] SET  READ_WRITE 
GO
