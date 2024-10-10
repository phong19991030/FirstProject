-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.6.5-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for demo
CREATE DATABASE IF NOT EXISTS `demo` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_vietnamese_ci */;
USE `demo`;

-- Dumping structure for table demo.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `imgPath` varchar(255) DEFAULT NULL,
  `product_type_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `age` int(50) DEFAULT NULL,
  `price` Double DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `img_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table demo.product: ~2 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `create_time`, `created_by`, `update_time`, `updated_by`, `imgPath`, `product_type_id`, `name`, `code`, `age`, `price`, `status`, `img_path`) VALUES
	(95, NULL, NULL, NULL, NULL, NULL, 96, 'Nguyễn Chung Phong 1', '123', 18, 123123, 1, 'vdtc_eparking.png'),
	(97, NULL, NULL, NULL, NULL, NULL, 95, 'Nguyễn Chung Phong', '1234', 18, 123123, 1, 'vdtc_eparking.png'),
	(98, NULL, NULL, NULL, NULL, NULL, 95, 'Nguyễn Chung Phong 2', '12345', 18, 1421240, 1, 'images.jpg'),
	(99, NULL, NULL, NULL, NULL, NULL, 96, 'Anh Tuan 22222', '12312', 28, 123123, 1, 'vdtc_eparking.png'),
	(100, NULL, NULL, NULL, NULL, NULL, 96, 'Anh Tuan 22222', '12312', 28, 123123, 1, 'vdtc_eparking.png'),
	(101, NULL, NULL, NULL, NULL, NULL, 96, 'Anh Tuan 22222', '12312', 28, 123123, 1, 'vdtc_eparking.png'),
	(102, NULL, NULL, NULL, NULL, NULL, 96, 'Anh Tuan 22222', '12312', 28, 123123, 1, 'vdtc_eparking.png'),
	(103, NULL, NULL, NULL, NULL, NULL, 96, 'Anh Tuan 22222', '12312', 28, 123123, 1, 'vdtc_eparking.png'),
	(104, NULL, NULL, NULL, NULL, NULL, 96, 'Anh Tuan 22222', '12312', 28, 123123, 1, 'vdtc_eparking.png'),
	(105, NULL, NULL, NULL, NULL, NULL, 96, 'Anh Tuan 22222', '12312', 28, 123123, 1, 'vdtc_eparking.png'),
	(106, NULL, NULL, NULL, NULL, NULL, 96, 'Anh Tuan 22222', '12312', 28, 123123, 1, 'vdtc_eparking.png');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping structure for table demo.product_type
CREATE TABLE IF NOT EXISTS `product_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime(6) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `imgPath` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table demo.product_type: ~0 rows (approximately)
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
INSERT INTO `product_type` (`id`, `create_time`, `created_by`, `update_time`, `updated_by`, `imgPath`, `name`, `status`) VALUES
	(95, NULL, NULL, NULL, NULL, NULL, 'đồ dùng', 1),
	(96, NULL, NULL, NULL, NULL, NULL, 'học tập', 1),
	(97, NULL, NULL, NULL, NULL, NULL, 'vớ vẩn', 1);
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
