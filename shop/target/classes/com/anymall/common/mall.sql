CREATE TABLE PRODUCT (
  id number(6) PRIMARY KEY,
  name varchar2(20),
  price varchar2(10),
  manufacturer varchar2(20),
  code_id NUMBER(6),
  use NUMBER(1),
  createdate date
);

CREATE TABLE CATEGORY (
  category_id number(6) PRIMARY KEY,
  category_name varchar2(20),
  use NUMBER(1),
  above NUMBER(6),
  createdate date
);

CREATE TABLE MEMBER (
  id varchar2(20) PRIMARY KEY,
  pw varchar2(20),
  name varchar2(10),
  birth date,
  gender NUMBER(1),
  address varchar2(50),
  sign_date date,
  grade varchar2(10)
);

CREATE TABLE CART (
  product_id NUMBER(6),
  member_id varchar2(20),
  amount NUMBER(6),
  checked NUMBER(1),
  createdate DATE
--  PRIMARY KEY ("product_id", "member_id")
);

CREATE TABLE ORDERS (
  order_num varchar2(20) PRIMARY KEY,
  member_id varchar2(20),
  product_id NUMBER(6),
  total varchar2(50),
  orderdate date,
  state varchar2(20),
  payment varchar2(20)
);

CREATE TABLE ORDERITEM (
  ITEM_ID VARCHAR2(100) PRIMARY KEY,
  product_id NUMBER(6),
  amount NUMBER(10),
  price varchar2(10),
  order_num varchar2(20),
  state varchar2(20),
  createdate date
);

CREATE SEQUENCE SEQ_ORDERITEM;
INSERT INTO orderItem (PRODUCT_ID, AMOUNT, PRICE, ORDER_NUM, STATE, CREATEDATE, ITEM_ID) VALUES (NULL, NULL, NULL, 'test', NULL, NULL, SEQ_ORDERITEM.NEXTVAL);
SELECT * FROM ORDERITEM ;
COMMIT;

ALTER TABLE ORDERITEM ADD UNIQUE(ORDER_NUM);

ALTER TABLE PRODUCT ADD FOREIGN KEY (category_id) REFERENCES category (category_id);

ALTER TABLE "cart" ADD FOREIGN KEY ("product_id") REFERENCES "product" ("id");

ALTER TABLE "cart" ADD FOREIGN KEY ("member_id") REFERENCES "member" ("id");

ALTER TABLE "order" ADD FOREIGN KEY ("member_id") REFERENCES "member" ("id");

ALTER TABLE "order" ADD FOREIGN KEY ("product_id") REFERENCES "product" ("id");

ALTER TABLE "orderItem" ADD FOREIGN KEY ("product_id") REFERENCES "product" ("id");

ALTER TABLE "order" ADD FOREIGN KEY ("order_num") REFERENCES "orderItem" ("order_num");


ALTER TABLE PRODUCT ADD FOREIGN KEY (category_id) REFERENCES CATEGORY (category_id);

ALTER TABLE CART ADD FOREIGN KEY (product_id) REFERENCES PRODUCT (id);

ALTER TABLE CART ADD FOREIGN KEY (member_id) REFERENCES MEMBER (id);

ALTER TABLE ORDERS ADD FOREIGN KEY (member_id) REFERENCES MEMBER (id);

ALTER TABLE ORDERS ADD FOREIGN KEY (product_id) REFERENCES PRODUCT (id);

ALTER TABLE ORDERITEM ADD FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE ORDERS ADD FOREIGN KEY (order_num) REFERENCES ORDERITEM (order_num);