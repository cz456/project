/*
 Navicat Premium Data Transfer

 Source Server         : a
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 23/01/2021 14:26:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `id` int(11) DEFAULT NULL,
  `name` varchar(1024) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '姓名',
  `loginNumber` varchar(1024) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '登录学号/工号',
  `passWord` varchar(1024) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '密码',
  `role` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '角色',
  `state` varchar(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '状态',
  `note` varchar(1024) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL COMMENT '备注'
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '人员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES (1, 'cz', '001', '001', '1', '1', NULL);

SET FOREIGN_KEY_CHECKS = 1;
