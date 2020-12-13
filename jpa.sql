/*
 Navicat Premium Data Transfer

 Source Server         : mySqlServer
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : jpa

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 13/12/2020 20:57:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for faculty
-- ----------------------------
DROP TABLE IF EXISTS `faculty`;
CREATE TABLE `faculty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `FacultyName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of faculty
-- ----------------------------
BEGIN;
INSERT INTO `faculty` VALUES (101, '计算机系');
INSERT INTO `faculty` VALUES (102, '数学系');
INSERT INTO `faculty` VALUES (103, '外语系');
INSERT INTO `faculty` VALUES (104, '经管系');
INSERT INTO `faculty` VALUES (105, '航天系');
INSERT INTO `faculty` VALUES (106, '人工智能');
INSERT INTO `faculty` VALUES (107, '大数据');
INSERT INTO `faculty` VALUES (108, '物理系');
INSERT INTO `faculty` VALUES (109, '中文系');
INSERT INTO `faculty` VALUES (110, '医学系');
COMMIT;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(11) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `math` int(11) DEFAULT NULL,
  `physics` int(11) DEFAULT NULL,
  `english` int(11) DEFAULT NULL,
  `c` int(11) DEFAULT NULL,
  `polity` int(11) DEFAULT NULL,
  KEY `grade` (`id`),
  CONSTRAINT `grade` FOREIGN KEY (`id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of grade
-- ----------------------------
BEGIN;
INSERT INTO `grade` VALUES (2018301103, 'mr.yin', 2, 3, 4, 5, 5);
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `facultyID` int(11) DEFAULT NULL,
  `birth` date NOT NULL,
  `age` int(11) NOT NULL,
  `grade` double(3,2) NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student` (`facultyID`),
  CONSTRAINT `student` FOREIGN KEY (`facultyID`) REFERENCES `faculty` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES (2018301103, 'mr.Yin', '安徽六安', '1725491705@qq.com', 1, 101, '2000-02-10', 20, 1.24, 0);
INSERT INTO `student` VALUES (2018301111, 'Mr.chen', '安徽', 'chen@qq.com', 1, 101, '1999-12-31', 20, 4.00, 0);
COMMIT;

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
BEGIN;
INSERT INTO `tbl_user` VALUES (1, 'aa', 'whtierose');
INSERT INTO `tbl_user` VALUES (2, '时称', 'blackMagician');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uno` varchar(255) NOT NULL,
  `upwd` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('Mr.Yin', '2018301103');
INSERT INTO `user` VALUES ('Mr.xia', '3245625');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
