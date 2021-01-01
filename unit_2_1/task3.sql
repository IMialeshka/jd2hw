delete from `listexpenses`.`expenses` where `listexpenses`.`expenses`.`value` < 3000
and `expenses`.`num` > 0;