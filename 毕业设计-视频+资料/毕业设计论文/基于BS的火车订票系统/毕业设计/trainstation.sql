/*
 Navicat Premium Data Transfer

 Source Server         : Liu
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : trainstation

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 30/05/2019 10:21:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `train_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `g_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_time` date NOT NULL,
  `origin` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `terminus` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `leavetime` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `a_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` decimal(10, 0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 573160 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (573127, 1, 'D315', '08:22', '2019-05-31', '北京', '天津', '2019-05-31', '09:04', 40);
INSERT INTO `orders` VALUES (573128, 1, 'G101', '07:00', '2019-05-31', '北京', '上海', '2019-05-31', '12:23', 553);
INSERT INTO `orders` VALUES (573132, 1, 'K8401', '23:34', '2019-05-31', '上海', '嘉兴', '2019-05-31', '00:35', 10);
INSERT INTO `orders` VALUES (573147, 153, 'D315', '08:22', '2019-05-31', '北京', '南京', '2017-09-01', '14:38', 314);
INSERT INTO `orders` VALUES (573148, 1, 'D315', '08:22', '2019-05-04', '北京', '南京', '2019-05-04', '14:38', 314);
INSERT INTO `orders` VALUES (573150, 1, 'C2223', '15:35', '2019-05-04', '北京', '天津', '2019-05-04', '16:13', 55);
INSERT INTO `orders` VALUES (573152, 154, 'G2223', '15:35', '2019-05-04', '北京', '天津', '2019-05-04', '16:13', 55);
INSERT INTO `orders` VALUES (573155, 1, 'G2223', '15:35', '2019-05-05', '北京', '武清', '2019-05-04', '15:57', 39);
INSERT INTO `orders` VALUES (573157, 154, 'C2223', '15:35', '2019-05-05', '北京', '武清', '2019-05-04', '15:57', 39);
INSERT INTO `orders` VALUES (573158, 1, 'C2223', '15:35', '2019-05-05', '北京', '武清', '2019-06-06', '15:57', 39);
INSERT INTO `orders` VALUES (573159, 1, 'G2223', '15:35', '2019-05-30', '北京', '武清', '2019-07-17', '15:57', 39);

-- ----------------------------
-- Table structure for ticket
-- ----------------------------
DROP TABLE IF EXISTS `ticket`;
CREATE TABLE `ticket`  (
  `id` int(11) NOT NULL,
  `train_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `amount` int(11) NOT NULL,
  `remainder` int(11) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ticket
-- ----------------------------
INSERT INTO `ticket` VALUES (1, 'C2223', 500, 500);
INSERT INTO `ticket` VALUES (2, 'G7281', 830, 830);
INSERT INTO `ticket` VALUES (3, 'G101', 832, 832);
INSERT INTO `ticket` VALUES (4, 'K8401', 1000, 1000);

-- ----------------------------
-- Table structure for train
-- ----------------------------
DROP TABLE IF EXISTS `train`;
CREATE TABLE `train`  (
  `train_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `station` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `a_time` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `g_time` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `amount` decimal(10, 0) NOT NULL,
  `remainder` decimal(10, 0) NOT NULL,
  PRIMARY KEY (`train_num`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of train
-- ----------------------------
INSERT INTO `train` VALUES ('C2223', '北京/武清/天津', '---/15:57/16:13', '15:35/15:58/---', '0.0/38.5/54.5', 800, 797);
INSERT INTO `train` VALUES ('D315', '北京/廊坊/天津/沧州/德州/济南/泰安/枣庄/徐州/蚌埠/定远/南京/镇江/常州/无锡/苏州/昆山/上海', '---/08:43/09:04/09:43/10:26/10:54/11:14/12:07/12:43/13:31/13:49/14:38/15:00/15:32/16:01/16:14/16:32/16:55', '08:22/08:45/09:17/09:56/10:27/10:56/11:22/12:23/12:48/13:32/14:04/14:40/15:12/15:43/16:03/16:20/16:38/---', '0.0/19.5/39.5/64.5/94.5/124.5/144/194/214/264/278.5/313.5/333.5/353.5/373.5/383.5/393.5/408', 1500, 1498);
INSERT INTO `train` VALUES ('G101', '北京/济南/曲阜/枣庄/南京/常州/无锡/上海', '---/08:32/09:06/09:31/11:01/11:35/11:54/12:23', '07:00/08:34/09:08/09:33/11:03/11:37/11:55/---', '0.0/184.5/244/284/443.5/493.5/513.5/553', 850, 848);
INSERT INTO `train` VALUES ('G111', '石家庄/北京/承德', '---/07:00/08:00/09:00', '06:00/07:05/08:05', '0.0/20.0/31.0', 100, 100);
INSERT INTO `train` VALUES ('G2223', '北京/武清/天津', '---/15:57/16:13', '15:35/15:58/---', '0.0/38.5/54.5', 110, 107);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` int(11) NOT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `country` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `papers_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `papers_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 155 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', '123456', 2, '男', '18655111134', 'aao@126.com', '北京', '111', '中国', '身份证', '34128119911111111');
INSERT INTO `users` VALUES (2, 'testuser', '123456', 1, '女', '15211111038', 'acpeng@126.com', '北京', '1111', '阿拉伯联合酋长国', '港澳通行证', 'G22222222');
INSERT INTO `users` VALUES (153, 'admins', '123456', 2, '男', '18888888888', '1327847316@qq.com', '廊坊市', '11111', '美国', '身份证', '130111111111111112');
INSERT INTO `users` VALUES (154, 'zhaosi', '123456', 1, '男', '15212151111', '1327847316@qq.com', '北京市', '赵四', '中国', '身份证', '130111111111111111');

SET FOREIGN_KEY_CHECKS = 1;
