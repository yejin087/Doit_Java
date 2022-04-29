package com.mybatis.board;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mybatis.dto.BoardDTO;
import com.mybatis.dto.PageVO;
import com.mybatis.model.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	BoardService service;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@PostMapping("insert")
	public String insert(BoardDTO board) {
		service.insert(board);
		return "redirect:list";
	}

	@GetMapping("insert")
	public String insertget(BoardDTO board) {
		return "boardInsert";
	}

	@GetMapping({ "/", "list" }) // root, list url������ ����
	public String list(Model model, String pageNum, @RequestParam(name = "field", defaultValue = "") String field,
			@RequestParam(name = "word", defaultValue = "") String word) {

		// ���� ������, �������� ������ 1, �ִٸ� parse Int �� pageNum
		int currentPage = pageNum == null ? 1 : Integer.parseInt(pageNum);
		// �ѹ��� ������ �Խñ� ��
		int pageSize = 5;
		// hashmap�� ���� value ������ String, int �ΰ��� �̹Ƿ� Object�� ����
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		// �� ������ �������� start ��ȣ���� pageSize ��ŭ �Խñ��� ������ �´�
		hm.put("start", (currentPage - 1) * pageSize); // ������ ������ ���۵Ǵ� ��ȣ
		hm.put("pageSize", pageSize);

		List<BoardDTO> board_list = service.findAll(hm);
		int count = service.getCount(hm);
		PageVO page = new PageVO(count, currentPage, pageSize);
//		page.setField(field);
//		page.setWord(word);

		model.addAttribute("board_list", board_list);
		model.addAttribute("count", count);
		model.addAttribute("p", page);
		return "boardList";
	}

	@GetMapping("view/{num}")
	public String view(@PathVariable int num, Model model) {
		model.addAttribute("board", service.findByNum(num));
		return "boardView";
	}

	@DeleteMapping("delete/{num}")
	@ResponseBody
	public String delete(@PathVariable int num) {
		service.delete(num);
		return "success";
	}

	@GetMapping("update/{num}")
	public String update(@PathVariable int num, Model model) {

		model.addAttribute("board", service.findByNum(num));
		return "boardUpdate";
	}

	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody BoardDTO board) {
		service.update(board);
		return "success update";
	}

}
