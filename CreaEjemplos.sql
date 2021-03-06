USE [master]
GO
/****** Object:  Database [Ejemplos]    Script Date: 29/10/2019 9:27:56 ******/
CREATE DATABASE [Ejemplos]

GO
ALTER DATABASE [Ejemplos] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Ejemplos].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Ejemplos] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Ejemplos] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Ejemplos] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Ejemplos] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Ejemplos] SET ARITHABORT OFF 
GO
ALTER DATABASE [Ejemplos] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Ejemplos] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Ejemplos] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Ejemplos] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Ejemplos] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Ejemplos] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Ejemplos] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Ejemplos] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Ejemplos] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Ejemplos] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Ejemplos] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Ejemplos] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Ejemplos] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Ejemplos] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Ejemplos] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Ejemplos] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Ejemplos] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Ejemplos] SET RECOVERY FULL 
GO
ALTER DATABASE [Ejemplos] SET  MULTI_USER 
GO
ALTER DATABASE [Ejemplos] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Ejemplos] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Ejemplos] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Ejemplos] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Ejemplos] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Ejemplos', N'ON'
GO
USE [Ejemplos]
GO
/****** Object:  Table [dbo].[Criaturitas]    Script Date: 29/10/2019 9:27:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Criaturitas](
	[ID] [tinyint] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](30) NULL,
 CONSTRAINT [PK_Criaturitas] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Gente]    Script Date: 29/10/2019 9:27:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Gente](
	[Nombre] [nvarchar](30) NULL,
	[Altura] [smallint] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Palabras]    Script Date: 29/10/2019 9:27:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Palabras](
	[ID] [smallint] IDENTITY(1,1) NOT NULL,
	[Palabra] [varchar](30) NULL,
 CONSTRAINT [PK_Palabras] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Palabras2]    Script Date: 29/10/2019 9:27:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Palabras2](
	[ID] [smallint] IDENTITY(1,1) NOT NULL,
	[Palabra] [varchar](20) NOT NULL,
 CONSTRAINT [PKPalabras2] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Personas]    Script Date: 29/10/2019 9:27:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Personas](
	[Nombre] [nvarchar](30) NULL,
	[Altura] [smallint] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Regalos]    Script Date: 29/10/2019 9:27:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Regalos](
	[ID] [tinyint] NOT NULL,
	[Denominacion] [nvarchar](50) NOT NULL,
	[Ancho] [tinyint] NULL,
	[Largo] [tinyint] NULL,
	[Alto] [tinyint] NULL,
	[Tipo] [char](1) NULL,
	[EdadMinima] [tinyint] NOT NULL,
	[Precio] [smallmoney] NOT NULL,
	[Superficie]  AS (CONVERT([smallint],[Ancho])*[Largo]),
	[GoesTo] [tinyint] NULL,
 CONSTRAINT [PK_Regalos] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TestRethrow]    Script Date: 29/10/2019 9:27:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TestRethrow](
	[ID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[Regalos Por Criaturita]    Script Date: 29/10/2019 9:27:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--Nos da los ids y nombres de las criaturitas y todos sus regalos
Create View [dbo].[Regalos Por Criaturita] AS
SELECT C.ID, C.Nombre, R.Denominacion FROM Criaturitas AS C
	Inner JOIN Regalos AS R ON C.ID = R.GoesTo
GO
SET IDENTITY_INSERT [dbo].[Criaturitas] ON 

INSERT [dbo].[Criaturitas] ([ID], [Nombre]) VALUES (1, N'Adela')
INSERT [dbo].[Criaturitas] ([ID], [Nombre]) VALUES (2, N'Cristina')
INSERT [dbo].[Criaturitas] ([ID], [Nombre]) VALUES (3, N'Diego')
INSERT [dbo].[Criaturitas] ([ID], [Nombre]) VALUES (4, N'Enrique')
INSERT [dbo].[Criaturitas] ([ID], [Nombre]) VALUES (5, N'Iñigo')
INSERT [dbo].[Criaturitas] ([ID], [Nombre]) VALUES (6, N'Adela')
INSERT [dbo].[Criaturitas] ([ID], [Nombre]) VALUES (7, N'Cristina')
INSERT [dbo].[Criaturitas] ([ID], [Nombre]) VALUES (8, N'Diego')
INSERT [dbo].[Criaturitas] ([ID], [Nombre]) VALUES (9, N'Enrique')
INSERT [dbo].[Criaturitas] ([ID], [Nombre]) VALUES (10, N'Iñigo')
INSERT [dbo].[Criaturitas] ([ID], [Nombre]) VALUES (13, N'Obdulia')
INSERT [dbo].[Criaturitas] ([ID], [Nombre]) VALUES (14, N'Aniceto')
INSERT [dbo].[Criaturitas] ([ID], [Nombre]) VALUES (15, N'Restituto')
SET IDENTITY_INSERT [dbo].[Criaturitas] OFF
INSERT [dbo].[Gente] ([Nombre], [Altura]) VALUES (N'Enrique', 175)
INSERT [dbo].[Gente] ([Nombre], [Altura]) VALUES (N'Cristina', 172)
INSERT [dbo].[Gente] ([Nombre], [Altura]) VALUES (N'Diego', 170)
SET IDENTITY_INSERT [dbo].[Palabras] ON 

INSERT [dbo].[Palabras] ([ID], [Palabra]) VALUES (9, N'palabra1')
INSERT [dbo].[Palabras] ([ID], [Palabra]) VALUES (10, N'palabra2')
INSERT [dbo].[Palabras] ([ID], [Palabra]) VALUES (11, N'palabra3')
INSERT [dbo].[Palabras] ([ID], [Palabra]) VALUES (12, N'palabra1')
INSERT [dbo].[Palabras] ([ID], [Palabra]) VALUES (13, N'palabra2')
INSERT [dbo].[Palabras] ([ID], [Palabra]) VALUES (14, N'palabra3')
INSERT [dbo].[Palabras] ([ID], [Palabra]) VALUES (19, N'victor1')
INSERT [dbo].[Palabras] ([ID], [Palabra]) VALUES (20, N'victor2')
SET IDENTITY_INSERT [dbo].[Palabras] OFF
SET IDENTITY_INSERT [dbo].[Palabras2] ON 

INSERT [dbo].[Palabras2] ([ID], [Palabra]) VALUES (1, N'Aprobado')
INSERT [dbo].[Palabras2] ([ID], [Palabra]) VALUES (2, N'Queso')
INSERT [dbo].[Palabras2] ([ID], [Palabra]) VALUES (3, N'Lechuga')
INSERT [dbo].[Palabras2] ([ID], [Palabra]) VALUES (4, N'Azúcar')
INSERT [dbo].[Palabras2] ([ID], [Palabra]) VALUES (5, N'Sacarina')
INSERT [dbo].[Palabras2] ([ID], [Palabra]) VALUES (6, N'Miel')
INSERT [dbo].[Palabras2] ([ID], [Palabra]) VALUES (7, N'Mermelada')
INSERT [dbo].[Palabras2] ([ID], [Palabra]) VALUES (9, N'Acerga')
INSERT [dbo].[Palabras2] ([ID], [Palabra]) VALUES (12, N'Obdulia')
INSERT [dbo].[Palabras2] ([ID], [Palabra]) VALUES (13, N'Restituto')
INSERT [dbo].[Palabras2] ([ID], [Palabra]) VALUES (14, N'Aniceto')
SET IDENTITY_INSERT [dbo].[Palabras2] OFF
INSERT [dbo].[Personas] ([Nombre], [Altura]) VALUES (N'Adela', 165)
INSERT [dbo].[Personas] ([Nombre], [Altura]) VALUES (N'Diego', 183)
INSERT [dbo].[Personas] ([Nombre], [Altura]) VALUES (N'Iñigo', 175)
INSERT [dbo].[Personas] ([Nombre], [Altura]) VALUES (N'Cristina', 172)
INSERT [dbo].[Regalos] ([ID], [Denominacion], [Ancho], [Largo], [Alto], [Tipo], [EdadMinima], [Precio], [GoesTo]) VALUES (1, N'Muñeca meona', 15, 10, 80, N'M', 3, 40.9500, 5)
INSERT [dbo].[Regalos] ([ID], [Denominacion], [Ancho], [Largo], [Alto], [Tipo], [EdadMinima], [Precio], [GoesTo]) VALUES (4, N'Exin chabola', 45, 85, 20, N'C', 6, 17.2000, 1)
INSERT [dbo].[Regalos] ([ID], [Denominacion], [Ancho], [Largo], [Alto], [Tipo], [EdadMinima], [Precio], [GoesTo]) VALUES (6, N'Action Man Latin King', 20, 15, 50, N'M', 4, 15.4800, 3)
INSERT [dbo].[Regalos] ([ID], [Denominacion], [Ancho], [Largo], [Alto], [Tipo], [EdadMinima], [Precio], [GoesTo]) VALUES (7, N'Patinete', 35, 90, 30, N'A', 6, 38.0000, 5)
INSERT [dbo].[Regalos] ([ID], [Denominacion], [Ancho], [Largo], [Alto], [Tipo], [EdadMinima], [Precio], [GoesTo]) VALUES (11, N'Trompo', 15, 15, 20, N'A', 4, 4.8000, 2)
INSERT [dbo].[Regalos] ([ID], [Denominacion], [Ancho], [Largo], [Alto], [Tipo], [EdadMinima], [Precio], [GoesTo]) VALUES (13, N'QuimiPum', 45, 75, 20, N'E', 10, 14.2500, NULL)
INSERT [dbo].[Regalos] ([ID], [Denominacion], [Ancho], [Largo], [Alto], [Tipo], [EdadMinima], [Precio], [GoesTo]) VALUES (15, N'Muñeca llorona', 15, 10, 80, N'M', 3, 36.8500, NULL)
INSERT [dbo].[Regalos] ([ID], [Denominacion], [Ancho], [Largo], [Alto], [Tipo], [EdadMinima], [Precio], [GoesTo]) VALUES (16, N'Magia Potagia', 50, 80, 20, N'S', 8, 19.7000, NULL)
INSERT [dbo].[Regalos] ([ID], [Denominacion], [Ancho], [Largo], [Alto], [Tipo], [EdadMinima], [Precio], [GoesTo]) VALUES (18, N'Enredos', 55, 65, 20, NULL, 5, 14.8500, 3)
INSERT [dbo].[Regalos] ([ID], [Denominacion], [Ancho], [Largo], [Alto], [Tipo], [EdadMinima], [Precio], [GoesTo]) VALUES (22, N'Action Man Skin Head', 20, 15, 50, N'M', 4, 15.4800, 2)
INSERT [dbo].[TestRethrow] ([ID]) VALUES (1)
INSERT [dbo].[TestRethrow] ([ID]) VALUES (2)
ALTER TABLE [dbo].[Regalos]  WITH CHECK ADD  CONSTRAINT [FK_RegalosCriaturitas] FOREIGN KEY([GoesTo])
REFERENCES [dbo].[Criaturitas] ([ID])
GO
ALTER TABLE [dbo].[Regalos] CHECK CONSTRAINT [FK_RegalosCriaturitas]
GO
USE [master]
GO
ALTER DATABASE [Ejemplos] SET  READ_WRITE 
GO
