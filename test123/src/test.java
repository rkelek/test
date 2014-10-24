import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Subject implements Serializable{
	String name;
	int code;
	int count;
	int sell;
	int buy;

	
	Subject(){}
	
	Subject(String name , int code , int count , int sell , int buy){
		this.name=name;		
		this.code=code;
		this.count=count;
		this.sell=sell;
		this.buy=buy;
	}
	
	
}


public class test implements Serializable {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
			boolean check = true;
			int count = 0;
			Scanner scan = new Scanner(System.in);
			Subject [] subj = new Subject[500]; 
			while(check){	
				System.out.println("1. ��ȸ / 2. �Է� / 3. �Ǹ� / 4. ���� / 5. ���� / 6. ����");
				System.out.print("�޴��� �����ϼ��� : ");
				String check1 = scan.next();	
				String a = check1;
				//�Է�
				if(check1.equals("2")){
					System.out.print((count+1)+"�� ��ǰ �̸�: ");
					String aname = scan.next();					
					
				
					System.out.print((count+1)+"�� ��ǰ �ڵ� : ");
					int itemcode = scan.nextInt();
				
					System.out.print((count+1)+"�� ��ǰ ���� : ");
					int itemcount = scan.nextInt();
					
					System.out.print((count+1)+"�� �Ǹ� ���� : ");
					int sellcost = scan.nextInt();
					
					System.out.print((count+1)+"�� ���� ���� : ");
					int buycost = scan.nextInt();
					
					subj[count] = new Subject(aname, itemcode, itemcount , sellcost , buycost);
					
					System.out.println("��ǰ�̸� : "+subj[count].name+" ��ǰ�ڵ� : "+subj[count].code
							+ " ��ǰ���� : " +subj[count].count+"�� �� �ԷµǾ����ϴ�.\n");
			}//if
				if(a.equals("2")){
					count++;
				}	
				//�Ǹ�
				if(check1.equals("3")){
					System.out.print("��ǰ�ڵ� : ");
					int co = scan.nextInt();
					System.out.print("�ǸŰ��� : ");
					int ea = scan.nextInt();
					
					for(int i=0 ; i<count;i++)
					{
						if(subj[i].code == co){
							if(subj[i].count > ea){
								subj[i].count -= ea;
								System.out.println("�Ǹ� ��ǰ�� �ܰ� : " + subj[i].sell);
								System.out.println("�� �Ǹ� �ݾ� : "+(ea*subj[i].sell));								
								System.out.println(subj[i].name+ "�� ������" +ea+"�� �Ǹ��� "+subj[i].count+"�� ���ҽ��ϴ�.\n" );
							}
							else{
								System.out.println("��ǰ�� �����մϴ�.");
							}
						}
					} 
				}//if
				//����
				if(check1.equals("4")){
					System.out.print("��ǰ�ڵ� : ");
					int co = scan.nextInt();
					System.out.print("���Ű��� : ");
					int ea = scan.nextInt();
					
					for(int i=0 ; i<count;i++)
					{
						if(subj[i].code == co){						
						subj[i].count += ea;
						System.out.println("���� ��ǰ�� �ܰ� : " + subj[i].buy);
						System.out.println("�� ���� �ݾ� : "+(ea*subj[i].buy));
						System.out.println(subj[i].name+ "�� ������ " +ea+"�� ������ "+subj[i].count+"�� ���ҽ��ϴ�.\n" );
						}
					} 
				}//if
				
				//��ȸ
				if(check1.equals("1")){
					if(count == 0){
						System.out.println("�Էµ� �����Ͱ� �����ϴ�.");
					}
					for(int i=0 ; i<count;i++)
					{
						System.out.println("��ǰ�̸� \t��ǰ�ڵ� \t��ǰ���� \t�ǸŴܰ� \t���Դܰ�");
						System.out.println(subj[i].name+ "\t\t" +subj[i].code + "\t\t" +subj[i].count+"\t\t"
								+subj[i].sell+"\t\t" +subj[i].buy+"\t\t" );			
					}
				}
				
				if(check1.equals("5")){
					System.out.println();
					System.out.println("1. ��ǰ���� / 2. �ǸŴܰ� / 3. ���Դܰ�");
					System.out.print("���� �� �׸��� ���ÿ� : ");	
					System.out.println();
					int check2 = scan.nextInt();
					if(check2==1){
						System.out.println("��ǰ���� ���� ( 1.�߰� 2.���� 3.���� )");
						System.out.print("���� �� �׸��� ���ÿ� : ");
						System.out.println();
						int check3 = scan.nextInt();
						if(check3 == 1)
						{
							System.out.print("������ ��ǰ�ڵ� : ");
							int code2 = scan.nextInt();							
							for(int i=0 ; i<count;i++)
								
							{
								if(subj[i].code == code2)
								{
									System.out.print("�߰��� ��ǰ�� ���� : ");
									int ea1 = scan.nextInt(); 
									subj[i].count += ea1;
									System.out.println("�����׸�");
									System.out.println("��ǰ�̸� \t��ǰ�ڵ� \t��ǰ���� \t�ǸŴܰ� \t���Դܰ�");
									System.out.println(subj[i].name+ "\t\t" +subj[i].code + "\t\t" +subj[i].count+"\t\t"
											+subj[i].sell+"\t\t" +subj[i].buy+"\t\t\n" );	
								}
								else
								{
									System.out.println("�������� �ʴ� ��ǰ�Դϴ�.");
								}
							}
						}
						
						if(check3 == 2)
						{
							System.out.print("������ ��ǰ�ڵ� : ");
							int code2 = scan.nextInt();
							
							for(int i=0 ; i<count;i++)
							{
								if(subj[i].code == code2)
								{
									System.out.print("���ҽ�ų ��ǰ�� ���� : ");
									int ea1 = scan.nextInt(); 
									subj[i].count -= ea1;
									System.out.println("�����׸�");
									System.out.println("��ǰ�̸� \t��ǰ�ڵ� \t��ǰ���� \t�ǸŴܰ� \t���Դܰ�");
									System.out.println(subj[i].name+ "\t\t" +subj[i].code + "\t\t" +subj[i].count+"\t\t"
											+subj[i].sell+"\t\t" +subj[i].buy+"\t\t\n" );	
								}
								else
								{
									System.out.println("�������� �ʴ� ��ǰ�Դϴ�.");
								}
							}
							
							
						}
						
						if(check3 == 3)
						{
							System.out.print("������ ��ǰ�ڵ� : ");
							int code2 = scan.nextInt();
							
							for(int i=0 ; i<count;i++)
							{
								if(subj[i].code == code2)
								{
									System.out.print("������ ��ǰ�� ���� : ");
									int ea1 = scan.nextInt(); 
									subj[i].count = ea1;
									System.out.println("�����׸�");
									System.out.println("��ǰ�̸� \t��ǰ�ڵ� \t��ǰ���� \t�ǸŴܰ� \t���Դܰ�");
									System.out.println(subj[i].name+ "\t\t" +subj[i].code + "\t\t" +subj[i].count+"\t\t"
											+subj[i].sell+"\t\t" +subj[i].buy+"\t\t\n" );	
								}
								else
								{
									System.out.println("�������� �ʴ� ��ǰ�Դϴ�.");
								}
							}
						}
					}//��ǰ���� if��
					
					if(check2==2){						
			
							System.out.print("������ ��ǰ�ڵ� : ");
							int code2 = scan.nextInt();
							System.out.print("���� ��ǰ�� �ǸŴܰ� : ");
							int sellcost1 = scan.nextInt(); 
							for(int i=0 ; i<count;i++)
							{
								if(subj[i].code == code2)
								{
									subj[i].sell = sellcost1;
									System.out.println("�����׸�");
									System.out.println("��ǰ�̸� \t��ǰ�ڵ� \t��ǰ���� \t�ǸŴܰ� \t���Դܰ�");
									System.out.println(subj[i].name+ "\t\t" +subj[i].code + "\t\t" +subj[i].count+"\t\t"
											+subj[i].sell+"\t\t" +subj[i].buy+"\t\t\n" );	
								}
								else
								{
									System.out.println("�������� �ʴ� ��ǰ�Դϴ�.");
								}
							}
					}
					
					if(check2==3){						
						
						System.out.print("������ ��ǰ�ڵ� : ");
						int code2 = scan.nextInt();
						System.out.print("���� ��ǰ�� ���Ŵܰ� : ");
						int buycost1 = scan.nextInt(); 
						for(int i=0 ; i<count;i++)
						{
							if(subj[i].code == code2)
							{
								subj[i].buy = buycost1;
								System.out.println("�����׸�");
								System.out.println("��ǰ�̸� \t��ǰ�ڵ� \t��ǰ���� \t�ǸŴܰ� \t���Դܰ�");
								System.out.println(subj[i].name+ "\t\t" +subj[i].code + "\t\t" +subj[i].count+"\t\t"
										+subj[i].sell+"\t\t" +subj[i].buy+"\t\t\n" );	
							}
							else
							{
								System.out.println("�������� �ʴ� ��ǰ�Դϴ�.");
							}
						}
				}

					
				}//else if
				
				//����
				if(check1.equals("6")){
					System.out.println("����Ǿ����ϴ�.");
					check = false;
				}//else if
			}
	}//��������
}//Ŭ��������
