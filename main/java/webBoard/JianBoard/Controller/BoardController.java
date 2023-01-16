package webBoard.JianBoard.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webBoard.JianBoard.domain.Board;
import webBoard.JianBoard.domain.Member;
import webBoard.JianBoard.service.BoardService;
import webBoard.JianBoard.service.MemberService;

@Controller
@RequestMapping("/board/**")
@RequiredArgsConstructor // 추가1
public class BoardController {

    private final BoardService serviceB; //추가2
    private final MemberService serviceM; //추가2

    @GetMapping("/hello")
    public String Hello() {
        return "/boards/hello";
    }

    // 추가3
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("cnt", serviceB.boardCount());
        model.addAttribute("test", serviceB.boardList());

        return "/boards/hello";
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("list", serviceB.boardList());

        return "/boards/main";
    }

    @GetMapping("/view")
    public String viewBoard(Model model, Long boardID){
        model.addAttribute("view",serviceB.getBoard(boardID));
        return "/boards/view";
    }

    @GetMapping("/upload")
    public String uploadBoardForm(){
        return "/boards/upload";
    }
    @PostMapping("/upload")
    public String uploadBoard(Board board){
        serviceB.uploadBoard(board);
        return "redirect:/board/main";
    }

    @PutMapping("/update")
    public String updateBoard(Board board){
        serviceB.updateBoard(board);
        return "redirect:/board/main";
    }
    @DeleteMapping("/delete")
    public String deleteBoard(Long boardID){
        serviceB.deleteBoard(boardID);
        return "redirect:/board/main";
    }

    @GetMapping("/sign-up")
    public String signUpForm(){
        return "/boards/sign-up";
    }
    @PutMapping("/sign-up")
    public String signUpBoard(Member member){
        serviceM.signUpBoard(member);
        return "redirect:/board/sign-in";
    }

    @GetMapping("/sign-in")
    public String signInForm(){
        return "/boards/sign-in";
    }
    @PostMapping("/sign-in")
    public String signInBoard(Member member){
        serviceM.signUpBoard(member);
        return "redirect:/board/main";
    }

//    @GetMapping("/upload")
//    public String uploadForm(Model model, String id){
//        model.addAttribute("member", serviceM.getMember(id));
//
//        return "/boards/main";
//    }
}