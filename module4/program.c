#include <stdio.h>
#include <stdlib.h>

// This program only shows you checksum from your .bashrc file
int main()
{
    system("md5 ~/.bashrc");
}
