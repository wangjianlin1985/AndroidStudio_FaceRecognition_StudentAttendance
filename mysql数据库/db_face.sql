/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.6
 Source Server Type    : MySQL
 Source Server Version : 50620
 Source Host           : localhost:3306
 Source Schema         : db_face

 Target Server Type    : MySQL
 Target Server Version : 50620
 File Encoding         : 65001

 Date: 16/09/2021 02:07:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ctime` varchar(111) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (14, '2021-09-15 23:25:23', 30);
INSERT INTO `record` VALUES (16, '2021-09-16 00:24:26', 34);
INSERT INTO `record` VALUES (17, '2021-09-16 00:31:34', 35);
INSERT INTO `record` VALUES (18, '2021-09-16 01:40:35', 37);
INSERT INTO `record` VALUES (19, '2021-09-16 01:40:57', 34);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zhuanye` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `banji` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `faceid` varchar(111) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (30, '29399405678', '计算机专业', '高晓丽', 'http://192.168.1.5:8080/11.jpg', '4班', '1631626747832');
INSERT INTO `user` VALUES (34, '29399405670', '软件工程', '唐嫣', 'http://192.168.1.5:8080/tangyan.png', '5班', '1631722854128');
INSERT INTO `user` VALUES (35, '29399405671', '软件工程', '李易峰', 'http://192.168.1.5:8080/liyifeng.jpg', '3班', '1631723354077');
INSERT INTO `user` VALUES (37, '29399405672', '计算机科学', '罗云熙', 'http://192.168.1.5:8080/luoyunxi.jpg', '1班', '1631727365764');

SET FOREIGN_KEY_CHECKS = 1;
