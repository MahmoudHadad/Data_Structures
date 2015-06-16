#include <iostream>
#include "mylist.h"
using namespace std;
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	
	
	MyList l(20);
	
	l.insert(5);
	l.insert(0);
	l.insert(3);
	l.insert(75);
	l.insert(-2);
	
	l.print();
	
//	l.route(3);
//	l.print();
	
	l.deleteAt(2);
	l.print();	
	
	l.deleteAt(0);
	l.print();
		
	l.deleteAt(2);
	l.print();	
	
	
	return 0;
}
