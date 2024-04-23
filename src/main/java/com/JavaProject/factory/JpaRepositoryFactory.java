package com.JavaProject.factory;

import com.JavaProject.repository.ProjectRepository;
import com.JavaProject.repository.RequestsRepo;
import com.JavaProject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaRepositoryFactory implements RepositoryFactory {

    private final UserRepo userRepo;
    private final ProjectRepository projectRepository;
    private final RequestsRepo requestsRepo;

    @Autowired
    public JpaRepositoryFactory(UserRepo userRepo, ProjectRepository projectRepository, RequestsRepo requestsRepo) {
        this.userRepo = userRepo;
        this.projectRepository = projectRepository;
        this.requestsRepo = requestsRepo;
    }

    @Override
    public UserRepo createUserRepo() {
        return userRepo;
    }

    @Override
    public ProjectRepository createProjectRepo() {
        return projectRepository;
    }

    @Override
    public RequestsRepo createRequestsRepo() {
        return requestsRepo;
    }
}
