package com.myshop.fundamentals.services;

import com.myshop.fundamentals.entity.Release;
import com.myshop.fundamentals.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleaseServiceImpl implements ReleaseService {
    private ReleaseRepository releaseRepository;

    @Autowired
    public ReleaseServiceImpl(ReleaseRepository releaseRepository){
        this.releaseRepository = releaseRepository;
    }

    @Override
    public Iterable<Release> listReleases() {
        return this.releaseRepository.findAll();
    }
}
