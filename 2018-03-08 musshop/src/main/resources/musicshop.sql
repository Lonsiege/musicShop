-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Мар 08 2018 г., 18:51
-- Версия сервера: 10.1.21-MariaDB
-- Версия PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `musicshop`
--

-- --------------------------------------------------------

--
-- Структура таблицы `combo`
--

CREATE TABLE `combo` (
  `id` int(11) NOT NULL,
  `combine` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `counter` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Дамп данных таблицы `combo`
--

INSERT INTO `combo` (`id`, `combine`, `counter`) VALUES
(100010, '1 2 3', 1),
(100011, '1 5', 3),
(100015, '9 10', 3),
(100020, '1 2', 1),
(100033, '1 9', 1),
(100038, '3 8', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `global_seq`
--

CREATE TABLE `global_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Дамп данных таблицы `global_seq`
--

INSERT INTO `global_seq` (`next_val`) VALUES
(100044),
(100044),
(100044),
(100044),
(100044);

-- --------------------------------------------------------

--
-- Структура таблицы `items`
--

CREATE TABLE `items` (
  `id` int(11) NOT NULL,
  `catalog_id` int(11) NOT NULL,
  `imageurl` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `manufactorer` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `price` int(11) NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Дамп данных таблицы `items`
--

INSERT INTO `items` (`id`, `catalog_id`, `imageurl`, `manufactorer`, `name`, `price`, `stock`) VALUES
(100000, 1, '1', 'Fender', 'Stratocaster', 200, 4),
(100001, 2, '2', 'Gibson', 'Les Paul', 200, 5),
(100002, 3, '3', 'Ibanez', 'RGV', 300, 4),
(100003, 4, '4', 'Ural', 'Aelita', 100, 2),
(100004, 5, '5', 'Bugera', '333XL', 50, 2),
(100005, 6, '6', 'Randall', 'Eod 88', 100, 2),
(100006, 7, '7', 'Ural', 'Classic', 150, 1),
(100007, 8, '8', 'D drum', 'd2', 450, 6),
(100008, 9, '9', 'Stadd', 'Blues', 550, 5),
(100009, 10, '10', 'Seinheiser', 'Rocky', 80, 20);

-- --------------------------------------------------------

--
-- Структура таблицы `sales`
--

CREATE TABLE `sales` (
  `id` int(11) NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sum` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Дамп данных таблицы `sales`
--

INSERT INTO `sales` (`id`, `email`, `sum`) VALUES
(100012, 'ilia@ilia.com', 630),
(100017, 'rewr', 400),
(100022, 'goro@goro.ru', 630),
(100026, 'bogo@hobo', 630),
(100030, 'rew', 750),
(100035, 'president@kremlin.com', 750),
(100040, 'goo', 250);

-- --------------------------------------------------------

--
-- Структура таблицы `salescombo`
--

CREATE TABLE `salescombo` (
  `id` int(11) NOT NULL,
  `combo_id` int(11) DEFAULT NULL,
  `sale_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Дамп данных таблицы `salescombo`
--

INSERT INTO `salescombo` (`id`, `combo_id`, `sale_id`) VALUES
(100016, 100015, 100012),
(100021, 100020, 100017),
(100025, 100015, 100022),
(100029, 100015, 100026),
(100034, 100033, 100030),
(100039, 100038, 100035),
(100043, 100011, 100040);

-- --------------------------------------------------------

--
-- Структура таблицы `salesitems`
--

CREATE TABLE `salesitems` (
  `id` int(11) NOT NULL,
  `item_id` int(11) DEFAULT NULL,
  `sale_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Дамп данных таблицы `salesitems`
--

INSERT INTO `salesitems` (`id`, `item_id`, `sale_id`) VALUES
(100013, 100008, 100012),
(100014, 100009, 100012),
(100018, 100000, 100017),
(100019, 100001, 100017),
(100023, 100008, 100022),
(100024, 100009, 100022),
(100027, 100008, 100026),
(100028, 100009, 100026),
(100031, 100000, 100030),
(100032, 100008, 100030),
(100036, 100002, 100035),
(100037, 100007, 100035),
(100041, 100000, 100040),
(100042, 100004, 100040);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `combo`
--
ALTER TABLE `combo`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `combo_unique_combine` (`combine`);

--
-- Индексы таблицы `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `catalog_id_unique` (`catalog_id`);

--
-- Индексы таблицы `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `salescombo`
--
ALTER TABLE `salescombo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5sed034bejk9gpihatgx4uly3` (`combo_id`),
  ADD KEY `FK26wuyub7rpmyhml6bexqsidts` (`sale_id`);

--
-- Индексы таблицы `salesitems`
--
ALTER TABLE `salesitems`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5kh65op0giod7cmmorm0l2l1g` (`item_id`),
  ADD KEY `FKspi6c2uu93vd342g68xd8sngx` (`sale_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
