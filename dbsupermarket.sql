-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2019 at 03:26 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`supermarket` /*!40100 DEFAULT CHARACTER SET latin1 */;

--
-- Database: `supermarket`
--

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `id_akun` int(11) NOT NULL,
  `username` varchar(10) NOT NULL,
  `pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`id_akun`, `username`, `pass`) VALUES
(1, 'admin', 'asdfg');

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `id_anggota` int(11) NOT NULL,
  `nama_anggota` varchar(50) NOT NULL,
  `almt_anggota` varchar(50) DEFAULT NULL,
  `notelp_anggota` varchar(12) DEFAULT NULL,
  `poin_anggota` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` int(11) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `harga_beli` int(11) DEFAULT NULL,
  `harga_jual` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama_barang`, `jumlah`, `harga_beli`, `harga_jual`) VALUES
(1, 'NIVEA MEN Black&White Invisible 50ml', 9, 15000, 18000),
(2, 'ROMA CREAM CRACKERS 135g', 50, 8000, 10000),
(3, 'DAISHA LIP BALM 10g', 0, 35000, 40000);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` int(11) NOT NULL,
  `nama_karyawan` varchar(50) NOT NULL,
  `almt_karyawan` varchar(100) DEFAULT NULL,
  `kota_karyawan` varchar(50) DEFAULT NULL,
  `notelp_karyawan` varchar(12) DEFAULT NULL,
  `kategori_karyawan` varchar(15) NOT NULL,
  `deleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `nama_karyawan`, `almt_karyawan`, `kota_karyawan`, `notelp_karyawan`, `kategori_karyawan`, `deleted`) VALUES
(1, 'Dany Muhammad Ghaly', 'Jl. Wonodri Baru III nomor 6', 'Semarang', '08213826033', 'Full Time', 0),
(2, 'Gustaf', 'Petek', 'Semarang', '082213545', 'Part Time', 0),
(3, 'Adyatma Fajriannur', 'Jl. Wanara', 'Semarang', '0484246', 'Full Time', 0),
(4, 'Dhanu', '', '', '', 'Part Time', 0),
(5, 'asdfasd', '', '', '', 'Full Time', 0),
(6, 'haha', '', '', '', 'Full Time', 0),
(7, 'hehe', '', '', '', 'Full Time', 0),
(8, 'entah', '', '', '', 'Full Time', 0),
(9, 'afdasfsdaffffff', '', '', '', 'Part Time', 0),
(10, 'fffff', '', '', '', 'Full Time', 0),
(11, 'lelahcok', '', '', '', 'Full Time', 0),
(12, 'ffffffaaaaaa', '', '', '', 'Full Time', 0),
(13, 'aaaaaa', '', '', '', 'Full Time', 0),
(14, 'entah', '', '', '', 'Full Time', 1),
(15, 'Gggggg', 'fafafa', 'w', '', 'Full Time', 1),
(16, 'jajajajaja', '', '', '', 'Part Time', 0),
(17, 'Jihad', 'haha', '', '', 'Full Time', 0),
(18, 'coba', '', '', '', 'Part Time', 0);

-- --------------------------------------------------------

--
-- Table structure for table `pembuangan`
--

CREATE TABLE `pembuangan` (
  `id_pembuangan` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `id_karyawan` int(11) NOT NULL,
  `tgl_pembuangan` date NOT NULL,
  `jml_buang` int(11) NOT NULL,
  `ket_pembuangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pemesanan`
--

CREATE TABLE `pemesanan` (
  `id_pemesanan` int(11) NOT NULL,
  `id_barang` int(11) NOT NULL,
  `id_karyawan` int(11) NOT NULL,
  `id_suplier` int(11) NOT NULL,
  `tgl_pemesanan` date NOT NULL,
  `jml_pesanan` int(11) NOT NULL,
  `status_pemesanan` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pemesanan`
--

INSERT INTO `pemesanan` (`id_pemesanan`, `id_barang`, `id_karyawan`, `id_suplier`, `tgl_pemesanan`, `jml_pesanan`, `status_pemesanan`) VALUES
(1, 1, 1, 1, '2019-03-26', 100, 'Tunggu'),
(2, 2, 1, 2, '2019-03-27', 150, 'Tunggu'),
(3, 1, 1, 1, '2019-03-27', 50, 'Tunggu'),
(4, 1, 1, 1, '2019-03-27', 200, 'Tunggu'),
(5, 1, 1, 1, '2019-03-26', 50, 'Tunggu'),
(6, 2, 1, 2, '2019-03-27', 50, 'Tunggu');

-- --------------------------------------------------------

--
-- Table structure for table `suplier`
--

CREATE TABLE `suplier` (
  `id_suplier` int(11) NOT NULL,
  `nama_suplier` varchar(100) NOT NULL,
  `almt_suplier` varchar(100) DEFAULT NULL,
  `kota_suplier` varchar(50) DEFAULT NULL,
  `notelp_suplier` varchar(12) DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `suplier`
--

INSERT INTO `suplier` (`id_suplier`, `nama_suplier`, `almt_suplier`, `kota_suplier`, `notelp_suplier`, `deleted`) VALUES
(1, 'PT Beiersdorf Indonesia', 'Jl. Raya Randuagug KM. 75', 'Malang', '08001164832', 0),
(2, 'PT. AMIDIS TIRTA MULIA', '', 'Bandung', '', 0),
(3, 'PT.CS2 Pola Sehat', 'JL.Lalalalalol', 'Bogor', '08001077777', 0),
(4, 'PT. Samsung', '', 'Jakarta', '', 0),
(5, 'GAGA', '', '', '', 0),
(6, 'PT. Mayora Indah Tbk', '', 'Tangerang', '', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`id_akun`);

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
  ADD PRIMARY KEY (`id_anggota`);

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `pembuangan`
--
ALTER TABLE `pembuangan`
  ADD PRIMARY KEY (`id_pembuangan`),
  ADD KEY `id_barang` (`id_barang`),
  ADD KEY `id_karyawan` (`id_karyawan`);

--
-- Indexes for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`id_pemesanan`),
  ADD KEY `id_barang` (`id_barang`),
  ADD KEY `id_karyawan` (`id_karyawan`),
  ADD KEY `id_suplier` (`id_suplier`);

--
-- Indexes for table `suplier`
--
ALTER TABLE `suplier`
  ADD PRIMARY KEY (`id_suplier`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `akun`
--
ALTER TABLE `akun`
  MODIFY `id_akun` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `anggota`
--
ALTER TABLE `anggota`
  MODIFY `id_anggota` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `karyawan`
--
ALTER TABLE `karyawan`
  MODIFY `id_karyawan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `pembuangan`
--
ALTER TABLE `pembuangan`
  MODIFY `id_pembuangan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pemesanan`
--
ALTER TABLE `pemesanan`
  MODIFY `id_pemesanan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `suplier`
--
ALTER TABLE `suplier`
  MODIFY `id_suplier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pembuangan`
--
ALTER TABLE `pembuangan`
  ADD CONSTRAINT `pembuangan_ibfk_1` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `pembuangan_ibfk_2` FOREIGN KEY (`id_karyawan`) REFERENCES `karyawan` (`id_karyawan`);

--
-- Constraints for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD CONSTRAINT `pemesanan_ibfk_1` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `pemesanan_ibfk_2` FOREIGN KEY (`id_karyawan`) REFERENCES `karyawan` (`id_karyawan`),
  ADD CONSTRAINT `pemesanan_ibfk_3` FOREIGN KEY (`id_suplier`) REFERENCES `suplier` (`id_suplier`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
