package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Comment;

/**
 * Created by Vlad.M on 07.09.2016.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
