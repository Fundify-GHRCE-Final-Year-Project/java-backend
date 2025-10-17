package com.fundify.fundify.project.repository;

import com.fundify.fundify.common.enums.Category;
import com.fundify.fundify.common.enums.ProjectStatus;
import com.fundify.fundify.project.model.Project;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProjectRepository {
    private final List<Project> projects = new ArrayList<>();
    private final List<String> members = Arrays.asList(
            "Arav Bhivgade",
            "Kartik Turak",
            "Piyush Churhe",
            "Pavan Rathod"
    );

    public List<Project> get() {
        return projects;
    }

    public List<Project> get(String owner) {
        return projects.stream().filter((project -> Objects.equals(project.owner(), owner))).toList();
    }

    public Optional<Project> find(String owner, int index) {
        return projects.stream().filter((project -> project.owner().equals(owner) && project.index() == index)).findFirst();
    }

    public List<Project> filter(ProjectStatus status, int limit) {
        List<Project> filteredProjects = new ArrayList<>();
        switch (status) {
            case Active -> {
                filteredProjects = projects.stream().filter(project -> project.goal() - project.funded() != 0).limit(limit).toList();
                break;
            }
            case Ended -> {
                filteredProjects = projects.stream().filter(project -> project.goal() - project.funded() == 0).limit(limit).toList();
                break;
            }
            case All -> {
                filteredProjects = projects.stream().limit(limit).toList();
                break;
            }
        }
        return filteredProjects;
    }

    public void create(Project project) {
        projects.add(project);
    }

    public void update(Project project, String owner, int index) {
        Optional<Project> existingProject = find(owner, index);
        existingProject.ifPresent(value -> projects.set(projects.indexOf(value), project));
    }

    public void delete(String owner, int index) {
        projects.removeIf(project -> project.owner().equals(owner) && project.index() == index);
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
                134387
        ));

        projects.add(new Project(
                "2",
                "Green Energy Fund",
                "Funding renewable energy startups to fight climate change.",
                members,
                Category.Environment,
                "kartik.eth",
                1,
                500000,
                10,
                100000,
                20000,
                134387
        ));

        projects.add(new Project(
                "3",
                "DeFi Microloan System",
                "Blockchain-based platform for microloans in developing countries.",
                members,
                Category.Finance,
                "pavan.eth",
                1,
                200000,
                8,
                150000,
                120000,
                134387
        ));
    }
}
