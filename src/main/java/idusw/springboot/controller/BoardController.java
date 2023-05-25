package idusw.springboot.controller;


import idusw.springboot.domain.Board;
import idusw.springboot.domain.Member;
import idusw.springboot.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boards")
public class BoardController {
    HttpSession session = null;
    private BoardService boardService;
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping(value = {"/",""})
    public String getBoardList(Model model){
        model.addAttribute("key", "value");
        return "/boards/list";
    }

    @GetMapping("/reg-form")
    public String getRegisterFrom(Model model) {
        model.addAttribute("board", Board.builder().build());
        model.addAttribute("member", Member.builder().build());
        return "/members/register";
    }

    @PostMapping("/register")
    public String createMember(@ModelAttribute("board") Board board, Model model, HttpServletRequest request) {
        session = request.getSession();
        Member member = (Member) session.getAttribute("mb");
        if(member != null) {
            board.setWriterSeq(member.getSeq());
            board.setWriterEmail(member.getEmail());
            board.setWriterName(member.getName());
            if (boardService.registerBoard(board) > 0)
                return "redircet:/";
            else
                return "/errors/404"; //예외 처리 화면

        }else
            return "/redirect:/members/reg-form";
    }
}
