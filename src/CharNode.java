//字符栈节点
class CharNode {
	char c;
	int priority;
	public CharNode(char cr){
		c = cr;
		//给字符分配优先级
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