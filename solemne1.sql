-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-06-2022 a las 06:10:23
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `solemne1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbladministrador`
--

CREATE TABLE `tbladministrador` (
  `idadministrador` int(11) NOT NULL,
  `rut` varchar(13) COLLATE utf8mb4_spanish_ci NOT NULL,
  `clave` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tbladministrador`
--

INSERT INTO `tbladministrador` (`idadministrador`, `rut`, `clave`) VALUES
(4, '20333228-9', 1111);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblentrenador`
--

CREATE TABLE `tblentrenador` (
  `identrenador` int(11) NOT NULL,
  `rut` varchar(13) COLLATE utf8mb4_spanish_ci NOT NULL,
  `clave` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tblentrenador`
--

INSERT INTO `tblentrenador` (`identrenador`, `rut`, `clave`) VALUES
(5, '20333228-9', 1111);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblevaluacion`
--

CREATE TABLE `tblevaluacion` (
  `idevaluacion` int(11) NOT NULL,
  `peso` int(11) NOT NULL,
  `estatura` double NOT NULL,
  `fecha` date NOT NULL,
  `imc` double NOT NULL,
  `estado` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `idusuario` int(11) NOT NULL,
  `identrenador` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tblevaluacion`
--

INSERT INTO `tblevaluacion` (`idevaluacion`, `peso`, `estatura`, `fecha`, `imc`, `estado`, `idusuario`, `identrenador`) VALUES
(6, 56, 1.7, '2021-07-15', 213214.241, 'seaq', 31, 5),
(7, 75, 1.76, '2021-08-23', 24.212293388429753, 'normal', 31, 5),
(8, 75, 2.1, '2021-08-24', 17.006802721088434, 'Bajo peso', 31, 5),
(9, 75, 1.79, '2021-08-20', 23.40750912892856, 'normal', 31, 5),
(10, 75, 1.76, '2022-05-12', 24.212293388429753, 'normal', 31, 5),
(11, 87, 173, '2022-06-29', 0.002906879615089044, 'Bajo peso', 31, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblpersona`
--

CREATE TABLE `tblpersona` (
  `rut` varchar(13) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `apellido` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `fono` int(9) NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tblpersona`
--

INSERT INTO `tblpersona` (`rut`, `nombre`, `apellido`, `direccion`, `fono`, `email`) VALUES
('20333228-9', 'elias benjamin', 'molina silva', 'direccion x', 967462312, 'eliasmolina_conta@hotmail.com'),
('22222222-2', 'perro', 'perro', 'perro', 111111111, 'perro@perro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblusuario`
--

CREATE TABLE `tblusuario` (
  `idusuario` int(11) NOT NULL,
  `rut` varchar(13) COLLATE utf8mb4_spanish_ci NOT NULL,
  `clave` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `tblusuario`
--

INSERT INTO `tblusuario` (`idusuario`, `rut`, `clave`) VALUES
(31, '20333228-9', 1111);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbladministrador`
--
ALTER TABLE `tbladministrador`
  ADD PRIMARY KEY (`idadministrador`),
  ADD UNIQUE KEY `rut` (`rut`);

--
-- Indices de la tabla `tblentrenador`
--
ALTER TABLE `tblentrenador`
  ADD PRIMARY KEY (`identrenador`),
  ADD UNIQUE KEY `rut` (`rut`);

--
-- Indices de la tabla `tblevaluacion`
--
ALTER TABLE `tblevaluacion`
  ADD PRIMARY KEY (`idevaluacion`),
  ADD KEY `idusuario` (`idusuario`,`identrenador`),
  ADD KEY `identrenador` (`identrenador`);

--
-- Indices de la tabla `tblpersona`
--
ALTER TABLE `tblpersona`
  ADD PRIMARY KEY (`rut`);

--
-- Indices de la tabla `tblusuario`
--
ALTER TABLE `tblusuario`
  ADD PRIMARY KEY (`idusuario`),
  ADD UNIQUE KEY `rut` (`rut`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbladministrador`
--
ALTER TABLE `tbladministrador`
  MODIFY `idadministrador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tblentrenador`
--
ALTER TABLE `tblentrenador`
  MODIFY `identrenador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tblevaluacion`
--
ALTER TABLE `tblevaluacion`
  MODIFY `idevaluacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `tblusuario`
--
ALTER TABLE `tblusuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbladministrador`
--
ALTER TABLE `tbladministrador`
  ADD CONSTRAINT `tbladministrador_ibfk_1` FOREIGN KEY (`rut`) REFERENCES `tblpersona` (`rut`);

--
-- Filtros para la tabla `tblentrenador`
--
ALTER TABLE `tblentrenador`
  ADD CONSTRAINT `tblentrenador_ibfk_1` FOREIGN KEY (`rut`) REFERENCES `tblpersona` (`rut`);

--
-- Filtros para la tabla `tblevaluacion`
--
ALTER TABLE `tblevaluacion`
  ADD CONSTRAINT `tblevaluacion_ibfk_1` FOREIGN KEY (`idusuario`) REFERENCES `tblusuario` (`idusuario`),
  ADD CONSTRAINT `tblevaluacion_ibfk_2` FOREIGN KEY (`identrenador`) REFERENCES `tblentrenador` (`identrenador`);

--
-- Filtros para la tabla `tblusuario`
--
ALTER TABLE `tblusuario`
  ADD CONSTRAINT `tblusuario_ibfk_1` FOREIGN KEY (`rut`) REFERENCES `tblpersona` (`rut`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
