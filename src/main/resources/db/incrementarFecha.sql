CREATE OR REPLACE FUNCTION incr_fecha(date) RETURNS date AS 
$$
DECLARE
pfecha ALIAS FOR $1;
BEGIN
RETURN pfecha + integer '1';
END;
$$
LANGUAGE plpgsql;

