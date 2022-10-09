CREATE TABLE `xxl_job_user` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `username` varchar(50) NOT NULL COMMENT '账号',
                                `password` varchar(50) NOT NULL COMMENT '密码',
                                `role` tinyint(4) NOT NULL COMMENT '角色：0-普通用户、1-管理员',
                                `permission` varchar(255) DEFAULT NULL COMMENT '权限：执行器ID列表，多个逗号分割',
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `i_username` (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tb_market_data` (
                                   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务，主键ID',
                                   `code` int(11) NOT NULL COMMENT '股票代码',
                                   `abbr` varchar(50) DEFAULT NULL COMMENT 'GLUE类型',
                                   `last_trade` mediumtext COMMENT 'GLUE源代码',
                                   `chg_ratio` varchar(128) NOT NULL COMMENT 'GLUE备注',
                                   `chg_amt` datetime DEFAULT NULL,
                                   `chg_ratio_5min` datetime DEFAULT NULL,
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `tb_market_data` (id, code, abbr, last_trade, chg_ratio, chg_amt, chg_ratio_5min)
VALUES ('1', '000004', 'ST国华', '97715.92', '111592.33', '11632.85', '13284.80')
