	.set sysarch, _x64_
	.include "console.i"

	.text
	#read-only memory section for program code and constants (fixed information)

	.entry	main
main:	
	PutMsg	greet

	ret
	#instruction to return control to system to exit this program


	.data
	#writable memory section for program variable

greet:	.string	"Hello World!\n"

	.end

