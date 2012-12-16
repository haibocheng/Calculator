import java.util.Scanner;


//测试类
class Run {
	public Run(){
		String input,ipt;   //用于接受测试时输入的数学表达式
		DoubleStack ist = new DoubleStack();    //创建一个数据栈
		CharStack cst = new CharStack();		//创建一个字符栈
		System.out.println("请输入要计算的表达式");
		Scanner s = new Scanner(System.in);
		input = s.nextLine();
		ipt = input + "#";		//添加数学表达式结尾标志"#"
		for(int i=0;i<ipt.length();i++){
			//判断字符是否为数学运算符
			if(ipt.charAt(i)=='+'||ipt.charAt(i)=='-'||ipt.charAt(i)=='*'||ipt.charAt(i)=='/'||ipt.charAt(i)=='('||ipt.charAt(i)==')'||ipt.charAt(i)=='#'){
				CharNode temp = new CharNode(ipt.charAt(i));
				//比较运算符优先级,如果当前计数器所指运算符比字符栈栈顶优先级低,并且栈顶字符不为'(',则进行相应计算的操作,如果栈顶字符为'(',则插入新字符,如果栈顶字符为'(',新字符为')',则删除栈顶字符
				if(temp.priority<=cst.Head.priority){
					if((cst.Head.priority-temp.priority)==9){
						cst.Remove();
					} else {
						if(cst.Head.priority==10||(temp.priority==0&&cst.Head.priority==0)){
							cst.Insert(temp);
						} else {
							double d2 = ist.Remove();
							double d1 = ist.Remove();
							double result = 0;
							switch(cst.Remove()){
								case '+': result = d1 + d2;
											break;
								case '-': result = d1 - d2;
											break;
								case '*': result = d1 * d2;
											break;
								case '/': result = d1 / d2;
											break;
						}
						ist.Insert(new DoubleNode(result));
						i--;
						}
					}
				} else {
					cst.Insert(temp);
				}
			} else {
				//如果前一个计数器所指字符也为数字,那么将前一个数字乘以10,再加上新数字替换原来的数字,否则直接将新数字入栈
				if(i>0&&ipt.charAt(i-1)>='0'&&ipt.charAt(i-1)<='9'){
					ist.Insert(new DoubleNode(ist.Remove()*10+((double)ipt.charAt(i)-48)));
				} else {
					ist.Insert(new DoubleNode(((double)ipt.charAt(i)-48)));
				}
			}
		}
		
		System.out.println(input+" = "+ist.Head.value);
	}
}