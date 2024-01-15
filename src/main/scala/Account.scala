package dev.khusanjon

// account model
case class Account(id: String, name: String, timestamp: Long)

/*
 * mysql accounts table structs
+-----------+--------------+------+-----+---------+-------+
| Field     | Type         | Null | Key | Default | Extra |
+-----------+--------------+------+-----+---------+-------+
| id        | varchar(100) | NO   | PRI | NULL    |       |
| name      | varchar(100) | YES  |     | NULL    |       |
| timestamp | mediumtext   | YES  |     | NULL    |       |
+-----------+--------------+------+-----+---------+-------+
/*
