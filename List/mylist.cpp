#include "mylist.h"

MyList::MyList()
{
	maxSize=0;
	numOfElements=0;
	arr=NULL;
}

MyList::MyList(int maxS)
{
	maxSize=maxS;
	numOfElements=0;
	arr=new int [maxS];
}


MyList::~MyList()
{
	if(arr==NULL)delete arr;
	else delete []arr;
}


bool MyList::insert(int val)
{
	if(numOfElements==maxSize)return false;
	
	if(!numOfElements)
	{
		arr[0]=val;
		numOfElements++;
		return true;
	}
	
	int position=0;
	
	for(;position<numOfElements;position++)
	{
		if(arr[position]>val)break;
		
	}
	
	for(int i=numOfElements;i>=position;i--)
	{
		arr[i+1]=arr[i];
	}
	arr[position]=val;
	numOfElements++;
	return true;	
}


void MyList::print()
{
	for(int i=0;i<numOfElements;i++)cout<<arr[i]<<" ";
	cout<<endl;
}


void MyList::route(int r)
{
	if(!numOfElements)return ;
	
	int *arr2=new int [numOfElements];
	
	for(int i=0;i<numOfElements;i++)
		arr2[(i+r)%numOfElements]=arr[i];
		
	for(int i=0;i<numOfElements;i++)
		arr[i]=arr2[i];
	
	delete []arr2;
}


void MyList:: deleteAt(int ind)
{
	if(ind>numOfElements-1)return;
	if(ind==numOfElements-1)
	{
		numOfElements--;
		return;
	}
	
	numOfElements--;	
	for(int i=ind;i<numOfElements;i++)
		arr[i]=arr[i+1];
		
		
		return;
}




