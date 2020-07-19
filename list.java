

interface list
{
	public abstract void add(int d);
	public abstract void remove(int i);
	public abstract void print();
	public abstract int size();
	public abstract void clear();
}

class Node
{
	private int data;
	private Node next;
	public Node(int data)
	{
		this.data = data;
	}
	public void setData(int data)
	{
		this.data = data;
	}
	public int getData()
	{
		return data;
	}
	public void setNext(Node next)
	{
		this.next = next;
	}
	public Node getNext()
	{
		return next;
	}
}

class LinkedList extends list
{
	private Node head;
	private int s=0;
	public LinkedList(){}
	public LinkedList(int data)
	{
		head = new Node(data);
		s++;
	}
	public void add(int data)
	{
		Node temp = head;
		Node newnode = new Node(data);
		while(temp.getNext() != null)
		{
			temp = temp.getNext();
		}
		temp.setNext(newnode);
		s++;
	}
	public void remove(int data)
	{
		if(head == null)
			return; 
		if(head.getData() == data)
			{
				head = head.getNext();
				s--;
				return;
			}
		Node temp = head;
		Node p=head;
		while(temp.getData() != data && temp.getNext() != null)
		{
			p = temp;
			temp = temp.getNext();
		}
		p.setNext(temp.getNext());
		s--;
	}
	public void print()
	{
		if(head == null)
			{
				System.out.println("Empty list");
				return;
			}
		Node temp = head;
		Node q;
		while(temp != null)
		{
			System.out.print(temp.getData()+" ");
			temp = temp.getNext();
		}
	}
	public int size()
	{
		return this.s;
	}
	public void clear()
	{
		head = null;
		s=0;
		return;
	}
}

class arraylist extends list
{
	private int[] arr;
	private int capacity;
	private int current;
	public arraylist()
	{
		arr = new int[1];
		capacity = 1;
		current = 0;
	}
	public void add(int data)
	{
		if(current == capacity)
		{
			int[] temp = new int[2*capacity];
			for(int i=0;i<current;i++)
			{
				temp[i] = arr[i];
			}
			
			capacity = capacity*2;
			arr = temp;
		}
		
		arr[current] = data;
		current++;
	}
	public void remove(int index)
	{
		if (index < 0)
		{
			System.out.println("invalid index");
			return;
		}
		if(index >= current)
		{
			System.out.println("index out of range");
			return;
		}
		for(int i = index;i<current-1;i++)
		{
			arr[i] = arr[i+1];
		}
		current = current-1;
	}
	public int get(int index)
	{
		if(index<current && index >= 0)
				return arr[index];
		return 0;
	}
	public void print()
	{
		if(current == 0)
			{System.out.println("Empty list");
			return;}
		for(int i=0;i<current;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	public int size()
	{
		return current;
	}
	public void clear()
	{
		int[] temp = new int[1];
		capacity = 1;
		current = 0;
	}
}
