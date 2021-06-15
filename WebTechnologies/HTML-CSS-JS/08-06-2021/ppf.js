/*
	// int_earned = 150000 * 7.1/100
	// int_earned = amount * int_rate/100;

	// opening_balance = 0;
	// closing_balance = amount+int_earned;
	
	// // after 2yr on
*/

//dom event handler
document.getElementById('btn').onclick= function(){
	// console.log('clicked');

	//we have received all values from form
	amount = document.getElementById('amt').value;
	// console.log(amount , typeof amount);

	int_rate = document.getElementById('int').value;
	// console.log(int_rate , typeof int_rate);

	years = document.getElementById('year').value;
	// console.log(years , typeof years);

	//we have converted values in number format before calculation

	amount = parseInt(amount)
	int_rate = parseFloat(int_rate)
	years = parseInt(years)

	console.log(amount,typeof amount)
	console.log(int_rate,typeof int_rate)
	console.log(years,typeof years)

	// opening_balance=closing_balance;
	// int_earned = ((opening_balance+amount) * int_rate/100);
	
	// closing_balance = opening_balance+amount+int_earned;

	//lets generate loop from year 1 to selected year
	opening_balance=0;
	strData = ``;
	for(i=1;i<=years;i++){
		// console.log(i);
		int_earned = Math.round((opening_balance+amount) * int_rate/100);
		closing_balance = opening_balance+amount+int_earned;

		// console.log(i ,opening_balance,amount,int_earned, closing_balance);
		strData = strData + `
			<tr>
				<td>${i}</td>
				<td>${opening_balance}</td>
				<td>${amount}</td>
				<td>${int_earned}</td>
				<td>${closing_balance}</td>
			</tr>
		`
		opening_balance=closing_balance;
	}
	console.log(strData)
	document.querySelector("#result").innerHTML = strData;
}









