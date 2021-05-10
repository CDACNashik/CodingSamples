	.set sysarch, _x64_
	.include "console.i"

	.text
	
	.entry main
main:
	GetInt	askl, lower	
	GetInt	asku, upper

	mov	rax, lower	
	cmp	rax, upper
	jg	done		#if rax > upper then jump to done
	sub	rax, 1
	mov	rdx, rax
	add	rdx, 1
	mul	rdx
	shr	rax, 1
	mov	rbx, rax
	mov	rax, upper
	mov	rdx, rax
	add	rdx, 1
	mul	rdx
	shr	rax, 1
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



