
DROP TABLE IF EXISTS `musician`;
CREATE TABLE `musician` (
  `id` BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `musician_first_name` varchar(255) NOT NULL,
  `musician_last_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);



DROP TABLE IF EXISTS `song`;
CREATE TABLE `song` (
  `id` BIGINT unsigned NOT NULL AUTO_INCREMENT,
  `song_title` varchar(255) DEFAULT NULL,
  `artist_last_name` varchar(255) DEFAULT NULL,
  `year_published` varchar(255) DEFAULT NULL,
  `musician_id` BIGINT(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_song_musicianid_idx` (`musician_id`),
  CONSTRAINT `fk_song_musicianid` FOREIGN KEY (`musician_id`) REFERENCES `musician` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);