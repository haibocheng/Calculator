//����ջ
class DoubleStack {
	DoubleNode Head;
	void Insert(DoubleNode in){
		if(Head==null) {
			Head = in;
		} else {
			in.next = Head;
			Head = in;
		}
	}
	double Remove(){
		if(Head==null) {
			System.out.println("��Ϊ��,ֹͣ����");
			return -1;
		} else {
			double val = Head.value;
			Head = Head.next;
			return val;
		}
	}
}