package app.components;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.entities.Tag;
import app.repositories.TagRepository;

@Component
public class TagInitializer {

    @Autowired
    private TagRepository tagRepository;

    @PostConstruct
    public void init() {
        if (tagRepository.count() == 0) {
            Tag tag1 = new Tag("Leadership");
            Tag tag2 = new Tag("Social");
            Tag tag3 = new Tag("Innovation");
            Tag tag4 = new Tag("Technology");
            Tag tag5 = new Tag("Community");

            tagRepository.save(tag1);
            tagRepository.save(tag2);
            tagRepository.save(tag3);
            tagRepository.save(tag4);
            tagRepository.save(tag5);

            System.out.println("Sample Tags have been initialized.");
        } else {
            List<Tag> tags = tagRepository.findAll();
            System.out.println("Tags already exist: " + tags);
        }
    }
}
