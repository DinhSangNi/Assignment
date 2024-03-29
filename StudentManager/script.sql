USE [master]
GO
/****** Object:  Database [StudentManager]    Script Date: 3/1/2024 2:35:42 AM ******/
CREATE DATABASE [StudentManager]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'StudentManager', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\StudentManager.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'StudentManager_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\StudentManager_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [StudentManager] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [StudentManager].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [StudentManager] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [StudentManager] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [StudentManager] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [StudentManager] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [StudentManager] SET ARITHABORT OFF 
GO
ALTER DATABASE [StudentManager] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [StudentManager] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [StudentManager] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [StudentManager] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [StudentManager] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [StudentManager] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [StudentManager] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [StudentManager] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [StudentManager] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [StudentManager] SET  ENABLE_BROKER 
GO
ALTER DATABASE [StudentManager] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [StudentManager] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [StudentManager] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [StudentManager] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [StudentManager] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [StudentManager] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [StudentManager] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [StudentManager] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [StudentManager] SET  MULTI_USER 
GO
ALTER DATABASE [StudentManager] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [StudentManager] SET DB_CHAINING OFF 
GO
ALTER DATABASE [StudentManager] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [StudentManager] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [StudentManager] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [StudentManager] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [StudentManager] SET QUERY_STORE = ON
GO
ALTER DATABASE [StudentManager] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [StudentManager]
GO
/****** Object:  Table [dbo].[Menu]    Script Date: 3/1/2024 2:35:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Menu](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Infor] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Student]    Script Date: 3/1/2024 2:35:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student](
	[ID] [int] NULL,
	[hoVaTen] [nvarchar](50) NULL,
	[diaChi] [nvarchar](50) NULL,
	[soDienThoai] [varchar](20) NULL,
	[giaoVienID] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Teacher]    Script Date: 3/1/2024 2:35:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teacher](
	[giaoVienID] [int] NULL,
	[hoTen] [nvarchar](50) NULL,
	[diaChi] [nvarchar](50) NULL,
	[matKhau] [varchar](50) NULL,
	[soDienThoai] [varchar](10) NULL,
	[monHoc] [nvarchar](50) NULL,
	[isADmin] [varchar](10) NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Menu] ON 

INSERT [dbo].[Menu] ([ID], [Infor]) VALUES (1, N'Thêm sinh viên')
INSERT [dbo].[Menu] ([ID], [Infor]) VALUES (2, N'Sửa sinh viên')
INSERT [dbo].[Menu] ([ID], [Infor]) VALUES (3, N'Xóa sinh viên')
INSERT [dbo].[Menu] ([ID], [Infor]) VALUES (4, N'Tìm kiếm')
INSERT [dbo].[Menu] ([ID], [Infor]) VALUES (5, N'Thêm giáo viên')
INSERT [dbo].[Menu] ([ID], [Infor]) VALUES (6, N'Sửa giáo viên')
INSERT [dbo].[Menu] ([ID], [Infor]) VALUES (7, N'Xóa giáo viên')
INSERT [dbo].[Menu] ([ID], [Infor]) VALUES (8, N'Logout')
INSERT [dbo].[Menu] ([ID], [Infor]) VALUES (9, N'Tạo ac admin')
SET IDENTITY_INSERT [dbo].[Menu] OFF
GO
INSERT [dbo].[Student] ([ID], [hoVaTen], [diaChi], [soDienThoai], [giaoVienID]) VALUES (1, N'Trương Đình Sang', NULL, N'1234567890', 1)
INSERT [dbo].[Student] ([ID], [hoVaTen], [diaChi], [soDienThoai], [giaoVienID]) VALUES (2, N'sa', N'sa', N'1234567890', 1)
INSERT [dbo].[Student] ([ID], [hoVaTen], [diaChi], [soDienThoai], [giaoVienID]) VALUES (3, N'Nguyễn Thái Thịnh', NULL, N'1234567890', 1)
INSERT [dbo].[Student] ([ID], [hoVaTen], [diaChi], [soDienThoai], [giaoVienID]) VALUES (4, N'Lê Nhật Huy', NULL, N'1234567890', 1)
INSERT [dbo].[Student] ([ID], [hoVaTen], [diaChi], [soDienThoai], [giaoVienID]) VALUES (5, N'Trương Đình Thiên', NULL, N'1234567890', 2)
INSERT [dbo].[Student] ([ID], [hoVaTen], [diaChi], [soDienThoai], [giaoVienID]) VALUES (6, N'Tôn Long Thiên Trườn', NULL, N'1234567890', 2)
INSERT [dbo].[Student] ([ID], [hoVaTen], [diaChi], [soDienThoai], [giaoVienID]) VALUES (7, N'Phan Thanh Duy', NULL, N'1234567890', 2)
INSERT [dbo].[Student] ([ID], [hoVaTen], [diaChi], [soDienThoai], [giaoVienID]) VALUES (1, N'sang', N'sang', N'1234567890', 1)
INSERT [dbo].[Student] ([ID], [hoVaTen], [diaChi], [soDienThoai], [giaoVienID]) VALUES (9, N'Truong Dinh Sang', NULL, NULL, NULL)
INSERT [dbo].[Student] ([ID], [hoVaTen], [diaChi], [soDienThoai], [giaoVienID]) VALUES (10, N'ta', N'ta', N'1234567890', 1)
GO
INSERT [dbo].[Teacher] ([giaoVienID], [hoTen], [diaChi], [matKhau], [soDienThoai], [monHoc], [isADmin]) VALUES (2, N'1', N'1', N'1', N'1234567890', N'1', N'no')
GO
USE [master]
GO
ALTER DATABASE [StudentManager] SET  READ_WRITE 
GO
