package login;

import java.util.Scanner;

import agency.AgencyKt;
import agency.AgencyLgu;
import agency.AgencySkt;
import dao.LoginDAO;
import data.Data;
import main.View;

public class Login {

	public static void login() throws Exception {

		Scanner scanner = new Scanner(System.in);
		LoginDAO dao = new LoginDAO();
		System.out.println("=======================================================================================");
		System.out.println("||                                통신사를 선택하세요.                               ||");
		System.out.println("||        SKT - 1번         KT - 2번         LGU - 3번        이전메뉴 - 4번         ||");
		System.out.println("=======================================================================================");
		try {
			System.out.print("                                       선택 : ");
			int input = scanner.nextInt();
			switch (input) {
			case 1:
				AgencySkt logInSKT;
				System.out.println(
						"=======================================================================================");
				System.out.print("                                    아이디 : ");
				String sk_id = scanner.next();
				System.out.print("                                   비밀번호 : ");
				String sk_ps = scanner.next();
				System.out.println(
						"=======================================================================================");
				try {
					logInSKT = dao.logInSk(sk_id, sk_ps);
					System.out.println(
							"=======================================================================================");
					System.out.println("                                 반갑습니다. " + logInSKT.getName()
							+ "님!                                 ");
					System.out.println(
							"=======================================================================================");

				} catch (java.lang.NullPointerException e) {
					System.out.println(
							"=======================================================================================");
					System.out.println("||                    잘 못 입력 했습니다. 다시 입력해주세요.                        ||");
					System.out.println(
							"=======================================================================================");
					login();
				} catch (java.util.NoSuchElementException e) {
					System.out.println(
							"=======================================================================================");
					System.out.println("||                    잘 못 입력 했습니다. 다시 입력해주세요.                        ||");
					System.out.println(
							"=======================================================================================");
					login();
				}

				finally {
					Data.getterData(1, sk_id, sk_ps);
				}

			case 2:
				AgencyKt logInKT;
				System.out.println(
						"=======================================================================================");
				System.out.print("                                    아이디 : ");
				String kt_id = scanner.next();
				System.out.print("                                   비밀번호 : ");
				String kt_ps = scanner.next();
				System.out.println(
						"=======================================================================================");
				try {
					logInKT = dao.logInKT(kt_id, kt_ps);
					System.out.println(
							"=======================================================================================");
					System.out.println("                                 반갑습니다. " + logInKT.getName()
							+ "님!                                 ");
					System.out.println(
							"=======================================================================================");
				} catch (java.lang.NullPointerException e) {
					System.out.println(
							"=======================================================================================");
					System.out.println("||                    잘 못 입력 했습니다. 다시 입력해주세요.                        ||");
					System.out.println(
							"=======================================================================================");
					login();
				} catch (java.util.NoSuchElementException e) {
					System.out.println(
							"=======================================================================================");
					System.out.println("||                    잘 못 입력 했습니다. 다시 입력해주세요.                        ||");
					System.out.println(
							"=======================================================================================");
					login();
				} finally {
					Data.getterData(2, kt_id, kt_ps);
				}

			case 3:
				AgencyLgu logInLGU;
				System.out.println(
						"=======================================================================================");
				System.out.print("                                    아이디 : ");
				String lgu_id = scanner.next();
				System.out.print("                                   비밀번호 : ");
				String lgu_ps = scanner.next();
				System.out.println(
						"=======================================================================================");
				try {
					logInLGU = dao.logInLGU(lgu_id, lgu_ps);
					System.out.println(
							"=======================================================================================");
					System.out.println("                                 반갑습니다. " + logInLGU.getName()
							+ "님!                                 ");
					System.out.println(
							"=======================================================================================");

				} catch (java.lang.NullPointerException e) {
					System.out.println(
							"=======================================================================================");
					System.out.println("||                    잘 못 입력 했습니다. 다시 입력해주세요.                        ||");
					System.out.println(
							"=======================================================================================");
					login();
				} catch (java.util.NoSuchElementException e) {
					System.out.println(
							"=======================================================================================");
					System.out.println("||                    잘 못 입력 했습니다. 다시 입력해주세요.                        ||");
					System.out.println(
							"=======================================================================================");
					login();
				} finally {
					Data.getterData(3, lgu_id, lgu_ps);
					
				}
			case 4: 
				View.startMethod();
				break;
			default:
				System.out.println(
						"=======================================================================================");
				System.out.println("||                                  다시 입력하세요.                                 ||");
				System.out.println(
						"=======================================================================================");
				login();
				break;
			}
			scanner.close();
		} catch (java.util.InputMismatchException e) {
			System.out
					.println("=======================================================================================");
			System.out.println("||                    잘 못 입력 했습니다. 다시 입력해주세요.                        ||");
			System.out
					.println("=======================================================================================");
			login();
			
		}

	}
}
