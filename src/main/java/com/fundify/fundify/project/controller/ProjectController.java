package com.fundify.fundify.project.controller;

import com.fundify.fundify.project.model.Project;
import com.fundify.fundify.project.repository.ProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/")
    List<Project> get() {
        return projectRepository.get();
    }

    @GetMapping("/{id}")
    Optional<Project> find(
            @PathVariable String id
    ) {
        Optional<Project> project = projectRepository.find(id);
        if (project.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return project;
    }

    @GetMapping("/{owner}/{index}")
    String find(
            @PathVariable String owner,
            @PathVariable int index
    ) {
        return "Hello Project!";
    }

    @GetMapping("/filter/{status}/{limit}")
    String filter(
            @PathVariable String status,
            @PathVariable int limit
    ) {
        return "Hello Project!";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    void create(
            @RequestBody Project project
    ) {
        projectRepository.create(project);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(
            @PathVariable String id,
            @RequestBody Project project
    ) {
        projectRepository.update(project, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(
            @PathVariable String id
    ) {
        projectRepository.delete(id);
    }
}
