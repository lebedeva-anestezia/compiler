program test;
var
	x : Integer;
	y : Integer;
	z : Integer;

begin
	x := 2;
	y := x * 2 - read();
	writeln(y);
	z := 5 * 2 - 10 div 3 + 1;
	writeln(z);
	while x > 0 do
	begin
		x := x - 1;
		writeln(x);
	end;
	y := 3*(2 + 1);

	if x < 2 * 2 or x = 1 then
	begin
		if not (1 <> 1) and x = x then
		begin
			writeln(1);
		end;
		writeln(2);
	end
	else
	begin
		write(1 + 1 * 2);
	end;
end.