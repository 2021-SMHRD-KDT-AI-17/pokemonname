select * from POKEMEMBER;

select * from pokemon;


select * from SCORE;

select * from score where rownum <= 5 and id like 'bome' order by indate desc;


select * from score where id like 'mt' order by indate desc;


select * from score where rownum <= 5 and id like 'mt' order by indate;
