package subscribe;

import java.util.Scanner;

import agency.AgencyKt;
import agency.AgencyLgu;
import agency.AgencySkt;
import dao.CheckDAO;
import dao.SubscribeDAO;
import main.View;

public class Subscribe {

	public static void subscribe() throws Exception {

		Scanner scanner = new Scanner(System.in);
		CheckDAO hpdao = new CheckDAO();
		SubscribeDAO dao = new SubscribeDAO();
		System.out.println("=======================================================================================");
		System.out.println("||                                통신사를 선택하세요.                               ||");
		System.out.println("||        SKT - 1번         KT - 2번         LGU - 3번        이전메뉴 - 4번         ||");
		System.out.println("=======================================================================================");
		System.out.print("                                       선택 : ");
		int input = scanner.nextInt();
		switch (input) {
		case 1:
			System.out
					.println("=======================================================================================");
			System.out.print("                                  아이디를 입력해주세요 : ");
			scanner.nextLine();
			String sk_id = scanner.nextLine();
			dao.idcheck(new AgencySkt(sk_id));
			System.out.print("                                 비밀번호를 입력해주세요 : ");
			String sk_ps = scanner.nextLine();

			String sk_name;
			while (true) {
				System.out.println("                 이름 형식은 한글[2글자-4글자] or 영문[firstname lastname] 입니다. ");
				System.out.print("                                  이름을 입력해주세요 : ");
				sk_name = scanner.nextLine();
				if (hpdao.namecheck(sk_name) != false) {
					break;
				}
			}

			String sk_hpNumber;
			while (true) {
				System.out.println("                            전화번호 형식은 010-XXXX-XXXX 입니다.");
				System.out.print("                                  전화번호를 입력해주세요 : ");
				sk_hpNumber = scanner.nextLine();
				if (hpdao.numbercheck(sk_hpNumber) != false) {
					break;
				}
			}
			hpdao.hpcheck(new AgencySkt(sk_hpNumber));
			System.out
					.println("=======================================================================================");
			dao.insertSkt(new AgencySkt(sk_id, sk_ps, sk_name, sk_hpNumber, 0, 0));
			View.startMethod();

		case 2:
			System.out
					.println("=======================================================================================");
			System.out.print("                                  아이디를 입력해주세요 : ");
			scanner.nextLine();
			String kt_id = scanner.nextLine();
			dao.idcheck(new AgencyKt(kt_id));
			System.out.print("                                 비밀번호를 입력해주세요 : ");
			String kt_ps = scanner.nextLine();

			String kt_name;
			while (true) {
				System.out.println("                 이름 형식은 한글[2글자-4글자] or 영문[firstname lastname] 입니다. ");
				System.out.print("                                  이름을 입력해주세요 : ");
				kt_name = scanner.nextLine();
				if (hpdao.namecheck(kt_name) != false) {
					break;
				}
			}

			String kt_hpNumber;
			while (true) {
				System.out.println("                            전화번호 형식은 010-XXXX-XXXX 입니다.");
				System.out.print("                                  전화번호를 입력해주세요 : ");
				kt_hpNumber = scanner.nextLine();
				if (hpdao.numbercheck(kt_hpNumber) != false) {
					break;
				}
			}
			hpdao.hpcheck(new AgencyKt(kt_hpNumber));

			System.out
					.println("=======================================================================================");
			dao.insertKt(new AgencyKt(kt_id, kt_ps, kt_name, kt_hpNumber, 0, 0));
			View.startMethod();

		case 3:
			System.out
					.println("=======================================================================================");
			System.out.print("                                  아이디를 입력해주세요 : ");
			scanner.nextLine();
			String lgu_id = scanner.nextLine();
			dao.idcheck(new AgencyLgu(lgu_id));
			System.out.print("                                 비밀번호를 입력해주세요 : ");
			String lgu_ps = scanner.nextLine();

			String lgu_name;
			while (true) {
				System.out.println("                 이름 형식은 한글[2글자-4글자] or 영문[firstname lastname] 입니다. ");
				System.out.print("                                  이름을 입력해주세요 : ");
				lgu_name = scanner.nextLine();
				if (hpdao.namecheck(lgu_name) != false) {
					break;
				}
			}

			String lgu_hpNumber;
			while (true) {
				System.out.println("                            전화번호 형식은 010-XXXX-XXXX 입니다.");
				System.out.print("                                  전화번호를 입력해주세요 : ");
				lgu_hpNumber = scanner.nextLine();
				if (hpdao.numbercheck(lgu_hpNumber) != false) {
					break;
				}
			}
			hpdao.hpcheck(new AgencyLgu(lgu_hpNumber));

			System.out
					.println("=======================================================================================");
			dao.insertLgu(new AgencyLgu(lgu_id, lgu_ps, lgu_name, lgu_hpNumber, 0, 0));
			View.startMethod();
		case 4:
			View.startMethod();
			break;
			
		default:
			System.out
					.println("=======================================================================================");
			System.out.println("||                                   다시 입력하세요.                                ||");
			System.out
					.println("=======================================================================================");

			subscribe();
		}
		scanner.close();
	}
}