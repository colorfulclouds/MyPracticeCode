#include <stdio.h>
#include <string.h>

#define M 20

int main(void)
{
	char str[50];
	
	while(scanf("%s",str) != EOF)
	{
		int len=strlen(str);
		int i=0,n=0;
		
		char c;
		while(i<len)
		{
			if(str[i]>='a' && str[i]<='z')
			{
				while(n>1)
				{
					printf("%c",c);
					n--;
				}
				n=0;
				c=str[i];
				printf("%c",c);
			}
			if(str[i]>='0'&&str[i]<='9')
			{
				n=n*10+str[i]-'0';
			}
			i++;
		}
		while(n>1)
		{
			printf("%c",c);
			n--;
		}
		printf("\n");
	}
	return 0;
}