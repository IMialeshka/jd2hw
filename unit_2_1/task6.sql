select r.name,
       sum(e.value) sumR
from `listexpenses`.`expenses` e,  `listexpenses`.`recivers` r
where e.receiver = r.num
group by e.receiver;

select   sum(e.value) sumR
from `listexpenses`.`expenses` e
where e.paydate = (select ed.paydate 
                   from `listexpenses`.`expenses` ed 
                   where ed.value = (select max(em.value) from `listexpenses`.`expenses` em) 
                   limit 1);
                   
                   
select   max(e.value) sumR
from `listexpenses`.`expenses` e
where e.paydate = (select m.paydate
                   from
                   (select em.paydate, sum(em.value) sumR from `listexpenses`.`expenses` em group by em.paydate order by sumR desc) m 
                   limit 1);
                                      
                   


