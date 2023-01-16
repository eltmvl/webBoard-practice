package webBoard.JianBoard.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webBoard.JianBoard.domain.Board;
import webBoard.JianBoard.service.BoardService;

@Controller
@RequestMapping("/board/**")
@RequiredArgsConstructor // 추가1
public class BoardController {

    private final BoardService service; //추가2

    @GetMapping("/hello")
    public String Hello() {
        return "/boards/hello";
    }

    // 추가3
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("cnt", service.boardCount());
        model.addAttribute("test", service.boardList());

        return "/boards/hello";
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("list", service.boardList());

        return "/boards/main";
    }

    @GetMapping("/view")
    public String viewBoard(Model model, Long boardID){
        model.addAttribute("view",service.getBoard(boardID));
        return "/boards/view";
    }

    @GetMapping("/upload")
    public String uploadBoardForm(){
        return "/boards/upload";
    }
    @PostMapping("/upload")
    public String uploadBoard(Board board){
        service.uploadBoard(board);
        return "redirect:/board/main";
    }

    @PutMapping("/update")
    public String updateBoard(Board board){
        service.updateBoard(board);
        return "redirect:/board/main";
    }
    @DeleteMapping("/delete")
    public String deleteBoard(Long boardID){
        service.deleteBoard(boardID);
        return "redirect:/board/main";
    }

    @GetMapping("/sign-up")
    public String signUpForm(){
        return "/boards/sign-up";
    }
    @PutMapping("/sign-up")
    public String signUpBoard(String id){
        service.signUpBoard(id);
        return "redirect:/board/sign-in";
    }

    @GetMapping("/sign-in")
    public String signInForm(){
        return "/boards/sign-in";
    }
    @PostMapping("/sign-in")
    public String signInBoard(String id){
        service.signUpBoard(id);
        return "redirect:/board/main";
    }
}