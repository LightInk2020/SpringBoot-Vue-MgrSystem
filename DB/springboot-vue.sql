/*
 Navicat Premium Data Transfer

 Source Server         : Mysql
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : springboot-vue

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 30/09/2021 17:57:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '昵称',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1', '1', 'c', 4, '女', '1');
INSERT INTO `user` VALUES (2, '2', '2', '2', 2, '女', '2');
INSERT INTO `user` VALUES (3, '3', '123456', '3', 3, '女', '3');
INSERT INTO `user` VALUES (5, '5', '123456', '5', 5, '男', '5');
INSERT INTO `user` VALUES (6, '6', '123456', '6', 6, '男', '6');
INSERT INTO `user` VALUES (8, '787', '123456', '676', 23, '男', 'adsad');
INSERT INTO `user` VALUES (10, 'wrz', '123456', 'sad', 23, '男', '辽宁省大连市大连理工大学软件学院');
INSERT INTO `user` VALUES (11, 'sad', '123456', '1212', 1, '男', '1');
INSERT INTO `user` VALUES (12, '213', '123456', '12', 11, '男', '1');
INSERT INTO `user` VALUES (13, '353', '123456', '2131', 11, '男', '1');
INSERT INTO `user` VALUES (14, '3', '123456', '3', 3, '男', '3');
INSERT INTO `user` VALUES (15, '33', '123456', '3', 3, '男', '3');
INSERT INTO `user` VALUES (16, '111', '123456', '11', 111, '男', '11');
INSERT INTO `user` VALUES (17, '11', '123456', 'aa', 140, '男', 'China');
INSERT INTO `user` VALUES (18, 'asd', '123456', 'aa', 2, '男', 'a');
INSERT INTO `user` VALUES (19, '11', '123456', '11', 1, '男', 'a');

SET FOREIGN_KEY_CHECKS = 1;
