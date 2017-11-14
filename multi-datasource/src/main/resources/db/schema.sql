CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL DEFAULT '' COMMENT 'username',
  `password` varchar(30) NOT NULL DEFAULT '' COMMENT '密码',
  `age` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '年龄',
  `gender` tinyint(1) NOT NULL DEFAULT '1' COMMENT '性别',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8