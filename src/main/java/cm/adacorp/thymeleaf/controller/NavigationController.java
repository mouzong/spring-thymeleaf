package cm.adacorp.thymeleaf.controller;

import cm.adacorp.thymeleaf.entity.Restaurant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class NavigationController {

    // Injection de la dependance du controlleur de restaurants
    private final RestaurantController restaurantController;

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("message-test", "Hi test offline Thymeleaf");
        return "index";
    }

    @GetMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("restaurants", restaurantController.getAll());
        return "home";
    }

    @GetMapping(value = "/all")
    public String getAllRestaurants(Model model) {
        model.addAttribute("restaurants", restaurantController.getAll());
        return "restaurants/all";
    }

    @GetMapping(value = "/create-new")
    public String nouveauRestaurant(@ModelAttribute Restaurant restaurant, Model model) {
        return "restaurants/create";
    }

    @PostMapping("/new")
    public String createRestaurant(@ModelAttribute Restaurant restaurant, Model model) {
        restaurantController.create(restaurant);
        return "redirect:/all";
    }


}
