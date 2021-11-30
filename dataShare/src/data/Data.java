package data;

import java.util.Scanner;

import agency.AgencyKt;
import agency.AgencyLgu;
import agency.AgencySkt;
import dao.ChargeDAO;
import dao.LoginDAO;
import dao.TerminateDAO;
import dao.TransmissionDAO;
import dao.UpdateDAO;
import main.View;

public class Data {
	static Scanner scanner = new Scanner(System.in);
	// 자주 사용할 것들은 값을 고정
	private static int myAgency;
	private static String myId;
	private static String mypassword;

	public static void getterData(int agency, String mainId, String password) throws Exception {
		myId = mainId; // 아이디 고정
		myAgency = agency; // 통신사 고정
		mypassword = password; // 비밀번호 고정
		setterData();
	}

	public static void setterData() throws Exception {
		try {
			System.out
					.println("=======================================================================================");
			System.out.println("||                             원하는 메뉴를 선택하세요.                             ||");
			System.out.println("||          1. 데이터 조회           2. 데이터 충전           3. 데이터 보내기       ||");
			System.out.println("||                    4. 회원 정보 변경           5. 로그아웃                        ||");
			System.out
					.println("=======================================================================================");
			System.out.print("                                       선택 : ");
			int input = scanner.nextInt();
			switch (input) {
			// 데이터조회
			case 1:
				try {
					check();
				} catch (java.lang.NullPointerException e) {
				} catch (java.util.NoSuchElementException e) {
				} finally {
					setterData();

				}

				// 데이터충전
			case 2:
				charge();
				setterData();
				break;
			// 데이터보내기
			case 3:
				try {
					transmission();
				} catch (java.lang.StackOverflowError e) {
					System.out.println("잘못 입력 하셨습니다.");
					Data.setterData();
				} finally {
					setterData();
				}
				break;
			case 4:
				update();
				setterData();
				break;
			case 5:
				System.out.println(
						"=======================================================================================");
				System.out.println("||                               초기 화면으로 돌아갑니다.                           ||");
				System.out.println(
						"=======================================================================================");
				View.startMethod();
				break;
			}
		} catch (java.util.InputMismatchException e) {
			System.out
					.println("=======================================================================================");
			System.out.println("||                       잘못 입력 했습니다. 다시 입력해주세요.                      ||");
			System.out
					.println("=======================================================================================");
			setterData();
		} catch (java.lang.StackOverflowError e) {
			System.out
					.println("=======================================================================================");
			System.out.println("||                       잘못 입력 했습니다. 다시 입력해주세요.                      ||");
			System.out
					.println("=======================================================================================");
			setterData();
		}
	}

	private static void check() throws Exception {
		LoginDAO dao = new LoginDAO();
		switch (myAgency) {
		case 1:
			AgencySkt logInSKT = dao.logInSk(myId, mypassword);
			System.out
					.println("=======================================================================================");
			System.out.println("             이름             핸드폰번호            보유데이터          요금         ");
			System.out.print("             " + logInSKT.getName());
			System.out.print("           " + logInSKT.getHpNumber());
			System.out.print("               " + logInSKT.getData());
			System.out.print("           " + logInSKT.getFee() + "\n");
			System.out
					.println("=======================================================================================");
			System.out.println("");
			break;
		case 2:
			AgencyKt logInKT = dao.logInKT(myId, mypassword);
			System.out
					.println("=======================================================================================");
			System.out.println("             이름             핸드폰번호            보유데이터          요금         ");
			System.out.print("             " + logInKT.getName());
			System.out.print("           " + logInKT.getHpNumber());
			System.out.print("               " + logInKT.getData());
			System.out.print("           " + logInKT.getFee() + "\n");
			System.out
					.println("=======================================================================================");
			System.out.println("");

			break;
		case 3:
			AgencyLgu logInLGU = dao.logInLGU(myId, mypassword);
			System.out
					.println("=======================================================================================");
			System.out.println("             이름             핸드폰번호            보유데이터          요금         ");
			System.out.print("             " + logInLGU.getName());
			System.out.print("           " + logInLGU.getHpNumber());
			System.out.print("               " + logInLGU.getData());
			System.out.print("           " + logInLGU.getFee() + "\n");
			System.out
					.println("=======================================================================================");
			System.out.println("");

			break;
		}
	}

