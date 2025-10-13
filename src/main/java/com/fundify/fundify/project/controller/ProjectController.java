package com.fundify.fundify.project.controller;

import com.fundify.fundify.project.model.Project;
import com.fundify.fundify.project.repository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/{id}")
    Stream<Project> getProjectByID(
            @PathVariable String id
    ) {
        return projectRepository.getProjectByID(id);
    }

    @GetMapping("/{owner}/{index}")
    String getProjectByOwnerAndIndex(
            @PathVariable String owner,
            @PathVariable int index
    ) {
        return "Hello Project!";
    }

    @GetMapping("/all")
    List<Project> getAllProjects() {
        return projectRepository.getAllProjects();
    }

    @GetMapping("/investments/{id}")
    String getProjectInvestments(
            @PathVariable String id
    ) {
        return "Hello Project!";
    }

    @PostMapping("/publish/{owner}")
    String postProjectDetails(
            @PathVariable String owner
    ) {
        return "Hello Project!";
    }

    @PostMapping("/filter/{status}/{limit}")
    String getFilteredProjects(
            @PathVariable String status,
            @PathVariable int limit
    ) {
        return "Hello Project!";
    }
}
