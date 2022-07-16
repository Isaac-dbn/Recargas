/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : MySQL
 Source Server Version : 100419
 Source Host           : localhost:3306
 Source Schema         : recarga

 Target Server Type    : MySQL
 Target Server Version : 100419
 File Encoding         : 65001

 Date: 16/07/2022 12:49:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for empresas
-- ----------------------------
DROP TABLE IF EXISTS `empresas`;
CREATE TABLE `empresas`  (
  `id_empresa` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_empresa`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of empresas
-- ----------------------------
INSERT INTO `empresas` VALUES (1, 'Claro');
INSERT INTO `empresas` VALUES (2, 'Tigo');
INSERT INTO `empresas` VALUES (3, 'Movistar');
INSERT INTO `empresas` VALUES (4, 'Uff');

-- ----------------------------
-- Table structure for productos
-- ----------------------------
DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos`  (
  `id_producto` int NOT NULL AUTO_INCREMENT,
  `nombre_producto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fk_id_empresa` int NULL DEFAULT NULL,
  PRIMARY KEY (`id_producto`) USING BTREE,
  INDEX `FK_PRODUCTOS1`(`fk_id_empresa`) USING BTREE,
  CONSTRAINT `FK_PRODUCTOS1` FOREIGN KEY (`fk_id_empresa`) REFERENCES `empresas` (`id_empresa`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of productos
-- ----------------------------
INSERT INTO `productos` VALUES (1, '10000', 1);
INSERT INTO `productos` VALUES (2, '15000', 1);
INSERT INTO `productos` VALUES (3, '100000', 1);
INSERT INTO `productos` VALUES (4, '1000', 2);
INSERT INTO `productos` VALUES (5, '2000', 2);
INSERT INTO `productos` VALUES (6, '5000', 2);
INSERT INTO `productos` VALUES (7, '1500', 3);
INSERT INTO `productos` VALUES (8, '3000', 3);
INSERT INTO `productos` VALUES (9, '7000', 3);
INSERT INTO `productos` VALUES (10, '5000', 4);
INSERT INTO `productos` VALUES (11, '8000', 4);
INSERT INTO `productos` VALUES (12, '10000', 4);

-- ----------------------------
-- Table structure for vendedores
-- ----------------------------
DROP TABLE IF EXISTS `vendedores`;
CREATE TABLE `vendedores`  (
  `id_vendedor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_vendedor`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vendedores
-- ----------------------------
INSERT INTO `vendedores` VALUES (1, 'Maria Gonzalez');
INSERT INTO `vendedores` VALUES (2, 'Claudia Lopez');
INSERT INTO `vendedores` VALUES (3, 'Pedro Perez');

-- ----------------------------
-- Table structure for ventas
-- ----------------------------
DROP TABLE IF EXISTS `ventas`;
CREATE TABLE `ventas`  (
  `id_venta` int NOT NULL AUTO_INCREMENT,
  `id_empresa` int NOT NULL,
  `numero` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `total` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `fk_id_vendedor` int NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`id_venta`) USING BTREE,
  INDEX `FK_VENTAS1`(`id_empresa`) USING BTREE,
  INDEX `FK_VENTAS2`(`fk_id_vendedor`) USING BTREE,
  CONSTRAINT `FK_VENTAS1` FOREIGN KEY (`id_empresa`) REFERENCES `empresas` (`id_empresa`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_VENTAS2` FOREIGN KEY (`fk_id_vendedor`) REFERENCES `vendedores` (`id_vendedor`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ventas
-- ----------------------------
INSERT INTO `ventas` VALUES (1, 2, '3333333333', '100000', 1, '2022-07-15 21:45:06');
INSERT INTO `ventas` VALUES (2, 2, '3333333333', '33333333', 2, '2022-07-15 21:49:45');
INSERT INTO `ventas` VALUES (3, 2, '3366666666', '1200', 2, '2022-07-15 21:52:03');
INSERT INTO `ventas` VALUES (4, 2, '3133232323', '121212', 1, '2022-07-16 08:52:13');
INSERT INTO `ventas` VALUES (10, 2, '3323332323', '4', 2, '2022-07-16 12:22:36');
INSERT INTO `ventas` VALUES (11, 1, '1332323232', '1', 3, '2022-07-16 12:25:26');
INSERT INTO `ventas` VALUES (12, 1, '1332323232', '1', 3, '2022-07-16 12:25:53');
INSERT INTO `ventas` VALUES (13, 4, '1212122221', '12', 2, '2022-07-16 12:28:20');
INSERT INTO `ventas` VALUES (14, 3, '3233323233', '8', 2, '2022-07-16 12:31:42');

SET FOREIGN_KEY_CHECKS = 1;
