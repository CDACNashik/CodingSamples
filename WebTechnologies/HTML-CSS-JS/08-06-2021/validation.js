function chk_username(el){
	// console.log(Math.random())
	// console.log(el)
	console.log(el.value)
	//om , om patil
	reg_uname = /^[a-zA-Z]([a-zA-Z ]{1,})?[a-zA-Z]$/;

	result_uname = reg_uname.test(el.value);
	console.log(result_uname); //false or true

	if(result_uname){
		el.nextElementSibling.style.display = 'none';
		el.className = "form-control";
		return true;
	}
	else{
		//false
		// DOM Traveser or DOM navigation property
		el.nextElementSibling.style.display = 'block';
		el.className = "form-control errClass";
		return false;
	}
}

function chk_usermobile(el){
	// console.log(el)
	// console.log(el.value)
	reg_mobile = /^[1-9][0-9]{9}$/
	result_mobile = reg_mobile.test(el.value)
	console.log(result_mobile);
	if(result_mobile){
		el.nextElementSibling.style.display = 'none';
		return true;
	}
	else{
		el.nextElementSibling.style.display = 'block';
		return false;
	}
}

document.getElementById("btn").onclick = function(){
	// console.log('test')
	txt1 = document.getElementById('uname');
	txt2 = document.getElementById('umobile');
	// console.log(txt1);
	// console.log(txt2);

	ans1 = chk_username(txt1)
	// console.log(ans1);
	ans2 = chk_usermobile(txt2);
	// console.log(ans2);

	if(ans1 && ans2){
		console.log('validation done');
	}
}



