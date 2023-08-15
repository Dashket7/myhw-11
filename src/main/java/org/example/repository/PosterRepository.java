package org.example.repository;

import org.example.domain.CreatingPoster;

public class PosterRepository {
    private CreatingPoster[] posters = new CreatingPoster[0];
    private int limit;

    public PosterRepository() {
this.limit=5;
    }

    public PosterRepository(int limit) {
        this.limit = limit;
    }

    public void save(CreatingPoster poster) {
        CreatingPoster[] tmp = new CreatingPoster[posters.length + 1];
        for (int i = 0; i < posters.length; i++) {
            tmp[i] = posters[i];
        }
        tmp[tmp.length - 1] = poster;
        posters = tmp;
    }

    public CreatingPoster[] findAll() {
        return posters;
    }

    public CreatingPoster[] findLast() {
        int resultLength;
        if (posters.length < limit) {
            resultLength = posters.length;
        } else {
            resultLength = limit;
        }

        CreatingPoster[] tmp = new CreatingPoster[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = posters[posters.length - 1 - i];
        }
        return tmp;
    }
}
