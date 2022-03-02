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

 Date: 02/03/2022 14:28:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Sheet_Music
-- ----------------------------
DROP TABLE IF EXISTS `Sheet_Music`;
CREATE TABLE `Sheet_Music` (
  `music_name` varchar(255) NOT NULL,
  `beat` varchar(5) NOT NULL,
  `tone` varchar(8) NOT NULL,
  `username` varchar(255) NOT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `insert_date` datetime NOT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `state` varchar(5) DEFAULT NULL,
  `abc` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `IDX_ON_USERNAME` (`username`) COMMENT '在username上的字段，提高用户查询自己的曲谱速度'
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3;

SET FOREIGN_KEY_CHECKS = 1;
