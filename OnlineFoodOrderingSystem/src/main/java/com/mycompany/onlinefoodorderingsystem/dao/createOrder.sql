/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  47288
 * Created: 2021-10-1
 */


CREATE TABLE `order` (`ID` INT NOT NULL auto_increment, `dishID` INT, `customerID` INT, `quantity` INT, amount INT, `orderDate` text, `State` text, PRIMARY KEY (`ID`))
AUTO_INCREMENT=1000;

insert into ofos.`order`(dishID,customerID,quantity,amount,orderDate,State)
value(1003,10003,5,50,"5/6/2021","In preparation")