package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.CarController.validateNameLength;


public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = Console.readLine();
            System.out.println("시도할 횟수는 몇 회인가요?");
            int count = Integer.parseInt(Console.readLine());
            if (count < 1) {
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상의 숫자여야 합니다.");
            }
            CarController carController = new CarController();
            carController.run(input,count);
        }catch (NumberFormatException e) {
            System.err.println("[ERROR] 시도 횟수는 숫자만 입력해야 합니다.");
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 숫자 형식입니다.", e);

        } catch (IllegalArgumentException e) {

            throw e;

        }
    }



    private static void check1(String[] parts) {
        if (parts.length < 2) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 잘못되었습니다.");
        }
    }
}
