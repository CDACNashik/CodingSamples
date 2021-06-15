/*
	// int_earned = 150000 * 7.1/100
	// int_earned = amount * int_rate/100;

	// opening_balance = 0;
	// closing_balance = amount+int_earned;
	
	// // after 2yr on
	// opening_balance=closing_balance;
	// int_earned = ((opening_balance+amount) * int_rate/100);
	// closing_balance = opening_balance+amount+int_earned;
*/
//dom event handler
document.getElementById('btn').onclick= function(){
	// console.log('yes')
	amount = document.getElementById('amt').value;
	int_rate = document.getElementById('int').value;
	years = document.getElementById('year').value;

	console.log(amount,int_rate,years);
	console.log(typeof amount,int_rate,years);

	amount = parseInt(amount);
	int_rate = parseFloat(int_rate);
	years = parseInt(years);

}