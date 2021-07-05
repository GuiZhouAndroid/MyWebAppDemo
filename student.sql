/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : dbweb

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 04/07/2021 23:59:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_id` int NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `stu_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `stu_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  `stu_class` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级',
  `stu_age` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年龄',
  `stu_sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `stu_birthday` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生日',
  PRIMARY KEY (`stu_id`, `stu_no`) USING BTREE,
  UNIQUE INDEX `stu_no`(`stu_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (2, '1998', '张三', '张三', '23', '女', 'ASD');

SET FOREIGN_KEY_CHECKS = 1;
