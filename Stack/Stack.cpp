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


class Stack
{
	Node* head;
	
	public:
		Stack(){
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
			temp->next=head;
			head=temp;
		}
		/////////////////////////
		void pop()
		{
			Node * temp=head;
			head=head->next;
			delete temp;
		}
		
	
};


void add2Stacks (Stack s1 , Stack s2)
{
	Stack temp;
	
	while(!s2.isEmpty())
	{
		temp.push(s2.top());
		s2.pop();
	}
	
	while(!temp.isEmpty())
	{
		s1.push(temp.top());
		temp.pop();
	}
	
		
	while(!s1.isEmpty())
	{
		cout<<s1.top()<<endl;
		s1.pop();
	}

	
}

void copy2Stacks (Stack s1 , Stack s2)
{
	Stack temp;
	
	while(!s1.isEmpty())
	s1.pop();
	

	
	while(!s2.isEmpty())
	{
		temp.push(s2.top());
		s2.pop();
	}
	
	while(!temp.isEmpty())
	{
		s1.push(temp.top());
		temp.pop();
	}
	
		
	while(!s1.isEmpty())
	{
		cout<<s1.top()<<endl;
		s1.pop();
	}

	
}



int main(){


Stack s1,s2;

for(int i=0;i<5;i++)
s1.push(i+1);

for(int i=5;i<10;i++)
s2.push(i+1);

//add2Stacks(s1,s2);
copy2Stacks(s1,s2);
return 0;
}
