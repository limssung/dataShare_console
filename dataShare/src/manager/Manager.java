package manager;

import java.util.List;
import java.util.Scanner;

import agency.AgencyKt;
import agency.AgencyLgu;
import agency.AgencyLog;
import agency.AgencySkt;
import dao.ManagerDAO;
import dao.TerminateDAO;
import main.View;

public class Manager {
	static Scanner scanner = new Scanner(System.in);

	public static void managerMode() throws Exception {

		System.out.println("=======================================================================================");
		System.out.println("      1. 수익조회        2. 회원 로그 조회         3. 회원 삭제        4. 초기메뉴     ");
		System.out.print("                                 원하는 메뉴를 선택하세요: ");
		int i = scanner.nextInt();
		System.out.println("=======================================================================================");
		switch (i) {
		case 1:
			select();
			break;
		case 2:
			selectLog();
			break;
		case 3:
			selectTerminate();
			break;
		case 4:
			View.startMethod();
			break;
		default:

		}
		scanner.close();
	}

	public static void select() throws Exception {
		System.out.println("=======================================================================================");
		System.out.println("||                                통신사를 선택하세요.                               ||");
		System.out.println("||        SKT - 1번         KT - 2번         LGU - 3번        이전메뉴 - 4번         ||");
		System.out.println("=======================================================================================");
		System.out.print("                                       선택 : ");
		int input = scanner.nextInt();
		switch (input) {
		case 1:
			ManagerDAO.managerSkt();
			break;
		case 2:
			ManagerDAO.managerKt();
			break;
		case 3:
			ManagerDAO.managerLgu();
			break;
		case 4:
			managerMode();
			break;
		default:
			System.out
					.println("=======================================================================================");
			System.out.println("||                               잘못된 입력을 하였습니다.                           ||");
			System.out
					.println("=======================================================================================");
		}
	}

	public static void selectLog() throws Exception {
		System.out.println("=======================================================================================");
		System.out.println("||                                통신사를 선택하세요.                               ||");
		System.out.println("||        SKT - 1번         KT - 2번         LGU - 3번        이전메뉴 - 4번         ||");
		System.out.println("=======================================================================================");
		System.out.print("                                       선택 : ");
		int input = scanner.nextInt();
		switch (input) {
		case 1:
			logSkt();
			managerMode();
			break;
		case 2:
			logKt();
			managerMode();
			break;
		case 3:
			logLgu();
			managerMode();
			break;
		case 4:
			managerMode();
			break;
		default:
			System.out
					.println("=======================================================================================");
			System.out.println("||                              회원 로그 기록이  없습니다.                          ||");
			System.out
					.println("=======================================================================================");
			managerMode();
			break;
		}

	}

	public static void logSkt() throws Exception {
		System.out.println("=======================================================================================");
		System.out.println("||                               조회할 SKT 회원 이름을 입력하세요.                  ||");
		System.out.println("=======================================================================================");
		System.out.print("                                       입력 : ");
		String id = scanner.next();
		ManagerDAO.logSkt(id);
		List<AgencyLog> list = ManagerDAO.logSkt(id);
		int fee = 0;
		for (AgencyLog log : list) {
			System.out
					.println("=======================================================================================");
			System.out.println(" 아이디    이름    증감데이터                  일시           통신사    타입      요금");
			System.out.print("  " + log.getId() + "       ");
			System.out.print(log.getName() + "       ");
			System.out.print(log.getData() + "              ");
			System.out.print(log.getDay() + "     ");
			System.out.print(log.getAgency() + "      ");
			System.out.print(log.getType() + "     ");
			System.out.print(log.getFee() + "\n");
			fee += log.getFee();
		}
		System.out.println("                     검색하신 회원의 총 요금은 " + fee + "원 입니다.");
		System.out.println("=======================================================================================");

	}

	public static void logKt() throws Exception {
		System.out.println("=======================================================================================");
		System.out.println("||                               조회할 KT 회원 이름을 입력하세요.                   ||");
		System.out.println("=======================================================================================");
		System.out.print("                                       입력 : ");
		String name = scanner.next();
		ManagerDAO.logKt(name);
		List<AgencyLog> list = ManagerDAO.logKt(name);
		int fee = 0;
		for (AgencyLog log : list) {
			System.out
					.println("=======================================================================================");
			System.out.println(" 아이디    이름    증감데이터                  일시           통신사    타입      요금");
			System.out.print("  " + log.getId() + "       ");
			System.out.print(log.getName() + "       ");
			System.out.print(log.getData() + "              ");
			System.out.print(log.getDay() + "     ");
			System.out.print(log.getAgency() + "      ");
			System.out.print(log.getType() + "     ");
			System.out.print(log.getFee() + "\n");
			fee += log.getFee();
		}

		System.out.println("                     검색하신 회원의 총 요금은 " + fee + "원 입니다.");
		System.out.println("=======================================================================================");

	}

