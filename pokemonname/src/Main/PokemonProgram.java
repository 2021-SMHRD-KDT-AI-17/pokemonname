package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Model.MemberDAO;
import Model.MemberDTO;
import Model.PokemonDAO;
import Model.PokemonDTO;

public class PokemonProgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MemberDAO mdao = new MemberDAO(); // mdao 초기화 - 명택
		
		
		while(true) {
			System.out.print("포켓몬 너의 이름은");
			System.out.print("[1]회원가입 [2]로그인 [3]종료 >>");
			int choice = sc.nextInt();
			
			if(choice==1) {
				System.out.print("가입할 아이디 입력 : ");
				String joinId = sc.next();
				
				int result = mdao.idCheck(joinId);
				if(result==0) {
					System.out.println("사용가능한 id입니다.");
				}else continue;
				
				System.out.print("가입할 비밀번호 입력 : ");
				String joinPw = sc.next();
				
				MemberDTO dto = new MemberDTO();
				dto.setId(joinId);
				dto.setPw(joinPw);
				
			}else if(choice==2) {
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
						
						
					}else if(menu==2) {
						ArrayList<PokemonDTO> list=mdao.rank(null);
						System.out.println("순위\t아이디\t점수");
						for(int i = 0;i<list.size();i++) {
							
							PokemonDTO dto1 = list.get(i);
					    	System.out.println((i+1)+"\t" +dto1.getId() +"\t" +  dto1.getScore());
					    }
					
					}else if(menu==3) {
						ArrayList<PokemonDTO> list = mdao.history(result.getID());
						for(int i=0;i<list.size();i++) {
							System.out.println(list.get(i).getscore());
						}
						
					}else break;
						
					
				}
				
				
				
			}else break;
		}

	}

}
