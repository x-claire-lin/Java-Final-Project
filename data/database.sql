/* Author: Yongxing Lian, Qirong Chen, Xihong Lin, Cheng Zhang  */

DROP DATABASE IF EXISTS FWRP;
CREATE DATABASE FWRP;
use FWRP;
CREATE TABLE Users
(
   userID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   userName varchar(30) NOT NULL,
   userEmail varchar(30) NOT NULL,
   userPhoneNumber varchar(30) NOT NULL,
   userPassword varchar(30) NOT NULL,
   userCity varchar(30) NOT NULL,
   userType varchar(30) NOT NULL
);
-- CREATE TABLE Products
CREATE TABLE Products
(
   productID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   productName varchar(30) NOT NULL,
   salePrice decimal NOT NULL,
   discountPrice decimal,
   inventoryAmount int NOT NULL,
   discountAmount int,
   donationAmount int,
   productType varchar(30) NOT NULL,
   surplusFlag varchar(4),
   userID int NOT NULL,
   expiryDate date,
   FOREIGN KEY (userID) References Users(userID)
);      

-- CREATE TABLE UserSubscription
CREATE TABLE UserSubscription
(
    subscriptionID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    userID int NOT NULL,
    productType varchar(30) NOT NULL,
    communicationMethod  varchar(30),
    userEmail  varchar(30),
    userPhoneNumber  varchar(30),
    userCity varchar(30) NOT NULL,
    surplusFlag varchar(4),
    FOREIGN KEY (userID) References Users(userID)
);
-- CREATE TABLE ProductTypes


-- CREATE TABLE SubscriptionMsg
CREATE TABLE SubscriptionMsg
(
 ID  int NOT NULL AUTO_INCREMENT PRIMARY KEY,
 senderName varchar(100) NOT NULL,
 recipientID int NOT NULL,
 content varchar(200) NOT NULL,
 dateSent date
);

CREATE VIEW DonationView AS
SELECT p.userID as uID,productID, productName, donationAmount,u.userName as DonationCompany
FROM Products as p join users as u on p.userID = u.userID
WHERE donationAmount IS NOT NULL AND donationAmount > 0;

CREATE VIEW DiscountView As
SELECT p.userID as uID,productID, productName, discountAmount, discountPrice, u.userName as DiscountCompany
FROM Products as p join users as u on p.userID = u.userID
WHERE discountAmount IS NOT NULL AND discountAmount > 0;


INSERT INTO users (userName,userEmail,userPhoneNumber,userPassword,userCity,userType) VALUES ('admin','admin@admin.com','6137712065','admin','ottawa','admin');
INSERT INTO users (userName,userEmail,userPhoneNumber,userPassword,userCity,userType) VALUES ('Walmart','Walmart@Walmart.com','4168523698','walmart','Toronto','retailer');
INSERT INTO users (userName,userEmail,userPhoneNumber,userPassword,userCity,userType) VALUES ('loblaws','loblaws@loblaws.com','7538810821','loblaws','Ottawa','retailer');
INSERT INTO users (userName,userEmail,userPhoneNumber,userPassword,userCity,userType) VALUES ('foodbanks','foodbanks@foodbanks.com','6138523620','foodbanks','Ottawa','charitable organization');
INSERT INTO users (userName,userEmail,userPhoneNumber,userPassword,userCity,userType) VALUES ('foodMissions','foodMissions@foodMissions.com','6130241369','foodMissions','Toronto','charitable organization');
INSERT INTO users (userName,userEmail,userPhoneNumber,userPassword,userCity,userType) VALUES ('Tom','toms@gmail.com','6137410258','toms','Ottawa','consumer');
INSERT INTO users (userName,userEmail,userPhoneNumber,userPassword,userCity,userType) VALUES ('Mike','mike@gmail.com','6139638520','mike','Toronto','consumer');

-- INSERT product TO Products
INSERT INTO Products (productName, salePrice, inventoryAmount, productType, surplusFlag, userID, expiryDate)
VALUES
    ('bread1', 3.97, 100, 'bread', 'Y', 3, '2024-08-1'),
    ('bread2', 5.97, 150, 'bread', 'N', 2, '2025-08-05'),
    ('meat3', 18.99, 200, 'meat', 'Y', 3, '2024-07-15'),
    ('meat4', 6.74, 75, 'meat','N', 2, '2024-6-20'),
    ('fruit5', 8.97, 120, 'fruit', 'Y', 3, '2024-8-25'),
    ('fruit6', 6.43, 180, 'fruit', 'N', 2, '2024-7-10'),
    ('vegi7', 5.28, 90, 'vegi', 'Y', 3, '2025-7-05'),
    ('vegi8', 3.99, 250, 'vegi', 'N', 2, '2024-7-12'),
    ('dairy9', 6.08, 130, 'dairy', 'Y', 3, '2024-7-15'),
    ('dairy10', 5.89, 110, 'dairy', 'N', 2, '2024-6-01');
    
-- INSERT records TO UserSubscription      
INSERT INTO UserSubscription (userID, productType,userCity)
VALUES
    (6, 'meat','Ottawa'),
    (7, 'meat','Ottawa'),
    (6, 'bread','Ottawa'),
    (7, 'bread','Toronto');
    
    
-- CREATE VIEW ProductTypes
CREATE VIEW ProductTypes AS 
SELECT DISTINCT productType FROM Products;


-- INSERT records TO subscriptionMsg
INSERT INTO subscriptionMsg (senderName,recipientID,content,dateSent)
VALUES
    ('walmart',3,'meat','2024-08.01'),
    ('walmart',3,'fruit','2024-07.03'),
    ('loblaws',4,'meat','2024-08.01'),
    ('loblaws',4,'fruit','2024-06.03');


update products set donationAmount =20.0  where productID = 6;
update products set donationAmount =50.0  where productID = 2;
update products set discountAmount =50.0  where productID = 3;
update products set discountAmount =50.0  where productID = 10;

select * from subscriptionMsg;
select * from Products;
select * from Products where userID=2 and surplusFlag='Y';
select * from users;
select * from DonationView where uID =2;
select * from DiscountView;
select * from usersubscription;
update discountview set discountPrice =20  where productID = 10;
select * from subscriptionMsg;

