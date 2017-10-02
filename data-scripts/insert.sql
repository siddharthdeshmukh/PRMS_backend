
-- -----------------------------------------------------
-- Insert Data For Table `phoenix`.`role`
-- -----------------------------------------------------

-- role, access privilege
insert into `phoenix`.`role` values("presenter","radio program presenter");
insert into `phoenix`.`role` values("manager", "station manager");
insert into `phoenix`.`role` values("admin", "system administrator");
insert into `phoenix`.`role` values("producer", "program producer");


-- -----------------------------------------------------
-- Insert Data For Table `phoenix`.`user`
-- -----------------------------------------------------

-- id, password, name, role
insert into `phoenix`.`user` values("dilbert", "dilbert", "dilbert, the hero", "presenter:producer");
insert into `phoenix`.`user` values("wally", "wally", "wally, the bludger", "producer");
insert into `phoenix`.`user` values("pointyhead", "pointyhead", "pointyhead, the manager", "manager");
insert into `phoenix`.`user` values("catbert", "catbert", "catbert, the hr", "admin:manager");
insert into `phoenix`.`user` values("dogbert", "dogbert", "dogbert, the CEO", "producer:admin");


-- -----------------------------------------------------
-- Insert Data For Table `phoenix`.`radio-program`
-- -----------------------------------------------------

insert into `phoenix`.`radio-program` values("short news", "summarised 5 minutes broadcasted every 2 hours", '00:05:00');
insert into `phoenix`.`radio-program` values("news", "full news broadcasted four times a day", '00:30:00');
insert into `phoenix`.`radio-program` values("top 10", "countdown music play of top 10 songs of the week", '01:00:00');
insert into `phoenix`.`radio-program` values("your choice", "audinece ask for music album song of thier choice", '01:00:00');
insert into `phoenix`.`radio-program` values("opinions", "discuss, debate or share opinions regarding a theme or subject", '00:30:00');
insert into `phoenix`.`radio-program` values("noose", "black comedy show", '00:30:00');
insert into `phoenix`.`radio-program` values("ppk", "phu chu kang comedy show", '00:30:00');
insert into `phoenix`.`radio-program` values("dance floor", "dance show", '00:30:00');
insert into `phoenix`.`radio-program` values("charity", "president charity show for unfortunate", '00:30:00');

-- -----------------------------------------------------
-- Insert Data For Table `phoenix`.`annual schedule`
-- -----------------------------------------------------

-- year, assignBy
insert into `phoenix`.`annual-schedule` values("2017", "pointyhead");

-- -----------------------------------------------------
-- Insert Data For Table `phoenix`.`weekely schedule`
-- -----------------------------------------------------

-- weekNo., startDate, assignBy
insert into `phoenix`.`weekly-schedule` values("1",'2017-01-02 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("2",'2017-01-09 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("3",'2017-01-16 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("4",'2017-01-23 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("5",'2017-01-30 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("6",'2017-02-06 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("7",'2017-02-13 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("8",'2017-02-20 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("9",'2017-02-27 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("10",'2017-03-06 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("11",'2017-03-13 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("12",'2017-03-20 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("13",'2017-03-27 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("14",'2017-04-03 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("15",'2017-04-10 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("16",'2017-04-17 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("17",'2017-04-24 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("18",'2017-05-01 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("19",'2017-05-08 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("20",'2017-05-15 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("21",'2017-05-22 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("22",'2017-05-29 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("23",'2017-06-05 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("24",'2017-06-12 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("25",'2017-06-19 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("26",'2017-06-26 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("27",'2017-07-03 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("28",'2017-07-10 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("29",'2017-07-17 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("30",'2017-07-24 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("31",'2017-07-31 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("32",'2017-08-07 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("33",'2017-08-14 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("34",'2017-08-21 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("35",'2017-08-28 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("36",'2017-09-04 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("37",'2017-09-11 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("38",'2017-09-18 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("39",'2017-09-25 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("40",'2017-10-02 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("41",'2017-10-07 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("42",'2017-10-14 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("43",'2017-10-21 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("44",'2017-10-28 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("45",'2017-11-06 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("46",'2017-11-13 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("47",'2017-11-20 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("48",'2017-11-27 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("49",'2017-12-04 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("50",'2017-12-11 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("51",'2017-12-18 00:00:00', "pointyhead");
insert into `phoenix`.`weekly-schedule` values("52",'2017-12-25 00:00:00', "pointyhead");


-- -----------------------------------------------------
-- Insert Data For Table `phoenix`.`program-slot`
-- -----------------------------------------------------

insert into `phoenix`.`program-slot` (duration,dateOfProgram,startTime,`program-name`,presenter,producer) values(30, '2017-09-28','09:00:00',"dance floor", "catbert", "dilbert");

insert into `phoenix`.`program-slot` (duration,dateOfProgram,startTime,`program-name`,presenter,producer) values(60, '2017-09-29','10:00:00',"your choice", "pointyhead", "dilbert");
insert into `phoenix`.`program-slot` (duration,dateOfProgram,startTime,`program-name`,presenter,producer) values(90, '2017-09-29','11:00:00',"top 10", "catbert", "dilbert");
insert into `phoenix`.`program-slot` (duration,dateOfProgram,startTime,`program-name`,presenter,producer) values(120, '2017-09-29','13:00:00',"short news", "pointyhead", "dilbert");
insert into `phoenix`.`program-slot` (duration,dateOfProgram,startTime,`program-name`,presenter,producer) values(30, '2017-09-29','14:00:00',"ppk", "dilbert", "dilbert");
insert into `phoenix`.`program-slot` (duration,dateOfProgram,startTime,`program-name`,presenter,producer) values(60, '2017-09-29','15:00:00',"opinions", "dilbert", "dilbert");
insert into `phoenix`.`program-slot` (duration,dateOfProgram,startTime,`program-name`,presenter,producer) values(90, '2017-09-29','16:00:00',"news", "dilbert", "dilbert");
insert into `phoenix`.`program-slot` (duration,dateOfProgram,startTime,`program-name`,presenter,producer) values(120, '2017-09-29','17:00:00',"charity", "catbert", "dilbert");
insert into `phoenix`.`program-slot` (duration,dateOfProgram,startTime,`program-name`,presenter,producer) values(30, '2017-09-30','10:00:00',"charity", "wally", "dilbert");