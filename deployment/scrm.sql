/*
Navicat MySQL Data Transfer

Source Server         : SCRM
Source Server Version : 80015
Source Host           : 42.159.104.30:3306
Source Database       : scrm

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-03-21 09:26:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` int(50) DEFAULT NULL,
  `activ_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '活动名称',
  `activ_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '活动图片',
  `activ_desc` varchar(21000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '活动描述',
  `start_date` int(50) DEFAULT NULL COMMENT '起始时间',
  `end_date` int(50) DEFAULT NULL COMMENT '结束时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for common_recom
-- ----------------------------
DROP TABLE IF EXISTS `common_recom`;
CREATE TABLE `common_recom` (
  `prod_asin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `update_time` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'user_id',
  `verif` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '面部识别',
  `open_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信id',
  `memb_points` int(255) DEFAULT NULL COMMENT '会员积分',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gender` int(255) DEFAULT NULL,
  `avatarUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for entrance_events
-- ----------------------------
DROP TABLE IF EXISTS `entrance_events`;
CREATE TABLE `entrance_events` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `time` datetime NOT NULL COMMENT '用户进入时间',
  `is_sent` int(255) unsigned zerofill NOT NULL COMMENT '是否下发（0或者空为未下发，1为下发）',
  `is_old` int(255) NOT NULL DEFAULT '0' COMMENT '是否是老用户，老用户为1,新用户为0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hot_brand_stats
-- ----------------------------
DROP TABLE IF EXISTS `hot_brand_stats`;
CREATE TABLE `hot_brand_stats` (
  `period` int(255) NOT NULL,
  `brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sales_count` int(255) DEFAULT NULL,
  `sales_amount` decimal(10,2) DEFAULT NULL,
  `count_time` datetime DEFAULT NULL,
  PRIMARY KEY (`period`,`brand`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hot_category_stats
-- ----------------------------
DROP TABLE IF EXISTS `hot_category_stats`;
CREATE TABLE `hot_category_stats` (
  `period` int(255) NOT NULL,
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sales_count` int(255) DEFAULT NULL,
  `sales_amount` decimal(10,2) DEFAULT NULL,
  `count_time` datetime DEFAULT NULL,
  PRIMARY KEY (`period`,`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hot_period_cfg
-- ----------------------------
DROP TABLE IF EXISTS `hot_period_cfg`;
CREATE TABLE `hot_period_cfg` (
  `period` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hot_product_stats
-- ----------------------------
DROP TABLE IF EXISTS `hot_product_stats`;
CREATE TABLE `hot_product_stats` (
  `period` int(255) NOT NULL,
  `product` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sales_count` int(255) DEFAULT NULL,
  `sales_amount` decimal(10,2) DEFAULT NULL,
  `count_time` datetime DEFAULT NULL,
  PRIMARY KEY (`period`,`product`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `prod_asin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `rate` int(50) DEFAULT NULL,
  `unix_time` int(255) DEFAULT NULL,
  `num` int(50) DEFAULT '1',
  KEY `user_id` (`user_id`),
  KEY `prod_asin` (`prod_asin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for personal_recom
-- ----------------------------
DROP TABLE IF EXISTS `personal_recom`;
CREATE TABLE `personal_recom` (
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `prod_asin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `reco_rank` int(10) NOT NULL COMMENT '推荐分数',
  `update_time` int(50) NOT NULL,
  PRIMARY KEY (`user_id`,`reco_rank`,`update_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for prodcate
-- ----------------------------
DROP TABLE IF EXISTS `prodcate`;
CREATE TABLE `prodcate` (
  `product_asin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `category` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`product_asin`,`category`),
  KEY `product_asin` (`product_asin`),
  KEY `category` (`category`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `asin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `imUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `brand` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`asin`),
  KEY `asin_idx` (`asin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for quarterly_category_stats
-- ----------------------------
DROP TABLE IF EXISTS `quarterly_category_stats`;
CREATE TABLE `quarterly_category_stats` (
  `year` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `quarter` int(255) NOT NULL,
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sales_count` int(255) DEFAULT NULL,
  `sales_amount` decimal(10,2) DEFAULT NULL,
  `count_time` datetime DEFAULT NULL,
  PRIMARY KEY (`year`,`quarter`,`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for quarterly_product_stats
-- ----------------------------
DROP TABLE IF EXISTS `quarterly_product_stats`;
CREATE TABLE `quarterly_product_stats` (
  `year` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `quarter` int(255) NOT NULL,
  `product` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sales_count` int(255) DEFAULT NULL,
  `sales_amount` decimal(10,2) DEFAULT NULL,
  `count_time` datetime DEFAULT NULL,
  PRIMARY KEY (`year`,`quarter`,`product`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for quarterly_total_stats
-- ----------------------------
DROP TABLE IF EXISTS `quarterly_total_stats`;
CREATE TABLE `quarterly_total_stats` (
  `year` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `quarter` int(255) NOT NULL,
  `sales_count` int(255) DEFAULT NULL,
  `sales_amount` decimal(10,2) DEFAULT NULL,
  `count_time` datetime DEFAULT NULL,
  PRIMARY KEY (`year`,`quarter`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- View structure for cate
-- ----------------------------
DROP VIEW IF EXISTS `cate`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `cate` AS select `prodcate`.`product_asin` AS `product_asin`,`prodcate`.`category` AS `category` from `prodcate` where (`prodcate`.`product_asin` = 'B000BN94F8') ;

-- ----------------------------
-- View structure for orders_totalprice
-- ----------------------------
DROP VIEW IF EXISTS `orders_totalprice`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `orders_totalprice` AS select `product`.`asin` AS `asin`,`product`.`title` AS `product`,`orders`.`num` AS `num`,`orders`.`user_id` AS `user_id`,(`orders`.`num` * `product`.`price`) AS `price`,`orders`.`unix_time` AS `unix_time`,`product`.`price` AS `unit_price`,`product`.`cate` AS `category`,`product`.`brand` AS `brand` from (`product` join `orders`) where (convert(`product`.`asin` using utf8mb4) = convert(`orders`.`prod_asin` using utf8mb4)) ;

-- ----------------------------
-- View structure for test
-- ----------------------------
DROP VIEW IF EXISTS `test`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`%` SQL SECURITY DEFINER VIEW `test` AS select `prodcate`.`product_asin` AS `product_asin`,count(`prodcate`.`category`) AS `count(category)` from `prodcate` where (not(`prodcate`.`product_asin` in (select `prodcate`.`product_asin` from `prodcate` where (not(`prodcate`.`category` in (select `prodcate`.`category` from `prodcate` where (`prodcate`.`product_asin` = 'B000BN94F8'))))))) group by `prodcate`.`product_asin` having (count(0) > 5) ;

-- ----------------------------
-- Procedure structure for update_common_recom
-- ----------------------------
DROP PROCEDURE IF EXISTS `update_common_recom`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `update_common_recom`()
BEGIN
    INSERT INTO 
    common_recom (prod_asin, update_time) 
    SELECT
        od.asin AS prod_asin,
        UNIX_TIMESTAMP(now()) AS update_time
    FROM orders_totalprice od
    WHERE
        od.unix_time >= UNIX_TIMESTAMP(CURDATE()) - (DATEDIFF(curdate(), '2011-12-31') + 30) * 86400
    AND od.unix_time < UNIX_TIMESTAMP(CURDATE()) - DATEDIFF(curdate(), '2011-12-31') * 86400
    GROUP BY
        od.asin
		ORDER BY
				count(od.asin) desc limit 16;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for update_hot_stats
-- ----------------------------
DROP PROCEDURE IF EXISTS `update_hot_stats`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `update_hot_stats`()
BEGIN
DECLARE v_total int DEFAULT 0;
declare ePeriod int;
declare i int default 1;
declare list CURSOR for SELECT period from hot_period_cfg;
select count(1) into v_total  from hot_period_cfg;
open list;

/*清空统计表*/
truncate hot_category_stats;
truncate hot_brand_stats;
truncate hot_product_stats;