	private static void charge() throws Exception {
		ChargeDAO dao = new ChargeDAO();
		switch (myAgency) {
		case 1:
			System.out
					.println("=======================================================================================");
			System.out.println("                      충전할 데이터량은 MB단위로 입력하세요");
			System.out.println("                           요금은 100MB당 2000원 입니다.");
			System.out.print("                              충전할 데이터량 입력: ");
			int sk_data = scanner.nextInt();
			dao.updateSKT(new AgencySkt(myId, mypassword, sk_data));
			System.out
					.println("=======================================================================================");
			System.out.println("");
			break;

		case 2:
			System.out
					.println("=======================================================================================");
			System.out.println("                      충전할 데이터량은 MB단위로 입력하세요");
			System.out.println("                           요금은 100MB당 2000원 입니다.");
			System.out.print("                              충전할 데이터량 입력: ");
			int kt_data = scanner.nextInt();
			dao.updateKT(new AgencyKt(myId, mypassword, kt_data));
			System.out
					.println("=======================================================================================");
			System.out.println("");
			break;

		case 3:
			System.out
					.println("=======================================================================================");
			System.out.println("                      충전할 데이터량은 MB단위로 입력하세요");
			System.out.println("                           요금은 100MB당 2000원 입니다.");
			System.out.print("                              충전할 데이터량 입력: ");
			int lgu_data = scanner.nextInt();
			dao.updateLGU(new AgencyLgu(myId, mypassword, lgu_data));
			System.out
					.println("=======================================================================================");
			System.out.println("");
			break;

		default:
			System.out
					.println("=======================================================================================");
			System.out.println("||                              다시 입력하세요.                                     ||");
			System.out
					.println("=======================================================================================");
		}
	}

	public static void transmission() throws Exception {
		// 데이터 보내기 - 데이터량, 아이디랑, 받는 핸드폰번호
		TransmissionDAO dao = new TransmissionDAO();
		switch (myAgency) {
		case 1:
			System.out
					.println("=======================================================================================");
			System.out.println("                        전화번호 형식은 010-XXXX-XXXX 입니다.");
			System.out.print("                         받는분의 핸드폰 번호를 입력하세요 : ");
			String sk_hpNum = scanner.next();
			System.out.print("                            보낼 데이터 량은 입력하세요 : ");
			int sk_data = scanner.nextInt();
			dao.transmissionSKT(new AgencySkt(myId, sk_hpNum, sk_data));
			System.out
					.println("=======================================================================================");
			System.out.println("");
			break;
		case 2:
			System.out
					.println("=======================================================================================");
			System.out.println("                        전화번호 형식은 010-XXXX-XXXX 입니다.");
			System.out.print("                         받는분의 핸드폰 번호를 입력하세요 : ");
			String kt_hpNum = scanner.next();
			System.out.print("                            보낼 데이터 량은 입력하세요 : ");
			int kt_data = scanner.nextInt();
			dao.transmissionKT(new AgencyKt(myId, kt_hpNum, kt_data));
			System.out
					.println("=======================================================================================");
			System.out.println("");
			break;
		case 3:
			System.out
					.println("=======================================================================================");
			System.out.println("                        전화번호 형식은 010-XXXX-XXXX 입니다.");
			System.out.print("                         받는분의 핸드폰 번호를 입력하세요 : ");
			String lgu_hpNum = scanner.next();
			System.out.print("                            보낼 데이터 량은 입력하세요 : ");
			int lgu_data = scanner.nextInt();
			dao.transmissionLGU(new AgencyLgu(myId, lgu_hpNum, lgu_data));
			System.out
					.println("=======================================================================================");
			System.out.println("");
			break;
		}
	}

