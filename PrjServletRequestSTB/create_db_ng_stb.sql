CREATE TABLE ng_stb_boot.category 
( 
  ID INT(10) NOT NULL 
, TYPE VARCHAR(20) NULL 
, CONSTRAINT PRIMARY KEY ( ID ) );

CREATE TABLE ng_stb_boot.history_even 
( 
  ID INT(10) NOT NULL 
, STB INT(10) NOT NULL 
, VERSION_FW INT(10) NOT NULL 
, DATE_UPDATE DATETIME NULL 
, CONSTRAINT PRIMARY KEY ( ID ) );

CREATE TABLE ng_stb_boot.history_odd 
( 
  ID INT(10) NOT NULL 
, STB INT(10) NOT NULL 
, VERSION_FW INT(10) NOT NULL 
, DATE_UPDATE DATETIME NULL 
, CONSTRAINT PRIMARY KEY ( ID ) );

CREATE TABLE ng_stb_boot.image_stb 
( 
  ID INT(10) NOT NULL 
, NAME VARCHAR(10) NULL 
, CONSTRAINT PRIMARY KEY ( ID ) );

CREATE TABLE ng_stb_boot.model 
( 
  ID INT(10) NOT NULL 
, NAME VARCHAR(30) NULL DEFAULT ' ' 
, FABRICATE VARCHAR(255) NULL DEFAULT ' ' 
, CONSTRAINT PRIMARY KEY ( ID ) );

CREATE TABLE ng_stb_boot.register_fw 
( 
  ID INT(10) NOT NULL 
, MODEL INT(10) NULL 
, VERSION VARCHAR(255) NULL 
, CODE_PATCH VARCHAR(255) NULL 
, MANUAL_PATH VARCHAR(255) NULL 
, CATEGORY INT(10) NULL 
, DATE_FW DATETIME NULL 
, IMG_TYPE INT(10) NULL 
, CONSTRAINT PRIMARY KEY ( ID ) );

CREATE TABLE ng_stb_boot.stb 
( 
  ID INT(10) NOT NULL 
, MAC VARCHAR(17) NULL 
, CATEGORY INT(10) NULL 
, VERSION_FW INT(10) NULL 
, IMAGE INT(10) NULL 
, CONSTRAINT PRIMARY KEY ( ID ) );

ALTER TABLE ng_stb_boot.history_even ADD CONSTRAINT FW_FK1 FOREIGN KEY ( VERSION_FW )
 REFERENCES ng_stb_boot.register_fw ( ID )
 ON DELETE NO ACTION;

ALTER TABLE ng_stb_boot.history_even ADD CONSTRAINT STB_FK1 FOREIGN KEY ( STB )
 REFERENCES ng_stb_boot.stb ( ID )
 ON DELETE NO ACTION;

ALTER TABLE ng_stb_boot.history_odd ADD CONSTRAINT FW_ODD_FK1 FOREIGN KEY ( VERSION_FW )
 REFERENCES ng_stb_boot.register_fw ( ID )
 ON DELETE NO ACTION;

ALTER TABLE ng_stb_boot.history_odd ADD CONSTRAINT STB_ODD_FK1 FOREIGN KEY ( STB )
 REFERENCES ng_stb_boot.stb ( ID )
 ON DELETE NO ACTION;

ALTER TABLE ng_stb_boot.register_fw ADD CONSTRAINT IMAGE_FW_FK1 FOREIGN KEY ( IMG_TYPE )
 REFERENCES ng_stb_boot.image_stb ( ID )
 ON DELETE NO ACTION;

ALTER TABLE ng_stb_boot.register_fw ADD CONSTRAINT INFO_FW_FK1 FOREIGN KEY ( CATEGORY )
 REFERENCES ng_stb_boot.category ( ID )
 ON DELETE NO ACTION;

ALTER TABLE ng_stb_boot.register_fw ADD CONSTRAINT MODEL_fw_FK1 FOREIGN KEY ( MODEL )
 REFERENCES ng_stb_boot.model ( ID )
 ON DELETE NO ACTION;

ALTER TABLE ng_stb_boot.stb ADD CONSTRAINT CATEGORY_FK1 FOREIGN KEY ( CATEGORY )
 REFERENCES ng_stb_boot.category ( ID )
 ON DELETE NO ACTION;

ALTER TABLE ng_stb_boot.stb ADD CONSTRAINT VERSION_FK1 FOREIGN KEY ( VERSION_FW )
 REFERENCES ng_stb_boot.register_fw ( ID )
 ON DELETE NO ACTION;

CREATE INDEX ng_stb_boot.STB_INDEX1 ON ng_stb_boot.stb ( ID ASC);

CREATE VIEW ng_stb_boot.current_stb_version_fw AS select `ng_stb_boot`.`stb`.`ID` AS `ID`,`ng_stb_boot`.`stb`.`MAC` AS `MAC`,`ng_stb_boot`.`category`.`ID` AS `CATEGORY`,`ng_stb_boot`.`register_fw`.`VERSION` AS `VERSION`,`ng_stb_boot`.`image_stb`.`ID` AS `IMAGE` from (((`ng_stb_boot`.`stb` join `ng_stb_boot`.`category`) join `ng_stb_boot`.`register_fw`) join `ng_stb_boot`.`image_stb`) where ((`ng_stb_boot`.`stb`.`VERSION_FW` = `ng_stb_boot`.`register_fw`.`ID`) and (`ng_stb_boot`.`stb`.`IMAGE` = `ng_stb_boot`.`register_fw`.`IMG_TYPE`) and (`ng_stb_boot`.`stb`.`CATEGORY` = `ng_stb_boot`.`category`.`ID`) and (`ng_stb_boot`.`stb`.`IMAGE` = `ng_stb_boot`.`image_stb`.`ID`)) order by `ng_stb_boot`.`stb`.`MAC`,`ng_stb_boot`.`image_stb`.`ID`;
