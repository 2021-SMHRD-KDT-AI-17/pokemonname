package Model;

public class Prologue extends Thread{
   

   int n = 0;
   String prol= "프롤로그 (시작을 원할 시 아무 키나 눌러주세요)\r\n"
         + "\r\n"
         + "2054년 1월...\r\n"
         + "지구에서 인기가 있다는 소식을 듣고 출발한 포켓몬들이 드디어 지구에 도착했는데...\r\n"
         + "시간이 너무 흐른 지금, 포켓몬들을 기억하는 사람이 없다!\r\n"
         + "오랜 시간 걸려 왔건만, 잊힌 게 억울한 포켓몬들은 지구인들을 붙잡고 본인을 기억하냐 묻지만, \r\n"
         + "사람들은 아무도 기억하지 못하는데...\r\n"
         + "분노한 포켓몬들이 행패를 부리기 시작했다!!!\r\n"
         + "그 순간, 비슷한 만화를 봤던 추억을 떠올려보는 아저씨 아줌마들..\r\n"
         + "그... 그..... 머시기.. 너의 이름은!!!!";
   
   String []arr = prol.split("");
         
         @Override
         public void run()
         {
            while(n<arr.length)
            {
            System.out.print(arr[n]);
            n++;
            try
            {
               sleep(70);
               
            }catch(InterruptedException e)
            {
               return;
               
            }
         }
}
   

}