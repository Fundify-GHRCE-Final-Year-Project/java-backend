package com.fundify.fundify.project.controller;

import com.fundify.fundify.common.enums.ProjectStatus;
import com.fundify.fundify.project.exception.ProjectNotFoundException;
import com.fundify.fundify.project.model.Project;
import com.fundify.fundify.project.repository.ProjectRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{owner}")
    List<Project> get(
            @PathVariable String owner
    ) {
        List<Project> projects = projectRepository.get(owner);
        if (projects.isEmpty()) {
            throw new ProjectNotFoundException();
        }
        return projects;
    }

    @GetMapping("/{owner}/{index}")
    Optional<Project> find(
            @PathVariable String owner,
            @PathVariable int index
    ) {
        Optional<Project> project = projectRepository.find(owner, index);
        if (project.isEmpty()) {
            throw new ProjectNotFoundException();
        }
        return project;
    }

    @GetMapping("/filter/{status}/{limit}")
    List<Project> filter(
            @PathVariable ProjectStatus status,
            @PathVariable int limit
    ) {
        List<Project> filteredProjects = projectRepository.filter(status, limit);
        if (filteredProjects.isEmpty()) {
            throw new ProjectNotFoundException();
        }
        return filteredProjects;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    void create(
            @Valid @RequestBody Project project
    ) {
        projectRepository.create(project);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{owner}/{index}")
    void update(
            @PathVariable String owner,
            @PathVariable int index,
            @Valid @RequestBody Project project
    ) {
        projectRepository.update(project, owner, index);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{owner}/{index}")
    void delete(
            @PathVariable String owner,
            @PathVariable int index
    ) {
        projectRepository.delete(owner, index);
    }
}
