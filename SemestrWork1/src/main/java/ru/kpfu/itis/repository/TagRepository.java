package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Tag;

/**
 * Created by Vlad.M on 06.09.2016.
 */
@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {
    Tag findByName(String name);
}
