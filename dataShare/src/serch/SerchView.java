package serch;

import java.util.Scanner;

import main.View;

public class SerchView {
	public static void serchView() throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.println("=======================================================================================");
		System.out.println("||                             찾으시는 메뉴를 선택하세요.                           ||");
		System.out.println("||              아이디 찾기 - 1번    비밀번호 찾기- 2번    이전메뉴- 3번             ||");
		System.out.println("=======================================================================================");
		System.out.print("                                       선택 : ");
		int input = scanner.nextInt();
		switch (input) {
		case 1:
			Serch.serchId();
		case 2:
			Serch.serchPw();
		case 3:
			View.startMethod();
		default:
			System.out.println("=======================================================================================");
			System.out.println("||                       잘못 입력 했습니다. 다시 입력해주세요.                      ||");
			System.out.println("=======================================================================================");
			View.startMethod();
		}
		scanner.close();
	}
}