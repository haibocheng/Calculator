//�ַ�ջ
class CharStack {
	CharNode Head = new CharNode('#');
	void Insert(CharNode cn){
			cn.next = Head;
			Head = cn;
	}
	char Remove() {
		if(Head==null){
			System.out.println("��Ϊ��,ֹͣ����");
			return 'f';
		} else {	
			char cr = Head.c;
			Head = Head.next;
			return cr;
		}
	}
}