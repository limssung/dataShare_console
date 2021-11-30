package manager;

import java.util.Scanner;

public class ManagerView {
	public static void manager() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=======================================================================================");
		System.out.println("                                관리자 모드가 실행되었습니다                         ");
        System.out.print  ("                                 관리자 키를 입력해주세요 : ");
        int i = scanner.nextInt();
        System.out.println("=======================================================================================");
        if (i == 1111) {
			Manager.managerMode();
		} else {
			System.out.println("                                  비밀번호가 틀렸습니다.");
			manager();
		}
		scanner.close();	
	}
	
}
