//�ַ�ջ�ڵ�
class CharNode {
	char c;
	int priority;
	public CharNode(char cr){
		c = cr;
		//���ַ��������ȼ�
		switch(cr){
			case ')': priority = 1;
					  break;
			case '+':
			case '-': priority = 2;
					  break;
			case '*':
			case '/': priority = 3;
					  break;
			case '(': priority = 10;
			  		  break;
		    default : priority = 0;
		}
	}
	CharNode next = null;
}