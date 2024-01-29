

package Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Model.MemberDAO;
import Model.MemberDTO;
import Model.MusicCon;
import Model.PokemonDAO;
import Model.PokemonDTO;
import Model.PokemonMusic;
import Model.ScoreDAO;
import Model.ScoreDTO;
import javazoom.jl.player.MP3Player;
import Model.Prologue;
import Model.PokemonBook;
import Model.PokemonBookAns;
import Model.PokemonBookHint;
import Model.Question;

public class PokemonProgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String defaultPath = "C:\\Users\\SMHRD\\Desktop\\music\\";
		MP3Player bgm = new MP3Player();

		MemberDAO mdao = new MemberDAO(); // mdao 초기화 - 명택
		ScoreDAO sdao = new ScoreDAO(); // sdao 초기화 - 현우
		Question que = new Question();
		Prologue prol = new Prologue();
		prol.start();
		

		bgm.play(defaultPath +"Pokemon Fire Red and Leaf Green - Wild Pokemon Battle.mp3");
		
		
		
		String skip = sc.next();


		
		while (true) {
			

			prol.stop();

			System.out.println();
			System.out.println("                                                                                                    \r\n"
					+ "                                                                                                    \r\n"
					+ "                                                                                                    \r\n"
					+ "                                                    :#*+.                                           \r\n"
					+ "                                                  .+**=*+.                                          \r\n"
					+ "                                       ...      .-**=--=**.                                         \r\n"
					+ "            ..:::::..            ..-+***%*+.   .***-=**-.   .....-******:                           \r\n"
					+ "       .:+****+++++***=.     .=****+==*#*++*+..*%#*****+- :#**+++***--=*+    .*#**=-..              \r\n"
					+ "   ..=**+=-----------=+*=.   +%*+----=**---=+****+=---==+**#*+---=**---**.   .##*==++***=*+-:..     \r\n"
					+ "  :##*=----------------=*-   =#***---=+------**=--=++=---+***-----+----+*:  ..##**----=*#*+++***+   \r\n"
					+ "  .+##*=--------+***=---**...::#%*=--------+**=--*:.*=-=**%#*-----=----=*=+*******-----+**----**.   \r\n"
					+ "    =##*+**-----=#-=*---****====**+------+*=:*=--**+--**=***=----------=**--*---=+*----=*=---+*-    \r\n"
					+ "     -*****=-----+*+*--**+--*=---=*+----==****+------=---==**=--------=*=-=*+--+-=++---=*----*+.    \r\n"
					+ "      ::-##*=-----+--=**=--**+=++-=*---------=**---------+**----*=--+-**--=****+--++----=---+*.     \r\n"
					+ "         +#**=-----=****---=***+--+*--=**+----=+*********#*+---=**-+*-+*---------+*--=-----=*=      \r\n"
					+ "         .#%**-----**##*----------*+--=*##***=----=**#-.*%**+=-+#****==*+-------+*=-=+-----**.      \r\n"
					+ "          .#%**----=*##*+-------=**=--=*..+#%#***==*+   +**#%#####*#*=-=+***+****---++----=*-       \r\n"
					+ "           .%%**---=***%#**+++**#%**++**.   .-*%##**+           .:*%****+***=:%#*=--*+----*=        \r\n"
					+ "            -%#*=---+*-.+%%%%#:.+%#%%#+.       ..=%%*             .:=*%%###*.-%####**+---+*.        \r\n"
					+ "             =%#*=-+***                                                           :%#***=*=         \r\n"
					+ "             .*%#*#*+-                                                            .:+*%##*.         \r\n"
					+ "              .-..                                                                     ..           \r\n"
					+ "                      ..@.       ..   .#:            .:#.     .+=====%:        .%*=%:               \r\n"
					+ "              .%+      .%.    .%.  =#. *:     .+#%*.  .*      .%%#####:       .@.  .%:              \r\n"
					+ "               =+   ++=.%.    .%.  -%. *:    .%:  .%. .*      .+*++++*+        .*+=*=.              \r\n"
					+ "               =+    . .%.     ..::.  .*:     +*..+*. .*    :%#########%-  .=%#########%.           \r\n"
					+ "               =@%=..  .%.   .===*#@*. *:       ..    .*      :%%%%%%%-      :+..                   \r\n"
					+ "                       .%.             *.             .*      .@:    ++       .@.     . .::.        \r\n"
					+ "                       .-.             -.             .-      .--------       .-------: .:-.        \r\n"
					+ "                                                                                                    \r\n"
					+ "                                                                                                    \r\n"
					+ "                                                                                                    \r\n"
					+ "                                                                                                    \r\n"
					+ "                                                                                                    ");
			

			System.out.println();
			System.out.print("[1]회원가입 [2]로그인 [3]종료 "
					+ "");
			int choice = sc.nextInt();

			if (choice == 1) {
				
				System.out.print("가입할 아이디 입력 : ");
				String joinId = sc.next();

				int result = mdao.idCheck(joinId);
				if (result == 0) {
					System.out.println("사용가능한 id입니다.");
				} else {
					System.out.println("사용중인 id 입니다. 다시 입력해주세요");
					continue; 
				}
				

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
			
				if(result==null) {
					System.out.println("로그인 실패");
					continue;
				} 

				//=======플레이
				while(true) {
				if(result != null) {
					System.out.println("===메뉴 선택===");
					System.out.println("[1]플레이 [2]랭킹보기 [3]나의 기록 확인 [4]로그아웃 >>");
					int menu = sc.nextInt();
					if(menu==1) {
						int sum = 0;
						int ansnum = 0;
						int hintnum = 0;
						int hint = 5;
						int pass = 1;
						int score = 1;
						int hintscore=1;
						
						PokemonBook pb = new PokemonBook();
						String [] pb1 = PokemonBook.book();
						Random rd = new Random();
						int i=0;

						System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣\r\n"
								+ "|　난이도 설정!　　　　　　　　　　　　　　　　[－][口][×]　　  |\r\n"
								+ "|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣|\r\n"
								+ "|　난이도에 따라 주는 점수가 다르다구!　　　　　　　　　　　　　  |\r\n"
								+ "|　상 : 30점 , 중 : 20점 , 하 : 10점　　　　　　　　　　　　　　　|\r\n"
								+ "|　　　　＿＿＿＿＿＿　　　　＿＿＿＿＿＿　　　　＿＿＿＿＿　　　|\r\n"
								+ "| 　　　｜[1] 하　　 |　　　｜[2] 중　　 ｜　 　|[3] 상　 　|　　|\r\n"
								+ "|　　　　￣￣￣￣￣￣　　　　￣￣￣￣￣￣　　　　￣￣￣￣￣　　　|\r\n"
								+ "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
						if(bgm.isPlaying())
						{
							bgm.stop();
						}
						
						int level = sc.nextInt();
						
						int quenum;
						

						while(i<=6) {
						 
						if(level == 1) { 
							quenum = rd.nextInt(22);
							score = 10;
							hintscore = 5;
						}
						else if(level == 2)
						{
							quenum = rd.nextInt(21)+23;
							score = 20;
							hintscore=10;
						}
						else
						{
							quenum = rd.nextInt(24)+45;
							score = 30;
							hintscore=15;
						}
						
		
						if(bgm.isPlaying())
						{
							bgm.stop();
						}
						bgm.play(defaultPath+"4.mp3");
						
						String question = pb1[quenum];
						System.out.println(question);
						System.out.println();

						que.viewque();
						int achoice = sc.nextInt();
						PokemonBookAns pba = new PokemonBookAns();
						String [] pbans = PokemonBookAns.ans();
						String answer = pbans[quenum];
						
						
						if(achoice == 1) {
					
						String userans = sc.next();
							if(userans.equals(answer))
							{
								que.answerright();
								ansnum++;
		                        try {
		                            Thread.sleep(2*1000); 
		                        } catch (InterruptedException ie) {
		                            Thread.currentThread().interrupt();
		                        }
							}
							else
		                     {
								que.answerwrong();
		                        
		                        // 화면 지연 : 틀렸을때 공격 받는 모습 보이도록 연출
		                        try {
		                            Thread.sleep(2*1000); 
		                        } catch (InterruptedException ie) {
		                            Thread.currentThread().interrupt();
		                        }

		                     }
							i++;
						}
						
						else if(achoice == 2)
						{
							 PokemonBookHint phb = new PokemonBookHint();
							 String [] pbhint = PokemonBookHint.hint();
							 if(hint>0) 
							 {
							 System.out.println("내 이름은 "+pbhint[quenum]+"이니까 잘 맞춰보라고!");
							 hint --;

								String userans = sc.next();
								if(userans.equals(answer))
								{
									que.answerright();
			                        try {
			                            Thread.sleep(2*1000); 
			                        } catch (InterruptedException ie) {
			                            Thread.currentThread().interrupt();
			                        }
									hintnum++;
								}
								else
			                     {
									que.answerwrong();
			                        // 화면 지연 : 틀렸을때 공격 받는 모습 보이도록 연출
			                        try {
			                            Thread.sleep(2*1000); 
			                        } catch (InterruptedException ie) {
			                            Thread.currentThread().interrupt();
			                        }

			                     }
								i++;	 
							 }
							 else
							 {
								 System.out.println("힌트를 다 사용해버렸어!!");
								 String userans = sc.next();
									if(userans.equals(answer))
									{
										que.answerright();
				                        try {
				                            Thread.sleep(2*1000); 
				                        } catch (InterruptedException ie) {
				                            Thread.currentThread().interrupt();
				                        }
										ansnum++;
									}
									else
				                     {
										que.answerwrong();
				                        // 화면 지연 : 틀렸을때 공격 받는 모습 보이도록 연출
				                        try {
				                            Thread.sleep(2*1000); 
				                        } catch (InterruptedException ie) {
				                            Thread.currentThread().interrupt();
				                        }

				                     }
									i++;	 
							 }


								
						}
						else if(achoice == 3 )
						{
							if(pass >0)
							{
							pass --;
							}
							else
							{
								System.out.println("패스 기회를 소진했어! 뭐든 기억해내라고!!");
								String userans = sc.next();
								if(userans.equals(answer))
								{
									que.answerright();
									ansnum++;
			                        try {
			                            Thread.sleep(2*1000); 
			                        } catch (InterruptedException ie) {
			                            Thread.currentThread().interrupt();
			                        }
								}
								else
			                     {
									que.answerwrong();
			                        // 화면 지연 : 틀렸을때 공격 받는 모습 보이도록 연출
			                        try {
			                            Thread.sleep(2*1000); 
			                        } catch (InterruptedException ie) {
			                            Thread.currentThread().interrupt();
			                        }

			                     }
								i++;
							}
						}

							sum = (score * ansnum) + (hintscore * hintnum);
						 	System.out.println("지금까지의 점수는 "+sum+" 점이야!");
		
					}
						
					
						if(i==7)
						{
							System.out.println("최종 점수는 "+sum+"점이야!");
						}

						ScoreDTO sdto = new ScoreDTO();
						sdto.setId(result.getId());
						sdto.setScore(sum);
						
						int cnt = sdao.PlayScore(sdto);{
							if(cnt>0) {
														
								continue;
							}
						}
						
					

				
				
					
			// =======  랭킹보기			
					}else if(menu==2) {
						
						ArrayList<ScoreDTO> list=sdao.rank();
						//for(int i = 0;i<list.size();i++) {
						if(bgm.isPlaying())
						{
							bgm.stop();
						}
						bgm.play(defaultPath+"end.mp3");
						System.out.println("                                                                                                                     \r\n"
								+ "                                                                                                                     \r\n"
								+ "                                                                                                                     \r\n"
								+ "                                                                                                                     \r\n"
								+ "                                                                                                                     \r\n"
								+ "                                                                                                                     \r\n"
								+ "                                            =:                                                                       \r\n"
								+ "                                            +@-:-                 .=#@#                                              \r\n"
								+ "                                             ++:::-            .:::-@+                                               \r\n"
								+ "                                               :::::.  ...:. .:::::=.  .:-                                           \r\n"
								+ "                 .:-::.                          :::::::::::::::-..-:::::=                                           \r\n"
								+ "               :+==-----: :--..                    ::::::::::::--::::::::.                                           \r\n"
								+ "              :+++===--=*===--*=                  -:=-:::::::+:-=:::::::-.                                           \r\n"
								+ "              =++**====-%#==-.==+:                =:#%-:::::*%-:-::::--..                                            \r\n"
								+ "              =+=%@@=======+- :---:               **+::::-::::*#=:-                                                  \r\n"
								+ "              :*+=%#+++===++-.:::-.               =*+::::::::=**+:::-                                                \r\n"
								+ "               -*++*+#####**. ..:.                 =--::::::::-=:::-:.                                               \r\n"
								+ "               .-*+##******.   .=-                .:::::-=-:::::++                                                   \r\n"
								+ "           .:+++**#***#*++++. :++-               :::::::-:::::::=.                                                   \r\n"
								+ "         .====+++*###*-:::::=#**+.             .::::::::::+::::-:-                   .:==::::                        \r\n"
								+ "         :+==+=:  :**=::.....-*+:             .+--:=:::::-=::::-:=:-              : .:-@%::-#+                       \r\n"
								+ "                  .+=:.......:===:              ==--=:::-==:::=:-==            .:::--:-:--::--.                      \r\n"
								+ "                  .==:..:::::-++==:              .=-.:-:. .-=:++-               :::.---+==++*+. .                    \r\n"
								+ "                 :====::::::-*#*+++*-:   :--------------------------------       -:.:-==-::::::::-                   \r\n"
								+ "                 =++++**-:-   -###+--    :--------------------------------       :=-:::::-:.::::.                    \r\n"
								+ "                 :***##:        ..       :--------------------------------    .::+...:...:...:.                      \r\n"
								+ "                :=*###+                  :--------------------------------    .::+.......:.....                      \r\n"
								+ "         ------------::::::::::::::::::::---------------------------------    --:-..:....:..::::.                    \r\n"
								+ "        .-----------------------------------------------------------------      .:-::::...:-::==-:                   \r\n"
								+ "        .-----------------------------------------------------------------        :::-=::..:-===:                    \r\n"
								+ "        .------------------------------:----------------------------------        ::-=.     .:.                      \r\n"
								+ "        .--------------------------------=--------------------------------        :::-                               \r\n"
								+ "        .--------------------------:-----=--------------------------------=:-:----------------------------:          \r\n"
								+ "        .--------------------------------========-------------------------+===============================-          \r\n"
								+ "        .--------------------------------=======-===---------------------=+===============================-          \r\n"
								+ "        .--------------------------------=========-====-=========---=----=+===============================-          \r\n"
								+ "        .--------------------------------==========----========--=========+===============================-          \r\n"
								+ "        .--------------------------------=================================+===============================-          \r\n"
								+ "        .--------------------------------=================================+===============================-          \r\n"
								+ "        .-------------------------------==================================*++++++++++++====================:...      \r\n"
								+ "        .-----==========================++++++++++++++++++++++++++++++++++*++++++++++++++++++++++++++++++++-:::......\r\n"
								+ "          ....:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::..........\r\n"
								+ "                          . .......................................................................                  \r\n"
								+ "                                                                                                                     ");
						System.out.println("　　　　　　　　　　"+list.get(1).getId()+"　　　　　　　　　　　　　　　"+list.get(0).getId()+"　　　　　　　　　　　　　　　"+list.get(2).getId());
						System.out.println("　　　　　　　　　　"+list.get(1).getScore()+"　　　　　　　　　　　　　　　　"+list.get(0).getScore()+"　　　　　　　　　　　　　　　　"+list.get(2).getScore());
							//ScoreDTO dto1 = list.get(i);
					    	//System.out.println((i+1)+"\t" +list.get(i).getId() +"\t" + list.get(i).getScore());
					   // }
						
						
						
						
			// ==== 나의 기록보기		
					}else if(menu==3) {
						ArrayList<ScoreDTO> list = sdao.history(result.getId());
						
						System.out.println("점수\t날짜");
						for(int i=0;i<list.size();i++) {
							System.out.println(list.get(i).getScore()+"\t"+list.get(i).getIndate());
						}
						
					}else break;
//						
//					

				}
				
				} // 메뉴 while 문 끝  
				
			}else break;

		}

	}

}
