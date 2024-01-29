select * from POKEMEMBER;

select * from SCORE;

select hint from POKEMON where num = 0;

select * from score where id = test and rownum <= 5 order by indate desc;

select * from score where id = 'test' order by indate desc;
select * from SCORE;

select * from score where rownum <= 5 and id like 'bome' order by indate desc;


select * from score where id like 'mt' order by indate desc;


<<<<<<< HEAD
select * from score where rownum <= 5 and id like 'mt' order by indate;
=======
select * from score where rownum <= 5 and id like 'bome' order by indate;

select * from (select * from score where id = 'test' order by indate desc) where rownum<=10;
>>>>>>> branch 'master' of https://github.com/2021-SMHRD-KDT-AI-17/pokemonname.git
