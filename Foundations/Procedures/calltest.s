	.set sysarch, _x64_
	.include "console.i"

	.text

Summation:			#procedure
	mov	rdx, rax
	add	rdx, 1
	mul	rdx
	shr	rax, 1

	ret			#transfer control to return address

	.entry main
main:
	GetInt	askl, lower	
	GetInt	asku, upper

	mov	rax, lower	
	cmp	rax, upper
	jg	done	
	sub	rax, 1
	call	Summation	#transfer control to instruction labelled as Summation
				#along with return address (of next instruction)
	mov	rbx, rax
	mov	rax, upper
	call	Summation	#reusing Summation code
	sub	rax, rbx

	PutInt	ans

done:	ret

askl:	.string	"Lower Limit: "
asku:	.string	"Upper Limit: "
ans:	.string "Sum of Integers = "

	.data

lower:	.quad	0
upper:	.quad	0

	.end



