import java.util.Scanner;


//������
class Run {
	public Run(){
		String input,ipt;   //���ڽ��ܲ���ʱ�������ѧ���ʽ
		DoubleStack ist = new DoubleStack();    //����һ������ջ
		CharStack cst = new CharStack();		//����һ���ַ�ջ
		System.out.println("������Ҫ����ı��ʽ");
		Scanner s = new Scanner(System.in);
		input = s.nextLine();
		ipt = input + "#";		//�����ѧ���ʽ��β��־"#"
		for(int i=0;i<ipt.length();i++){
			//�ж��ַ��Ƿ�Ϊ��ѧ�����
			if(ipt.charAt(i)=='+'||ipt.charAt(i)=='-'||ipt.charAt(i)=='*'||ipt.charAt(i)=='/'||ipt.charAt(i)=='('||ipt.charAt(i)==')'||ipt.charAt(i)=='#'){
				CharNode temp = new CharNode(ipt.charAt(i));
				//�Ƚ���������ȼ�,�����ǰ��������ָ��������ַ�ջջ�����ȼ���,����ջ���ַ���Ϊ'(',�������Ӧ����Ĳ���,���ջ���ַ�Ϊ'(',��������ַ�,���ջ���ַ�Ϊ'(',���ַ�Ϊ')',��ɾ��ջ���ַ�
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
				//���ǰһ����������ָ�ַ�ҲΪ����,��ô��ǰһ�����ֳ���10,�ټ����������滻ԭ��������,����ֱ�ӽ���������ջ
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