loop1:loop
    IF i > v_total THEN	      
        LEAVE loop1;	
    end if;
    
    /*从hot_period_cfg中获取需要统计的热点天数*/
    fetch list into ePeriod;
    
    /*统计类别数据*/
    INSERT INTO 
    hot_category_stats (period, category, sales_count, sales_amount, count_time) 
    SELECT
        ePeriod as period,
        od.category AS category,
        sum(od.num) AS sales_count,
        sum(od.price) AS sales_amount,
        CURRENT_TIMESTAMP AS count_time
    FROM orders_totalprice od
    WHERE
        od.unix_time >= UNIX_TIMESTAMP(CURDATE()) - (DATEDIFF(curdate(), '2011-12-31') + ePeriod) * 86400
    AND od.unix_time < UNIX_TIMESTAMP(CURDATE()) - DATEDIFF(curdate(), '2011-12-31') * 86400
    GROUP BY
        od.category;
        
    /*统计品牌数据*/
    INSERT INTO 
    hot_brand_stats (period, brand, sales_count, sales_amount, count_time) 
    SELECT
        ePeriod as period,
        od.brand AS brand,
        sum(od.num) AS sales_count,
        sum(od.price) AS sales_amount,
        CURRENT_TIMESTAMP AS count_time
    FROM orders_totalprice od
    WHERE
        od.unix_time >= UNIX_TIMESTAMP(CURDATE()) - (DATEDIFF(curdate(), '2011-12-31') + ePeriod) * 86400
    AND od.unix_time < UNIX_TIMESTAMP(CURDATE()) - DATEDIFF(curdate(), '2011-12-31') * 86400
    GROUP BY
        od.brand;
        

    /*统计产品数据*/
    INSERT INTO 
    hot_product_stats (period, product, sales_count, sales_amount, count_time) 
    SELECT
        ePeriod as period,
        od.product AS product,
        sum(od.num) AS sales_count,
        sum(od.price) AS sales_amount,
        CURRENT_TIMESTAMP AS count_time
    FROM orders_totalprice od
    WHERE
        od.unix_time >= UNIX_TIMESTAMP(CURDATE()) - (DATEDIFF(curdate(), '2011-12-31') + ePeriod) * 86400
    AND od.unix_time < UNIX_TIMESTAMP(CURDATE()) - DATEDIFF(curdate(), '2011-12-31') * 86400
    GROUP BY
        od.product;
    
    
    set i = i +1;
