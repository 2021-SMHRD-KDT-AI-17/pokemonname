package Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Model.MemberDAO;
import Model.MemberDTO;
import Model.PokemonDAO;
import Model.PokemonDTO;
import Model.ScoreDAO;
import Model.ScoreDTO;
import Model.Prologue;
import Model.PokemonBook;
import Model.PokemonBookAns;
import Model.PokemonBookHint;

public class PokemonProgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		MemberDAO mdao = new MemberDAO(); // mdao 초기화 - 명택
		ScoreDAO sdao = new ScoreDAO(); // sdao 초기화 - 현우
		
		Prologue prol = new Prologue();
		prol.start();
		
		String skip = sc.next();
		
		while (true) {
			
			prol.stop();
			System.out.println();
			System.out.println("포켓몬 너의 이름은");
			

			
			System.out.print("[1]회원가입 [2]로그인 [3]종료 >>");
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.print("가입할 아이디 입력 : ");
				String joinId = sc.next();

				int result = mdao.idCheck(joinId);
				if (result == 0) {
					System.out.println("사용가능한 id입니다.");
				} else
					continue;

				System.out.print("가입할 비밀번호 입력 : ");
				String joinPw = sc.next();

				MemberDTO dto = new MemberDTO();
				dto.setId(joinId);
				dto.setPw(joinPw);
				
				int cnt = mdao.join(dto);

			} else if (choice == 2) {
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();

				MemberDTO dto = new MemberDTO();
				dto.setId(id);
				dto.setPw(pw);

				MemberDTO result = mdao.login(dto);

				
				//=======플레이
				if(result != null) {
					System.out.println("===메뉴 선택===");
					System.out.println("[1]플레이 [2]랭킹보기 [3]나의 기록 확인 [4]로그아웃 >>");
					int menu = sc.nextInt();
					if(menu==1) {
						int sum = 0;
						int hint = 5;
						int pass = 1;
						
						PokemonBook pb = new PokemonBook();
						String [] pb1 = PokemonBook.book();
						Random rd = new Random();
						int i=0;
						
						System.out.println("난이도를 선택하라고! 난이도에 따라 점수가 다를 거야!!");
						System.out.println("[1]하 [2]중 [3]상");
						
						int level = sc.nextInt();
						
						int quenum;
						
						if(level == 1) { 
							quenum = rd.nextInt(22);
						}
						else if(level == 2)
						{
							quenum = rd.nextInt(21)+23;
						}
						else
						{
							quenum = rd.nextInt(24)+45;
						}
						
						String question = pb1[quenum];
						System.out.println(question);
						
						
						System.out.println("내 이름이 뭐게!!!");
	
						System.out.println("[1]정답입력 [2]힌트 [3]패스");
						int achoice = sc.nextInt();
						PokemonBookAns pba = new PokemonBookAns();
						String [] pbans = PokemonBookAns.ans();
						String answer = pbans[quenum];
						
						
						if(achoice == 1) {
					
						String userans = sc.next();
							if(userans.equals(answer))
							{
								System.out.println("정답이야!");
								sum=sum+10;
							}
							else
							{
								System.out.println("그것도 기억 못하다니!!");
							}
							i++;
						}
						
						else if(achoice == 2&&hint>0)
						{
							 PokemonBookHint phb = new PokemonBookHint();
							 String [] pbhint = PokemonBookHint.hint();
							 System.out.println("내 이름은 "+pbhint[quenum]+"이니까 잘 맞춰보라고!");
							 hint --;
							 
								String userans = sc.next();
								if(userans.equals(answer))
								{
									System.out.println("정답이야!");
									sum=sum+5;
								}
								else
								{
									System.out.println("그것도 기억 못하다니!!");
								}
								i++;	 
							
								
						}
						else if(achoice == 3 && pass > 0)
						{
							pass --;
						}
						
						if(pass ==0)
						{
							System.out.println("패스 기회를 소진했어! 뭐든 기억해내라고!!");
							String userans = sc.next();
							if(userans.equals(answer))
							{
								System.out.println("정답이야!");
								sum=sum+5;
							}
							else
							{
								System.out.println("그것도 기억 못하다니!!");
							}
							i++;
						}
						

						 if(achoice == 2&&hint ==0)
						 {
							 System.out.println("힌트 기회를 소진했어!! 뭐든 생각해내라고!");
								String userans = sc.next();
								if(userans.equals(answer))
								{
									System.out.println("정답이야!");
									sum=sum+5;
								}
								else
								{
									System.out.println("그것도 기억 못하다니!!");
								}
								i++;

						 }

						
						
						if(i==10)
							{
								System.out.println(sum);
							}
				
					}
					else if(menu==2) {
//						ArrayList<PokemonDTO> list=mdao.rank(null);
//						System.out.println("순위\t아이디\t점수");
//						for(int i = 0;i<list.size();i++) {
//							
//							PokemonDTO dto1 = list.get(i);
//					    	System.out.println((i+1)+"\t" +dto1.getId() +"\t" +  dto1.getScore());
//					    }
//					
//					}else if(menu==3) {
//						ArrayList<PokemonDTO> list = mdao.history(result.getID());
//						for(int i=0;i<list.size();i++) {
//							System.out.println(list.get(i).getscore());
//						}
//						
					}else break;
//						
//					
				}
				
				
				
			}else break;

		}

	}

}
