--
-- PostgreSQL database dump
--

-- Dumped from database version 10.14 (Ubuntu 10.14-0ubuntu0.18.04.1)
-- Dumped by pg_dump version 10.14 (Ubuntu 10.14-0ubuntu0.18.04.1)

-- Started on 2020-10-12 13:46:58 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2956 (class 1262 OID 82167)
-- Name: cars; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE cars WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'pl_PL.UTF-8' LC_CTYPE = 'pl_PL.UTF-8';


ALTER DATABASE cars OWNER TO postgres;

\connect cars

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 13041)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2958 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 198 (class 1259 OID 82179)
-- Name: car_dealers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.car_dealers (
    name character varying(25),
    location character varying(20),
    phone_number character varying(10),
    id integer NOT NULL
);


ALTER TABLE public.car_dealers OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 90359)
-- Name: car_dealers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.car_dealers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.car_dealers_id_seq OWNER TO postgres;

--
-- TOC entry 2959 (class 0 OID 0)
-- Dependencies: 204
-- Name: car_dealers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.car_dealers_id_seq OWNED BY public.car_dealers.id;


--
-- TOC entry 197 (class 1259 OID 82170)
-- Name: cars; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cars (
    year integer,
    id bigint NOT NULL,
    automat_gear boolean,
    dealer_id integer NOT NULL,
    model character varying,
    color character varying,
    brand character varying
);


ALTER TABLE public.cars OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 82184)
-- Name: cars_dealer_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cars_dealer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cars_dealer_id_seq OWNER TO postgres;

--
-- TOC entry 2960 (class 0 OID 0)
-- Dependencies: 199
-- Name: cars_dealer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cars_dealer_id_seq OWNED BY public.cars.dealer_id;


--
-- TOC entry 196 (class 1259 OID 82168)
-- Name: cars_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cars_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cars_id_seq OWNER TO postgres;

--
-- TOC entry 2961 (class 0 OID 0)
-- Dependencies: 196
-- Name: cars_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cars_id_seq OWNED BY public.cars.id;


--
-- TOC entry 203 (class 1259 OID 82214)
-- Name: user_cars; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_cars (
    car_id integer NOT NULL,
    user_id integer NOT NULL
);


ALTER TABLE public.user_cars OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 82212)
-- Name: user_cars_car_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_cars_car_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_cars_car_id_seq OWNER TO postgres;

--
-- TOC entry 2962 (class 0 OID 0)
-- Dependencies: 202
-- Name: user_cars_car_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_cars_car_id_seq OWNED BY public.user_cars.car_id;


--
-- TOC entry 201 (class 1259 OID 82203)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    name character varying(20),
    surname character varying(20)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 82199)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- TOC entry 2963 (class 0 OID 0)
-- Dependencies: 200
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- TOC entry 2809 (class 2604 OID 90361)
-- Name: car_dealers id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car_dealers ALTER COLUMN id SET DEFAULT nextval('public.car_dealers_id_seq'::regclass);


--
-- TOC entry 2807 (class 2604 OID 82173)
-- Name: cars id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cars ALTER COLUMN id SET DEFAULT nextval('public.cars_id_seq'::regclass);


--
-- TOC entry 2808 (class 2604 OID 82240)
-- Name: cars dealer_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cars ALTER COLUMN dealer_id SET DEFAULT nextval('public.cars_dealer_id_seq'::regclass);


--
-- TOC entry 2811 (class 2604 OID 82231)
-- Name: user_cars car_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_cars ALTER COLUMN car_id SET DEFAULT nextval('public.user_cars_car_id_seq'::regclass);


--
-- TOC entry 2810 (class 2604 OID 82206)
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- TOC entry 2944 (class 0 OID 82179)
-- Dependencies: 198
-- Data for Name: car_dealers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.car_dealers (name, location, phone_number, id) VALUES ('DreamCars', 'Katowice', '999222123', 2);
INSERT INTO public.car_dealers (name, location, phone_number, id) VALUES ('YourCar', 'Kraków', '932222666', 3);
INSERT INTO public.car_dealers (name, location, phone_number, id) VALUES ('Super Car Dealer', 'Kraków', '111222666', 4);
INSERT INTO public.car_dealers (name, location, phone_number, id) VALUES ('Cars of heaven', 'Warszawa', '555222666', 5);
INSERT INTO public.car_dealers (name, location, phone_number, id) VALUES ('Super Duper Cars', 'Warszawa', '555888666', 6);


