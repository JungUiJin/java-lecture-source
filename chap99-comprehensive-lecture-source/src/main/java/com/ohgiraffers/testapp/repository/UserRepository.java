package com.ohgiraffers.testapp.repository;

import com.ohgiraffers.testapp.aggregate.BloodType;
import com.ohgiraffers.testapp.aggregate.User;
import com.ohgiraffers.testapp.stream.MyObjectOutputStream;

import java.io.*;
import java.util.ArrayList;

/* 데이터 입출력을 위해 만들어 지며 성공 또는 실패 여부를 반환 */
public class UserRepository {
    private final ArrayList<User> userList = new ArrayList<>();
    private static final String FILE_PATH = "src/main/java/com/ohgiraffers/testapp/db/userDB.dat";

    public UserRepository() {
        /* 객체 생성 시 동작할 내용
        * 1. 초기 회원 3명을 넣어 놓는다.
        * 2. 파일로부터 회원 정보를 가져온다.
        * 3. userList 에 담는다.*/

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            ArrayList<User> users = new ArrayList<>();
            users.add(new User(1, "id01", "pw01", 20, new String[]{"발레", "수영"}, BloodType.A));
            users.add(new User(2, "id02", "pw02", 25, new String[]{"축구", "영화", "독서"}, BloodType.B));
            users.add(new User(3, "id03", "pw03", 30, new String[]{"게임"}, BloodType.O));

            saveUsers(file, users);
        }

        loadUsers(file);

    }

    private void loadUsers(File file) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            while(true){
                userList.add((User)ois.readObject());
            }
        }catch (EOFException e){
            System.out.println("회원 정보를 모두 로딩하였습니다.");
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void saveUsers(File file, ArrayList<User> users) {
        try(ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file))) {
            for (User user : users) {
                ous.writeObject(user);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public ArrayList<User> selectAllUsers() {
        return userList;
    }

    public User selectUserByNo(int no) {
        for (User user : userList) {
            if (user.getNo() == no) {
                return user;
            }
        }
        return null;
    }

    public int selectLastUserNo() {
        User lastUser = userList.get(userList.size() - 1);
        return lastUser.getNo();
    }

    public int insertUser(User user) {
        int result = 0;
        try(MyObjectOutputStream moos = new MyObjectOutputStream(new FileOutputStream(FILE_PATH,true))){

            moos.writeObject(user);
            userList.add(user);
            result=1;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public int deleteUser(int no) {
        /* soft delete -> 상태값 변경
        *  hard delete -> 데이터 물리적 삭제 */
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getNo() == no){
                userList.remove(i);

                File file = new File(FILE_PATH);
                saveUsers(file, userList);

                return 1;
            }
        }

        return 0;
    }

    public int updateUser(User user) {
        for(int i=0;i<userList.size();i++){
            if(userList.get(i).getNo() == user.getNo()){
                userList.set(i, user);

                File file = new File(FILE_PATH);
                saveUsers(file, userList);

                return 1;
            }
        }
        return 0;
    }
}
