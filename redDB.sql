-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-05-2018 a las 05:17:13
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `redDB_red`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE IF NOT EXISTS `administrador` (
  `id_administrador` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(40) NOT NULL,
  `clave` varchar(40) NOT NULL,
  PRIMARY KEY (`id_administrador`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id_administrador`, `correo`, `clave`) VALUES
(1, 'admin@root.com', '12345');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `amigo`
--

CREATE TABLE IF NOT EXISTS `amigo` (
  `id_amigo` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuarioE` int(11) NOT NULL,
  `id_usuarioR` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id_amigo`),
  KEY `id_usuarioE` (`id_usuarioE`),
  KEY `id_usuarioR` (`id_usuarioR`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=33 ;

--
-- Volcado de datos para la tabla `amigo`
--

INSERT INTO `amigo` (`id_amigo`, `id_usuarioE`, `id_usuarioR`, `fecha`) VALUES
(3, 27, 19, '2021-05-11 12:52:47'),
(23, 32, 27, '2021-05-13 22:17:37'),
(24, 36, 27, '2021-05-13 22:24:08'),
(25, 22, 27, '2021-05-13 22:28:43'),
(26, 37, 27, '2021-05-14 00:27:23'),
(27, 40, 27, '2021-05-13 22:17:37'),
(28, 41, 40, '2021-05-14 13:30:46'),
(30, 44, 35, '2021-05-16 08:05:53'),
(31, 45, 44, '2021-05-16 10:37:39'),
(32, 47, 48, '2021-05-16 14:30:28');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `chat`
--

CREATE TABLE IF NOT EXISTS `chat` (
  `id_chat` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuarioE` int(11) NOT NULL,
  `id_usuarioR` int(11) NOT NULL,
  PRIMARY KEY (`id_chat`),
  KEY `id_usuarioE` (`id_usuarioE`),
  KEY `id_usuarioR` (`id_usuarioR`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `chat`
--

INSERT INTO `chat` (`id_chat`, `id_usuarioE`, `id_usuarioR`) VALUES
(8, 37, 27),
(9, 27, 38),
(10, 40, 20),
(11, 40, 41),
(12, 44, 19),
(13, 45, 44),
(14, 46, 44),
(15, 48, 47);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE IF NOT EXISTS `ciudad` (
  `id_ciudad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `id_pais` int(11) NOT NULL,
  PRIMARY KEY (`id_ciudad`),
  KEY `id_pais` (`id_pais`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`id_ciudad`, `nombre`, `id_pais`) VALUES
(1, 'Buenos Aires', 1),
(2, 'Campana', 1),
(3, 'Bolivar', 1),
(4, 'Moreno', 1),
(5, 'Lomas de Zamora', 1),
(6, 'Tigre', 1),
(7, 'San Isidro', 1),
(8, 'Lanús', 1),
(9, 'Quilmes', 1),
(10, 'Vicente Lopez', 1),
(11, 'San Martín', 1),
(13, 'La Plata', 1),
(14, 'Ezeiza', 1),
(15, 'Montevideo', 2),
(16, 'Punta del Este', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE IF NOT EXISTS `comentario` (
  `id_comentario` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `id_publicacion` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `comentario` varchar(125) NOT NULL,
  PRIMARY KEY (`id_comentario`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_publicacion` (`id_publicacion`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=85 ;

--
-- Volcado de datos para la tabla `comentario`
--

INSERT INTO `comentario` (`id_comentario`, `id_usuario`, `id_publicacion`, `fecha`, `comentario`) VALUES
(48, 27, 72, '2018-05-12 11:20:47', 'aca'),
(49, 27, 72, '2018-05-12 11:23:22', 'hola'),
(54, 27, 72, '2018-05-12 13:24:06', 'ayer'),
(55, 27, 72, '2018-05-12 13:24:10', 'nada'),
(56, 33, 76, '2018-05-12 13:56:02', 'comentario'),
(58, 35, 77, '2018-05-12 19:38:30', 'Hey'),
(59, 27, 72, '2018-05-12 19:47:03', 'batman'),
(62, 27, 75, '2018-05-12 20:37:58', 'aqui'),
(63, 27, 72, '2018-05-12 20:38:18', 'alla'),
(64, 27, 72, '2018-05-12 20:52:14', '54562132156'),
(66, 27, 72, '2018-05-12 21:01:26', 'no se'),
(68, 27, 72, '2018-05-12 21:08:04', ':v'),
(69, 27, 83, '2018-05-12 21:20:05', ':v'),
(70, 27, 84, '2018-05-13 20:27:04', 'no mames campeón'),
(71, 27, 72, '2018-05-13 20:28:12', 'vamos tigre'),
(72, 27, 86, '2018-05-13 22:27:47', 'y comento relajadito:v'),
(73, 27, 85, '2018-05-13 22:28:34', ':Vv'),
(74, 27, 78, '2018-05-14 00:43:36', 'que pasa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE IF NOT EXISTS `mensaje` (
  `id_mensaje` int(11) NOT NULL AUTO_INCREMENT,
  `id_chat` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `mensaje` text NOT NULL,
  `envia` varchar(199) DEFAULT NULL,
  PRIMARY KEY (`id_mensaje`),
  KEY `id_chat` (`id_chat`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=75 ;

--
-- Volcado de datos para la tabla `mensaje`
--

INSERT INTO `mensaje` (`id_mensaje`, `id_chat`, `fecha`, `mensaje`, `envia`) VALUES
(64, 13, '2021-05-16 10:52:22', '4!3!1''s1(V', 'Pedro'),
(65, 13, '2021-05-16 10:53:01', ' <5', 'Pedro'),
(66, 13, '2021-05-16 10:53:23', '0!#7', 'miguel'),
(67, 13, '2021-05-16 10:53:50', '''&''0!)', 'miguel'),
(68, 13, '2021-05-16 10:55:12', '/', 'migueñ'),
(69, 13, '2021-05-16 11:00:23', '~%', 'Pedro'),
(70, 14, '2021-05-16 13:24:56', ',<*%s', 'Pablo'),
(71, 14, '2021-05-16 13:25:18', 'j?h', 'miguel'),
(72, 15, '2021-05-16 14:31:19', ')6(72,6', 'Jose'),
(73, 15, '2021-05-16 14:31:29', '5&#d#'' %fN]@', 'Marcelo'),
(74, 15, '2021-05-16 14:31:38', ',<*%', 'Jose');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE IF NOT EXISTS `pais` (
  `id_pais` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_pais`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`id_pais`, `nombre`) VALUES
(1, 'Argentina'),
(2, 'Uruguay');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicacion`
--

CREATE TABLE IF NOT EXISTS `publicacion` (
  `id_publicacion` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `publicacion` tinytext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `foto` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id_publicacion`),
  KEY `id_usuario` (`id_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=103 ;

--
-- Volcado de datos para la tabla `publicacion`
--

INSERT INTO `publicacion` (`id_publicacion`, `id_usuario`, `fecha`, `publicacion`, `foto`) VALUES
(67, 27, '2021-05-11 12:52:47', 'adasdasd', 'perfil.png'),
(72, 19, '2021-05-12 11:07:46', 'puta vida', 'perfil.png'),
(75, 27, '2021-05-12 13:22:38', 'oie shiiico', 'perfil.png'),
(76, 33, '2021-05-12 13:55:50', 'pubicacion de mi abuela', 'perfil.png'),
(77, 35, '2021-05-12 19:38:24', 'publicacion editada papu :V<br>', 'perfil.png'),
(78, 37, '2021-05-12 20:21:19', 'aca', 'perfil.png'),
(79, 37, '2021-05-12 20:21:57', 'asda', 'perfil.png'),
(81, 36, '2021-05-12 20:29:56', 'adadsa', 'perfil.png'),
(83, 27, '2021-05-12 21:20:01', 'asdasd', 'perfil.png'),
(84, 27, '2021-05-13 20:26:57', 'calvo', 'perfil.png'),
(85, 27, '2021-05-13 20:47:07', 'asdasdasd', 'perfil.png'),
(86, 27, '2021-05-13 22:27:40', 'publico relajadito :v<br>', 'perfil.png'),
(89, 38, '2021-05-14 00:51:37', 'publica normal?<br>', 'perfil.png'),
(90, 39, '2021-05-14 01:19:12', 'nada por aqui', 'perfil.png'),
(92, 40, '2021-05-14 11:39:39', 'publica wey<br>', 'perfil.png'),
(93, 40, '2021-05-14 13:22:07', 'y si', 'perfil.png'),
(94, 40, '2021-05-14 13:23:38', 'miguel', 'perfil.png'),
(95, 40, '2021-05-14 13:28:15', 'mamiiii', 'perfil.png'),
(96, 40, '2021-05-14 13:28:47', 'shorooo', 'perfil.png'),
(97, 40, '2021-05-14 13:29:11', 'si publico aca', 'perfil.png'),
(98, 41, '2021-05-14 13:31:31', 'primera publicacion prro<br>', 'perfil.png'),
(100, 44, '2021-05-16 08:05:08', 'acacaca', 'perfil.png'),
(101, 45, '2021-05-16 10:37:53', 'la puta madre', 'perfil.png'),
(102, 47, '2021-05-16 14:27:57', 'esta es mi primera publicacion', 'perfil.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud`
--

CREATE TABLE IF NOT EXISTS `solicitud` (
  `id_solicitud` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuarioE` int(11) NOT NULL,
  `id_usuarioR` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id_solicitud`),
  KEY `id_usuarioE` (`id_usuarioE`),
  KEY `id_usuarioR` (`id_usuarioR`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Volcado de datos para la tabla `solicitud`
--

INSERT INTO `solicitud` (`id_solicitud`, `id_usuarioE`, `id_usuarioR`, `fecha`) VALUES
(6, 27, 20, '2021-05-13 20:49:59'),
(18, 27, 38, '2021-05-14 00:52:30'),
(19, 40, 20, '2021-05-14 11:30:12'),
(20, 44, 19, '2021-05-16 08:06:22'),
(21, 46, 44, '2021-05-16 13:24:14'),
(22, 47, 20, '2021-05-16 14:29:26');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `edad` int(11) NOT NULL,
  `correo` varchar(40) NOT NULL,
  `clave` text NOT NULL,
  `foto` varchar(40) NOT NULL,
  `pais` varchar(40) NOT NULL,
  `ciudad` varchar(40) NOT NULL,
  `estado` int(11) NOT NULL,
  `situacion_sentimental` varchar(30) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=49 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `edad`, `correo`, `clave`, `foto`, `pais`, `ciudad`, `estado`, `situacion_sentimental`) VALUES
(19, 'Pedro', 30, 'correoprueba@gmail.com', '1234', 'perfil.png', 'Argentina', 'Buenos Aires', 0, 'Divorciado'),
(20, 'Juan Martinez', 28, 'victorius@gmail.com', '3dc9aae309078c4cb7681132f7565b141aa1f91e64da206de1f3305def74bfcf', 'perfil.png', 'Argentina', 'Buenos Aires', 0, 'Soltero'),
(22, 'Andres Gamboa', 22, 'gamboa@gmail.coma', '1234', 'andres.hpg', 'Argentina', 'Buenos Aires', 0, 'Casado'),
(27, 'Migue ML', 20, 'calvo', 'calvo', 'perfil.png', 'Argentina', 'Buenos Aires', 0, 'Soltero'),
(32, 'Paulito Mix', 13, 'paulo@correo', 'paulo', 'foto.jpg', 'Argentina', 'Buenos Aires', 0, 'Casado'),
(33, 'paulo', 14, 'paulo2', 'paulo2', 'foto.jpg', 'Argentina', 'Buenos Aires', 0, 'Casado'),
(34, 'marulanda', 14, 'marulanda', 'marulanda', 'foto.jpg', 'Argentina', 'Buenos Aires', 0, 'Casado'),
(35, 'federico', 12, 'federico bebe', 'federico', 'foto.jpg', 'Argentina', 'Buenos Aires', 0, 'Casado'),
(36, 'Juan', 12, 'juan', 'juan', 'foto.jpg', 'Argentina', 'Buenos Aires', 0, 'Casado'),
(37, 'p', 1, 'p', 'p', 'foto.jpg', 'Argentina', 'Buenos Aires', 0, 'Casado'),
(38, 'ome', 14, 'ome', 'ome', 'foto.jpg', 'Argentina', 'Buenos Aires', 0, 'Soltero'),
(39, 'cripto2', 12, 'cripto', '52ea4d748b0a6c8d8bec475cf10c08d3aad609bf59b09be1dd2009b41adb64f2', 'foto.jpg', 'Argentina', 'Buenos Aires', 0, 'Soltero'),
(40, 'federico:v', 14, 'federico', 'cd71fa4239dac4232ed0f85d682be555798551f732d1cf655f65f86884121fe4', 'foto.jpg', 'Argentina', 'Buenos Aires', 0, 'Soltero'),
(41, 'test', 12, 'test', '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08', 'foto.jpg', 'Argentina', 'Buenos Aires', 0, 'Soltero'),
(42, 'petro', 14, 'petro', '7f39968abe16717540b152bd80ad4765555091ba7244212dcd33547094d1a1c1', 'foto.jpg', 'Argentina', 'Buenos Aires', 0, 'Soltero'),
(43, 'maria', 12, 'maria', '5ef68465886fa04d3e0bbe86b59d964dd98e5775e95717df978d8bedee6ff16c', 'foto.jpg', 'Argentina', 'Buenos Aires', 0, 'Soltero'),
(44, 'miguel M', 12, 'miguel', '5ef68465886fa04d3e0bbe86b59d964dd98e5775e95717df978d8bedee6ff16c', 'foto.jpg', 'Argentina', 'Buenos Aires', 0, 'Soltero'),
(45, 'pancracio', 122, 'pancracio', '1e49115c588c6ede452d0300e822f643ff7f759ccf39d49fdb66a601166bfe41', 'foto.jpg', 'Argentina', 'Campana', 0, 'Soltero'),
(46, 'cristhian', 12, 'fn199@g.com', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'perfil.png', 'Argentina', 'Buenos Aires', 0, 'Soltero'),
(47, 'Miguel Martinez L', 20, 'miguel@yo.co', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'perfil.png', 'Uruguay', 'Montevideo', 0, 'Casado'),
(48, 'paulo', 30, 'paulo@hotmail.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'perfil.png', 'Argentina', 'San Isidro', 0, 'Soltero');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `amigo`
--
ALTER TABLE `amigo`
  ADD CONSTRAINT `amigo_ibfk_1` FOREIGN KEY (`id_usuarioE`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `amigo_ibfk_2` FOREIGN KEY (`id_usuarioR`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `chat`
--
ALTER TABLE `chat`
  ADD CONSTRAINT `chat_ibfk_1` FOREIGN KEY (`id_usuarioE`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `chat_ibfk_2` FOREIGN KEY (`id_usuarioR`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD CONSTRAINT `ciudad_ibfk_1` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`);

--
-- Filtros para la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `comentario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `comentario_ibfk_2` FOREIGN KEY (`id_publicacion`) REFERENCES `publicacion` (`id_publicacion`);

--
-- Filtros para la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD CONSTRAINT `mensaje_ibfk_1` FOREIGN KEY (`id_chat`) REFERENCES `chat` (`id_chat`);

--
-- Filtros para la tabla `publicacion`
--
ALTER TABLE `publicacion`
  ADD CONSTRAINT `publicacion_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD CONSTRAINT `solicitud_ibfk_1` FOREIGN KEY (`id_usuarioE`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `solicitud_ibfk_2` FOREIGN KEY (`id_usuarioR`) REFERENCES `usuario` (`id_usuario`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
