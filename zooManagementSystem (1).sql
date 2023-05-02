-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 02, 2023 at 03:56 PM
-- Server version: 8.0.32-0ubuntu0.22.04.2
-- PHP Version: 8.1.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `zooManagementSystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `animal`
--

CREATE TABLE `animal` (
  `a_id` int NOT NULL,
  `a_name` varchar(100) NOT NULL,
  `Gender` varchar(100) NOT NULL,
  `zoo_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `animal`
--

INSERT INTO `animal` (`a_id`, `a_name`, `Gender`, `zoo_name`) VALUES
(55, 'Donkey', 'Male', 'Nehru Zoological Park'),
(57, 'Elephant', 'Female', 'Indira Gandhi Zoological Park'),
(59, 'Tiger', 'Male', ' Allen Forest Zoo'),
(60, 'Cat', 'Female', 'Sajjangarh Biological Park'),
(61, 'Lion', 'Male', 'Mysore Zoo'),
(111, 'Goat', 'Female', 'Gopalpur Zoo'),
(112, 'Pig', 'Male', 'Allen Forest Zoo'),
(124, 'Horse ', 'Male', 'Vandalur Zoo'),
(128, 'Huskey Dog', 'Male', 'Sajjangarh Biological Park'),
(130, 'Zebra', 'Male', 'Rajiv Gandhi Zoological Park ,Pune,india'),
(131, 'Jarman safad Dog', 'Male', 'Nehru Zoological Park,Hyderabad'),
(132, 'Bear', 'Male', 'Bhiwani Zoo,Bhiwani,Haryana');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `uid` int NOT NULL,
  `username` varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(25) COLLATE utf8mb4_general_ci NOT NULL,
  `usernumber` varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `role` varchar(50) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`uid`, `username`, `password`, `email`, `usernumber`, `role`) VALUES
(108, 'Anjali Thakur', '$2y$13$oFUB02K6vV6X/s1kEnQHP.NFbOEX.EqSvkoA8.B80WqRuOuqKTQJy', 'anjalithakur@gmail.com', '7018971634', 'User'),
(109, 'Shalini Chandel', '$2y$13$Uzu6xPI0PBlyvYPoM5fdGu0R2bjmyBoBkc/zxTz1a2chzFasLlkEq', 'shalini@gmail.com', '7015527894', 'Admin'),
(111, 'Rahul Sharma', '$2y$13$2u6rE5gcuZfjtkhjuvcR2OyJt4j754smO488wanMGOp6hbmzllyRe', 'rahulsharma@gmail.com', '7015567867', 'admin'),
(112, 'Chahat Sharma', '$2y$13$73cN8y7zpuP5e9Z8P5X/IOjH4.iwbWsLt736skN7hbELuwm9QDX4i', 'chahat@gmail.com', '7016563693', 'admin'),
(113, 'Sunil Kumar', '$2y$13$ezdg2q/qr4NuRKE22yMhjuoJ82IX4cQ.jfKuWXp0ViZtitpLythd6', 'sunil@gmail.com', '7014267893', 'user'),
(114, 'Anshul Saini', '$2y$13$hRbo8Q9QeU5LbQuCQdvoWOCPFVNGNeyn6DOXRNrGxPodUKtyKa7Iu', 'anshulsani@gmail.com', '7015527894', 'Admin'),
(168, 'Rohit Thakur', '$2a$10$PRkvDpPawSvu1fPVqrAfDeP.DORPuAAlV/cnqto1pmtE5D73BxGjC', 'rohit@gmail.com', '8218971349', 'Admin'),
(169, 'Sapna Sharma', '$2a$10$pJh7KyCBO1M2cwWyB.ETjO53k56vJm.oRIM8MbObQ8xL8fy49WRJC', 'sapnasharma@gmail.com', '8218947477', 'Admin'),
(170, 'Indu Sharma', '$2a$10$Wj1tMusbCTY2/10fz6OagearX4NRLDZKNFqicd7JLAwaWh41.4.di', 'indusharma@gmail.com', '7018971654', 'User'),
(174, 'Aditya', '$2a$10$YtQNJgo3xs5IPL34VpIenO/urfHHAEtIIcmorvlLqxX8vFQENSYKa', 'aditya@gmail.com', '8219315000', 'User'),
(175, 'deeksha', '$2a$10$A27cTvI7atcaGmBBAfcUmeCWL0spUj.QnUsL/kGt.1vkYrvBslGX2', 'deeksha@gmail.com', '7018971654', 'Admin'),
(178, 'Ritika ', '$2a$10$ZhMCwlxjGRiDNvzEMJ7xEemuP.5XU.MdDsnnIL1dzxjom/866UAUq', 'ritika@gmail.com', '8218971699', 'Admin'),
(186, 'Satvik', '$2a$10$XLSoOJ5YdOc5VAhHDjCJwOwHbYkDdxF9FG7rzCCtwHtrqsmXuceIu', 'satvik@gmail.com', '7018971634', 'User'),
(189, 'Manu ', '$2a$10$g.bbFuQnJSgtcfzfYJAwVec2cOxEv6FNj407KkK8CXN2qMUgq7nGq', 'manu@gmail.com', '8218971651', 'User'),
(190, 'Anu', '$2a$10$RxRyPq3uPFxhR6n7nntTE.invAhTEN4n4lzqrvfGREy/Owfn1bPzW', 'anu@gmail.com', '8213399933', 'Admin'),
(194, 'Sonia Sharma', '$2a$10$HpJKK0rueHXl5h3.bsEdEeXqEpJ7apd5Irei6/ryXxDRW3dnrXUNW', 'sonia@gmail.com', '7018971222', 'User');

-- --------------------------------------------------------

--
-- Table structure for table `zoo`
--

CREATE TABLE `zoo` (
  `z_id` int NOT NULL,
  `z_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `z_location` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `zoo`
--

INSERT INTO `zoo` (`z_id`, `z_name`, `z_location`) VALUES
(81, 'Indira Gandhi Zoological Park Zoo', 'Visakhapatnam'),
(85, 'Vandalur Zoo', 'Vandalur,Chennai'),
(86, 'Gopalpur Zoo', 'Kangra, Himachal Pradesh'),
(89, 'National Zoological Park', 'Delhi,India'),
(90, 'Mysore Zoo', 'Mysore'),
(92, 'Nehru Zoological Park', 'Hyderabad'),
(136, 'Sajjangarh Biological Park  ', 'Udaipur, Rajasthan'),
(145, 'Sanjay Gandhi Jaivik Udyan', 'Patna,India'),
(146, 'Allen Forest Zoo', 'Kanpur, India'),
(182, 'Maitri Bagh Zoo', 'Bhilai, India'),
(183, 'Bhiwani Zoo', 'Bhiwani,Haryana'),
(184, 'Thrissur Zoo', 'Thrissur, Kerala'),
(194, 'Rohtak Zoo', 'Rohtak ,Haryana'),
(195, 'Nehru Zoological Park', 'Hyderabad, Telangana');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `animal`
--
ALTER TABLE `animal`
  ADD PRIMARY KEY (`a_id`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`uid`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `zoo`
--
ALTER TABLE `zoo`
  ADD PRIMARY KEY (`z_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `animal`
--
ALTER TABLE `animal`
  MODIFY `a_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=135;

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `uid` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=196;

--
-- AUTO_INCREMENT for table `zoo`
--
ALTER TABLE `zoo`
  MODIFY `z_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=196;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
