package org.example.repository;

import org.example.domain.CreatingPoster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterRepositoryTest {
    CreatingPoster poster1 = new CreatingPoster(24, "Отель", 5);
    CreatingPoster poster2 = new CreatingPoster(25, "Бландшот", 12);
    CreatingPoster poster3 = new CreatingPoster(26, "Вперёд", 6);
    CreatingPoster poster4 = new CreatingPoster(27, "Джентельмены", 13);
    CreatingPoster poster5 = new CreatingPoster(28, "Человек Невидимка", 5);
    CreatingPoster poster6 = new CreatingPoster(29, "Тролли.Мировой Тур", 19);
    CreatingPoster poster7 = new CreatingPoster(30, "Номер один", 19);

    @Test
    public void shouldGetPosters() {
        PosterRepository repo = new PosterRepository();
        repo.save(poster1);
        repo.save(poster2);
        repo.save(poster3);
        repo.save(poster4);
        repo.save(poster5);
        repo.save(poster6);
        repo.save(poster7);
        CreatingPoster[] expected = {poster1, poster2, poster3, poster4, poster5, poster6, poster7};
        CreatingPoster[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastFivePosters() {
        PosterRepository repo = new PosterRepository();
        repo.save(poster1);
        repo.save(poster2);
        repo.save(poster3);
        repo.save(poster4);
        repo.save(poster5);
        repo.save(poster6);
        repo.save(poster7);
        CreatingPoster[] expected = {poster7, poster6, poster5, poster4, poster3};
        CreatingPoster[] actual = repo.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLastThreePosters() {
        PosterRepository repo = new PosterRepository();
        repo.save(poster1);
        repo.save(poster2);
        repo.save(poster3);
        CreatingPoster[] expected = {poster3, poster2, poster1};
        CreatingPoster[] actual = repo.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetSevenPosters() {
        PosterRepository repo = new PosterRepository(7);
        repo.save(poster1);
        repo.save(poster2);
        repo.save(poster3);
        repo.save(poster4);
        repo.save(poster5);
        repo.save(poster6);
        repo.save(poster7);
        CreatingPoster[] expected = {poster7, poster6, poster5, poster4, poster3, poster2, poster1};
        CreatingPoster[] actual = repo.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}