--
-- TOC entry 2943 (class 0 OID 82170)
-- Dependencies: 197
-- Data for Name: cars; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.cars (year, id, automat_gear, dealer_id, model, color, brand) VALUES (2020, 1, true, 3, '720S', 'yellow', 'McLaren');
INSERT INTO public.cars (year, id, automat_gear, dealer_id, model, color, brand) VALUES (2020, 2, true, 2, '488 GTB', 'red', 'Ferrari');
INSERT INTO public.cars (year, id, automat_gear, dealer_id, model, color, brand) VALUES (2020, 3, true, 4, 'Huracan Performante', 'yellow', 'Lamborghini');
INSERT INTO public.cars (year, id, automat_gear, dealer_id, model, color, brand) VALUES (2020, 4, true, 4, '911 GT2 RS', 'silver', 'Porche');
INSERT INTO public.cars (year, id, automat_gear, dealer_id, model, color, brand) VALUES (2020, 5, false, 4, 'R8 V10 Plus', 'black', 'Audi');
INSERT INTO public.cars (year, id, automat_gear, dealer_id, model, color, brand) VALUES (2020, 6, false, 4, 'GT', 'blue', 'FORD');
INSERT INTO public.cars (year, id, automat_gear, dealer_id, model, color, brand) VALUES (2020, 7, false, 2, 'DBS Superleggera', 'silver', 'Aston Martin');
INSERT INTO public.cars (year, id, automat_gear, dealer_id, model, color, brand) VALUES (2019, 8, true, 5, 'Speedtail', 'orange', 'McLaren');
INSERT INTO public.cars (year, id, automat_gear, dealer_id, model, color, brand) VALUES (2019, 9, true, 5, '718 Cayman GT4', 'grey', 'Porche');
INSERT INTO public.cars (year, id, automat_gear, dealer_id, model, color, brand) VALUES (2019, 10, true, 2, 'Jesko', 'grey', 'Koenigsegg');


--
-- TOC entry 2949 (class 0 OID 82214)
-- Dependencies: 203
-- Data for Name: user_cars; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_cars (car_id, user_id) VALUES (2, 3);
INSERT INTO public.user_cars (car_id, user_id) VALUES (3, 2);
INSERT INTO public.user_cars (car_id, user_id) VALUES (4, 1);
INSERT INTO public.user_cars (car_id, user_id) VALUES (5, 2);
INSERT INTO public.user_cars (car_id, user_id) VALUES (6, 1);
INSERT INTO public.user_cars (car_id, user_id) VALUES (7, 3);
INSERT INTO public.user_cars (car_id, user_id) VALUES (8, 2);
INSERT INTO public.user_cars (car_id, user_id) VALUES (9, 1);
INSERT INTO public.user_cars (car_id, user_id) VALUES (10, 3);


--
-- TOC entry 2947 (class 0 OID 82203)
-- Dependencies: 201
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.users (id, name, surname) VALUES (1, 'Mikolaj', 'Urbanek');
INSERT INTO public.users (id, name, surname) VALUES (2, 'Marta', 'S');
INSERT INTO public.users (id, name, surname) VALUES (3, 'Tomek', 'K');


--
-- TOC entry 2964 (class 0 OID 0)
-- Dependencies: 204
-- Name: car_dealers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.car_dealers_id_seq', 6, true);


--
-- TOC entry 2965 (class 0 OID 0)
-- Dependencies: 199
-- Name: cars_dealer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cars_dealer_id_seq', 1, false);


--
-- TOC entry 2966 (class 0 OID 0)
-- Dependencies: 196
-- Name: cars_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cars_id_seq', 10, true);


--
-- TOC entry 2967 (class 0 OID 0)
-- Dependencies: 202
-- Name: user_cars_car_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_cars_car_id_seq', 1, false);


--
-- TOC entry 2968 (class 0 OID 0)
-- Dependencies: 200
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 3, true);


--
-- TOC entry 2815 (class 2606 OID 90363)
-- Name: car_dealers car_dealers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.car_dealers
    ADD CONSTRAINT car_dealers_pkey PRIMARY KEY (id);


--
-- TOC entry 2813 (class 2606 OID 82178)
-- Name: cars cars_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT cars_pkey PRIMARY KEY (id);


--
-- TOC entry 2817 (class 2606 OID 82209)
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2820 (class 2606 OID 82232)
-- Name: user_cars car_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_cars
    ADD CONSTRAINT car_id FOREIGN KEY (car_id) REFERENCES public.cars(id);


--
-- TOC entry 2818 (class 2606 OID 90368)
-- Name: cars dealer_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cars
    ADD CONSTRAINT dealer_id FOREIGN KEY (dealer_id) REFERENCES public.car_dealers(id) NOT VALID;


--
-- TOC entry 2819 (class 2606 OID 82226)
-- Name: user_cars user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_cars
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES public.users(id) NOT VALID;


-- Completed on 2020-10-12 13:46:58 CEST

--
-- PostgreSQL database dump complete
--