	public static void update() throws Exception {
		UpdateDAO dao = new UpdateDAO();
		System.out.println("=======================================================================================");
		System.out.println("||                             원하는 메뉴를 선택하세요.                             ||");
		System.out.println("||    1. 핸드폰 번호 변경      2. 비밀번호 변경      3. 회원탈퇴      4. 이전 메뉴   ||");
		System.out.println("=======================================================================================");
		System.out.print("                                       선택 : ");
		int input = scanner.nextInt();
		switch (input) {
		case 1:
			scanner.nextLine();
			if (myAgency == 1) {
				System.out.println(
						"=======================================================================================");
				System.out.println("                      전화번호 형식은 010-XXXX-XXXX 입니다.");
				System.out.print("                       변경하실 핸드폰 번호를 입력하세요 : ");
				String sk_hpNum = scanner.nextLine();
				System.out.println(
						"=======================================================================================");
				dao.updateSktHpNum(new AgencySkt(myId, mypassword, sk_hpNum));
			} else if (myAgency == 2) {
				System.out.println(
						"=======================================================================================");
				System.out.println("                      전화번호 형식은 010-XXXX-XXXX 입니다.");
				System.out.print("                       변경하실 핸드폰 번호를 입력하세요 : ");
				String kt_hpNum = scanner.nextLine();
				System.out.println(
						"=======================================================================================");
				dao.updateKtPW(new AgencyKt(myId, mypassword, kt_hpNum));
			} else if (myAgency == 3) {
				System.out.println(
						"=======================================================================================");
				System.out.println("                      전화번호 형식은 010-XXXX-XXXX 입니다.");
				System.out.print("                       변경하실 핸드폰 번호를 입력하세요 : ");
				String lgu_hpNum = scanner.nextLine();
				System.out.println(
						"=======================================================================================");
				dao.updateLguPW(new AgencyLgu(myId, mypassword, lgu_hpNum));
			}
			setterData();
			break;
		case 2:
			scanner.nextLine();
			if (myAgency == 1) {
				System.out.println(
						"=======================================================================================");
				System.out.print("                     변경하실 비밀번호를 입력하세요 : ");
				String sk_pw = scanner.nextLine();
				System.out.println(
						"=======================================================================================");
				dao.updateSktPW(new AgencySkt(myId, sk_pw));
			} else if (myAgency == 2) {
				System.out.println(
						"=======================================================================================");
				System.out.print("                     변경하실 비밀번호를 입력하세요 : ");
				String kt_pw = scanner.nextLine();
				System.out.println(
						"=======================================================================================");
				dao.updateKtPW(new AgencyKt(myId, kt_pw));
			} else if (myAgency == 3) {
				System.out.println(
						"=======================================================================================");
				System.out.print("                     변경하실 비밀번호를 입력하세요 : ");
				String lgu_pw = scanner.nextLine();
				System.out.println(
						"=======================================================================================");
				dao.updateLguPW(new AgencyLgu(myId, lgu_pw));
			}
			setterData();
			break;

		case 3:
			TerminateDAO tdao = new TerminateDAO();
			scanner.nextLine();
			if (myAgency == 1) {
				System.out.println(
						"=======================================================================================");
				System.out.print("                  탈퇴하실 회원의 비밀번호를 입력하세요 : ");
				String sk_pw = scanner.nextLine();
				System.out.println(
						"=======================================================================================");
				tdao.terminateSkt(new AgencySkt(myId, sk_pw));
			} else if (myAgency == 2) {
				System.out.println(
						"=======================================================================================");
				System.out.print("                  탈퇴하실 회원의 비밀번호를 입력하세요 : ");
				String kt_pw = scanner.nextLine();
				System.out.println(
						"=======================================================================================");
				tdao.terminateKt(new AgencyKt(myId, kt_pw));
			} else if (myAgency == 3) {
				System.out.println(
						"=======================================================================================");
				System.out.print("                  탈퇴하실 회원의 비밀번호를 입력하세요 : ");
				String lgu_pw = scanner.nextLine();
				System.out.println(
						"=======================================================================================");
				tdao.terminateLgu(new AgencyLgu(myId, lgu_pw));
			}
			View.startMethod();
			break;

		case 4:
			setterData();
			break;

		default:
			System.out
					.println("=======================================================================================");
			System.out.println("||                          잘못된 값을 입력하셨습니다.                              ||");
			System.out
					.println("=======================================================================================");
			update();
			break;
		}
	}

}