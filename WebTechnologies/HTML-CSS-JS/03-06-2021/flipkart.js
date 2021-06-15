function myfunc(imgTag){
	// console.log(imgTag);
	path= imgTag.getAttribute('src')
	// console.log(path);

	//128/128 => 880/1056
	//q=70 => q=50

	newpath = path.replace('128/128','880/1056');
	// console.log(newpath);

	finalpath = newpath.replace("q=70",'q=50');
	// console.log(finalpath);

	document.getElementById('mainimg').setAttribute('src',finalpath);

}
