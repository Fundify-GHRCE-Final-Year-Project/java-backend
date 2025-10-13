package com.fundify.fundify.project.repository;

import com.fundify.fundify.common.enums.Category;
import com.fundify.fundify.project.model.Project;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Repository
public class ProjectRepository {
    private List<Project> projects = new ArrayList<>();
    private List<String> members = Arrays.asList(
            "Arav Bhivgade",
            "Kartik Turak",
            "Piyush Churhe",
            "Pavan Rathod"
    );

    public List<Project> getAllProjects() {
        return projects;
    }

    public Stream<Project> getProjectByID(String id) {
        return projects.stream().filter((project -> Objects.equals(project.id(), id)));
    }

    @PostConstruct
    private void init() {
        projects.add(new Project(
                "1",
                "AI Education Platform",
                "A platform to teach AI using interactive lessons.",
                members,
                Category.Education,
                "arav.eth",
                1,
                100000,
                5,
                25000,
                5000,
                134387,
                Instant.now(),
                Instant.now()
        ));

        projects.add(new Project(
                "2",
                "Green Energy Fund",
                "Funding renewable energy startups to fight climate change.",
                members,
                Category.Environment,
                "kartik.eth",
                2,
                500000,
                10,
                100000,
                20000,
                134387,
                Instant.now(),
                Instant.now()
        ));

        projects.add(new Project(
                "3",
                "DeFi Microloan System",
                "Blockchain-based platform for microloans in developing countries.",
                members,
                Category.Finance,
                "pavan.eth",
                3,
                200000,
                8,
                150000,
                120000,
                134387,
                Instant.now(),
                Instant.now()
        ));
    }
}
