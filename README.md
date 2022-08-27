**<h1 align="center">&nbsp;<img height="50" width="80" src="https://user-images.githubusercontent.com/62439381/185650577-c4dcc4c4-dee8-4859-ae22-f6a55b9f0559.png"> Projeto CRUD em JAVA & MySQL <img height="50" width="80" src="https://user-images.githubusercontent.com/62439381/185650577-c4dcc4c4-dee8-4859-ae22-f6a55b9f0559.png">&nbsp;</h1>**

Desenvolvimento de um simples projeto CRUD (Sistema de uma aula EAD) utilizando o acesso a banco de dados com o MySQL e linguagem JAVA com swing

## Assuntos Abordados no Desenvolvimento do Projeto:

- Acesso a banco de dados com o MySql.
- Uso de linguagens, como: Java.

## Configuração do Projeto:

- Baixar o **XAMPP** em seu sistema operacional **https://www.apachefriends.org/pt_br/index.html**
- Instale e coloque o projeto dentro desta árvore de arquivos **_C:\XAMPP/htdocs_** (isso vai depender de onde foi instalado).
- Executar o **XAMPP** e iniciar o apache2 e mySQL.
- Executar a query **banco-de-dados.sql** ou importar o arquivo no **_phpMyAdmin_** para criar a table necessária.
<br>

```
-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 19, 2018 at 12:07 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `user`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `id_number` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `fname`, `lname`, `id_number`) VALUES
(2, 'james', 'muriithi', '12345678');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_number` (`id_number`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

```
## Início:

- Acesse em seu navegador e digite **http://localhost**
- Entre no arquivo do projeto.
- O sistema deverá estar rodando conforme o **Video** abaixo.

https://user-images.githubusercontent.com/62439381/185810596-702838ba-5438-4038-b938-56f1cf89ca22.mp4

#    
