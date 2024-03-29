USE [NewsOnline]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 05/14/2013 16:58:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[c_id] [int] IDENTITY(1,1) NOT NULL,
	[c_name] [nvarchar](50) NULL,
	[c_fatherID] [int] NOT NULL,
	[c_delete] [bit] NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[c_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Category] ON
INSERT [dbo].[Category] ([c_id], [c_name], [c_fatherID], [c_delete]) VALUES (9, N'City', 0, NULL)
INSERT [dbo].[Category] ([c_id], [c_name], [c_fatherID], [c_delete]) VALUES (10, N'Business', 0, NULL)
INSERT [dbo].[Category] ([c_id], [c_name], [c_fatherID], [c_delete]) VALUES (11, N'World', 0, NULL)
INSERT [dbo].[Category] ([c_id], [c_name], [c_fatherID], [c_delete]) VALUES (12, N'Headlines', 0, NULL)
INSERT [dbo].[Category] ([c_id], [c_name], [c_fatherID], [c_delete]) VALUES (13, N'Science', 0, NULL)
INSERT [dbo].[Category] ([c_id], [c_name], [c_fatherID], [c_delete]) VALUES (15, N'Environment', 0, NULL)
INSERT [dbo].[Category] ([c_id], [c_name], [c_fatherID], [c_delete]) VALUES (16, N'Entertainment', 0, NULL)
INSERT [dbo].[Category] ([c_id], [c_name], [c_fatherID], [c_delete]) VALUES (17, N'Sports', 0, NULL)
INSERT [dbo].[Category] ([c_id], [c_name], [c_fatherID], [c_delete]) VALUES (18, N'Cricket', 17, NULL)
INSERT [dbo].[Category] ([c_id], [c_name], [c_fatherID], [c_delete]) VALUES (19, N'Football', 17, NULL)
INSERT [dbo].[Category] ([c_id], [c_name], [c_fatherID], [c_delete]) VALUES (20, N'Tennis', 17, NULL)
SET IDENTITY_INSERT [dbo].[Category] OFF
/****** Object:  Table [dbo].[BlackListWords]    Script Date: 05/14/2013 16:58:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BlackListWords](
	[b_id] [int] IDENTITY(1,1) NOT NULL,
	[b_word] [nvarchar](100) NULL,
 CONSTRAINT [PK_BlackListWords] PRIMARY KEY CLUSTERED 
(
	[b_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 05/14/2013 16:58:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[u_id] [int] IDENTITY(1,1) NOT NULL,
	[u_name] [nvarchar](50) NULL,
	[u_password] [nvarchar](50) NULL,
	[u_email] [nvarchar](50) NULL,
	[u_address] [nvarchar](200) NULL,
	[u_tel] [nchar](12) NULL,
	[u_delete] [bit] NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[u_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 05/14/2013 16:58:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[r_id] [int] IDENTITY(1,1) NOT NULL,
	[r_name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Roles] PRIMARY KEY CLUSTERED 
(
	[r_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Publisher]    Script Date: 05/14/2013 16:58:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Publisher](
	[p_id] [int] IDENTITY(1,1) NOT NULL,
	[p_name] [nvarchar](100) NULL,
	[p_nick_name] [nvarchar](100) NULL,
	[p_email] [nvarchar](100) NULL,
	[p_password] [nvarchar](10) NULL,
	[p_tel] [nchar](12) NULL,
	[p_delete] [bit] NULL,
	[r_id] [int] NULL,
 CONSTRAINT [PK_Publisher] PRIMARY KEY CLUSTERED 
(
	[p_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Publish]    Script Date: 05/14/2013 16:58:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Publish](
	[p_id] [int] NOT NULL,
	[c_id] [int] NOT NULL,
 CONSTRAINT [PK_Publish] PRIMARY KEY CLUSTERED 
(
	[p_id] ASC,
	[c_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[News]    Script Date: 05/14/2013 16:58:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[News](
	[n_id] [int] IDENTITY(1,1) NOT NULL,
	[n_title] [nvarchar](100) NULL,
	[n_content] [nvarchar](max) NULL,
	[n_image_path] [nvarchar](100) NULL,
	[n_sumary] [nvarchar](100) NULL,
	[n_view] [int] NULL,
	[n_rank] [int] NULL,
	[n_delete] [bit] NULL,
	[p_id] [int] NOT NULL,
	[c_id] [int] NOT NULL,
 CONSTRAINT [PK_News] PRIMARY KEY CLUSTERED 
(
	[n_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Comments]    Script Date: 05/14/2013 16:58:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comments](
	[cm_id] [int] IDENTITY(1,1) NOT NULL,
	[cm_email] [nvarchar](100) NULL,
	[cm_title] [nvarchar](100) NULL,
	[cm_content] [nvarchar](200) NULL,
	[cm_delete] [bit] NOT NULL,
	[n_id] [int] NOT NULL,
 CONSTRAINT [PK_Comments] PRIMARY KEY CLUSTERED 
(
	[cm_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  ForeignKey [FK_Publisher_Roles]    Script Date: 05/14/2013 16:58:07 ******/
