package app.components;

import app.entities.Event;
import app.entities.Organization;
import app.entities.Tag;
import app.entities.User;
import app.repositories.EventRepository;
import app.repositories.OrganizationRepository;
import app.repositories.TagRepository;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DatabaseInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private TagRepository tagRepository;

    @PostConstruct
    @Transactional
    public void init() {
        // Initialize tags if not already present
        if (tagRepository.count() == 0) {
            Tag leadershipTag = new Tag("Leadership");
            Tag socialTag = new Tag("Social");
            Tag innovationTag = new Tag("Innovation");
            Tag technologyTag = new Tag("Technology");
            Tag communityTag = new Tag("Community");

            tagRepository.save(leadershipTag);
            tagRepository.save(socialTag);
            tagRepository.save(innovationTag);
            tagRepository.save(technologyTag);
            tagRepository.save(communityTag);

            logger.info("Tags initialized.");
        }

        // Initialize organizations if not already present
        if (organizationRepository.count() == 0) {
            Organization org1 = new Organization(
                "Ateneo Gabay",
                "0917-987-6543",
                "ateneogabay@gmail.com",
                "A student organization focused on empowering marginalized communities through education and community service."
            );

            Organization org2 = new Organization(
                "Ateneo Management Information Systems Association (MISA)",
                "0917-555-1234",
                "ateneomisa@gmail.com",
                "An organization that promotes the integration of business and technology among Ateneo students through various events, talks, and projects."
            );

            Organization org3 = new Organization(
                "Ateneo Catechetical Instruction League (ACIL)",
                "0917-654-3210",
                "acil.ateneo@gmail.com",
                "ACIL has been making Christ a living reality for the catechists and the people they interact with by providing opportunities to share the Word of God with not just peers, but with the marginalized as well, especially the youth."
            );

            Organization org4 = new Organization(
                "Ateneo Electronics and Computer Engineering Society (ECES)",
                "0917-567-8901",
                "eces@ateneo.edu",
                "The sole and premier engineering organization at Ateneo, fosters personal and professional growth. We advocate for integrating engineering skills to innovate and solve societal issues."
            );

            Organization org5 = new Organization(
                "Baybayin Ateneo",
                "0917-678-9012",
                "baybayinateneo@gmail.com",
                "Baybayin is the premier Filipino cultural organization of the Ateneo that leads the lively discourse and immersion on Filipino heritage, cultivating a culturally sensitive public that is respectful of the many facets of Filipino life and culture."
            );

            Organization org6 = new Organization(
                "Computer Society of the Ateneo (CompSAt)",
                "0917-789-0123",
                "compsat@ateneo.edu",
                "CompSAt is the premier IT organization of the Ateneo, driven to improve the quality of lives through a shared passion for Information Technology. CompSAt envisions itself as a community driven by the common belief that anyone can code."
            );

            Organization org7 = new Organization(
                "Development Society of the Ateneo (DevSoc)",
                "0917-890-1234",
                "devsoc@ateneo.edu",
                "DevSoc is a home for development-minded students; dreamers for a better future, and doers to make it a reality. DevSoc is an inviting home for those looking to build an advocacy and further grow as individuals."
            );

            Organization org8 = new Organization(
                "Ateneans Guided and Inspired by their Love for Animals (AGILA)",
                "0917-901-2345",
                "agila@ateneo.edu",
                "AGILA is a student-led animal welfare organization based in Ateneo. It serves the Ateneo community through its animal management and humane education like the TNVR and Cat Census."
            );

            Organization org9 = new Organization(
                "Blue Independent Komiks (BLINK)",
                "0917-012-3456",
                "blink@ateneo.edu",
                "Blue Independent Komiks, or BLINK, is an organization for comic makers, enthusiasts, and anyone with an interest in a medium where words and pictures come to create meaning and move hearts."
            );

            Organization org10 = new Organization(
                "Cuisina",
                "0917-123-4567",
                "cuisina@ateneo.edu",
                "CUISINA is the home for Ateneans who love and are passionate about the gastronomic scene, striving to create a deeper understanding and appreciation for the art and foster an empowering culture for food and drink enthusiasts in all aspects."
            );

            Organization org11 = new Organization(
                "Effective Altruism Blue (EA Blue)",
                "0917-234-5678",
                "eablue@ateneo.edu",
                "Effective Altruism Blue (EA Blue) is a university chapter for Ateneans interested in effective altruism—a philosophy and social movement that uses evidence and reason to figure out how to maximize our positive impact with limited time and resources."
            );

            Organization org12 = new Organization(
                "Spaces for Women's Art and Narratives (SWAN)",
                "0917-345-6789",
                "swan@ateneo.edu",
                "As the premier feminist fine arts organization, SWAN aims to foster safe spaces for creating and appreciating feminist expression in the fine arts, with the intention of co-empowering with women and feminists within and outside of the Loyola Schools."
            );

            // Save organizations
            organizationRepository.save(org1);
            organizationRepository.save(org2);
            organizationRepository.save(org3);
            organizationRepository.save(org4);
            organizationRepository.save(org5);
            organizationRepository.save(org6);
            organizationRepository.save(org7);
            organizationRepository.save(org8);
            organizationRepository.save(org9);
            organizationRepository.save(org10);
            organizationRepository.save(org11);
            organizationRepository.save(org12);

            logger.info("Sample organizations initialized.");
        }

        // Initialize users if not already present
        if (userRepository.count() == 0) {
            User user1 = new User(
                "nellbert.pineda@student.ateneo.edu",
                "Nellbert",
                "Pineda",
                "0917-555-1234",
                "ethan123"
            );
            User user2 = new User(
                "maristel.lluch@student.ateneo.edu",
                "Maristel",
                "Lluch",
                "0917-555-5678",
                "maris234"
            );

            userRepository.save(user1);
            userRepository.save(user2);
            logger.info("Sample users initialized.");
        }

        // Initialize events if not already present
        if (eventRepository.count() == 0) {
            Organization org1 = organizationRepository.findById(1L).orElse(null);
            Organization org2 = organizationRepository.findById(2L).orElse(null);

            // Retrieve tags
            Optional<Tag> leadershipTag = tagRepository.findByName("Leadership");
            Optional<Tag> socialTag = tagRepository.findByName("Social");
            Optional<Tag> innovationTag = tagRepository.findByName("Innovation");
            Optional<Tag> technologyTag = tagRepository.findByName("Technology");
            Optional<Tag> communityTag = tagRepository.findByName("Community");

            if (org1 != null && org2 != null && leadershipTag != null && socialTag != null && innovationTag != null && technologyTag != null && communityTag != null) {
                Event event1 = new Event(
                    "Silent Night: Gabay Christmas Party 2024🕸️",
                    "Celebrate the season of giving with the Ateneo Gabay Christmas Party...",
                    LocalDate.parse("2024-12-09"),
                    LocalTime.parse("16:00"),
                    "CTC 105",
                    org1
                );

                Event event2 = new Event(
                    "Hexceed 2024: Serving with purpose for the future",
                    "Join us for Hexceed 2024...",
                    LocalDate.parse("2024-11-20"),
                    LocalTime.parse("17:00"),
                    "CTC 102",
                    org2
                );

                // Associate events with tags using ifPresent to handle Optional
                leadershipTag.ifPresent(event1.getTags()::add);
                socialTag.ifPresent(event1.getTags()::add);
                innovationTag.ifPresent(event1.getTags()::add);

                technologyTag.ifPresent(event2.getTags()::add);
                communityTag.ifPresent(event2.getTags()::add);

                // Save events after tags have been added
                eventRepository.save(event1);
                eventRepository.save(event2);

                logger.info("Sample events initialized with tags.");
            } else {
                logger.warn("Could not find organizations or tags for event creation.");
            }
        }
    }
}