	.intel_syntax noprefix
	
	.text

	.global	GCD
	.type	GCD, @function
GCD:	
1:	cmp	rdi, rsi
	je	3f
	jg	2f
	sub	rsi, rdi
	jmp	1b
2:	sub	rdi, rsi
	jmp	1b
3:	mov	rax, rsi
	ret

	.end


