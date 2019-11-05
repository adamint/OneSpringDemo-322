package one;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class OneController {
  @GetMapping("/")
  public String oneHome(HttpSession session, Model model) {
    @SuppressWarnings("unchecked")
    Map<Integer, String> transactions = (Map<Integer, String>) session.getAttribute("transactions");
    model.addAttribute("transactions", transactions);
    model.addAttribute("transactionNumber", transactions == null ? 0 : transactions.size());

    return "index";
  }

  @PostMapping("/add")
  public String add(@RequestParam("add") String add, HttpSession session) {
    @SuppressWarnings("unchecked")
    TreeMap<Integer, String> transactions = (TreeMap<Integer, String>) session.getAttribute("transactions");
    if (transactions == null) {
      transactions = new TreeMap<>();
      session.setAttribute("transactions", transactions);
    }

    int lastKey = transactions.size() > 0 ? transactions.lastKey() : 0;
    transactions.put(lastKey + 1, add);

    return "redirect:/";
  }

  @PostMapping("/delete")
  public String delete(@RequestParam("delete") int deleteKey, HttpSession session) {
    @SuppressWarnings("unchecked")
    Map<Integer, String> transactions = (Map<Integer, String>) session.getAttribute("transactions");
    transactions.remove(deleteKey);

    return "redirect:/";
  }
}
