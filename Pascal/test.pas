program test;
var
	x : Integer;
	y : Integer;

begin
	x := 3;
	while x > 0 do
	begin
		x := x - 1;
		writeln(x);
	end;
	y := 3 * (2 + 1);

	if x < 2 * 2 or x = 1 then
	begin
		writeln(1);
	end
	else
	begin
		write(2 * 1);
	end;
end.