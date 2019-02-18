CREATE TABLE user(
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` VARCHAR(20) NOT NULL COMMENT '用户名',
  `nickname` VARCHAR(20) NOT NULL DEFAULT '用户' COMMENT '用户昵称',
  `password` VARCHAR(20) NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE tab(
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `name` VARCHAR(20) NOT NULL COMMENT '标签名',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE category(
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCRMENT COMMENT '类别id',
  `name` VARCHAR(20) NOT NULL COMMENT '类别名',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE article(
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCRMENT COMMENT '文章id',
  `title` VARCHAR(20) NOT NULL COMMENT '文章标题',
  `author` INT(10) NOT NULL COMMENT '文章作者',
  `createTime` DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` DATETIME NULL DEFAULT DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `category` INT(10) NOT NULL COMMENT '文章类别',
  `content` TEXT,
  PRIMARY KEY (`id`),
  KEY `author` (`author`),
  CONSTRAINT `author` FOREIGN KEY (`author`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE
)

CREATE TABLE comment(
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `article`
  `nickname`
)