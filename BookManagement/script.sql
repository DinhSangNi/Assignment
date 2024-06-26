USE [master]
GO
/****** Object:  Database [BookManagement]    Script Date: 4/2/2024 1:04:52 PM ******/
CREATE DATABASE [BookManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BookManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\BookManagement.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BookManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\BookManagement_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [BookManagement] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BookManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BookManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BookManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BookManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BookManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BookManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [BookManagement] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [BookManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BookManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BookManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BookManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BookManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BookManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BookManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BookManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BookManagement] SET  ENABLE_BROKER 
GO
ALTER DATABASE [BookManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BookManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BookManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BookManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BookManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BookManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BookManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BookManagement] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BookManagement] SET  MULTI_USER 
GO
ALTER DATABASE [BookManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BookManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BookManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BookManagement] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BookManagement] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BookManagement] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [BookManagement] SET QUERY_STORE = ON
GO
ALTER DATABASE [BookManagement] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [BookManagement]
GO
/****** Object:  Table [dbo].[Book]    Script Date: 4/2/2024 1:04:52 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Book](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[book_code] [varchar](10) NOT NULL,
	[book_name] [nvarchar](100) NULL,
	[book_title] [nvarchar](100) NULL,
	[decription] [text] NULL,
	[type] [nvarchar](50) NULL,
	[price] [decimal](10, 2) NULL,
	[created_at] [datetime] NULL,
	[update_at] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[book_code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Book] ON 

INSERT [dbo].[Book] ([id], [book_code], [book_name], [book_title], [decription], [type], [price], [created_at], [update_at]) VALUES (1, N'QN001', N'You And Me', N'Alan', N'Very good', N'Romance', CAST(50000.00 AS Decimal(10, 2)), CAST(N'2024-03-24T23:56:00.970' AS DateTime), CAST(N'2024-03-24T23:57:08.737' AS DateTime))
INSERT [dbo].[Book] ([id], [book_code], [book_name], [book_title], [decription], [type], [price], [created_at], [update_at]) VALUES (2, N'QN002', N'Lan Va Diep', N'Vu Linh', N'Very good', N'Romance', CAST(50000.00 AS Decimal(10, 2)), CAST(N'2024-03-24T23:56:00.970' AS DateTime), CAST(N'2024-03-25T11:48:56.847' AS DateTime))
INSERT [dbo].[Book] ([id], [book_code], [book_name], [book_title], [decription], [type], [price], [created_at], [update_at]) VALUES (3, N'QN003', N'Chanh Mat Ong', N'AZB', N'Very good', N'Romance', CAST(50000.00 AS Decimal(10, 2)), CAST(N'2024-03-24T23:56:00.970' AS DateTime), CAST(N'2024-03-24T23:56:00.970' AS DateTime))
INSERT [dbo].[Book] ([id], [book_code], [book_name], [book_title], [decription], [type], [price], [created_at], [update_at]) VALUES (4, N'QN004', N'You And Me', N'Alan', N'Very good', N'Romance', CAST(50000.00 AS Decimal(10, 2)), CAST(N'2024-03-25T11:48:08.760' AS DateTime), CAST(N'2024-03-25T11:48:08.760' AS DateTime))
SET IDENTITY_INSERT [dbo].[Book] OFF
GO
/****** Object:  StoredProcedure [dbo].[Paging]    Script Date: 4/2/2024 1:04:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- Stored Procedure 
CREATE PROC [dbo].[Paging]
(
	@PageIndex int,
	@PageNum int
)
AS
BEGIN
	Declare @CurrentRow int = ( @PageIndex - 1 ) * @PageNum
	Declare @TotalRow int = (SELECT COUNT(*) FROM Book)

	SELECT * FROM Book
	ORDER BY id
	OFFSEt @CurrentRow ROWS
	FETCH NEXT @PageNum ROWS ONLY
ENd
GO
USE [master]
GO
ALTER DATABASE [BookManagement] SET  READ_WRITE 
GO
