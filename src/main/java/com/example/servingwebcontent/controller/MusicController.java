package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.DTO.MusicDTO;
import com.example.servingwebcontent.domain.Music;
import com.example.servingwebcontent.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.StreamSupport;

@Controller
public class MusicController {

    @Autowired
    MusicService musicService;

    @GetMapping("/musics")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {

        Iterable<Music> musics = musicService.find(filter);
        if (StreamSupport.stream(musics.spliterator(), false).count() == 0) {
            model.addAttribute("emptyMessage", true);
        }

        model.addAttribute("musics", musics)
                .addAttribute("filter", filter)
                .addAttribute("categories", musicService.getCategories())
                .addAttribute("types", musicService.getTypes());
        return "musics";
    }


    @PostMapping("/musics")
    public String add(MusicDTO musicDTO, Model model) {
        if (musicService.isUnique(musicDTO)) {
                musicService.save(musicDTO);
                return "redirect:/musics";
            } else {
                model.addAttribute("message", true)
                        .addAttribute("musics", musicService.findAll())
                        .addAttribute("categories", musicService.getCategories())
                        .addAttribute("types", musicService.getTypes())
                        .addAttribute("tempMusic", musicDTO);
                return "musics";
            }
    }

    @PostMapping("/musics/delete")
    public String delete(@RequestParam Long id){
        musicService.delete(id);
        return "redirect:/musics";
    }

    @GetMapping("musics/edit/{id}")
    public String getEditPage(@PathVariable Long id, Model model) {
        model.addAttribute("musics", musicService.findById(id))
                .addAttribute("categories", musicService.getCategories())
                .addAttribute("types", musicService.getTypes());
        return "musicEdit";
    }

    @PostMapping("musics/edit")
    public String musicsEdit(MusicDTO musicDTO, Model model) {
        if (musicService.isUnique(musicDTO)) {
            musicService.edit(musicDTO);
            return "redirect:/musics";
        } else {
            Music music = musicService.findExists(musicDTO);
            model.addAttribute("musics", music)
                    .addAttribute("categories", musicService.getCategories())
                    .addAttribute("types", musicService.getTypes())
                    .addAttribute("message", true);
            return "musicEdit";
        }
    }
}
