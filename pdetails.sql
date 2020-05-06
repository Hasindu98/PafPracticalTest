-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3325
-- Generation Time: May 06, 2020 at 06:12 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `patient`
--

-- --------------------------------------------------------

--
-- Table structure for table `pdetails`
--

CREATE TABLE `pdetails` (
  `pat_id` int(20) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `pat_Nic` int(20) NOT NULL,
  `pat_bday` varchar(20) NOT NULL,
  `pat_phno` int(20) NOT NULL,
  `pat_email` varchar(20) NOT NULL,
  `pat_gender` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pdetails`
--

INSERT INTO `pdetails` (`pat_id`, `first_name`, `last_name`, `pat_Nic`, `pat_bday`, `pat_phno`, `pat_email`, `pat_gender`) VALUES
(1, 'Fernando', 'Laksiri', 923546579, '19/02/1998', 785643267, 'fernando@gmail.com', 'male'),
(2, 'Naradaa', 'Sanath', 975639235, '23/09/2001', 712345678, 'naradaa@gmail.com', 'male'),
(3, 'Senuri', 'lakshi', 957456789, '15/02/1998', 759341678, 'senuri@gmail.com', 'female');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pdetails`
--
ALTER TABLE `pdetails`
  ADD PRIMARY KEY (`pat_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
