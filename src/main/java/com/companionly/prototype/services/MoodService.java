package com.companionly.prototype.services;

import com.companionly.prototype.models.Mood;
import com.companionly.prototype.data.MoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoodService {

    private final MoodRepository moodRepository;

    public MoodService(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }
    
    public List<Mood> searchMoods(String keyword) {
        return moodRepository.searchMoods(keyword);
    }


    public Optional<Mood> getMoodById(Long id) {
        return moodRepository.findById(id);
    }

    public void saveMood(Mood mood) {
        moodRepository.save(mood);
    }

    public void deleteMood(Long id) {
        moodRepository.deleteById(id);
    }
    
    public double getAverageMood() {
        List<Mood> moods = moodRepository.findAll();
        return moods.stream()
                .mapToInt(Mood::getMood)
                .average()
                .orElse(0.0); // Return 0 if no moods found
    }

    public Optional<Mood> getBestMoodDay() {
        return moodRepository.findAll().stream()
                .max((m1, m2) -> Integer.compare(m1.getMood(), m2.getMood()));
    }

    public Optional<Mood> getWorstMoodDay() {
        return moodRepository.findAll().stream()
                .min((m1, m2) -> Integer.compare(m1.getMood(), m2.getMood()));
    }

    public List<Mood> getAllMoods() {
        return moodRepository.findAll();
    }
}
