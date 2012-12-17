/*
MySQL Backup
Source Server Version: 5.5.27
Source Database: xjx
Date: 2012-12-17 22:29:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `a001`
-- ----------------------------
DROP TABLE IF EXISTS `a001`;
CREATE TABLE `a001` (
  `A` varchar(255) DEFAULT NULL,
  `B` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `a002`
-- ----------------------------
DROP TABLE IF EXISTS `a002`;
CREATE TABLE `a002` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `F` bigint(20) DEFAULT NULL,
  `C` varchar(20) NOT NULL,
  `D` varchar(200) DEFAULT NULL,
  `G` int(11) DEFAULT NULL,
  `N` varchar(100) NOT NULL,
  `TY` varchar(20) NOT NULL,
  `R` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `a003`
-- ----------------------------
DROP TABLE IF EXISTS `a003`;
CREATE TABLE `a003` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `B` datetime DEFAULT NULL,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `IC` varchar(20) NOT NULL,
  `PW` varchar(35) NOT NULL,
  `P` varchar(20) DEFAULT NULL,
  `R` longtext,
  `RS` varchar(100) DEFAULT NULL,
  `RN` longtext,
  `A2` varchar(20) DEFAULT NULL,
  `X` varchar(2) NOT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `TN` varchar(20) NOT NULL,
  `E` varchar(20) DEFAULT NULL,
  `M` varchar(20) DEFAULT NULL,
  `TP` varchar(20) DEFAULT NULL,
  `N` varchar(20) NOT NULL,
  `O` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1E46523B417C36` (`O`),
  CONSTRAINT `FK1E46523B417C36` FOREIGN KEY (`O`) REFERENCES `a002` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `a004`
-- ----------------------------
DROP TABLE IF EXISTS `a004`;
CREATE TABLE `a004` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `R` longtext,
  `C` varchar(50) NOT NULL,
  `N` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `a005`
-- ----------------------------
DROP TABLE IF EXISTS `a005`;
CREATE TABLE `a005` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `C` varchar(20) NOT NULL,
  `N` varchar(50) NOT NULL,
  `F` bigint(20) DEFAULT NULL,
  `H` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `a006`
-- ----------------------------
DROP TABLE IF EXISTS `a006`;
CREATE TABLE `a006` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `C` varchar(40) NOT NULL,
  `D` varchar(200) DEFAULT NULL,
  `N` varchar(100) NOT NULL,
  `F` bigint(20) DEFAULT NULL,
  `H` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `a007`
-- ----------------------------
DROP TABLE IF EXISTS `a007`;
CREATE TABLE `a007` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `D` longtext,
  `N` varchar(200) NOT NULL,
  `P` longtext NOT NULL,
  `S` float NOT NULL,
  `AT` varchar(200) NOT NULL,
  `O` bigint(20) NOT NULL,
  `OT` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `a008`
-- ----------------------------
DROP TABLE IF EXISTS `a008`;
CREATE TABLE `a008` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `F` bigint(20) DEFAULT NULL,
  `H` bit(1) DEFAULT NULL,
  `M` bit(1) DEFAULT NULL,
  `I` varchar(100) DEFAULT NULL,
  `R` varchar(50) NOT NULL,
  `U` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `b001`
-- ----------------------------
DROP TABLE IF EXISTS `b001`;
CREATE TABLE `b001` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `RC` longtext,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `IU` varchar(100) DEFAULT NULL,
  `TT` varchar(20) DEFAULT NULL,
  `WN` varchar(200) NOT NULL,
  `RDE` datetime DEFAULT NULL,
  `RR` longtext,
  `RU` varchar(100) DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `WT` varchar(20) DEFAULT NULL,
  `OI` bigint(20) DEFAULT NULL,
  `UI` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1EBAAFEA95A1B3` (`UI`),
  KEY `FK1EBAAF3B4189A1` (`OI`),
  CONSTRAINT `FK1EBAAF3B4189A1` FOREIGN KEY (`OI`) REFERENCES `a002` (`id`),
  CONSTRAINT `FK1EBAAFEA95A1B3` FOREIGN KEY (`UI`) REFERENCES `a003` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `b002`
-- ----------------------------
DROP TABLE IF EXISTS `b002`;
CREATE TABLE `b002` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `RC` longtext,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `IU` varchar(100) DEFAULT NULL,
  `TT` varchar(20) DEFAULT NULL,
  `SNA` varchar(200) NOT NULL,
  `RDE` datetime DEFAULT NULL,
  `RR` longtext,
  `RU` varchar(100) DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `ST` varchar(20) DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `OI` bigint(20) DEFAULT NULL,
  `UI` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1EBAB0EA95A1B3` (`UI`),
  KEY `FK1EBAB03B4189A1` (`OI`),
  CONSTRAINT `FK1EBAB03B4189A1` FOREIGN KEY (`OI`) REFERENCES `a002` (`id`),
  CONSTRAINT `FK1EBAB0EA95A1B3` FOREIGN KEY (`UI`) REFERENCES `a003` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `b003`
-- ----------------------------
DROP TABLE IF EXISTS `b003`;
CREATE TABLE `b003` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `RC` longtext,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `FU` varchar(200) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `IU` varchar(200) DEFAULT NULL,
  `RDE` datetime DEFAULT NULL,
  `RTP` varchar(20) DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `RT` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `b004`
-- ----------------------------
DROP TABLE IF EXISTS `b004`;
CREATE TABLE `b004` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `RC` longtext,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `IU` varchar(100) DEFAULT NULL,
  `NN` varchar(200) NOT NULL,
  `RDE` datetime DEFAULT NULL,
  `RR` longtext,
  `RU` varchar(100) DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `NT` varchar(20) DEFAULT NULL,
  `OI` bigint(20) DEFAULT NULL,
  `UI` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1EBAB2EA95A1B3` (`UI`),
  KEY `FK1EBAB23B4189A1` (`OI`),
  CONSTRAINT `FK1EBAB23B4189A1` FOREIGN KEY (`OI`) REFERENCES `a002` (`id`),
  CONSTRAINT `FK1EBAB2EA95A1B3` FOREIGN KEY (`UI`) REFERENCES `a003` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `b005`
-- ----------------------------
DROP TABLE IF EXISTS `b005`;
CREATE TABLE `b005` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `RC` longtext,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `IU` varchar(100) DEFAULT NULL,
  `TT` varchar(20) DEFAULT NULL,
  `MN` varchar(200) NOT NULL,
  `RDE` datetime DEFAULT NULL,
  `RR` longtext,
  `RU` varchar(100) DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `MT` varchar(20) DEFAULT NULL,
  `OI` bigint(20) DEFAULT NULL,
  `UI` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1EBAB3EA95A1B3` (`UI`),
  KEY `FK1EBAB33B4189A1` (`OI`),
  CONSTRAINT `FK1EBAB33B4189A1` FOREIGN KEY (`OI`) REFERENCES `a002` (`id`),
  CONSTRAINT `FK1EBAB3EA95A1B3` FOREIGN KEY (`UI`) REFERENCES `a003` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `b006`
-- ----------------------------
DROP TABLE IF EXISTS `b006`;
CREATE TABLE `b006` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `CT` varchar(20) NOT NULL,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `IT` varchar(20) NOT NULL,
  `CP` varchar(20) DEFAULT NULL,
  `CPP` varchar(20) DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `UC` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `b007`
-- ----------------------------
DROP TABLE IF EXISTS `b007`;
CREATE TABLE `b007` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `CN` int(11) DEFAULT NULL,
  `HN` int(11) DEFAULT NULL,
  `HIN` int(11) DEFAULT NULL,
  `CI` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1EBAB5588D3756` (`CI`),
  CONSTRAINT `FK1EBAB5588D3756` FOREIGN KEY (`CI`) REFERENCES `b006` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `b008`
-- ----------------------------
DROP TABLE IF EXISTS `b008`;
CREATE TABLE `b008` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `IR` bit(1) DEFAULT NULL,
  `RN` varchar(20) NOT NULL,
  `OI` bigint(20) NOT NULL,
  `RDE` datetime DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `b009`
-- ----------------------------
DROP TABLE IF EXISTS `b009`;
CREATE TABLE `b009` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `CT` longtext,
  `IR` bit(1) DEFAULT NULL,
  `NI` bigint(20) DEFAULT NULL,
  `UI` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1EBAB7EA95A1B3` (`UI`),
  KEY `FK1EBAB7234BDE82` (`NI`),
  CONSTRAINT `FK1EBAB7234BDE82` FOREIGN KEY (`NI`) REFERENCES `b004` (`id`),
  CONSTRAINT `FK1EBAB7EA95A1B3` FOREIGN KEY (`UI`) REFERENCES `a003` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `b010`
-- ----------------------------
DROP TABLE IF EXISTS `b010`;
CREATE TABLE `b010` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `content` longtext,
  `NI` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1EBACD234BDE82` (`NI`),
  CONSTRAINT `FK1EBACD234BDE82` FOREIGN KEY (`NI`) REFERENCES `b004` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `b011`
-- ----------------------------
DROP TABLE IF EXISTS `b011`;
CREATE TABLE `b011` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `CP` varchar(16) DEFAULT NULL,
  `A5` varchar(20) DEFAULT NULL,
  `FD` datetime DEFAULT NULL,
  `FP` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `IT` varchar(20) NOT NULL,
  `n1` int(11) DEFAULT NULL,
  `n10` int(11) DEFAULT NULL,
  `n11` int(11) DEFAULT NULL,
  `n12` int(11) DEFAULT NULL,
  `n13` int(11) DEFAULT NULL,
  `n14` int(11) DEFAULT NULL,
  `n15` int(11) DEFAULT NULL,
  `n16` int(11) DEFAULT NULL,
  `n17` int(11) DEFAULT NULL,
  `n18` int(11) DEFAULT NULL,
  `n19` int(11) DEFAULT NULL,
  `n2` int(11) DEFAULT NULL,
  `n20` int(11) DEFAULT NULL,
  `n3` int(11) DEFAULT NULL,
  `n4` int(11) DEFAULT NULL,
  `n5` int(11) DEFAULT NULL,
  `n6` int(11) DEFAULT NULL,
  `n7` int(11) DEFAULT NULL,
  `n8` int(11) DEFAULT NULL,
  `n9` int(11) DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `SM` varchar(2) NOT NULL,
  `SY` varchar(5) NOT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `UR` varchar(20) DEFAULT NULL,
  `EI` bigint(20) DEFAULT NULL,
  `OI` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1EBACEE4C4484D` (`EI`),
  KEY `FK1EBACE3B4189A1` (`OI`),
  CONSTRAINT `FK1EBACE3B4189A1` FOREIGN KEY (`OI`) REFERENCES `a002` (`id`),
  CONSTRAINT `FK1EBACEE4C4484D` FOREIGN KEY (`EI`) REFERENCES `a006` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `b012`
-- ----------------------------
DROP TABLE IF EXISTS `b012`;
CREATE TABLE `b012` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `SC` varchar(255) DEFAULT NULL,
  `NUM` int(11) DEFAULT NULL,
  `WP` varchar(200) DEFAULT NULL,
  `WT` varchar(20) DEFAULT NULL,
  `CI` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1EBACF55FF2D43` (`CI`),
  CONSTRAINT `FK1EBACF55FF2D43` FOREIGN KEY (`CI`) REFERENCES `c001` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `c001`
-- ----------------------------
DROP TABLE IF EXISTS `c001`;
CREATE TABLE `c001` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `CAD` longtext,
  `CH` varchar(20) DEFAULT NULL,
  `CN` varchar(200) NOT NULL,
  `CFI` varchar(200) DEFAULT NULL,
  `CFT` bigint(20) DEFAULT NULL,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `CI` varchar(20) DEFAULT NULL,
  `CIN` bit(1) DEFAULT NULL,
  `ISN` int(11) DEFAULT NULL,
  `IAC` bit(1) DEFAULT NULL,
  `CIA` bit(1) DEFAULT NULL,
  `ICH` bit(1) DEFAULT NULL,
  `IDG` bit(1) DEFAULT NULL,
  `ISD` bit(1) DEFAULT NULL,
  `IFK` bit(1) DEFAULT NULL,
  `CIO` bit(1) DEFAULT NULL,
  `ISA` bit(1) DEFAULT NULL,
  `LL` varchar(200) DEFAULT NULL,
  `LC` varchar(20) DEFAULT NULL,
  `LP` varchar(20) NOT NULL,
  `MN` int(11) DEFAULT NULL,
  `CON` int(11) DEFAULT NULL,
  `PN` int(11) DEFAULT NULL,
  `PM` varchar(15) DEFAULT NULL,
  `PP` varchar(20) DEFAULT NULL,
  `CR` varchar(200) DEFAULT NULL,
  `SM` varchar(15) DEFAULT NULL,
  `SNA` varchar(20) DEFAULT NULL,
  `CSN` int(11) DEFAULT NULL,
  `CSR` varchar(200) DEFAULT NULL,
  `CSS` varchar(20) DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `STN` int(11) DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `YS` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `c002`
-- ----------------------------
DROP TABLE IF EXISTS `c002`;
CREATE TABLE `c002` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `CN` varchar(20) DEFAULT NULL,
  `CC` varchar(20) NOT NULL,
  `CL` varchar(20) DEFAULT NULL,
  `ET` varchar(20) DEFAULT NULL,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `ISD` datetime DEFAULT NULL,
  `ISU` varchar(200) DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `ST` varchar(20) NOT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `VB` datetime DEFAULT NULL,
  `VE` datetime DEFAULT NULL,
  `CI` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1F2F0F55FF2D43` (`CI`),
  CONSTRAINT `FK1F2F0F55FF2D43` FOREIGN KEY (`CI`) REFERENCES `c001` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `c003`
-- ----------------------------
DROP TABLE IF EXISTS `c003`;
CREATE TABLE `c003` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `CET` varchar(20) DEFAULT NULL,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `IPD` datetime DEFAULT NULL,
  `IPU` varchar(200) DEFAULT NULL,
  `CML` varchar(20) DEFAULT NULL,
  `CN` varchar(20) NOT NULL,
  `PU` varchar(200) DEFAULT NULL,
  `CPP` varchar(15) DEFAULT NULL,
  `PDU` varchar(200) DEFAULT NULL,
  `RC` varchar(20) DEFAULT NULL,
  `RDE` datetime DEFAULT NULL,
  `RU` varchar(200) DEFAULT NULL,
  `SP` varchar(20) DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `CS` varchar(20) DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `UA` varchar(200) DEFAULT NULL,
  `CUN` varchar(200) DEFAULT NULL,
  `CUA` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `c004`
-- ----------------------------
DROP TABLE IF EXISTS `c004`;
CREATE TABLE `c004` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `CN` varchar(20) DEFAULT NULL,
  `CC` varchar(20) DEFAULT NULL,
  `CL` varchar(20) DEFAULT NULL,
  `ET` varchar(20) DEFAULT NULL,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `ISD` datetime DEFAULT NULL,
  `IU` varchar(200) DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `ST` varchar(20) DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `VB` datetime DEFAULT NULL,
  `VE` datetime DEFAULT NULL,
  `CI` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1F2F1155FF2D43` (`CI`),
  CONSTRAINT `FK1F2F1155FF2D43` FOREIGN KEY (`CI`) REFERENCES `c001` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `c005`
-- ----------------------------
DROP TABLE IF EXISTS `c005`;
CREATE TABLE `c005` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `ADS` varchar(200) DEFAULT NULL,
  `CA` int(11) DEFAULT NULL,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `CI` varchar(20) DEFAULT NULL,
  `CN` varchar(20) DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `CS` varchar(2) DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `c006`
-- ----------------------------
DROP TABLE IF EXISTS `c006`;
CREATE TABLE `c006` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `ACT` varchar(20) DEFAULT NULL,
  `CAC` longtext,
  `AD` datetime DEFAULT NULL,
  `CAD` varchar(100) DEFAULT NULL,
  `CAL` float DEFAULT NULL,
  `CAP` varchar(20) DEFAULT NULL,
  `ARD` datetime DEFAULT NULL,
  `ARU` varchar(100) DEFAULT NULL,
  `CAT` varchar(20) DEFAULT NULL,
  `CBT` varchar(20) DEFAULT NULL,
  `CID` varchar(200) DEFAULT NULL,
  `CNS` longtext,
  `DN` int(11) DEFAULT NULL,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `CIR` bit(1) DEFAULT NULL,
  `MWN` int(11) DEFAULT NULL,
  `MN` int(11) DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `SWN` int(11) DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `TN` int(11) DEFAULT NULL,
  `ARO` bigint(20) DEFAULT NULL,
  `CAU` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1F2F135600A0B4` (`CAU`),
  KEY `FK1F2F133B42F625` (`ARO`),
  CONSTRAINT `FK1F2F133B42F625` FOREIGN KEY (`ARO`) REFERENCES `a002` (`id`),
  CONSTRAINT `FK1F2F135600A0B4` FOREIGN KEY (`CAU`) REFERENCES `c001` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `c007`
-- ----------------------------
DROP TABLE IF EXISTS `c007`;
CREATE TABLE `c007` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `CDE` datetime DEFAULT NULL,
  `CN` varchar(20) DEFAULT NULL,
  `CCN` varchar(20) DEFAULT NULL,
  `CDT` varchar(100) DEFAULT NULL,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `CIA` bit(1) DEFAULT NULL,
  `CLN` varchar(20) DEFAULT NULL,
  `LC` varchar(20) DEFAULT NULL,
  `PNB` varchar(20) DEFAULT NULL,
  `CRK` longtext,
  `A2` varchar(20) DEFAULT NULL,
  `CSY` varchar(100) DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `c008`
-- ----------------------------
DROP TABLE IF EXISTS `c008`;
CREATE TABLE `c008` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `CC` varchar(20) DEFAULT NULL,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `PID` varchar(20) NOT NULL,
  `PN` varchar(20) NOT NULL,
  `PP` varchar(20) DEFAULT NULL,
  `PSC` float DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `PST` int(11) DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `TT` varchar(20) DEFAULT NULL,
  `CI` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1F2F1555FF2D43` (`CI`),
  CONSTRAINT `FK1F2F1555FF2D43` FOREIGN KEY (`CI`) REFERENCES `c001` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `c009`
-- ----------------------------
DROP TABLE IF EXISTS `c009`;
CREATE TABLE `c009` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `CC` varchar(20) NOT NULL,
  `CDE` datetime DEFAULT NULL,
  `CDA` varchar(200) DEFAULT NULL,
  `CDC` varchar(20) DEFAULT NULL,
  `DCT` longtext,
  `CDM` varchar(13) DEFAULT NULL,
  `CDP` varchar(13) DEFAULT NULL,
  `DT` varchar(20) DEFAULT NULL,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `CIA` bit(1) DEFAULT NULL,
  `CL` varchar(20) DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `CS` varchar(200) DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `CI` bigint(20) DEFAULT NULL,
  `OI` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1F2F1655FF2D43` (`CI`),
  KEY `FK1F2F163B4189A1` (`OI`),
  CONSTRAINT `FK1F2F163B4189A1` FOREIGN KEY (`OI`) REFERENCES `a002` (`id`),
  CONSTRAINT `FK1F2F1655FF2D43` FOREIGN KEY (`CI`) REFERENCES `c001` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `c010`
-- ----------------------------
DROP TABLE IF EXISTS `c010`;
CREATE TABLE `c010` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `CDE` datetime NOT NULL,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `CL` varchar(20) NOT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `CS` varchar(200) NOT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `HI` bigint(20) DEFAULT NULL,
  `OI` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1F2F2C70934F9F` (`HI`),
  KEY `FK1F2F2C3B4189A1` (`OI`),
  CONSTRAINT `FK1F2F2C3B4189A1` FOREIGN KEY (`OI`) REFERENCES `a002` (`id`),
  CONSTRAINT `FK1F2F2C70934F9F` FOREIGN KEY (`HI`) REFERENCES `c009` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `c011`
-- ----------------------------
DROP TABLE IF EXISTS `c011`;
CREATE TABLE `c011` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `CT1` varchar(255) DEFAULT NULL,
  `CT2` varchar(255) DEFAULT NULL,
  `CT3` varchar(255) DEFAULT NULL,
  `CT4` varchar(255) DEFAULT NULL,
  `FT` varchar(20) DEFAULT NULL,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `LT` varchar(20) DEFAULT NULL,
  `PA` varchar(200) DEFAULT NULL,
  `PI` float DEFAULT NULL,
  `PN` varchar(200) DEFAULT NULL,
  `PT` varchar(20) DEFAULT NULL,
  `A2` varchar(20) DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `CI` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1F2F2D55FF2D43` (`CI`),
  CONSTRAINT `FK1F2F2D55FF2D43` FOREIGN KEY (`CI`) REFERENCES `c001` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `c012`
-- ----------------------------
DROP TABLE IF EXISTS `c012`;
CREATE TABLE `c012` (
  `id` bigint(20) NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `ED` datetime DEFAULT NULL,
  `EU` varchar(100) DEFAULT NULL,
  `A5` varchar(20) DEFAULT NULL,
  `A1` varchar(20) DEFAULT NULL,
  `A4` varchar(20) DEFAULT NULL,
  `IO` varchar(100) DEFAULT NULL,
  `IT` varchar(20) DEFAULT NULL,
  `PL` varchar(100) DEFAULT NULL,
  `RO` varchar(100) DEFAULT NULL,
  `RM` longtext,
  `A2` varchar(20) DEFAULT NULL,
  `SD` datetime DEFAULT NULL,
  `A3` varchar(20) DEFAULT NULL,
  `CI` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1F2F2E55FF2D43` (`CI`),
  CONSTRAINT `FK1F2F2E55FF2D43` FOREIGN KEY (`CI`) REFERENCES `c001` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_back_inventory`
-- ----------------------------
DROP TABLE IF EXISTS `jx_back_inventory`;
CREATE TABLE `jx_back_inventory` (
  `JB_ID` int(11) NOT NULL,
  `JB_CODE` varchar(20) NOT NULL,
  `JB_LAST_CODE` varchar(20) NOT NULL,
  `JB_OCODE` varchar(20) NOT NULL,
  `JB_CODEMARK` varchar(50) DEFAULT NULL,
  `JB_DEPT` int(11) NOT NULL,
  `JB_SUPPLIER` int(11) NOT NULL,
  `JB_USER` int(11) NOT NULL,
  `JB_DATE` datetime NOT NULL,
  `JB_CHECKUSER` int(11) DEFAULT NULL,
  `JB_WAREHOUSE` int(11) NOT NULL,
  `JB_REMARK` varchar(500) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JB_ID`),
  KEY `FK_BACK_INVENTORY_CHECKUSER` (`JB_CHECKUSER`),
  KEY `FK_BACK_INVENTORY_DEPT` (`JB_DEPT`),
  KEY `FK_BACK_INVENTORY_SUPPLIER` (`JB_SUPPLIER`),
  KEY `FK_BACK_INVENTORY_USER` (`JB_USER`),
  KEY `FK_BACK_INVENTORY_WAREHOUSE` (`JB_WAREHOUSE`),
  CONSTRAINT `FK_BACK_INVENTORY_CHECKUSER` FOREIGN KEY (`JB_CHECKUSER`) REFERENCES `jx_employee` (`JE_ID`),
  CONSTRAINT `FK_BACK_INVENTORY_DEPT` FOREIGN KEY (`JB_DEPT`) REFERENCES `jx_dept` (`JD_ID`),
  CONSTRAINT `FK_BACK_INVENTORY_SUPPLIER` FOREIGN KEY (`JB_SUPPLIER`) REFERENCES `jx_supplier` (`JS_ID`),
  CONSTRAINT `FK_BACK_INVENTORY_USER` FOREIGN KEY (`JB_USER`) REFERENCES `jx_employee` (`JE_ID`),
  CONSTRAINT `FK_BACK_INVENTORY_WAREHOUSE` FOREIGN KEY (`JB_WAREHOUSE`) REFERENCES `jx_warehouse` (`JW_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_back_inventory_details`
-- ----------------------------
DROP TABLE IF EXISTS `jx_back_inventory_details`;
CREATE TABLE `jx_back_inventory_details` (
  `JBD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JBD_BACK_INVENTORY` int(11) NOT NULL,
  `JBD_BARCODE` varchar(20) NOT NULL,
  `JBD_CODE` varchar(20) NOT NULL,
  `JBD_NAME` varchar(50) NOT NULL,
  `JBD_UNIT` int(11) NOT NULL,
  `JBD_QUANTITY` float(10,2) DEFAULT NULL,
  `JBD_COST` float(10,4) DEFAULT NULL,
  `JBD_AMOUNT` float(10,2) DEFAULT NULL,
  `JBD_NUM` float(10,2) DEFAULT NULL,
  `JBD_OVERFLOW` varchar(50) DEFAULT NULL,
  `JBD_RATE` float(2,2) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JBD_ID`),
  KEY `FK_BACK_INVENTORY_DETAILS_MAIN` (`JBD_BACK_INVENTORY`),
  CONSTRAINT `FK_BACK_INVENTORY_DETAILS_MAIN` FOREIGN KEY (`JBD_BACK_INVENTORY`) REFERENCES `jx_back_inventory` (`JB_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_customer`
-- ----------------------------
DROP TABLE IF EXISTS `jx_customer`;
CREATE TABLE `jx_customer` (
  `JC_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JC_CODE` varchar(20) NOT NULL,
  `JC_CLAZZ` char(1) NOT NULL,
  `JC_NAME` varchar(200) NOT NULL,
  `JC_ADDRESS` varchar(300) DEFAULT NULL,
  `JC_POST` varchar(6) DEFAULT NULL,
  `JC_PHONE` varchar(20) DEFAULT NULL,
  `JC_FULLNAME` varchar(200) DEFAULT NULL,
  `JC_BANK` varchar(200) DEFAULT NULL,
  `JC_ACCOUNT` varchar(50) DEFAULT NULL,
  `JC_DUTY` varchar(50) DEFAULT NULL,
  `JC_USER` int(11) NOT NULL,
  `JC_CANUSE` tinyint(1) NOT NULL,
  `JC_REMARK` varchar(500) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JC_ID`),
  KEY `FK_CUSTOMER_EMPLOYEE` (`JC_USER`),
  CONSTRAINT `FK_CUSTOMER_EMPLOYEE` FOREIGN KEY (`JC_USER`) REFERENCES `jx_employee` (`JE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_dept`
-- ----------------------------
DROP TABLE IF EXISTS `jx_dept`;
CREATE TABLE `jx_dept` (
  `JD_ID` int(11) NOT NULL,
  `JD_CODE` varchar(20) NOT NULL,
  `JD_NAME` varchar(50) NOT NULL,
  `JD_PARENT` int(11) DEFAULT NULL,
  `JD_CANUSE` tinyint(1) NOT NULL,
  `JD_REMARK` varchar(500) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_employee`
-- ----------------------------
DROP TABLE IF EXISTS `jx_employee`;
CREATE TABLE `jx_employee` (
  `JE_ID` int(11) NOT NULL,
  `JE_CODE` varchar(20) NOT NULL,
  `JE_PLACE` varchar(20) DEFAULT NULL,
  `JE_CLAZZ` char(1) NOT NULL,
  `JE_NAME` varchar(20) NOT NULL,
  `JE_DEPT` int(11) NOT NULL,
  `JE_SEX` tinyint(1) NOT NULL,
  `JE_IDCARD` varchar(30) DEFAULT NULL,
  `JE_DEGREE` tinyint(1) DEFAULT NULL,
  `JE_JOB` int(11) DEFAULT NULL,
  `JE_BIRTHDAY` datetime DEFAULT NULL,
  `JE_ADDRESS` varchar(200) DEFAULT NULL,
  `JE_POST` varchar(6) DEFAULT NULL,
  `JE_PHONE` varchar(20) DEFAULT NULL,
  `JE_ISJOB` tinyint(1) DEFAULT NULL,
  `JE_LEVEL` tinyint(1) DEFAULT NULL,
  `JE_WORKDATE` datetime DEFAULT NULL,
  `JE_INDATE` datetime DEFAULT NULL,
  `JE_RESUME` text,
  `JE_RELATION` varchar(500) DEFAULT NULL,
  `JE_REMARK` varchar(500) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JE_ID`),
  KEY `FK_EMPLOYEE_DEPT` (`JE_DEPT`),
  CONSTRAINT `FK_EMPLOYEE_DEPT` FOREIGN KEY (`JE_DEPT`) REFERENCES `jx_dept` (`JD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_goods`
-- ----------------------------
DROP TABLE IF EXISTS `jx_goods`;
CREATE TABLE `jx_goods` (
  `JG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JG_INCODE` varchar(20) NOT NULL,
  `JG_CODE` varchar(20) NOT NULL,
  `JG_NAME` varchar(100) NOT NULL,
  `JG_DEPT` int(11) NOT NULL,
  `JG_SUNIT` int(11) NOT NULL,
  `JG_BUNIT` int(11) NOT NULL,
  `JG_SPEC` varchar(20) DEFAULT NULL,
  `JG_CATE` int(11) NOT NULL,
  `JG_ORIGIN` varchar(50) DEFAULT NULL,
  `JG_FACTORY` varchar(200) DEFAULT NULL,
  `JG_RATE` int(2) DEFAULT NULL,
  `JG_GUIDED` float(2,2) DEFAULT NULL,
  `JG_SHELF` int(3) DEFAULT NULL,
  `JG_PTYPE` int(11) NOT NULL,
  `JG_PCYCLE` int(3) DEFAULT NULL,
  `JG_STYPE` int(11) DEFAULT NULL,
  `JG_SEWAY` int(3) DEFAULT NULL,
  `JG_CANSELL` tinyint(1) NOT NULL,
  `JG_SPARE` tinyint(1) NOT NULL,
  `JG_INTSELL` tinyint(1) NOT NULL,
  `JG_REMARK` varchar(500) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JG_ID`),
  KEY `FK_GOODS_BUNIT` (`JG_BUNIT`),
  KEY `FK_GOODS_DEPT` (`JG_DEPT`),
  KEY `FK_GOODS_PRODUCT` (`JG_CATE`),
  KEY `FK_GOODS_PUCHASE_TYPE` (`JG_PTYPE`),
  KEY `FK_GOODS_SETTLEMENT_TYPE` (`JG_STYPE`),
  KEY `FK_GOODS_SUNIT` (`JG_SUNIT`),
  CONSTRAINT `FK_GOODS_BUNIT` FOREIGN KEY (`JG_BUNIT`) REFERENCES `jx_unit` (`JU_ID`),
  CONSTRAINT `FK_GOODS_DEPT` FOREIGN KEY (`JG_DEPT`) REFERENCES `jx_dept` (`JD_ID`),
  CONSTRAINT `FK_GOODS_PRODUCT` FOREIGN KEY (`JG_CATE`) REFERENCES `jx_product_cate` (`JPC_ID`),
  CONSTRAINT `FK_GOODS_PUCHASE_TYPE` FOREIGN KEY (`JG_PTYPE`) REFERENCES `jx_puchase_type` (`JP_ID`),
  CONSTRAINT `FK_GOODS_SETTLEMENT_TYPE` FOREIGN KEY (`JG_STYPE`) REFERENCES `jx_settlement_type` (`JS_ID`),
  CONSTRAINT `FK_GOODS_SUNIT` FOREIGN KEY (`JG_SUNIT`) REFERENCES `jx_unit` (`JU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_inventory`
-- ----------------------------
DROP TABLE IF EXISTS `jx_inventory`;
CREATE TABLE `jx_inventory` (
  `JI_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JI_WAREHOUSE` int(11) NOT NULL,
  `JI_GOODS` int(11) NOT NULL,
  `JI_CURSUM` float NOT NULL,
  `JI_TOTALSUM` float NOT NULL,
  `JI_WASTESUM` float NOT NULL,
  `JI_SPARESUM` float NOT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JI_ID`),
  KEY `FK_INVENTORY_GOODS` (`JI_GOODS`),
  KEY `FK_INVENTORY_WAREHOUSE` (`JI_WAREHOUSE`),
  CONSTRAINT `FK_INVENTORY_GOODS` FOREIGN KEY (`JI_GOODS`) REFERENCES `jx_goods` (`JG_ID`),
  CONSTRAINT `FK_INVENTORY_WAREHOUSE` FOREIGN KEY (`JI_WAREHOUSE`) REFERENCES `jx_warehouse` (`JW_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_in_inventory`
-- ----------------------------
DROP TABLE IF EXISTS `jx_in_inventory`;
CREATE TABLE `jx_in_inventory` (
  `JI_ID` int(11) NOT NULL,
  `JI_CODE` varchar(20) NOT NULL,
  `JI_LAST_CODE` varchar(20) NOT NULL,
  `JI_OCODE` varchar(20) NOT NULL,
  `JI_CODEMARK` varchar(50) DEFAULT NULL,
  `JI_DEPT` int(11) NOT NULL,
  `JI_SUPPLIER` int(11) NOT NULL,
  `JI_USER` int(11) NOT NULL,
  `JI_DATE` datetime NOT NULL,
  `JI_CHECKUSER` int(11) DEFAULT NULL,
  `JI_WAREHOUSE` int(11) NOT NULL,
  `JI_REMARK` varchar(500) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JI_ID`),
  KEY `FK_IN_INVENTORY_CHECKUSER` (`JI_CHECKUSER`),
  KEY `FK_IN_INVENTORY_DEPT` (`JI_DEPT`),
  KEY `FK_IN_INVENTORY_SUPPLIER` (`JI_SUPPLIER`),
  KEY `FK_IN_INVENTORY_USER` (`JI_USER`),
  KEY `FK_IN_INVENTORY_WAREHOUSE` (`JI_WAREHOUSE`),
  CONSTRAINT `FK_IN_INVENTORY_CHECKUSER` FOREIGN KEY (`JI_CHECKUSER`) REFERENCES `jx_employee` (`JE_ID`),
  CONSTRAINT `FK_IN_INVENTORY_DEPT` FOREIGN KEY (`JI_DEPT`) REFERENCES `jx_dept` (`JD_ID`),
  CONSTRAINT `FK_IN_INVENTORY_SUPPLIER` FOREIGN KEY (`JI_SUPPLIER`) REFERENCES `jx_supplier` (`JS_ID`),
  CONSTRAINT `FK_IN_INVENTORY_USER` FOREIGN KEY (`JI_USER`) REFERENCES `jx_employee` (`JE_ID`),
  CONSTRAINT `FK_IN_INVENTORY_WAREHOUSE` FOREIGN KEY (`JI_WAREHOUSE`) REFERENCES `jx_warehouse` (`JW_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_in_inventory_details`
-- ----------------------------
DROP TABLE IF EXISTS `jx_in_inventory_details`;
CREATE TABLE `jx_in_inventory_details` (
  `JID_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JID_IN_INVENTORY` int(11) NOT NULL,
  `JID_BARCODE` varchar(20) NOT NULL,
  `JID_CODE` varchar(20) NOT NULL,
  `JID_NAME` varchar(50) NOT NULL,
  `JID_UNIT` int(11) NOT NULL,
  `JID_QUANTITY` float(10,2) DEFAULT NULL,
  `JID_COST` float(10,4) DEFAULT NULL,
  `JID_AMOUNT` float(10,2) DEFAULT NULL,
  `JID_NUM` float(10,2) DEFAULT NULL,
  `JID_OVERFLOW` varchar(50) DEFAULT NULL,
  `JID_RATE` float(2,2) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JID_ID`),
  KEY `FK_IN_INVENTORY_DETAILS_MAIN` (`JID_IN_INVENTORY`),
  KEY `FK_STOCK_INCOMING_DETAILS_UNIT` (`JID_UNIT`),
  CONSTRAINT `FK_IN_INVENTORY_DETAILS_MAIN` FOREIGN KEY (`JID_IN_INVENTORY`) REFERENCES `jx_in_inventory` (`JI_ID`),
  CONSTRAINT `FK_STOCK_INCOMING_DETAILS_UNIT` FOREIGN KEY (`JID_UNIT`) REFERENCES `jx_unit` (`JU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_move_inventory`
-- ----------------------------
DROP TABLE IF EXISTS `jx_move_inventory`;
CREATE TABLE `jx_move_inventory` (
  `JM_ID` int(11) NOT NULL,
  `JM_LAST_CODE` varchar(20) NOT NULL,
  `JM_OCODE` varchar(20) NOT NULL,
  `JM_NUM` varchar(50) DEFAULT NULL,
  `JM_DEPT` int(11) NOT NULL,
  `JM_IWAREHOUSE` int(11) NOT NULL,
  `JM_OWAREHOUSE` int(11) NOT NULL,
  `JM_USER` int(11) NOT NULL,
  `JM_DATE` datetime NOT NULL,
  `JM_REMARK` varchar(500) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JM_ID`),
  KEY `FK_MOVE_INVENTORY_DEPT` (`JM_DEPT`),
  KEY `FK_MOVE_INVENTORY_INHOUSE` (`JM_OWAREHOUSE`),
  KEY `FK_MOVE_INVENTORY_OUTHOUSE` (`JM_IWAREHOUSE`),
  KEY `FK_MOVE_INVENTORY_USER` (`JM_USER`),
  KEY `FK8A4ED97F2678841E` (`JM_USER`),
  CONSTRAINT `FK8A4ED97F2678841E` FOREIGN KEY (`JM_USER`) REFERENCES `jx_employee` (`JE_ID`),
  CONSTRAINT `FK_MOVE_INVENTORY_DEPT` FOREIGN KEY (`JM_DEPT`) REFERENCES `jx_dept` (`JD_ID`),
  CONSTRAINT `FK_MOVE_INVENTORY_INHOUSE` FOREIGN KEY (`JM_OWAREHOUSE`) REFERENCES `jx_warehouse` (`JW_ID`),
  CONSTRAINT `FK_MOVE_INVENTORY_OUTHOUSE` FOREIGN KEY (`JM_IWAREHOUSE`) REFERENCES `jx_warehouse` (`JW_ID`),
  CONSTRAINT `FK_MOVE_INVENTORY_USER` FOREIGN KEY (`JM_USER`) REFERENCES `jx_customer` (`JC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_move_inventory_details`
-- ----------------------------
DROP TABLE IF EXISTS `jx_move_inventory_details`;
CREATE TABLE `jx_move_inventory_details` (
  `JMD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JMD_MOVE_INVENTORY` int(11) NOT NULL,
  `JMD_BARCODE` varchar(20) NOT NULL,
  `JMD_CODE` varchar(20) NOT NULL,
  `JMD_NAME` varchar(50) NOT NULL,
  `JMD_UNIT` int(11) NOT NULL,
  `JMD_QUANTITY` float(10,2) DEFAULT NULL,
  `JMD_COST` float(10,4) DEFAULT NULL,
  `JMD_AMOUNT` float(10,2) DEFAULT NULL,
  `JMD_NUM` float(10,2) DEFAULT NULL,
  `JMD_OVERFLOW` varchar(50) DEFAULT NULL,
  `JMD_RATE` float(2,2) DEFAULT NULL,
  `JMD_PACK` float(10,2) DEFAULT NULL,
  `JMD_WCOST` float(10,2) DEFAULT NULL,
  `JMD_WAMOUNT` float(10,2) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JMD_ID`),
  KEY `FK_MOVE_INVENTORY_MAIN` (`JMD_MOVE_INVENTORY`),
  CONSTRAINT `FK_MOVE_INVENTORY_MAIN` FOREIGN KEY (`JMD_MOVE_INVENTORY`) REFERENCES `jx_move_inventory` (`JM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_product_cate`
-- ----------------------------
DROP TABLE IF EXISTS `jx_product_cate`;
CREATE TABLE `jx_product_cate` (
  `JPC_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JPC_CODE` varchar(20) NOT NULL,
  `JPC_NAME` varchar(100) NOT NULL,
  `JPC_USE` tinyint(1) NOT NULL,
  `JPC_MEMO` varchar(200) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JPC_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_puchase_type`
-- ----------------------------
DROP TABLE IF EXISTS `jx_puchase_type`;
CREATE TABLE `jx_puchase_type` (
  `JP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JP_CODE` varchar(20) NOT NULL,
  `JP_NAME` varchar(50) NOT NULL,
  `JP_REMARK` varchar(500) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `JP_CANUSE` bit(1) NOT NULL,
  PRIMARY KEY (`JP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_sales`
-- ----------------------------
DROP TABLE IF EXISTS `jx_sales`;
CREATE TABLE `jx_sales` (
  `JS_ID` int(11) NOT NULL,
  `JS_DEPT` int(11) NOT NULL,
  `JS_OCODE` varchar(20) NOT NULL,
  `JS_NUM` varchar(20) DEFAULT NULL,
  `JS_LAST_CODE` varchar(20) DEFAULT NULL,
  `JS_WAREHOUSE` int(11) NOT NULL,
  `JS_CUSTOMER` int(11) NOT NULL,
  `JS_SETTLEMENT` int(11) DEFAULT NULL,
  `JS_USER` int(11) NOT NULL,
  `JS_DATE` datetime NOT NULL,
  `JS_RATE` float(2,2) DEFAULT NULL,
  `JS_DELIVERY` varchar(50) DEFAULT NULL,
  `JS_REMARK` varchar(500) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JS_ID`),
  KEY `FK_SALES_CUSTOMER` (`JS_CUSTOMER`),
  KEY `FK_SALES_DEPT` (`JS_DEPT`),
  KEY `FK_SALES_EMPLOYEE` (`JS_USER`),
  KEY `FK_SALES_SETTLEMENT` (`JS_SETTLEMENT`),
  KEY `FK_SALES_WAREHOUSE` (`JS_WAREHOUSE`),
  CONSTRAINT `FK_SALES_CUSTOMER` FOREIGN KEY (`JS_CUSTOMER`) REFERENCES `jx_customer` (`JC_ID`),
  CONSTRAINT `FK_SALES_DEPT` FOREIGN KEY (`JS_DEPT`) REFERENCES `jx_dept` (`JD_ID`),
  CONSTRAINT `FK_SALES_EMPLOYEE` FOREIGN KEY (`JS_USER`) REFERENCES `jx_employee` (`JE_ID`),
  CONSTRAINT `FK_SALES_SETTLEMENT` FOREIGN KEY (`JS_SETTLEMENT`) REFERENCES `jx_settlement_type` (`JS_ID`),
  CONSTRAINT `FK_SALES_WAREHOUSE` FOREIGN KEY (`JS_WAREHOUSE`) REFERENCES `jx_warehouse` (`JW_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_sales_details`
-- ----------------------------
DROP TABLE IF EXISTS `jx_sales_details`;
CREATE TABLE `jx_sales_details` (
  `JSD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JSD_SALES` int(11) NOT NULL,
  `JSD_BARCODE` varchar(20) NOT NULL,
  `JSD_CODE` varchar(20) NOT NULL,
  `JSD_NAME` varchar(50) NOT NULL,
  `JSD_UNIT` int(11) NOT NULL,
  `JSD_QUANTITY` float(10,2) DEFAULT NULL,
  `JSD_COST` float(10,4) DEFAULT NULL,
  `JSD_AMOUNT` float(10,2) DEFAULT NULL,
  `JSD_NUM` float(10,2) DEFAULT NULL,
  `JSD_OVERFLOW` varchar(50) DEFAULT NULL,
  `JSD_RATE` float(2,2) DEFAULT NULL,
  `JSD_PAG` varchar(20) DEFAULT NULL,
  `JSD_WCOST` float(10,2) DEFAULT NULL,
  `JSD_WAMOUNT` float(10,2) DEFAULT NULL,
  `JSD_PRE` float(10,2) DEFAULT NULL,
  `JSD_SAMOUNT` float(10,2) DEFAULT NULL,
  `JSD_CUSTITEM` varchar(20) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JSD_ID`),
  KEY `FK_SALES_DETAILS_MAIN` (`JSD_SALES`),
  KEY `FK_SALES_DETAILS_UNIT` (`JSD_UNIT`),
  CONSTRAINT `FK_SALES_DETAILS_MAIN` FOREIGN KEY (`JSD_SALES`) REFERENCES `jx_sales` (`JS_ID`),
  CONSTRAINT `FK_SALES_DETAILS_UNIT` FOREIGN KEY (`JSD_UNIT`) REFERENCES `jx_unit` (`JU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_settlement_type`
-- ----------------------------
DROP TABLE IF EXISTS `jx_settlement_type`;
CREATE TABLE `jx_settlement_type` (
  `JS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JS_CODE` varchar(20) NOT NULL,
  `JS_NAME` varchar(50) NOT NULL,
  `JS_REMARK` varchar(500) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_supplier`
-- ----------------------------
DROP TABLE IF EXISTS `jx_supplier`;
CREATE TABLE `jx_supplier` (
  `JS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JS_CODE` varchar(20) NOT NULL,
  `JS_NAME` varchar(100) NOT NULL,
  `JS_ADDR` varchar(200) DEFAULT NULL,
  `JS_POST` char(6) DEFAULT NULL,
  `JS_TELE` varchar(20) DEFAULT NULL,
  `JS_FULLNAME` varchar(200) DEFAULT NULL,
  `JS_BANK` varchar(50) DEFAULT NULL,
  `JS_ACCOUNT` varchar(50) DEFAULT NULL,
  `JS_DUTYNO` varchar(50) DEFAULT NULL,
  `JS_CONTACT` varchar(20) DEFAULT NULL,
  `JS_PERSON` varchar(20) DEFAULT NULL,
  `JS_REMARK` varchar(200) DEFAULT NULL,
  `JS_CANUSE` tinyint(1) NOT NULL,
  `JS_CATE` char(1) DEFAULT NULL,
  `JS_LIMIT` float(2,2) DEFAULT NULL,
  `JS_BALANCE` float(2,2) DEFAULT NULL,
  `JS_CREATETIME` datetime DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_unit`
-- ----------------------------
DROP TABLE IF EXISTS `jx_unit`;
CREATE TABLE `jx_unit` (
  `JU_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JU_CODE` varchar(20) NOT NULL,
  `JU_NAME` varchar(50) NOT NULL,
  `JU_MEMO` varchar(200) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  PRIMARY KEY (`JU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `jx_warehouse`
-- ----------------------------
DROP TABLE IF EXISTS `jx_warehouse`;
CREATE TABLE `jx_warehouse` (
  `JW_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JW_CODE` varchar(20) NOT NULL,
  `JW_NAME` varchar(50) NOT NULL,
  `JW_MEMO` varchar(200) DEFAULT NULL,
  `CD` datetime DEFAULT NULL,
  `RD` bit(1) DEFAULT NULL,
  `MD` datetime DEFAULT NULL,
  `SN` int(11) DEFAULT NULL,
  `JW_USERS` varchar(100) DEFAULT NULL,
  `JW_USERSNAME` longtext,
  PRIMARY KEY (`JW_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `a001` VALUES ('C006','3'), ('C002','497'), ('A005','3635'), ('A006','222'), ('A004','4'), ('C001','930'), ('A002','25'), ('A003','27'), ('A008','105'), ('B003','14'), ('B004','17'), ('B001','3'), ('A007','4'), ('B009','65'), ('C008','5'), ('A009','25'), ('C013','5'), ('jx_dept','3'), ('jx_employee','5'), ('jx_puchase_type','2'), ('jx_settlement_type','4'), ('jx_unit','3'), ('jx_warehouse','3'), ('jx_supplier','2'), ('jx_customer','6'), ('jx_product_cate','2');
INSERT INTO `a002` VALUES ('1','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','CZ000001','滁州市安全监管局',NULL,'滁州市安全监管局','public',NULL), ('2','2012-09-17 22:23:00','','2012-09-17 22:23:00','0','1','CZ000002','滁州市安全监管局',NULL,'滁州市安全监管局','public',NULL), ('3','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','1','CZ000003','琅琊区安全监管局',NULL,'琅琊区安全监管局','public',NULL), ('4','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','1','CZ000004','定远县安全监管局',NULL,'定远县安全监管局','public',NULL), ('5','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','1','CZ000005','南谯区安全监管局',NULL,'南谯区安全监管局','public',NULL), ('6','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','1','CZ000006','明光市安全监管局',NULL,'明光市安全监管局','public',NULL), ('7','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','1','CZ000007','来安县安全监管局',NULL,'来安县安全监管局','public',NULL), ('8','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','1','CZ000008','全椒县安全监管局',NULL,'全椒县安全监管局','public',NULL), ('9','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','1','CZ000009','凤阳县安全监管局',NULL,'凤阳县安全监管局','public',NULL), ('10','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','1','CZ000010','天长市安全监管局',NULL,'天长市安全监管局','public',NULL), ('11','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','1','CZ00000101','党组书记、局长 董学赋',NULL,'党组书记、局长 董学赋','inner',NULL), ('12','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','2','11','CZ0000010101','党组成员、副局长 刘泽斌',NULL,'党组成员、副局长 刘泽斌','inner',NULL), ('13','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','1','11','CZ0000010102','党组成员、副局长 朱伟',NULL,'党组成员、副局长  朱伟','inner',NULL), ('14','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','3','11','CZ0000010103','党组成员、纪检组长  李义明',NULL,'党组成员、纪检组长  李义明','inner',NULL), ('15','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','13','CZ000001010101','监管二科',NULL,'监管二科','inner',NULL), ('16','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','13','CZ000001010102','行政审批科',NULL,'行政审批科','inner',NULL), ('17','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','12','CZ000001010301','监管一科',NULL,'监管一科','inner',NULL), ('18','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','12','CZ000001010302','职业健康科',NULL,'职业健康科','inner',NULL), ('19','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','12','CZ000001010303','安委会办公室',NULL,'安委会办公室','inner',NULL), ('20','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','14','CZ000001010201','规划科技科',NULL,'规划科技科','inner',NULL), ('21','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','14','CZ000001010202','监察支队',NULL,'监察支队','inner',NULL), ('22','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','4','11','CZ0000010104','副调研员  吕宝林',NULL,'副调研员  吕宝林','inner',NULL), ('23','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','22','CZ000001010401','办公室',NULL,'办公室','inner',NULL), ('24','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','22','CZ000001010402','机关后勤',NULL,'机关后勤','inner',NULL);
INSERT INTO `a003` VALUES ('1','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','1980-01-01 00:00:00',NULL,'341100',NULL,'513022198212121677','96e79218965eb72c92a549dd5a330112','','','1','超级管理员','0','男',NULL,'超级管理员','','','0550-3075685','master','1'), ('2','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','1980-01-01 00:00:00',NULL,'341100',NULL,'513022198712121677','c4ca4238a0b923820dcc509a6f75849b','','','2','系统管理员','0','男',NULL,'系统管理员','','18668270570','0574-88220977','admin','1'), ('3','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_01',NULL,'3','普通用户',NULL,'男',NULL,'董学赋',NULL,'18005508231','3075680','dongxf','1'), ('4','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_02',NULL,'3','普通用户',NULL,'男',NULL,'朱 伟',NULL,'18005505586','3075681','zhuw','1'), ('5','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_02',NULL,'3','普通用户',NULL,'男',NULL,'刘泽斌',NULL,'18005507839','3075682','liuzb','1'), ('6','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_03',NULL,'3','普通用户',NULL,'男',NULL,'李义明',NULL,'18005505589','3075683','liym','1'), ('7','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_04',NULL,'3','普通用户',NULL,'男',NULL,'李玉成',NULL,'18905500011','3075696','liyc','1'), ('8','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_05',NULL,'3','普通用户',NULL,'男',NULL,'吕宝林',NULL,'18005505728','3075685','lvbl','1'), ('9','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_06',NULL,'3','普通用户',NULL,'男',NULL,'李红兵',NULL,'18055033595','3075686','lihb','1'), ('10','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_07',NULL,'3','普通用户',NULL,'男',NULL,'张宝印',NULL,'18005505561','3075695','zhangby','1'), ('11','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_08',NULL,'3','普通用户',NULL,'男',NULL,'席氷利',NULL,'18005505600','3075693','xiyl','1'), ('12','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_09',NULL,'3','普通用户',NULL,'男',NULL,'费勤发',NULL,'18005505570','3075690','feiqf','1'), ('13','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_10',NULL,'3','普通用户',NULL,'男',NULL,'马 达',NULL,'18005505590','3075691','mada','1'), ('14','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_11',NULL,'3','普通用户',NULL,'男',NULL,'朱元华',NULL,'18005505569','3075692','zhuyh','1'), ('15','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_12',NULL,'3','普通用户',NULL,'男',NULL,'邢立发',NULL,'18955086789','3075692','xinglf','1'), ('16','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_13',NULL,'3','普通用户',NULL,'男',NULL,'王红彬',NULL,'18005505571','3075693','wanghb','1'), ('17','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_14',NULL,'3','普通用户',NULL,'男',NULL,'俞 群',NULL,'18005505572','3075697','yuqun','1'), ('18','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_15',NULL,'3','普通用户',NULL,'男',NULL,'曹孝平',NULL,'18005505580','3075690','caoxb','1'), ('19','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_16',NULL,'3','普通用户',NULL,'男',NULL,'王化开',NULL,'18005505597','3075695','wanghk','1'), ('20','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf',NULL,NULL,'3','普通用户',NULL,'男',NULL,'张仕全',NULL,'18005505565','3075686','zhangsq','1'), ('21','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_17',NULL,'3','普通用户',NULL,'女',NULL,'周小梅',NULL,'18005505585','3075686','zhouxm','1'), ('22','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_17',NULL,'3','普通用户',NULL,'女',NULL,'孙文娟',NULL,'18005505568','3075876','sunwj','1'), ('23','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_17',NULL,'3','普通用户',NULL,'男',NULL,'王福义',NULL,NULL,'3075687','wangfy','1'), ('24','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_17',NULL,'3','普通用户',NULL,'男',NULL,'盛小兵',NULL,'13305500858','3075687','shengxb','1'), ('25','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_17',NULL,'3','普通用户',NULL,'男',NULL,'刘海林',NULL,'18005505579','3075687','liuhl','1'), ('26','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','2012-09-17 22:23:00',NULL,'341100',NULL,'000000000000000000','07d0901f7c59acf7a00b15309c439fbf','position_17',NULL,'3','普通用户',NULL,'男',NULL,'巴宝峰',NULL,'18005505578','3075687','babf','1');
INSERT INTO `a004` VALUES ('1','2012-05-21 15:53:40','\0','2012-05-21 15:53:40','0','17,33,34,18,35,36,19,37,90,91,38,77,78,39,79,80,40,81,82,20,41,42,21,43,44,22,45,46,23,47,48,85,86,24,49,50,25,51,52,26,53,54,87,88,27,55,56,28,57,58,29,59,60,30,61,62,31,63,64,65,66,67,92,32,68,69,70,71,72,73,74,75,76,83,84,89\r\n','ROLE_SUPERMASTER','超级管理员'), ('2','2012-05-21 15:55:31','\0','2012-05-21 15:55:31','0','32,68,69,70,71,72,73,74,75,76,83,84,93,94,95,96,97,98,99,100,101,102,103,104','ROLE_MASTER','系统管理员'), ('3','2012-05-21 15:55:54','\0','2012-05-21 15:55:54','0','17,33,34,18,35,36,19,37,90,91,38,77,78,39,79,80,40,81,82,20,41,42,21,43,44,22,45,46,23,47,48,85,86,24,49,50,25,51,52,26,53,54,27,55,56,28,57,58,29,59,60,30,61,62,31,63,64,65,66,67,92,32,76,83,84,89\r\n','ROLE_STANDARD','普通用户');
INSERT INTO `a008` VALUES ('17','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','','',NULL,'组织机构','fkOrganize_chart.xhtml'), ('18','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','','',NULL,'通知公告','baseNotice_list.xhtml'), ('19','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','','',NULL,'数据上报',NULL), ('20','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','','',NULL,'行政许可','baseStatistic_company_licensing.xhtml'), ('21','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','','',NULL,'行政执法','baseStatistic_company_inspect.xhtml'), ('22','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','','',NULL,'标准化','baseStatistic_company_statands.xhtml'), ('23','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','','',NULL,'培训管理','baseStatistic_company_train.xhtml'), ('24','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','','',NULL,'事故管理','baseStatistic_company_accident.xhtml'), ('25','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','','',NULL,'举报投诉','companyComplaints_manager.xhtml'), ('26','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','','',NULL,'隐患排查','baseStatistic_company_danger.xhtml'), ('27','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','','',NULL,'职业健康','baseHealth_manager.xhtml'), ('28','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','','',NULL,'法律法规','baseRules_list.xhtml'), ('29','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','','',NULL,'企业管理','baseStatistic_company_industrial.xhtml'), ('30','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','','',NULL,'三同时','companyProject_manager.xhtml'), ('31','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','','',NULL,'统计汇总','baseStatistic_company_industrial.xhtml'), ('32','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','0','','',NULL,'后台管理',NULL), ('33','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','17','\0','',NULL,'组织架构图','fkOrganize_chart.xhtml'), ('34','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','17','\0','',NULL,'通讯录','fkAddressList_contact.xhtml'), ('35','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','18','\0','',NULL,'通知管理','baseNotice_manager.xhtml'), ('36','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','18','\0','',NULL,'我的通知','baseNotice_myNotice.xhtml'), ('37','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','19','','',NULL,'隐患上报',NULL), ('38','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','19','','',NULL,'工作计划',NULL), ('39','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','19','','',NULL,'会议记录',NULL), ('40','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','19','','',NULL,'工作总结',NULL), ('41','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','20','\0','',NULL,'行政许可录入','companyLicensing_companyList.xhtml'), ('42','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','20','\0','',NULL,'行政许可查询','companyLicensing_manager.xhtml'), ('43','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','21','\0','',NULL,'行政执法录入','companyInspect_companyInfoManager.xhtml'), ('44','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','21','\0','',NULL,'行政执法查询','companyInspect_list.xhtml'), ('45','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','22','\0','',NULL,'标准化录入','companyStandard_companyList.xhtml'), ('46','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','22','\0','',NULL,'标准化查询','companyStandard_manager.xhtml'), ('47','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','23','\0','',NULL,'培训结果录入','companyTrain_companyList.xhtml'), ('48','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','23','\0','',NULL,'培训结果查询','companyTrain_manager.xhtml'), ('49','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','24','\0','',NULL,'事故录入','companyAccident_companyList.xhtml'), ('50','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','24','\0','',NULL,'事故查询','companyAccident_manager.xhtml'), ('51','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','25','\0','',NULL,'举报投诉录入','companyComplaints_managerList.xhtml'), ('52','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','25','\0','',NULL,'举报投诉查询','companyComplaints_manager.xhtml'), ('53','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','26','\0','',NULL,'隐患录入','companyHiddendanger_companySerach.xhtml'), ('54','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','26','\0','',NULL,'隐患挂牌','companyHiddendanger_hiddenListingManager.xhtml'), ('55','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','27','\0','',NULL,'职业健康录入','baseHealth_companyList.xhtml'), ('56','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','27','\0','',NULL,'职业健康查询','baseHealth_manager.xhtml'), ('57','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','28','\0','',NULL,'法律法规录入','baseRules_manager.xhtml'), ('58','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','28','\0','',NULL,'法律法规查询','baseRules_list.xhtml'), ('59','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','29','\0','',NULL,'企业管理','companyInfo_manager.xhtml'), ('60','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','29','\0','',NULL,'企业查询','companyInfo_list.xhtml'), ('61','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','30','\0','',NULL,'建设项目录入','companyProject_companyList.xhtml'), ('62','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','30','\0','',NULL,'建设项目查询','companyProject_manager.xhtml'), ('63','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','31','\0','',NULL,'行业与类型统计','baseStatistic_company_industrial.xhtml'), ('64','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','31','\0','',NULL,'安全事故统计表','baseStatistic_company_accident.xhtml'), ('65','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','31','\0','',NULL,'安全培训统计表','baseStatistic_company_train.xhtml'), ('66','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','31','\0','',NULL,'行政许可统计表','baseStatistic_company_licensing.xhtml'), ('67','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','31','\0','',NULL,'达标企业统计表','baseStatistic_company_statands.xhtml'), ('68','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','32','\0','',NULL,'机构管理','fkOrganize_manager.xhtml'), ('69','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','32','\0','',NULL,'角色管理','fkRole_manager.xhtml'), ('70','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','32','\0','',NULL,'用户管理','fkUser_manager.xhtml'), ('71','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','32','\0','',NULL,'区域管理','fkArea_navigation.xhtml'), ('72','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','32','\0','',NULL,'枚举管理','fkEnum_navigation.xhtml'), ('73','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','32','\0','',NULL,'菜单管理','fkResource_manager.xhtml'), ('74','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','32','\0','',NULL,'权限分配','authoriz.xhtml'), ('75','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','32','\0','',NULL,'附件管理','fkAnnex_manager.xhtml'), ('76','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','32','\0','\0',NULL,'工作工间授权','workspace_*.xhtml'), ('77','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','38','\0','',NULL,'工作计划列表','baseWorkplan_list.xhtml'), ('78','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','38','\0','',NULL,'工作计划管理','baseWorkplan_manager.xhtml'), ('79','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','39','\0','',NULL,'会议记录列表','baseMeeting_list.xhtml'), ('80','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','39','\0','',NULL,'会议记录管理','baseMeeting_manager.xhtml'), ('81','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','40','\0','',NULL,'工作总结列表','baseSummary_list.xhtml'), ('82','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','40','\0','',NULL,'工作总结管理','baseSummary_manager.xhtml'), ('83','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','32','\0','\0',NULL,'统计权限','baseStatistic_*.xhtml'), ('84','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','32','\0','',NULL,'修改个人信息','fkUser_showSelf.xhtml'), ('85','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','23','\0','',NULL,'培训机构管理','trainorg_manager.xhtml'), ('86','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','23','\0','',NULL,'培训机构列表','trainorg_list.xhtml'), ('87','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','26','\0','',NULL,'重大危险源录入','companySignificantDanger_companySerach.xhtml '), ('88','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','26','\0','',NULL,'重大危险源查询','companySignificantDanger_companyHasSignificant.xhtml'), ('89','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','32','\0','',NULL,'通讯录管理','fkAddressList_manager.xhtml'), ('90','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','37','\0','',NULL,'道路交通隐患上报','companyReports_insert.xhtml?rptype=1'), ('91','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','37','\0','',NULL,'非煤矿山隐患上报','companyReports_insert.xhtml?rptype=0'), ('92','2012-09-17 22:23:00','\0','2012-09-17 22:23:00','0','31','\0','',NULL,'行政执法统计表','baseStatistic_company_inspect.xhtml'), ('93','2012-11-17 14:31:12','\0','2012-11-17 14:31:12','0','0','','','','基础代码',''), ('94','2012-11-17 15:38:10','\0','2012-11-17 15:38:10','0','93','\0','','','员工档案维护','jxEmployee_manager.xhtml'), ('95','2012-11-17 16:30:52','\0','2012-11-17 16:30:52','0','93','\0','','','部门代码维护','jxDept_manager.xhtml'), ('96','2012-11-21 21:48:12','\0','2012-11-21 21:48:12','0','93','\0','','','供应商进货类型维护','jxPuchaseType_manager.xhtml'), ('97','2012-11-21 21:51:39','\0','2012-11-21 21:51:39','0','93','\0','','','客户结算类型维护','jxSettlementType_manager.xhtml'), ('98','2012-11-21 21:52:47','\0','2012-11-21 21:52:47','0','93','\0','','','包装单位代码维护','jxUnit_manager.xhtml'), ('99','2012-12-02 20:24:11','\0','2012-12-02 20:24:11','0','93','\0','','','库位编码维护','jxWarehouse_manager.xhtml'), ('100','2012-12-13 16:54:01','\0','2012-12-13 16:54:01','1','0','','','','代码管理',''), ('101','2012-12-13 17:07:14','\0','2012-12-13 17:07:14','2','100','\0','','','供应商档案维护','jxSupplier_manager.xhtml'), ('102','2012-12-13 17:09:39','\0','2012-12-13 17:09:39','3','100','\0','','','客户档案维护','jxCustomer_manager.xhtml'), ('103','2012-12-13 17:14:03','\0','2012-12-13 17:14:03','4','100','\0','','','商品分类维护','jxProductCate_manager.xhtml'), ('104','2012-12-13 17:14:46','\0','2012-12-13 17:14:46','5','100','\0','','','商品代码维护','jxGoods_manager.xhtml');
INSERT INTO `jx_customer` VALUES ('5','11','a','11','','','','','','','','3','1','','2012-12-17 15:29:24','','2012-12-17 15:29:24','0');
INSERT INTO `jx_dept` VALUES ('1','1','总部','0','1','','2012-11-17 17:17:52','\0','2012-11-17 17:17:52','0'), ('2','11','直销部','0','1','','2012-11-21 22:47:47','\0','2012-11-21 22:47:47','0');
INSERT INTO `jx_employee` VALUES ('3','11','宁波','a','111','2','1','11','1','1','2012-11-14 00:00:00','111','11','111','1','0','2012-11-21 00:00:00','2012-11-14 00:00:00','1111','111','111','2012-11-21 22:53:03','\0','2012-11-21 22:53:03','0'), ('4','001','宁波','A','张明明','1','1','','6','1','2012-03-09 00:00:00','','','','1','0',NULL,NULL,'','','','2012-12-02 21:45:18','\0','2012-12-02 21:45:18','0');
INSERT INTO `jx_product_cate` VALUES ('1','11','11','1','11','2012-12-17 16:00:00','\0','2012-12-17 16:00:00','0');
INSERT INTO `jx_puchase_type` VALUES ('1','J','进销','','2012-11-21 22:07:34','\0','2012-11-21 22:07:34','0','\0');
INSERT INTO `jx_settlement_type` VALUES ('1','10','月结10天','','2012-11-21 22:26:36','\0','2012-11-21 22:26:36','0'), ('2','15','月结15天','','2012-11-21 22:26:57','\0','2012-11-21 22:26:57','0'), ('3','30','月结30天','','2012-11-21 22:27:20','\0','2012-11-21 22:27:20','0');
INSERT INTO `jx_supplier` VALUES ('1','111','11','','','','ddd','','','','','','','1','a',NULL,NULL,NULL,'2012-12-14 17:06:33','','2012-12-14 17:06:33','0');
INSERT INTO `jx_unit` VALUES ('1','个','个','','2012-11-21 22:34:41','\0','2012-11-21 22:34:41','0'), ('2','箱','箱','','2012-11-21 22:34:50','\0','2012-11-21 22:34:50','0');
INSERT INTO `jx_warehouse` VALUES ('2','01','一号仓库','','2012-12-02 22:06:32','\0','2012-12-02 22:06:32','0','4','张明明');
