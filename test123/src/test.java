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
				System.out.println("1. 조회 / 2. 입력 / 3. 판매 / 4. 구매 / 5. 수정 / 6. 종료");
				System.out.print("메뉴를 선택하세요 : ");
				String check1 = scan.next();	
				String a = check1;
				//입력
				if(check1.equals("2")){
					System.out.print((count+1)+"번 물품 이름: ");
					String aname = scan.next();					
					
				
					System.out.print((count+1)+"번 물품 코드 : ");
					int itemcode = scan.nextInt();
				
					System.out.print((count+1)+"번 물품 갯수 : ");
					int itemcount = scan.nextInt();
					
					System.out.print((count+1)+"의 판매 가격 : ");
					int sellcost = scan.nextInt();
					
					System.out.print((count+1)+"의 구매 가격 : ");
					int buycost = scan.nextInt();
					
					subj[count] = new Subject(aname, itemcode, itemcount , sellcost , buycost);
					
					System.out.println("물품이름 : "+subj[count].name+" 물품코드 : "+subj[count].code
							+ " 물품갯수 : " +subj[count].count+"개 가 입력되었습니다.\n");
			}//if
				if(a.equals("2")){
					count++;
				}	
				//판매
				if(check1.equals("3")){
					System.out.print("물품코드 : ");
					int co = scan.nextInt();
					System.out.print("판매갯수 : ");
					int ea = scan.nextInt();
					
					for(int i=0 ; i<count;i++)
					{
						if(subj[i].code == co){
							if(subj[i].count > ea){
								subj[i].count -= ea;
								System.out.println("판매 물품의 단가 : " + subj[i].sell);
								System.out.println("총 판매 금액 : "+(ea*subj[i].sell));								
								System.out.println(subj[i].name+ "의 갯수가" +ea+"개 판매후 "+subj[i].count+"개 남았습니다.\n" );
							}
							else{
								System.out.println("물품이 부족합니다.");
							}
						}
					} 
				}//if
				//구매
				if(check1.equals("4")){
					System.out.print("물품코드 : ");
					int co = scan.nextInt();
					System.out.print("구매갯수 : ");
					int ea = scan.nextInt();
					
					for(int i=0 ; i<count;i++)
					{
						if(subj[i].code == co){						
						subj[i].count += ea;
						System.out.println("구매 물품의 단가 : " + subj[i].buy);
						System.out.println("총 구매 금액 : "+(ea*subj[i].buy));
						System.out.println(subj[i].name+ "의 갯수가 " +ea+"개 구매후 "+subj[i].count+"개 남았습니다.\n" );
						}
					} 
				}//if
				
				//조회
				if(check1.equals("1")){
					if(count == 0){
						System.out.println("입력된 데이터가 없습니다.");
					}
					for(int i=0 ; i<count;i++)
					{
						System.out.println("물품이름 \t물품코드 \t물품갯수 \t판매단가 \t구입단가");
						System.out.println(subj[i].name+ "\t\t" +subj[i].code + "\t\t" +subj[i].count+"\t\t"
								+subj[i].sell+"\t\t" +subj[i].buy+"\t\t" );			
					}
				}
				
				if(check1.equals("5")){
					System.out.println();
					System.out.println("1. 물품갯수 / 2. 판매단가 / 3. 구입단가");
					System.out.print("수정 할 항목을 고르시오 : ");	
					System.out.println();
					int check2 = scan.nextInt();
					if(check2==1){
						System.out.println("물품갯수 수정 ( 1.추가 2.감소 3.수정 )");
						System.out.print("수정 할 항목을 고르시오 : ");
						System.out.println();
						int check3 = scan.nextInt();
						if(check3 == 1)
						{
							System.out.print("수정할 물품코드 : ");
							int code2 = scan.nextInt();							
							for(int i=0 ; i<count;i++)
								
							{
								if(subj[i].code == code2)
								{
									System.out.print("추가할 물품의 갯수 : ");
									int ea1 = scan.nextInt(); 
									subj[i].count += ea1;
									System.out.println("수정항목");
									System.out.println("물품이름 \t물품코드 \t물품갯수 \t판매단가 \t구입단가");
									System.out.println(subj[i].name+ "\t\t" +subj[i].code + "\t\t" +subj[i].count+"\t\t"
											+subj[i].sell+"\t\t" +subj[i].buy+"\t\t\n" );	
								}
								else
								{
									System.out.println("존재하지 않는 물품입니다.");
								}
							}
						}
						
						if(check3 == 2)
						{
							System.out.print("수정할 물품코드 : ");
							int code2 = scan.nextInt();
							
							for(int i=0 ; i<count;i++)
							{
								if(subj[i].code == code2)
								{
									System.out.print("감소시킬 물품의 갯수 : ");
									int ea1 = scan.nextInt(); 
									subj[i].count -= ea1;
									System.out.println("수정항목");
									System.out.println("물품이름 \t물품코드 \t물품갯수 \t판매단가 \t구입단가");
									System.out.println(subj[i].name+ "\t\t" +subj[i].code + "\t\t" +subj[i].count+"\t\t"
											+subj[i].sell+"\t\t" +subj[i].buy+"\t\t\n" );	
								}
								else
								{
									System.out.println("존재하지 않는 물품입니다.");
								}
							}
							
							
						}
						
						if(check3 == 3)
						{
							System.out.print("수정할 물품코드 : ");
							int code2 = scan.nextInt();
							
							for(int i=0 ; i<count;i++)
							{
								if(subj[i].code == code2)
								{
									System.out.print("수정할 물품의 갯수 : ");
									int ea1 = scan.nextInt(); 
									subj[i].count = ea1;
									System.out.println("수정항목");
									System.out.println("물품이름 \t물품코드 \t물품갯수 \t판매단가 \t구입단가");
									System.out.println(subj[i].name+ "\t\t" +subj[i].code + "\t\t" +subj[i].count+"\t\t"
											+subj[i].sell+"\t\t" +subj[i].buy+"\t\t\n" );	
								}
								else
								{
									System.out.println("존재하지 않는 물품입니다.");
								}
							}
						}
					}//물품갯수 if문
					
					if(check2==2){						
			
							System.out.print("수정할 물품코드 : ");
							int code2 = scan.nextInt();
							System.out.print("수정 물품의 판매단가 : ");
							int sellcost1 = scan.nextInt(); 
							for(int i=0 ; i<count;i++)
							{
								if(subj[i].code == code2)
								{
									subj[i].sell = sellcost1;
									System.out.println("수정항목");
									System.out.println("물품이름 \t물품코드 \t물품갯수 \t판매단가 \t구입단가");
									System.out.println(subj[i].name+ "\t\t" +subj[i].code + "\t\t" +subj[i].count+"\t\t"
											+subj[i].sell+"\t\t" +subj[i].buy+"\t\t\n" );	
								}
								else
								{
									System.out.println("존재하지 않는 물품입니다.");
								}
							}
					}
					
					if(check2==3){						
						
						System.out.print("수정할 물품코드 : ");
						int code2 = scan.nextInt();
						System.out.print("수정 물품의 구매단가 : ");
						int buycost1 = scan.nextInt(); 
						for(int i=0 ; i<count;i++)
						{
							if(subj[i].code == code2)
							{
								subj[i].buy = buycost1;
								System.out.println("수정항목");
								System.out.println("물품이름 \t물품코드 \t물품갯수 \t판매단가 \t구입단가");
								System.out.println(subj[i].name+ "\t\t" +subj[i].code + "\t\t" +subj[i].count+"\t\t"
										+subj[i].sell+"\t\t" +subj[i].buy+"\t\t\n" );	
							}
							else
							{
								System.out.println("존재하지 않는 물품입니다.");
							}
						}
				}

					
				}//else if
				
				//종료
				if(check1.equals("6")){
					System.out.println("종료되었습니다.");
					check = false;
				}//else if
			}
	}//메인종료
}//클래스종료
