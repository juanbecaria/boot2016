USE [master]
GO
/****** Object:  Database [Bootcamp]    Script Date: 9/27/2016 3:01:19 PM ******/
CREATE DATABASE [Bootcamp]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Bootcamp', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\Bootcamp.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Bootcamp_log', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\Bootcamp_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [Bootcamp] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Bootcamp].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Bootcamp] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Bootcamp] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Bootcamp] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Bootcamp] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Bootcamp] SET ARITHABORT OFF 
GO
ALTER DATABASE [Bootcamp] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Bootcamp] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Bootcamp] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Bootcamp] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Bootcamp] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Bootcamp] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Bootcamp] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Bootcamp] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Bootcamp] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Bootcamp] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Bootcamp] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Bootcamp] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Bootcamp] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Bootcamp] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Bootcamp] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Bootcamp] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Bootcamp] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Bootcamp] SET RECOVERY FULL 
GO
ALTER DATABASE [Bootcamp] SET  MULTI_USER 
GO
ALTER DATABASE [Bootcamp] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Bootcamp] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Bootcamp] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Bootcamp] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Bootcamp] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Bootcamp', N'ON'
GO
ALTER DATABASE [Bootcamp] SET QUERY_STORE = OFF
GO
USE [Bootcamp]
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [Bootcamp]
GO
/****** Object:  Table [dbo].[Atmosfera]    Script Date: 9/27/2016 3:01:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Atmosfera](
	[fecha] [date] NOT NULL,
	[ciudad] [nvarchar](50) NOT NULL,
	[pais] [nvarchar](50) NOT NULL,
	[region] [nvarchar](50) NOT NULL,
	[presion] [float] NULL,
	[visivilidad] [float] NULL,
	[ambienteAscendente] [float] NULL,
	[humedad] [float] NULL,
 CONSTRAINT [PK_Atmosfera] PRIMARY KEY CLUSTERED 
(
	[fecha] ASC,
	[ciudad] ASC,
	[pais] ASC,
	[region] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DiaActual]    Script Date: 9/27/2016 3:01:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DiaActual](
	[fecha] [date] NOT NULL,
	[ciudad] [nvarchar](50) NOT NULL,
	[pais] [nvarchar](50) NOT NULL,
	[region] [nvarchar](50) NOT NULL,
	[temperatura] [float] NULL,
	[descripcion] [nvarchar](50) NULL,
 CONSTRAINT [PK_DiaActual] PRIMARY KEY CLUSTERED 
(
	[fecha] ASC,
	[ciudad] ASC,
	[pais] ASC,
	[region] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Localidad]    Script Date: 9/27/2016 3:01:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Localidad](
	[ciudad] [nvarchar](50) NOT NULL,
	[pais] [nvarchar](50) NOT NULL,
	[region] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Localidad] PRIMARY KEY CLUSTERED 
(
	[ciudad] ASC,
	[pais] ASC,
	[region] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Pronostico]    Script Date: 9/27/2016 3:01:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pronostico](
	[fecha] [date] NOT NULL,
	[ciudad] [nvarchar](50) NOT NULL,
	[pais] [nvarchar](50) NOT NULL,
	[region] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Pronostico] PRIMARY KEY CLUSTERED 
(
	[fecha] ASC,
	[ciudad] ASC,
	[pais] ASC,
	[region] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PronosticoExtendido]    Script Date: 9/27/2016 3:01:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PronosticoExtendido](
	[fechaDia] [date] NOT NULL,
	[fechaPronostico] [date] NOT NULL,
	[ciudad] [nvarchar](50) NOT NULL,
	[pais] [nvarchar](50) NOT NULL,
	[region] [nvarchar](50) NOT NULL,
	[minima] [int] NULL,
	[maxima] [int] NULL,
	[descripcion] [nvarchar](50) NULL,
	[nombre] [nchar](10) NULL,
 CONSTRAINT [PK_Dia] PRIMARY KEY CLUSTERED 
(
	[fechaDia] ASC,
	[fechaPronostico] ASC,
	[ciudad] ASC,
	[pais] ASC,
	[region] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Viento]    Script Date: 9/27/2016 3:01:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Viento](
	[fecha] [date] NOT NULL,
	[ciudad] [nvarchar](50) NOT NULL,
	[pais] [nvarchar](50) NOT NULL,
	[region] [nvarchar](50) NOT NULL,
	[velocidad] [float] NULL,
	[direccion] [float] NULL,
 CONSTRAINT [PK_Viento] PRIMARY KEY CLUSTERED 
(
	[fecha] ASC,
	[ciudad] ASC,
	[pais] ASC,
	[region] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[Atmosfera]  WITH CHECK ADD  CONSTRAINT [FK_Atmosfera_Pronostico] FOREIGN KEY([fecha], [ciudad], [pais], [region])
REFERENCES [dbo].[Pronostico] ([fecha], [ciudad], [pais], [region])
GO
ALTER TABLE [dbo].[Atmosfera] CHECK CONSTRAINT [FK_Atmosfera_Pronostico]
GO
ALTER TABLE [dbo].[DiaActual]  WITH CHECK ADD  CONSTRAINT [FK_DiaActual_Pronostico] FOREIGN KEY([fecha], [ciudad], [pais], [region])
REFERENCES [dbo].[Pronostico] ([fecha], [ciudad], [pais], [region])
GO
ALTER TABLE [dbo].[DiaActual] CHECK CONSTRAINT [FK_DiaActual_Pronostico]
GO
ALTER TABLE [dbo].[Pronostico]  WITH CHECK ADD  CONSTRAINT [FK_Pronostico_Localidad] FOREIGN KEY([ciudad], [pais], [region])
REFERENCES [dbo].[Localidad] ([ciudad], [pais], [region])
GO
ALTER TABLE [dbo].[Pronostico] CHECK CONSTRAINT [FK_Pronostico_Localidad]
GO
ALTER TABLE [dbo].[PronosticoExtendido]  WITH CHECK ADD  CONSTRAINT [FK_Dia_Pronostico] FOREIGN KEY([fechaPronostico], [ciudad], [pais], [region])
REFERENCES [dbo].[Pronostico] ([fecha], [ciudad], [pais], [region])
GO
ALTER TABLE [dbo].[PronosticoExtendido] CHECK CONSTRAINT [FK_Dia_Pronostico]
GO
ALTER TABLE [dbo].[Viento]  WITH CHECK ADD  CONSTRAINT [FK_Viento_Pronostico] FOREIGN KEY([fecha], [ciudad], [pais], [region])
REFERENCES [dbo].[Pronostico] ([fecha], [ciudad], [pais], [region])
GO
ALTER TABLE [dbo].[Viento] CHECK CONSTRAINT [FK_Viento_Pronostico]
GO
USE [master]
GO
ALTER DATABASE [Bootcamp] SET  READ_WRITE 
GO
