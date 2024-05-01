PGDMP                       |            groceryshop    16.2    16.2                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16395    groceryshop    DATABASE     m   CREATE DATABASE groceryshop WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
    DROP DATABASE groceryshop;
                postgres    false            �            1259    16426    order_total    TABLE        CREATE TABLE public.order_total (
    id integer NOT NULL,
    tex character varying(255),
    total_price double precision
);
    DROP TABLE public.order_total;
       public         heap    postgres    false            �            1259    16425    order_total_id_seq    SEQUENCE     �   CREATE SEQUENCE public.order_total_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.order_total_id_seq;
       public          postgres    false    218                       0    0    order_total_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.order_total_id_seq OWNED BY public.order_total.id;
          public          postgres    false    217            �            1259    16417    product    TABLE     �   CREATE TABLE public.product (
    id integer NOT NULL,
    image character varying(255),
    name character varying(255),
    price double precision,
    quantity integer,
    stock integer
);
    DROP TABLE public.product;
       public         heap    postgres    false            �            1259    16416    product_id_seq    SEQUENCE     �   CREATE SEQUENCE public.product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.product_id_seq;
       public          postgres    false    216                       0    0    product_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.product_id_seq OWNED BY public.product.id;
          public          postgres    false    215            y           2604    16429    order_total id    DEFAULT     p   ALTER TABLE ONLY public.order_total ALTER COLUMN id SET DEFAULT nextval('public.order_total_id_seq'::regclass);
 =   ALTER TABLE public.order_total ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    217    218    218            x           2604    16420 
   product id    DEFAULT     h   ALTER TABLE ONLY public.product ALTER COLUMN id SET DEFAULT nextval('public.product_id_seq'::regclass);
 9   ALTER TABLE public.product ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215    216                      0    16426    order_total 
   TABLE DATA           ;   COPY public.order_total (id, tex, total_price) FROM stdin;
    public          postgres    false    218   9                 0    16417    product 
   TABLE DATA           J   COPY public.product (id, image, name, price, quantity, stock) FROM stdin;
    public          postgres    false    216   �                  0    0    order_total_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.order_total_id_seq', 3, true);
          public          postgres    false    217                       0    0    product_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.product_id_seq', 6, true);
          public          postgres    false    215            }           2606    16431    order_total order_total_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.order_total
    ADD CONSTRAINT order_total_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.order_total DROP CONSTRAINT order_total_pkey;
       public            postgres    false    218            {           2606    16424    product product_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.product DROP CONSTRAINT product_pkey;
       public            postgres    false    216               ;   x�ȹ !��.��Y���_܆V�#��v�imŋD��eM��=5�������^         �   x�}�=�0�����J��6wAbDb�!Q#�Q�R���������6�HQ�$ϟ�K)t�m��&(�(V�@�#�ǖ
Q:�E���b��Lo�I�Ax"tO3�B�pFxc< ��3?$��Z)iG��J�c�p�ŗ�#[�@��8�
:�;FQ.��Z�����u�w���5���(C��"}Ą�R�/���u     