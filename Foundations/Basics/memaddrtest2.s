	.set sysarch, _x64_
	.include "console.i"

	.text
	
	.entry main
main:
	GetInt	ask, month

	#mov	rcx, month		#direct addressing
	mov	rbx, offset month	#rbx = address linked to month
	mov	rcx, [rbx]		#indirect addressing

	sub	rcx, 1			#getting index of month
	mov	rbx, offset year
	mov	rax, [rbx+8*rcx]

	PutInt	ans

	ret


ask:	.string	"Month[1-12]: "
ans:	.string "Number of days: "
year:	.quad	31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31

	.data

month:	.quad	0

	.end



