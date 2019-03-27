package com.socialnetwork.postModule.PostModule.Seed;

import com.socialnetwork.postModule.PostModule.Repositories.CommentLikesRepository;
import com.socialnetwork.postModule.PostModule.Repositories.CommentRepository;
import com.socialnetwork.postModule.PostModule.Repositories.LikeRepository;
import com.socialnetwork.postModule.PostModule.Repositories.PostRepository;
import com.socialnetwork.postModule.PostModule.Entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PostSeeder implements ApplicationRunner {

    private PostRepository postRepository;
    private LikeRepository likeRepository;
    private CommentRepository commentRepository;
    private CommentLikesRepository commentLikesRepository;

    @Autowired
    public PostSeeder(PostRepository _postRepository, LikeRepository _likeRepository, CommentRepository _commentRepository, CommentLikesRepository _commentLikesRepository) {
        this.postRepository = _postRepository;
        this.likeRepository = _likeRepository;
        this.commentRepository = _commentRepository;
        this.commentLikesRepository = _commentLikesRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = postRepository.count();

        if (count == 0) {
            postRepository.save(new Post(1, "Rajaa pada snijeg vanii!!"));
            postRepository.save(new Post(2, "SAMO SDA SDA"));

            for (Post post : postRepository.findAll()) {
                likeRepository.save(new PostLike(1, post));

                commentRepository.save(new Comment("Predobar ti je post", post));
            }

            for (Comment comment : commentRepository.findAll()) {
                commentLikesRepository.save(new CommentLikes(1, comment));
            }
        }
    }
}