public class IntList {

    private IntNode _head;


    public IntList() {
        _head = null;
    }

    public IntList(IntNode node) {
        _head = node;
    }

    public boolean empty() {
        return _head == null;
    }

    public void addToEnd(IntNode node) {
        if (empty( ))
            _head = node;
        else {
            IntNode ptr = _head;
            while (ptr.getNext( ) != null)
                ptr = ptr.getNext( );
            ptr.setNext(node);
        }
    }

    public IntNode getHead(){
        return _head;
    }

    public int length()
    {
        IntNode temp = _head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.getNext();
        }
        return count;
    }
}
