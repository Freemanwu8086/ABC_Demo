/*
 Navicat Premium Data Transfer

 Source Server         : mysql本地库
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : abc

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 02/03/2022 14:28:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Announce
-- ----------------------------
DROP TABLE IF EXISTS `Announce`;
CREATE TABLE `Announce` (
  `announce` varchar(300) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

SET FOREIGN_KEY_CHECKS = 1;
