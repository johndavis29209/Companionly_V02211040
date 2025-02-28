package com.companionly.prototype.controllers;

import com.companionly.prototype.models.Mood;
import com.companionly.prototype.services.MoodService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class MoodController {

    private final MoodService moodService;

    public MoodController(MoodService moodService) {
        this.moodService = moodService;
    }

    @GetMapping("/mood")
    public String showMoods(Model model) {
        List<Mood> moods = moodService.getAllMoods();
        LocalDate today = LocalDate.now();

        // Check if mood was logged today
        boolean moodLoggedToday = moods.stream()
                .anyMatch(mood -> mood.getDate().equals(today));

        model.addAttribute("moodLoggedToday", moodLoggedToday);
        model.addAttribute("moods", moods);
        return "mood";  // This will render the moodtracker page
    }

    @GetMapping("/add")
    public String addMoodForm(Model model) {
        model.addAttribute("mood", new Mood());
        return "add-mood";
    }

    @PostMapping("/save")
    public String saveMood(@ModelAttribute("mood") Mood mood) {
        if (mood.getId() != null) {
            mood.setId(null);  // Clear the ID to ensure it's a new entry
        }


        moodService.saveMood(mood);
        return "redirect:/mood";
    }


    @GetMapping("/edit/{id}")
    public String editMoodForm(@PathVariable Long id, Model model) {
        Optional<Mood> mood = moodService.getMoodById(id);
        if (mood.isPresent()) {
            model.addAttribute("mood", mood.get());
            return "edit-mood";
        } else {
            return "redirect:/mood";
        }
    }

    @PostMapping("/update/{id}")
    public String updateMood(@PathVariable Long id, @ModelAttribute("mood") Mood mood) {
        mood.setId(id); // Ensure the ID is set correctly
        moodService.saveMood(mood); // Save the updated mood
        return "redirect:/mood"; // Redirect to the main page
    }
    @GetMapping("/delete/{id}")
    public String deleteMood(@PathVariable Long id) {
        moodService.deleteMood(id);
        return "redirect:/mood";
    }
    @GetMapping("/stats")
    public String showStatistics(Model model) {
        List<Mood> moods = moodService.getAllMoods();
        model.addAttribute("moods", moods); // Pass the moods to the view
        model.addAttribute("averageMood", moodService.getAverageMood());
        model.addAttribute("bestMoodDay", moodService.getBestMoodDay().orElse(null));
        model.addAttribute("worstMoodDay", moodService.getWorstMoodDay().orElse(null));
        return "stats";
    }

    @GetMapping("/search")
    public String searchMoods(@RequestParam("keyword") String keyword, Model model) {
        List<Mood> moods = moodService.searchMoods(keyword);
        model.addAttribute("moods", moods);
        model.addAttribute("keyword", keyword);

        // If the search keyword is empty or results don't include today's date, pass a flag
        boolean showPopup = moods.isEmpty() || moods.stream().noneMatch(mood -> mood.getDate().equals(LocalDate.now()));
        model.addAttribute("showPopup", showPopup);

        return "mood"; // Returns the search results
    }}

