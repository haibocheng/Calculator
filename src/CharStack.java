//×Ö·ûÕ»
class CharStack {
	CharNode Head = new CharNode('#');
	void Insert(CharNode cn){
			cn.next = Head;
			Head = cn;
	}
	char Remove() {
		if(Head==null){
			System.out.println("±íÎª¿Õ,Í£Ö¹²Ù×÷");
			return 'f';
		} else {	
			char cr = Head.c;
			Head = Head.next;
			return cr;
		}
	}
}