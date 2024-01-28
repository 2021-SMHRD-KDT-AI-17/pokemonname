package Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Model.MemberDAO;
import Model.MemberDTO;
import Model.PokemonBook;
import Model.PokemonDAO;
import Model.PokemonDTO;
import Model.ScoreDAO;
import Model.ScoreDTO;
import Model.Prologue;
import Model.PokemonBook;
import Model.PokemonBookAns;

public class PokemonProgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		MemberDAO mdao = new MemberDAO(); // mdao 초기화 - 명택
		ScoreDAO sdao = new ScoreDAO(); // sdao 초기화 - 현우
		PokemonBook book = new PokemonBook();
		
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
						
						PokemonBook pb = new PokemonBook();
						String [] pb1 = PokemonBook.book();
						Random rd = new Random();
						int i=0;
						
						while(i<10) {
						int quenum = rd.nextInt(pb1.length);
						String question = pb1[quenum];
						System.out.println(question);
						System.out.println("내 이름이 뭐게!!!");
						
						PokemonBookAns pba = new PokemonBookAns();
						String [] pbans = PokemonBookAns.ans();
						String answer = pbans[quenum];
						String userans = sc.next();
						if(userans.equals(answer))
						{
							System.out.println("정답이야!");
							sum++;
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
//					} else if (menu == 2) {
//						ArrayList<PokemonDTO> list = mdao.rank(null);
//						System.out.println("순위\t아이디\t점수");
//						for (int i = 0; i < list.size(); i++) {
//
//							PokemonDTO dto1 = list.get(i);
//							System.out.println((i + 1) + "\t" + dto1.getId() + "\t" + dto1.getScore());
//						}
//
//					} else if (menu == 3) {
//						ArrayList<PokemonDTO> list = mdao.history(result.getID());
//						for (int i = 0; i < list.size(); i++) {
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
