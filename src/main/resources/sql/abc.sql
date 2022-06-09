/*
 Navicat Premium Data Transfer

 Source Server         : mysql服务器库
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : abc

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 07/06/2022 08:08:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Admin
-- ----------------------------
DROP TABLE IF EXISTS `Admin`;
CREATE TABLE `Admin` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Admin
-- ----------------------------
BEGIN;
INSERT INTO `Admin` (`username`, `password`, `id`) VALUES ('freemanwu', 'wsq.@.990811', 1);
COMMIT;

-- ----------------------------
-- Table structure for Announce
-- ----------------------------
DROP TABLE IF EXISTS `Announce`;
CREATE TABLE `Announce` (
  `announce` varchar(300) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Announce
-- ----------------------------
BEGIN;
INSERT INTO `Announce` (`announce`, `update_date`, `id`) VALUES ('请各位用户妥善保管\r\n自己的账号以及密码！', '2022-02-15 20:56:10', 1);
INSERT INTO `Announce` (`announce`, `update_date`, `id`) VALUES ('你好', '2022-02-16 11:18:00', 2);
INSERT INTO `Announce` (`announce`, `update_date`, `id`) VALUES ('今天是个好日子', '2022-02-16 11:24:26', 3);
INSERT INTO `Announce` (`announce`, `update_date`, `id`) VALUES ('请各位用户妥善保管\r\n自己的账号以及密码！\r\n谨防诈骗！', '2022-02-16 11:25:37', 4);
INSERT INTO `Announce` (`announce`, `update_date`, `id`) VALUES ('近期正在注册域名\r\n可能会出现外网无法通过\r\nwww.searchingwu.space的域名\r\n访问该网站的问题，预计将在3月10日前解决。', '2022-03-04 11:25:04', 5);
INSERT INTO `Announce` (`announce`, `update_date`, `id`) VALUES ('网站已通过备案，所有功能可正常使用，欢迎大家推广以及合作。\r\nwww.searchingwu.space\r\n', '2022-03-11 14:40:33', 6);
COMMIT;

-- ----------------------------
-- Table structure for Comment
-- ----------------------------
DROP TABLE IF EXISTS `Comment`;
CREATE TABLE `Comment` (
  `username` varchar(255) NOT NULL,
  `music_id` int(11) NOT NULL,
  `comment` varchar(1000) NOT NULL,
  `comment_date` datetime NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Comment
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for Favorite
-- ----------------------------
DROP TABLE IF EXISTS `Favorite`;
CREATE TABLE `Favorite` (
  `username` varchar(255) NOT NULL,
  `music_id` int(11) NOT NULL,
  `collect_date` date NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unameMid` (`username`,`music_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Favorite
-- ----------------------------
BEGIN;
INSERT INTO `Favorite` (`username`, `music_id`, `collect_date`, `id`) VALUES ('freemanwu', 34, '2022-04-13', 1);
INSERT INTO `Favorite` (`username`, `music_id`, `collect_date`, `id`) VALUES ('freemanwu', 30, '2022-04-13', 3);
INSERT INTO `Favorite` (`username`, `music_id`, `collect_date`, `id`) VALUES ('freemanwu', 4, '2022-04-13', 7);
INSERT INTO `Favorite` (`username`, `music_id`, `collect_date`, `id`) VALUES ('freemanwu', 33, '2022-04-13', 8);
INSERT INTO `Favorite` (`username`, `music_id`, `collect_date`, `id`) VALUES ('多嘴的鸭子', 34, '2022-05-10', 16);
INSERT INTO `Favorite` (`username`, `music_id`, `collect_date`, `id`) VALUES ('freemanwu', 43, '2022-05-30', 17);
COMMIT;

-- ----------------------------
-- Table structure for Sheet_Music
-- ----------------------------
DROP TABLE IF EXISTS `Sheet_Music`;
CREATE TABLE `Sheet_Music` (
  `music_name` varchar(255) NOT NULL,
  `beat` varchar(5) NOT NULL,
  `tone` varchar(8) NOT NULL,
  `username` varchar(255) NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `insert_date` datetime NOT NULL,
  `last_update_date` datetime DEFAULT NULL,
  `state` varchar(5) DEFAULT NULL,
  `abc` varchar(10000) DEFAULT NULL,
  `introduction` varchar(10000) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `IDX_ON_USERNAME` (`username`) COMMENT '在username上的字段，提高用户查询自己的曲谱速度',
  KEY `IDX_FOR_ZH` (`music_name`,`beat`,`tone`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Sheet_Music
-- ----------------------------
BEGIN;
INSERT INTO `Sheet_Music` (`music_name`, `beat`, `tone`, `username`, `location`, `insert_date`, `last_update_date`, `state`, `abc`, `introduction`, `id`) VALUES ('Love of My Life', '4/4', 'D', 'Queen', '/user/Queen', '1975-02-09 10:52:03', '2022-02-14 14:53:45', '通过', '', NULL, 4);
INSERT INTO `Sheet_Music` (`music_name`, `beat`, `tone`, `username`, `location`, `insert_date`, `last_update_date`, `state`, `abc`, `introduction`, `id`) VALUES ('Another One Bites the Dust', '4/4', 'A', 'Queen', '/user/Queen', '1980-02-09 10:55:22', '2022-03-03 14:29:24', '通过', '', NULL, 5);
INSERT INTO `Sheet_Music` (`music_name`, `beat`, `tone`, `username`, `location`, `insert_date`, `last_update_date`, `state`, `abc`, `introduction`, `id`) VALUES ('再见杰克', '4/4', 'D', '痛痒乐队', '/user/痛痒', '2008-02-09 15:08:42', '2022-03-03 14:29:36', '通过', '', NULL, 6);
INSERT INTO `Sheet_Music` (`music_name`, `beat`, `tone`, `username`, `location`, `insert_date`, `last_update_date`, `state`, `abc`, `introduction`, `id`) VALUES ('梦中的婚礼', '3/4', 'C', '用户已注销', NULL, '2022-03-04 12:41:03', '2022-03-04 12:42:02', '通过', 'E2 E2 C2 D2', NULL, 30);
INSERT INTO `Sheet_Music` (`music_name`, `beat`, `tone`, `username`, `location`, `insert_date`, `last_update_date`, `state`, `abc`, `introduction`, `id`) VALUES ('挪威的森林', '1/4', 'B', 'freemanwu', NULL, '2022-03-05 11:24:53', '2022-04-14 23:43:01', '通过', 'X:5\r\nT:挪威的森林\r\nM:2/4\r\nL:1/4\r\nQ:80\r\nO:中国\r\nN:作曲:吴俊霖\r\nN:编辑:Cindy Zhou\r\nK:G\r\n|:e1/2e1/2 (e1/4d1/4) d1/4 (d1/4|\r\n e1/2) e1/2 (d1/4B1/4) B1/2 |\r\ne1/2e1/2 (e1/4d1/4) d1/4 (d1/4|\r\nd1/2) d1/2 (d1/4B1/4) B1/2 |\r\ne1/2e1/2 (e1/4d1/4) d1/4 (d1/4 |\r\n B1/2) d1/2 A1/2G1/2 |\r\nA1/2B1/4B1/4 d1/4 (B1/4B1/4A1/4) |\r\nA z1/2B1/4d1/4 |\r\ne1/2e1/2 (e1/4d1/4) d1/4(d1/4 \r\n|d/)d/ (d//B//)B/ |\r\ne/e/ (e//d//)d//(d// |\r\n d/)d/ (d//B//)B/ |\r\ne/e/ (e//d//)d//(d// |\r\nB/)B/ (A//G//)G/ |\r\nA/B//B// d//(B//B//A//) |\r\nA z/B//A// |G/G/ (G//E//)E//(A// |\r\n A/)B/ z/B//A// |\r\nG/G/ (G//E//)E//(A// |\r\nA/)B/ z/B//d// |\r\ne/d/ (d//B//)B/ |\r\n(e//d//)e/ z/B//d// |\r\ne/d//d// d//d/B// |\r\n (d//e//d//)(d// (d) |\r\n d) z/B//d// |e/d/ d//d/B// |\r\n(d//e//d//)(d// (d) |\r\nd)!segno!G/g//(d// |\r\ne) (B//A//)A/ |\r\n B G/(A//B//) |\r\n A//A//A//A// G/E//(G// |\r\nG/)(D//(E//) E/)E//E// |\r\nG//G//G//G// G/G//E// |\r\nG/A/ z/B//d// |\r\n e/d//d// d/', '', 31);
INSERT INTO `Sheet_Music` (`music_name`, `beat`, `tone`, `username`, `location`, `insert_date`, `last_update_date`, `state`, `abc`, `introduction`, `id`) VALUES ('小鸡的一家', '2/4', 'D', 'freemanwu', NULL, '2022-03-05 11:33:56', '2022-03-05 16:05:21', '通过', 'X:1\r\nT:小鸡的一家\r\nM:2/4\r\nQ:1/4=140\r\nL:1/16\r\nK:D\r\nC2 C2 C2 E2 | G2 G2 G4 | A3 G E2 G2 | D2 D2 D4 |  %4\r\nE2 E2 G4 | C2 D2 E4 | C3 D (E2 G2) | [12 D2 z2 E2 z2 |  %8\r\nC4 z4 ] | [3 D2 D2 D2 E2 | C4 z4 ] :| ', NULL, 32);
INSERT INTO `Sheet_Music` (`music_name`, `beat`, `tone`, `username`, `location`, `insert_date`, `last_update_date`, `state`, `abc`, `introduction`, `id`) VALUES ('她来听我的演唱会', '2/4', 'F', 'freemanwu', NULL, '2022-03-06 11:06:49', '2022-03-10 15:42:29', '通过', 'X:1\r\nT:她来听我的演唱会\r\nM:2/4\r\nQ:2/4=35\r\nL:1/16\r\nK:D\r\nc2 d2 e2 f2| (e1 d1 c1) (d1 e1)|', NULL, 33);
INSERT INTO `Sheet_Music` (`music_name`, `beat`, `tone`, `username`, `location`, `insert_date`, `last_update_date`, `state`, `abc`, `introduction`, `id`) VALUES ('辉煌明天', '2/4', 'B', 'freemanwu', NULL, '2022-03-06 17:12:03', '2022-04-14 13:43:26', '通过', 'X:1\r\nT:辉煌明天\r\nM:2/4\r\nQ:1/4=60\r\nK:B\r\ng1 (g1g1g1) (e1f1g1) g2| g1 (g1g1g1) (e1f1g1) g2| g2 c1| a2 g1 a1|\r\nf1 A1 A2| c2 g1 e1|f4 - - -| e1 z1 c1 (d1 d1) z0|\r\ne1 z1 c1 (d1 d1) z0|(d1 G1/2) (G1 G1) | g2 g2 B|z4|\r\nG2 e2| c2 G2| A1 B2 (A1 -E1)|G1 G3|\r\nA2 (B1 -c1)| (d1 -z1/2) G (z1/2 G1/2)|(e1/2 e1/4) (e1/2 e1/2) e1 (d1/2 c1/2)| d1 d3 |', '西安石油大学校歌\r\n陈忠实先生作词', 34);
INSERT INTO `Sheet_Music` (`music_name`, `beat`, `tone`, `username`, `location`, `insert_date`, `last_update_date`, `state`, `abc`, `introduction`, `id`) VALUES ('Selection And Dragging Test', '4/4', 'B', 'freemanwu', NULL, '2022-03-17 11:02:19', '2022-03-18 10:19:07', '通过', 'X:1\r\nM:4/4\r\nL:1/16\r\n%%partsfont box\r\n%%stretchlast .7\r\n%%barnumbers 1\r\nT: Selection And Dragging Test\r\nT: Demonstrates a lot the different types of elements and their effect.\r\nC: Public Domain\r\nR: Play steady\r\nA: Paul Rosen\r\nS: abcjs website\r\nW: Now is the time for all good men\r\nW:\r\nW: To come to the aid of their party.\r\nH: This shows every type of thing that can possibly be drawn.\r\nH:\r\nH: And two lines of history.\r\nQ: \"Easy Swing\" 1/4=140\r\nP: AABB\r\n%%staves {(RH extra) (LH)}\r\nV:RH clef=treble name=RH\r\nV:LH clef=bass name=LH\r\nK:Bb\r\nP:A\r\n[V: RH] !mp![b8B8d8] f3g f4|!<(![d12b12] !<)![b4g4]| \\\r\n[Q:\"left\" 1/4=170\"right\"]z4 !<(! (bfdf) (3B2d2c2 !<)!B4|!f![c4f4] z4 [b8d8]|\r\n!p![G8e8] Tu[c8f8]|!<(![d12f12] !<)!g4|!f!a4 [g4b4] z4 =e4|[A8c8f8] d8|\r\n|1 [c8F8] [B4G4] z4|[d12B12] A4|!>(![D8A8] Bcde fAB!>)!c|!mp!d16:|\r\nw:Strang- ers in the night\r\n[V: extra] B,4- B,4- B,4 B,4 | \"Bb\"{C}B,4 {CD}B,4 B,4 B,4 | B,4 B,4 B,4 B,4 | B,4 B,4 B,4 B,4 |\r\nB,4 B,4 B,4 B,4 | B,4 B,4 B,4 B,4 | B,4 B,4 B,4 B,4 | B,4 B,4 B,4 B,4 |\r\nB,4 B,4 B,4 B,4 |B,4 B,4 B,4 B,4 |\"^annotation\"B,4 B,4 B,4 B,4 |B,4 B,4 B,4 B,4 :|\r\n[V: LH] B,6 D2 [F,8F8A,8]|B,2B,,2 C,4 D,4 E,F,G,2|F,2A,2 D4 D4 G,2E,2|[C4F,4A,4] z4 [F8B,8]|\r\nG,8 A,8|A,12 B,G,D,E,|F,G,A,F, (G,A,B,G,) C4 C4|[C,8A,8] [F8F,8B,8]|\r\nA,3C B,3D G,F,E,D, F,2A,2|D,2C,2 B,,2A,,2 G,,4 F,,A,,C,F,|F,,6 D,,2 [D,4G,,4] z4|B,,16:|', NULL, 36);
INSERT INTO `Sheet_Music` (`music_name`, `beat`, `tone`, `username`, `location`, `insert_date`, `last_update_date`, `state`, `abc`, `introduction`, `id`) VALUES ('因为爱情', '1/4', 'F', 'freemanwu', NULL, '2022-03-20 15:19:05', '2022-03-20 15:23:13', '通过', 'X:48\r\nT:因为爱情\r\nM:4/4\r\nL:1/4\r\nQ:90\r\nO:中国\r\nN:作曲:小柯\r\nN:编辑:Cindy Zhou\r\nK:F\r\nz1/2C1/2 D1/2F1/2 F1/2D1/2 F1/2G1/2 |A1/2G3/2 z F1/2D1/2 |A1/2G1/2 D1/2A1/2 G3/2 (F1/2 |\r\n F1/2)D3/2 z D1/2E1/2 |F1/2F1/2 D1/2 A(G1/2 G) |A3/4(G1/4 G1/2)G1/2 G A | A4 |z z z z \r\n|: z1/2C1/2 D1/2F1/2 F1/2D1/2 F1/2G1/2 | A1/2G3/2 z F1/2D1/2 |A1/2G1/2 D1/2A1/2 G3/2(F1/2 |\r\nF1/2)D3/2 z D1/2E1/2 | F1/2F1/2 D1/2 A(G1/2 G) |F D1/2F1/2 A (c |c1/2)(G1/2 G3) |\r\n z z G A1/2(c1/2 |c1/2)A3/2 z1/2c1/2 c1/2A1/2 |G1/2c1/2 c2 d1/2e1/2 | \r\nf1/2f1/2 f1/2e1/2 f3/4(e1/4 e1/2)e1/2 |c1/2(A1/2 A2)c1/2A1/2 |c1/2(d1/2 d3/2) c1/2 d1/2c1/2 |\r\n c1/2(F1/2 F2) D1/2F1/2 |A1/2G1/2 D1/2A1/2 G1/2D1/2 d| c2) G A1/2(c1/2 |\r\n c1/2)(A1/2 A) z1/2c1/2 c1/2A1/2 |G1/2c1/2 c2 d1/2e1/2 |f1/2f1/2 f1/2e1/2 f3/4(e1/4 e1/2)e1/2 |\r\n c1/2(A1/2 A2) c1/2A1/2 |c1/2(d1/2 d3/2) c1/2 d3/4c1/4 |c1/2(F1/2 F2) D1/2F1/2 |\r\n A1/2G1/2 D1/2A1/2 G1/2D1/2 A1/2(G1/2 |G2) A G1/2(A1/2 |A1/2) (F1/2 F3) |\r\n (z z1/2E1/2 E3/4(F1/4 F1/2)G1/2 |A G1/4F1/4(D1/2 D2) |z z1/2c1/2 c1/2A1/2 A |F1/4E1/4(C1/2 C3)|\r\n z D,1/4E,1/4F,1/4A,1/4 (3D1/2E1/2F1/2 (3G1/2A1/2B1/2 |B A1/2F1/2 F2 |d c3) :| [2 A1/2(F1/2 (F3) |\r\nF2) zz |z1/2C1/2 D1/2F1/2 F1/2D1/2 F1/2G1/2 | A1/2G3/2 z F1/2D1/2 |A1/2G1/2 D1/2A1/2 G3/2(F1/2 |\r\nF1/2)D3/2 z D1/2E1/2 | F1/2F1/2 D1/2A (G1/2 G) |A3/4(G1/4 G1/2)G1/2 G A |(A4 |A2)zz |', NULL, 37);
INSERT INTO `Sheet_Music` (`music_name`, `beat`, `tone`, `username`, `location`, `insert_date`, `last_update_date`, `state`, `abc`, `introduction`, `id`) VALUES ('那一年', '4/4', 'D', 'freemanwu', NULL, '2022-04-07 22:03:18', '2022-04-07 22:32:16', '通过', 'X:20\r\nT:那一年\r\nM:4/4\r\nL:1/4\r\nQ:64\r\nO:中国\r\nN:作曲:许巍\r\nK:D \r\n|(z1/2f1/4f1/4) f1/2g1/2 f1/2e1/2 e |z1/2d1/4e1/4 f1/2g1/4f1/4 e1/2 f1/4g1/4 e |\r\nz1/2f1/4f1/4) f1/2g1/2 f1/2e1/2 e |z1/2d1/4e1/4 f1/2f1/2 e1/2f1/2 d | z1/2f1/4f1/4)\r\n f1/2g1/2 f1/2e1/2 e |z1/2d1/4e1/4 f1/2g1/4f1/4 e1/2 f1/4g1/4 e |z1/2f1/4f1/4)\r\n f1/2g1/2 f1/2e1/2 e |z1/2b1/4z1/4 f1/2 g1/2f1/2 e1/2f1/2 | d) {E1/2}F1/2D1/2\r\n {D1/2}E z |B,1/2D1/2 {D1/2}E1/2D1/2 zz |z1/2D1/2 {E1/2}F1/2D1/2 E1/2E1/2 z |\r\nB,1/2D1/2 E1/2 D B,1/2 z| z1/2D1/2 {E1/2}F1/2D1/2 E1/2E1/2 z1/2D1/2 |A1/2F1/2 E1/2 F D1/2 z |\r\nz _F1/2D1/2 _E1/2A,1/2 z |B,1/2D B,1/2 z z | z1/2A,1/2 A1/2F1/2 E1/2E1/2 z |\r\nF1/2F1/2 F1/2F1/2 {E1/4}F1/2D1/2 z |z1/2A,1/2 A1/2F1/2E1/2E1/2 z |\r\nF1/2F1/2 F1/2F1/2 {E1/4}F1/2B,1/2 z | z1/2A,1/2 A1/2F1/2 E1/2E1/2 z1/2A,1/2 |\r\nB1/2B1/2 A1/2{E1/4}F D1/2 z |z D1/2D1/2 D1/2C1/2 E1/2(F1/2 |F) D1/2D1/2 (C1/2B,1/2) B, |\r\n (z1/2f1/4f1/4 f1/2g1/2 f1/2e1/2 e |z1/2d1/4e1/4 f1/2g1/4f1/4 e1/2f1/4g1/4 f |\r\nz1/2f1/4f1/4 f1/2g1/2 f1/2e1/2 e |z1/2d1/4e1/4 f1/2f1/2 e1/2f1/2 d | z1/2f1/4f1/4\r\n f1/2g1/2 f1/2e1/2 e |z1/2d1/4e1/4 f1/2g1/4f1/4 e1/2f1/4g1/4 f |z1/2f1/4f1/4 f1/2g1/2 f1/2e1/2 e |\r\nz1/2b1/2 z1/2f1/2 g1/2f1/2 e1/2f1/2 | d) A1/2F1/2 E1/2E1/2 z1/2D1/2 |F1/2F1/2 F1/2F1/2 {E1/2}F1/2D1/2 z |\r\nz1/2A,1/2 A1/2F1/2 E1/2E1/2 z |F1/2F1/2 F1/2F1/2 {E1/2}F1/2B,1/2 z | z1/2A,1/2 A1/2F1/2 \r\nE1/2E1/2 z1/2A,1/2 |B1/2B1/2 A1/2{E1/2}F D1/2 z |z D1/2D1/2 D1/2C1/2 E1/2(F1/2 |F) D (C1/2B,1/2) B, |\r\n A,3/2 D1/2C3/2 D1/2 |E1/2E1/2 D1/2E1/2 D z |A, (A,1/2D1/2) C3/2 E1/2 |F1/2D1/2 C1/2D1/2 (C1/2B,1/2) z |\r\nA, (A,1/2D1/2) C3/2D1/2 | E1/2E1/2 D1/2E1/2 D z |A, (A,1/2D1/2) C3/2 E1/2 |F1/2D1/2 C1/2D1/2 (C1/2B,1/2 B, |\r\n(z1/2a1/4a1/4 f1/2g1/2 g1/2 f e1/2 | z1/2d1/4e1/4 f1/2g1/4f1/4 e1/2f1/4g1/4 f |z1/2a1/4a1/4\r\n a1/2g1/2 g1/2 f e1/2 |z1/2d1/4e1/4 f1/2g1/4f1/4 e1/2f1/2 d |z1/2a1/4a1/4 f1/2g1/2 g1/2 f e1/2 |\r\n z1/2d1/4e1/4 f1/2g1/4f1/4 e1/2f1/4g1/4 f |z1/2a1/4a1/4 a1/2d\'1/2 d\'1/2c\'1/2 c\'1/2b1/2 |\r\nb1/2a1/2 a1/2g1/2 g1/2f1/2 e1/2f1/2) |A (A1/2d1/2) c3/2 d1/2 | e1/2e1/2 d1/2e1/2 d z |\r\nA (A1/2 a1/2)c3/2 e1/2 |f1/2d1/2 c1/2d1/2 (c1/2B1/2) z |A (A1/2d1/2) c3/2d1/2 | e1/2e1/2 d1/2e1/2 d z |\r\nA (A1/2 a1/2)c3/2 e1/2 |f1/2d1/2 c1/2d1/2 (c1/2B1/2) B |z d1/2f1/2 f1/2e1/2 e1/2f1/2 |\r\n (g1/2f1/2) f1/2d1/2 (e1/2d1/2) d |z d1/2f1/2 f1/2e1/2 e1/2f1/2 |(f1/2d1/2) d1/2d1/2 (c1/2B1/2) B |\r\nz d1/2f1/2 f1/2 e f1/2 | (g1/2f1/2) f1/2d1/2 (e1/2d1/2) d |z d1/2f1/2 (f1/2e1/2) e1/2f1/2 |\r\n(f1/2d1/2) d (c1/2B1/2) B |A3/2 d1/2 c3/2 d1/2 | e1/2e1/2 d1/2e1/2 d z |A (A1/2d1/2) c3/2 e1/2 |\r\nf1/2d1/2 c1/2d1/2 (c1/2B1/2) z |A (A1/2d1/2)c3/2 d | e1/2e1/2 d1/2e1/2 d z |A (A1/2d1/2) c3/2 e1/2 |\r\nf1/2d1/2 c1/2d1/2 (c1/2B1/2) B |(d4 |d3) A | B4 |f4 |A1/2B1/2 (A3 |A3) F |A1/2B1/2 A3 |B4 |(d4 | e3) B |\r\n(f4 |f2) B2 |(a4 |a4 |a4 |a) b f B | (d4 |d3) B |(d4 |d3) e |d1/2e1/2 (d3 |d3) B | d1/2e1/2 (d3 |d4) |d4) |', NULL, 38);
INSERT INTO `Sheet_Music` (`music_name`, `beat`, `tone`, `username`, `location`, `insert_date`, `last_update_date`, `state`, `abc`, `introduction`, `id`) VALUES ('婚礼进行曲2', '1/4', 'C', 'freemanwu', NULL, '2022-04-28 11:48:24', '2022-04-28 12:17:17', '通过', 'X:1255\r\nT:WEDDING MARCH 婚礼进行曲2\r\nM:2/4\r\nL:1/4\r\nQ:92\r\nO:外国\r\nN:作曲:瓦格纳\r\nN:编辑:Cindy Zhou\r\nK:C \r\n|:G, C3/4C// | C2 | G, D3/4B,// | C2 | G, C3/4E// | F E3/4D// | C B,3/4C// | D2 |\r\n G, C3/4C// | C2 | G, D3/4B,// | C2 | G, C3/4E// | G E3/4C// | G D3/4E// | C2 |\r\n F E/D/ | A, A, | B, C3/4D// | D2 | F E/D/ | A, A, | A, B,3/4^C// | C2 | E ^F/E/ |\r\n D ^C | E D/^C/ | ^C B, | E ^F | A ^C | ^C B,3/4A,// | ^F, E | E, D,/_C,/ | G, E, |\r\n G, F,/D,/ | E,2 | E, E,/^F,/ | G, _F, | E, E, | E,3/2 G,/ | G, C3/4C// | C2 | G, D3/4B,// |\r\n C2 | G, C3/4E// | F E3/4D// | C B,3/4C// | D2 | G, C3/4C// | C2 | G, D3/4B,// | C2 |\r\n G, C3/4E// | G E3/4C// | A2 | G/F/ E3/4D// | (C2 | C) z/E/ | E2 | F3/2 E/ | (G2 | G) z :|', '婚礼进行曲2\r\n作曲:瓦格纳', 41);
INSERT INTO `Sheet_Music` (`music_name`, `beat`, `tone`, `username`, `location`, `insert_date`, `last_update_date`, `state`, `abc`, `introduction`, `id`) VALUES ('莫斯科郊外的晚上', '2/4', 'F', 'freemanwu', NULL, '2022-04-28 11:53:30', '2022-05-13 23:23:39', '通过', 'X:1240\r\nT:莫斯科郊外的晚上\r\nM:2/4\r\nL:1/4\r\nQ:68\r\nO:俄罗斯\r\nN:作曲:索罗维约夫.谢多伊拉\r\nN:编辑:Cindy Zhou\r\nK: F\r\n(D,/A,//D// F//A//D//F// | D,//D//A//F// D//A//D//F// | D,/A,//D// F//A//D//F// |\r\n D,//D//A//F// D//A//D//F// |: ^B ^c | (e/d/) (A | A/) (E D/) | (A/G/) (B |\r\n B) (c/B/) | A (G/F/) | A G | D2) | (D/F/) (A/F/) | G (F/E/) | (A G) | D2 |\r\n (F/A/) c/c/ | d (c/B/) | A2 | (^B ^c) | (e/d/) (A | A/) (E D/) | (A/G/) (B |\r\n B) (c/B/) | (A G/F/) | (A G) | D2 | (^B ^c) | (e/d/) (A | A/) (E D/) |\r\n (A/G/ (B | B) (c/B/) | A (G/F/) | (A G | D2 :|(^B ^c | e/d/ (A | A/) E D/ |\r\n (A/G/) (B | B) (c/B/) | A (G/F/) | (A G) | D2 |D/F/ A/F/ | G F/E/ | A G | D2 |\r\n F/A/ c/c/ | d c/B/ | A2 | ^B ^c | (e/d/) (A | A/) E D/ | (A/G/) (B | B) (c/B/) |\r\n A G/F/ | A G | D2) | (^B ^c) | (e/d/) (A | A/) (E D/) | (A/G/) (B | B) (c/B/) |\r\n (A G/F/) | A G | D2 | (^B ^c) | (e/d/) (A | A/) (E D/) | (A/G/) (B | B) (c/B/) |\r\n A (G/F/) | A ^c | !>(!(d2 | (d2) | d) !>)! z |', '莫斯科郊外的晚上\r\n作曲:索罗维约夫.谢多伊拉', 42);
INSERT INTO `Sheet_Music` (`music_name`, `beat`, `tone`, `username`, `location`, `insert_date`, `last_update_date`, `state`, `abc`, `introduction`, `id`) VALUES ('喀秋莎', '2/4', 'bA', 'freemanwu', NULL, '2022-04-28 12:00:04', '2022-05-13 23:28:18', '通过', 'X:1239\r\nT:喀秋莎\r\nM:2/4\r\nL:1/4\r\nQ:110\r\nO:苏联\r\nN:作曲:勃兰切尔\r\nK:Ab \r\n|(c f | e f/e/ | d c3/4B// | c F | z/ d B/ | c3/2 A/ | G/C/ A/G/ | F/F//F// F/z/) |\r\n F3/2 G/ | A3/2 F/ | A G3/4F// | G C/z/ | G3/2 A/ | B3/2 G//G// | B/B//B// A/G/ |\r\n F2 |c f3/4f// | (e f/)e/ | d c/B/ | c F | z/ d (B//B//) | c3/2 A//A// |[1,2 G/C//C// (A/G/) |\r\nF2 | G/C//C// A/G/ | F2 | c c/c/ | e2 | (f2 | f2) | |:(c f | e f/e/ | d c3/4B// |\r\n c F | z/ d B/ | c3/2 A/ | G/C/ A/G/ | F/F//F// F/z/) | F3/2 G/ | A3/2 F/ | A G3/4F// |\r\n G C/z/ | G3/2 A/ | B3/2 G//G// | B/B//B// A/G/ | F2 |c f3/4f// | (e f/)e/ | d c/B/ |\r\n c F | z/ d (B//B//) | c3/2 A//A// |[1,2 G/C//C// (A/G/) |F2 | G/C//C// A/G/ | F2 :|\r\n |:(c f | e f/e/ | d c3/4B// | c F | z/ d B/ | c3/2 A/ | G/C/ A/G/ | F/F//F// F/z/) | \r\nF3/2 G/ | A3/2 F/ | A G3/4F// | G C/z/ | G3/2 A/ | B3/2 G//G// | B/B//B// A/G/ | F2 |\r\nc f3/4f// | (e f/)e/ | d c/B/ | c F | z/ d (B//B//) | c3/2 A//A// |[1,2 G/C//C// (A/G/) \r\n|F2 | G/C//C// A/G/ | F2 :|', '这首歌曲创作于1939年，但当时并没有流行，是两年后发生的苏联卫国战争使这首歌曲脱颖而出，并伴着隆隆的炮火流传了开来。如此说来，恰恰是战争使《喀秋莎》这首歌曲体现出了它那不同寻常的价值，而经过战火的洗礼，这首歌曲更是获得了新的甚至是永恒的生命。\r\n这首爱情歌曲竟在战争中得以流传，其原因就在于，这歌声使美好的音乐和正义的战争相融合，这歌声把姑娘的情爱和士兵们的英勇报国联系在了一起，这饱含着少女纯情的歌声，使得抱着冰冷的武器、卧在寒冷的战壕里的战士们，在难熬的硝烟与寂寞中，心灵得到了情与爱的温存和慰藉。\r\n战后，苏联当局为了表彰《喀秋莎》这首歌在战争中所起到的巨大鼓舞作用，专为它建立了一座纪念馆，这在人类的战争史和音乐史上，应该是首例。\r\n\r\n----------------------俄文歌词-------------------\r\nРасцветали яблони и груши，\r\nПоплыли туманы над рекой；\r\nВыходила на берег Катюша,\r\nНа высокий берег，на крутой.\r\nВыходила,песню заводила\r\nПро степного，сизого орла,\r\nПро того，которого любила,\r\nПро того，чьи письма берегла.\r\nОй,ты песня，песенка девичья,\r\nТы лети за ясным солнцем вслед，\r\nИ бойцу на дальнем пограничье\r\nОт Катюши передай привет.\r\nПусть он вспомнит девушку простую,\r\nПусть услышит，как она поёт,\r\nПусть он землю бережёт родную，\r\nА любовь Катюша сбережёт.\r\nРасцветали яблони и груши,\r\nПоплыли туманы над рекой;\r\nВыходила на берег Катюша，На высокий берег,на крутой.\r\n-----------------------------中文歌词-------------------------\r\n（寒柏译）\r\n正当梨花开遍了天涯，河上飘着柔曼的轻纱；喀秋莎站在那峻峭的岸上，歌声好像明媚的春光。\r\n喀秋莎站在那峻峭的岸上，歌声好像明媚的春光。\r\n姑娘唱着美妙的歌曲，她在歌唱草原的雄鹰；她在歌唱心爱的人儿，她还藏着爱人的书信。\r\n她在歌唱心爱的人儿，她还藏着爱人的书信。\r\n啊这歌声姑娘的歌声，跟着光明的太阳飞去吧；去向远方边疆的战士，把喀秋莎的问候传达。\r\n去向远方边疆的战士，把喀秋莎的问候传达。\r\n驻守边疆年轻的战士，心中怀念遥远的姑娘；勇敢战斗保卫祖国，喀秋莎爱情永远属于他。\r\n勇敢战斗保卫祖国，喀秋莎爱情永远属于他。\r\n正当梨花开遍了天涯，河上飘着柔曼的轻纱；喀秋莎站在峻峭的岸上，歌声好像明媚的春光。\r\n喀秋莎站在峻峭的岸上，歌声好像明媚的春光。', 43);
INSERT INTO `Sheet_Music` (`music_name`, `beat`, `tone`, `username`, `location`, `insert_date`, `last_update_date`, `state`, `abc`, `introduction`, `id`) VALUES ('外婆的澎湖湾', '4/4', 'A', 'freemanwu', NULL, '2022-04-28 12:06:09', '2022-04-28 12:18:37', '通过', 'X:1058\r\nT:外婆的澎湖湾\r\nM:4/4\r\nL:1/4\r\nQ:92\r\nO:中国\r\nN:作曲:叶佳修\r\nN:编辑:Cindy Zhou\r\nK:A \r\n(E3/2 E/ A3/2 E/ | F3/2 D/ B3/2 F/ | G3/2 E/ B d | c3/2 A/ e2 | E3/2 E/ A3/2 E/ |\r\n F3/2 D/ F3/2 F/ | G3/2 E/ B c/B/ | A4) | C/E/ E/E/ F//A3/4 (F/E/) | A/{A//}A/ PF/F/ E2 |\r\n c/c/ c/c/ d/c/ (B//A3/4) | B//B//B//B// B/c/ {c//}B2 | c/c/ c/c/ d/c/ (B//A3/4) |\r\n F/A/ A/F/ E2 | c/c/ c/c//c// d/c/ (B//A3/4) | E//E//E//E// (B//A//)G/ A2 |\r\n C/E/ E/E/ F//A3/4 (F/E/) | A/A//A// {A//}PF/F/ E2 | c/c/ c/c/ d/c/ B/A/ |\r\n B//B/B// B/c/ {c//}B2 | c/c/ c/c//c// d/c/ B/A/ | F/A//A// {A//}PF/F/ E2 |\r\n c/c/ c/c/ d/c/ B/A/ | E/E/ (B//A//)G/ A2 |:G (G/A/) (B E) | (A/E/) (A/B/) (c {B//}A) |\r\n d/ d c/ (B/A/) (G/A/) | (B3/2 c/ B2) | c3/2 c/ d d3/4d// | c3/4B// (A/G/) F2 |\r\n E/E/ z A/A/ z | B A B (A/B/) |\r\n M:2/4\r\n c e/d/ | \r\nM:4/4 \r\nc3/2 A/ G (A/B/) | [1 A4 :|\r\n[2 A4 | (d3/2 e/) f a | a g f g | a4) |', '', 44);
INSERT INTO `Sheet_Music` (`music_name`, `beat`, `tone`, `username`, `location`, `insert_date`, `last_update_date`, `state`, `abc`, `introduction`, `id`) VALUES ('七子之歌', '4/4', 'C', 'freemanwu', NULL, '2022-04-28 12:08:04', '2022-04-28 12:17:54', '通过', 'X:1295\r\nT:七子之歌—澳门\r\nM:4/4\r\nL:1/4\r\nQ:82\r\nO:中国\r\nN:作曲:李海鹰\r\nN:编辑:Cindy Zhou\r\nK:C \r\n|: G E/G/ E/ G3/2 | A/G/ E/A/ G2 | C C/D/ E G/E/ | D z/E/ G2 | G/G/ A/G/ E/ G G/ |\r\n A/G/ c/A/ G2 | C G/E/ D/C/ D | E/ (G3/2 G/)D/ E |[1 C4 :| [2 C3 z/G/ | e (d3/4c//)\r\n (A/G/) G | A/ A G/ A3/4c// e/c/ | d3 z/G/ | e d3/4c// (A/G/) G | A/ A G/ A (e/d/) |\r\n d4 | e d3/4c// (A/G/) G | c (A/G/) (E/D/) C | z (D/E/) (G2 | G2) z(G/A/) | c4 |\r\n | G E/G/ E/ G3/2 | A/G/ E/A/ G2 | C C/D/ E G/E/ | D z/E/ G2 | G/G/ A/G/ E/ G G/ |\r\n A/G/ c/A/ G2 | C G/E/ D/C/ D | E/ (G3/2 G/)D/ E |[1 C4 | [2 C3 z/G/ | e (d3/4c//)\r\n (A/G/) G | A/ A G/ A3/4c// e/c/ | d3 z/G/ | e d3/4c// (A/G/) G | A/ A G/ A (e/d/) |\r\n d4 | e d3/4c// (A/G/) G | c (A/G/) (E/D/) C | z (D/E/) (G2 | G2) z(G/A/) | c4 | \r\n|G E/G/ E/ G3/2 | A/G/ E/A/ G2 | c (A/G/) (E/D/) C | zz (E/D/) C | (G/A/) C3 |', '七子之歌，澳门回归祖国之际由一位小姑娘演唱，表达了澳门回归祖国的热切之情。', 45);
COMMIT;

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phoneNumber` varchar(255) NOT NULL,
  `birthday` date NOT NULL,
  `enroll_date` datetime DEFAULT NULL,
  `MusicAnnounce` varchar(255) DEFAULT NULL,
  `comment_mark` int(1) unsigned NOT NULL,
  `id` int(255) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_ON_USERNAME` (`username`,`password`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of User
-- ----------------------------
BEGIN;
INSERT INTO `User` (`username`, `password`, `phoneNumber`, `birthday`, `enroll_date`, `MusicAnnounce`, `comment_mark`, `id`) VALUES ('freemanwu', 'wsq.@.990811', '13359166204', '1999-08-11', '2022-02-01 20:19:46', '曲谱《喀秋莎》已过审！', 0, 1);
INSERT INTO `User` (`username`, `password`, `phoneNumber`, `birthday`, `enroll_date`, `MusicAnnounce`, `comment_mark`, `id`) VALUES ('小笨蛋', '123456', '13347450622', '1980-08-25', '1999-02-15 20:14:47', NULL, 0, 3);
INSERT INTO `User` (`username`, `password`, `phoneNumber`, `birthday`, `enroll_date`, `MusicAnnounce`, `comment_mark`, `id`) VALUES ('行走的弩哥', '19990312YAN', '13347450622', '1999-03-12', '2022-03-09 15:59:46', '韩妍你好！', 0, 5);
INSERT INTO `User` (`username`, `password`, `phoneNumber`, `birthday`, `enroll_date`, `MusicAnnounce`, `comment_mark`, `id`) VALUES ('aaa', '123456', '15593361234', '2022-03-11', '2022-03-11 16:29:12', NULL, 0, 9);
INSERT INTO `User` (`username`, `password`, `phoneNumber`, `birthday`, `enroll_date`, `MusicAnnounce`, `comment_mark`, `id`) VALUES ('bbb', '123456', '15593361234', '2022-03-11', '2022-03-11 16:32:52', NULL, 0, 12);
INSERT INTO `User` (`username`, `password`, `phoneNumber`, `birthday`, `enroll_date`, `MusicAnnounce`, `comment_mark`, `id`) VALUES ('ddd', '123456', '15593361234', '2022-03-17', '2022-03-11 16:35:28', NULL, 0, 14);
INSERT INTO `User` (`username`, `password`, `phoneNumber`, `birthday`, `enroll_date`, `MusicAnnounce`, `comment_mark`, `id`) VALUES ('eee', '123456', '15593361234', '2022-03-12', '2022-03-11 16:37:52', NULL, 0, 15);
INSERT INTO `User` (`username`, `password`, `phoneNumber`, `birthday`, `enroll_date`, `MusicAnnounce`, `comment_mark`, `id`) VALUES ('fff', '123456', '15593361234', '2022-03-12', '2022-03-11 16:39:04', NULL, 0, 18);
INSERT INTO `User` (`username`, `password`, `phoneNumber`, `birthday`, `enroll_date`, `MusicAnnounce`, `comment_mark`, `id`) VALUES ('fff12', '123456', '15593361234', '2022-03-12', '2022-03-11 16:40:38', NULL, 0, 19);
INSERT INTO `User` (`username`, `password`, `phoneNumber`, `birthday`, `enroll_date`, `MusicAnnounce`, `comment_mark`, `id`) VALUES ('上海加油', 'SHANGHAI', '13359166205', '1949-10-01', '2022-04-09 14:12:46', NULL, 0, 23);
INSERT INTO `User` (`username`, `password`, `phoneNumber`, `birthday`, `enroll_date`, `MusicAnnounce`, `comment_mark`, `id`) VALUES ('18191146106', 'ZXQ1129...', '18191146106', '2022-02-02', '2022-04-11 21:33:33', NULL, 0, 24);
INSERT INTO `User` (`username`, `password`, `phoneNumber`, `birthday`, `enroll_date`, `MusicAnnounce`, `comment_mark`, `id`) VALUES ('多嘴的鸭子', '1111', '13359166204', '2022-05-10', '2022-05-10 18:35:20', NULL, 0, 25);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
