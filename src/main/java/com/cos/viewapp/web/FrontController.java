package com.cos.viewapp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


// RestController (데이터를 리턴한다) 데이터응답
// Controller (파일을 리턴한다) 파일응답

@Controller
public class FrontController {	// Controller에서는 전역변수 쓰지 말라 -> 충돌한다
	
	// http://localhost:8080/home
	// 디스패쳐 서블릿이 받는다 -> home 파싱 (파싱: 구문분석)
	// IoC 컨테이너에서 @RestController와 @Controller로 생성된 객체만 찾는다.
	// 메서드를 호출한다.
	
	@GetMapping("/home")
	public String home(Model model) {	// request == model
		// ViewResolver 클래스 => view를 보여주는 역할
		// src/main/resources/templates (prefix)
		// .mustache (suffix)
		// 디스패쳐 서블릿이 매개변수에 주입해준다.
		
		String name = "최주호";
		model.addAttribute("name", name);
		
		List<Board> boards = new ArrayList<>();
		boards.add(new Board(1, "제목1"));
		boards.add(new Board(2, "제목2"));
		
		model.addAttribute("boards", boards);
		
		return "home";	// RequestDispatcher 가 자동 작동
		
	}
}
