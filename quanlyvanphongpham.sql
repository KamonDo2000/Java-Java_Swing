-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2020 at 04:35 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlyvanphongpham`
--

-- --------------------------------------------------------

--
-- Table structure for table `dangnhap`
--

CREATE TABLE `dangnhap` (
  `UserName` varchar(50) NOT NULL,
  `PassWorld` varchar(50) NOT NULL,
  `use` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dangnhap`
--

INSERT INTO `dangnhap` (`UserName`, `PassWorld`, `use`) VALUES
('dothegiahuy', '1', '0'),
('lexuantruong', '1', '1'),
('dangductrung', '1', '0');

-- --------------------------------------------------------

--
-- Table structure for table `hanghoa`
--

CREATE TABLE `hanghoa` (
  `idHang` varchar(30) NOT NULL,
  `tenHang` varchar(30) NOT NULL,
  `giaBan` varchar(30) NOT NULL,
  `tonKho` varchar(30) NOT NULL,
  `daBan` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hanghoa`
--

INSERT INTO `hanghoa` (`idHang`, `tenHang`, `giaBan`, `tonKho`, `daBan`) VALUES
('BB01', 'Bút Bi Đỏ', '3000', '50', '10'),
('BB02', 'Bút Bi Xanh', '3500', '100', '47'),
('BB03', 'Bút Bi Đen', '3500', '36', '4'),
('BB04', 'Bút Bi Tím', '3500', '38', '23'),
('BB05', 'Thước Kẻ', '4000', '40', '23'),
('BB06', 'Compa', '6000', '29', '8'),
('BB07', 'ruy băng', '10000', '40', '10'),
('BB08', 'Thiệp mời', '6000', '100', '47'),
('BB09', 'Bút Máy', '50000', '10', '8'),
('BB10', 'Vở Ô Li', '12000', '19', '9'),
('BB11', 'Vở 200 Trang', '12500', '30', '10'),
('BB12', 'Vở note', '7000', '78', '10'),
('BB13', 'Keo 502', '6000', '50', '6'),
('BB14', 'Keo con chó', '20000', '15', '6'),
('BB15', 'Keo nến', '10000', '100', '86'),
('BB16', 'Kim Tuyến', '25000', '40', '20'),
('BB17', 'Giấy màu', '5000', '40', '20'),
('BB18', 'Túi Chống Sốc', '100000', '10', '3'),
('BB19', 'Dây kẽm', '5000', '10', '2'),
('BB20', 'Dây Kẽm Chỉ', '3000', '6', '8'),
('BB21', 'Giấy dán vở', '2000', '60', '20'),
('BB22', 'Giấy Kiếng', '3000', '65', '20'),
('BB23', 'Bút Chì', '1000', '50', '5'),
('BB24', 'Bút Chì Kim', '1500', '54', '5'),
('BB25', 'Len Cuộn', '50000', '39', '8'),
('BB26', 'Tẩy', '1000', '50', '16'),
('BB27', 'Bàn Thấp', '300000', '10', '1'),
('BB28', 'Ổ Điện', '30000', '19', '5');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

CREATE TABLE `hoadon` (
  `maHoaDon` varchar(50) NOT NULL,
  `idKhach` varchar(50) NOT NULL,
  `idHang` varchar(50) NOT NULL,
  `soLuong` varchar(50) NOT NULL,
  `thanhTien` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hoadon`
--

INSERT INTO `hoadon` (`maHoaDon`, `idKhach`, `idHang`, `soLuong`, `thanhTien`) VALUES
('HD01', 'Đỗ Long Đường', 'BB02', '2', 7000),
('HD01', 'Đỗ Long Đường', 'BB09', '20', 1000000),
('HD01', 'Đỗ Long Đường', 'BB06', '12', 72000),
('HD02', 'Vừ A Dính', 'BB06', '15', 90000),
('HD02', 'Vừ A Dính', 'BB18', '6', 600000),
('HD02', 'Vừ A Dính', 'BB15', '6', 60000),
('HD03', 'Đỗ Thế Gia Huy', 'BB12', '6', 42000),
('HD03', 'Đỗ Thế Gia Huy', 'BB19', '6', 30000),
('HD04', 'Nguyễn Thành Long', 'BB05', '4', 16000),
('HD04', 'Nguyễn Thành Long', 'BB17', '4', 20000),
('HD05', 'Lê Ngọc Dự', 'BB24', '19', 28500);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKH` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Age` varchar(50) NOT NULL,
  `Gender` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`MaKH`, `Name`, `Age`, `Gender`, `Address`, `Phone`) VALUES
('KH01', 'Đỗ Gia Huy', '20', 'Nam', 'Hồ Chí Minh', '0774053798'),
('KH02', 'Đỗ Long Đường', '25', 'Nam', 'Hồ Chí Minh', '0923136787'),
('KH03', 'Phạm Đình Lưu', '22', 'Nam', 'Nghệ An', '0923136253'),
('KH04', 'Vừ A Dính', '30', 'Nam', 'Điện Biên', '09273139832'),
('KH05', 'Đoàn Ngọc Hải', '27', 'Nam', 'Lai Châu', '0923439423'),
('KH06', 'Bùi Thị Xuân', '43', 'Nữ', 'Hà Đông', '0985937544'),
('KH07', 'Đỗ Thành Long', '34', 'Nam', 'Hà Đông', '097863745'),
('KH08', 'Đỗ Động Tân', '48', 'Nam', 'Khánh Hội', '097849542');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` varchar(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Age` varchar(50) NOT NULL,
  `Gender` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL,
  `Salary` varchar(50) NOT NULL,
  `Time` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `Name`, `Age`, `Gender`, `Address`, `Phone`, `Salary`, `Time`) VALUES
('NV01', 'Lê Đình Thám ', '20', 'Nam', 'Quảng Bình', '093829402', '1000', '24/11/2020'),
('NV02', 'Lê Bảo An', '25', 'Nam', 'Quảng Trị', '083912838', '1500', '2/4/2020'),
('NV03', 'Nguyễn Từ Tốn', '23', 'Nam', 'Quảng Trị', '084627381', '1000', '25/4/2020'),
('NV04', 'Phạm Bình Gôn', '29', 'Nam', 'Hà Nội', '0846273123', '3000', '25/11/2020'),
('NV05', 'Đỗ Công Tuyên', '26', 'Nam', 'Quảng An', '093792719', '5000', '5/6/2022'),
('NV06', 'Nguyễn Thị Bé', '19', 'Nữ ', 'Điện Thọ', '0938928790', '2000', '24/9/2020'),
('NV07', 'Nguyễn Văn A', '20', 'Nam', 'Nha Trang', '0938928790', '2500', '24/2/2020'),
('NV08', 'Nguyễn Thị B', '23', 'Nữ', 'Đà Lạt', '0938928790', '3000', '24/12/2020'),
('NV09', 'Nguyễn Thị Tốt', '21', 'Nữ', 'Tây Ninh', '0938912932', '3500', '2/3/2020'),
('NV10', 'Nguyễn Thị Dông', '28', 'Nữ', 'Đồng Nai', '093892345', '3500', '2/6/2020'),
('NV11', 'Đặng văn Dung', '23', 'Nam', 'Hà Nam', '093981928', '3000', '23/4/2020');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
