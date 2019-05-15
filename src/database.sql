# 创建数据库
CREATE DATABASE blog DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

# 使用创建的这个数据库
USE blog;

# 创建用户表
CREATE TABLE user
(
  `id`       INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name`     VARCHAR(20) UNIQUE NOT NULL COMMENT '用户名',
  `nickname` VARCHAR(20) NOT NULL DEFAULT '用户' COMMENT '用户昵称',
  `password` VARCHAR(20) NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

# 创建标签表
CREATE TABLE tag
(
  `id`   INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `name` VARCHAR(20) UNIQUE NOT NULL COMMENT '标签名',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

# 创建分类表
CREATE TABLE category
(
  `id`   INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '类别id',
  `name` VARCHAR(20) UNIQUE NOT NULL COMMENT '类别名',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

# 创建文章表
CREATE TABLE article
(
  `id`         INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title`      VARCHAR(20) NOT NULL COMMENT '文章标题',
  `author`     INT(10) UNSIGNED COMMENT '外键-文章作者',
  `createTime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `category`   INT(10) UNSIGNED COMMENT '外键-文章类别',
  `content`    TEXT COMMENT '文章内容',
  `visit`      INT(10) DEFAULT 0 COMMENT '点击量',
  `recommend`  TINYINT(1) DEFAULT 0 COMMENT '是否推荐',
  PRIMARY KEY (`id`),
  KEY          `author` (`author`),
  CONSTRAINT `article_author` FOREIGN KEY (`author`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE NO ACTION,
  KEY          `category` (`category`),
  CONSTRAINT `article_category` FOREIGN KEY (`category`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE NO ACTION
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

# 创建评论表
CREATE TABLE comment(
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `article` INT(10) UNSIGNED NOT NULL COMMENT '外键-文章',
  `nickname` VARCHAR(20) NOT NULL COMMENT '评论昵称',
  `contact` VARCHAR(50) NULL COMMENT '联系方式',
  `content` TEXT NOT NULL COMMENT '评论内容',
  PRIMARY KEY(`id`),
  FOREIGN KEY (`article`) REFERENCES `article` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

# 创建文章与标签的表
CREATE TABLE article_tag (
  `article` INT(10) UNSIGNED NOT NULL COMMENT '外键-文章',
  `tag` INT(10) UNSIGNED NOT NULL COMMENT '外键-标签',
  PRIMARY KEY (`article`, `tag`),
  FOREIGN KEY (`article`) REFERENCES `article` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  FOREIGN KEY (`tag`) REFERENCES `tag` (`id`) ON DELETE CASCADE ON UPDATE  NO ACTION
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

# 插入一个用户数据
INSERT INTO user(name, nickname, password) VALUES('k','k','123');

# 插入一个分类数据
INSERT INTO category(name) VALUES('java');

# 插入一个标签数据
INSERT INTO tag(name) VALUES('jdbc');

# 插入一个标签数据
INSERT INTO tag(name) VALUES('mysql');

# 插入一个文章数据
INSERT INTO article(title, author, category, content) VALUES("jdbc", 1, 1, "# jdbc");

# 文章与标签关联
INSERT INTO article_tag(article, tag) VALUES(1, 1);
