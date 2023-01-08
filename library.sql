-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 08, 2023 at 09:57 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `bookName` varchar(255) NOT NULL,
  `bookAuthor` varchar(255) NOT NULL,
  `bookISBN` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `bookName`, `bookAuthor`, `bookISBN`) VALUES
(2, 'Igra staklenih perli', 'Herman Hesse', '9789940251291'),
(3, 'Prodavnica tajni', 'Dino Bucatti', '978-86-521-3367-3'),
(4, 'The Fourth Industrial Revolution', 'Klaus Schwab', '978-1524758868'),
(5, 'COVID-19: The Great Reset', 'Klaus Schwab', '978-2940631124 '),
(6, 'The Old Man and the Sea', 'Ernest Hemingway', ' 7201046446'),
(7, 'Alise', 'France Queen', '978458900'),
(9, 'The Peripheral', 'William Gibson', ' 9780241961018');

-- --------------------------------------------------------

--
-- Table structure for table `issuebook`
--

CREATE TABLE `issuebook` (
  `id` int(11) NOT NULL,
  `memberid` int(11) NOT NULL,
  `bookid` int(11) NOT NULL,
  `bookname` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `returnDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `issuebook`
--

INSERT INTO `issuebook` (`id`, `memberid`, `bookid`, `bookname`, `date`, `returnDate`) VALUES
(9, 5478, 2, 'Igra staklenih perli', '2022-07-15', '2022-07-15'),
(16, 864863, 2, 'Igra staklenih perli', '2022-07-07', '2022-07-27'),
(28, 55, 5, 'COVID-19: The Great Reset', '2022-07-28', '2022-08-08'),
(29, 34, 6, 'The Old Man and the Sea', '2022-08-01', '2022-08-10'),
(34, 34, 7, 'Alise', '2023-01-04', '2023-01-06'),
(36, 3, 5, 'COVID-19: The Great Reset', '2023-01-06', '2023-01-21');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `memberID` int(11) NOT NULL,
  `memberName` varchar(255) NOT NULL,
  `memberPhone` int(20) NOT NULL,
  `memberEmail` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `memberID`, `memberName`, `memberPhone`, `memberEmail`) VALUES
(1, 89, 'Sani Selim', 3985792, 'ssaet@dajf.com'),
(4, 3, 'Sanja Kostić', 9983000, 'snj.sl@gmail.com'),
(8, 1, 'Suzana Kojić', 381234098, 'suzanak@gmail.com'),
(9, 2, 'NIkola Vrzić', 98534699, 'nikolaj@gmail.com'),
(10, 3, 'Ivica Kojić', 542984527, 'ikojic@gmail.com'),
(12, 56, 'kloud minurin', 94275748, 'pok.ohitf@mail.ru'),
(13, 9, 'Nikola Lazić', 87999888, 'nikollla@gmail.com'),
(14, 90, 'dragana huberth', 9694867, 'dragagaga@gmail.com'),
(15, 85, 'ljubina djerić  vasić', 78666555, 'ljubina@gmail.com'),
(16, 50, ' Čupko Šljivić', 4325669, 'cupko@gmail.com'),
(18, 34, 'Eleonora Key', 198586900, 'eli@gmail.com'),
(19, 5, 'mukica', 65463777, 'muki@gmail.com'),
(20, 5, 'Ljupko', 61223889, 'ljubi@gmial.com'),
(21, 123, 'Mia Moji', 394000029, 'mia@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `returnbook`
--

CREATE TABLE `returnbook` (
  `id` int(11) NOT NULL,
  `mmbrid` int(11) NOT NULL,
  `mmbrname` varchar(255) NOT NULL,
  `bookname` varchar(255) NOT NULL,
  `returndate` varchar(255) NOT NULL,
  `dayselapsed` int(11) NOT NULL,
  `fine` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `returnbook`
--

INSERT INTO `returnbook` (`id`, `mmbrid`, `mmbrname`, `bookname`, `returndate`, `dayselapsed`, `fine`) VALUES
(1, 1, 'Suzana Kojić', 'Igra staklenih perli', '2022-07-29', 0, 0),
(2, 2, 'NIkola Vrzić', 'Prodavnica tajni', '2022-07-09', 3, 1.5),
(3, 23, 'nada', 'Igra staklenih perli', '2022-07-21', 0, 0),
(5, 9, 'Nikola Lazić', 'The Fourth Industrial Revolution', '2022-07-27', 0, 0),
(6, 4, 'Sanja Kostić', 'COVID-19: The Great Reset', '2022-07-09', 4, 2),
(7, 89, 'Sani Selim', 'COVID-19: The Great Reset', '2022-07-08', 5, 2.5),
(9, 1, 'Suzana Kojić', 'Prodavnica tajni', '2022-07-12', 1, 0.5),
(10, 85, 'ljubina djerić  vasić', 'The Fourth Industrial Revolution', '2022-07-06', 7, 3.5),
(11, 90, 'dragana huberth', 'Prodavnica tajni', '2022-07-12', 1, 0.5),
(13, 2, 'NIkola Vrzić', 'The Old Man and the Sea', '2023-01-07', 1, 0.5),
(14, 1, 'Suzana Kojić', 'Igra staklenih perli', '2022-08-27', 134, 67);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `issuebook`
--
ALTER TABLE `issuebook`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `returnbook`
--
ALTER TABLE `returnbook`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `issuebook`
--
ALTER TABLE `issuebook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `returnbook`
--
ALTER TABLE `returnbook`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
