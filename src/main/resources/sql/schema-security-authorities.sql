CREATE DATABASE IF NOT EXISTS `paul_dirac`;
USE `paul_dirac`;

--
-- Table structure for table `authorities`
-- This is part of security to define users' roles/authorities in Database
--

DROP TABLE IF EXISTS `authorities`;

CREATE TABLE `authorities` (
  `username`varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,

  UNIQUE KEY `authorities_idx_1` (`username`, `authority`),

  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--CREATE TABLE `authorities` (
--  `username` varchar(50) NOT NULL,
--  `authority` varchar(50) NOT NULL,
--  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
--  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
--) ENGINE=InnoDB DEFAULT CHARSET=latin1;