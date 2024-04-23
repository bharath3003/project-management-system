package com.JavaProject.service;

import com.JavaProject.dto.ProjectDto;
import com.JavaProject.entity.Project;
import com.JavaProject.entity.Project.DomainName;
import com.JavaProject.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectDto> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<ProjectDto> getProjectById(int id) {
        return projectRepository.findById(id)
                .map(this::convertToDto);
    }

    public ProjectDto saveProject(ProjectDto projectDto) {
        Project project = convertToEntity(projectDto);
        Project savedProject = projectRepository.save(project);
        return convertToDto(savedProject);
    }

    public void deleteProjectById(int id) {
        projectRepository.deleteById(id);
    }

    public List<ProjectDto> getProjectsByDomain(DomainName domain) {
        return projectRepository.findByDomain(domain).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ProjectDto convertToDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setProjectName(project.getProjectName());
        projectDto.setDomain(project.getDomain());
        projectDto.setDifficultyLevel(project.getDifficultyLevel());
        projectDto.setDomainName(project.getDomainName());
        return projectDto;
    }

    private Project convertToEntity(ProjectDto projectDto) {
        Project project = new Project();
        project.setId(projectDto.getId());
        project.setProjectName(projectDto.getProjectName());
        project.setDomain(projectDto.getDomain());
        project.setDifficultyLevel(projectDto.getDifficultyLevel());
        project.setDomainName(projectDto.getDomainName());
        return project;
    }
}