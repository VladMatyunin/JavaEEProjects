DROP DATABASE medline;
CREATE DATABASE medline
WITH
OWNER = postgres
ENCODING = 'UTF8'
LC_COLLATE = 'Russian_Russia.1251'
LC_CTYPE = 'Russian_Russia.1251'
TABLESPACE = pg_default
CONNECTION LIMIT = -1;

-- Table: public.part

-- DROP TABLE public.part;

CREATE TABLE public.part
(
  name character varying(50) COLLATE pg_catalog."default",
  "number" character varying(50) COLLATE pg_catalog."default",
  vendor character varying(50) COLLATE pg_catalog."default",
  qty integer,
  shipped date,
  received date
)
WITH (
OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.part
  OWNER to postgres;

INSERT INTO public.part(
  name, "number", vendor, qty, shipped, received)
VALUES
  ('test1', '1-2ss-2-3', 'testvendor1', 23, '23.10.2017', '27.10.2017'),
  ('test2', '1-412122S', 'testvendor2', 26, '12.11.2015', '27.11.2015'),
  ('test3', 'sSEBBs-2-3', 'testvendor3', 42, '05.06.2014', '07.06.2014'),
  ('test4', 'DFDQww4', 'testvendor4', 41, '02.02.2014', '10.02.2014'),
  ('test5', '145533-33', 'testvendor5', 55, '23.11.2016', '27.11.2016'),
  ('test6', 'sdaq2231', 'testvendor6', 11, '27.07.2015', '30.07.2015'),
  ('test7', 'dfDWWW222', 'testvendor7', 14, '10.10.2014', '16.10.2014'),
  ('test8', 'sdfgdh334', 'testvendor8', 66, '20.03.2017', '25.03.2017'),
  ('test9', 'ss_ssdqw_', 'testvendor9', 78, '22.02.2014', '27.02.2014'),
  ('test10', 'wghr6efsg5', 'testvendor10', 12, '23.10.2017', '27.10.2017'),
  ('test11', 'sdt34efdfd', 'testvendor11', 1, '02.04.2017', '10.04.2017'),
  ('test12', 'eaewt2', 'testvendor12', 89, '10.01.2014', '16.01.2014');