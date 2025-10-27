package racingcar;

public class Car {

    private String name;
    private int count;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    private String counting(){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return name+" : "+counting()+"\n";
    }


}
