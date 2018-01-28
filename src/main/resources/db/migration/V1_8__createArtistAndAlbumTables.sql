
DROP TABLE IF EXISTS `artist`;
CREATE TABLE `artist` (
  `id` BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `artist_first_name` varchar(255) NOT NULL,
  `artist_last_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);



DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `id` BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `album_name` varchar(255) DEFAULT NULL,
  `release_year` varchar(255) DEFAULT NULL,
  `artist_id` BIGINT(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_album_artistid_idx` (`artist_id`),
  CONSTRAINT `fk_album_artistid` FOREIGN KEY (`artist_id`) REFERENCES `artist` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);