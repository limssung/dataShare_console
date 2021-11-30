package serch;

import java.util.Scanner;

import agency.AgencyKt;
import agency.AgencyLgu;
import agency.AgencySkt;
import dao.SerchDAO;
import main.View;

public class Serch {

	public static void serchId() throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.println("=======================================================================================");
		System.out.println("||                                통신사를 선택하세요.                               ||");
		System.out.println("||        SKT - 1번         KT - 2번         LGU - 3번        이전메뉴 - 4번         ||");
		System.out.println("=======================================================================================");
		System.out.print("                                       선택 : ");
		int input = scanner.nextInt();
		switch (input) {
		case 1:
			System.out.println("=======================================================================================");
			System.out.print("                                  이름을 입력해주세요 : ");
			String sk_name = scanner.next();
			System.out.println("                            전화번호 형식은 010-XXXX-XXXX 입니다.");
			System.out.print("                                  전화번호를 입력해주세요 : ");
			String sk_hpNumber = scanner.next();
			SerchDAO.serchIdSkt(new AgencySkt(sk_name, sk_hpNumber));
			View.startMethod();
			break;
		case 2:
			System.out.println("=======================================================================================");
			System.out.print("                                  이름을 입력해주세요 : ");
			String kt_name = scanner.next();
			System.out.println("                            전화번호 형식은 010-XXXX-XXXX 입니다.");
			System.out.print("                                  전화번호를 입력해주세요 : ");
			String kt_hpNumber = scanner.next();
			SerchDAO.serchIdKt(new AgencyKt(kt_name, kt_hpNumber));
			View.startMethod();
			break;
		case 3:
			System.out.println("=======================================================================================");
			System.out.print("                                  이름을 입력해주세요 : ");
			String lgu_name = scanner.next();
			System.out.println("                            전화번호 형식은 010-XXXX-XXXX 입니다.");
			System.out.print("                                  전화번호를 입력해주세요 : ");
			String lgu_hpNumber = scanner.next();
			SerchDAO.serchIdLgu(new AgencyLgu(lgu_name, lgu_hpNumber));
			View.startMethod();
			break;
		
		case 4:
			View.startMethod();
			break;
			
		default:
			System.out.println("=======================================================================================");
			System.out.println("||                       잘못 입력 했습니다. 다시 입력해주세요.                      ||");
			System.out.println("=======================================================================================");
			View.startMethod();
			break;
		}
		scanner.close();
	}
	
	public static void serchPw() throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=======================================================================================");
		System.out.println("||                                통신사를 선택하세요.                               ||");
		System.out.println("||        SKT - 1번         KT - 2번         LGU - 3번        이전메뉴 - 4번         ||");
		System.out.println("=======================================================================================");
		System.out.print("                                       선택 : ");
		int input = scanner.nextInt();
		switch (input) {
		case 1:
			System.out.println("=======================================================================================");
			System.out.print("                                 아이디를 입력해주세요 : ");
			String sk_id = scanner.next();
			System.out.print("                                  이름을 입력해주세요 : ");
			String sk_name = scanner.next();
			System.out.println("                            전화번호 형식은 010-XXXX-XXXX 입니다.");
			System.out.print("                                  전화번호를 입력해주세요 : ");
			String sk_hpNumber = scanner.next();
			SerchDAO.serchPwSkt(new AgencySkt(sk_id, sk_name, sk_hpNumber));
			View.startMethod();
			break;
		case 2:
			System.out.println("=======================================================================================");
			System.out.print("                                 아이디를 입력해주세요 : ");
			String kt_id = scanner.next();
			System.out.print("                                  이름을 입력해주세요 : ");
			String kt_name = scanner.next();
			System.out.println("                            전화번호 형식은 010-XXXX-XXXX 입니다.");
			System.out.print("                                  전화번호를 입력해주세요 : ");
			String kt_hpNumber = scanner.next();
			SerchDAO.serchPwKt(new AgencyKt(kt_id, kt_name, kt_hpNumber));
			View.startMethod();
			break;
		case 3:
			System.out.println("=======================================================================================");
			System.out.print("                                 아이디를 입력해주세요 : ");
			String lgu_id = scanner.next();
			System.out.print("                                  이름을 입력해주세요 : ");
			String lgu_name = scanner.next();
			System.out.println("                            전화번호 형식은 010-XXXX-XXXX 입니다.");
			System.out.print("                                  전화번호를 입력해주세요 : ");
			String lgu_hpNumber = scanner.next();
			SerchDAO.serchPwLgu(new AgencyLgu(lgu_id, lgu_name, lgu_hpNumber));
			View.startMethod();
			break;
		case 4:
			View.startMethod();
			break;
		default:
			System.out.println("=======================================================================================");
			System.out.println("||                       잘못 입력 했습니다. 다시 입력해주세요.                      ||");
			System.out.println("=======================================================================================");
			View.startMethod();
			break;
		}
		scanner.close();
	}
}