	public static void logLgu() throws Exception {
		System.out.println("=======================================================================================");
		System.out.println("||                               조회할 LGU 회원 이름을 입력하세요.                  ||");
		System.out.println("=======================================================================================");
		System.out.print("                                       입력 : ");
		String name = scanner.next();
		ManagerDAO.logLgu(name);
		List<AgencyLog> list = ManagerDAO.logLgu(name);
		int fee = 0;
		for (AgencyLog log : list) {
			System.out
					.println("=======================================================================================");
			System.out.println(" 아이디    이름    증감데이터                  일시           통신사    타입      요금");
			System.out.print("  " + log.getId() + "       ");
			System.out.print(log.getName() + "       ");
			System.out.print(log.getData() + "              ");
			System.out.print(log.getDay() + "     ");
			System.out.print(log.getAgency() + "      ");
			System.out.print(log.getType() + "     ");
			System.out.print(log.getFee() + "\n");
			fee += log.getFee();
		}
		System.out.println("                     검색하신 회원의 총 요금은 " + fee + "원 입니다.");
		System.out.println("=======================================================================================");

	}

	public static void selectTerminate() throws Exception {
		System.out.println("=======================================================================================");
		System.out.println("||                                통신사를 선택하세요.                               ||");
		System.out.println("||        SKT - 1번         KT - 2번         LGU - 3번        이전메뉴 - 4번         ||");
		System.out.println("=======================================================================================");
		System.out.print("                                       선택 : ");
		int input = scanner.nextInt();
		TerminateDAO dao = new TerminateDAO();
		switch (input) {
		case 1:
			System.out
					.println("=======================================================================================");
			System.out.println("||                          삭제할 SKT 회원 아이디를 입력하세요.                     ||");
			System.out
					.println("=======================================================================================");
			System.out.print("                                       입력 : ");
			String sk_id = scanner.next();
			System.out
					.println("=======================================================================================");
			System.out.println("||                        삭제할 SKT 회원 핸드폰 번호를 입력하세요.                  ||");
			System.out
					.println("=======================================================================================");
			System.out.print("                                       입력 : ");
			String sk_hpNum = scanner.next();
			dao.terminateMSkt(new AgencySkt(sk_id, sk_hpNum));
			managerMode();
			break;
		case 2:
			System.out
					.println("=======================================================================================");
			System.out.println("||                          삭제할 KT 회원 아이디를 입력하세요.                      ||");
			System.out
					.println("=======================================================================================");
			System.out.print("                                       입력 : ");
			String kt_id = scanner.next();
			System.out
					.println("=======================================================================================");
			System.out.println("||                        삭제할 KT 회원 핸드폰 번호를 입력하세요.                   ||");
			System.out
					.println("=======================================================================================");
			System.out.print("                                       입력 : ");
			String kt_hpNum = scanner.next();
			dao.terminateMKt(new AgencyKt(kt_id, kt_hpNum));
			managerMode();
			break;

		case 3:
			System.out
					.println("=======================================================================================");
			System.out.println("||                          삭제할 LGU 회원 아이디를 입력하세요.                     ||");
			System.out
					.println("=======================================================================================");
			System.out.print("                                       입력 : ");
			String lgu_id = scanner.next();
			System.out
					.println("=======================================================================================");
			System.out.println("||                        삭제할 LGU 회원 핸드폰 번호를 입력하세요.                  ||");
			System.out
					.println("=======================================================================================");
			System.out.print("                                       입력 : ");
			String lgu_hpNum = scanner.next();
			dao.terminateMLgu(new AgencyLgu(lgu_id, lgu_hpNum));
			managerMode();
			break;

		case 4:
			managerMode();
			break;
		default:
			System.out
					.println("=======================================================================================");
			System.out.println("||                            일치하는 회원 기록이  없습니다.                        ||");
			System.out
					.println("=======================================================================================");
			managerMode();
			break;
		}
	}

}
