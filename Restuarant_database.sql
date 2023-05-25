create database restuarant;
use restuarant;

create table food_type(
	id int primary key auto_increment,
	food_type_name varchar(50) not null unique key
	);

insert into food_type values(1,"Soups and Salads"),
	(2,"Starters"),
	(3,"Main Course"),
	(4,"Rotis"),
	(5,"Desserts");

create table menu(id int primary key auto_increment,
	food_type_id int not null,
	dish_name varchar(50) not null unique key,
	is_veg boolean not null,
	price int not null,
    is_available boolean not null,
    image_path varchar(1024) default "default.jpg"
	);
    
insert into menu values(1,1,"Veg manchow soup",True,115,True,"resources/images/soup1.jpg"),
    (2,1,"Mutton Bone Soup",False,140,True,"resources/images/soup2.jpg"),
	(3,1,"Hot & Sour",True,110,True,"resources/images/soup3.jpg"),
    (4,1,"Lemon Coriander",True,110,True,"resources/images/soup4.jpg"),
    (5,2,"Paneer Tikka",True,240,True,"resources/images/starters1.jpg"),
    (6,2,"Malai Tikka Kebab",False,240,True,"resources/images/starters2.jpg"),
    (7,2,"Tandoori Chicken Half",False,280,True,"resources/images/starters3.jpg"),
	(8,2,"Gobi Manchuria",True,200,True,"resources/images/starters4.jpg"),
    (9,2,"Fish Tikka",False,380,True,"resources/images/starters5.jpg"),
    (10,2,"Tandoori Prawns",False,390,True,"resources/images/starters6.jpg"),
    (13,3,"Butter Chicken",False,270,True,"resources/images/maincourse1.jpg"),
    (14,3,"Kadhai Chicken",False,270,True,"resources/images/maincourse2.jpg"),
    (11,3,"Kadai Paneer",True,240,True,"resources/images/maincourse3.jpg"),
    (12,3,"Malai Kofta",True,240,True,"resources/images/maincourse4.jpg"),
    (15,3,"Punjabi Chicken",False,270,True,"resources/images/maincourse5.jpg"),
    (16,3,"Chicken Biryani Regular",False,245,True,"resources/images/maincourse6.jpg"),
    (17,3,"Chicken Biryani Special",False,320,True,"resources/images/maincourse6.jpg"),
    (18,3,"Fish Biryani",False,270,True,"resources/images/maincourse7.jpg"),
    (19,4,"Rumali Roti",True,35,True,"resources/images/roti1.jpg"),
    (20,4,"Butter Naan",True,35,True,"resources/images/roti2.jpg"),
    (21,4,"Garlic Naan",True,40,True,"resources/images/roti3.jpg"),
    (22,5,"Apricot Delight",True,120,True,"resources/images/deserts1.jpg"),
    (23,5,"Qurbani Ka Meetha",True,120,True,"resources/images/deserts2.jpg"),
    (24,5,"Gulab Jamun",True,120,True,"resources/images/deserts3.jpg"),
    (25,5,"Rabdi Malai",True,140,True,"resources/images/deserts4.jpg");
    
alter table menu
add foreign key(food_type_id) references food_type(id);

create table invoice_item(
	id int auto_increment primary key,
    invoice_id int not null,
    menu_id int not null,
    quantity int not null
    );

create table invoice(
	id int auto_increment primary key,
    order_id varchar(30),
    order_time timestamp default(current_timestamp()),
    customer_id int not null
    );

create table customer(
	id int auto_increment primary key,
    phone_no varchar(10) not null,
    customer_name varchar(50) not null
    );

alter table invoice
add foreign key(customer_id) references customer(id);

alter table invoice_item
add foreign key(menu_id) references menu(id);

alter table invoice_item
add foreign key(invoice_id) references invoice(id);

create table payment_type(
	id int auto_increment primary key,
	payment_option varchar(30) not null unique key
	);
        
insert into payment_type values(1,"cash"),
	(2,"upi"),
	(3,"credit/debit card");
        
create table payment(
	id int auto_increment primary key,
    invoice_id int not null,
    customer_id int not null,
    payment_date date not null,
    payment_type_id int not null,
    total_amount float not null,
    constraint unique_payment unique(customer_id,invoice_id)
    );

alter table payment
add foreign key(invoice_id) references invoice(id);

alter table payment
add foreign key(payment_type_id) references payment_type(id);

create table taxes_and_charges(
	id int auto_increment primary key,
    cgst float not null,
    sgst float not null,
    convinience_fee float not null
    );
    
insert into taxes_and_charges values(1,2.5,2.5,0);

alter table invoice
add column charges_id int not null;

alter table invoice
add foreign key(charges_id) references taxes_and_charges(id);

create table rating(
	id int primary key,
    review varchar(20));
   
create table user_review(
	id int primary key,
	invoice_id int not null,
    comments varchar(50),
    rating_id int not null);
    
alter table user_review
add foreign key(invoice_id) references invoice(id),
add foreign key(rating_id) references rating(id);

insert into rating values(1,"worst experience"),(2,"bad experience"),(3,"average"),(4,"good"),(5,"excellent");

create table avg_dish_rating(id int primary key auto_increment,menu_id int unique key,customercount int,avg_rating float);

insert into avg_dish_rating values(1,1,1,4.0),(2,2,1,4.0),(3,3,1,4.0),(4,4,1,4.0),(5,5,1,4.0),(6,6,1,4.0),(7,7,1,4.0),(8,8,1,4.0),(9,9,1,4.0),(10,10,1,4.0),(11,11,1,4.0),(12,12,1,4.0),(13,13,1,4.0),(14,14,1,4.0),(15,15,1,4.0),(16,16,1,4.0),(17,17,1,4.0),(18,18,1,4.0),(19,19,1,4.0),(20,20,1,4.0),(21,21,1,4.0),(22,22,1,4.0),(23,23,1,4.0),(24,24,1,4.0),(25,25,1,4.0);
alter table avg_dish_rating add foreign key(menu_id) references menu(id);

create table invoice_item_rating(id int primary key auto_increment,invoice_item_id int,rating_id int);
alter table invoice_item_rating add foreign key(invoice_item_id) references invoice_item(id);
alter table invoice_item_rating add foreign key(rating_id) references rating(id);
