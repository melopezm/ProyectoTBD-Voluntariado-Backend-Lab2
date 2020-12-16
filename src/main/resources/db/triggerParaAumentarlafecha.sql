create or replace function sumarUnDia() returns trigger as
$$
begin
update voluntario set fnacimiento = (select incr_fecha(New.fnacimiento)) where id = New.id; 
return new;
end;
$$
language plpgsql;

create trigger trigger_sumar_un_dia
after insert on voluntario
for each row
execute procedure sumarUnDia();

