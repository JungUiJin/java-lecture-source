package com.ohgiraffers.section06.objectarray;

public class Application {
    public static void main(String[] args) {
        Car[] cars = new Car[5];

        // cars의 각 인덱스는 기본 값 null로 초기화 되어있기 때문에 인덱스별로 인스턴스를 생성해야 한다.

        cars[0] = new Car("현대",300);
        cars[1] = new Car("기아",300);
        cars[2] = new Car("쉐보레",300);
        cars[3] = new Car("르노",300);
        cars[4] = new Car("쌍용",300);

        // 배열은 반복문을 통해 일괄 처리가 가능하다는 장점이 있다.
        for (Car car : cars) {
            car.driveMaxSpeed();
        }
        // 객체 배열도 할당과 동시에 초기화 할 수 있다.
        Car[] cars2 = {
                new Car("현대",200),
                new Car("기아",100),
                new Car("쉐보레",200),
                new Car("르노",400),
                new Car("쌍용",100)
        };
        for (Car car : cars2) {
            car.driveMaxSpeed();
        }
    }
}
