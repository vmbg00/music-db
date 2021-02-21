package bg.softuni.music_db.web;

import bg.softuni.music_db.security.CurrentUser;
import bg.softuni.music_db.services.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final AlbumService albumService;

    public HomeController(CurrentUser currentUser, AlbumService albumService) {
        this.currentUser = currentUser;
        this.albumService = albumService;
    }

    @GetMapping("/")
    public String index(Model model){
        if (currentUser.isAnonymous()){
            return "index";
        }
        model.addAttribute("albums", this.albumService.getAlbums());
        model.addAttribute("totalCopies", this.albumService.copiesSum());

        return "home";
    }

    @GetMapping("/albums/delete/{id}")
    public String delete(@PathVariable Long id){
        this.albumService.delete(id);

        return "redirect:/";
    }
}
