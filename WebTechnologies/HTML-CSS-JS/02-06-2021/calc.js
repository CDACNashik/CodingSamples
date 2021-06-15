function myfunc(type){
	// console.log('Called');
	// console.log(document);
	// console.log(document.getElementById("rec1"));
	// console.log(document.getElementById("rec2"));

	ans1 = document.getElementById('rec1').value;
	console.log(ans1 , typeof ans1);

	ans2 = document.getElementById('rec2').value;
	console.log(ans2 , typeof ans2);

	console.log(type); // 1,2,3,4

	if(ans1=='' || ans2==''){
		result = 'Some records r missing';
		// console.log(result);
	}
	else{
		/*
		if(type==1){
			// result = ans1+ans2;
			// console.log(result);
			// result = parseInt(ans1)+parseInt(ans2);
			result = parseFloat(ans1)+parseFloat(ans2);
		}
		else if(type==2){
			result = parseFloat(ans1)-parseFloat(ans2);
		}
		else if(type==3){
			result = parseFloat(ans1)/parseFloat(ans2);
		}
		else if(type==4){
			result = parseFloat(ans1)*parseFloat(ans2);
		}
		*/
		switch(type){
			case 1:
			result = parseFloat(ans1)+parseFloat(ans2);break;

			case 2:
			result = parseFloat(ans1)-parseFloat(ans2);break;

			case 3:
			result = parseFloat(ans1)/parseFloat(ans2);break;

			default:
			result = parseFloat(ans1)*parseFloat(ans2);
		}
		console.log(result);
	}

	console.log(document.getElementById('message'))
	document.getElementById('message').innerHTML = result;
}