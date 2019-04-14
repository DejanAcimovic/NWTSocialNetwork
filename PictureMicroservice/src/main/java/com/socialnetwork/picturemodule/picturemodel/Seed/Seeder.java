package com.socialnetwork.picturemodule.picturemodel.Seed;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.net.URL;

import javax.imageio.ImageIO;

import com.socialnetwork.picturemodule.picturemodel.Entities.Picture;
import com.socialnetwork.picturemodule.picturemodel.Entities.ProfilePicture;
import com.socialnetwork.picturemodule.picturemodel.Repositories.PictureRepository;


import com.socialnetwork.picturemodule.picturemodel.Repositories.ProfilePictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements ApplicationRunner {

    private PictureRepository repository;
    private ProfilePictureRepository profilePictureRepository;

    @Autowired
    public Seeder(PictureRepository _repository, ProfilePictureRepository profilePictureRepository1) {
        this.profilePictureRepository = profilePictureRepository1;
        this.repository = _repository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = repository.count();

        if(count == 0) {
            String url = "https://videnskab.dk/sites/default/files/styles/columns_12_12_desktop/public/article_media/hus_1.jpg?itok=1xFNM2ZL&timestamp=1464219173";
            /*BufferedImage bufferedImage = ImageIO.read(url);

            // get DataBufferBytes from Raster
            WritableRaster raster = bufferedImage .getRaster();
            DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
*/
            repository.save(new Picture(url,2));
            profilePictureRepository.save(new ProfilePicture(url,1));
        }
    }
}