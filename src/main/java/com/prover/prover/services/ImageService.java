package com.prover.prover.services;

import com.prover.prover.models.Images;
import com.prover.prover.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 23.05.2017.
 */
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Images saveImage(String filepath){
        Images images = new Images();
        images.setFilePath(filepath);
        imageRepository.save(images);
        return images;
    }
}
