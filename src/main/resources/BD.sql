CREATE DATABASE prueba_nuvu;
CREATE USER 'admin'@'%' IDENTIFIED BY '123456*';
GRANT ALL PRIVILEGES ON prueba_nuvu.* TO 'admin'@'%';
FLUSH PRIVILEGES;