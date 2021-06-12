#include "NativeMethodTest1.h"

JNIEXPORT jlong JNICALL Java_NativeMethodTest1_gcd
  (JNIEnv*, jclass, jlong first, jlong second)
{
	while(first != second)
	{
		if(first > second)
			first -= second;
		else
			second -= first;
	}

	return first;
}

