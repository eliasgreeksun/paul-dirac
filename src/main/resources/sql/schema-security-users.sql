CREATE DATABASE IF NOT EXISTS `paul_dirac`;
USE `paul_dirac`;

--
-- Table structure for table `users`
-- This is part of security to define users in Database
--

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username`varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;