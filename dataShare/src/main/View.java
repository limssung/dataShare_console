package main;

import java.util.Scanner;

import login.Login;
import manager.ManagerView;
import serch.SerchView;
import subscribe.Subscribe;

public class View {
   static int i;
   public static void startMethod() throws Exception {
      System.out.println("=======================================================================================");
      System.out.println("||                       어서오세요! DATA SHARING SERVICE 입니다.                    ||");
      System.out.println("||                             원하는 서비스를 선택하세요.                           ||");
      System.out.println("||                                     1. 회원가입                                   ||");
      System.out.println("||                                      2. 로그인                                    ||");
      System.out.println("||                                   3. ID & P/w 찾기                                ||");
      System.out.println("||                                       4. 종료                                     ||");
      System.out.println("=======================================================================================");
      Scanner scanner = new Scanner(System.in);
      int j = i;
      try {
         System.out.print("                                       선택 : ");
         int menu = scanner.nextInt();

         switch (menu) {
         case 1:
            Subscribe.subscribe();
            break;
         case 2:
            Login.login();
            break;
         case 3:
            SerchView.serchView();
            break;
         case 4:
            System.out.println(
                  "=======================================================================================");
            System.out.println("||                        안녕히 가세요. 프로그램을 종료합니다.                      ||");
            System.out.println(
                  "=======================================================================================");
            System.exit(0);
            break;
         case 9:
            while (j < 4) {
               i++;
               System.out.println(
                     "=======================================================================================");
               System.out.println("||                       잘못 입력 했습니다. 다시 입력해주세요.                      ||");
               System.out.println(
                     "=======================================================================================");
               startMethod();
            }
            ManagerView.manager();
         default:
            System.out.println(
                  "=======================================================================================");
            System.out.println("||                       잘못 입력 했습니다. 다시 입력해주세요.                      ||");
            System.out.println(
                  "=======================================================================================");
            startMethod();
            break;
         }
      } catch (java.util.InputMismatchException e) {
         System.out
               .println("=======================================================================================");
         System.out.println("||                       잘못 입력 했습니다. 다시 입력해주세요.                      ||");
         System.out
               .println("=======================================================================================");
         startMethod();
      }
      scanner.close();
   }
}