// script1.js
console.log( document.querySelector('#btn'));

btnTag = document.querySelector("#btn");

//dom event handler
btnTag.onclick = function(){
	console.log('test')
	//name="txtData"
	console.log(document.getElementsByName('txtData'))
	txtValue = document.getElementsByName('txtData')[0].value;
	console.log(txtValue); // 20/2/2020
	answer = txtValue.split("/"); //[20, 2, 2020]
	console.log(answer);
	yearByUser = answer[2];
	console.log(yearByUser);

	//date class
	dateObj = new Date();
	console.log(dateObj);
	curyear = dateObj.getFullYear();
	console.log(curyear); //2021

	age = curyear - yearByUser;
	console.log(age);

	console.log(document.getElementsByTagName('h1'))

	document.getElementsByTagName('h1')[0].innerHTML = age;
}