select e.`num`, e.`paydate`, r.`name`, e.`value`
from `listexpenses`.`expenses` e, `listexpenses`.`recivers` r
where e.`receiver` = r.`num`
  and e.`value` > 10000;