-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         5.7.14-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para clinicadental
CREATE DATABASE IF NOT EXISTS `clinicadental` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `clinicadental`;

-- Volcando estructura para tabla clinicadental.cita
CREATE TABLE IF NOT EXISTS `cita` (
  `id_cita` int(10) NOT NULL AUTO_INCREMENT,
  `fecha_cita` date NOT NULL,
  `hora_cita` varchar(255) NOT NULL,
  `motivo` varchar(255) DEFAULT NULL,
  `id_paciente` int(11) DEFAULT NULL,
  `id_medico` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_cita`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla clinicadental.expediente_medico
CREATE TABLE IF NOT EXISTS `expediente_medico` (
  `id_expediente` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_expedicion` date DEFAULT NULL,
  `enfermedades_cronicas` varchar(200) DEFAULT NULL,
  `alergias` varchar(100) DEFAULT NULL,
  `id_paciente` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_expediente`),
  KEY `FK_expediente_medico_paciente` (`id_paciente`),
  CONSTRAINT `FK_expediente_medico_paciente` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla clinicadental.libros
CREATE TABLE IF NOT EXISTS `libros` (
  `ISBN` varchar(255) DEFAULT NULL,
  `idAutor` int(11) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `categoria` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla clinicadental.medico_dentista
CREATE TABLE IF NOT EXISTS `medico_dentista` (
  `id_medico` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido_paterno` varchar(50) DEFAULT NULL,
  `apellido_materno` varchar(50) DEFAULT NULL,
  `especialidad` varchar(50) DEFAULT NULL,
  `horario` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_medico`)
) ENGINE=InnoDB AUTO_INCREMENT=506 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla clinicadental.odontograma
CREATE TABLE IF NOT EXISTS `odontograma` (
  `id_odontograma` int(11) NOT NULL,
  `fecha_expedicion` date DEFAULT NULL,
  `hallazgo` varchar(60) DEFAULT NULL,
  `pieza` int(11) DEFAULT NULL,
  `tipo_trabajo` varchar(90) DEFAULT NULL,
  `id_paciente` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_odontograma`),
  UNIQUE KEY `id_paciente` (`id_paciente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla clinicadental.paciente
CREATE TABLE IF NOT EXISTS `paciente` (
  `id_paciente` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido_Paterno` varchar(50) NOT NULL,
  `apellido_materno` varchar(50) DEFAULT NULL,
  `genero` char(1) DEFAULT NULL,
  `calle_numero` varchar(50) DEFAULT NULL,
  `colonia` varchar(40) DEFAULT NULL,
  `codigo_postal` varchar(40) DEFAULT NULL,
  `estado` varchar(40) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contrasena` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_paciente`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla clinicadental.personal_clinica
CREATE TABLE IF NOT EXISTS `personal_clinica` (
  `id_personal` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `tipo_personal` varchar(50) NOT NULL,
  PRIMARY KEY (`id_personal`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
-- Volcando estructura para tabla clinicadental.prueba
CREATE TABLE IF NOT EXISTS `prueba` (
  `id` int(11) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
