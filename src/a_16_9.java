import java.util.ArrayList;

public class a_16_9
{
    /* Write a method called stutter that doubles the size of a list by replacing every integer in the list with two of that
    integer. For example, suppose a variable list stores the values [1, 8, 19, 4, 17], after a call of
    list.stutter(), it should store [1, 1, 8, 8, 19, 19, 4, 4, 17, 17].*/

    //initiate standard variables
    private ListNode front;

    //too test the method
    public void run()
    {
        //I have made an add-method to ListNode
        addNodeToList(0,1);
        addNodeToList(1,8);
        addNodeToList(2,19);
        addNodeToList(3,4);
        addNodeToList(4,17);

        //I have made a print list data method
        stutter();
        printList();
    }


    //doubles the size of a list by replacing every integer in the list with two of that integer.
    //by using 3 for-loop.
    public void stutter()
    {
        //initiate variables
        ArrayList<Integer> holder = new ArrayList<>();

        //the for-loop adds fronts value to the arraylist holder.
        for (ListNode current = front; current != null; current = current.next)
        {
            holder.add(current.data);
        }

        //the for-loop set all nodes to null
        for (ListNode current = front; front != null; current = current.next)
        {
            //the reason for at check the next node is to avoid NullPointerException!
            if (current.next.next == null)
            {
                current.next = null;
            }
            if (current.next == null)
            {
                front = null;
            }
        }

        //adds the doubble to list(front)
        int rigthIndex = 0;
        for (int i = 0; i < holder.size(); i++)
        {
            //adds the doubble to list(front) with the add method
            addNodeToList(rigthIndex,holder.get(i));
            addNodeToList(rigthIndex+1,holder.get(i));
            rigthIndex += 2;
        }
    }

    //an add-method to ListNode that adds a value to the list
    public void addNodeToList(int index, int value)
    {
        //if index is 0, then add value to front
        if(index == 0)
        {
            front = new ListNode(value, front);
        }
        // else add a value to the end of list
        else
        {
            ListNode current = front;
            for (int i = 0; i < index-1; i++)
            {
                current = current.next;
            }
            current.next = new ListNode(value,current.next);
        }
    }

    //prints the list
    public void printList()
    {
        //the for-loop that prints the list data out
        System.out.print("[ ");
        for (ListNode current = front; current != null; current = current.next)
        {
            System.out.print(current.data + ", ");
        }
        System.out.println("]" + "\n");
    }

}
