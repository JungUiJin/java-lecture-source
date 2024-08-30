package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application1 {
    public static void main(String[] args) {
        /* 필터 스트림 : 기반 스트림에 추가 되어 성능 향상 기능 추가
        *  BufferReader/Writer 버퍼 공간을 이용하여 데이터를 쌓아 두었다가 입출력하여 입출력 횟수를 줄이고 성능을 향상 */

        BufferedWriter bw = null;
        try{
            /* 보조 스트림 객체 생성 시에는 생성자의 인자로 연결 될 기반 스트림을 전달한다. */
            bw = new BufferedWriter(new FileWriter("testBurffered.txt"));

            bw.write("This is a test\n");
            bw.write("hi hi\n");
            bw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                /* 버퍼를 이용하는 경우 버퍼가 가득 차면 자동으로 내보내기를 하지만 가득 차지 않은 경우 flush로 내보내기 해줘야 한다. */
                /* close를 사용하면 flush를 실행하고 난 뒤 자원을 반납한다. */
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try(BufferedReader br = new BufferedReader(new FileReader("testBurffered.txt"))){
            /* reaLine 메소드 기능을 추가로 제공한다.
            *  버퍼의 한 줄을 읽어와서 문자열로 반환하며 더 이상 읽어올 값이 없을 경우 null이 반환된다.*/
            String temp;
            while((temp = br.readLine()) != null){
                System.out.println(temp);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
