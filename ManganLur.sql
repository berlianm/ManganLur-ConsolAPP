-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2022 at 02:24 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `harga` int(11) NOT NULL,
  `jenis` varchar(255) NOT NULL,
  `id_restoran` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id`, `nama`, `harga`, `jenis`, `id_restoran`) VALUES
(1, 'Ayam Bakar', 15000, 'Makanan', 2),
(3, 'Es Teh', 5000, 'Minuman', 4),
(4, 'Nasi Rames', 10000, 'Makanan', 4);

-- --------------------------------------------------------

--
-- Table structure for table `restoran`
--

CREATE TABLE `restoran` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `tempat_duduk` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `layanan` varchar(255) NOT NULL,
  `nomor_telepon` varchar(255) NOT NULL,
  `pihak_restoran` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restoran`
--

INSERT INTO `restoran` (`id`, `nama`, `tempat_duduk`, `alamat`, `layanan`, `nomor_telepon`, `pihak_restoran`) VALUES
(1, 'LKJ', '5', '', 'Mamam', '082939292', 2),
(2, 'MnM', '5', 'Jalan Jalan', 'Dine In', '08768282838473', 3),
(3, 'Nasi Padang Rahmat', '40', 'Jalan sukohadi', 'Dine In, Take Away', '087782878372', 4),
(4, 'Dian Food', '20', 'Jalan W.R', 'Dine In', '087726388493', 5);

-- --------------------------------------------------------

--
-- Table structure for table `review_menu`
--

CREATE TABLE `review_menu` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `review` varchar(255) NOT NULL,
  `id_reviewer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `review_menu`
--

INSERT INTO `review_menu` (`id`, `id_menu`, `review`, `id_reviewer`) VALUES
(3, 3, 'Segarrrr', 4);

-- --------------------------------------------------------

--
-- Table structure for table `review_restoran`
--

CREATE TABLE `review_restoran` (
  `id` int(11) NOT NULL,
  `id_restoran` int(11) NOT NULL,
  `review` varchar(255) NOT NULL,
  `id_reviewer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `review_restoran`
--

INSERT INTO `review_restoran` (`id`, `id_restoran`, `review`, `id_reviewer`) VALUES
(1, 4, 'Tempat nyaman', 4);

-- --------------------------------------------------------

--
-- Table structure for table `user_restoran`
--

CREATE TABLE `user_restoran` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nik` varchar(255) NOT NULL,
  `nomor_telepon` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_restoran`
--

INSERT INTO `user_restoran` (`id`, `nama`, `username`, `email`, `password`, `nik`, `nomor_telepon`) VALUES
(4, 'Rahmat', 'rhmat', 'rhmat@mail.com', 'rhmat', '298392938293', '0877263782345'),
(5, 'Dian', 'dian', 'dian@mail.com', 'dian', '9288394893829', '0998773899483');

-- --------------------------------------------------------

--
-- Table structure for table `user_review`
--

CREATE TABLE `user_review` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_review`
--

INSERT INTO `user_review` (`id`, `nama`, `username`, `email`, `password`) VALUES
(2, 'Yah', 'yah', 'yah@mail.com', 'yah'),
(3, 'Sandy', 'sand', 'sand@mail.com', 'sand'),
(4, 'Revian', 'rev', 'rev@mail.com', 'rev');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `restoran`
--
ALTER TABLE `restoran`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `review_menu`
--
ALTER TABLE `review_menu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `review_restoran`
--
ALTER TABLE `review_restoran`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_restoran`
--
ALTER TABLE `user_restoran`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_review`
--
ALTER TABLE `user_review`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `restoran`
--
ALTER TABLE `restoran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `review_menu`
--
ALTER TABLE `review_menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `review_restoran`
--
ALTER TABLE `review_restoran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user_restoran`
--
ALTER TABLE `user_restoran`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_review`
--
ALTER TABLE `user_review`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
