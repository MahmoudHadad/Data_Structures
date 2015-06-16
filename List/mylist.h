#ifndef MYLIST_H
#define MYLIST_H
#include <iostream>

using namespace std;

class MyList
{
	int maxSize;
	int numOfElements;
	int *arr;
	public:
		MyList();
		MyList(int maxS);
		bool insert(int val);
		void print();
		void route(int r);
		void deleteAt(int ind);
		
		~MyList();
	
};

#endif
