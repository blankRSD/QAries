PGDMP         .                y            qaries    13.3 (Debian 13.3-1.pgdg100+1)    13.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16384    qaries    DATABASE     Z   CREATE DATABASE qaries WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';
    DROP DATABASE qaries;
                postgres    false                        2615    16405    qaries    SCHEMA        CREATE SCHEMA qaries;
    DROP SCHEMA qaries;
                postgres    false            �            1259    16395    user    TABLE     �   CREATE TABLE public."user" (
    email character varying(100),
    userid bigint NOT NULL,
    username character varying(100),
    password character varying(100)
);
    DROP TABLE public."user";
       public         heap    postgres    false            �            1259    16400    userdetails    TABLE     �   CREATE TABLE public.userdetails (
    userid bigint NOT NULL,
    profile_pic character varying(100),
    linkedin character varying(100),
    instagram character varying(100)
);
    DROP TABLE public.userdetails;
       public         heap    postgres    false            |          0    16395    user 
   TABLE DATA           C   COPY public."user" (email, userid, username, password) FROM stdin;
    public          postgres    false    201   �
       }          0    16400    userdetails 
   TABLE DATA           O   COPY public.userdetails (userid, profile_pic, linkedin, instagram) FROM stdin;
    public          postgres    false    202   �
       �
           2606    16399    user user_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (userid);
 :   ALTER TABLE ONLY public."user" DROP CONSTRAINT user_pkey;
       public            postgres    false    201            �
           2606    16404    userdetails userdetails_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.userdetails
    ADD CONSTRAINT userdetails_pkey PRIMARY KEY (userid);
 F   ALTER TABLE ONLY public.userdetails DROP CONSTRAINT userdetails_pkey;
       public            postgres    false    202            |      x������ � �      }      x������ � �     