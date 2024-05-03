package Week4;

import java.util.Scanner;

class Phone {
    private String name; // 이름 필드
    private String tel; // 전화번호 필드

    // 생성자
    public Phone(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    // 이름과 전화번호를 반환하는 getter 메소드
    public String getName() {
        return name;
    }
    public String getTel() {
        return tel;
    }
}

class PhoneBook {
    private Phone[] phones; // Phone 객체 배열
    private Scanner scanner = new Scanner(System.in); // 입력을 위한 Scanner 객체

    // 인원수에 따른 Phone 객체 배열 생성
    public PhoneBook() {
        int number;
        while(true) {
            number = scanner.nextInt();
            if(number > 0) {
                phones = new Phone[number];
                break;
            }
        }
        scanner.nextLine(); // 숫자 입력 후 남은 개행 문자 처리
    }

    // Phone 정보를 입력받고 저장하는 메소드
    public void run() {
        for(int i = 0; i < phones.length; i++) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            phones[i] = new Phone(parts[0], parts[1]);
        }
        System.out.println("저장되었습니다...");

        // 이름으로 전화번호 검색
        while(true) {
            String name = scanner.nextLine();
            if(name.equals("그만")) break;

            boolean found = false;
            for(Phone phone : phones) {
                if(phone.getName().equals(name)) {
                    System.out.println(name + "의 번호는 " + phone.getTel() + " 입니다.");
                    found = true;
                    break;
                }
            }
            if(!found) {
                System.out.println(name + " 이 없습니다.");
            }
        }
    }
}

public class PhoneBookClass {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.run();
    }
}