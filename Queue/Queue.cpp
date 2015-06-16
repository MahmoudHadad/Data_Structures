# include<iostream>
# include<vector>
# include<set>
# include<algorithm>
# include<windows.h>
# include<math.h>
# include<sstream>
# include<fstream>
# include<map>
# include<string.h>
#include <stdlib.h> 
#include <ctime>
#include <iomanip> 
#include <cmath> 

using namespace std;

struct Node
{
	Node (int v)
	{
		val=v;
		next=NULL;
	}
	Node ()
	{
		next=NULL;
	}
	
	int val;
	Node * next;
};


class Queue
{
	Node* head;
	
	public:
		Queue(){
			head=NULL;
		}
		////////////////////
		bool isEmpty()
		{
			if(head==NULL)
			return 1;
			return 0;
		} 
		///////////////////////
		int top()
		{
			if(head==NULL)
			return -1;
			return head->val;
		}
		/////////////////////////
		void push(int v)
		{
			Node * temp=new Node (v);
			if(head==NULL)
			{
				head=temp;
				return;
			}
			Node * it=head;
			while(it->next!=NULL)
			it=it->next;
			
			it->next=temp;
		}
		/////////////////////////
		void pop()
		{
			Node * temp=head;
			head=head->next;
			delete temp;
		}
	
};



int main(){


Queue q;

cout<<"Is Empty  "<<q.isEmpty()<<endl;

q.push(5);
q.push(10);
q.push(15);
q.push(20);
q.push(25);
q.push(30);

cout<<"Is Empty  "<<q.isEmpty()<<endl;

while(!q.isEmpty())
{
	cout<<q.top()<<endl;
	q.pop();
}



return 0;
}
