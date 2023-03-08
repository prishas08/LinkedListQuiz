import java.util.*;

public class MyLinkedList
{
	public static final int ID = 232646; //add your student ID here
		
	private ListNode front;

	public class ListNode //******** INNER CLASS ********
	{
		int      data;
		ListNode next;

		public ListNode(int data) { this.data = data; }
		public ListNode(int data, ListNode next) { this.data = data; this.next = next; }

		@Override
		public String toString() { return "" + this.data; }
	}

	public MyLinkedList() //not actually necessary but included for clarity
	{
		front = null;
	}

	public MyLinkedList(int val)
	{
		front = new ListNode(val);
	}

	/** for ease of testing, you can construct a MLL object with initial values:
	 *     MyLinkedList list = new MyLinkedList(1, 2, 3, 4);
	 */
	public MyLinkedList(int... vals)
	{
		if (front == null) front = new ListNode(vals[0]);

		ListNode current = front;

		for (int i = 1; i < vals.length; i++) {
			current.next = new ListNode(vals[i]);
			current = current.next;
		}
	}

	@Override
	public String toString()
	{
		String result = "[";

		ListNode current = front;

		while (current != null)
		{
			if (current.next == null) //reached last element in the list
				result += current.data;

			else
				result += current.data + ", ";

			current = current.next;
		}
		result += "]";

		return result;
	}

	public ListNode getFront() { return this.front; }

	/********************************************
	 ********** QUIZ METHODS BELOW HERE *********
	 ********************************************/

	//#1
	public void replaceLast(int n)
	{
		ListNode temp = this.front;
		while(temp.next.next!=null)
		{
			temp=temp.next;
		}
		temp.next.data = n;
		//TODO
	}

	//#2
	public int lastIndexOf(int val)
	{
		//TODO
		int index = -1;
		int counter = 0;
		ListNode temp = this.front;
		while(temp!=null)
		{
			if(temp.data == val)
			{
				index = counter;
			}
			temp = temp.next;
			counter++;
		}
		return index;
	}

	//#3
	public int countDuplicates()
	{
		//TODO
		int counter = 0;
		ListNode temp = this.front;
		while(temp.next!=null)
		{
			if(temp.data==temp.next.data)
			{
				counter++;
			}
			temp=temp.next;
		}
		return counter;
	}

	//#4
	public void stutter()
	{
		//don't run - has an infinity loop
		ListNode temp = this.front;
		ListNode temp2;
		while(temp.next!=null)
		{
			temp2 = temp.next;
			temp.next.data = temp.data;
			temp.next.next = temp2;
			temp=temp.next;
		}
		//TODO
	}

	//#5
	public void removeAll(int n)
	{
		ListNode temp = this.front;
		while(temp.next!=null)
		{
			if(temp.data==n)
			{
				front = temp.next;
			}
			if(temp.next.data == n)
			{
				ListNode temp2 = temp.next;
				temp2 = temp2.next;
				temp.next = temp2;
			}
			temp = temp.next;
		}
		//TODO
	}

	//#6
	public int deleteLast()
	{
		//TODO
		ListNode temp = this.front;
		int x = 0;
		while(temp.next.next!=null)
		{
			temp = temp.next;
		}
		x = temp.next.data;
		temp = new ListNode(temp.next.data, null);
		return x;
	}

	/** You can test your methods below if you'd like */
	public static void main(String[] args)
	{
		//
		MyLinkedList b = new MyLinkedList(1,2,3,4,5,6,7);
		b.replaceLast(42);
		System.out.println(b);
		MyLinkedList c = new MyLinkedList(1,18,2,7,18,38,18,40);
		System.out.println(c.lastIndexOf(18));
		MyLinkedList d = new MyLinkedList(1, 1, 1, 3, 3, 6, 9, 15, 15, 23, 23, 23, 40, 40);
		System.out.println(d.countDuplicates());
		MyLinkedList e = new MyLinkedList(1, 8, 19, 4, 17);
		//e.stutter();
		System.out.println(e);
		MyLinkedList f = new MyLinkedList(3, 9, 4, 2, 3, 8, 17, 4, 3, 18);
		f.removeAll(3);
		System.out.println(f);
		MyLinkedList g = new MyLinkedList(1, 8, 19, 4, 17);
		System.out.println(g.deleteLast());
		System.out.println(g);
	}
}