end loop;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for update_quarterly_stats
-- ----------------------------
DROP PROCEDURE IF EXISTS `update_quarterly_stats`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `update_quarterly_stats`()
BEGIN

truncate quarterly_category_stats; 
truncate quarterly_product_stats; 
truncate quarterly_total_stats; 

/*统计季度类别销售数据*/
INSERT INTO 
quarterly_category_stats (YEAR, QUARTER, category, sales_count,	sales_amount, count_time) 
SELECT 	YEAR(FROM_UNIXTIME(od.unix_time)) AS YEAR,
	QUARTER (FROM_UNIXTIME(od.unix_time)) AS QUARTER,
	od.category AS category,
	sum(od.num) AS sales_count,
	sum(od.price) AS sales_amount,
	CURRENT_TIMESTAMP AS count_time
FROM
	orders_totalprice od
GROUP BY YEAR, QUARTER, category;



/*统计季度产品销售数据*/
INSERT INTO 
quarterly_product_stats (YEAR,	QUARTER, product,	sales_count, sales_amount,count_time) 
SELECT YEAR(FROM_UNIXTIME(od.unix_time)) AS YEAR, 
	QUARTER (FROM_UNIXTIME(od.unix_time)) AS QUARTER,
	od.asin AS product,
	sum(od.num) AS sales_count,
	sum(od.price) AS sales_amount,
	CURRENT_TIMESTAMP AS count_time
FROM
	orders_totalprice od
GROUP BY YEAR, QUARTER,	od.asin;



/*统计季度总销售数据*/
INSERT INTO 
quarterly_total_stats (YEAR,	QUARTER, sales_count, sales_amount,count_time) 
SELECT YEAR(FROM_UNIXTIME(od.unix_time)) AS YEAR, 
	QUARTER (FROM_UNIXTIME(od.unix_time)) AS QUARTER,
	sum(od.num) AS sales_count,
	sum(od.price) AS sales_amount,
	CURRENT_TIMESTAMP AS count_time
FROM
	orders_totalprice od
GROUP BY YEAR, QUARTER;


END
;;
DELIMITER ;

-- ----------------------------
-- Event structure for regular_update_common_recom
-- ----------------------------
DROP EVENT IF EXISTS `regular_update_common_recom`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` EVENT `regular_update_common_recom` ON SCHEDULE EVERY 1 DAY STARTS '2019-03-14 19:30:00' ON COMPLETION NOT PRESERVE ENABLE DO call update_common_recom()
;;
DELIMITER ;

-- ----------------------------
-- Event structure for regular_update_hot_stats
-- ----------------------------
DROP EVENT IF EXISTS `regular_update_hot_stats`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` EVENT `regular_update_hot_stats` ON SCHEDULE EVERY 1 DAY STARTS '2019-03-14 19:00:00' ON COMPLETION NOT PRESERVE ENABLE DO call update_hot_stats()
;;
DELIMITER ;

-- ----------------------------
-- Event structure for regular_update_quarterly_stats
-- ----------------------------
DROP EVENT IF EXISTS `regular_update_quarterly_stats`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` EVENT `regular_update_quarterly_stats` ON SCHEDULE EVERY 1 DAY STARTS '2019-03-14 20:00:00' ON COMPLETION NOT PRESERVE ENABLE DO call update_quarterly_stats()
;;
DELIMITER ;
