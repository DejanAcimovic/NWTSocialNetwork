package com.socialnetwork.pictureModule.PictureModule.Seed;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.net.URL;

import javax.imageio.ImageIO;

import com.socialnetwork.pictureModule.PictureModule.Entities.Picture;
import com.socialnetwork.pictureModule.PictureModule.Repositories.PictureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Seeder implements ApplicationRunner {

    private PictureRepository repository;

    @Autowired
    public Seeder(PictureRepository _repository) {
        this.repository = _repository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = repository.count();
        
        if(count == 0) {
            URL url = new URL("https://videnskab.dk/sites/default/files/styles/columns_12_12_desktop/public/article_media/hus_1.jpg?itok=1xFNM2ZL&timestamp=1464219173");
            BufferedImage bufferedImage = ImageIO.read(url);

            // get DataBufferBytes from Raster
            WritableRaster raster = bufferedImage .getRaster();
            DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

            repository.save(new Picture(data.getData()));
        }
    }
}