ALTER TABLE [dbo].[Publisher]  WITH CHECK ADD  CONSTRAINT [FK_Publisher_Roles] FOREIGN KEY([r_id])
REFERENCES [dbo].[Roles] ([r_id])
GO
ALTER TABLE [dbo].[Publisher] CHECK CONSTRAINT [FK_Publisher_Roles]
GO
/****** Object:  ForeignKey [FK_Publish_Category]    Script Date: 05/14/2013 16:58:07 ******/
ALTER TABLE [dbo].[Publish]  WITH CHECK ADD  CONSTRAINT [FK_Publish_Category] FOREIGN KEY([c_id])
REFERENCES [dbo].[Category] ([c_id])
GO
ALTER TABLE [dbo].[Publish] CHECK CONSTRAINT [FK_Publish_Category]
GO
/****** Object:  ForeignKey [FK_Publish_Publisher]    Script Date: 05/14/2013 16:58:07 ******/
ALTER TABLE [dbo].[Publish]  WITH CHECK ADD  CONSTRAINT [FK_Publish_Publisher] FOREIGN KEY([p_id])
REFERENCES [dbo].[Publisher] ([p_id])
GO
ALTER TABLE [dbo].[Publish] CHECK CONSTRAINT [FK_Publish_Publisher]
GO
/****** Object:  ForeignKey [FK_News_Category]    Script Date: 05/14/2013 16:58:07 ******/
ALTER TABLE [dbo].[News]  WITH CHECK ADD  CONSTRAINT [FK_News_Category] FOREIGN KEY([c_id])
REFERENCES [dbo].[Category] ([c_id])
GO
ALTER TABLE [dbo].[News] CHECK CONSTRAINT [FK_News_Category]
GO
/****** Object:  ForeignKey [FK_News_Publisher]    Script Date: 05/14/2013 16:58:07 ******/
ALTER TABLE [dbo].[News]  WITH CHECK ADD  CONSTRAINT [FK_News_Publisher] FOREIGN KEY([p_id])
REFERENCES [dbo].[Publisher] ([p_id])
GO
ALTER TABLE [dbo].[News] CHECK CONSTRAINT [FK_News_Publisher]
GO
/****** Object:  ForeignKey [FK_Comments_News]    Script Date: 05/14/2013 16:58:07 ******/
ALTER TABLE [dbo].[Comments]  WITH CHECK ADD  CONSTRAINT [FK_Comments_News] FOREIGN KEY([n_id])
REFERENCES [dbo].[News] ([n_id])
GO
ALTER TABLE [dbo].[Comments] CHECK CONSTRAINT [FK_Comments_News]
GO
