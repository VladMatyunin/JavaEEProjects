package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Post;

import java.util.List;

/**
 * Created by Vlad.M on 06.09.2016.
 */
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByTagsName(String name);
}
