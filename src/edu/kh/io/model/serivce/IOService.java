package edu.kh.io.model.serivce;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOService {

	// IO
	
	// Input(입력) : 외부 -> 내부로 데이터를 들여오는 것
	// Output(출력) : 내부 -> 외부로 데이터를 내보내는 것
	
	// Stream : 입/출력 통로 역할(데이터가 흘러가는 통로) 
	//   		기본적으로 Stream은 단방향
	
	// 1) 파일 출력 (내부 == 프로그램, 외부 == 파일)
	public void output1() {
		
		// 바이트 기반 스트림 이용
		FileOutputStream fos = null;
		
		// FileOutputStream 객체 생성 시
		// FileNotFountException / IOException 예외가 발생할 가능성이 있음 -> 예외처리 필요
		try {
			
			fos = new FileOutputStream("test1.txt");
			// 현재 프로그램에서 test1.txt 파일로 출력하는 통로 객체 생성
		
		// 파일에 "Hello"내보내기
		String str = "Hello";
		
		 for (int i = 0; i < str.length(); i++) {
			 
			 // "Hello"를 한문자씩 끊어서 파일로 출력하기
			 fos.write(str.charAt(i));
			 
			 // write()는 IOException을 발생시킬 가능성이 있다.
			 
		}
					
					
		} catch(IOException e) {
			System.out.println("예외 발생");
			e.printStackTrace(); // 예외 추적
		
		} finally {
			
			// 예외가 발생 하든 말든 무조건 수행
			
			// 사용한 스트림 자원 반환(통로 없앰) --> 필수 작성!!!
			// 프로그램 메모리 관리 차원에서 항상 다쓰면 끊어줌
			// -> 작성 안하면 문제점으로 꼽을 수 있다!
			try {
			fos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	
}
