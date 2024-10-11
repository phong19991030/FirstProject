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
    `product_type_id` bigint(20) DEFAULT NULL,
    `name` varchar(255) DEFAULT NULL,
    `code` varchar(255) DEFAULT NULL,
    `age` int(50) DEFAULT NULL,
    `price` double DEFAULT NULL,
    `status` int(11) DEFAULT NULL,
    `img_path` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `code` (`code`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table demo.product: ~6 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `create_time`, `created_by`, `update_time`, `updated_by`, `product_type_id`, `name`, `code`, `age`, `price`, `status`, `img_path`) VALUES
                                                                                                                                                                    (97, NULL, NULL, '2024-10-07 16:36:03.000000', NULL, 95, 'Nguyễn Chung Phong', '1234', 18, 180, 1, 'vdtc_eparking.png'),
                                                                                                                                                                    (107, NULL, NULL, '2024-10-07 16:36:15.000000', NULL, 96, 'Nguyễn Chung Phong 1', '123', 15, 100, 1, NULL),
                                                                                                                                                                    (109, '2024-10-07 16:45:57.000000', NULL, '2024-10-07 16:45:57.000000', NULL, 95, 'Đồ dùng 1', '11', 8, 123123, 1, NULL),
                                                                                                                                                                    (110, '2024-10-07 17:23:00.000000', NULL, '2024-10-07 17:23:00.000000', NULL, 96, 'Nguyễn Chung Phong 1', '12345', 1231, 123, 1, NULL),
                                                                                                                                                                    (111, '2024-10-11 08:25:42.000000', NULL, '2024-10-11 08:25:42.000000', NULL, 95, 'Nguyễn Chung Phong 1', '123456', 123, 123, 1, NULL),
                                                                                                                                                                    (112, '2024-10-11 08:34:54.000000', NULL, '2024-10-11 08:34:54.000000', NULL, 95, 'vớ vẩn', '1234567', 123, 123123, 1, 'Untitled.png');
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
    `code` varchar(10) DEFAULT NULL,
    `description` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `code` (`code`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table demo.product_type: ~2 rows (approximately)
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
INSERT INTO `product_type` (`id`, `create_time`, `created_by`, `update_time`, `updated_by`, `imgPath`, `name`, `status`, `code`, `description`) VALUES
                                                                                                                                                    (95, NULL, NULL, '2024-10-11 08:58:13.000000', NULL, NULL, 'đồ dùng', 1, '1', ''),
                                                                                                                                                    (96, NULL, NULL, '2024-10-11 08:51:07.000000', NULL, NULL, 'học tập', 1, '12', ''),
                                                                                                                                                    (97, NULL, NULL, '2024-10-11 08:51:11.000000', NULL, NULL, 'vớ vẩn', 1, '123', ''),
                                                                                                                                                    (98, '2024-10-07 13:55:13.000000', NULL, '2024-10-11 08:58:19.000000', NULL, NULL, 'vớ vẩn 2', 1, '1234', '');
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
