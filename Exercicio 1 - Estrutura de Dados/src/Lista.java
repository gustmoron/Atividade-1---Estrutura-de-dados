public class Lista<T> {

	public No<T> start, end;

	public void insertStart(T info) {
		No<T> temp = new No<T>(info);
	
		if (start == null) {
			end = temp;
		} else {
			temp.next = start;
			start.prev = temp;
		}
		start = temp;
	}

	public void insertEnd(T info) {
		No<T> temp = new No<T>(info);
		
		if (start == null) {
			start = temp;
		} else {
			temp.prev = end;
			end.next = temp;
		}
		end = temp;
	}

	public void printListFromStart() {
		No<T> temp = start;
		
		while (temp != null) {
			System.out.println(temp.info);
			temp = temp.next;
		}
	}

	public void printListFromEnd() {
		No<T> temp = end;
		
		while (temp != null) {
			System.out.println(temp.info);
			temp = temp.prev;
		}
	}

	public No<T> search(T info) {
		No<T> temp = start;
		
		while (temp != null) {
			if (temp.info.equals(info)) {
				break;
			}
			temp = temp.next;
		}

		return temp;
	}

	public void deleteFromStart2(T info) {
		No<T> temp = search(info);
		
		if (temp != null) {
			if (start.equals(temp) && end.equals(temp)) { // unico elemento
				start = null;
				end = null;
			} else if (start.equals(temp)) { // É o primeiro elemento
				start = temp.next;
				start.prev = null;
				temp.next = null;
			} else if (end.equals(temp)) { // ultimo elemento
				end = temp.prev;
				end.next = null;
				temp.prev = null;
			} else {
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				temp.next = null;
				temp.prev = null;
				temp = null;
			}
			temp = null;
		}
	}


}