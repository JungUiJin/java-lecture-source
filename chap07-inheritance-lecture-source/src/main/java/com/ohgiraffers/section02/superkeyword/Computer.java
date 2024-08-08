package com.ohgiraffers.section02.superkeyword;

import java.util.Date;

public class Computer extends Product{
    private String cpu;
    private int ram;
    private int hdd;
    private String operatingSystem;

    public Computer() {

    }

    public Computer(String cpu, int ram, int hdd, String operatingSystem) {
        super();
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.operatingSystem = operatingSystem;
        System.out.println("Computer Class의 모든 필드 초기화 생성자 호출");
    }

    public Computer(String code, String name, String brand, int price, Date manufactureDate, String cpu, int ram, int hdd, String operatingSystem) {
        super(code, name, brand, price, manufactureDate);
        // 생성자를 this로 호출 한다는 것은 super를 두 번 호출하는 것과 같다. 따라서 허용되지 않는다.
//        this(cpu, ram, hdd, operatingSystem);
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.operatingSystem = operatingSystem;
        System.out.println("Product 클래스와 Computer 클래스의 모든 필드 초기화하는 생성자 호출.");
    }

    /* 부모 필드에 직접 접근은 불가하지만 getter, setter 메소드는 자신의 것처럼 사용 가능하므로
    *  자식 클래스에서 추가된 필드에 대해서만 getter setter를 작성한다. */

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String getInformation() {
        // 부모 클래스의 private 멤버에는 직접 접근 불가하므로 getter 메소드로 접근한다.
        // super, this 모두 사용 가능하며, 생략하면 this. 의 의미이다.
        // 다만 코드의 의미를 명확히 하기 위해 super. 로 명시한다.

        // Product 에서 미리 명시된 getInformation 을 활용
        // super.getInformation 으로 작성할 것.
        return super.getInformation()+ " "
                + this.cpu + " " + this.ram + " " + this.hdd + " " + this.operatingSystem;
    }
}
