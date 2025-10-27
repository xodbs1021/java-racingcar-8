package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

public class CarController {
    List<Car> cars=new ArrayList<>();



    public void run(String input,int count) {
        String[] split = getStrings(input);
        validateNameLength(split);
        addCar(split);
        racing(count);
    }

    private static String[] getStrings(String input) {
        String[] split = input.trim().split(",");
        String[] trimmedSplit = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            trimmedSplit[i] = split[i].trim();
        }
        return split;
    }

    public static void validateNameLength(String[] split) {
        for (String s : split) {
            if(s.length()>5) {
                throw new IllegalArgumentException("글자수가 초과하였습니다");
            }
        }
    }
    private void addCar(String[] split) {
        for (String s : split) {
            cars.add(new Car(s));
        }
    }

    private void racing(int count){
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
             randomCount();
             result();
        }
        finalResult();
    }

    private void randomCount() {
        for (Car car : cars) {
            int i = Randoms.pickNumberInRange(0, 9);
            System.out.println("i = " + i);
            if(i>=4){
                car.setCount(car.getCount()+1);
            }

        }
    }

    private void result() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private void finalResult() {
        Collections.sort(cars, Comparator.comparing(Car::getCount).reversed());

        int maxCount = cars.get(0).getCount();

        StringBuilder winnerBuilder = new StringBuilder();

        for (Car car : cars) {
            if (car.getCount() == maxCount) {
                if (winnerBuilder.length() > 0) {
                    winnerBuilder.append(", ");
                }
                winnerBuilder.append(car.getName());
            } else {
                break;
            }
        }

        System.out.println("최종 우승자 : " + winnerBuilder.toString());
    }

}
